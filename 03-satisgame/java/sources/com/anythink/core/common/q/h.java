package com.anythink.core.common.q;

import com.anythink.core.common.h.as;
import com.anythink.core.common.h.n;
import com.anythink.core.e.l;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public int a;
    public String b;
    public int c;
    public int d;
    public double e;
    public as f;
    public n g;
    public l h;
    public int i;
    public g j;
    public Integer[] k;

    public final String toString() {
        return "SharedPlaceInfo{format=" + this.a + ", placementId='" + this.b + "', requestInterval=" + this.c + ", adCacheNumThreshold=" + this.d + ", adCachePriceThreshold=" + this.e + ", realFormatLoadParams=" + this.f + ", failRetryReqCount=" + this.i + ", loadModes=" + Arrays.toString(this.k) + AbstractJsonLexerKt.END_OBJ;
    }
}
