package com.bytedance.ms.xr.ms;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Runnable {
    private volatile boolean ah = false;
    private Runnable d = new Runnable() { // from class: com.bytedance.ms.xr.ms.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.ah = false;
        }
    };

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f584ms = ms();
    private final ah xr;

    d(ah ahVar) {
        this.xr = ahVar;
        com.bytedance.ms.xr.ka.c.ms(2L);
        com.bytedance.ms.xr.ka.ka.ms().ms(4500L, this.d);
        com.bytedance.ms.xr.ka.ka.ms().ms(5000L, this, 40, 5000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        if (this.ah) {
            return;
        }
        if (xr()) {
            i = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i = 100;
        }
        if (this.xr.ms(i, str, 25)) {
            this.ah = true;
        }
    }

    private long ms() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean xr() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }
}
