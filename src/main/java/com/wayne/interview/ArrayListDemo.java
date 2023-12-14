package com.wayne.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * list删除元素的方法
 * @author waine
 * @date 2023-03-08 14:57
 */

public class ArrayListDemo {
    private static final Logger logger = LoggerFactory.getLogger(ArrayListDemo.class);

    public static void main(String[] args){
        delete();
    }

    public static void delete() {
        // 使用循环的方式正序遍历删除元素，如果出现连续重复的元素，会漏掉要删除元素
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("bb");
        list.add("ccc");
        list.add("ccc");
        list.add("ccc");
        correctDelete(list);
        for (String s : list) {
            logger.info("element[{}]", s);
        }

    }

    /**
     * 错误的删除方法，此删除方法会把后面的元素全部前移，导致漏删除
     */
    public static void incorrectRemove1(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if ("bb".equals(list.get(i))) {
                // 此删除方法会把后面的元素全部前移，导致漏删除
                list.remove(list.get(i));
                // 因为当前元素被删除之后，后面的元素会顶上来，
                // 必须重新判断当前位置是不是重复的元素才可以保证不漏删
                i = i - 1;
            }
        }
    }

    /**
     * 增强for循环编译的时候会被替换成迭代器，迭代器在执行next方法时会比对实际修改次数和预期修改次数是否一致
     */
    public static void incorrectRemove2(ArrayList<String> list) {
        for (String s : list) {
            if ("bb".equals(s)) {
                // 而list的删除方法会把改变修改次数，此时迭代器实际上并没有修改list，所以实际修改次数和迭代器的预期修改次数不一致
                list.remove(s);
            }
        }
    }

    public static void correctDelete(List<String> list){
        list.removeIf("bb"::equals);
    }


    /**
     * list扩容后的capacity会变成原来的1.5倍
     */
    public static void grow() {
        // ArrayList 默认大小是10，每次扩容增加当前容量的一半
        ArrayList<String> list = new ArrayList<>(2);
        for (int i = 0; i < 50; i++) {
            list.add(i + "");
            // 每次增加元素以后输出list当前的capacity
            logger.info("capacity[{}]", getArrayListCapacity(list));
        }
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
