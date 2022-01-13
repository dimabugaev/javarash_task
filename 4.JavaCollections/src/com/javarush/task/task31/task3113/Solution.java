package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    static int countFiles = 0;
    static int countDir = 0;
    static long sumSizeFiles = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Path startPath = Paths.get(bufferedReader.readLine());
        if (!Files.isDirectory(startPath)){
            System.out.format("%s - не папка\n", startPath);
            return;
        }


        Files.walkFileTree(startPath, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                countDir ++;
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                countFiles ++;
                sumSizeFiles += attrs.size();
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.SKIP_SUBTREE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });

        System.out.format("Всего папок - %d\n", countDir-1);
        System.out.format("Всего файлов - %d\n", countFiles);
        System.out.format("Общий размер - %d\n", sumSizeFiles);

    }
}
