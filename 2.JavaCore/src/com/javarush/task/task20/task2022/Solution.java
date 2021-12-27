package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public Solution(){}

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //fileName = (String) in.readObject();

        stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "/Users/dmitrybugaev/Documents/res1.txt";
        String filename1 = "/Users/dmitrybugaev/Documents/res2.txt";

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        Solution sol = new Solution(filename1);

        sol.writeObject("testing data");

        outputStream.writeObject(sol);

        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        Solution newsol = (Solution) inputStream.readObject();
        inputStream.close();

        System.out.println(newsol.fileName.equals(newsol.fileName));

    }
}
