package com.hellojpa.jsonnode;

import org.json.JSONObject;
import org.json.XML;

public class XmlToJson {
    public static void main(String[] args) {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<note>\n" +
                "<to>Hoon</to>\n" +
                "<from>Jane</from>\n" +
                "<heading>Letter</heading>\n" +
                "<body>Hi~ I'm Jane</body>\n" +
                "</note>";

        JSONObject json = XML.toJSONObject(xmlStr);
        String jsonStr = json.toString(4);

        System.out.println("===================");
        System.out.println(jsonStr);



    }
}
