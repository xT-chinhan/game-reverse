package com.byazt.prx;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.byazt.ptd.l;
import com.byazt.ptd.q;
import com.byazt.ptd.qg;
import com.byazt.ptd.s;
import com.byazt.ptd.w;
import com.byazt.ptd.x;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION, 19})
public class n {
    public static volatile n s;
    public Context n;
    public CountDownLatch q;
    public com.byazt.nf.n qg;
    public final Object l = new Object();
    public long w = 0;
    public ServiceConnection x = new ServiceConnection() { // from class: com.byazt.prx.n.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            n.this.qg = com.byazt.nf.n.AbstractBinderC0259n.n(iBinder);
            try {
                n.this.qg.asBinder().linkToDeath(n.this.fs, 0);
            } catch (RemoteException e) {
                k.n("MultiProcess", "onServiceConnected throws :", e);
            }
            n.this.q.countDown();
            System.currentTimeMillis();
            long unused = n.this.w;
        }
    };
    public IBinder.DeathRecipient fs = new IBinder.DeathRecipient() { // from class: com.byazt.prx.n.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            n.this.qg.asBinder().unlinkToDeath(n.this.fs, 0);
            n.this.qg = null;
            n.this.n();
        }
    };

    private n(Context context) {
        this.n = context.getApplicationContext();
        n();
    }

    public static n n(Context context) {
        if (s == null) {
            synchronized (n.class) {
                if (s == null) {
                    s = new n(context);
                }
            }
        }
        return s;
    }

    public IBinder n(int i) {
        try {
            com.byazt.nf.n nVar = this.qg;
            if (nVar != null) {
                return nVar.n(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n() {
        this.q = new CountDownLatch(1);
        try {
            this.n.bindService(new Intent(this.n, (Class<?>) BinderPoolService.class), this.x, 1);
            this.w = System.currentTimeMillis();
            this.q.await();
        } catch (Exception e) {
            k.n("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }

    /* JADX INFO: renamed from: com.byazt.prx.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class BinderC0306n extends com.byazt.nf.n.AbstractBinderC0259n {
        @Override // com.byazt.nf.n
        public IBinder n(int i) throws RemoteException {
            if (i == 0) {
                return x.qg();
            }
            if (i == 1) {
                return l.qg();
            }
            if (i == 2) {
                return s.qg();
            }
            if (i == 3) {
                return qg.qg();
            }
            if (i == 4) {
                return q.qg();
            }
            if (i != 5) {
                return null;
            }
            return w.qg();
        }
    }
}
