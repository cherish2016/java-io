package demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * cherish
 * Created by cherish on 2017/3/17/017.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port: " + port);
            Socket socket;
            TimeServerHandleExecutePool singleExecutor = new TimeServerHandleExecutePool(50,10000);
            while (true){
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }

        } catch (IOException e) {
            //todo
        }
    }
}
