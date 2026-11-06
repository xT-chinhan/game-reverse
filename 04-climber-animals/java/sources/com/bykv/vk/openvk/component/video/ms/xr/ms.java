package com.bykv.vk.openvk.component.video.ms.xr;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
abstract class ms implements hi {
    private static final AtomicLong zb = new AtomicLong();
    protected volatile String ab;
    protected volatile List<ny.xr> c;
    protected volatile sl ch;
    protected com.bykv.vk.openvk.component.video.ms.xr.d.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected volatile com.bykv.vk.openvk.component.video.ms.xr.ms.ms f88ms;
    protected volatile ny ny;
    protected volatile String x;
    protected final com.bykv.vk.openvk.component.video.ms.xr.xr.ah xr;
    protected final AtomicInteger ah = new AtomicInteger();
    protected final AtomicLong d = new AtomicLong();
    protected volatile boolean hi = false;
    public final long sl = zb.incrementAndGet();
    private final AtomicInteger u = new AtomicInteger(0);
    private int ub = -1;

    public ms(com.bykv.vk.openvk.component.video.ms.xr.ms.ms msVar, com.bykv.vk.openvk.component.video.ms.xr.xr.ah ahVar) {
        this.f88ms = msVar;
        this.xr = ahVar;
    }

    public void ms() {
        this.u.compareAndSet(0, 1);
    }

    public boolean xr() {
        return this.u.get() == 1;
    }

    protected void ah() {
        this.u.compareAndSet(0, 2);
    }

    public boolean d() {
        return this.u.get() == 2;
    }

    protected void ka() throws com.bykv.vk.openvk.component.video.ms.xr.ah.ms {
        if (xr()) {
            throw new com.bykv.vk.openvk.component.video.ms.xr.ah.ms();
        }
    }

    protected com.bykv.vk.openvk.component.video.ms.xr.ka.ms ms(sl.ms msVar, int i, int i2, String str) throws IOException {
        com.bykv.vk.openvk.component.video.ms.xr.ka.xr xrVarXr = com.bykv.vk.openvk.component.video.ms.xr.ka.ah.ms().xr();
        com.bykv.vk.openvk.component.video.ms.xr.ka.ka kaVar = new com.bykv.vk.openvk.component.video.ms.xr.ka.ka();
        HashMap map = new HashMap();
        kaVar.xr = msVar.f105ms;
        kaVar.f86ms = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            kaVar.f86ms = 4;
        }
        List<ny.xr> list = this.c;
        if (list != null && !list.isEmpty()) {
            for (ny.xr xrVar : list) {
                if (!"Range".equalsIgnoreCase(xrVar.f103ms) && !"Connection".equalsIgnoreCase(xrVar.f103ms) && !"Proxy-Connection".equalsIgnoreCase(xrVar.f103ms) && !"Host".equalsIgnoreCase(xrVar.f103ms)) {
                    map.put(xrVar.f103ms, xrVar.xr);
                }
            }
        }
        String strMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(i, i2);
        if (strMs != null) {
            map.put("Range", strMs);
        }
        if (ka.c) {
            map.put("Cache-Control", "no-cache");
        }
        d dVarAh = d.ah();
        c cVarMs = c.ms();
        boolean z = this.ny == null;
        ah ahVarMs = z ? dVarAh.ms() : cVarMs.xr();
        ah ahVarXr = z ? dVarAh.xr() : cVarMs.ah();
        if (ahVarMs != null || ahVarXr != null) {
            if (ahVarMs != null) {
                kaVar.ah = ahVarMs.ms(msVar.xr);
            }
            if (ahVarXr != null) {
                kaVar.d = ahVarXr.ms(msVar.xr);
            }
        }
        kaVar.ka = map;
        if (this.hi) {
            this.hi = false;
            return null;
        }
        return xrVarXr.ms(kaVar);
    }

    protected int c() {
        if (this.ny != null) {
            return this.ny.ah.f102ms;
        }
        return this.f88ms instanceof com.bykv.vk.openvk.component.video.ms.xr.ms.xr ? 1 : 0;
    }

    protected boolean ab() {
        return c() == 1;
    }

    protected void ms(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = ka.ab;
        int iC = c();
        if (i3 == 1 || (i3 == 2 && iC == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.ub) {
                    return;
                }
                this.ub = i4;
                com.bykv.vk.openvk.component.video.ms.ah.ms.ms(new Runnable() { // from class: com.bykv.vk.openvk.component.video.ms.xr.ms.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ms.this.ka != null) {
                            sl slVar = ms.this.ch;
                            int unused = ms.this.ub;
                        }
                    }
                });
            }
        }
    }
}
