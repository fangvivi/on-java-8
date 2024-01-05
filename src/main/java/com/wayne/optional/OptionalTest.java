package com.wayne.optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author wayne
 * @date 2023-02-16 21:20
 */
@Slf4j
public class OptionalTest {

    @Test
    public void test1(){
        final Girl girl = new Girl();
        final Optional<Girl> opGirl = Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        final Optional<Girl> opGirl = Optional.ofNullable(girl);
        Girl girlNew = opGirl.orElse(new Girl("张三"));
        log.info("{}", girlNew);
    }

    public void getGirlName(Boy boy){
        log.info("{}", boy.getGirl().getName());
    }

    public void getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boyNew = boyOptional.orElse(new Boy(new Girl("李四")));
        Girl girl = boyNew.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("王五"));
        log.info("{}", girl1.getName());
    }

    @Test
    public void test3(){
        Boy boy = null;
        getGirlName2(boy);
    }
}
