package com.byazt.cri;

import com.taptap.sdk.kit.internal.http.TapHttp;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1393, 13})
public final class w {
    public static boolean n(String str) {
        return TapHttp.METHOD_POST.equals(str) || "PATCH".equals(str) || "PUT".equals(str) || "DELETE".equals(str) || "MOVE".equals(str);
    }

    public static boolean qg(String str) {
        return TapHttp.METHOD_POST.equals(str) || "PUT".equals(str) || "PATCH".equals(str) || "PROPPATCH".equals(str) || "REPORT".equals(str);
    }

    public static boolean s(String str) {
        return qg(str) || "OPTIONS".equals(str) || "DELETE".equals(str) || "PROPFIND".equals(str) || "MKCOL".equals(str) || "LOCK".equals(str);
    }

    public static boolean q(String str) {
        return "PROPFIND".equals(str);
    }

    public static boolean l(String str) {
        return !"PROPFIND".equals(str);
    }
}
