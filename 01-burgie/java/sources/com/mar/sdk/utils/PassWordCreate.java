package com.mar.sdk.utils;

import java.util.Random;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class PassWordCreate {
    public String createPassWord(int len) {
        int random = createRandomInt();
        return createPassWord(random, len);
    }

    public String createPassWord(int random, int len) {
        Random rd = new Random(random);
        StringBuffer sb = new StringBuffer();
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int count = 0;
        while (count < len) {
            int rdGet = Math.abs(rd.nextInt(62));
            if (rdGet >= 0 && rdGet < str.length) {
                sb.append(str[rdGet]);
                count++;
            }
        }
        return sb.toString();
    }

    public int createRandomInt() {
        double temp = Math.random() * 100000.0d;
        if (temp >= 100000.0d) {
            temp = 99999.0d;
        }
        int tempint = (int) Math.ceil(temp);
        return tempint;
    }

    public static void main(String[] args) {
        PassWordCreate passWordCreate = new PassWordCreate();
        String key = passWordCreate.createPassWord(24);
        System.out.println(key + Des3Util.encrypt("{'timeStamp':'1646709571275','advertObjectId':'advert6226cb4399321151e8c967dc'}", key));
    }
}
