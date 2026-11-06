package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.taptap.sdk.kit.internal.http.TapHttp;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static boolean ms(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals(TapHttp.METHOD_PUT) || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean xr(String str) {
        return str.equals("POST") || str.equals(TapHttp.METHOD_PUT) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean ah(String str) {
        return xr(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean ka(String str) {
        return !str.equals("PROPFIND");
    }
}
