package com.byazt.osx;

import com.taptap.sdk.kit.internal.http.TapHttp;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 442, 5})
public final class uc {
    public static boolean pr(String str) {
        return TapHttp.METHOD_POST.equals(str) || "PATCH".equals(str) || TapHttp.METHOD_PUT.equals(str) || "DELETE".equals(str) || "MOVE".equals(str);
    }

    public static boolean hw(String str) {
        return TapHttp.METHOD_POST.equals(str) || TapHttp.METHOD_PUT.equals(str) || "PATCH".equals(str) || "PROPPATCH".equals(str) || "REPORT".equals(str);
    }

    public static boolean hn(String str) {
        return hw(str) || "OPTIONS".equals(str) || "DELETE".equals(str) || "PROPFIND".equals(str) || "MKCOL".equals(str) || "LOCK".equals(str);
    }

    public static boolean x(String str) {
        return "PROPFIND".equals(str);
    }

    public static boolean c(String str) {
        return !"PROPFIND".equals(str);
    }
}
