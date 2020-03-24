package com.example.demomongodb;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

//@Test
public class UUIDTest {
    @Test
    public void test1() {
        /*AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        aesKeyGenerator.*/
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

    @Test
    public void test2() {
        String str = "37140219860917762X";
        System.out.println(str);
        System.out.println(str.substring(6, 10));
        System.out.println(str.substring(10, 12));
        System.out.println(str.substring(12, 14));
    }

    @Test
    public void test3() {
        String str = "100000000000";
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int anInt = random.nextInt(1000000);
            System.out.print(anInt);
            System.out.print("\t");
            String format = String.format("%06d", anInt);
            System.out.print(format);
            System.out.print("\t");
            System.out.println(str + format);
        }
    }

    @Test
    public void test4(){
//        double integer = 510922199001020408;
        BigDecimal bigDecimal = new BigDecimal("510922199001020408");
        for (int i = 0; i < 50; i++) {
            bigDecimal = bigDecimal.add(new BigDecimal(1));
            System.out.println(bigDecimal);
        }
//        System.out.println(bigDecimal);
    }

    @Test
    public void test5(){
        BigDecimal bigDecimal = new BigDecimal("13100000000");
        for (int i = 0; i < 10; i++) {
            bigDecimal = bigDecimal.add(new BigDecimal(1));
            System.out.println(bigDecimal);
        }
    }
}
