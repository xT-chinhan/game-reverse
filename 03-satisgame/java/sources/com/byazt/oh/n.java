package com.byazt.oh;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.gct.pk;
import com.byazt.nf.fs;
import com.byazt.nf.rv;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.DownloadListenerTask;
import com.byazt.pmn.TTAppDownloadListenerGroup;
import com.byazt.qit.x;
import com.byazt.vf.wo;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, 19})
public abstract class n extends s implements wo.n {
    public String cy;
    public volatile Runnable d;
    public TTAppDownloadListenerGroup fs;
    public boolean k;
    public WeakReference<Context> n;
    public Function<SparseArray<Object>, Object> oa;
    public volatile com.byazt.wif.s ou;
    public String q;
    public com.byazt.gct.l qg;
    public final String rv;
    public pk s;
    public boolean sz;
    public com.byazt.nf.l tj;
    public HashSet<Integer> x;
    public final AtomicInteger l = new AtomicInteger(1);
    public final AtomicBoolean w = new AtomicBoolean(false);
    public C0280n cp = new C0280n();
    public List<fs> wm = new CopyOnWriteArrayList();
    public AtomicBoolean m = new AtomicBoolean(false);
    public final com.byazt.myr.qg hd = new com.byazt.myr.qg() { // from class: com.byazt.oh.n.1
        @Override // com.byazt.hj.DownloadStatusChangeListener
        public void onIdle() {
            n.this.l.set(1);
            if (com.byazt.byp.qg.n()) {
                n.this.n(DownloadListenerTask.ON_IDLE, 0L, 0L, null, null);
            } else if (n.this.fs != null) {
                n.this.fs.onIdle();
            }
        }

        @Override // com.byazt.myr.qg
        public void onDownloadStart() {
            com.byazt.de.n.s(n.this.tj(), 1);
            n.this.l.set(2);
            if (com.byazt.byp.qg.n()) {
                n.this.n(DownloadListenerTask.ON_IDLE, 0L, 0L, null, null);
            } else if (n.this.fs != null) {
                n.this.fs.onIdle();
            }
        }

        @Override // com.byazt.myr.qg
        public void onDownloadActive(long j, long j2, String str) {
            if (n.this.m.get()) {
                n.this.m.set(false);
                com.byazt.de.n.s(n.this.tj(), 2);
            }
            n.this.l.set(3);
            if (com.byazt.byp.qg.n()) {
                n nVar = n.this;
                nVar.n(DownloadListenerTask.ON_DOWNLOAD_ACTIVE, j, j2, str, nVar.qg.s());
            } else if (n.this.fs != null) {
                n.this.fs.onDownloadActive(j, j2, str, n.this.qg.s());
            }
        }

        @Override // com.byazt.myr.qg
        public void onDownloadPaused(long j, long j2, String str) {
            com.byazt.de.n.s(n.this.tj());
            n.this.m.set(true);
            n.this.l.set(4);
            if (com.byazt.byp.qg.n()) {
                n nVar = n.this;
                nVar.n(DownloadListenerTask.ON_DOWNLOAD_PAUSED, j, j2, str, nVar.qg.s());
            } else if (n.this.fs != null) {
                n.this.fs.onDownloadPaused(j, j2, str, n.this.qg.s());
            }
        }

        @Override // com.byazt.myr.qg
        public void onDownloadFailed(long j, long j2, String str) {
            com.byazt.de.n.q(n.this.tj(), 1);
            n.this.l.set(5);
            if (com.byazt.byp.qg.n()) {
                n nVar = n.this;
                nVar.n(DownloadListenerTask.ON_DOWNLOAD_FAILED, j, j2, str, nVar.qg.s());
            } else if (n.this.fs != null) {
                n.this.fs.onDownloadFailed(j, j2, str, n.this.qg.s());
            }
        }

        @Override // com.byazt.myr.qg
        public void onInstalled(long j, long j2, String str) {
            com.byazt.de.n.l(n.this.tj(), 1);
            n.this.l.set(7);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String str2 = str;
            if (com.byazt.byp.qg.n()) {
                n nVar = n.this;
                nVar.n(DownloadListenerTask.ON_INSTALLED, j, j2, str2, nVar.qg.s());
            } else if (n.this.fs != null) {
                n.this.fs.onInstalled(str2, n.this.qg.s());
            }
        }

        @Override // com.byazt.myr.qg
        public void onDownloadFinished(long j, long j2, String str) {
            com.byazt.de.n.l(n.this.tj());
            n.this.l.set(6);
            if (com.byazt.byp.qg.n()) {
                n nVar = n.this;
                nVar.n(DownloadListenerTask.ON_DOWNLOAD_FINISHED, j, j2, str, nVar.qg.s());
            } else if (n.this.fs != null) {
                n.this.fs.onDownloadFinished(j, str, n.this.qg.s());
            }
        }
    };
    public com.byazt.ot.n.qg cd = new com.byazt.ot.n.qg() { // from class: com.byazt.oh.n.2
        @Override // com.byazt.ot.n.qg
        public void n() {
        }

        @Override // com.byazt.ot.n.qg
        public void q() {
        }

        @Override // com.byazt.ot.n.qg
        public void s() {
        }

        @Override // com.byazt.ot.n.qg
        public void qg() {
            if (com.byazt.vyf.s.cy().lh()) {
                return;
            }
            com.byazt.de.n.qg(n.this.tj());
            com.byazt.vyf.s.cy().s().qg(n.this.cd);
        }
    };
    public final com.byazt.hj.qg um = new com.byazt.hj.qg() { // from class: com.byazt.oh.n.3
        @Override // com.byazt.hj.qg
        public void n() {
            com.byazt.de.n.qg(n.this.tj(), 1);
            com.byazt.vyf.s.cy().s().n(n.this.cd);
        }

        @Override // com.byazt.hj.qg
        public void qg() {
            com.byazt.de.n.qg(n.this.tj(), 2);
        }
    };

    public abstract void n(boolean z);

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void onPause() {
    }

    public abstract void q();

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public abstract void setCheckCompliance(int i);

    public abstract void w();

    public abstract void x();

    public n(Context context, pk pkVar, String str, String str2) {
        this.cy = str2;
        this.n = new WeakReference<>(context);
        this.s = pkVar;
        this.qg = pkVar.k();
        str = TextUtils.isEmpty(str) ? w.qg(pkVar) : str;
        this.q = TextUtils.isEmpty(str) ? com.byazt.wg.qg.AD_TAG_FEED : str;
        this.rv = pkVar.hashCode() + pkVar.ou();
        this.oa = com.byazt.vyf.s.cy().fi();
        if (this.qg == null && TextUtils.isEmpty(this.cy)) {
            return;
        }
        if (this.qg == null) {
            com.byazt.gct.l lVar = new com.byazt.gct.l();
            this.qg = lVar;
            lVar.qg(this.cy);
        }
        if (rv.getContext() == null) {
            rv.n(context);
        }
        this.fs = new TTAppDownloadListenerGroup();
        init();
        com.byazt.eji.s.n().qg(pkVar);
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void init() {
        x();
        w();
    }

    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.n;
            if (weakReference == null) {
                return rv.getContext();
            }
            Context context = weakReference.get();
            return context == null ? rv.getContext() : context;
        } catch (Throwable unused) {
            return rv.getContext();
        }
    }

    public com.byazt.wif.s n() {
        if (this.ou == null) {
            synchronized (this) {
                if (this.ou == null) {
                    this.ou = new com.byazt.wif.s(getContext(), this.s);
                }
            }
        }
        return this.ou;
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void addAppDownloadListener(AppDownloadListener appDownloadListener) {
        addAppDownloadListener(appDownloadListener, true);
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void addAppDownloadListener(AppDownloadListener appDownloadListener, boolean z) {
        if (appDownloadListener == null) {
            return;
        }
        TTAppDownloadListenerGroup tTAppDownloadListenerGroup = this.fs;
        if (tTAppDownloadListenerGroup != null) {
            tTAppDownloadListenerGroup.add(appDownloadListener);
        }
        if (z) {
            n(appDownloadListener);
        }
        w();
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void addOnEventLogHandler(int i, com.byazt.ms.n.InterfaceC0249n interfaceC0249n) {
        if (this.x == null) {
            this.x = new HashSet<>();
        }
        this.x.add(Integer.valueOf(i));
        if (this.oa != null) {
            this.oa.apply(com.byazt.of.qg.n().n(9).n(Void.class).n(0, new com.byazt.ikv.s().n("hid", Integer.valueOf(i)).n("id", Integer.valueOf(i)).n("onEventLogHandler", interfaceC0249n).n("hashCode", Integer.valueOf(fs()))).qg());
        }
    }

    /* JADX INFO: renamed from: com.byazt.oh.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public class C0280n extends x {
        public String l;
        public String n;
        public String q;
        public long qg;
        public long s;

        public C0280n() {
            super("DownloadCallbackRunnable");
        }

        public C0280n(String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.n = str;
            this.qg = j;
            this.s = j2;
            this.q = str2;
            this.l = str3;
        }

        public void n(String str) {
            this.n = str;
        }

        public void n(long j) {
            this.qg = j;
        }

        public void qg(long j) {
            this.s = j;
        }

        public void qg(String str) {
            this.q = str;
        }

        public void s(String str) {
            this.l = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n.this.qg().n(n.this.rv, this.n, this.qg, this.s, this.q, this.l);
            } catch (Throwable unused) {
            }
        }
    }

    public com.byazt.nf.l qg() {
        if (this.tj == null) {
            this.tj = com.byazt.ptd.qg.n(com.byazt.prx.n.n(rv.getContext()).n(3));
        }
        return this.tj;
    }

    public void s() {
        if (this.n == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && com.byazt.vyf.s.cy().n(activity)) {
            n(activity);
        } else {
            rv();
        }
    }

    private void n(Activity activity) {
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS != null && this.d == null) {
            this.d = new Runnable() { // from class: com.byazt.oh.n.4
                @Override // java.lang.Runnable
                public void run() {
                    n.this.rv();
                    n.this.d = null;
                }
            };
            nVarS.n(activity, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        if (com.byazt.byp.qg.n()) {
            com.byazt.qit.l.s().execute(new Runnable() { // from class: com.byazt.oh.n.5
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.nf.l lVarN = com.byazt.ptd.qg.n(com.byazt.prx.n.n(rv.getContext()).n(3));
                    try {
                        synchronized (n.this.wm) {
                            if (lVarN != null) {
                                if (n.this.wm.size() > 0) {
                                    Iterator it = n.this.wm.iterator();
                                    while (it.hasNext()) {
                                        lVarN.qg(n.this.rv, (fs) it.next());
                                    }
                                    n.this.wm.clear();
                                }
                            }
                        }
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }

    public void n(final AppDownloadListener appDownloadListener) {
        if (!com.byazt.byp.qg.n() || appDownloadListener == null) {
            return;
        }
        com.byazt.qit.l.s().execute(new Runnable() { // from class: com.byazt.oh.n.6
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.prx.n nVarN = com.byazt.prx.n.n(rv.getContext());
                com.byazt.ca.w wVar = new com.byazt.ca.w(appDownloadListener);
                com.byazt.nf.l lVarN = com.byazt.ptd.qg.n(nVarN.n(3));
                if (lVarN != null) {
                    try {
                        lVarN.n(n.this.rv, wVar);
                        synchronized (n.this.wm) {
                            try {
                                n.this.wm.add(wVar);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (RemoteException unused) {
                    }
                }
            }
        });
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void onResume() {
        if (rv.getContext() == null) {
            rv.n(getContext());
        }
        w();
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void onDestroy() {
        TTAppDownloadListenerGroup tTAppDownloadListenerGroup = this.fs;
        if (tTAppDownloadListenerGroup != null) {
            tTAppDownloadListenerGroup.clear();
        }
        q();
        HashSet<Integer> hashSet = this.x;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.x);
            this.x.clear();
            final Iterator it = hashSet2.iterator();
            com.byazt.ag.qg.n(new x("remove_log_hanlder") { // from class: com.byazt.oh.n.7
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        if (n.this.oa != null) {
                            n.this.oa.apply(com.byazt.of.qg.n().n(3).n(Void.class).n(0, new com.byazt.ikv.s().n("hid", Integer.valueOf(iIntValue)).n("hashCode", Integer.valueOf(n.this.fs()))).qg());
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
            this.n = null;
        }
        this.ou = null;
    }

    @Override // com.byazt.oh.s, com.byazt.pmn.ITTInnerDownloadAdapter
    public void setActivity(Activity activity, boolean z) {
        if (activity == null) {
            return;
        }
        this.n = new WeakReference<>(activity);
        if (z) {
            return;
        }
        w();
    }

    public int l() {
        return this.l.get();
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void setClickViewIsButton(boolean z) {
        this.sz = z;
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public Map<String, Object> getParam() {
        return new HashMap();
    }

    public void n(String str, long j, long j2, String str2, String str3) {
        C0280n c0280n = this.cp;
        if (c0280n == null) {
            this.cp = new C0280n(str, j, j2, str2, str3);
        } else {
            c0280n.n(str);
            this.cp.n(j);
            this.cp.qg(j2);
            this.cp.qg(str2);
            this.cp.s(str3);
        }
        com.byazt.qit.l.s().execute(this.cp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tj() {
        pk pkVar = this.s;
        if (pkVar == null) {
            return null;
        }
        return pkVar.h();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.n.l(tj(), 2);
    }
}
