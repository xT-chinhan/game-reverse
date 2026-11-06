package com.byazt.mef;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.lj.SqlDownloadCacheService;
import com.byazt.lj.a;
import com.byazt.stx.aj;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 798, 5})
public class uc implements ServiceConnection, a {
    public static int hn;
    public static boolean hw;
    public static long x = 0;
    public Future<?> aj;
    public com.byazt.lj.hn.pr.InterfaceC0121pr fw;
    public hn pr;
    public Handler c = new Handler(Looper.getMainLooper());
    public hw uc = null;
    public Runnable zo = new Runnable() { // from class: com.byazt.mef.uc.1
        @Override // java.lang.Runnable
        public void run() {
            if (!uc.hw && uc.this.fw != null) {
                uc.this.fw.pr();
            }
        }
    };
    public CountDownLatch vk = new CountDownLatch(1);

    public uc() {
        SqlDownloadCacheService.pr(com.byazt.lj.hn.of(), this);
    }

    public void pr(com.byazt.lj.hn.pr.InterfaceC0121pr interfaceC0121pr) {
        this.fw = interfaceC0121pr;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        hw = true;
        this.c.removeCallbacks(this.zo);
        try {
            this.pr = hn.pr.pr(iBinder);
        } catch (Throwable th) {
        }
        this.aj = com.byazt.lj.hn.k().submit(new Runnable() { // from class: com.byazt.mef.uc.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        try {
                            if (uc.this.uc != null && uc.this.pr != null) {
                                uc.this.pr.pr(uc.this.uc);
                            }
                            uc.this.vk.countDown();
                            iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.byazt.mef.uc.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = uc.hw = false;
                                    if (!uc.this.fw() && uc.this.fw != null) {
                                        uc.this.c.postDelayed(uc.this.zo, 2000L);
                                    }
                                }
                            }, 0);
                        } catch (Throwable th2) {
                        }
                    } catch (Throwable th3) {
                        try {
                            com.byazt.p000do.pr.hw("SqlDownloadCacheAidlWra", "onServiceConnected fail", th3);
                            if (uc.this.fw != null) {
                                uc.this.fw.pr();
                            }
                            uc.this.vk.countDown();
                            iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.byazt.mef.uc.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = uc.hw = false;
                                    if (!uc.this.fw() && uc.this.fw != null) {
                                        uc.this.c.postDelayed(uc.this.zo, 2000L);
                                    }
                                }
                            }, 0);
                        } catch (Throwable th4) {
                            uc.this.vk.countDown();
                            try {
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.byazt.mef.uc.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused = uc.hw = false;
                                        if (!uc.this.fw() && uc.this.fw != null) {
                                            uc.this.c.postDelayed(uc.this.zo, 2000L);
                                        }
                                    }
                                }, 0);
                            } catch (Throwable th5) {
                            }
                            throw th4;
                        }
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.pr = null;
        hw = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fw() {
        if (Build.VERSION.SDK_INT >= 26 || hw) {
            return false;
        }
        if (hn > 5) {
            com.byazt.p000do.pr.x("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - x < IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS) {
            com.byazt.p000do.pr.x("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
            return false;
        }
        hn++;
        x = jCurrentTimeMillis;
        this.c.postDelayed(new Runnable() { // from class: com.byazt.mef.uc.3
            @Override // java.lang.Runnable
            public void run() {
                SqlDownloadCacheService.pr(com.byazt.lj.hn.of(), uc.this);
            }
        }, 1000L);
        return true;
    }

    @Override // com.byazt.lj.a
    public void pr(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.byazt.auw.hw>> sparseArray2, final x xVar) {
        com.byazt.lj.hn.k().submit(new Runnable() { // from class: com.byazt.mef.uc.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                x xVar2;
                Future future;
                uc.this.pr(new hw.pr() { // from class: com.byazt.mef.uc.4.1
                    @Override // com.byazt.mef.hw
                    public void pr(Map map, Map map2) {
                        com.byazt.tuy.uc.pr(sparseArray, map);
                        com.byazt.tuy.uc.pr(sparseArray2, map2);
                        xVar.pr();
                        uc.this.pr((hw) null);
                    }
                });
                try {
                    z = !uc.this.vk.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    z = false;
                }
                if (z && (future = uc.this.aj) != null) {
                    future.cancel(true);
                }
                uc.this.pr();
                if (z && (xVar2 = xVar) != null) {
                    xVar2.pr();
                }
            }
        });
    }

    public void pr(hw hwVar) {
        synchronized (this) {
            hn hnVar = this.pr;
            if (hnVar != null) {
                try {
                    hnVar.pr(hwVar);
                } catch (RemoteException e) {
                }
            } else {
                this.uc = hwVar;
            }
        }
    }

    public void pr() {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.pr();
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo hw(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.hw(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> pr(String str) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.pr(str);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> hw(String str) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.hw(str);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> hn(String str) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.hn(str);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> x(String str) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.x(str);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public List<DownloadInfo> hw() {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.hw();
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public List<com.byazt.auw.hw> hn(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.hn(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public void x(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.x(i);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public void pr(com.byazt.auw.hw hwVar) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.pr(hwVar);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public void hw(com.byazt.auw.hw hwVar) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.hw(hwVar);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, int i2, long j) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.pr(i, i2, j);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, int i2, int i3, long j) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.pr(i, i2, i3, j);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, int i2, int i3, int i4) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.pr(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo pr(int i, int i2) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.pr(i, i2);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public boolean pr(DownloadInfo downloadInfo) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.pr(downloadInfo);
            }
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.vk
    public boolean c(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.c(i);
            }
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.vk
    public boolean uc(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.uc(i);
            }
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.vk
    public void hn() {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.hn();
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo fw(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.fw(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo pr(int i, long j, String str, String str2) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.pr(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo pr(int i, long j) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.pr(i, j);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo hw(int i, long j) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.hw(i, j);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo zo(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.zo(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo hn(int i, long j) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.hn(i, j);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo x(int i, long j) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.x(i, j);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo aj(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.aj(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public DownloadInfo vk(int i) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.vk(i);
            }
            return null;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // com.byazt.lj.vk
    public boolean x() {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.x();
            }
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.vk
    public boolean c() {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                return hnVar.c();
            }
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // com.byazt.lj.vk
    public void hw(DownloadInfo downloadInfo) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.hw(downloadInfo);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public void pr(int i, List<com.byazt.auw.hw> list) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.pr(i, list);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    public void hw(int i, List<com.byazt.auw.hw> list) {
        try {
            hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.hw(i, list);
            }
        } catch (RemoteException e) {
        }
    }

    @Override // com.byazt.lj.vk
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public ArrayList<aj> g(int i) {
        return null;
    }

    @Override // com.byazt.lj.vk
    public Map<Long, aj> k(int i) {
        return null;
    }

    @Override // com.byazt.lj.vk
    public boolean pr(int i, Map<Long, aj> map) {
        return false;
    }

    @Override // com.byazt.lj.vk
    public void m(int i) {
    }
}
