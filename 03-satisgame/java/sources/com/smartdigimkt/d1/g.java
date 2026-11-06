package com.smartdigimkt.d1;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final int a;
    public final int b;
    public final List c;
    public final long d;

    public g(com.smartdigimkt.b3.e eVar) {
        this.b = 0;
        this.a = eVar.K1;
        this.b = eVar.N1;
        this.c = eVar.M1;
        this.d = eVar.L1;
    }

    public final String toString() {
        return "ShakeSensorSetting{shakeWay=" + this.a + ", shakeStrength=" + this.b + ", shakeStrengthList=" + this.c + ", shakeDetectDurationTime=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
