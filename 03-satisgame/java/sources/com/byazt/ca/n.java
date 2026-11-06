package com.byazt.ca;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 730, 19})
public class n extends com.byazt.nf.qg.n {
    public Handler n = new Handler(Looper.getMainLooper());
    public com.byazt.okk.n.InterfaceC0282n qg;

    public n(com.byazt.okk.n.InterfaceC0282n interfaceC0282n) {
        this.qg = interfaceC0282n;
    }

    @Override // com.byazt.nf.qg
    public void n() throws RemoteException {
        n(new Runnable() { // from class: com.byazt.ca.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.qg != null) {
                    n.this.qg.n();
                }
            }
        });
    }

    @Override // com.byazt.nf.qg
    public void qg() throws RemoteException {
        n(new Runnable() { // from class: com.byazt.ca.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.qg != null) {
                    n.this.qg.qg();
                }
            }
        });
    }

    @Override // com.byazt.nf.qg
    public void s() throws RemoteException {
        n(new Runnable() { // from class: com.byazt.ca.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.qg != null) {
                    n.this.qg.s();
                }
            }
        });
    }

    private void n(Runnable runnable) {
        this.n.post(runnable);
    }
}
