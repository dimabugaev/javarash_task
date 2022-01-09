package com.javarush.task.task35.task3513;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Tile {
    int value;

    public Tile(int value) {
        this.value = value;
    }

    public Tile() {
        this.value = 0;
    }

    public boolean isEmpty(){
        return value == 0;
    }
    
    Color getFontColor(){
        if (this.value < 16)
            return new Color(0x776e65);
        else 
            return new Color(0xf9f6f2);
    }
    
    Color getTileColor(){
        Map<Integer, Color> colors = new HashMap<>();
        
        colors.put(0, new Color(0xcdc1b4));
        colors.put(2, new Color(0xeee4da));
        colors.put(4, new Color(0xede0c8));
        colors.put(8, new Color(0xf2b179));
        colors.put(16, new Color(0xf59563));
        colors.put(32, new Color(0xf67c5f));
        colors.put(64, new Color(0xf65e3b));
        colors.put(128, new Color(0xedcf72));
        colors.put(256, new Color(0xedcc61));
        colors.put(512, new Color(0xedc850));
        colors.put(1024, new Color(0xedc53f));
        colors.put(2048, new Color(0xedc22e));

        if (colors.containsKey(this.value))
            return colors.get(this.value);
        else
            return new Color(0xff0000);
    }
        
}
