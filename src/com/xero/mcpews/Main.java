package com.xero.mcpews;

import com.xero.mcpews.command.Command;
import com.xero.mcpews.command.SayCommand;
import com.xero.mcpews.event.PlayerMessageEvent;
import com.xero.mcpews.event.PlayerTravelledEvent;
import com.xero.mcpews.event.ScreenChangedEvent;
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
            public void onReceiveResponse(Command.StringResponse response) {
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

class MyListener implements MCListener, MCEventReceiver<PlayerMessageEvent>, MCResponseReceiver<SayCommand.Response> {
    @Override
    public void onCreate(MCClient client) {
        System.out.println("Connected!");
        client.registerReceiver(PlayerMessageEvent.TYPE, this);
        client.registerReceiver(ScreenChangedEvent.TYPE, new MCEventReceiver<ScreenChangedEvent>() {
            @Override
            public void onReceiveEvent(MCClient client, ScreenChangedEvent event) {
                System.out.println("ScreenChangedEvent!");
            }
        });
        client.registerReceiver(PlayerTravelledEvent.TYPE, null);
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
    public void onReceiveEvent(MCClient client, PlayerMessageEvent event) {
        if (!PlayerMessageEvent.MESSAGE_CHAT.equals(event.getMessageType())) return;
        System.out.println(event.getSender() + ": " + event.getMessage());
        client.sendCommand(SayCommand.create("I heard: " + event.getMessage()).responseTo(this));
        if (event.getMessage().equals("close")) {
            client.destroy();
        } else if (event.getMessage().equals("r")) {
            client.unregisterReceiver(event.getType());
        }
    }

    @Override
    public void onReceiveResponse(SayCommand.Response response) {
        System.out.println("Send command success: " + response.getMessage());
    }
}
