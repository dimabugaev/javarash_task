package com.javarush.task.task35.task3507;

import java.io.*;

public class ModuleLoader extends ClassLoader{
    private String pathToBean;

    public ModuleLoader(String partToBean, ClassLoader parent) {
        super(parent);
        this.pathToBean = partToBean;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            byte[] data = getByteClassFromFile(pathToBean+"/"+name+".class");
            return defineClass(null, data,0, data.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

    private byte[] getByteClassFromFile(String path) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (InputStream inputStream = new FileInputStream(new File(path))){
            byte[] buff = new byte[1000];
            while (inputStream.available()>0){
                int count = inputStream.read(buff);
                outputStream.write(buff,0,count);
            }
        }

        return outputStream.toByteArray();
    }
}
