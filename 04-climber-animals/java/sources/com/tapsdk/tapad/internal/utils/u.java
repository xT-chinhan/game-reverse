package com.tapsdk.tapad.internal.utils;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    public static String a(String str) {
        int iIndexOf = str.indexOf(63);
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf == -1) {
            iIndexOf = str.length() + 1;
        }
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length() + 1;
        }
        int iMin = Math.min(iIndexOf, iIndexOf2);
        if (iMin < str.length()) {
            str = str.substring(0, iMin);
        }
        return str.substring(Math.max(str.lastIndexOf(47), str.lastIndexOf(92)) + 1);
    }
}
