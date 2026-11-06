package com.smartdigimkt.r4;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 {
    public static String a(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - 3);
        }
        return new String(bytes);
    }
}
