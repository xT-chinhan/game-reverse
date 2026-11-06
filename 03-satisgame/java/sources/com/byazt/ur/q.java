package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 5})
public class q {
    public static com.byazt.ccr.qg n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        return n(jsonReader, wVar, true);
    }

    public static com.byazt.ccr.qg n(JsonReader jsonReader, com.byazt.pp.w wVar, boolean z) throws IOException {
        return new com.byazt.ccr.qg(n(jsonReader, z ? com.byazt.nu.tj.n() : 1.0f, wVar, d.n));
    }

    public static com.byazt.ccr.q qg(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        return new com.byazt.ccr.q(n(jsonReader, wVar, cd.n));
    }

    public static com.byazt.ccr.w s(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        return new com.byazt.ccr.w(py.n(jsonReader, wVar, com.byazt.nu.tj.n(), ur.n, true));
    }

    public static com.byazt.ccr.x q(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        return new com.byazt.ccr.x(n(jsonReader, wVar, j.n));
    }

    public static com.byazt.ccr.fs l(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        return new com.byazt.ccr.fs(n(jsonReader, com.byazt.nu.tj.n(), wVar, an.n));
    }

    public static com.byazt.ccr.tj w(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        return new com.byazt.ccr.tj(n(jsonReader, com.byazt.nu.tj.n(), wVar, rv.n));
    }

    public static com.byazt.ccr.n x(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        return new com.byazt.ccr.n(n(jsonReader, wVar, x.n));
    }

    public static com.byazt.ccr.s n(JsonReader jsonReader, com.byazt.pp.w wVar, int i) throws IOException {
        return new com.byazt.ccr.s(n(jsonReader, wVar, new k(i)));
    }

    private static <T> List<com.byazt.yt.n<T>> n(JsonReader jsonReader, com.byazt.pp.w wVar, dg<T> dgVar) throws IOException {
        return py.n(jsonReader, wVar, 1.0f, dgVar, false);
    }

    private static <T> List<com.byazt.yt.n<T>> n(JsonReader jsonReader, float f, com.byazt.pp.w wVar, dg<T> dgVar) throws IOException {
        return py.n(jsonReader, wVar, f, dgVar, false);
    }
}
