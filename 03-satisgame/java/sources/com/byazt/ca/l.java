package com.byazt.ca;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.nf.x;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 730, 18})
public class l extends x.n {
    public com.byazt.tmn.n n;
    public Handler qg = new Handler(Looper.getMainLooper());

    public l(com.byazt.tmn.n nVar) {
        this.n = nVar;
    }

    private void w() {
        this.n = null;
        this.qg = null;
    }

    private Handler x() {
        Handler handler = this.qg;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.qg = handler2;
        return handler2;
    }

    @Override // com.byazt.nf.x
    public void n() throws RemoteException {
        w();
    }

    @Override // com.byazt.nf.x
    public void n(final Bundle bundle) throws RemoteException {
        x().post(new Runnable() { // from class: com.byazt.ca.l.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tmn.n nVar = l.this.n;
                if (nVar != null) {
                    nVar.n(bundle);
                }
            }
        });
    }

    @Override // com.byazt.nf.x
    public void qg(final Bundle bundle) throws RemoteException {
        x().post(new Runnable() { // from class: com.byazt.ca.l.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tmn.n nVar = l.this.n;
                if (nVar != null) {
                    nVar.qg(bundle);
                }
            }
        });
    }

    @Override // com.byazt.nf.x
    public void s(final Bundle bundle) throws RemoteException {
        x().post(new Runnable() { // from class: com.byazt.ca.l.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tmn.n nVar = l.this.n;
                if (nVar != null) {
                    nVar.s(bundle);
                }
            }
        });
    }

    @Override // com.byazt.nf.x
    public void qg() throws RemoteException {
        x().post(new Runnable() { // from class: com.byazt.ca.l.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tmn.n nVar = l.this.n;
                if (nVar != null) {
                    nVar.n();
                }
            }
        });
    }

    @Override // com.byazt.nf.x
    public void s() throws RemoteException {
        x().post(new Runnable() { // from class: com.byazt.ca.l.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tmn.n nVar = l.this.n;
                if (nVar != null) {
                    nVar.qg();
                }
            }
        });
    }

    @Override // com.byazt.nf.x
    public void q() throws RemoteException {
        x().post(new Runnable() { // from class: com.byazt.ca.l.6
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tmn.n nVar = l.this.n;
                if (nVar != null) {
                    nVar.s();
                }
            }
        });
    }

    @Override // com.byazt.nf.x
    public void n(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        x().post(new Runnable() { // from class: com.byazt.ca.l.7
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tmn.n nVar = l.this.n;
                if (nVar != null) {
                    nVar.n(z, i, str, i2, str2);
                }
            }
        });
    }

    @Override // com.byazt.nf.x
    public void n(final boolean z, final int i, final Bundle bundle) {
        x().post(new Runnable() { // from class: com.byazt.ca.l.8
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.tmn.n nVar = l.this.n;
                if (nVar != null) {
                    try {
                        nVar.n(z, i, bundle);
                    } catch (AbstractMethodError unused) {
                        k.qg("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                    }
                }
            }
        });
    }
}
