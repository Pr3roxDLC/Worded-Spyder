package me.Pr3roxDLC;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        List<ComboProxy> proxies = new ArrayList<>();


        proxies.add(new ComboProxy("84.17.51.238:3128"));
        proxies.add(new ComboProxy("118.175.93.94:45175"));
        proxies.add(new ComboProxy("186.4.229.47:8080"));



        for (ComboProxy comboProxy : proxies) {

            System.out.println(comboProxy.proxyIP + ":" + comboProxy.port);

            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(comboProxy.getProxyIP(), comboProxy.getPort()));

            OkHttpClient client = new OkHttpClient().setProxy(proxy);
            while (true) {

                Request request = new Request.Builder().url("https://api.mojang.com/users/profiles/minecraft/Pr3roxDLC").build();

                try {
                    Response response = client.newCall(request).execute();

                    InputStream is = response.body().byteStream();

                    String text = new BufferedReader(
                            new InputStreamReader(is, StandardCharsets.UTF_8))
                            .lines()
                            .collect(Collectors.joining("\n"));

                    System.out.println(text + " " + System.currentTimeMillis());


                    if(text.startsWith("{\"e"))break;

                } catch (IOException e) {
                    System.out.println("FAILED TO CONNECT, TRYING NEXT PROXY");
                    break;
                }


            }

        }


//        int proxyPort = 0;
//        String proxyIP = "localhost";
//        Proxy proxyTest = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("192.227.108.83", 80));
//
//        OkHttpClient client = new OkHttpClient().setProxy(proxyTest);
//
//
//        Request request = new Request.Builder().url("https://api.mojang.com/users/profiles/minecraft/Pr3roxDLC").build();
//
//        Response response = client.newCall(request).execute();
//
//        InputStream is = response.body().byteStream();
//
//        String text = new BufferedReader(
//                new InputStreamReader(is, StandardCharsets.UTF_8))
//                .lines()
//                .collect(Collectors.joining("\n"));
//
//
//        System.out.println(text);
//

    }
}
