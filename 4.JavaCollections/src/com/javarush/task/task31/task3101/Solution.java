package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length > 1){
            File rootDir = new File(args[0]);
            File destinationFile1 = new File(args[1]);
            File destinationFile = new File(destinationFile1.getParent() + "/allFilesContent.txt");

            FileUtils.renameFile(destinationFile1, destinationFile);

            //File destinationFile = new File(sourceFile.getParentFile() + "/allFilesContent.txt");

            //if (FileUtils.isExist(rootDir)) {

                    OutputStream fileOut = new FileOutputStream(destinationFile);
                    List<File> resultFiles = getFileTree(rootDir);
                    resultFiles.sort(Comparator.comparing(File::getName));
                    byte[] buff = new byte[1000];
                    for (File resFile: resultFiles){
                        try(InputStream fileIn = new FileInputStream(resFile);) {
                            int count = fileIn.read(buff);
                            fileOut.write(buff, 0, count);
                        }
                        fileOut.write('\n');
                    }
                    fileOut.close();
           // }
        }
    }

    public static List<File> getFileTree(File rootfile) throws IOException {
        Queue<File> fileQueue = new LinkedList<>();
        List<File> result = new ArrayList<>();

        if (rootfile.isDirectory()){
            fileQueue.offer(rootfile);
            while (fileQueue.size() > 0){
                File dir = fileQueue.poll();
                for(File file : dir.listFiles()){
                    if (file.isDirectory())
                        fileQueue.offer(file);
                    else if (file.isFile() && file.length() <=50)
                        result.add(file);
                }
            }
        }

        return result;

    }
}
