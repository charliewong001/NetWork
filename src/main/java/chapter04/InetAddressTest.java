package chapter04;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

    public static void getByName()
            throws UnknownHostException, UnsupportedEncodingException {
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);

        //传入点分四段地址,不会检查DNS,而是直接创建一个InetAddress对象
        //可能会为实际上不存在也无法连接的主机创建InetAddress对象
        InetAddress address2 = InetAddress.getByName("220.181.112.244");//返回的就是传入的点分四段地址
        System.out.println(address2);
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
        System.out.println(address.getCanonicalHostName());

    }

    public static InetAddress getBaiduByName() {
        try {
            return InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getHostName() {
        InetAddress ia = getBaiduByName();
        String hostName = ia.getHostName();
        System.out.println(hostName);
    }

    public static void getAllByName() throws UnknownHostException {
        InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress address : addresses) {
            System.out.println(address);
        }
    }

    public static void getLocalHost() throws UnknownHostException {
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println(ia);
    }

    /**
     * 不与DNS交互,可以为不存在或者无法解析的主机创建地址
     * @throws UnknownHostException
     */
    public static void getByAddress() throws UnknownHostException {
        byte[] address = { (byte) 220, (byte) 181, 112, (byte) 244 };
        InetAddress ia = InetAddress.getByAddress(address);
        System.out.println(ia);
    }

    /**
     * 不与DNS交互,可以为不存在或者无法解析的主机创建地址
     * @throws UnknownHostException
     */
    public static void getByAddressWithName() throws UnknownHostException {
        byte[] address = { (byte) 220, (byte) 181, 112, (byte) 244 };
        InetAddress ia = InetAddress.getByAddress("www.baidu.com", address);
        System.out.println(ia);
    }

    public static void main(String[] args) throws Exception {
        getByName();
    }
}
