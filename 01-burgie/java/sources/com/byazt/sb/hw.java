package com.byazt.sb;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 765, 13})
public class hw {
    public static volatile hw pr;
    public final long hn;
    public LruCache<String, com.byazt.vc.pr> hw;
    public int x;
    public CopyOnWriteArrayList<String> c = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<String> uc = new CopyOnWriteArrayList<>();
    public ConcurrentHashMap<String, WeakReference<com.byazt.ap.x>> fw = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Long> zo = new ConcurrentHashMap<>();
    public final Object aj = new Object();

    public static /* synthetic */ void pr(hw hwVar, String str) {
    }

    private hw() {
        int iRi = a.hw().ri();
        this.x = iRi;
        if (iRi > 30) {
            this.x = 30;
        } else if (iRi < 0) {
            this.x = 5;
        }
        this.hn = a.hw().tc() * 1000;
        this.hw = new LruCache<String, com.byazt.vc.pr>(this.x) { // from class: com.byazt.sb.hw.1
            @Override // android.util.LruCache
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, com.byazt.vc.pr prVar) {
                return 1;
            }
        };
    }

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    public void pr(of ofVar) {
        if (ofVar == null) {
            return;
        }
        try {
            if (ofVar.hh() == 3) {
                x(ofVar);
            }
        } catch (Throwable th) {
        }
    }

    private void x(final of ofVar) {
        if (TextUtils.isEmpty(ofVar.bd())) {
            return;
        }
        final String strBd = ofVar.bd();
        if (this.c.contains(strBd) || this.uc.contains(strBd) || this.hw.get(strBd) != null) {
            return;
        }
        this.c.add(strBd);
        this.zo.put(strBd, Long.valueOf(System.currentTimeMillis()));
        c.hw(new fw("playable_prefetch") { // from class: com.byazt.sb.hw.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hw.this.pr(ofVar, strBd);
                } catch (Throwable th) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(of ofVar, final String str) {
        com.byazt.pk.hn.pr(ofVar, ofVar == null ? null : ofVar.cg(), new com.byazt.ap.x() { // from class: com.byazt.sb.hw.3
            @Override // com.byazt.ap.x
            public void pr(boolean z, List<of> list, boolean z2) {
                try {
                    if (hw.this.uc != null && hw.this.uc.contains(str)) {
                        hw.pr(hw.this, "prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    hw.pr(hw.this, "prefetchCache-onAdLoaded.. success: ".concat(String.valueOf(z)));
                    synchronized (hw.this.aj) {
                        if (!z || list == null) {
                            hw.this.c.remove(str);
                        } else {
                            if (list.size() > 0) {
                                com.byazt.vc.pr prVar = new com.byazt.vc.pr();
                                prVar.pr = list;
                                prVar.hw = z;
                                prVar.hn = SystemClock.elapsedRealtime();
                                hw.this.hw.put(str, prVar);
                                hw.pr(hw.this, "prefetchCache-onAdLoaded.. 缓存save  key: " + str);
                            }
                            hw.this.c.remove(str);
                        }
                        throw th;
                    }
                    WeakReference weakReference = (WeakReference) hw.this.fw.get(str);
                    com.byazt.ap.x xVar = weakReference == null ? null : (com.byazt.ap.x) weakReference.get();
                    if (xVar != null) {
                        xVar.pr(z, list, true);
                        hw.this.fw.remove(str);
                        hw.pr(hw.this, "prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception e) {
                }
            }
        }, (com.byazt.qe.hw) null);
    }

    public void hw(of ofVar) {
        if (ofVar == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(ofVar.bd())) {
                return;
            }
            String strBd = ofVar.bd();
            this.uc.add(strBd);
            this.hw.remove(strBd);
            this.c.remove(strBd);
            this.fw.remove(strBd);
            this.zo.remove(strBd);
            this.hw.size();
            this.c.size();
            this.uc.size();
        } catch (Exception e) {
        }
    }

    public boolean pr(of ofVar, com.byazt.ap.x xVar) {
        if (ofVar == null || TextUtils.isEmpty(ofVar.bd())) {
            return false;
        }
        String strBd = ofVar.bd();
        try {
            synchronized (this.aj) {
                if (this.c.contains(strBd)) {
                    this.fw.put(strBd, new WeakReference<>(xVar));
                    return true;
                }
                com.byazt.vc.pr prVar = this.hw.get(strBd);
                if (prVar == null) {
                    return false;
                }
                if (pr(prVar)) {
                    hw(ofVar);
                    return false;
                }
                if (xVar != null) {
                    xVar.pr(prVar.hw, prVar.pr, true);
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
        }
    }

    private boolean pr(com.byazt.vc.pr prVar) {
        return this.hn > 0 && prVar != null && SystemClock.elapsedRealtime() - prVar.hn > this.hn;
    }

    public long hn(of ofVar) {
        try {
            if (this.zo != null && ofVar != null && !TextUtils.isEmpty(ofVar.bd())) {
                return this.zo.get(ofVar.bd()).longValue();
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }
}
