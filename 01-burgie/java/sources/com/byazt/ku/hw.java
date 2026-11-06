package com.byazt.ku;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.sd.k;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 67, 13})
public class hw extends k.pr {
    public com.byazt.wt.uc.pr hw;
    public Handler pr = new Handler(Looper.getMainLooper());

    public hw(com.byazt.wt.uc.pr prVar) {
        this.hw = prVar;
    }

    @Override // com.byazt.sd.k
    public void pr() throws RemoteException {
        pr(new Runnable() { // from class: com.byazt.ku.hw.1
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.hw != null) {
                    hw.this.hw.pr();
                }
            }
        });
    }

    @Override // com.byazt.sd.k
    public void pr(final String str) throws RemoteException {
        pr(new Runnable() { // from class: com.byazt.ku.hw.2
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.hw != null) {
                    hw.this.hw.pr(str);
                }
            }
        });
    }

    private void pr(Runnable runnable) {
        if (this.pr == null) {
            this.pr = new Handler(Looper.getMainLooper());
        }
        this.pr.post(runnable);
    }
}
