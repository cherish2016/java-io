package demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * cherish
 * Created by cherish on 2017/3/17/017.
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        try {
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME");
            System.out.println("Send order 2 server succeed");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        } catch (IOException e) {
            //todo
        }
    }
}
