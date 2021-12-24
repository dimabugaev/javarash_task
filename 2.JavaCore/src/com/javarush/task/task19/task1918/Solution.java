package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;

/* 
Знакомство с тегами
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        if (args.length > 0) {

            try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(console.readLine()));) {

                StringBuilder stringBuilder = new StringBuilder();

                while (reader.ready()) {
                    stringBuilder.append(reader.readLine());
                }

                Document doc = Jsoup.parse(stringBuilder.toString(),"", Parser.xmlParser());
                Elements elem = doc.select(args[0]);
                for (Element element : elem){
                    System.out.println(element);
                }
            }
        }
    }

//    public static String getTegInfo(FileReader reader, String tag, boolean first, int n) throws IOException {
//        String res = "";
//        res = res + tag;
//
//
//        String findTag = "";
//        boolean writingTag = false;
//        boolean closeTag = false;
//        while (reader.ready())
//        {
//            int i = reader.read();
//            if (i == '<'){
//                writingTag = true;
//                findTag = Character.toString((char) i);
//                continue;
//            }
//            if(writingTag){
//                if (i == '/') {
//                    findTag = findTag + Character.toString((char) i);
//                    closeTag = true;
//                    continue;
//                }
//                if (i == ' ' || i == '>' || i == '\r' || i == '\n') {
//                    findTag = findTag + Character.toString((char) i);
//                    if (findTag.replaceAll("[^[\\w]]","").equals(tag.replaceAll("[^[\\w]]",""))) { //наш тэг
//                        if (first) res = "";
//
//                        if (!closeTag) {
//
//                            number++;
//                            res = res + getTegInfo(reader, findTag, false, number);
//                        }
//                        else {
//                            //Solution.list.add(0, (res + findTag).replaceAll("\r|\n",""));
//                            //Solution.list.add((res + findTag).replaceAll("\r|\n",""));
//                            Solution.list.put(n,(res + findTag).replaceAll("\r|\n",""));
//                            return res + findTag;
//                        }
//                    }else{
//                        writingTag = false;
//                        res = res + findTag;
//                        findTag = "";
//                        continue;
//                    }
//                }
//                findTag = findTag + Character.toString((char) i);
//                continue;
//            }
//
//            res = res + Character.toString((char) i);
//        }
//        if (!first) {
//            //Solution.list.add(0, res.replaceAll("\r|\n",""));
//            //Solution.list.add(res.replaceAll("\r|\n", ""));
//            Solution.list.put(n,(res + findTag).replaceAll("\r|\n",""));
//        }
//        return res;
//    }
}
