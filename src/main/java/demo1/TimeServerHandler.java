package demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * cherish
 * Created by cherish on 2017/3/17/017.
 */
public class TimeServerHandler implements Runnable{

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader in;
        PrintWriter out;

        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime;
            String body;
            while (true) {
                body = in.readLine();
                if(body == null) break;
                System.out.println("Time server receive order: "+body);
                currentTime = "QUERY TIME".equals(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                out.println(currentTime);
            }
        } catch (IOException e) {
            //todo
        }
    }
}
