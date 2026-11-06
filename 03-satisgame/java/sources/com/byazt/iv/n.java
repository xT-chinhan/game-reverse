package com.byazt.iv;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.cq.l;
import com.byazt.hne.ThemeStatusBroadcastReceiver;
import com.byazt.lh.w;
import com.byazt.osr.DynamicRootView;
import com.byazt.tk.rv;
import com.byazt.twc.s;
import com.byazt.udb.cp;
import com.byazt.udb.fs;
import com.byazt.udb.oa;
import com.byazt.udb.q;
import com.byazt.udb.sz;
import com.byazt.udb.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1592, 19})
public class n implements cp, q<DynamicRootView> {
    public fs l;
    public DynamicRootView n;
    public x q;
    public com.byazt.hkc.fs qg;
    public Context s;
    public oa w;
    public ScheduledFuture<?> x;
    public AtomicBoolean fs = new AtomicBoolean(false);
    public volatile boolean rv = false;

    public n(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.hkc.fs fsVar, oa oaVar, com.byazt.xnr.n nVar) {
        this.s = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, oaVar, nVar);
        this.n = dynamicRootView;
        this.qg = fsVar;
        this.w = oaVar;
        dynamicRootView.setRenderListener(this);
        this.w = oaVar;
    }

    @Override // com.byazt.udb.q
    public void n(x xVar) {
        this.q = xVar;
        int iFs = this.w.fs();
        if (iFs < 0) {
            this.n.n(this.qg instanceof com.byazt.hkc.x ? WorkQueueKt.MASK : 117, "time is " + iFs);
            return;
        }
        this.x = l.n(new RunnableC0204n(2), iFs, TimeUnit.MILLISECONDS);
        if (this.rv) {
            rv.s().postDelayed(new Runnable() { // from class: com.byazt.iv.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.x();
                }
            }, this.w.cp());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.w.cp() <= 0) {
            x();
        } else {
            rv.qg().postDelayed(new Runnable() { // from class: com.byazt.iv.n.2
                @Override // java.lang.Runnable
                public void run() {
                    n.this.x();
                }
            }, this.w.cp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.w.x().qg(qg());
        JSONObject jSONObjectL = this.w.l();
        if (!com.byazt.mzw.qg.n(jSONObjectL)) {
            this.n.n(this.qg instanceof com.byazt.hkc.x ? 123 : 113, "data null is " + (jSONObjectL == null));
        } else {
            this.qg.n(new com.byazt.xnr.qg() { // from class: com.byazt.iv.n.3
                @Override // com.byazt.xnr.qg
                public void n(final com.byazt.lh.fs fsVar) {
                    n.this.rv();
                    n.this.w.x().s(n.this.qg());
                    n.this.n(fsVar);
                    n.this.qg(fsVar);
                    if (n.this.rv) {
                        n.this.s(fsVar);
                    } else {
                        rv.qg().post(new Runnable() { // from class: com.byazt.iv.n.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                n.this.s(fsVar);
                            }
                        });
                    }
                    if (n.this.n == null || fsVar == null) {
                        return;
                    }
                    n.this.n.setBgColor(fsVar.n());
                    n.this.n.setBgMaterialCenterCalcColor(fsVar.qg());
                }
            });
            this.qg.n(this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.lh.fs fsVar) {
        List<com.byazt.lh.fs> listCp;
        if (fsVar == null || (listCp = fsVar.cp()) == null || listCp.size() <= 0) {
            return;
        }
        Collections.sort(listCp, new Comparator<com.byazt.lh.fs>() { // from class: com.byazt.iv.n.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.lh.fs fsVar2, com.byazt.lh.fs fsVar3) {
                w wVarL = fsVar2.tj().l();
                w wVarL2 = fsVar3.tj().l();
                if (wVarL == null || wVarL2 == null) {
                    return 0;
                }
                return wVarL.g() >= wVarL2.g() ? 1 : -1;
            }
        });
        for (com.byazt.lh.fs fsVar2 : listCp) {
            if (fsVar2 != null) {
                n(fsVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.lh.fs fsVar) {
        float fX;
        float fW;
        List<com.byazt.lh.fs> listCp;
        if (fsVar == null) {
            return;
        }
        List<com.byazt.lh.fs> listCp2 = fsVar.cp();
        if (listCp2 == null || listCp2.size() <= 0) {
            fX = 0.0f;
        } else {
            fX = 0.0f;
            for (com.byazt.lh.fs fsVar2 : listCp2) {
                if (fsVar2.x() > fsVar.x() - fsVar2.rv() || (listCp = fsVar2.cp()) == null || listCp.size() <= 0) {
                    fW = 0.0f;
                } else {
                    fW = 0.0f;
                    for (com.byazt.lh.fs fsVar3 : listCp) {
                        if (fsVar3.tj().getType().equals("logo-union")) {
                            fW = fsVar3.tj().w();
                            fX = (((-fW) + fsVar.x()) - fsVar2.x()) + fsVar2.tj().l().o();
                        }
                    }
                }
                qg(fsVar2);
                if (fW <= -15.0f) {
                    fsVar2.w(fsVar2.rv() - fW);
                    fsVar2.q(fsVar2.x() + fW);
                    for (com.byazt.lh.fs fsVar4 : fsVar2.cp()) {
                        fsVar4.q(fsVar4.x() - fW);
                    }
                }
            }
        }
        com.byazt.lh.fs fsVarD = fsVar.d();
        if (fsVarD == null) {
            return;
        }
        float fW2 = fsVar.w() - fsVarD.w();
        float fX2 = fsVar.x() - fsVarD.x();
        fsVar.s(fW2);
        fsVar.q(fX2);
        if (fX > 0.0f) {
            fsVar.q(fsVar.x() - fX);
            fsVar.w(fsVar.rv() + fX);
            for (com.byazt.lh.fs fsVar5 : fsVar.cp()) {
                fsVar5.q(fsVar5.x() + fX);
            }
        }
    }

    @Override // com.byazt.udb.q
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public DynamicRootView w() {
        return l();
    }

    @Override // com.byazt.udb.q
    public void n(boolean z) {
        n(w());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                n(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.byazt.osr.l) {
            ((com.byazt.osr.l) view).qg();
        }
    }

    @Override // com.byazt.udb.q
    public int qg() {
        return this.qg instanceof com.byazt.hkc.x ? 3 : 2;
    }

    public void s() {
        this.n.n();
    }

    public void q() {
        this.n.qg();
    }

    public void qg(boolean z) {
        this.n.setSoundMute(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(com.byazt.lh.fs fsVar) {
        if (fsVar == null) {
            this.n.n(this.qg instanceof com.byazt.hkc.x ? 123 : 113, "layoutUnit is null");
            return;
        }
        this.w.x().q(qg());
        try {
            this.n.n(fsVar, qg());
        } catch (Exception e) {
            this.n.n(this.qg instanceof com.byazt.hkc.x ? 128 : 118, "exception is " + e.getMessage());
        }
    }

    public DynamicRootView l() {
        return this.n;
    }

    public void n(fs fsVar) {
        this.l = fsVar;
    }

    private boolean fs() {
        DynamicRootView dynamicRootView = this.n;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    @Override // com.byazt.udb.cp
    public void n(sz szVar) {
        if (this.fs.get()) {
            return;
        }
        this.fs.set(true);
        if (szVar.s() && fs()) {
            this.n.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.q.n(w(), szVar);
            return;
        }
        this.q.n(szVar.cp(), szVar.tj());
    }

    @Override // com.byazt.udb.cp
    public void n(View view, int i, s sVar, int i2) {
        fs fsVar = this.l;
        if (fsVar != null) {
            fsVar.n(view, i, sVar, i2);
        }
    }

    @Override // com.byazt.udb.cp
    public void qg(View view, int i, s sVar, int i2) {
        fs fsVar = this.l;
        if (fsVar != null) {
            fsVar.qg(view, i, sVar, i2);
        }
    }

    public void s(boolean z) {
        this.rv = z;
    }

    /* JADX INFO: renamed from: com.byazt.iv.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1592, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private class RunnableC0204n implements Runnable {
        public int qg;

        public RunnableC0204n(int i) {
            this.qg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.qg == 2) {
                n.this.n.n(n.this.qg instanceof com.byazt.hkc.x ? WorkQueueKt.MASK : 117, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        try {
            ScheduledFuture<?> scheduledFuture = this.x;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.x.cancel(false);
            this.x = null;
        } catch (Throwable unused) {
        }
    }
}
