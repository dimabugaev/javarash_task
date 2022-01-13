package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {

        try {
            Path incomPath = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(incomPath), Files.isExecutable(incomPath),
                    Files.isDirectory(incomPath), Files.isWritable(incomPath));
        } catch (IOException e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
