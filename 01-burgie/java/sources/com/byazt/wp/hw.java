package com.byazt.wp;

import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1678, 13})
public class hw {
    public long c;
    public String hn;
    public String hw;
    public String pr;
    public long x;

    public static hw pr(String str, String str2, String str3) {
        return new hw(str, str2, str3);
    }

    private hw(String str, String str2, String str3) {
        this.pr = str;
        this.hw = str2;
        this.hn = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.c = jCurrentTimeMillis;
        this.x = jCurrentTimeMillis;
        ZeusLogger.i(this.pr, this.hw + String.format(" watcher[%s]-start", str3));
    }

    public long pr(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.x;
        ZeusLogger.i(this.pr, this.hw + String.format(" watcher[%s]-%s cost=%s, total=%s", this.hn, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public long pr() {
        return System.currentTimeMillis() - this.x;
    }
}
