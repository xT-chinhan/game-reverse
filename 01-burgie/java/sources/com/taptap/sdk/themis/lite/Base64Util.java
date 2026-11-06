package com.taptap.sdk.themis.lite;

import android.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public class Base64Util {
    public static String decode(String input) {
        byte[] decodedBytes = Base64.decode(input, 0);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
}
