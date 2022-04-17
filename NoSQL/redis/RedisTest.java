package com.skillbox.redisdemo;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

public class RedisTest {

    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis


  



    private static void log(int UsersOnline) {
        String log = String.format("[%s] Пользователей купил: %d", DF.format(new Date()), UsersOnline);
        out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {
        int allUsers = 500;
        RedisStorage redis = new RedisStorage();
        redis.init();
        // Эмулируем 10 секунд работы сайта
        for (int i = 0; i <= allUsers; i++)
        {
            if(i % 10 == 0){
                int userBought =(int) (Math.random() * 500);
                out.println("Пользователь: " + userBought + "купил услугу");
                TimeUnit.SECONDS.sleep(1);
                log(userBought);
                continue;
            }
            int userToShow = (int) (Math.random() * 500);
            out.println(userToShow);



        }



        }

    }
