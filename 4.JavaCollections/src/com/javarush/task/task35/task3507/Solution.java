package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedEncodingException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, UnsupportedEncodingException {
        Set<Animal> animalSet = new HashSet<>();

        File dir = new File(URLDecoder.decode(pathToAnimals, "UTF-8"));
        ModuleLoader loader = new ModuleLoader(dir.getAbsolutePath(), ClassLoader.getSystemClassLoader());
        for (String module: dir.list()){
            String moduleName = module.split(".class")[0];
            Class clazz = loader.loadClass(moduleName);
            if (Animal.class.isAssignableFrom(clazz)){
                try {
                    Constructor<Animal> constructor = clazz.getConstructor();
                    //Animal obj = constructor.newInstance();
                    animalSet.add(constructor.newInstance());
                } catch (NoSuchMethodException e) {
                    //e.printStackTrace();
                } catch (InvocationTargetException e) {
                    //e.printStackTrace();
                } catch (InstantiationException e) {
                    //e.printStackTrace();
                } catch (IllegalAccessException e) {
                    //e.printStackTrace();
                }
            }
        }
        return animalSet;
    }
}
