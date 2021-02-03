package me.Pr3roxDLC;

public class ComboProxy {


    public String getProxyIP() {
        return proxyIP;
    }

    public void setProxyIP(String proxyIP) {
        this.proxyIP = proxyIP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    String proxyIP = "";
    int port = 0;

    public ComboProxy(String proxy){
        proxyIP = proxy.split(":")[0];
        port = Integer.parseInt(proxy.split(":")[1]);

    }

}
