package com.byazt.ca;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 730, 26})
public class qg extends com.byazt.nf.s.n {
    public Handler n = new Handler(Looper.getMainLooper());
    public com.byazt.af.n.InterfaceC0121n qg;

    public qg(com.byazt.af.n.InterfaceC0121n interfaceC0121n) {
        this.qg = interfaceC0121n;
    }

    @Override // com.byazt.nf.s
    public void n() throws RemoteException {
        n(new Runnable() { // from class: com.byazt.ca.qg.1
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.qg != null) {
                    qg.this.qg.n();
                }
            }
        });
    }

    @Override // com.byazt.nf.s
    public void n(final String str) throws RemoteException {
        n(new Runnable() { // from class: com.byazt.ca.qg.2
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.qg != null) {
                    qg.this.qg.n(str);
                }
            }
        });
    }

    private void n(Runnable runnable) {
        if (this.n == null) {
            this.n = new Handler(Looper.getMainLooper());
        }
        this.n.post(runnable);
    }
}
