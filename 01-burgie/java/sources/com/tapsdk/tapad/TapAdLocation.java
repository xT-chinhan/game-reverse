package com.tapsdk.tapad;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class TapAdLocation {
    public final double accuracy;
    public final double latitude;
    public final double longitude;

    public TapAdLocation(double d, double d2, double d3) {
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = d3;
    }

    public String toString() {
        return "TapAdLocation{latitude=" + this.latitude + ", longitude=" + this.longitude + ", accuracy=" + this.accuracy + AbstractJsonLexerKt.END_OBJ;
    }
}
