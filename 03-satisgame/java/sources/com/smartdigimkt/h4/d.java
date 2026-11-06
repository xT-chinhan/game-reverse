package com.smartdigimkt.h4;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public int a;
    public String b;

    public abstract int a();

    public abstract void a(int i, String str, String str2);

    public final void a(c cVar) {
        if (e.c == null) {
            synchronized (e.class) {
                if (e.c == null) {
                    e.c = new e();
                }
            }
        }
        e.c.a(this, cVar);
    }

    public abstract byte[] b();

    public static byte[] a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
