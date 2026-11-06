package com.anythink.core.api;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class ATCustomContentInfo {
    ATAdInfo atAdInfo;
    double customContentDouble;
    Object customContentObject;
    String customContentString;

    public ATCustomContentInfo(String str, Object obj) {
        this.customContentDouble = -1.0d;
        this.customContentString = str;
        this.customContentObject = obj;
    }

    public ATCustomContentInfo(double d, Object obj) {
        this.customContentDouble = d;
        this.customContentObject = obj;
    }

    public String getCustomContentString() {
        return this.customContentString;
    }

    public double getCustomContentDouble() {
        return this.customContentDouble;
    }

    public Object getCustomContentObject() {
        return this.customContentObject;
    }

    public ATAdInfo getAdInfo() {
        return this.atAdInfo;
    }

    public void setATAdInfo(ATAdInfo aTAdInfo) {
        this.atAdInfo = aTAdInfo;
    }

    public String toString() {
        return "ATCustomContentInfo{customContentString='" + this.customContentString + "', customContentDouble=" + this.customContentDouble + ", customContentObject=" + this.customContentObject + AbstractJsonLexerKt.END_OBJ;
    }
}
