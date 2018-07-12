import com.xero.mcpews.*;
import com.xero.mcpews.command.Command;
import com.xero.mcpews.command.FillCommand;
import com.xero.mcpews.command.Position;
import com.xero.mcpews.event.PlayerMessageEvent;
import com.xero.mcpews.event.PlayerTravelledEvent;
import org.java_websocket.WebSocket;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class Main {
    static Scanner scan;

    public static void main(String[] args) {
        WSServer s = new WSServer(new InetSocketAddress(12345), new MyFactory());
        s.start();
        System.out.println("Server run on " + s.getAddress());
        scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        MCResponseReceiver<Command.StringResponse> rec = new MCResponseReceiver<Command.StringResponse>() {
            @Override
            public void onReceiveResponse(MCClient client, Command.StringResponse response) {
                System.out.println(response.getJson().toString());
            }
        };
        while (true) {
            String a = scan.next();
            s.broadcastCommand(Command.StringCommand.create(a).responseTo(rec));
        }
    }
}

class MyFactory extends MCListenerFactory {
    @Override
    public MCListener create(WebSocket conn) {
        return new MyListener();
    }
}

class MyListener implements MCListener, MCEventReceiver<PlayerMessageEvent>, MCResponseReceiver<FillCommand.Response> {
    @Override
    public void onCreate(MCClient client) {
        System.out.println("Connected!");
        client.registerReceiver(PlayerMessageEvent.TYPE, this);
        client.registerReceiver(PlayerTravelledEvent.TYPE, new MCEventReceiver<PlayerTravelledEvent>() {
            @Override
            public void onReceiveEvent(MCClient client, PlayerTravelledEvent event) {
                System.out.println("Player travelled");
            }
        });
    }

    @Override
    public void onDestroy(MCClient client) {
        System.out.println("Disconnected!");
        System.exit(0);
    }

    @Override
    public void onError(MCClient client, MCError error) {
        System.out.println("Error! " + error.getStatusMessage() + " (" + error.getStatusCode() + ")");
    }

    @Override
    public void onException(MCClient client, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onReceiveEvent(MCClient client, PlayerMessageEvent event) {
        if (!PlayerMessageEvent.MESSAGE_CHAT.equals(event.getMessageType())) return;
        System.out.println(event.getSender() + ": " + event.getMessage());
        if (event.getMessage().equals("close")) {
            client.destroy();
        } else if (event.getMessage().equals("fill")) {
            client.sendCommand(FillCommand.createDefault(
                    Position.createRelative(0, 0, 0),
                    Position.createRelative(3, 3, 3),
                    "tnt"
                    ).responseTo(this));
        }
    }

    @Override
    public void onReceiveResponse(MCClient client, FillCommand.Response response) {
        System.out.print(response.getStatusCode() + ":" + response.getStatusMessage());
    }
}
