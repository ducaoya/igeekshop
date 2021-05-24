package com.igeek.shop.utils;
import java.util.UUID;
public class CommonsUtils {
    public static String getUUid() {
        //1.UUID.randomUUID（）调用随机方法，获取一个随机ID
        String uid=UUID.randomUUID().toString();

        //2.replace("被替换的目标内容","替换成指定的内容")
        String uuid = uid.replace("-", "");
        return uuid;

    }
    public static void main(String[] args) {
        System.out.println(CommonsUtils.getUUid());


    }
}
