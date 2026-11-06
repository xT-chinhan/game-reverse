package com.anythink.core.common.m.d;

import com.anythink.core.common.d.t;
import com.anythink.core.common.m.b.h;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 6;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 4;
    protected int j;
    protected String k;

    public interface a {
        void a(Object obj);

        void a(Throwable th);
    }

    public void a(String str, String str2, String str3, int i2) {
    }

    public abstract int c();

    public abstract int d();

    public abstract byte[] e();

    public abstract boolean f();

    protected int g() {
        return 0;
    }

    public h e_() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        if (bVarB != null) {
            return new h(bVarB.G(), bVarB.H());
        }
        return null;
    }

    public final void a(int i2, String str) {
        this.j = i2;
        this.k = str;
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

    protected final JSONObject h() {
        return com.anythink.core.common.m.e.a(g());
    }

    protected final JSONObject i() {
        return com.anythink.core.common.m.e.b(g());
    }

    public final void a(a aVar) {
        e.a().a(this, aVar);
    }
}
