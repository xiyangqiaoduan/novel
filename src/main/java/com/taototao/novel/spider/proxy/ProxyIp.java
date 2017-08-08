package com.taototao.novel.spider.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-08-08 13:37
 **/
public class ProxyIp {

    private static final Logger log = LoggerFactory.getLogger(ProxyIp.class);


//    public static void main(String[] args) throws IOException, InterruptedException {
//        while(true){
//            System.setProperty("http.maxRedirects", "50");
//            System.getProperties().setProperty("proxySet", "true");
//            // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
//            ArrayList<String> listIp=new ArrayList<String>();
//            listIp.add("183.222.102.105:80");
//            listIp.add("183.222.102.98:8080");
//            listIp.add("183.222.102.109:8080");
//            listIp.add("121.248.112.20:3128");
//            listIp.add("61.130.97.212:8099");
//            listIp.add("124.133.230.254:8080");
//            listIp.add("124.133.230.254:80");
//            listIp.add("42.232.10.249:8998");
//            Random random = new Random();
//            int randomInt = random.nextInt(listIp.size());
//            String ipport = listIp.get(randomInt);
//            String proxyIp = ipport.substring(0, ipport.lastIndexOf(":"));
//            String proxyPort = ipport.substring(ipport.lastIndexOf(":") + 1, ipport.length());
//            System.getProperties().setProperty("proxySet", "true");
//            System.getProperties().setProperty("http.proxyHost", proxyIp);
//            System.getProperties().setProperty("http.proxyPort", proxyPort);
//
//            //确定代理是否设置成功
//            log.info(getHtml("http://www.taototao.com/novel/info/articleList?category=2"));
//            Thread.sleep(5000);
//        }
//
//
//    }

    private static String getHtml(String address){
        StringBuffer html = new StringBuffer();
        String result = null;
        try{
            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");
            BufferedInputStream in = new BufferedInputStream(conn.getInputStream());

            try{
                String inputLine;
                byte[] buf = new byte[4096];
                int bytesRead = 0;
                while (bytesRead >= 0) {
                    inputLine = new String(buf, 0, bytesRead, "ISO-8859-1");
                    html.append(inputLine);
                    bytesRead = in.read(buf);
                    inputLine = null;
                }
                buf = null;
            }finally{
                in.close();
                conn = null;
                url = null;
            }
            result = new String(html.toString().trim().getBytes("ISO-8859-1"), "gb2312").toLowerCase();

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            html = null;
        }
        return result;
    }
}




