package com.umeng.powersdk;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public long f;

    public final String toString() {
        return "BatteryInfo{level=" + this.a + ", voltage=" + this.b + ", temperature=" + this.c + ", status=" + this.d + ", chargingType=" + this.e + ", ts=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
