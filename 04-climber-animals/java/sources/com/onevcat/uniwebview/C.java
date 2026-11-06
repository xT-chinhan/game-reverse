package com.onevcat.uniwebview;

import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class C extends D {
    /* JADX WARN: Illegal instructions before constructor call */
    public C(String webViewName, String url) {
        Intrinsics.checkNotNullParameter(webViewName, "webViewName");
        Intrinsics.checkNotNullParameter(url, "url");
        String string = new JSONObject(MapsKt.mapOf(TuplesKt.to("url", url))).toString();
        Intrinsics.checkNotNullExpressionValue(string, "obj.toString()");
        super(webViewName, "ShouldUniWebViewHandleRequest", string);
    }
}
