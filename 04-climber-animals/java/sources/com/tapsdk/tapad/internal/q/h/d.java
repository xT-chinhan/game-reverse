package com.tapsdk.tapad.internal.q.h;

import okhttp3.Headers;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static boolean a = false;

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static long a(Headers headers) {
        return a(headers.get("Content-Length"));
    }
}
