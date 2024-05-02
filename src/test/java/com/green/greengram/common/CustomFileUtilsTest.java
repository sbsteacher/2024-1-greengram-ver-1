package com.green.greengram.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class CustomFileUtilsTest {

    @Autowired
    CustomFileUtils utils;

    @Test
    void makeFolders() {
        String result = utils.makeFolders("ddd2");
        System.out.println("result: " + result);
    }

    @Test
    void makeRandomFileName() {
        String result = utils.makeRandomFileName();
        System.out.println("=======================================");
        System.out.println("makeRandomFileName: "+ result); //34자
        System.out.println("=======================================");
    }

    @Test
    void getExt() {
        String ext = utils.getExt("abcde.ddd.jpg.sadklsdklsdaklj.png");
        System.out.println("ext: " + ext);
    }

}