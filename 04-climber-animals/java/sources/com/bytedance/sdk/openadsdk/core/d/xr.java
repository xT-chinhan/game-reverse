package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.ch;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private long ah;
    private Runnable d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f2459ms = 10000;
    private String xr;

    public xr(String str) {
        this.xr = str;
    }

    public xr ms(int i) {
        this.f2459ms = i <= 0 ? 10000 : i * 1000;
        return this;
    }

    public xr ms(Runnable runnable) {
        this.d = runnable;
        return this;
    }

    public void xr(final Runnable runnable) {
        this.ah = System.currentTimeMillis();
        if (!ms.ka()) {
            xr(1);
            ah(runnable);
        } else if (ch.ub().cv()) {
            xr(2);
            ms();
        } else if (!ms.ms()) {
            xr(1);
            ah(runnable);
        } else {
            x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.d.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ch.ub().cv()) {
                        xr.this.xr(2);
                        xr.this.ms();
                    } else {
                        xr.this.xr(1);
                        xr.this.ah(runnable);
                    }
                }
            }, this.f2459ms);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms() {
        Runnable runnable = this.d;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i) {
        StringBuilder sb = new StringBuilder(">> tk: ");
        sb.append(this.xr).append(i == 1 ? " run" : " cancel").append(", isBst: true, tmgap: ").append((System.currentTimeMillis() - this.ah) / 1000);
        if (i == 1) {
            sl.ms("bstsdk", sb.toString());
        } else {
            sl.xr("bstsdk", sb.toString());
        }
    }
}
