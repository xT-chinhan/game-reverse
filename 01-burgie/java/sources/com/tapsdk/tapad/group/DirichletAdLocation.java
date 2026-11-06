package com.tapsdk.tapad.group;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletAdLocation {
    public final double accuracy;
    public final double latitude;
    public final double longitude;

    public DirichletAdLocation(double d, double d2, double d3) {
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = d3;
    }

    public String toString() {
        return "DirichletAdLocation{latitude=" + this.latitude + ", longitude=" + this.longitude + ", accuracy=" + this.accuracy + AbstractJsonLexerKt.END_OBJ;
    }
}
