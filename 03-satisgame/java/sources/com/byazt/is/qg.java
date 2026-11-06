package com.byazt.is;

import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1818, 26})
public class qg {
    public long l;
    public String n;
    public long q;
    public String qg;
    public String s;

    public static qg n(String str, String str2, String str3) {
        return new qg(str, str2, str3);
    }

    private qg(String str, String str2, String str3) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.l = jCurrentTimeMillis;
        this.q = jCurrentTimeMillis;
        ZeusLogger.i(this.n, this.qg + String.format(" watcher[%s]-start", str3));
    }

    public long n(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.l;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.q;
        ZeusLogger.i(this.n, this.qg + String.format(" watcher[%s]-%s cost=%s, total=%s", this.s, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public long n() {
        return System.currentTimeMillis() - this.q;
    }
}
