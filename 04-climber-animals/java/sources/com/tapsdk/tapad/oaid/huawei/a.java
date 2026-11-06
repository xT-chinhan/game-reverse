package com.tapsdk.tapad.oaid.huawei;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ServiceConnection {
    public static final ThreadPoolExecutor c = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    boolean a = false;
    private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    /* JADX INFO: renamed from: com.tapsdk.tapad.oaid.huawei.a$a, reason: collision with other inner class name */
    static class RunnableC0645a implements Runnable {
        final IBinder a;
        final a b;

        RunnableC0645a(a aVar, IBinder iBinder) {
            this.b = aVar;
            this.a = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
                a.a(this.b).offer(this.a);
            } catch (Throwable th) {
                Log.w("PPSSerivceConnection", "onServiceConnected  " + th.getClass().getSimpleName());
            }
        }
    }

    static LinkedBlockingQueue a(a aVar) {
        return aVar.b;
    }

    public IBinder a() throws InterruptedException {
        if (this.a) {
            throw new IllegalStateException();
        }
        this.a = true;
        return this.b.take();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d("PPSSerivceConnection", "onServiceConnected");
        c.execute(new RunnableC0645a(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
