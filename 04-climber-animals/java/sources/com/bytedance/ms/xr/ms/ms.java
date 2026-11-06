package com.bytedance.ms.xr.ms;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends FileObserver {
    private volatile boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ah f586ms;
    private final int xr;

    public ms(ah ahVar, String str, int i) {
        super(str, i);
        this.xr = 5000;
        this.ah = true;
        if (ahVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.f586ms = ahVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.ah && i == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.f586ms != null) {
            this.ah = false;
            this.f586ms.ms(200, "/data/anr/".concat(String.valueOf(str)), 80);
            new C0217ms(5000).start();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ms.xr.ms.ms$ms, reason: collision with other inner class name */
    private final class C0217ms extends com.bytedance.sdk.component.ch.d.ah {
        private int xr;

        C0217ms(int i) {
            super("ANRFileObserver$RestartMonitorThread");
            this.xr = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.xr);
            ms.this.ah = true;
        }
    }
}
