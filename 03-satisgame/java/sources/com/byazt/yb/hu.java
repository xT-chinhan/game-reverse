package com.byazt.yb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 793})
public final class hu<Service, Result> {
    public final CountDownLatch n = new CountDownLatch(1);
    public final Context q;
    public final Intent qg;
    public final qg<Service, Result> s;

    interface qg<T, Result> {
        Result n(T t) throws Exception;

        T qg(IBinder iBinder);
    }

    public hu(Context context, Intent intent, qg<Service, Result> qgVar) {
        this.q = context;
        this.qg = intent;
        this.s = qgVar;
    }

    public Result n() {
        hu<Service, Result>.n nVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.km.cp.s("Don't do this in ui thread.", null);
            return null;
        }
        try {
            nVar = new n(this.n, this.s);
            this.q.bindService(this.qg, nVar, 1);
            this.n.await();
            try {
                Result resultN = this.s.n(nVar.n);
                n(nVar);
                return resultN;
            } catch (Throwable th) {
                th = th;
                try {
                    com.byazt.km.cp.n(th);
                    return null;
                } finally {
                    n(nVar);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            nVar = null;
        }
    }

    private void n(hu<Service, Result>.n nVar) {
        if (nVar != null) {
            try {
                this.q.unbindService(nVar);
            } catch (Throwable th) {
                com.byazt.km.cp.n(th);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES})
    class n implements ServiceConnection {
        public Service n;
        public final qg<Service, Result> q;
        public final CountDownLatch s;

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        public n(CountDownLatch countDownLatch, qg<Service, Result> qgVar) {
            this.s = countDownLatch;
            this.q = qgVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.byazt.km.cp.n("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                this.n = this.q.qg(iBinder);
                try {
                    this.s.countDown();
                } catch (Exception e) {
                    com.byazt.km.cp.n(e);
                }
            } catch (Throwable th) {
                try {
                    com.byazt.km.cp.s("ServiceBlockBinder#onServiceConnected", th);
                } finally {
                    try {
                        this.s.countDown();
                    } catch (Exception e2) {
                        com.byazt.km.cp.n(e2);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.byazt.km.cp.n("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.s.countDown();
            } catch (Exception e) {
                com.byazt.km.cp.n(e);
            }
        }
    }
}
