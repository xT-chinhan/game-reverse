package com.byazt.i;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 20})
public final class hn {
    public static volatile hn c;
    public final HashSet<pr> aj;
    public volatile com.byazt.j.hn fw;
    public final hw<Runnable> hn;
    public final SparseArray<Map<String, com.byazt.i.hw>> hw;
    public volatile boolean k;
    public volatile int pr = 163840;
    public volatile com.byazt.d.hn uc;
    public final com.byazt.i.hw.InterfaceC0091hw vk;
    public volatile String w;
    public final ExecutorService x;
    public volatile com.byazt.j.hw zo;

    public void pr(com.byazt.j.hn hnVar) {
        this.fw = hnVar;
    }

    public void pr(com.byazt.d.hn hnVar) {
        this.uc = hnVar;
    }

    public void pr(int i) {
        if (i > 0) {
            this.pr = i;
        }
        boolean z = x.c;
    }

    private hn() {
        SparseArray<Map<String, com.byazt.i.hw>> sparseArray = new SparseArray<>(2);
        this.hw = sparseArray;
        this.aj = new HashSet<>();
        this.vk = new com.byazt.i.hw.InterfaceC0091hw() { // from class: com.byazt.i.hn.1
            @Override // com.byazt.i.hw.InterfaceC0091hw
            public void pr(com.byazt.i.hw hwVar) {
                int iC = hwVar.c();
                synchronized (hn.this.hw) {
                    Map map = (Map) hn.this.hw.get(iC);
                    if (map != null) {
                        map.remove(hwVar.zo);
                    }
                }
                if (x.c) {
                    String str = hwVar.zo;
                }
            }
        };
        hw<Runnable> hwVar = new hw<>();
        this.hn = hwVar;
        ExecutorService executorServicePr = pr(hwVar);
        this.x = executorServicePr;
        hwVar.pr((ThreadPoolExecutor) executorServicePr);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public static hn pr() {
        if (c == null) {
            synchronized (hn.class) {
                if (c == null) {
                    c = new hn();
                }
            }
        }
        return c;
    }

    public void pr(boolean z, boolean z2, int i, String str, String... strArr) {
        pr(z, z2, i, str, null, strArr);
    }

    public void pr(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        int i2;
        boolean z3 = x.c;
        com.byazt.j.pr prVar = z ? this.zo : this.fw;
        com.byazt.d.hn hnVar = this.uc;
        if (prVar == null || hnVar == null) {
            if (x.c) {
                ho.hw("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        if (i > 0) {
            i2 = i;
        } else {
            i2 = this.pr;
        }
        String strPr = z2 ? str : com.byazt.o.pr.pr(str);
        File fileX = prVar.x(strPr);
        if (fileX != null && fileX.length() >= i2) {
            if (x.c) {
                fileX.length();
                return;
            }
            return;
        }
        synchronized (this.hw) {
            Map<String, com.byazt.i.hw> map2 = this.hw.get(z ? 1 : 0);
            if (map2.containsKey(strPr)) {
                return;
            }
            pr prVar2 = new pr(z, z2, i2, str, map, strArr);
            String str2 = this.w;
            if (str2 != null) {
                int i3 = x.hn;
                if (i3 == 3) {
                    synchronized (this.aj) {
                        this.aj.add(prVar2);
                    }
                    boolean z4 = x.c;
                    return;
                } else if (i3 == 2) {
                    boolean z5 = x.c;
                    return;
                } else if (i3 == 1 && this.k == z && str2.equals(strPr)) {
                    boolean z6 = x.c;
                    return;
                }
            }
            ArrayList arrayList = null;
            List<uc.hw> listPr = com.byazt.a.pr.pr(com.byazt.a.pr.pr(map));
            if (listPr != null) {
                arrayList = new ArrayList(listPr.size());
                int size = listPr.size();
                for (int i4 = 0; i4 < size; i4++) {
                    uc.hw hwVar = listPr.get(i4);
                    if (hwVar != null) {
                        arrayList.add(new uc.hw(hwVar.pr, hwVar.hw));
                    }
                }
            }
            com.byazt.i.hw hwVarPr = new com.byazt.i.hw.pr().pr(prVar).pr(hnVar).pr(str).hw(strPr).pr(new zo(com.byazt.a.pr.pr(strArr))).pr((List<uc.hw>) arrayList).pr(i2).pr(this.vk).pr(prVar2).pr();
            map2.put(strPr, hwVarPr);
            this.x.execute(hwVarPr);
        }
    }

    public void pr(String str) {
        pr(false, false, str);
    }

    public void pr(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.a.pr.pr(new Runnable() { // from class: com.byazt.i.hn.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.i.hw hwVar;
                synchronized (hn.this.hw) {
                    Map map = (Map) hn.this.hw.get(com.byazt.d.hw.pr(z));
                    if (map != null) {
                        hwVar = (com.byazt.i.hw) map.remove(z2 ? str : com.byazt.o.pr.pr(str));
                    } else {
                        hwVar = null;
                    }
                }
                if (hwVar != null) {
                    hwVar.pr();
                }
            }
        });
    }

    public void hw() {
        com.byazt.a.pr.pr(new Runnable() { // from class: com.byazt.i.hn.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                synchronized (hn.this.hw) {
                    int size = hn.this.hw.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) hn.this.hw.get(hn.this.hw.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    hn.this.hn.clear();
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.byazt.i.hw) it.next()).pr();
                    boolean z = x.c;
                }
            }
        });
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 116})
    private static final class pr {
        public final Map<String, String> c;
        public final int hn;
        public final boolean hw;
        public final boolean pr;
        public final String[] uc;
        public final String x;

        public pr(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.pr = z;
            this.hw = z2;
            this.hn = i;
            this.x = str;
            this.c = map;
            this.uc = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            pr prVar = (pr) obj;
            if (this.pr != prVar.pr || this.hw != prVar.hw || this.hn != prVar.hn) {
                return false;
            }
            return this.x.equals(prVar.x);
        }

        public int hashCode() {
            return ((((((this.pr ? 1 : 0) * 31) + (this.hw ? 1 : 0)) * 31) + this.hn) * 31) + this.x.hashCode();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 506})
    private static final class hw<T> extends LinkedBlockingDeque<T> {
        public ThreadPoolExecutor pr;

        private hw() {
        }

        public void pr(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.pr != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.pr = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.pr.getPoolSize();
                int activeCount = this.pr.getActiveCount();
                int maximumPoolSize = this.pr.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    boolean z = x.c;
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    private static ExecutorService pr(final hw<Runnable> hwVar) {
        int i;
        int iPr = com.byazt.a.pr.pr();
        if (iPr <= 0) {
            i = 1;
        } else if (iPr <= 4) {
            i = iPr;
        } else {
            i = 4;
        }
        return new com.byazt.fr.x(0, i, 60L, TimeUnit.SECONDS, hwVar, new ThreadFactory() { // from class: com.byazt.i.hn.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.byazt.fr.hn hnVar = new com.byazt.fr.hn(runnable) { // from class: com.byazt.i.hn.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                        }
                        super.run();
                    }
                };
                hnVar.setName("csj_video_preload_" + hnVar.getId());
                hnVar.setDaemon(true);
                if (x.c) {
                    hnVar.getName();
                }
                return hnVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.byazt.i.hn.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    hwVar.offerFirst(runnable);
                    boolean z = x.c;
                } catch (Throwable th) {
                }
            }
        });
    }
}
