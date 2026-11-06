package com.byazt.nd;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.tk.k;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 674, 8})
public final class s {
    public static volatile s l;
    public volatile String cp;
    public volatile boolean d;
    public volatile com.byazt.lp.qg fs;
    public volatile int n = 163840;
    public final ExecutorService q;
    public final SparseArray<Map<String, com.byazt.nd.qg>> qg;
    public final HashSet<n> rv;
    public final qg<Runnable> s;
    public final com.byazt.nd.qg.InterfaceC0256qg tj;
    public volatile com.byazt.frl.s w;
    public volatile com.byazt.lp.s x;

    public void n(com.byazt.lp.s sVar) {
        this.x = sVar;
    }

    public void n(com.byazt.frl.s sVar) {
        this.w = sVar;
    }

    public void n(int i) {
        if (i > 0) {
            this.n = i;
        }
        boolean z = q.l;
    }

    private s() {
        SparseArray<Map<String, com.byazt.nd.qg>> sparseArray = new SparseArray<>(2);
        this.qg = sparseArray;
        this.rv = new HashSet<>();
        this.tj = new com.byazt.nd.qg.InterfaceC0256qg() { // from class: com.byazt.nd.s.1
            @Override // com.byazt.nd.qg.InterfaceC0256qg
            public void n(com.byazt.nd.qg qgVar) {
                int iL = qgVar.l();
                synchronized (s.this.qg) {
                    Map map = (Map) s.this.qg.get(iL);
                    if (map != null) {
                        map.remove(qgVar.fs);
                    }
                }
                if (q.l) {
                    String str = qgVar.fs;
                }
            }
        };
        qg<Runnable> qgVar = new qg<>();
        this.s = qgVar;
        ExecutorService executorServiceN = n(qgVar);
        this.q = executorServiceN;
        qgVar.n((ThreadPoolExecutor) executorServiceN);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public static s n() {
        if (l == null) {
            synchronized (s.class) {
                if (l == null) {
                    l = new s();
                }
            }
        }
        return l;
    }

    public void n(boolean z, boolean z2, int i, String str, String... strArr) {
        n(z, z2, i, str, null, strArr);
    }

    public void n(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        ArrayList arrayList;
        boolean z3 = q.l;
        com.byazt.lp.n nVar = z ? this.fs : this.x;
        com.byazt.frl.s sVar = this.w;
        if (nVar == null || sVar == null) {
            if (q.l) {
                k.qg("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i2 = i <= 0 ? this.n : i;
        String strN = z2 ? str : com.byazt.nl.n.n(str);
        File fileQ = nVar.q(strN);
        if (fileQ != null && fileQ.length() >= i2) {
            if (q.l) {
                fileQ.length();
                return;
            }
            return;
        }
        synchronized (this.qg) {
            Map<String, com.byazt.nd.qg> map2 = this.qg.get(z ? 1 : 0);
            if (map2.containsKey(strN)) {
                return;
            }
            n nVar2 = new n(z, z2, i2, str, map, strArr);
            String str2 = this.cp;
            if (str2 != null) {
                int i3 = q.s;
                if (i3 == 3) {
                    synchronized (this.rv) {
                        this.rv.add(nVar2);
                    }
                    boolean z4 = q.l;
                    return;
                } else if (i3 == 2) {
                    boolean z5 = q.l;
                    return;
                } else if (i3 == 1 && this.d == z && str2.equals(strN)) {
                    boolean z6 = q.l;
                    return;
                }
            }
            List<w.qg> listN = com.byazt.cmv.n.n(com.byazt.cmv.n.n(map));
            if (listN != null) {
                arrayList = new ArrayList(listN.size());
                int size = listN.size();
                for (int i4 = 0; i4 < size; i4++) {
                    w.qg qgVar = listN.get(i4);
                    if (qgVar != null) {
                        arrayList.add(new w.qg(qgVar.n, qgVar.qg));
                    }
                }
            } else {
                arrayList = null;
            }
            com.byazt.nd.qg qgVarN = new com.byazt.nd.qg.n().n(nVar).n(sVar).n(str).qg(strN).n(new fs(com.byazt.cmv.n.n(strArr))).n((List<w.qg>) arrayList).n(i2).n(this.tj).n(nVar2).n();
            map2.put(strN, qgVarN);
            this.q.execute(qgVarN);
        }
    }

    public void n(String str) {
        n(false, false, str);
    }

    public void n(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.cmv.n.n(new Runnable() { // from class: com.byazt.nd.s.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.nd.qg qgVar;
                synchronized (s.this.qg) {
                    Map map = (Map) s.this.qg.get(com.byazt.frl.qg.n(z));
                    if (map != null) {
                        qgVar = (com.byazt.nd.qg) map.remove(z2 ? str : com.byazt.nl.n.n(str));
                    } else {
                        qgVar = null;
                    }
                }
                if (qgVar != null) {
                    qgVar.n();
                }
            }
        });
    }

    public void qg() {
        com.byazt.cmv.n.n(new Runnable() { // from class: com.byazt.nd.s.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                synchronized (s.this.qg) {
                    int size = s.this.qg.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) s.this.qg.get(s.this.qg.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    s.this.s.clear();
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.byazt.nd.qg) it.next()).n();
                    boolean z = q.l;
                }
            }
        });
    }

    @com.byazt.cp.n(n = {0, 1, 674, 546})
    private static final class n {
        public final Map<String, String> l;
        public final boolean n;
        public final String q;
        public final boolean qg;
        public final int s;
        public final String[] w;

        public n(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.n = z;
            this.qg = z2;
            this.s = i;
            this.q = str;
            this.l = map;
            this.w = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            n nVar = (n) obj;
            if (this.n == nVar.n && this.qg == nVar.qg && this.s == nVar.s) {
                return this.q.equals(nVar.q);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.n ? 1 : 0) * 31) + (this.qg ? 1 : 0)) * 31) + this.s) * 31) + this.q.hashCode();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 674, 782})
    private static final class qg<T> extends LinkedBlockingDeque<T> {
        public ThreadPoolExecutor n;

        private qg() {
        }

        public void n(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.n != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.n = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.n.getPoolSize();
                int activeCount = this.n.getActiveCount();
                int maximumPoolSize = this.n.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    boolean z = q.l;
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    private static ExecutorService n(final qg<Runnable> qgVar) {
        int i;
        int iN = com.byazt.cmv.n.n();
        if (iN > 0) {
            if (iN > 4) {
                i = 4;
            }
            return new com.byazt.xis.q(0, i, 60L, TimeUnit.SECONDS, qgVar, new ThreadFactory() { // from class: com.byazt.nd.s.4
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.byazt.xis.s sVar = new com.byazt.xis.s(runnable) { // from class: com.byazt.nd.s.4.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Process.setThreadPriority(10);
                            } catch (Throwable unused) {
                            }
                            super.run();
                        }
                    };
                    sVar.setName("csj_video_preload_" + sVar.getId());
                    sVar.setDaemon(true);
                    if (q.l) {
                        sVar.getName();
                    }
                    return sVar;
                }
            }, new RejectedExecutionHandler() { // from class: com.byazt.nd.s.5
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    try {
                        qgVar.offerFirst(runnable);
                        boolean z = q.l;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        iN = 1;
        i = iN;
        return new com.byazt.xis.q(0, i, 60L, TimeUnit.SECONDS, qgVar, new ThreadFactory() { // from class: com.byazt.nd.s.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.byazt.xis.s sVar = new com.byazt.xis.s(runnable) { // from class: com.byazt.nd.s.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable unused) {
                        }
                        super.run();
                    }
                };
                sVar.setName("csj_video_preload_" + sVar.getId());
                sVar.setDaemon(true);
                if (q.l) {
                    sVar.getName();
                }
                return sVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.byazt.nd.s.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    qgVar.offerFirst(runnable);
                    boolean z = q.l;
                } catch (Throwable unused) {
                }
            }
        });
    }
}
