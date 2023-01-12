package solo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
int PORT = 9999;



    public static void main(String[] args) throws IOException {
        System.out.println("Chat Server is running...");

        try (ServerSocket listener = new ServerSocket(9999)) {
            while (true) {
                new Handler(listener.accept()).start();
            }
        }
    }

    public  static class Handler extends Thread {
        String name;
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
           
     List<PrintWriter> writers = new ArrayList<>();
            try {
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }

                    synchronized (writers) {
                        if (!name.isEmpty()) {
                            break;
                        }
                    }
                }

                out.println("NAMEACCEPTED");
                writers.add(out);

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}