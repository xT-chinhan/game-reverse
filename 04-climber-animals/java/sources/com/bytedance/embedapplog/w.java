package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    private static final AtomicLong c = new AtomicLong(1000);
    private static ms ub;
    private long ab;
    private rt ah;
    private volatile boolean ch;
    private rt d;
    private long hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final pc f537ms;
    private long ny = -1;
    private int sl;
    private vm u;
    private int x;
    private final jw xr;
    private String zb;

    w(jw jwVar, pc pcVar) {
        this.xr = jwVar;
        this.f537ms = pcVar;
    }

    public String ms() {
        return this.ka;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004e  */
    synchronized Bundle ms(long j, long j2) {
        Bundle bundle;
        if (this.f537ms.ka() && ah()) {
            long j3 = this.ab;
            if (j3 <= 0 || j - j3 <= j2) {
                bundle = null;
            } else {
                bundle = new Bundle();
                bundle.putInt("session_no", this.sl);
                int i = this.x + 1;
                this.x = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", (j - this.ab) / 1000);
                bundle.putString(com.umeng.analytics.pro.x.a, tz.xr(this.ny));
                this.ab = j;
            }
        } else {
            bundle = null;
        }
        return bundle;
    }

    public boolean xr() {
        return this.ch;
    }

    boolean ah() {
        return xr() && this.hi == 0;
    }

    private synchronized void ms(tz tzVar, ArrayList<tz> arrayList, boolean z) {
        long j = tzVar instanceof ms ? -1L : tzVar.xr;
        this.ka = UUID.randomUUID().toString();
        c.set(1000L);
        this.ny = j;
        this.ch = z;
        this.hi = 0L;
        this.ab = 0L;
        if (oh.xr) {
            oh.ms("startSession, " + this.ka + ", hadUi:" + z + " data:" + tzVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String string = new StringBuilder().append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            if (TextUtils.isEmpty(this.zb)) {
                this.zb = this.f537ms.xr();
                this.sl = this.f537ms.ah();
            }
            if (!string.equals(this.zb)) {
                this.zb = string;
                this.sl = 1;
            } else {
                this.sl++;
            }
            this.f537ms.ms(string, this.sl);
            this.x = 0;
            this.ab = tzVar.xr;
        }
        if (j != -1) {
            vm vmVar = new vm(false);
            vmVar.d = this.ka;
            vmVar.ah = d();
            vmVar.xr = this.ny;
            vmVar.u = this.ch ? false : true;
            vmVar.zb = this.xr.ah();
            vmVar.sl = this.xr.xr();
            vmVar.c = com.bytedance.embedapplog.ms.ch();
            vmVar.ab = com.bytedance.embedapplog.ms.ny();
            if (this.f537ms.nw()) {
                vmVar.x = com.bytedance.embedapplog.ms.ka();
            }
            arrayList.add(vmVar);
            this.u = vmVar;
            if (oh.xr) {
                oh.ms("gen launch, " + vmVar.d + ", hadUi:" + z, null);
            }
        }
    }

    public static boolean ms(tz tzVar) {
        if (tzVar instanceof rt) {
            return ((rt) tzVar).ch();
        }
        return false;
    }

    boolean ms(tz tzVar, ArrayList<tz> arrayList) {
        boolean z = tzVar instanceof rt;
        boolean zMs = ms(tzVar);
        boolean z2 = true;
        if (this.ny == -1) {
            ms(tzVar, arrayList, ms(tzVar));
        } else if (!this.ch && zMs) {
            ms(tzVar, arrayList, true);
        } else if (this.hi == 0 || tzVar.xr <= this.hi + this.f537ms.re()) {
            if (this.ny > tzVar.xr + com.anythink.core.common.d.j.k.a) {
                ms(tzVar, arrayList, zMs);
            } else {
                z2 = false;
            }
        } else if (!zd.xr() && zd.ms()) {
            ms(tzVar, arrayList, zMs);
        }
        if (z) {
            rt rtVar = (rt) tzVar;
            if (rtVar.ch()) {
                this.hi = 0L;
                arrayList.add(tzVar);
                if (TextUtils.isEmpty(rtVar.zb)) {
                    if (this.d != null && (rtVar.xr - this.d.xr) - this.d.sl < 500) {
                        rtVar.zb = this.d.u;
                    } else if (this.ah != null && (rtVar.xr - this.ah.xr) - this.ah.sl < 500) {
                        rtVar.zb = this.ah.u;
                    }
                }
            } else {
                Bundle bundleMs = ms(tzVar.xr, 0L);
                if (bundleMs != null) {
                    com.bytedance.embedapplog.ms.ms("play_session", bundleMs);
                }
                this.hi = rtVar.xr;
                arrayList.add(tzVar);
                if (rtVar.hi()) {
                    this.ah = rtVar;
                } else {
                    this.d = rtVar;
                    this.ah = null;
                }
            }
        } else if (!(tzVar instanceof ms)) {
            arrayList.add(tzVar);
        }
        xr(tzVar);
        return z2;
    }

    public void xr(tz tzVar) {
        if (tzVar != null) {
            if (this.f537ms.nw()) {
                tzVar.x = com.bytedance.embedapplog.ms.ka();
            }
            tzVar.c = com.bytedance.embedapplog.ms.ch();
            tzVar.ab = com.bytedance.embedapplog.ms.ny();
            tzVar.d = this.ka;
            tzVar.ah = d();
        }
    }

    public static long d() {
        return c.incrementAndGet();
    }

    static class ms extends vy {
        private ms() {
        }
    }

    static ms ka() {
        if (ub == null) {
            ub = new ms();
        }
        ub.xr = System.currentTimeMillis();
        return ub;
    }
}
