package com.wltt.http;

import cn.hutool.http.HttpUtil;

/**
 * author: wlt
 * data: 2020/5/13
 * description:
 */
public class BdTest {
    public static void main(String[] args) {
        String resStr = HttpUtil.post("http://factory.sit01.jaalantech.com/api/0001/accrual/group/list?id=AM202112021332442805642365172545","test");
        System.out.println(resStr);
    }
}
