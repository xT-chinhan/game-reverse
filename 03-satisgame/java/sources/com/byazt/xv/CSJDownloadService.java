package com.byazt.xv;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 966})
public class CSJDownloadService extends Service {
    public static final String qg = "CSJDownloadService";
    public k n;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        s.n(this);
        k kVarH = s.h();
        this.n = kVarH;
        kVarH.n(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.byazt.fe.n.qg(qg, "onBind downloadServiceHandler != null:" + (this.n != null));
        k kVar = this.n;
        if (kVar != null) {
            return kVar.n(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.byazt.fe.n.n()) {
            com.byazt.fe.n.qg(qg, "DownloadService onStartCommand");
        }
        this.n.s();
        ExecutorService executorServiceD = s.d();
        if (executorServiceD != null) {
            executorServiceD.execute(new Runnable() { // from class: com.byazt.xv.CSJDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CSJDownloadService.this.n != null) {
                        CSJDownloadService.this.n.n(intent, i, i2);
                    }
                }
            });
        }
        return s.tj() ? 2 : 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.byazt.fe.n.n()) {
            com.byazt.fe.n.qg(qg, "Service onDestroy");
        }
        k kVar = this.n;
        if (kVar != null) {
            kVar.q();
            this.n = null;
        }
        super.onDestroy();
    }
}
