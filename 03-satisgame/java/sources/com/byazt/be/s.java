package com.byazt.be;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.fvm.oa;
import com.byazt.gct.pk;
import com.byazt.ia.NativeDrawVideoTsView;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.lz.LazeLayout;
import com.byazt.nf.rv;
import com.byazt.tk.hd;
import com.byazt.vgx.w;
import com.byazt.whi.l;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 668, 8})
public class s extends com.byazt.hn.n implements LazeLayout.n<NativeVideoTsView>, com.byazt.lz.n<NativeVideoTsView> {
    public CreativeContainer cp;
    public com.byazt.dc.n d;
    public com.byazt.zq.qg fs;
    public q l;
    public boolean n;
    public com.byazt.vd.n q;
    public Bitmap qg;
    public LazeLayout rv;
    public int s;
    public volatile WeakReference<NativeVideoTsView> tj;
    public final Context w;
    public final pk x;

    /* JADX WARN: Multi-variable type inference failed */
    public s(Context context, pk pkVar, int i, com.byazt.zq.qg qgVar) {
        super(new q(context, pkVar, i, qgVar));
        this.rv = null;
        this.tj = null;
        this.d = new com.byazt.dc.n(0 == true ? 1 : 0) { // from class: com.byazt.be.s.3
            @Override // com.byazt.dc.n
            public void n(View view, oa oaVar) {
                NativeVideoTsView nativeVideoTsViewBb = s.this.l.bb();
                if (nativeVideoTsViewBb != null) {
                    nativeVideoTsViewBb.cp();
                }
            }

            @Override // com.byazt.dc.n
            public void qg(View view, oa oaVar) {
                NativeVideoTsView nativeVideoTsViewBb = s.this.l.bb();
                if (nativeVideoTsViewBb != null) {
                    nativeVideoTsViewBb.cp();
                }
            }

            @Override // com.byazt.dc.n
            public void n(oa oaVar) {
                NativeVideoTsView nativeVideoTsViewBb = s.this.l.bb();
                if (nativeVideoTsViewBb != null) {
                    nativeVideoTsViewBb.wm();
                }
            }
        };
        this.fs = qgVar;
        q qVar = (q) t();
        this.l = qVar;
        this.x = pkVar;
        this.w = context;
        ((l) qVar.v()).n(this.d);
        if (context == null || pk.s(pkVar) || !CreativeContainer.qg(pkVar)) {
            return;
        }
        l lVar = (l) this.l.v();
        this.cp = new CreativeContainer(context, pkVar, lVar != null ? lVar.qg() : null);
    }

    @Override // com.byazt.hn.n, com.byazt.fvm.oa
    public View py() {
        pk pkVar = this.x;
        NativeVideoTsView nativeVideoTsViewQg = null;
        if (pkVar == null || this.w == null) {
            return null;
        }
        if (pk.qg(pkVar)) {
            com.byazt.eji.s.n().n(this.x, 3, "valid invoke");
        }
        if (pk.s(this.x)) {
            if (com.byazt.ag.qg.n()) {
                this.rv = new LazeLayout(this.w, this, this);
            } else {
                try {
                    nativeVideoTsViewQg = qg(this.w);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewQg != null) {
                    n(nativeVideoTsViewQg);
                }
                return nativeVideoTsViewQg;
            }
        } else if (this.cp != null) {
            l lVar = (l) this.l.v();
            if (lVar != null && lVar.t() != null) {
                lVar.t().n(this.cp);
            }
            return this.cp;
        }
        com.byazt.eo.q.n().n(this.x).n(this.l.ln()).qg(this.l.lh());
        return this.rv;
    }

    @Override // com.byazt.lz.n
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView qg(Context context) {
        NativeVideoTsView nativeVideoTsViewN = this.l.n(true);
        nativeVideoTsViewN.setControllerStatusCallBack(new NativeVideoTsView.q() { // from class: com.byazt.be.s.1
            @Override // com.byazt.ia.NativeVideoTsView.q
            public void n(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                s.this.l.n.n = z;
                s.this.l.n.l = j;
                s.this.l.n.w = j2;
                s.this.l.n.x = j3;
                s.this.l.n.q = z2;
                s.this.l.n.fs = z3;
            }
        });
        nativeVideoTsViewN.setAdCreativeClickListener(new NativeVideoTsView.n() { // from class: com.byazt.be.s.2
            @Override // com.byazt.ia.NativeVideoTsView.n
            public void n(View view, int i) {
                com.byazt.whi.q qVarT = ((l) s.this.l.v()).t();
                if (qVarT != null) {
                    qVarT.n(view, i);
                }
            }
        });
        nativeVideoTsViewN.setVideoAdLoadListener(this.l);
        nativeVideoTsViewN.setVideoAdInteractionListener(this.l);
        nativeVideoTsViewN.setIsAutoPlay(n(w.cy(this.x)));
        nativeVideoTsViewN.setIsQuiet(this.x.kj() == 1);
        NativeDrawVideoTsView nativeDrawVideoTsView = (NativeDrawVideoTsView) nativeVideoTsViewN;
        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.n);
        Bitmap bitmap = this.qg;
        if (bitmap != null) {
            nativeDrawVideoTsView.n(bitmap, this.s);
        }
        nativeVideoTsViewN.setDrawVideoListener(this.q);
        this.tj = new WeakReference<>(nativeVideoTsViewN);
        return nativeVideoTsViewN;
    }

    @Override // com.byazt.lz.LazeLayout.n
    public void n(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setNativeRenderAd(true);
            nativeVideoTsView.n(0L, true, false);
        }
    }

    @Override // com.byazt.fvm.oa
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.dc.n nVar, com.byazt.he.q qVar) {
        View viewPy;
        try {
            n(viewGroup, (List<View>) null, list, list2, list3, (View) null, nVar);
            if (qVar != null) {
                View viewFindViewById = viewGroup.findViewById(qVar.d());
                if (viewFindViewById != null && w() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(w());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = com.byazt.okk.s.s(viewGroup.getContext(), 38.0f);
                        layoutParams.height = com.byazt.okk.s.s(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(w());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(qVar.x());
                if (frameLayout == null || (viewPy = py()) == null) {
                    return;
                }
                com.byazt.okk.s.fs(viewPy);
                frameLayout.removeAllViews();
                frameLayout.addView(viewPy, -1, -1);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.qg qgVar) {
        q qVar = this.l;
        if (qVar != null) {
            qVar.n(qgVar);
        }
    }

    @Override // com.byazt.fvm.oa
    public void n(com.byazt.dc.q qVar) {
        q qVar2 = this.l;
        if (qVar2 != null) {
            qVar2.n(qVar);
        }
    }

    @Override // com.byazt.fvm.oa
    public com.byazt.nq.l h() {
        return new com.byazt.fp.s();
    }

    @Override // com.byazt.fvm.rv
    public void n(boolean z) {
        this.n = z;
    }

    @Override // com.byazt.fvm.rv
    public void n(Bitmap bitmap, int i) {
        this.qg = bitmap;
        this.s = i;
        bb();
    }

    @Override // com.byazt.hn.n, com.byazt.fvm.oa
    public void m() {
        NativeVideoTsView nativeVideoTsView;
        super.m();
        if (this.tj != null && (nativeVideoTsView = this.tj.get()) != null) {
            nativeVideoTsView.ou();
        }
        LazeLayout lazeLayout = this.rv;
        if (lazeLayout != null) {
            lazeLayout.n();
        }
        CreativeContainer creativeContainer = this.cp;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(null);
        }
    }

    @Override // com.byazt.fvm.oa
    public String hu() {
        pk pkVar = this.x;
        if (pkVar != null) {
            return pkVar.h();
        }
        return null;
    }

    private boolean n(int i) {
        int iL = rv.qg().l(i);
        if (3 == iL) {
            return false;
        }
        if (1 != iL || !hd.q(this.w)) {
            if (2 == iL) {
                if (!hd.l(this.w) && !hd.q(this.w)) {
                    hd.w(this.w);
                }
            } else if (5 == iL && !hd.q(this.w)) {
                hd.w(this.w);
            }
        }
        return true;
    }

    @Override // com.byazt.fvm.rv
    public void n(com.byazt.vd.n nVar) {
        this.q = nVar;
    }

    private void bb() {
        int i = this.s;
        if (i >= 200) {
            this.s = 200;
        } else if (i <= 20) {
            this.s = 20;
        }
    }
}
