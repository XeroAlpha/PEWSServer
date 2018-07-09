# Websocket Server for Minecraft (Bedrock Edition)

## How to use
1. Import this project.

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

## Thanks
- [jocopa3/PEWS-API](https://github.com/jocopa3/PEWS-API)
- [LNSSPsd/MyAgent](https://github.com/LNSSPsd/MyAgent)