package com.smartdigimkt.d4;

import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public c a;
    public int b;
    public String c;
    public Throwable d;
    public com.smartdigimkt.e4.c e;
    public Map f;
    public List g;
    public long h = -1;
    public boolean i;

    public final String toString() {
        return "NetBridgeResponse{request=" + this.a + ", code=" + this.b + ", errorMsg='" + this.c + "', exception=" + this.d + ", responseBody=" + this.e + ", responseHeader=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
