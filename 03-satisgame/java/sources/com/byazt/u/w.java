package com.byazt.u;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.byazt.kl.rv;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.SqlDownloadCacheService;
import com.byazt.xv.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 745, 13})
public class w implements ServiceConnection, a {
    public static long q;
    public static boolean qg;
    public static int s;
    public s n;
    public Future<?> rv;
    public com.byazt.xv.s.n.InterfaceC0397n x;
    public Handler l = new Handler(Looper.getMainLooper());
    public qg w = null;
    public Runnable fs = new Runnable() { // from class: com.byazt.u.w.1
        @Override // java.lang.Runnable
        public void run() {
            if (w.qg || w.this.x == null) {
                return;
            }
            w.this.x.n();
        }
    };
    public CountDownLatch tj = new CountDownLatch(1);

    @Override // com.byazt.xv.tj
    public Map<Long, rv> d(int i) {
        return null;
    }

    @Override // com.byazt.xv.tj
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ArrayList<rv> sz(int i) {
        return null;
    }

    @Override // com.byazt.xv.tj
    public boolean n(int i, Map<Long, rv> map) {
        return false;
    }

    @Override // com.byazt.xv.tj
    public void oa(int i) {
    }

    public w() {
        SqlDownloadCacheService.n(com.byazt.xv.s.u(), this);
    }

    public void n(com.byazt.xv.s.n.InterfaceC0397n interfaceC0397n) {
        this.x = interfaceC0397n;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        qg = true;
        this.l.removeCallbacks(this.fs);
        try {
            this.n = s.n.n(iBinder);
        } catch (Throwable unused) {
        }
        this.rv = com.byazt.xv.s.d().submit(new Runnable() { // from class: com.byazt.u.w.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (w.this.w != null && w.this.n != null) {
                                w.this.n.n(w.this.w);
                            }
                            w.this.tj.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.byazt.u.w.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused2 = w.qg = false;
                                    if (w.this.x() || w.this.x == null) {
                                        return;
                                    }
                                    w.this.l.postDelayed(w.this.fs, 2000L);
                                }
                            };
                        } catch (Throwable unused2) {
                        }
                    } catch (Throwable th) {
                        try {
                            com.byazt.fe.n.qg("SqlDownloadCacheAidlWra", "onServiceConnected fail", th);
                            if (w.this.x != null) {
                                w.this.x.n();
                            }
                            w.this.tj.countDown();
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.byazt.u.w.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused3 = w.qg = false;
                                    if (w.this.x() || w.this.x == null) {
                                        return;
                                    }
                                    w.this.l.postDelayed(w.this.fs, 2000L);
                                }
                            };
                        } catch (Throwable th2) {
                            w.this.tj.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.byazt.u.w.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused3 = w.qg = false;
                                        if (w.this.x() || w.this.x == null) {
                                            return;
                                        }
                                        w.this.l.postDelayed(w.this.fs, 2000L);
                                    }
                                }, 0);
                            } catch (Throwable unused3) {
                            }
                            throw th2;
                        }
                    }
                    iBinder2.linkToDeath(deathRecipient, 0);
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.n = null;
        qg = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        if (Build.VERSION.SDK_INT >= 26 || qg) {
            return false;
        }
        if (s > 5) {
            com.byazt.fe.n.q("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - q < 15000) {
            com.byazt.fe.n.q("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        s++;
        q = jCurrentTimeMillis;
        this.l.postDelayed(new Runnable() { // from class: com.byazt.u.w.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.n(com.byazt.xv.s.u(), w.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.byazt.xv.a
    public void n(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.byazt.wm.qg>> sparseArray2, final q qVar) {
        com.byazt.xv.s.d().submit(new Runnable() { // from class: com.byazt.u.w.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                q qVar2;
                Future future;
                w.this.n(new qg.n() { // from class: com.byazt.u.w.4.1
                    @Override // com.byazt.u.qg
                    public void n(Map map, Map map2) {
                        com.byazt.ta.w.n(sparseArray, map);
                        com.byazt.ta.w.n(sparseArray2, map2);
                        qVar.n();
                        w.this.n((qg) null);
                    }
                });
                try {
                    z = !w.this.tj.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable unused) {
                    z = false;
                }
                if (z && (future = w.this.rv) != null) {
                    future.cancel(true);
                }
                w.this.n();
                if (!z || (qVar2 = qVar) == null) {
                    return;
                }
                qVar2.n();
            }
        });
    }

    public void n(qg qgVar) {
        synchronized (this) {
            s sVar = this.n;
            if (sVar != null) {
                try {
                    sVar.n(qgVar);
                } catch (RemoteException unused) {
                }
            } else {
                this.w = qgVar;
            }
        }
    }

    public void n() {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.n();
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo qg(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.qg(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> n(String str) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.n(str);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> qg(String str) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.qg(str);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> s(String str) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.s(str);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> q(String str) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.q(str);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public List<DownloadInfo> qg() {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.qg();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public List<com.byazt.wm.qg> s(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.s(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public void q(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.q(i);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public void n(com.byazt.wm.qg qgVar) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.n(qgVar);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public void qg(com.byazt.wm.qg qgVar) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.qg(qgVar);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public void n(int i, int i2, long j) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.n(i, i2, j);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public void n(int i, int i2, int i3, long j) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.n(i, i2, i3, j);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public void n(int i, int i2, int i3, int i4) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.n(i, i2, i3, i4);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo n(int i, int i2) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.n(i, i2);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public boolean n(DownloadInfo downloadInfo) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.n(downloadInfo);
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.tj
    public boolean l(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.l(i);
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.tj
    public boolean w(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.w(i);
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.tj
    public void s() {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.s();
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo x(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.x(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo n(int i, long j, String str, String str2) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.n(i, j, str, str2);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo n(int i, long j) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.n(i, j);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo qg(int i, long j) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.qg(i, j);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo fs(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.fs(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo s(int i, long j) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.s(i, j);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo q(int i, long j) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.q(i, j);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo rv(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.rv(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public DownloadInfo tj(int i) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.tj(i);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.byazt.xv.tj
    public boolean q() {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.q();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.tj
    public boolean l() {
        try {
            s sVar = this.n;
            if (sVar != null) {
                return sVar.l();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.byazt.xv.tj
    public void qg(DownloadInfo downloadInfo) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.qg(downloadInfo);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public void n(int i, List<com.byazt.wm.qg> list) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.n(i, list);
            }
        } catch (RemoteException unused) {
        }
    }

    @Override // com.byazt.xv.tj
    public void qg(int i, List<com.byazt.wm.qg> list) {
        try {
            s sVar = this.n;
            if (sVar != null) {
                sVar.qg(i, list);
            }
        } catch (RemoteException unused) {
        }
    }
}
