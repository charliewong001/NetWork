package chapter06;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetworkInterfaceTest {

    public static NetworkInterface getByName() {
        try {
            NetworkInterface ni = NetworkInterface.getByName("lo");
            System.out.println(ni);
            return ni;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static NetworkInterface getByInetAddress() {
        try {
            InetAddress ia = InetAddress.getByName("127.0.0.1");
            System.out.println(ia);
            NetworkInterface ni = NetworkInterface.getByInetAddress(ia);
            System.out.println(ni);
            return ni;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 列出本地主机上的所有网络接口
     */
    public static void getNetworkInterfaces() {
        try {
            Enumeration<NetworkInterface> e = NetworkInterface
                    .getNetworkInterfaces();
            while (e.hasMoreElements()) {
                System.out.println(e.nextElement());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void getInetAddresses() {
        NetworkInterface ni = getByName();
        Enumeration<InetAddress> e = ni.getInetAddresses();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }

    public static String getName() {
        NetworkInterface ni = getByName();
        String name = ni.getName();
        System.out.println(name);
        return name;
    }

    public static String getDisplayName() {
        NetworkInterface ni = getByName();
        String name = ni.getDisplayName();
        System.out.println(name);
        return name;
    }

    public static void main(String[] args) {
        getDisplayName();
    }

}
