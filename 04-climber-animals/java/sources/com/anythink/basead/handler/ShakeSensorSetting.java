package com.anythink.basead.handler;

import com.anythink.core.common.h.y;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class ShakeSensorSetting {
    List<Double> a;
    long b;
    private int c;
    private int d;
    private long e;

    public ShakeSensorSetting(y yVar) {
        this.d = 0;
        this.e = 0L;
        this.c = yVar.aI();
        this.d = yVar.aL();
        this.a = yVar.aK();
        this.b = yVar.aJ();
        this.e = yVar.W();
    }

    public int getShakeWay() {
        return this.c;
    }

    public int getShakeStrength() {
        return this.d;
    }

    public List<Double> getShakeStrengthList() {
        return this.a;
    }

    public long getShakeDetectDurationTime() {
        return this.b;
    }

    public long getShakeTimeMs() {
        return this.e;
    }

    public String toString() {
        return "ShakeSensorSetting{shakeWay=" + this.c + ", shakeStrength=" + this.d + ", shakeStrengthList=" + this.a + ", shakeDetectDurationTime=" + this.b + ", shakeTimeMs=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
