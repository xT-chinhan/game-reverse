package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: classes4.dex */
public class dn {
    private final ByteArrayOutputStream a;
    private final ep b;
    private ed c;

    public dn() {
        this(new dx.a());
    }

    public dn(ef efVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        ep epVar = new ep(byteArrayOutputStream);
        this.b = epVar;
        this.c = efVar.a(epVar);
    }

    public byte[] a(de deVar) throws dk {
        this.a.reset();
        deVar.write(this.c);
        return this.a.toByteArray();
    }

    public String a(de deVar, String str) throws dk {
        try {
            return new String(a(deVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new dk("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public String b(de deVar) throws dk {
        return new String(a(deVar));
    }
}
