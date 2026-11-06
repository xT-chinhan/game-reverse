package com.bytedance.adsdk.xr.xr.ms;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f465ms;
    private Object[] xr;

    public String ms() {
        return this.f465ms;
    }

    public void ms(String str) {
        this.f465ms = str;
    }

    public Object[] xr() {
        return this.xr;
    }

    public void ms(Object[] objArr) {
        this.xr = objArr;
    }

    public String toString() {
        return "MethodResult{methodName='" + this.f465ms + "', args=" + Arrays.toString(this.xr) + AbstractJsonLexerKt.END_OBJ;
    }
}
