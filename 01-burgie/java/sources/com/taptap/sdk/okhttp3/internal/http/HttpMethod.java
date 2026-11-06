package com.taptap.sdk.okhttp3.internal.http;

import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpMethod {
    public static boolean invalidatesCache(String method) {
        return method.equals(TapHttp.METHOD_POST) || method.equals("PATCH") || method.equals(TapHttp.METHOD_PUT) || method.equals("DELETE") || method.equals("MOVE");
    }

    public static boolean requiresRequestBody(String method) {
        return method.equals(TapHttp.METHOD_POST) || method.equals(TapHttp.METHOD_PUT) || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT");
    }

    public static boolean permitsRequestBody(String method) {
        return (method.equals(TapHttp.METHOD_GET) || method.equals(Util.METHOD_HEAD)) ? false : true;
    }

    public static boolean redirectsWithBody(String method) {
        return method.equals("PROPFIND");
    }

    public static boolean redirectsToGet(String method) {
        return !method.equals("PROPFIND");
    }

    private HttpMethod() {
    }
}
