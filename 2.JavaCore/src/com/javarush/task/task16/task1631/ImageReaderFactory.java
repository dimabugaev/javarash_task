package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageTypes){
        ImageReader res;
        if (imageTypes == ImageTypes.BMP) res = new BmpReader();
        else if (imageTypes == ImageTypes.JPG) res = new JpgReader();
        else if (imageTypes == ImageTypes.PNG) res = new PngReader();
        else
            throw new IllegalArgumentException();

        return res;
    }
}
