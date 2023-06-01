package com.project.laundryappui.user.Util;

import android.annotation.SuppressLint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public  class TextUtil {


    public static boolean saveInfo(long id,int state,String uuid) {
        String info = id + "##" + state + "##" + uuid;
        @SuppressLint("SdCardPath") File file =  new File("/data/data/com.project.laundryappui/userinfo.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //将字符串写入到文件中
            fos.write(info.getBytes());
            //关闭数据流
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String[] readInfo() {
        @SuppressLint("SdCardPath") File file =  new File("/data/data/com.project.laundryappui/userinfo.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String temp = reader.readLine();
            String[] result = temp.split("##");
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}