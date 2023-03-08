package com.wayne.interview;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author waine
 * @date 2023-03-08 14:57
 */

public class ArrayListDemo {
    public static void main(String[] args) throws IllegalAccessException {
        // ArrayList 默认大小是10，每次扩容增加当前容量的一半
        ArrayList<String> list = new ArrayList<>(2);
        for (int i = 0; i < 50; i++) {
            list.add(i+"");
        }

        Runnable t1 = () -> {
            for (String s : list) {
                System.out.println(s);
            }
        };

        Runnable t2 = () -> {
            for (String s : list) {
                list.remove(s);
            }
        };

        new Thread(t1).start();
        new Thread(t2).start();


    }


    /**
     * 获取ArrayList的capacity
     */
    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            Field field = arrayListClass.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] objects = (Object[]) field.get(arrayList);
            return objects.length;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    }
