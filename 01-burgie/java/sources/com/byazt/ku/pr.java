package com.byazt.ku;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.sd.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 67, 37})
public class pr extends w.pr {
    public com.byazt.wt.c.pr hw;
    public Handler pr = new Handler(Looper.getMainLooper());

    public pr(com.byazt.wt.c.pr prVar) {
        this.hw = prVar;
    }

    @Override // com.byazt.sd.w
    public void pr() throws RemoteException {
        pr(new Runnable() { // from class: com.byazt.ku.pr.1
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.hw != null) {
                    pr.this.hw.pr();
                }
            }
        });
    }

    @Override // com.byazt.sd.w
    public void hw() throws RemoteException {
        pr(new Runnable() { // from class: com.byazt.ku.pr.2
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.hw != null) {
                    pr.this.hw.hw();
                }
            }
        });
    }

    @Override // com.byazt.sd.w
    public void hn() throws RemoteException {
        pr(new Runnable() { // from class: com.byazt.ku.pr.3
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.hw != null) {
                    pr.this.hw.hn();
                }
            }
        });
    }

    private void pr(Runnable runnable) {
        this.pr.post(runnable);
    }
}
