package com.byazt.qy;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2094, 19})
public class n {
    public String n;
    public Object[] qg;

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public Object[] qg() {
        return this.qg;
    }

    public void n(Object[] objArr) {
        this.qg = objArr;
    }

    public String toString() {
        return "MethodResult{methodName='" + this.n + "', args=" + Arrays.toString(this.qg) + AbstractJsonLexerKt.END_OBJ;
    }
}
