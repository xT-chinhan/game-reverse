package com.anythink.core.common.m.b.a.c;

import com.taptap.sdk.kit.internal.http.TapHttp;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static boolean a(String str) {
        return str.equals(TapHttp.METHOD_POST) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return str.equals(TapHttp.METHOD_POST) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean c(String str) {
        return (str.equals(TapHttp.METHOD_GET) || str.equals("HEAD")) ? false : true;
    }

    private static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    private static boolean e(String str) {
        return !str.equals("PROPFIND");
    }

    private f() {
    }
}
