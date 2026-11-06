package com.ss.android.socialbase.downloader.xr;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.anythink.basead.exoplayer.i.a;
import com.ss.android.socialbase.downloader.c.ny;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class c implements ServiceConnection, t {
    private static int ah;
    private static long d;
    private static boolean xr;
    private com.ss.android.socialbase.downloader.downloader.ah.ms.InterfaceC0564ms ab;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f4806ms;
    private Future<?> ny;
    private Handler ka = new Handler(Looper.getMainLooper());
    private xr c = null;
    private Runnable x = new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.xr || c.this.ab == null) {
                return;
            }
            c.this.ab.ms();
        }
    };
    private CountDownLatch ch = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ab() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public ArrayList<ny> u(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ms(int i, Map<Long, ny> map) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public Map<Long, ny> sl(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void zb(int i) {
    }

    public c() {
        SqlDownloadCacheService.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), this);
    }

    public void ms(com.ss.android.socialbase.downloader.downloader.ah.ms.InterfaceC0564ms interfaceC0564ms) {
        this.ab = interfaceC0564ms;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        xr = true;
        this.ka.removeCallbacks(this.x);
        try {
            this.f4806ms = ah.ms.ms(iBinder);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        this.ny = com.ss.android.socialbase.downloader.downloader.ah.sl().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.c.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (c.this.c != null && c.this.f4806ms != null) {
                                c.this.f4806ms.ms(c.this.c);
                            }
                            c.this.ch.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.xr.c.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = c.xr = false;
                                    if (c.this.ab() || c.this.ab == null) {
                                        return;
                                    }
                                    c.this.ka.postDelayed(c.this.x, a.f);
                                }
                            };
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th2) {
                        try {
                            com.ss.android.socialbase.downloader.ah.ms.xr("SqlDownloadCacheAidlWra", "onServiceConnected fail", th2);
                            if (c.this.ab != null) {
                                c.this.ab.ms();
                            }
                            c.this.ch.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.xr.c.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = c.xr = false;
                                    if (c.this.ab() || c.this.ab == null) {
                                        return;
                                    }
                                    c.this.ka.postDelayed(c.this.x, a.f);
                                }
                            };
                        } catch (Throwable th3) {
                            c.this.ch.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.xr.c.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused2 = c.xr = false;
                                        if (c.this.ab() || c.this.ab == null) {
                                            return;
                                        }
                                        c.this.ka.postDelayed(c.this.x, a.f);
                                    }
                                }, 0);
                            } catch (Throwable unused2) {
                            }
                            throw th3;
                        }
                    }
                    iBinder2.linkToDeath(deathRecipient, 0);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f4806ms = null;
        xr = false;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.xr.c$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCacheService.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), c.this);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ms(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.xr>> sparseArray2, final d dVar) {
        com.ss.android.socialbase.downloader.downloader.ah.sl().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.xr.c.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                d dVar2;
                Future future;
                c.this.ms(new xr.ms() { // from class: com.ss.android.socialbase.downloader.xr.c.4.1
                    @Override // com.ss.android.socialbase.downloader.xr.xr
                    public void ms(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.ny.c.ms(sparseArray, map);
                        com.ss.android.socialbase.downloader.ny.c.ms(sparseArray2, map2);
                        dVar.ms();
                        c.this.ms((xr) null);
                    }
                });
                try {
                    z = !c.this.ch.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    z = false;
                }
                if (z && (future = c.this.ny) != null) {
                    future.cancel(true);
                }
                c.this.ms();
                if (!z || (dVar2 = dVar) == null) {
                    return;
                }
                dVar2.ms();
            }
        });
    }

    public void ms(xr xrVar) {
        synchronized (this) {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                try {
                    ahVar.ms(xrVar);
                } catch (RemoteException e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            } else {
                this.c = xrVar;
            }
        }
    }

    public void ms() {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.ms();
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo xr(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.xr(i);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> ms(String str) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ms(str);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> xr(String str) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.xr(str);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> ah(String str) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ah(str);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> d(String str) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.d(str);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<DownloadInfo> xr() {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.xr();
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public List<com.ss.android.socialbase.downloader.model.xr> ah(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ah(i);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void d(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.d(i);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(com.ss.android.socialbase.downloader.model.xr xrVar) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.ms(xrVar);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(com.ss.android.socialbase.downloader.model.xr xrVar) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.xr(xrVar);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, int i2, long j) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.ms(i, i2, j);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, int i2, int i3, long j) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.ms(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, int i2, int i3, int i4) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.ms(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ms(int i, int i2) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ms(i, i2);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ms(DownloadInfo downloadInfo) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ms(downloadInfo);
            }
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ka(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ka(i);
            }
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean c(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.c(i);
            }
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ah() {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.ah();
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ab(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ab(i);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ms(int i, long j, String str, String str2) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ms(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ms(int i, long j) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ms(i, j);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo xr(int i, long j) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.xr(i, j);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo x(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.x(i);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ah(int i, long j) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ah(i, j);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo d(int i, long j) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.d(i, j);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ny(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ny(i);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public DownloadInfo ch(int i) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ch(i);
            }
            return null;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean d() {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.d();
            }
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public boolean ka() {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                return ahVar.ka();
            }
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(DownloadInfo downloadInfo) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.xr(downloadInfo);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void ms(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.ms(i, list);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ch
    public void xr(int i, List<com.ss.android.socialbase.downloader.model.xr> list) {
        try {
            ah ahVar = this.f4806ms;
            if (ahVar != null) {
                ahVar.xr(i, list);
            }
        } catch (RemoteException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }
}
