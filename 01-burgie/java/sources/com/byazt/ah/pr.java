package com.byazt.ah;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1023, 37})
public class pr extends FileObserver {
    public volatile boolean hn;
    public final int hw;
    public final hn pr;

    public pr(hn hnVar, String str, int i) {
        super(str, i);
        this.hw = 5000;
        this.hn = true;
        if (hnVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.pr = hnVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.hn && i == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.pr != null) {
            this.hn = false;
            this.pr.pr(200, "/data/anr/".concat(String.valueOf(str)), 80);
            getClass();
            new C0012pr(5000).start();
        }
    }

    /* JADX INFO: renamed from: com.byazt.ah.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1023, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private final class C0012pr extends com.byazt.fr.hn {
        public int hw;

        public C0012pr(int i) {
            super("ANRFileObserver$RestartMonitorThread");
            this.hw = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.hw);
            pr.this.hn = true;
        }
    }
}
