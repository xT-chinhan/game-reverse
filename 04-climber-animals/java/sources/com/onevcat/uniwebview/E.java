package com.onevcat.uniwebview;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class E {
    public final String a;
    public final JSONObject b;

    public E(String resultStr) {
        Intrinsics.checkNotNullParameter(resultStr, "resultStr");
        this.a = resultStr;
        this.b = new JSONObject(resultStr);
    }
}
