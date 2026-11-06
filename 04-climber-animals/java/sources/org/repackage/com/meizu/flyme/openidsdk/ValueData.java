package org.repackage.com.meizu.flyme.openidsdk;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class ValueData {
    public String a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
