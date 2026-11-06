package com.bytedance.pangle.util;

/* JADX INFO: loaded from: classes2.dex */
public class sl {
    public static int ms(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }
}
