package com.byazt.ca;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 730, 8})
public class s extends com.byazt.nf.q.n {
    public com.byazt.rzx.n n;
    public Handler qg = new Handler(Looper.getMainLooper());

    public s(com.byazt.rzx.n nVar) {
        this.n = nVar;
    }

    private void l() {
        this.n = null;
        this.qg = null;
    }

    private Handler w() {
        Handler handler = this.qg;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.qg = handler2;
        return handler2;
    }

    @Override // com.byazt.nf.q
    public void n() throws RemoteException {
        l();
    }

    @Override // com.byazt.nf.q
    public void n(final Bundle bundle) throws RemoteException {
        w().post(new Runnable() { // from class: com.byazt.ca.s.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rzx.n nVar = s.this.n;
                if (nVar != null) {
                    nVar.n(bundle);
                }
            }
        });
    }

    @Override // com.byazt.nf.q
    public void qg(final Bundle bundle) throws RemoteException {
        w().post(new Runnable() { // from class: com.byazt.ca.s.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rzx.n nVar = s.this.n;
                if (nVar != null) {
                    nVar.qg(bundle);
                }
            }
        });
    }

    @Override // com.byazt.nf.q
    public void s(final Bundle bundle) throws RemoteException {
        w().post(new Runnable() { // from class: com.byazt.ca.s.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rzx.n nVar = s.this.n;
                if (nVar != null) {
                    nVar.s(bundle);
                }
            }
        });
    }

    @Override // com.byazt.nf.q
    public void qg() throws RemoteException {
        w().post(new Runnable() { // from class: com.byazt.ca.s.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rzx.n nVar = s.this.n;
                if (nVar != null) {
                    nVar.n();
                }
            }
        });
    }

    @Override // com.byazt.nf.q
    public void s() throws RemoteException {
        w().post(new Runnable() { // from class: com.byazt.ca.s.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rzx.n nVar = s.this.n;
                if (nVar != null) {
                    nVar.qg();
                }
            }
        });
    }
}
