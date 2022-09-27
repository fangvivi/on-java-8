package com.wayne.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 8锁
 * @author wayne
 *
 * 1 标准访问，先打印短信还是邮件
 * ------sendSMS
 * ------sendEmail
 *
 * 2 停4秒在短信方法内，先打印短信还是邮件
 * ------sendSMS
 * ------sendEmail
 *
 * 3 新增普通的hello方法，是先打短信还是hello
 * ------getHello
 * ------sendSMS
 *
 * 4 现在有两部手机，先打印短信还是邮件
 * ------sendEmail
 * ------sendSMS
 *
 * 5 两个静态同步方法，1部手机，先打印短信还是邮件
 * ------sendSMS
 * ------sendEmail
 *
 * 6 两个静态同步方法，2部手机，先打印短信还是邮件
 * ------sendSMS
 * ------sendEmail
 *
 * 7 1个静态同步方法,1个普通同步方法，1部手机，先打印短信还是邮件
 * ------sendEmail
 * ------sendSMS
 *
 * 8 1个静态同步方法,1个普通同步方法，2部手机，先打印短信还是邮件
 * ------sendEmail
 * ------sendSMS
 *
 *  */
public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(()->{
            try {
                phone.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        Thread.sleep(100);

        //phone1.sendEmail();
        //phone.hello();
        new Thread(phone::sendEmail,"t2").start();
    }
}

/**
 * synchronized 加在非静态方法上，锁住的对象
 * 加在static方法上，锁住的类对象
 */
@Slf4j
class Phone {
    public synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        log.info("------sendSMS");
    }

    public synchronized void sendEmail(){
        log.info("------sendEmail");
    }

    public void hello(){
        log.info("------hello");
    }
}
