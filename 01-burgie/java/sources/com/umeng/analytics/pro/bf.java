package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class bf {
    private final ByteArrayOutputStream a;
    private final ch b;
    private bv c;

    public bf() {
        this(new bp.a());
    }

    public bf(bx bxVar) {
        this.a = new ByteArrayOutputStream();
        this.b = new ch(this.a);
        this.c = bxVar.a(this.b);
    }

    public byte[] a(aw awVar) throws bc {
        this.a.reset();
        awVar.write(this.c);
        return this.a.toByteArray();
    }

    public String a(aw awVar, String str) throws bc {
        try {
            return new String(a(awVar), str);
        } catch (UnsupportedEncodingException e) {
            throw new bc("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public String b(aw awVar) throws bc {
        return new String(a(awVar));
    }
}
