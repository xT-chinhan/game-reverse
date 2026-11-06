package com.byazt.ku;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.byazt.ca.ho;
import com.byazt.sd.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 67, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends nt.pr {
    public Handler hw = new Handler(Looper.getMainLooper());
    public com.byazt.yg.pr pr;

    public c(com.byazt.yg.pr prVar) {
        this.pr = prVar;
    }

    private void uc() {
        this.pr = null;
        this.hw = null;
    }

    private Handler fw() {
        Handler handler = this.hw;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.hw = handler2;
        return handler2;
    }

    @Override // com.byazt.sd.nt
    public void pr() throws RemoteException {
        uc();
    }

    @Override // com.byazt.sd.nt
    public void pr(final Bundle bundle) throws RemoteException {
        fw().post(new Runnable() { // from class: com.byazt.ku.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yg.pr prVar = c.this.pr;
                if (prVar != null) {
                    prVar.pr(bundle);
                }
            }
        });
    }

    @Override // com.byazt.sd.nt
    public void hw(final Bundle bundle) throws RemoteException {
        fw().post(new Runnable() { // from class: com.byazt.ku.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yg.pr prVar = c.this.pr;
                if (prVar != null) {
                    prVar.hw(bundle);
                }
            }
        });
    }

    @Override // com.byazt.sd.nt
    public void hn(final Bundle bundle) throws RemoteException {
        fw().post(new Runnable() { // from class: com.byazt.ku.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yg.pr prVar = c.this.pr;
                if (prVar != null) {
                    prVar.hn(bundle);
                }
            }
        });
    }

    @Override // com.byazt.sd.nt
    public void hw() throws RemoteException {
        fw().post(new Runnable() { // from class: com.byazt.ku.c.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yg.pr prVar = c.this.pr;
                if (prVar != null) {
                    prVar.pr();
                }
            }
        });
    }

    @Override // com.byazt.sd.nt
    public void hn() throws RemoteException {
        fw().post(new Runnable() { // from class: com.byazt.ku.c.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yg.pr prVar = c.this.pr;
                if (prVar != null) {
                    prVar.hw();
                }
            }
        });
    }

    @Override // com.byazt.sd.nt
    public void x() throws RemoteException {
        fw().post(new Runnable() { // from class: com.byazt.ku.c.6
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yg.pr prVar = c.this.pr;
                if (prVar != null) {
                    prVar.hn();
                }
            }
        });
    }

    @Override // com.byazt.sd.nt
    public void pr(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        fw().post(new Runnable() { // from class: com.byazt.ku.c.7
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yg.pr prVar = c.this.pr;
                if (prVar != null) {
                    prVar.pr(z, i, str, i2, str2);
                }
            }
        });
    }

    @Override // com.byazt.sd.nt
    public void pr(final boolean z, final int i, final Bundle bundle) {
        fw().post(new Runnable() { // from class: com.byazt.ku.c.8
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.yg.pr prVar = c.this.pr;
                if (prVar != null) {
                    try {
                        prVar.pr(z, i, bundle);
                    } catch (AbstractMethodError e) {
                        ho.hw("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                    }
                }
            }
        });
    }
}
