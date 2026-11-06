package com.bykv.vk.openvk.component.video.ms.xr;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
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
public class d {
    private static volatile d ka;
    private volatile com.bykv.vk.openvk.component.video.ms.xr.ms.ah ab;
    private final xr<Runnable> ah;
    private volatile com.bykv.vk.openvk.component.video.ms.xr.xr.ah c;
    private final com.bykv.vk.openvk.component.video.ms.xr.xr.InterfaceC0185xr ch;
    private final ExecutorService d;
    private volatile ah hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile int f75ms = 163840;
    private final HashSet<ms> ny;
    private volatile ah sl;
    private volatile boolean u;
    private volatile com.bykv.vk.openvk.component.video.ms.xr.ms.xr x;
    private final SparseArray<Map<String, com.bykv.vk.openvk.component.video.ms.xr.xr>> xr;
    private volatile String zb;

    void ms(com.bykv.vk.openvk.component.video.ms.xr.ms.ah ahVar) {
        this.ab = ahVar;
    }

    void ms(com.bykv.vk.openvk.component.video.ms.xr.xr.ah ahVar) {
        this.c = ahVar;
    }

    public void ms(int i) {
        if (i > 0) {
            this.f75ms = i;
        }
        if (ka.ah) {
            com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_Preloader", "MaxPreloadSize: ".concat(String.valueOf(i)));
        }
    }

    private d() {
        SparseArray<Map<String, com.bykv.vk.openvk.component.video.ms.xr.xr>> sparseArray = new SparseArray<>(2);
        this.xr = sparseArray;
        this.ny = new HashSet<>();
        this.ch = new com.bykv.vk.openvk.component.video.ms.xr.xr.InterfaceC0185xr() { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.1
            @Override // com.bykv.vk.openvk.component.video.ms.xr.xr.InterfaceC0185xr
            public void ms(com.bykv.vk.openvk.component.video.ms.xr.xr xrVar) {
                int iC = xrVar.c();
                synchronized (d.this.xr) {
                    Map map = (Map) d.this.xr.get(iC);
                    if (map != null) {
                        map.remove(xrVar.x);
                    }
                }
                if (ka.ah) {
                    String str = xrVar.x;
                }
            }
        };
        xr<Runnable> xrVar = new xr<>();
        this.ah = xrVar;
        ExecutorService executorServiceMs = ms(xrVar);
        this.d = executorServiceMs;
        xrVar.ms((ThreadPoolExecutor) executorServiceMs);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    ah ms() {
        return this.hi;
    }

    ah xr() {
        return this.sl;
    }

    public static d ah() {
        if (ka == null) {
            synchronized (d.class) {
                if (ka == null) {
                    ka = new d();
                }
            }
        }
        return ka;
    }

    void ms(boolean z, String str) {
        com.bykv.vk.openvk.component.video.ms.xr.xr xrVarRemove;
        this.zb = str;
        this.u = z;
        if (ka.ah) {
            com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_Preloader", "setCurrentPlayKey, ".concat(String.valueOf(str)));
        }
        HashSet<com.bykv.vk.openvk.component.video.ms.xr.xr> hashSet = null;
        HashSet<ms> hashSet2 = null;
        if (str == null) {
            synchronized (this.ny) {
                if (!this.ny.isEmpty()) {
                    hashSet2 = new HashSet(this.ny);
                    this.ny.clear();
                }
            }
            if (hashSet2 != null) {
                for (ms msVar : hashSet2) {
                    ms(msVar.f81ms, msVar.xr, msVar.ah, msVar.d, msVar.ka, msVar.c);
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + msVar.d);
                    }
                }
                return;
            }
            return;
        }
        int i = ka.x;
        if (i != 3 && i != 2) {
            if (i == 1) {
                synchronized (this.xr) {
                    Map<String, com.bykv.vk.openvk.component.video.ms.xr.xr> map = this.xr.get(com.bykv.vk.openvk.component.video.ms.xr.xr.xr.ms(z));
                    xrVarRemove = map != null ? map.remove(str) : null;
                }
                if (xrVarRemove != null) {
                    xrVarRemove.ms();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.xr) {
            int size = this.xr.size();
            for (int i2 = 0; i2 < size; i2++) {
                SparseArray<Map<String, com.bykv.vk.openvk.component.video.ms.xr.xr>> sparseArray = this.xr;
                Map<String, com.bykv.vk.openvk.component.video.ms.xr.xr> map2 = sparseArray.get(sparseArray.keyAt(i2));
                if (map2 != null) {
                    Collection<com.bykv.vk.openvk.component.video.ms.xr.xr> collectionValues = map2.values();
                    if (collectionValues != null && !collectionValues.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(collectionValues);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        for (com.bykv.vk.openvk.component.video.ms.xr.xr xrVar : hashSet) {
            xrVar.ms();
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + xrVar.ab);
            }
        }
        if (i == 3) {
            synchronized (this.ny) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ms msVar2 = (ms) ((com.bykv.vk.openvk.component.video.ms.xr.xr) it.next()).u;
                    if (msVar2 != null) {
                        this.ny.add(msVar2);
                    }
                }
            }
        }
    }

    public void ms(boolean z, boolean z2, int i, String str, String... strArr) {
        ms(z, z2, i, str, null, strArr);
    }

    public void ms(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        ArrayList arrayList;
        boolean z3 = ka.ah;
        com.bykv.vk.openvk.component.video.ms.xr.ms.ms msVar = z ? this.x : this.ab;
        com.bykv.vk.openvk.component.video.ms.xr.xr.ah ahVar = this.c;
        if (msVar == null || ahVar == null) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.d("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i2 = i <= 0 ? this.f75ms : i;
        String strMs = z2 ? str : com.bykv.vk.openvk.component.video.api.c.xr.ms(str);
        File fileD = msVar.d(strMs);
        if (fileD != null && fileD.length() >= i2) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_Preloader", "no need preload, file size: " + fileD.length() + ", need preload size: " + i2);
                return;
            }
            return;
        }
        if (c.ms().ms(com.bykv.vk.openvk.component.video.ms.xr.xr.xr.ms(z), strMs)) {
            if (ka.ah) {
                com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: ".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        synchronized (this.xr) {
            Map<String, com.bykv.vk.openvk.component.video.ms.xr.xr> map2 = this.xr.get(z ? 1 : 0);
            if (map2.containsKey(strMs)) {
                return;
            }
            int i3 = i2;
            ms msVar2 = new ms(z, z2, i2, str, map, strArr);
            String str2 = this.zb;
            if (str2 != null) {
                int i4 = ka.x;
                if (i4 == 3) {
                    synchronized (this.ny) {
                        this.ny.add(msVar2);
                    }
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                    }
                    return;
                }
                if (i4 == 2) {
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_Preloader", "cancel preload: ".concat(String.valueOf(str)));
                    }
                    return;
                } else if (i4 == 1 && this.u == z && str2.equals(strMs)) {
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                    }
                    return;
                }
            }
            List<ny.xr> listMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms(com.bykv.vk.openvk.component.video.ms.ah.ms.ms(map));
            if (listMs != null) {
                arrayList = new ArrayList(listMs.size());
                int size = listMs.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ny.xr xrVar = listMs.get(i5);
                    if (xrVar != null) {
                        arrayList.add(new ny.xr(xrVar.f103ms, xrVar.xr));
                    }
                }
            } else {
                arrayList = null;
            }
            com.bykv.vk.openvk.component.video.ms.xr.xr xrVarMs = new com.bykv.vk.openvk.component.video.ms.xr.xr.ms().ms(msVar).ms(ahVar).ms(str).xr(strMs).ms(new sl(com.bykv.vk.openvk.component.video.ms.ah.ms.ms(strArr))).ms((List<ny.xr>) arrayList).ms(i3).ms(this.ch).ms(msVar2).ms();
            map2.put(strMs, xrVarMs);
            this.d.execute(xrVarMs);
        }
    }

    public void ms(String str) {
        ms(false, false, str);
    }

    public void ms(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bykv.vk.openvk.component.video.ms.ah.ms.ms(new com.bytedance.sdk.component.ch.ny("cancel b b S") { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.ms.xr.xr xrVar;
                synchronized (d.this.xr) {
                    Map map = (Map) d.this.xr.get(com.bykv.vk.openvk.component.video.ms.xr.xr.xr.ms(z));
                    if (map != null) {
                        xrVar = (com.bykv.vk.openvk.component.video.ms.xr.xr) map.remove(z2 ? str : com.bykv.vk.openvk.component.video.api.c.xr.ms(str));
                    } else {
                        xrVar = null;
                    }
                }
                if (xrVar != null) {
                    xrVar.ms();
                }
            }
        });
    }

    public void d() {
        com.bykv.vk.openvk.component.video.ms.ah.ms.ms(new com.bytedance.sdk.component.ch.ny("cancelAll") { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bykv.vk.openvk.component.video.ms.xr.xr> arrayList = new ArrayList();
                synchronized (d.this.xr) {
                    int size = d.this.xr.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) d.this.xr.get(d.this.xr.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.ah.clear();
                }
                for (com.bykv.vk.openvk.component.video.ms.xr.xr xrVar : arrayList) {
                    xrVar.ms();
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.xr("TAG_PROXY_Preloader", "PreloadTask: " + xrVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    private static final class ms {
        final int ah;
        final String[] c;
        final String d;
        final Map<String, String> ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final boolean f81ms;
        final boolean xr;

        ms(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.f81ms = z;
            this.xr = z2;
            this.ah = i;
            this.d = str;
            this.ka = map;
            this.c = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ms msVar = (ms) obj;
            if (this.f81ms == msVar.f81ms && this.xr == msVar.xr && this.ah == msVar.ah) {
                return this.d.equals(msVar.d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f81ms ? 1 : 0) * 31) + (this.xr ? 1 : 0)) * 31) + this.ah) * 31) + this.d.hashCode();
        }
    }

    private static final class xr<T> extends LinkedBlockingDeque<T> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ThreadPoolExecutor f82ms;

        private xr() {
        }

        public void ms(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f82ms != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.f82ms = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.f82ms.getPoolSize();
                int activeCount = this.f82ms.getActiveCount();
                int maximumPoolSize = this.f82ms.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    private static ExecutorService ms(final xr<Runnable> xrVar) {
        int i;
        int iMs = com.bykv.vk.openvk.component.video.ms.ah.ms.ms();
        if (iMs > 0) {
            if (iMs > 4) {
                i = 4;
            }
            return new com.bytedance.sdk.component.ch.d.d(0, i, 60L, TimeUnit.SECONDS, xrVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.4
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.ch.d.ah ahVar = new com.bytedance.sdk.component.ch.d.ah(runnable) { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.4.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Process.setThreadPriority(10);
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.sl.ms(th);
                            }
                            super.run();
                        }
                    };
                    ahVar.setName("csj_video_preload_" + ahVar.getId());
                    ahVar.setDaemon(true);
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_Preloader", "new preload thead: " + ahVar.getName());
                    }
                    return ahVar;
                }
            }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.5
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    try {
                        xrVar.offerFirst(runnable);
                        if (ka.ah) {
                            com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.sl.ms(th);
                    }
                }
            });
        }
        iMs = 1;
        i = iMs;
        return new com.bytedance.sdk.component.ch.d.d(0, i, 60L, TimeUnit.SECONDS, xrVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.ch.d.ah ahVar = new com.bytedance.sdk.component.ch.d.ah(runnable) { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.sl.ms(th);
                        }
                        super.run();
                    }
                };
                ahVar.setName("csj_video_preload_" + ahVar.getId());
                ahVar.setDaemon(true);
                if (ka.ah) {
                    com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_Preloader", "new preload thead: " + ahVar.getName());
                }
                return ahVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.ms.xr.d.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    xrVar.offerFirst(runnable);
                    if (ka.ah) {
                        com.bytedance.sdk.component.utils.sl.ms("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.ms(th);
                }
            }
        });
    }
}
