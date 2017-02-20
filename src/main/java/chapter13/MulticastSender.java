package chapter13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.concurrent.Semaphore;

public class MulticastSender {

    public static InetAddress ADDRESS;
    public static int PORT = 1234;

    static {
        try {
            ADDRESS = InetAddress.getByName("224.1.2.3");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(PORT);
            ms.setTimeToLive(1);
            byte[] data = "some data".getBytes("UTF-8");
            DatagramPacket dp = new DatagramPacket(data, data.length, ADDRESS,
                    PORT);
            ms.send(dp);
            Semaphore sp = new Semaphore(0);
            sp.acquire();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (ms != null) {
                ms.close();
            }
        }

    }

}
