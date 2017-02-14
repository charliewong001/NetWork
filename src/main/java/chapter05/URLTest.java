package chapter05;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

    /**
     * 通过构造方法创建URL
     */
    public static URL construct() {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com");
            System.out.println(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            URL url1 = new URL("http", "www.cnblogs.com",
                    "/xing901022/p/4084900.html");
            System.out.println(url1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            URL url2 = new URL("http", "www.cnblogs.com", 8080,
                    "/xing901022/p/4084900.html");
            System.out.println(url2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            URL url1 = new URL("http://www.baidu.com/charlie/a.html");
            URL url2 = new URL(url1, "b.html");
            System.out.println(url2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * java.File.toURL()
     * @throws MalformedURLException 
     */
    public static URL toURL() throws MalformedURLException {
        File file = new File(
                "E:\\charlie\\workspaces\\default\\NetWork\\src\\main\\java\\chapter05\\URLTest.java");
        URI uri = file.toURI();
        URL url = uri.toURL();
        System.out.println(uri);
        System.out.println(url);
        return url;
    }

    /**
     * 通过类加载器来加载文件
     */
    public static void getSystemResource() {
        URL url = ClassLoader
                .getSystemResource("classpath:chapter05/URLTest.class");
        System.out.println(url);
    }

    public static void openStream() throws IOException {
        URL url = toURL();
        InputStream is = url.openStream();
        //        byte[] b = new byte[1024 * 3];
        //        for (int i = 0;; i = is.read(b)) {
        //            System.out.println("i = " + i);
        //            if (i == -1)
        //                break;
        //            System.out.println(new String(b, "utf-8"));
        //        }
        int i = is.read();
        while (i != -1) {
            //            char c = (char) i;
            //            System.out.print(Character.toString(c));
            System.out.write(i);
            i = is.read();
        }
    }

    public static void getContent() throws IOException {
        URL url = toURL();
        Object obj = url.getContent();
        System.out.println(obj);
    }

    public static void openConnection() throws IOException {
        URL url = construct();
        URLConnection conn = url.openConnection();
        String contentType = conn.getContentType();
        System.out.println("contentType = " + contentType);
        InputStream is = conn.getInputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            System.out.write(i);
        }
    }

    public static void main(String[] args) throws IOException {
        openConnection();
    }

}
