package com.anythink.core.common.inner.c;

import com.anythink.core.common.h.y;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    List<Double> a;
    long b;
    private int c;
    private int d;
    private long e;

    public e(y yVar) {
        this.d = 0;
        this.e = 0L;
        this.c = yVar.F();
        this.d = yVar.I();
        this.a = yVar.H();
        this.b = yVar.G();
        this.e = yVar.x();
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final List<Double> c() {
        return this.a;
    }

    private long e() {
        return this.b;
    }

    public final long d() {
        return this.e;
    }

    public final String toString() {
        return "ShakeSensorSetting{shakeWay=" + this.c + ", shakeStrength=" + this.d + ", shakeStrengthList=" + this.a + ", shakeDetectDurationTime=" + this.b + ", shakeTimeMs=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
