package com.pentacle.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws Exception {
        String url = "http://jandan.net/";
        Document document = Jsoup.parse(new URL(url), 10000);
        Elements content = document.getElementById("content").getElementsByClass("post f list-post");
        int id = 0;
        for (Element elConten : content) {
            Elements img = elConten.select(".thumbs_b a img");
            //图片
            String src = img.attr("src");
            String data_original = img.attr("data-original");
            String title = elConten.select(".indexs h2 a").text();
            String s = !"".equals(src) ? src : data_original;
            String pattern = ".*https.*";
            boolean isTure = Pattern.matches(pattern, s);
            String subString = "";
            //定义输入输出流
            URL imgUrl = null;
            File file = null;
            if (isTure == false) {
                imgUrl = new URL(("http:" + s));
                file = new File("G:/GitKu/paChongStudy01/imgDownload/" + s + File.separator);
            } else {
                imgUrl = new URL(s);
                String p = "(?<=https://)(.*)(?=.jpg)";
                // 创建 Pattern 对象
                Pattern r = Pattern.compile(p);
                // 现在创建 matcher 对象
                Matcher m = r.matcher(s);
                while (m.find()) {
                    subString = s.substring(m.start(), m.end());
                }
                file  = new File("G:/GitKu/paChongStudy01/imgDownload/" + subString + File.separator);
            }
            File parentFile = file.getParentFile();
            File file1 = new File(parentFile.toString());
            if (!file1.exists()) {
                file1.mkdirs(); //生成文件夹
            }
            URLConnection con = imgUrl.openConnection();
                          con.setRequestProperty("User-agent", "Mozilla/4.0(compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = con.getInputStream();
            OutputStream outputStream = null;
            if (isTure == false) {
                outputStream = new FileOutputStream(parentFile.toString() + "/" + id + ".jpg");
            } else {
                outputStream = new FileOutputStream(parentFile.toString() + "/" + id + ".jpg");
            }
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                outputStream.write(temp);
            }
            inputStream.close();
            outputStream.close();
            id++;
            System.out.println(title + ".jpg 下载完成");
        }
    }
}
