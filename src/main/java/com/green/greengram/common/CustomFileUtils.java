package com.green.greengram.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.UUID;

@Component
@Getter
public class CustomFileUtils {

    private final String uploadPath;

    public CustomFileUtils(@Value("${file.directory}") String uploadPath) {
        this.uploadPath = uploadPath;
    }

    //폴더 만들기
    public String makeFolders(String path) {
        File folder = new File(uploadPath, path);
        folder.mkdirs();
        return folder.getAbsolutePath();
    }

    //UUID 랜덤 파일명
    public String makeRandomFileName() {
        return UUID.randomUUID().toString();
    }

    //파일명에서 확장자 추출
    public String getExt(String fileName) {
        int idx = fileName.lastIndexOf(".");
        return fileName.substring(idx);
    }

    //랜덤 파일명 with 확장자 만들기
    public String makeRandomFileName(String fileName) {
        return makeRandomFileName() + getExt(fileName);
    }

}

