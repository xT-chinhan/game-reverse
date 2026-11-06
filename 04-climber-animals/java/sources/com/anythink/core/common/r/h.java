package com.anythink.core.common.r;

import com.anythink.core.common.h.ar;
import com.anythink.core.common.h.n;
import com.anythink.core.d.l;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public int a;
    public String b;
    public int c;
    public int d;
    public double e;
    public ar f;
    public n g;
    public l h;
    public int i;
    public g j;

    public final String toString() {
        return "SharedPlaceInfo{format=" + this.a + ", placementId='" + this.b + "', requestInterval=" + this.c + ", adCacheNumThreshold=" + this.d + ", adCachePriceThreshold=" + this.e + ", failRetryReqCount=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
