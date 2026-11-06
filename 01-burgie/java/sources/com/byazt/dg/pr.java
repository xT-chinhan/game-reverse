package com.byazt.dg;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1230, 37})
public class pr {
    public Object[] hw;
    public String pr;

    public String pr() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public Object[] hw() {
        return this.hw;
    }

    public void pr(Object[] objArr) {
        this.hw = objArr;
    }

    public String toString() {
        return "MethodResult{methodName='" + this.pr + "', args=" + Arrays.toString(this.hw) + AbstractJsonLexerKt.END_OBJ;
    }
}
