package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] contentArr = Files.readAllBytes(file); // размер файла: content.length
        String content = new String(contentArr);

        boolean correctFile = true;

        if (partOfContent != null && !content.contains(partOfContent))
            correctFile = false;

        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            correctFile = false;

        if (minSize > 0 && contentArr.length < minSize)
            correctFile = false;

        if (maxSize >0 && contentArr.length > maxSize)
            correctFile = false;

        if (correctFile)
            foundFiles.add(file);

        //return super.visitFile(file, attrs);
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
