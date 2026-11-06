package com.bytedance.pangle.log;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private String ah;
    private long d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f647ms;
    private String xr;

    public static ms ms(String str, String str2, String str3) {
        return new ms(str, str2, str3);
    }

    private ms(String str, String str2, String str3) {
        this.f647ms = str;
        this.xr = str2;
        this.ah = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.ka = jCurrentTimeMillis;
        this.d = jCurrentTimeMillis;
        ZeusLogger.i(this.f647ms, this.xr + String.format(" watcher[%s]-start", str3));
    }

    public long ms(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.ka;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.d;
        ZeusLogger.i(this.f647ms, this.xr + String.format(" watcher[%s]-%s cost=%s, total=%s", this.ah, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public long ms() {
        return System.currentTimeMillis() - this.d;
    }
}
