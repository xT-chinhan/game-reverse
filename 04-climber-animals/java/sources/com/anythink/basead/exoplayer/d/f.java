package com.anythink.basead.exoplayer.d;

import com.anythink.basead.exoplayer.d.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface f<T extends i> {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    int e();

    a f();

    T g();

    Map<String, String> h();

    byte[] i();

    public static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }
}
