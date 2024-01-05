package com.wayne.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author waine
 * @date 2023-12-15 16:15
 */
@Slf4j
public class ListProblems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        log.info("list:{} size:{} class:{}", list, list.size(), list.get(0).getClass());

        List<Integer> listInteger = Arrays.stream(arr).boxed().collect(Collectors.toList());
        log.info("list:{} size:{} class:{}", listInteger, listInteger.size(), listInteger.get(0).getClass());
    }
}
