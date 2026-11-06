package com.byazt.ri;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.hg.of;
import com.byazt.ku.uc;
import com.byazt.sd.a;
import com.byazt.sd.g;
import com.byazt.sd.yb;
import com.byazt.sd.zo;
import com.byazt.vkw.qi;
import com.byazt.wt.ls;
import com.byazt.wt.ww;
import com.byazt.xlm.fw;
import com.mar.sdk.MARCode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 697, 37})
public abstract class pr extends hn implements qi.pr {
    public final String aj;
    public HashSet<Integer> fw;
    public boolean g;
    public of hn;
    public boolean ho;
    public com.byazt.hg.c hw;
    public volatile Runnable k;
    public Function<SparseArray<Object>, Object> m;
    public String nt;
    public volatile com.byazt.wr.hn ny;
    public WeakReference<Context> pr;
    public g vk;
    public String x;
    public com.byazt.nv.x zo;
    public final AtomicInteger c = new AtomicInteger(1);
    public final AtomicBoolean uc = new AtomicBoolean(false);
    public C0176pr w = new C0176pr();
    public List<yb> fo = new CopyOnWriteArrayList();
    public AtomicBoolean rc = new AtomicBoolean(false);
    public final com.byazt.qp.hw yb = new com.byazt.qp.hw() { // from class: com.byazt.ri.pr.1
        @Override // com.byazt.bek.DownloadStatusChangeListener
        public void onIdle() {
            pr.this.c.set(1);
            if (com.byazt.iy.hw.pr()) {
                pr.this.pr("onIdle", 0L, 0L, null, null);
            } else if (pr.this.zo != null) {
                pr.this.zo.pr();
            }
        }

        @Override // com.byazt.qp.hw
        public void onDownloadStart() {
            com.byazt.qd.pr.hn(pr.this.nt(), 1);
            pr.this.c.set(2);
            if (com.byazt.iy.hw.pr()) {
                pr.this.pr("onIdle", 0L, 0L, null, null);
            } else if (pr.this.zo != null) {
                pr.this.zo.pr();
            }
        }

        @Override // com.byazt.qp.hw
        public void onDownloadActive(long j, long j2, String str) {
            if (pr.this.rc.get()) {
                pr.this.rc.set(false);
                com.byazt.qd.pr.hn(pr.this.nt(), 2);
            }
            pr.this.c.set(3);
            if (com.byazt.iy.hw.pr()) {
                pr prVar = pr.this;
                prVar.pr("onDownloadActive", j, j2, str, prVar.hw.hn());
            } else if (pr.this.zo != null) {
                pr.this.zo.pr(j, j2, str, pr.this.hw.hn());
            }
        }

        @Override // com.byazt.qp.hw
        public void onDownloadPaused(long j, long j2, String str) {
            com.byazt.qd.pr.hn(pr.this.nt());
            pr.this.rc.set(true);
            pr.this.c.set(4);
            if (com.byazt.iy.hw.pr()) {
                pr prVar = pr.this;
                prVar.pr("onDownloadPaused", j, j2, str, prVar.hw.hn());
            } else if (pr.this.zo != null) {
                pr.this.zo.hw(j, j2, str, pr.this.hw.hn());
            }
        }

        @Override // com.byazt.qp.hw
        public void onDownloadFailed(long j, long j2, String str) {
            com.byazt.qd.pr.x(pr.this.nt(), 1);
            pr.this.c.set(5);
            if (com.byazt.iy.hw.pr()) {
                pr prVar = pr.this;
                prVar.pr("onDownloadFailed", j, j2, str, prVar.hw.hn());
            } else if (pr.this.zo != null) {
                pr.this.zo.hn(j, j2, str, pr.this.hw.hn());
            }
        }

        @Override // com.byazt.qp.hw
        public void onInstalled(long j, long j2, String str) {
            String str2;
            com.byazt.qd.pr.c(pr.this.nt(), 1);
            pr.this.c.set(7);
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = str;
            }
            if (com.byazt.iy.hw.pr()) {
                pr prVar = pr.this;
                prVar.pr("onInstalled", j, j2, str2, prVar.hw.hn());
            } else if (pr.this.zo != null) {
                pr.this.zo.pr(str2, pr.this.hw.hn());
            }
        }

        @Override // com.byazt.qp.hw
        public void onDownloadFinished(long j, long j2, String str) {
            com.byazt.qd.pr.c(pr.this.nt());
            pr.this.c.set(6);
            if (com.byazt.iy.hw.pr()) {
                pr prVar = pr.this;
                prVar.pr("onDownloadFinished", j, j2, str, prVar.hw.hn());
            } else if (pr.this.zo != null) {
                pr.this.zo.pr(j, str, pr.this.hw.hn());
            }
        }
    };
    public com.byazt.wt.pr.hw lb = new com.byazt.wt.pr.hw() { // from class: com.byazt.ri.pr.2
        @Override // com.byazt.wt.pr.hw
        public void pr() {
        }

        @Override // com.byazt.wt.pr.hw
        public void hw() {
            if (!zo.nt().y()) {
                com.byazt.qd.pr.hw(pr.this.nt());
                zo.nt().hn().hw(pr.this.lb);
            }
        }

        @Override // com.byazt.wt.pr.hw
        public void hn() {
        }

        @Override // com.byazt.wt.pr.hw
        public void x() {
        }
    };
    public final com.byazt.bek.hw qa = new com.byazt.bek.hw() { // from class: com.byazt.ri.pr.3
        @Override // com.byazt.bek.hw
        public void pr() {
            com.byazt.qd.pr.hw(pr.this.nt(), 1);
            zo.nt().hn().pr(pr.this.lb);
        }

        @Override // com.byazt.bek.hw
        public void hw() {
            com.byazt.qd.pr.hw(pr.this.nt(), 2);
        }
    };

    public abstract void c(boolean z);

    public abstract void k();

    public abstract void m();

    @Override // com.byazt.nv.hn
    public abstract void pr(int i);

    public abstract void vk();

    public pr(Context context, of ofVar, String str, String str2) {
        this.nt = str2;
        this.pr = new WeakReference<>(context);
        this.hn = ofVar;
        this.hw = ofVar.ho();
        str = TextUtils.isEmpty(str) ? ls.hw(ofVar) : str;
        this.x = TextUtils.isEmpty(str) ? com.byazt.pfl.hw.AD_TAG_FEED : str;
        this.aj = ofVar.hashCode() + ofVar.ny();
        this.m = zo.nt().ls();
        if (this.hw == null && TextUtils.isEmpty(this.nt)) {
            return;
        }
        if (this.hw == null) {
            com.byazt.hg.c cVar = new com.byazt.hg.c();
            this.hw = cVar;
            cVar.hw(this.nt);
        }
        if (a.getContext() == null) {
            a.pr(context);
        }
        this.zo = new com.byazt.nv.x();
        pr();
    }

    @Override // com.byazt.nv.hn
    public void pr() {
        m();
        k();
    }

    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.pr;
            if (weakReference == null) {
                return a.getContext();
            }
            Context context = weakReference.get();
            if (context == null) {
                return a.getContext();
            }
            return context;
        } catch (Throwable th) {
            return a.getContext();
        }
    }

    public com.byazt.wr.hn fw() {
        if (this.ny == null) {
            synchronized (this) {
                if (this.ny == null) {
                    this.ny = new com.byazt.wr.hn(getContext(), this.hn);
                }
            }
        }
        return this.ny;
    }

    @Override // com.byazt.nv.hn
    public void pr(com.byazt.nv.pr prVar) {
        pr(prVar, true);
    }

    @Override // com.byazt.nv.hn
    public void pr(com.byazt.nv.pr prVar, boolean z) {
        if (prVar == null) {
            return;
        }
        com.byazt.nv.x xVar = this.zo;
        if (xVar != null) {
            xVar.pr(prVar);
        }
        if (z) {
            hw(prVar);
        }
        k();
    }

    @Override // com.byazt.nv.hn
    public void pr(int i, com.byazt.lm.hn.pr prVar) {
        if (this.fw == null) {
            this.fw = new HashSet<>();
        }
        this.fw.add(Integer.valueOf(i));
        if (this.m != null) {
            this.m.apply(com.byazt.xi.hw.pr().pr(9).pr(Void.class).pr(0, new ww().pr("hid", Integer.valueOf(i)).pr("id", Integer.valueOf(i)).pr("onEventLogHandler", prVar).pr("hashCode", Integer.valueOf(g()))).hw());
        }
    }

    /* JADX INFO: renamed from: com.byazt.ri.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 697, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public class C0176pr extends fw {
        public String c;
        public long hn;
        public long hw;
        public String pr;
        public String x;

        public C0176pr() {
            super("DownloadCallbackRunnable");
        }

        public C0176pr(String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.pr = str;
            this.hw = j;
            this.hn = j2;
            this.x = str2;
            this.c = str3;
        }

        public void pr(String str) {
            this.pr = str;
        }

        public void pr(long j) {
            this.hw = j;
        }

        public void hw(long j) {
            this.hn = j;
        }

        public void hw(String str) {
            this.x = str;
        }

        public void hn(String str) {
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                pr.this.zo().pr(pr.this.aj, this.pr, this.hw, this.hn, this.x, this.c);
            } catch (Throwable th) {
            }
        }
    }

    public g zo() {
        if (this.vk == null) {
            this.vk = com.byazt.us.hw.pr(com.byazt.gt.pr.pr(a.getContext()).pr(3));
        }
        return this.vk;
    }

    public void aj() {
        Activity activity;
        if (this.pr == null) {
            return;
        }
        Context context = getContext();
        if (!(context instanceof Activity)) {
            activity = null;
        } else {
            activity = (Activity) context;
        }
        if (activity != null && zo.nt().pr(activity)) {
            pr(activity);
        } else {
            ho();
        }
    }

    private void pr(Activity activity) {
        com.byazt.wt.pr prVarHn = zo.nt().hn();
        if (prVarHn != null && this.k == null) {
            this.k = new Runnable() { // from class: com.byazt.ri.pr.4
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.ho();
                    pr.this.k = null;
                }
            };
            prVarHn.pr(activity, this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho() {
        if (!com.byazt.iy.hw.pr()) {
            return;
        }
        com.byazt.xlm.c.hn().execute(new Runnable() { // from class: com.byazt.ri.pr.5
            @Override // java.lang.Runnable
            public void run() {
                g gVarPr = com.byazt.us.hw.pr(com.byazt.gt.pr.pr(a.getContext()).pr(3));
                try {
                    synchronized (pr.this.fo) {
                        if (gVarPr != null) {
                            if (pr.this.fo.size() > 0) {
                                Iterator it = pr.this.fo.iterator();
                                while (it.hasNext()) {
                                    gVarPr.hw(pr.this.aj, (yb) it.next());
                                }
                                pr.this.fo.clear();
                            }
                        }
                    }
                } catch (RemoteException e) {
                }
            }
        });
    }

    public void hw(final com.byazt.nv.pr prVar) {
        if (!com.byazt.iy.hw.pr() || prVar == null) {
            return;
        }
        com.byazt.xlm.c.hn().execute(new Runnable() { // from class: com.byazt.ri.pr.6
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gt.pr prVarPr = com.byazt.gt.pr.pr(a.getContext());
                uc ucVar = new uc(prVar);
                g gVarPr = com.byazt.us.hw.pr(prVarPr.pr(3));
                if (gVarPr != null) {
                    try {
                        gVarPr.pr(pr.this.aj, ucVar);
                        synchronized (pr.this.fo) {
                            pr.this.fo.add(ucVar);
                        }
                    } catch (RemoteException e) {
                    }
                }
            }
        });
    }

    @Override // com.byazt.nv.hn
    public void hw() {
        if (a.getContext() == null) {
            a.pr(getContext());
        }
        k();
    }

    @Override // com.byazt.nv.hn
    public void hn() {
        com.byazt.nv.x xVar = this.zo;
        if (xVar != null) {
            xVar.hw();
        }
        vk();
        HashSet<Integer> hashSet = this.fw;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.fw);
            this.fw.clear();
            final Iterator it = hashSet2.iterator();
            com.byazt.zp.zo.pr(new fw("remove_log_hanlder") { // from class: com.byazt.ri.pr.7
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        if (pr.this.m != null) {
                            pr.this.m.apply(com.byazt.xi.hw.pr().pr(3).pr(Void.class).pr(0, new ww().pr("hid", Integer.valueOf(iIntValue)).pr("hashCode", Integer.valueOf(pr.this.g()))).hw());
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.pr;
        if (weakReference != null) {
            weakReference.clear();
            this.pr = null;
        }
        this.ny = null;
    }

    @Override // com.byazt.ri.hn, com.byazt.nv.hn
    public void pr(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        this.pr = new WeakReference<>(activity);
        if (z) {
            return;
        }
        k();
    }

    public int w() {
        return this.c.get();
    }

    @Override // com.byazt.nv.hn
    public void hn(boolean z) {
        this.g = z;
    }

    @Override // com.byazt.nv.hn
    public Map<String, Object> c() {
        return new HashMap();
    }

    public void pr(String str, long j, long j2, String str2, String str3) {
        C0176pr c0176pr = this.w;
        if (c0176pr == null) {
            this.w = new C0176pr(str, j, j2, str2, str3);
        } else {
            c0176pr.pr(str);
            this.w.pr(j);
            this.w.hw(j2);
            this.w.hw(str2);
            this.w.hn(str3);
        }
        com.byazt.xlm.c.hn().execute(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String nt() {
        of ofVar = this.hn;
        if (ofVar == null) {
            return null;
        }
        return ofVar.z();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.pr.c(nt(), 2);
    }
}
