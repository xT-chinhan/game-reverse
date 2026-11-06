package com.byazt.ltk;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.gct.pk;
import com.byazt.gct.ri;
import com.byazt.nf.rv;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.uv.q;
import com.byazt.zq.qg;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1687, 19})
public class n {
    public static volatile n n;
    public int q;
    public LruCache<String, ri> qg;
    public final long s;
    public CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<String> w = new CopyOnWriteArrayList<>();
    public ConcurrentHashMap<String, WeakReference<q>> x = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Long> fs = new ConcurrentHashMap<>();
    public final Object rv = new Object();

    public static /* synthetic */ void n(n nVar, String str) {
    }

    private n() {
        int iVk = rv.qg().vk();
        this.q = iVk;
        if (iVk > 30) {
            this.q = 30;
        } else if (iVk < 0) {
            this.q = 5;
        }
        this.s = rv.qg().wn() * 1000;
        this.qg = new LruCache<String, ri>(this.q) { // from class: com.byazt.ltk.n.1
            @Override // android.util.LruCache
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, ri riVar) {
                return 1;
            }
        };
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void n(pk pkVar) {
        if (pkVar != null) {
            try {
                if (pkVar.nc() == 3) {
                    q(pkVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void q(final pk pkVar) {
        if (TextUtils.isEmpty(pkVar.fe())) {
            return;
        }
        final String strFe = pkVar.fe();
        if (this.l.contains(strFe) || this.w.contains(strFe) || this.qg.get(strFe) != null) {
            return;
        }
        this.l.add(strFe);
        this.fs.put(strFe, Long.valueOf(System.currentTimeMillis()));
        l.qg(new x("playable_prefetch") { // from class: com.byazt.ltk.n.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.n(pkVar, strFe);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(pk pkVar, final String str) {
        com.byazt.jc.q.n(pkVar, pkVar == null ? null : pkVar.vh(), new q() { // from class: com.byazt.ltk.n.3
            @Override // com.byazt.uv.q
            public void n(boolean z, List<pk> list, boolean z2) {
                try {
                    if (n.this.w != null && n.this.w.contains(str)) {
                        n.n(n.this, "prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    n.n(n.this, "prefetchCache-onAdLoaded.. success: ".concat(String.valueOf(z)));
                    synchronized (n.this.rv) {
                        if (!z || list == null) {
                            n.this.l.remove(str);
                        } else {
                            if (list.size() > 0) {
                                ri riVar = new ri();
                                riVar.n = list;
                                riVar.qg = z;
                                riVar.s = SystemClock.elapsedRealtime();
                                n.this.qg.put(str, riVar);
                                n.n(n.this, "prefetchCache-onAdLoaded.. 缓存save  key: " + str);
                            }
                            n.this.l.remove(str);
                        }
                        throw th;
                    }
                    WeakReference weakReference = (WeakReference) n.this.x.get(str);
                    q qVar = weakReference == null ? null : (q) weakReference.get();
                    if (qVar != null) {
                        qVar.n(z, list, true);
                        n.this.x.remove(str);
                        n.n(n.this, "prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception unused) {
                }
            }
        }, (qg) null);
    }

    public void qg(pk pkVar) {
        if (pkVar != null) {
            try {
                if (TextUtils.isEmpty(pkVar.fe())) {
                    return;
                }
                String strFe = pkVar.fe();
                this.w.add(strFe);
                this.qg.remove(strFe);
                this.l.remove(strFe);
                this.x.remove(strFe);
                this.fs.remove(strFe);
                this.qg.size();
                this.l.size();
                this.w.size();
            } catch (Exception unused) {
            }
        }
    }

    public boolean n(pk pkVar, q qVar) {
        if (pkVar != null && !TextUtils.isEmpty(pkVar.fe())) {
            String strFe = pkVar.fe();
            try {
                synchronized (this.rv) {
                    if (this.l.contains(strFe)) {
                        this.x.put(strFe, new WeakReference<>(qVar));
                        return true;
                    }
                    ri riVar = this.qg.get(strFe);
                    if (riVar == null) {
                        return false;
                    }
                    if (n(riVar)) {
                        qg(pkVar);
                        return false;
                    }
                    if (qVar != null) {
                        qVar.n(riVar.qg, riVar.n, true);
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean n(ri riVar) {
        return this.s > 0 && riVar != null && SystemClock.elapsedRealtime() - riVar.s > this.s;
    }

    public long s(pk pkVar) {
        try {
            if (this.fs == null || pkVar == null || TextUtils.isEmpty(pkVar.fe())) {
                return 0L;
            }
            return this.fs.get(pkVar.fe()).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }
}
