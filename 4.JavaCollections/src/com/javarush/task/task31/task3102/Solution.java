package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> fileQueue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        File rootfile = new File(root);
        if (rootfile.isDirectory()){
            fileQueue.offer(rootfile);
            while (fileQueue.size() > 0){
                File dir = fileQueue.poll();
                for(File file : dir.listFiles()){
                    if (file.isDirectory())
                        fileQueue.offer(file);
                    else if (file.isFile())
                        result.add(file.getAbsolutePath());
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
