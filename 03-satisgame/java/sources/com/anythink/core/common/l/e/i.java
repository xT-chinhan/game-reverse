package com.anythink.core.common.l.e;

import com.anythink.core.common.d.s;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 6;
    public static final int g = 10;
    public static final int h = 9;
    public static final int i = 12;
    public static final int j = 12;
    public static final int k = 13;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 4;
    protected int o;
    protected String p;

    public interface a {
        void a(Object obj);

        void a(Throwable th);
    }

    public abstract int a();

    public void a(com.anythink.core.common.l.c.h hVar) {
    }

    public abstract int b();

    public abstract byte[] c();

    public abstract boolean d();

    public void e() {
    }

    protected int f() {
        return 0;
    }

    public com.anythink.core.common.l.c.h h() {
        return null;
    }

    public boolean i() {
        return false;
    }

    public long j() {
        return 0L;
    }

    public com.anythink.core.common.l.c.h a_() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
        if (bVarB != null) {
            return new com.anythink.core.common.l.c.h(bVarB.y(), bVarB.z());
        }
        return null;
    }

    public final void a(int i2, String str) {
        this.o = i2;
        this.p = str;
    }

    protected static byte[] a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    protected final JSONObject k() {
        return com.anythink.core.common.l.f.a(f());
    }

    protected final JSONObject l() {
        return com.anythink.core.common.l.f.b(f());
    }

    public final void a(a aVar) {
        k.a().a(this, aVar);
    }
}
