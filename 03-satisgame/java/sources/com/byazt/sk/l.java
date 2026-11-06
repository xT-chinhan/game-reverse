package com.byazt.sk;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1501, 18})
public class l {
    public static long fs = 10485760;
    public static long l = 50;
    public static volatile String n = "";
    public static long q = 512000;
    public static volatile String qg = "";
    public static final JSONObject rv = new JSONObject();
    public static volatile String s = "";
    public static long w = 5242880;
    public static long x = 31457280;

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n = str;
    }
}
