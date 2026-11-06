package com.byazt.np;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.oz.RefreshableBannerView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 29})
public class cp {
    public final Runnable cy;
    public final Handler fs;
    public final com.byazt.gl.n k;
    public w l;
    public w q;
    public final SoftReference<Context> qg;
    public com.byazt.gl.n rv;
    public com.byazt.qn.qg s;
    public final View.OnAttachStateChangeListener sz;
    public com.byazt.gl.q tj;
    public RefreshableBannerView w;
    public final Handler x;
    public int n = 0;
    public SoftReference<Activity> cp = new SoftReference<>(null);
    public SoftReference<com.byazt.lr.n> d = new SoftReference<>(null);
    public SoftReference<Map<String, Object>> oa = new SoftReference<>(null);

    /* JADX INFO: renamed from: com.byazt.np.cp$3, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 20, 65})
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cp.this.fs.post(new Runnable() { // from class: com.byazt.np.cp.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (cp.this.n == 0 || cp.this.l == null) {
                        return;
                    }
                    View viewN = cp.this.l.n((Context) cp.this.qg.get());
                    if (viewN != null) {
                        cp.this.n(cp.this.l);
                        if (cp.this.w != null) {
                            cp.this.w.n(viewN);
                        }
                        cp.this.fs.postDelayed(new Runnable() { // from class: com.byazt.np.cp.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (cp.this.q != null) {
                                    cp.this.q.s();
                                }
                                cp.this.q = cp.this.l;
                                cp.this.hd();
                            }
                        }, 250L);
                    } else {
                        if (cp.this.l != null) {
                            cp.this.l.s();
                        }
                        cp.this.hd();
                    }
                    cp.this.k();
                }
            });
        }
    }

    public cp(Context context) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.byazt.np.cp.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (cp.this.n == 0) {
                    return;
                }
                cp.this.hd();
                cp.this.k();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                cp.this.cy();
            }
        };
        this.sz = onAttachStateChangeListener;
        this.k = new com.byazt.gl.n() { // from class: com.byazt.np.cp.2
            @Override // com.byazt.gl.n
            public void n() {
                cp.this.cy();
                if (cp.this.rv != null) {
                    cp.this.rv.n();
                }
            }

            @Override // com.byazt.gl.n
            public void n(View view) {
                if (cp.this.rv != null) {
                    cp.this.rv.n(view);
                }
            }

            @Override // com.byazt.gl.n
            public void qg(View view) {
                if (cp.this.rv != null) {
                    cp.this.rv.qg(view);
                }
            }

            @Override // com.byazt.gl.n
            public void n(com.byazt.mj.n nVar) {
                if (cp.this.rv != null) {
                    cp.this.rv.n(nVar);
                }
            }
        };
        this.cy = new AnonymousClass3();
        this.qg = new SoftReference<>(context);
        this.q = new w(context);
        if (context != null) {
            RefreshableBannerView refreshableBannerView = new RefreshableBannerView(context);
            this.w = refreshableBannerView;
            refreshableBannerView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.w.setVisibilityChangeListener(new RefreshableBannerView.n() { // from class: com.byazt.np.cp.4
                @Override // com.byazt.oz.RefreshableBannerView.n
                public void n(boolean z) {
                    if (z) {
                        if (cp.this.n == 0) {
                            return;
                        }
                        cp.this.k();
                        return;
                    }
                    cp.this.cy();
                }
            });
        }
        this.x = new Handler(com.byazt.rb.l.qg());
        this.fs = new Handler(Looper.getMainLooper());
    }

    private void n(com.byazt.qn.qg qgVar) {
        com.byazt.ws.qg qgVarN;
        if (qgVar == null || (qgVarN = com.byazt.qt.qg.n().n(qgVar.a(), 1, 100)) == null) {
            return;
        }
        int iCp = qgVarN.cp(1);
        if (iCp >= 10000 && iCp <= 180000) {
            this.n = iCp;
            com.byazt.rb.qg.n("TMe", "---==-----banner轮播时间：" + this.n);
        } else {
            com.byazt.rb.qg.n("TMe", "---==-----banner轮播时间下发不在10*1000～180*1000范围内：" + iCp + "，禁止banner轮播");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.x.removeCallbacksAndMessages(null);
        this.x.postDelayed(this.cy, this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy() {
        this.x.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hd() {
        Context context;
        SoftReference<Context> softReference = this.qg;
        if (softReference == null || (context = softReference.get()) == null) {
            return;
        }
        w wVar = new w(context);
        this.l = wVar;
        wVar.n(this.k);
        this.l.n(this.tj);
        n(this.s);
        this.l.n(new com.byazt.qn.qg(this.s), (com.byazt.gl.qg) null);
    }

    public void n(com.byazt.qn.qg qgVar, com.byazt.gl.qg qgVar2) {
        SoftReference<Context> softReference;
        if (this.q == null || (softReference = this.qg) == null || softReference.get() == null) {
            return;
        }
        this.s = qgVar;
        n(qgVar);
        if (!com.byazt.qt.qg.n().n(qgVar.a(), 1) && qgVar2 != null) {
            qgVar2.n(new com.byazt.mj.n(840031, com.byazt.mj.n.n(840031)));
        } else if (com.byazt.qt.qg.n().ur()) {
            this.q.n(this.s, qgVar2);
        } else if (qgVar2 != null) {
            qgVar2.n(new com.byazt.mj.n(840032, com.byazt.mj.n.n(840032)));
        }
    }

    public void n(com.byazt.gl.n nVar) {
        this.rv = nVar;
        w wVar = this.q;
        if (wVar != null) {
            wVar.n(this.k);
        }
    }

    public void n(com.byazt.gl.q qVar) {
        this.tj = qVar;
        w wVar = this.q;
        if (wVar != null) {
            wVar.n(qVar);
        }
    }

    public void n() {
        w wVar = this.q;
        if (wVar != null) {
            wVar.w();
        }
    }

    public void qg() {
        w wVar = this.q;
        if (wVar != null) {
            wVar.py();
        }
    }

    public void s() {
        this.fs.removeCallbacksAndMessages(null);
        cy();
        RefreshableBannerView refreshableBannerView = this.w;
        if (refreshableBannerView != null) {
            refreshableBannerView.removeOnAttachStateChangeListener(this.sz);
        }
        w wVar = this.q;
        if (wVar != null) {
            wVar.s();
        }
        w wVar2 = this.l;
        if (wVar2 != null) {
            wVar2.s();
        }
    }

    public boolean q() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.q();
        }
        return false;
    }

    public View l() {
        w wVar = this.q;
        if (wVar == null) {
            return null;
        }
        View viewN = wVar.n(this.qg.get());
        w wVar2 = this.q;
        wVar2.n(wVar2.q);
        if (viewN == null || this.w == null) {
            return null;
        }
        viewN.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.byazt.np.cp.5
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (view.getVisibility() == 0) {
                    cp cpVar = cp.this;
                    cpVar.n(cpVar.q);
                    view.removeOnLayoutChangeListener(this);
                }
            }
        });
        this.w.removeAllViews();
        ViewParent parent = viewN.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(viewN);
        }
        this.w.addView(viewN);
        return this.w;
    }

    public int w() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.l();
        }
        return 0;
    }

    public Map<String, Object> x() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.hd();
        }
        return new HashMap();
    }

    public List<com.byazt.mj.qg> fs() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.tj();
        }
        return new ArrayList();
    }

    public List<com.byazt.mj.s> rv() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.cp();
        }
        return null;
    }

    public com.byazt.mj.s tj() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.k();
        }
        return null;
    }

    public List<com.byazt.mj.s> cp() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    public com.byazt.mj.s d() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.f_();
        }
        return null;
    }

    public int oa() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.cy();
        }
        return -1;
    }

    public void n(com.byazt.mi.s sVar) {
        w wVar = this.q;
        if (wVar != null) {
            wVar.n(sVar);
        }
    }

    public void n(com.byazt.mi.qg qgVar) {
        w wVar = this.q;
        if (wVar != null) {
            wVar.qg(qgVar);
        }
    }

    public void n(com.byazt.fx.s sVar) {
        w wVar = this.q;
        if (wVar != null) {
            wVar.n(sVar);
        }
    }

    public void n(Activity activity, com.byazt.lr.n nVar) {
        this.cp = new SoftReference<>(activity);
        this.d = new SoftReference<>(nVar);
    }

    public void n(Dialog dialog, Integer[] numArr) {
        HashMap map = new HashMap();
        map.put("dislike_dialog", dialog);
        map.put("dislike_ids", numArr);
        this.oa = new SoftReference<>(map);
    }

    public com.byazt.fvm.x n(Activity activity) {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.n(activity);
        }
        return null;
    }

    public com.byazt.fvm.q sz() {
        w wVar = this.q;
        if (wVar != null) {
            return wVar.ou();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(w wVar) {
        Map<String, Object> map = this.oa.get();
        if (map != null) {
            Dialog dialog = (Dialog) map.get("dislike_dialog");
            Integer[] numArr = (Integer[]) map.get("dislike_ids");
            if (dialog != null && numArr != null) {
                wVar.n(dialog, numArr);
            }
        }
        Activity activity = this.cp.get();
        com.byazt.lr.n nVar = this.d.get();
        if (activity == null || nVar == null) {
            return;
        }
        wVar.n(activity, nVar);
    }

    public void n(String str) {
        w wVar = this.q;
        if (wVar != null) {
            wVar.q(str);
        }
    }
}
