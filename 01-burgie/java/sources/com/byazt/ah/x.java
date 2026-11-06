package com.byazt.ah;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1023, 121})
public class x implements Runnable {
    public final hn hw;
    public volatile boolean hn = false;
    public Runnable x = new Runnable() { // from class: com.byazt.ah.x.1
        @Override // java.lang.Runnable
        public void run() {
            x.this.hn = false;
        }
    };
    public long pr = pr();

    public x(hn hnVar) {
        this.hw = hnVar;
        com.byazt.sds.uc.pr(2L);
        com.byazt.sds.c.pr().pr(4500L, this.x);
        com.byazt.sds.c.pr().pr(5000L, this, 40, 5000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        if (!this.hn) {
            if (!hw()) {
                str = null;
                i = 100;
            } else {
                i = 200;
                str = "/data/anr/traces.txt";
            }
            if (this.hw.pr(i, str, 25)) {
                this.hn = true;
            }
        }
    }

    private long pr() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean hw() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }
}
