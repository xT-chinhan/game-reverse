package com.tapsdk.tapad.oaid.huawei;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class HuaweiA implements ServiceConnection {
    public static final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    boolean b = false;
    private final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1);

    public IBinder a() {
        if (this.b) {
            throw new IllegalStateException();
        }
        this.b = true;
        return this.c.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        a.execute(new Runnable(this, iBinder) { // from class: com.tapsdk.tapad.oaid.huawei.HuaweiA$HuaweiA$1
            final IBinder a;
            final HuaweiA b;

            {
                this.b = this;
                this.a = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    System.currentTimeMillis();
                    HuaweiA.a(this.b).offer(this.a);
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        System.currentTimeMillis();
    }

    public static LinkedBlockingQueue a(HuaweiA huaweiA) {
        return huaweiA.c;
    }
}
