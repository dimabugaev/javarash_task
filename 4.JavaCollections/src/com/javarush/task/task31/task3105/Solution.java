package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Content> entries = getContents(args[1]);

        FileOutputStream zipFile = new FileOutputStream(args[1]);
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //кладем в него  ZipEntry –«архивный объект»
        File file = new File(args[0]);
        zip.putNextEntry(new ZipEntry("new/" + file.getName()));

        //копируем файл «document-for-archive.txt» в архив под именем «document.txt»
        Files.copy(file.toPath(), zip);

        //копируем все остальные файлы
        for (Content content : entries) {
            if (!content.getFileName().equals("new/" + file.getName())) content.saveToZip(zip);
        }

        // закрываем архив
        zip.close();
    }

    private static List<Content> getContents(String arg) throws IOException {
        List<Content> entries = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(arg))) {
            ZipEntry currentEntry;
            byte[] buffer = new byte[1024];
            while ((currentEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int length = 0;
                while ((length = zipInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                entries.add(new Content(currentEntry.getName(), outputStream.toByteArray()));
            }
        }
        return entries;
    }

    static class Content {
        String fileName;
        byte[] body;

        Content(String fileName, byte[] body) {
            this.fileName = fileName;
            this.body = body;
        }

        public String getFileName() {
            return fileName;
        }

        void saveToZip(ZipOutputStream zip) throws IOException {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zip.putNextEntry(zipEntry);
            zip.write(body);
            zip.closeEntry();
        }
    }

//    public static void main(String[] args) throws IOException {
//        if (args.length > 1){
//            Path addToArchive = Paths.get(args[0]);
//            //Path currentZip = Paths.get(args[1]);
//
//
//            FileInputStream fileInputStream = new FileInputStream(args[1]);
//            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
//
//            Map<String, byte[]> dataBuffer = new HashMap<>();
//            ByteArrayOutputStream bufferOutStream = new ByteArrayOutputStream();
//
//            ZipEntry zipEntry = zipInputStream.getNextEntry();
//            while (zipEntry != null) {
//                //String fileName = zipEntry.getName();
//                //bufferOutStream = new ByteArrayOutputStream();
//                copyData(zipInputStream, bufferOutStream);
//
//                dataBuffer.put(zipEntry.getName(), bufferOutStream.toByteArray());
//
//                zipInputStream.closeEntry();
//                bufferOutStream.reset();
//                zipEntry = zipInputStream.getNextEntry();
//            }
//
//            zipInputStream.close();
//
//
//
//            ZipOutputStream zipOutStream = new ZipOutputStream(new FileOutputStream(args[1]));
//            InputStream fileIn = new FileInputStream(args[0]);
//
//            zipOutStream.putNextEntry(new ZipEntry("new/"+addToArchive.getFileName().toString()));
//            Files.copy(addToArchive, zipOutStream);
//            //copyData(fileIn, zipOutStream);
//            zipOutStream.closeEntry();
//            fileIn.close();
//
//            //for (Map.Entry<ZipEntry, byte[]> item: dataBuffer.entrySet()){
//
//            Iterator<Map.Entry<String, byte[]>> iterator = dataBuffer.entrySet().iterator();
//
//            while (iterator.hasNext()){
//                Map.Entry<String, byte[]> item = iterator.next();
//
//                //if (!("new/"+addToArchive.getFileName().toString()).equals(item.getKey())) {
//                if (item.getKey().endsWith(addToArchive.getFileName().toString())) continue;
//
//                    String nameEntry = item.getKey();
//                    zipOutStream.putNextEntry(new ZipEntry(nameEntry));
//                    zipOutStream.write(item.getValue());
//
//                    zipOutStream.closeEntry();
//
//            }
//
////            Iterator<Map.Entry<String, byte[]>> iterator = dataBuffer.entrySet().iterator();
////
////            while (iterator.hasNext()){
////                Map.Entry<String, byte[]> item = iterator.next();
////                zipOutStream.putNextEntry(new ZipEntry(item.getKey()));
////                zipOutStream.write(item.getValue());
////
////                zipOutStream.closeEntry();
////
////            }
//
//            zipOutStream.close();
//
//
//
//
////            try (ZipOutputStream bufOutStream = new ZipOutputStream(bufferDataStream);
////            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(currentZip.toFile()));
////            InputStream fileIn = new FileInputStream(addToArchive.toFile())){
////
////                copyZipToZip(bufOutStream, zipInputStream);
////
////                bufOutStream.putNextEntry(new ZipEntry("new/"+addToArchive.getFileName().toString()));
////                copyData(fileIn, bufOutStream);
////                bufOutStream.closeEntry();
////            }
////
////            try (ZipOutputStream bufOutStream = new ZipOutputStream(new FileOutputStream(currentZip.toFile()));
////                 ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bufferDataStream.toByteArray()));){
////
////                copyZipToZip(bufOutStream, zipInputStream);
////            }
//
//        }
//    }

    private static void copyZipToZip(ZipOutputStream bufOutStream, ZipInputStream zipInputStream) throws IOException {
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            String fileName = zipEntry.getName();

            bufOutStream.putNextEntry(new ZipEntry(fileName));
            copyData(zipInputStream, bufOutStream);

            zipInputStream.closeEntry();
            bufOutStream.closeEntry();

            zipEntry = zipInputStream.getNextEntry();
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
