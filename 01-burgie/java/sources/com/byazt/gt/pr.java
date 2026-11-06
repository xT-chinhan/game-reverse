package com.byazt.gt;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.byazt.ca.ho;
import com.byazt.sd.vk;
import com.byazt.us.c;
import com.byazt.us.fw;
import com.byazt.us.hn;
import com.byazt.us.hw;
import com.byazt.us.uc;
import com.byazt.us.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 37})
public class pr {
    public static volatile pr hn;
    public vk hw;
    public Context pr;
    public CountDownLatch x;
    public final Object c = new Object();
    public long uc = 0;
    public ServiceConnection fw = new ServiceConnection() { // from class: com.byazt.gt.pr.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pr.this.hw = vk.pr.pr(iBinder);
            try {
                pr.this.hw.asBinder().linkToDeath(pr.this.zo, 0);
            } catch (RemoteException e) {
                ho.pr("MultiProcess", "onServiceConnected throws :", e);
            }
            pr.this.x.countDown();
            System.currentTimeMillis();
            long unused = pr.this.uc;
        }
    };
    public IBinder.DeathRecipient zo = new IBinder.DeathRecipient() { // from class: com.byazt.gt.pr.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            pr.this.hw.asBinder().unlinkToDeath(pr.this.zo, 0);
            pr.this.hw = null;
            pr.this.pr();
        }
    };

    private pr(Context context) {
        this.pr = context.getApplicationContext();
        pr();
    }

    public static pr pr(Context context) {
        if (hn == null) {
            synchronized (pr.class) {
                if (hn == null) {
                    hn = new pr(context);
                }
            }
        }
        return hn;
    }

    public IBinder pr(int i) {
        try {
            vk vkVar = this.hw;
            if (vkVar == null) {
                return null;
            }
            return vkVar.pr(i);
        } catch (RemoteException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pr() {
        this.x = new CountDownLatch(1);
        try {
            this.pr.bindService(new Intent(this.pr, (Class<?>) BinderPoolService.class), this.fw, 1);
            this.uc = System.currentTimeMillis();
            this.x.await();
        } catch (Exception e) {
            ho.pr("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }

    /* JADX INFO: renamed from: com.byazt.gt.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class BinderC0079pr extends vk.pr {
        @Override // com.byazt.sd.vk
        public IBinder pr(int i) throws RemoteException {
            switch (i) {
                case 0:
                    return fw.hw();
                case 1:
                    return c.hw();
                case 2:
                    return hn.hw();
                case 3:
                    return hw.hw();
                case 4:
                    return x.hw();
                case 5:
                    return uc.hw();
                default:
                    return null;
            }
        }
    }
}
