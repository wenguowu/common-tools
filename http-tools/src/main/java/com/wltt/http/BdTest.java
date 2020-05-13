package com.wltt.http;

import cn.hutool.http.HttpUtil;

/**
 * author: wlt
 * data: 2020/5/13
 * description:
 */
public class BdTest {
    public static void main(String[] args) {
        String resStr = HttpUtil.post("www.baidu.com","test");
    }
}
