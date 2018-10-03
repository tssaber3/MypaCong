package dao;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import entity.Picture;
import util.JDBC;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//通过网页的输入爬取图片并保存到数据库中
public class saveData {
    private static final String IMGSRC_REG = "https://wc-ahba9see.c.sakurastorage.jp/(\\w+)/(\\w+-)";//提取src的正则表达式
    public static void main(String[] args) throws Exception {
        String name = "";
        System.out.println("请输入分组的名字");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        String picture = "";
        HtmlElement sumbit = null;
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = webClient.getPage("https://worldcosplay.net/photo/6680447");
        while(true) {
            DomNodeList<DomElement> list = page.getElementsByTagName("img");//获取图片的src
            for (DomElement d : list) {
                if (d.getAttribute("class").equals("img")) {
                    picture = d.asXml();
                    getSrc(picture,name);
                }
            }
            DomNodeList<DomElement> alist = page.getElementsByTagName("a");//找到网页下一页的按钮
            for (DomElement d : alist) {
                if (d.getAttribute("class").equals("keep-photo-context")) {
                    sumbit = (HtmlElement) d;
                }
            }
            page = sumbit.click();//返回下一个网页
        }
    }
    public static void getSrc(String src ,String name) throws Exception {
        Picture picture = new Picture();
        pictureDao dao = new pictureDao();
        Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(src);
        String url = "";
        while(matcher.find())
        {
            url = matcher.group();
            url += "3000.jpg";
            System.out.println(url);
        }

        picture.setSrc(url);
        picture.setName(name);
        dao.addpicture(picture);
    }
}
//https://wc-ahba9see.c.sakurastorage.jp/211498/jxfeqajdlwmhvxczseqdjmeysltjbypvwmqnzuvj-3000.jpg
//https://wc-ahba9see.c.sakurastorage.jp/211498/jxfeqajdlwmhvxczseqdjmeysltjbypvwmqnzuvj-740.jpg
//https://wc-ahba9see.c.sakurastorage.jp/(\w+)/(\w+-)
//https://wc-ahba9see.c.sakurastorage.jp/21344/tkfjygrosmnyafftznrawnytrdivdzvkvaebcail-350x600.jpg