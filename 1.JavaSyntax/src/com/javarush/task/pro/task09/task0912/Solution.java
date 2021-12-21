package com.javarush.task.pro.task09.task0912;

/* 
Проверка URL-адреса
*/

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        //напишите тут ваш код

        String[] checking = {"https", "http"};

        for (int i = 0; i < checking.length; i++) {
            if (url.startsWith(checking[i] + "://")) return checking[i];
        }
        return "неизвестный";
    }

    public static String checkDomain(String url) {
        //напишите тут ваш код
        String[] checking = {"com", "net", "org", "ru"};

        for (int i = 0; i < checking.length; i++) {
            if (url.endsWith("."+checking[i])) return checking[i];
        }
        return "неизвестный";
    }
}
