package com.byazt.ku;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.sd.m;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 67, 20})
public class hn extends m.pr {
    public Handler hw = new Handler(Looper.getMainLooper());
    public com.byazt.rf.pr pr;

    public hn(com.byazt.rf.pr prVar) {
        this.pr = prVar;
    }

    private void c() {
        this.pr = null;
        this.hw = null;
    }

    private Handler uc() {
        Handler handler = this.hw;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.hw = handler2;
        return handler2;
    }

    @Override // com.byazt.sd.m
    public void pr() throws RemoteException {
        c();
    }

    @Override // com.byazt.sd.m
    public void pr(final Bundle bundle) throws RemoteException {
        uc().post(new Runnable() { // from class: com.byazt.ku.hn.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rf.pr prVar = hn.this.pr;
                if (prVar != null) {
                    prVar.pr(bundle);
                }
            }
        });
    }

    @Override // com.byazt.sd.m
    public void hw(final Bundle bundle) throws RemoteException {
        uc().post(new Runnable() { // from class: com.byazt.ku.hn.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rf.pr prVar = hn.this.pr;
                if (prVar != null) {
                    prVar.hw(bundle);
                }
            }
        });
    }

    @Override // com.byazt.sd.m
    public void hn(final Bundle bundle) throws RemoteException {
        uc().post(new Runnable() { // from class: com.byazt.ku.hn.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rf.pr prVar = hn.this.pr;
                if (prVar != null) {
                    prVar.hn(bundle);
                }
            }
        });
    }

    @Override // com.byazt.sd.m
    public void hw() throws RemoteException {
        uc().post(new Runnable() { // from class: com.byazt.ku.hn.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rf.pr prVar = hn.this.pr;
                if (prVar != null) {
                    prVar.pr();
                }
            }
        });
    }

    @Override // com.byazt.sd.m
    public void hn() throws RemoteException {
        uc().post(new Runnable() { // from class: com.byazt.ku.hn.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.rf.pr prVar = hn.this.pr;
                if (prVar != null) {
                    prVar.hw();
                }
            }
        });
    }
}
