package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UrlToIp {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("m.flight.qunar.com");
        System.out.println(inetAddress.getHostAddress());
    }
}
