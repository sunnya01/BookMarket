package pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author sunchaowei
 * @create 2026/3/2-14:01
 */
public class Dom4jTest {

    @Test
    public void Test01() {
        // 创建一个SaxReader输入流 读取xml配置文件 生成document对象
        SAXReader saxReader = new SAXReader();

        Document document;

        try {
            document = saxReader.read("src/books.xml");
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

        System.out.println(document);

    }

    @Test
    public void Test02() throws DocumentException {
        //1 读取books xml 文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //2 通过document对象获取跟元素
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement.getName());
        //3 通过根元素获取book对象
        List<Element> bookList = rootElement.elements("book");
        //4 遍历处理每个book标签转换为Book类对象
        for (Element book : bookList) {
            //asXML() 把标签对象转换为标签字符串
//            System.out.println(book.asXML());
//            Element nameElement = book.element("name");
//            String nameText = nameElement.getText();
            String nameText = book.elementText("name");

            String priceText = book.elementText("price");

            String authorText = book.elementText("author");

            String snValue = book.attributeValue("sn");

            System.out.println(new Book(snValue, nameText, BigDecimal.valueOf(Double.parseDouble(priceText)), authorText));

        }
    }
}
