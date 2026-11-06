package com.byazt.wo;

import java.text.SimpleDateFormat;
import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1668, 26})
public class qg {
    public long l;
    public String n;
    public String q;
    public String qg;
    public String s;

    public void n(String str) {
        this.n = str;
    }

    public void qg(String str) {
        this.qg = str;
    }

    public void s(String str) {
        this.s = str;
    }

    public String n() {
        return this.q;
    }

    public void q(String str) {
        this.q = str;
    }

    public void n(long j) {
        this.l = j;
    }

    public String toString() {
        return "MediationBehaviorDbData{primeRit='" + this.n + "', adnRit='" + this.qg + "', adnName='" + this.s + "', adAction='" + this.q + "', timeStamp=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.l)) + AbstractJsonLexerKt.END_OBJ;
    }
}
