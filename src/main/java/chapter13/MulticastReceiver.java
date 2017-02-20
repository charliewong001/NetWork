package chapter13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class MulticastReceiver {

    public static void main(String[] args) {
        try {
            MulticastSocket ms = new MulticastSocket(MulticastSender.PORT);
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            ms.joinGroup(MulticastSender.ADDRESS);
            ms.receive(dp);
            String data = new String(dp.getData(), "UTF-8");
            System.out.println("receving data : " + data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
