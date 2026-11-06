package com.byazt.ku;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.sd.yb;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 67, 5})
public class uc extends yb.pr {
    public Handler hw = new Handler(Looper.getMainLooper());
    public volatile com.byazt.nv.pr pr;

    private Handler x() {
        Handler handler = this.hw;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.hw = handler2;
        return handler2;
    }

    public uc(com.byazt.nv.pr prVar) {
        this.pr = prVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(com.byazt.nv.pr prVar) {
        if (prVar != null) {
            return true;
        }
        return false;
    }

    @Override // com.byazt.sd.yb
    public void pr() throws RemoteException {
        if (this.pr != null) {
            x().post(new Runnable() { // from class: com.byazt.ku.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.nv.pr prVar = uc.this.pr;
                    if (!uc.this.pr(prVar)) {
                        return;
                    }
                    prVar.pr();
                }
            });
        }
    }

    @Override // com.byazt.sd.yb
    public void pr(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.pr != null) {
            x().post(new Runnable() { // from class: com.byazt.ku.uc.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.nv.pr prVar = uc.this.pr;
                    if (!uc.this.pr(prVar)) {
                        return;
                    }
                    prVar.pr(j, j2, str, str2);
                }
            });
        }
    }

    @Override // com.byazt.sd.yb
    public void hw(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.pr != null) {
            x().post(new Runnable() { // from class: com.byazt.ku.uc.3
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.nv.pr prVar = uc.this.pr;
                    if (!uc.this.pr(prVar)) {
                        return;
                    }
                    prVar.hw(j, j2, str, str2);
                }
            });
        }
    }

    @Override // com.byazt.sd.yb
    public void hn(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.pr != null) {
            x().post(new Runnable() { // from class: com.byazt.ku.uc.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.nv.pr prVar = uc.this.pr;
                    if (!uc.this.pr(prVar)) {
                        return;
                    }
                    prVar.hn(j, j2, str, str2);
                }
            });
        }
    }

    @Override // com.byazt.sd.yb
    public void pr(final long j, final String str, final String str2) throws RemoteException {
        if (this.pr != null) {
            x().post(new Runnable() { // from class: com.byazt.ku.uc.5
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.nv.pr prVar = uc.this.pr;
                    if (!uc.this.pr(prVar)) {
                        return;
                    }
                    prVar.pr(j, str, str2);
                }
            });
        }
    }

    @Override // com.byazt.sd.yb
    public void pr(final String str, final String str2) throws RemoteException {
        if (this.pr != null) {
            x().post(new Runnable() { // from class: com.byazt.ku.uc.6
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.nv.pr prVar = uc.this.pr;
                    if (!uc.this.pr(prVar)) {
                        return;
                    }
                    String str3 = str;
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = str2;
                    prVar.pr(str3, str4 != null ? str4 : "");
                }
            });
        }
    }

    public void hn() {
        this.pr = null;
        this.hw = null;
    }
}
