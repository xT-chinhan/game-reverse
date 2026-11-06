package com.byazt.gp;

import android.text.TextUtils;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, 101})
public final class fs {
    public static final fs n = new fs();
    public final s fs;
    public final AtomicBoolean l;
    public final AtomicBoolean q;
    public final ExecutorService qg;
    public final n rv;
    public final AtomicBoolean s;
    public final AtomicBoolean w;
    public final qg x;

    interface n {
        int n(long j);

        void n(Runnable runnable, long j);

        boolean n();
    }

    interface qg {
        boolean delete(String str);

        x.n n(long j, boolean z);

        x.w n(byte[] bArr, String str, String str2, long j);

        boolean n();

        boolean n(x.w wVar);

        boolean n(Set<String> set);
    }

    interface s {
        void n(com.byazt.ng.qg.n nVar, List<x.fs> list, rv.qg qgVar);
    }

    private fs() {
        this(l(), new l(new x()), new w(new rv()), new q());
    }

    public fs(ExecutorService executorService, qg qgVar, s sVar, n nVar) {
        this.s = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.w = new AtomicBoolean(true);
        this.qg = executorService;
        this.x = qgVar;
        this.fs = sVar;
        this.rv = nVar;
    }

    public static fs n() {
        return n;
    }

    private static ExecutorService l() {
        com.byazt.xis.q qVar = new com.byazt.xis.q(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), com.byazt.rb.l.n("gm_t_single_material_image"), new ThreadPoolExecutor.AbortPolicy());
        qVar.allowCoreThreadTimeOut(true);
        return qVar;
    }

    public String n(byte[] bArr, String str, String str2, long j) {
        final x.w wVarN;
        if (this.rv.n() || TextUtils.isEmpty(com.byazt.ng.qg.n().n) || (wVarN = this.x.n(bArr, str, str2, j)) == null) {
            return null;
        }
        try {
            this.qg.execute(new Runnable() { // from class: com.byazt.gp.fs.1
                @Override // java.lang.Runnable
                public void run() {
                    if (fs.this.x.n(wVarN)) {
                        fs.this.n(1);
                    }
                }
            });
            return wVarN.n;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i) {
        com.byazt.ng.qg.n nVarN = com.byazt.ng.qg.n();
        if (nVarN == null || TextUtils.isEmpty(nVarN.n)) {
            return;
        }
        if ((!this.l.get() || i == 4) && !this.s.get()) {
            int i2 = 1;
            x.n nVarN2 = this.x.n(System.currentTimeMillis(), (i == 1 || i == 4) ? false : true);
            com.byazt.gp.s.n(nVarN2.qg);
            List<x.fs> list = nVarN2.n;
            if (i != 2 && i != 4) {
                i2 = nVarN.q;
            }
            if (n(i, nVarN, list.size(), i2)) {
                n(nVarN, list);
            }
        }
    }

    private boolean n(int i, com.byazt.ng.qg.n nVar, int i2, int i3) {
        int iW;
        if ((i != 2 || this.w.get()) && i2 >= i3) {
            return (!nVar.s || ((iW = w()) != Integer.MIN_VALUE && iW == 4)) && this.s.compareAndSet(false, true);
        }
        return false;
    }

    private int w() {
        try {
            return this.rv.n(0L);
        } catch (Throwable unused) {
            return Integer.MIN_VALUE;
        }
    }

    private void n(com.byazt.ng.qg.n nVar, final List<x.fs> list) {
        try {
            this.fs.n(nVar, list, new rv.qg() { // from class: com.byazt.gp.fs.2
                @Override // com.byazt.gp.rv.qg
                public void n(Set<String> set, Set<String> set2, Map<String, Integer> map) {
                    fs.this.n((List<x.fs>) list, set, set2, map);
                }
            });
        } catch (Throwable unused) {
            this.s.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final List<x.fs> list, final Set<String> set, final Set<String> set2, final Map<String, Integer> map) {
        try {
            this.qg.execute(new Runnable() { // from class: com.byazt.gp.fs.3
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    fs.this.qg(list, set, set2, map);
                }
            });
        } catch (RejectedExecutionException unused) {
            this.s.set(false);
        } catch (Throwable unused2) {
            this.s.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(List<x.fs> list, Set<String> set, Set<String> set2, Map<String, Integer> map) throws Throwable {
        boolean zN;
        try {
            zN = n(set);
            try {
                boolean z = true;
                zN = n(set2) || zN;
                if (!n(list, map) && !zN) {
                    z = false;
                }
                this.s.set(false);
                if (z && this.x.n()) {
                    x();
                }
            } catch (Throwable th) {
                th = th;
                this.s.set(false);
                if (zN && this.x.n()) {
                    x();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            zN = false;
        }
    }

    private boolean n(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        return this.x.n(set);
    }

    private void x() {
        if (this.l.compareAndSet(false, true)) {
            try {
                this.rv.n(new Runnable() { // from class: com.byazt.gp.fs.4
                    @Override // java.lang.Runnable
                    public void run() {
                        fs.this.l.set(false);
                        fs.this.qg(4);
                    }
                }, TimeUnit.SECONDS.toMillis(5L));
            } catch (Throwable unused) {
                this.l.set(false);
            }
        }
    }

    private boolean n(List<x.fs> list, Map<String, Integer> map) {
        if (list != null && !list.isEmpty() && map != null && !map.isEmpty()) {
            HashMap map2 = new HashMap();
            for (x.fs fsVar : list) {
                if (fsVar != null && !TextUtils.isEmpty(fsVar.n)) {
                    map2.put(fsVar.n, fsVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                x.fs fsVar2 = (x.fs) map2.get(entry.getKey());
                Integer value = entry.getValue();
                if (fsVar2 != null && value != null && this.x.delete(fsVar2.n)) {
                    arrayList.add(new x.qg(fsVar2, value.intValue()));
                }
            }
            com.byazt.gp.s.n(arrayList);
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void qg() {
        if (this.q.compareAndSet(false, true)) {
            this.rv.n(new Runnable() { // from class: com.byazt.gp.fs.5
                @Override // java.lang.Runnable
                public void run() {
                    fs.this.qg(2);
                }
            }, TimeUnit.SECONDS.toMillis(10L));
        }
    }

    public void s() {
        if (com.byazt.vyf.s.cy().lh() || this.w.getAndSet(true)) {
            return;
        }
        qg(3);
    }

    public void q() {
        if (com.byazt.vyf.s.cy().lh()) {
            return;
        }
        this.w.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final int i) {
        try {
            this.qg.execute(new Runnable() { // from class: com.byazt.gp.fs.6
                @Override // java.lang.Runnable
                public void run() {
                    fs.this.n(i);
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS})
    private static final class l implements qg {
        public final x n;

        public l(x xVar) {
            this.n = xVar;
        }

        @Override // com.byazt.gp.fs.qg
        public x.w n(byte[] bArr, String str, String str2, long j) {
            return this.n.n(bArr, str, str2, j);
        }

        @Override // com.byazt.gp.fs.qg
        public boolean n(x.w wVar) {
            return this.n.n(wVar);
        }

        @Override // com.byazt.gp.fs.qg
        public x.n n(long j, boolean z) {
            return this.n.n(j, z);
        }

        @Override // com.byazt.gp.fs.qg
        public boolean n() {
            return this.n.n();
        }

        @Override // com.byazt.gp.fs.qg
        public boolean delete(String str) {
            return this.n.delete(str);
        }

        @Override // com.byazt.gp.fs.qg
        public boolean n(Set<String> set) {
            return this.n.n((Collection<String>) set);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, 124})
    private static final class w implements s {
        public final rv n;

        public w(rv rvVar) {
            this.n = rvVar;
        }

        @Override // com.byazt.gp.fs.s
        public void n(com.byazt.ng.qg.n nVar, List<x.fs> list, rv.qg qgVar) {
            this.n.n(nVar, list, qgVar);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 80, 129})
    private static final class q implements n {
        private q() {
        }

        @Override // com.byazt.gp.fs.n
        public boolean n() {
            return com.byazt.rb.l.l();
        }

        @Override // com.byazt.gp.fs.n
        public int n(long j) {
            oa oaVar = (oa) com.byazt.qp.q.n("device_info_new");
            if (oaVar == null) {
                return 0;
            }
            return oaVar.n(j);
        }

        @Override // com.byazt.gp.fs.n
        public void n(Runnable runnable, long j) {
            com.byazt.tk.rv.s().postDelayed(runnable, j);
        }
    }
}
