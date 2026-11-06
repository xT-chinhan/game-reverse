package com.mar.sdk.utils;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.mar.sdk.log.Log;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class EncryptUtils {
    public static String md5Sign(Map<String, String> params, String key) {
        String data = generateUrlSortedParamString(params, "&", true) + "&key=" + key;
        Log.d("MARSDK", "sign str:" + data);
        String sign = md5(data).toLowerCase();
        Log.d("MARSDK", "sign:" + sign);
        return sign;
    }

    public static String md5(String txt) {
        return encrypt(txt, "md5");
    }

    public static String sha(String txt) {
        return encrypt(txt, "sha");
    }

    private static String encrypt(String txt, String algorithName) {
        if (txt == null || txt.trim().length() == 0) {
            return null;
        }
        if (algorithName == null || algorithName.trim().length() == 0) {
            algorithName = "MD5";
        }
        try {
            MessageDigest m = MessageDigest.getInstance(algorithName);
            m.reset();
            m.update(txt.getBytes(Key.STRING_CHARSET_NAME));
            byte[] bts = m.digest();
            String result = hex(bts);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String hex(byte[] bts) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bts) {
            sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3));
        }
        return sb.toString();
    }

    public static String generateUrlSortedParamString(Map<String, String> params, String splitChar, boolean nullExcluded) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key) == null ? "" : params.get(key);
            if (!nullExcluded || value.length() != 0) {
                content.append(key + "=" + value);
                if (!TextUtils.isEmpty(splitChar)) {
                    content.append(splitChar);
                }
            }
        }
        if (content.length() > 0 && !TextUtils.isEmpty(splitChar)) {
            content.deleteCharAt(content.length() - 1);
        }
        return content.toString();
    }
}
