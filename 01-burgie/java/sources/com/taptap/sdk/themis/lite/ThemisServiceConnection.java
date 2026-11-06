package com.taptap.sdk.themis.lite;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class ThemisServiceConnection implements ServiceConnection {
    public static final LinkedBlockingQueue<IBinder> BINDER_QUEUE = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, final IBinder service) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.taptap.sdk.themis.lite.ThemisServiceConnection.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!ThemisServiceConnection.BINDER_QUEUE.isEmpty()) {
                        ThemisServiceConnection.BINDER_QUEUE.clear();
                    }
                    ThemisServiceConnection.BINDER_QUEUE.put(service);
                } catch (InterruptedException e) {
                    LogUtil.info(Base64Util.decode("VGhlbWlzU2VydmljZUNvbm5lY3Rpb246") + e.toString());
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
    }
}
