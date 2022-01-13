package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 1) {
            //Path resultFileName = Paths.get(args[0]);

            List<String> list = new ArrayList<>();

            for (int i = 1; i < args.length; i++) {
                list.add(args[i]);
            }
            Collections.sort(list);

            List<FileInputStream> listOfStream = new ArrayList<>();

            for (String item: list){
                listOfStream.add(new FileInputStream(item));
            }

            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(listOfStream)));
            FileOutputStream out = new FileOutputStream(args[0]);


            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null){
                copyData(zipInputStream, out);
                zipEntry = zipInputStream.getNextEntry();
            }

            zipInputStream.close();
            out.close();
        }
    }

    private static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }


}
