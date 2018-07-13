# Websocket Server for Minecraft (Bedrock Edition)

## How to use
1. Import `PEWSServer-lite.jar` (You can download it in the Release page.).

2. Define you listener factory, this factory creates a listener for every WebSocket connection.
```java
class MyFactory extends MCListenerFactory {
    @Override
    public MCListener create(WebSocket conn) {
        return new MyListener();
    }
}

class MyListener implements MCListener {
    @Override
    public void onCreate(MCClient client) {
        //when finishing connecting
    }

    @Override
    public void onDestroy(MCClient client) {
        //when disconnecting
    }

    @Override
    public void onError(MCClient client, MCError error) {
        //when some error occurs in Minecraft Client
    }
}
```

3. Create a WebSocket server:
```java
WSServer server = new WSServer(new InetSocketAddress(19131), new MyFactory());
```

4. Run your server:
```java
server.start();
```

5. Now you can connect to this server by using command '/connect your_ip:port' on your client.


## How to listen to custom Event

1. Extend `com.xero.mcpews.event.Event`.

2. Add a public static field to store the `EventType` of this custom `Event` like this
and override method `getType()`, making it return the `EventType` field before.
```java 
public static final EventType TYPE = EventType.registerEventType("CustomEvent", CustomEvent.class);

@Override
public EventType getType() {
    return TYPE;
}
```

3. If you do not want to use Gson to serialize this type of event, you should add a public static
method with the following name and signature:
```java
public static CustomEvent fromJson(JsonElement json, Gson gson) {...}
```
otherwise, WSServer will use {@code gson.fromJson} to serialize it when receiving event with the specific name.

4. Finally, you can use `registerReceiver(CustomEvent.TYPE, myReceiver)` to subscribe the custom event.


## Thanks
- [jocopa3/PEWS-API](https://github.com/jocopa3/PEWS-API)
- [LNSSPsd/MyAgent](https://github.com/LNSSPsd/MyAgent)