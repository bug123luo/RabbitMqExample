package com.lcclovehww;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<Integer, String> tempMap = new HashMap<>();
        tempMap.put(0, "0");
        tempMap.put(1, "1");
        tempMap.put(2, "2");
        tempMap.put(3, "3");
        tempMap.put(4, "4");
        tempMap.put(5, "5");
        tempMap.put(6, "6");
        tempMap.put(7, "7");
        tempMap.put(8, "8");
        tempMap.put(9, "9");
        tempMap.put(10, "A");
        tempMap.put(11, "B");
        tempMap.put(12, "C");
        tempMap.put(13, "D");
        tempMap.put(14, "E");
        tempMap.put(15, "F");
        byte new_byte= (byte) 0xC0;
//        System.out.println( "Hello World!" );
        System.out.println(new_byte);
        System.out.println(tempMap.get(getHeight4(new_byte)));
        System.out.println(tempMap.get(getLow4(new_byte)));
    }


    public static int getHeight4(byte data){//获取高四位
        int height;
        height = ((data & 0xf0) >> 4);
        return height;
    }

    public static int getLow4(byte data){//获取低四位
        int low;
        low = (data & 0x0f);
        return low;
    }
}
