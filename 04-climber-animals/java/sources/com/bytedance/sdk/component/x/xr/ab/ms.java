package com.bytedance.sdk.component.x.xr.ab;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.x.ms.ka;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static int ah = 3000;
    private static volatile ms d;
    private Looper ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile HandlerThread f1545ms;
    private volatile Handler xr = null;

    public static ms ms(ka kaVar) {
        if (d == null) {
            synchronized (ms.class) {
                if (d == null) {
                    d = new ms(kaVar);
                }
            }
        }
        return d;
    }

    private ms(ka kaVar) {
        this.f1545ms = null;
        this.ka = null;
        if (kaVar == null || kaVar.d() == null || kaVar.d().xr() == null) {
            this.f1545ms = new HandlerThread("csj_ad_log", 10);
            this.f1545ms.start();
        } else {
            this.ka = kaVar.d().xr();
        }
    }

    public Handler ms() {
        if (this.ka != null) {
            if (this.xr == null) {
                synchronized (ms.class) {
                    if (this.xr == null) {
                        this.xr = new Handler(this.ka);
                    }
                }
            }
        } else if (this.f1545ms == null || !this.f1545ms.isAlive()) {
            synchronized (ms.class) {
                if (this.f1545ms == null || !this.f1545ms.isAlive()) {
                    this.f1545ms = new HandlerThread("csj_init_handle", -1);
                    this.f1545ms.start();
                    this.xr = new Handler(this.f1545ms.getLooper());
                }
            }
        } else if (this.xr == null) {
            synchronized (ms.class) {
                if (this.xr == null) {
                    this.xr = new Handler(this.f1545ms.getLooper());
                }
            }
        }
        return this.xr;
    }

    public int xr() {
        if (ah <= 0) {
            ah = 3000;
        }
        return ah;
    }
}
