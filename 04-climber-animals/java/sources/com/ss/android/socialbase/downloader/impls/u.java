package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class u extends com.ss.android.socialbase.downloader.downloader.ms implements ServiceConnection {
    private static final String ka = "u";
    private com.ss.android.socialbase.downloader.downloader.u ab;
    private com.ss.android.socialbase.downloader.downloader.ny c;
    private int x = -1;

    @Override // com.ss.android.socialbase.downloader.downloader.ms
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.ah.ms.xr(ka, "bindService");
            Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.ny.c.ms()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.ah.ms.xr(ka, "stopService");
        this.xr = false;
        Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms, com.ss.android.socialbase.downloader.downloader.ub
    public IBinder ms(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.bytedance.sdk.openadsdk.api.ab.d(ka, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.ab.ms.ms("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(ka, "onBind IndependentDownloadBinder");
        return new zb();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms, com.ss.android.socialbase.downloader.downloader.ub
    public void xr(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(ka, "tryDownload aidlService == null:" + (this.c == null));
        if (this.c == null) {
            ms(downloadTask);
            startService(com.ss.android.socialbase.downloader.downloader.ah.k(), this);
            return;
        }
        ab();
        try {
            this.c.ms(com.ss.android.socialbase.downloader.ny.ab.ms(downloadTask));
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    private void ab() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        try {
            synchronized (this.f4666ms) {
                sparseArrayClone = this.f4666ms.clone();
                this.f4666ms.clear();
            }
            if (sparseArrayClone == null || sparseArrayClone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.ah.g() == null) {
                return;
            }
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.c.ms(com.ss.android.socialbase.downloader.ny.ab.ms(it.next()));
                        } catch (RemoteException e) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.ah.ms.xr(ka, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms, com.ss.android.socialbase.downloader.downloader.ub
    public void ah(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.d.ms().ms(downloadTask.getDownloadId(), true);
        ms msVarG = com.ss.android.socialbase.downloader.downloader.ah.g();
        if (msVarG != null) {
            msVarG.ms(downloadTask);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = ka;
        com.ss.android.socialbase.downloader.ah.ms.xr(str, "onServiceConnected ");
        this.c = com.ss.android.socialbase.downloader.downloader.ny.ms.ms(iBinder);
        com.ss.android.socialbase.downloader.downloader.u uVar = this.ab;
        if (uVar != null) {
            uVar.ms(iBinder);
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(str, "onServiceConnected aidlService!=null" + (this.c != null) + " pendingTasks.size:" + this.f4666ms.size());
        if (this.c != null) {
            com.ss.android.socialbase.downloader.downloader.d.ms().xr();
            this.xr = true;
            this.d = false;
            int i = this.x;
            if (i != -1) {
                try {
                    this.c.sl(i);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            }
            if (this.c != null) {
                ab();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.ah.ms.xr(ka, "onServiceDisconnected ");
        this.c = null;
        this.xr = false;
        com.ss.android.socialbase.downloader.downloader.u uVar = this.ab;
        if (uVar != null) {
            uVar.x();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.c = null;
        com.ss.android.socialbase.downloader.downloader.u uVar = this.ab;
        if (uVar != null) {
            uVar.x();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms, com.ss.android.socialbase.downloader.downloader.ub
    public void ms(com.ss.android.socialbase.downloader.downloader.u uVar) {
        this.ab = uVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms, com.ss.android.socialbase.downloader.downloader.ub
    public void ms(int i) {
        com.ss.android.socialbase.downloader.downloader.ny nyVar = this.c;
        if (nyVar == null) {
            this.x = i;
            return;
        }
        try {
            nyVar.sl(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ms, com.ss.android.socialbase.downloader.downloader.ub
    public void startService() {
        if (this.c == null) {
            startService(com.ss.android.socialbase.downloader.downloader.ah.k(), this);
        }
    }
}
