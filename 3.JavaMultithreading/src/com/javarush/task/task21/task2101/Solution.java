package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] res = new byte[ip.length];

        for (int i = 0; i < ip.length; i++) {
            res[i] = (byte) (ip[i] & mask[i]);
        }

        return res;
    }

    public static String getBinary(byte n){
        String res = "";
        int dec = 0;
        if (n<0)
            dec = (int) n + 256;
        else
            dec = n;

        while (dec > 0){
            res = dec % 2 + res;
            dec = dec/2;
        }


        return "00000000".substring(res.length()) + res;

    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(getBinary(bytes[i]) + " ");
        }
        System.out.println();
    }
}
