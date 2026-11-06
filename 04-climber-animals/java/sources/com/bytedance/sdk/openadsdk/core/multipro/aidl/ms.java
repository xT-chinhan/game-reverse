package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ab;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ah;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.c;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.d;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ka;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.xr;
import com.bytedance.sdk.openadsdk.core.sl;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static volatile ms ah;
    private CountDownLatch d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f2885ms;
    private sl xr;
    private final Object ka = new Object();
    private long c = 0;
    private ServiceConnection ab = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.bytedance.sdk.component.utils.sl.ms("MultiProcess", "BinderPool......onServiceDisconnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ms.this.xr = sl.ms.ms(iBinder);
            try {
                ms.this.xr.asBinder().linkToDeath(ms.this.x, 0);
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.sl.ah("MultiProcess", "onServiceConnected throws :", e);
            }
            ms.this.d.countDown();
            System.currentTimeMillis();
            long unused = ms.this.c;
        }
    };
    private IBinder.DeathRecipient x = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            com.bytedance.sdk.component.utils.sl.xr("MultiProcess", "binder died.");
            ms.this.xr.asBinder().unlinkToDeath(ms.this.x, 0);
            ms.this.xr = null;
            ms.this.ms();
        }
    };

    private ms(Context context) {
        this.f2885ms = context.getApplicationContext();
        ms();
    }

    public static ms ms(Context context) {
        if (ah == null) {
            synchronized (ms.class) {
                if (ah == null) {
                    ah = new ms(context);
                }
            }
        }
        return ah;
    }

    public IBinder ms(int i) {
        try {
            sl slVar = this.xr;
            if (slVar != null) {
                return slVar.ms(i);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ms() {
        com.bytedance.sdk.component.utils.sl.ms("MultiProcess", "BinderPool......connectBinderPoolService");
        this.d = new CountDownLatch(1);
        try {
            this.f2885ms.bindService(new Intent(this.f2885ms, (Class<?>) BinderPoolService.class), this.ab, 1);
            this.c = System.currentTimeMillis();
            this.d.await();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ah("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.multipro.aidl.ms$ms, reason: collision with other inner class name */
    public static class BinderC0295ms extends sl.ms {
        @Override // com.bytedance.sdk.openadsdk.core.sl
        public IBinder ms(int i) throws RemoteException {
            if (i == 0) {
                return ab.xr();
            }
            if (i == 1) {
                return ka.xr();
            }
            if (i == 2) {
                return ah.xr();
            }
            if (i == 3) {
                return xr.xr();
            }
            if (i == 4) {
                return d.xr();
            }
            if (i != 5) {
                return null;
            }
            return c.xr();
        }
    }
}
