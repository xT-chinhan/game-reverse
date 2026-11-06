package com.byazt.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.byazt.gr.l;
import com.byazt.gr.oa;
import com.byazt.gr.q;
import com.byazt.gr.sz;
import com.byazt.gr.tj;
import com.byazt.gr.w;
import com.byazt.gu.qg;
import com.byazt.hb.fs;
import com.byazt.ih.s;
import com.byazt.jm.RoundImageView;
import com.byazt.vh.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 206, 19})
public class n extends com.byazt.ih.n<YogaLayout> {
    public w dm;
    public sz ei;
    public tj nk;
    public com.byazt.gr.n o;
    public View.OnAttachStateChangeListener qn;
    public l sq;
    public com.byazt.gr.n vo;
    public ViewTreeObserver.OnGlobalLayoutListener ze;

    public n(Context context) {
        super(context);
        this.sq = l.ROW;
        this.ei = sz.NO_WRAP;
        this.dm = w.FLEX_START;
        this.vo = com.byazt.gr.n.STRETCH;
        this.o = com.byazt.gr.n.STRETCH;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: cx, reason: merged with bridge method [inline-methods] */
    public YogaLayout n() {
        YogaLayout yogaLayout = new YogaLayout(this.qg);
        yogaLayout.n(this);
        this.nk = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    @Override // com.byazt.ih.s
    public void h() {
        if (this.dg) {
            if (this.wv != null) {
                this.wv.n();
            }
            com.byazt.gu.w.n().qg().n(this.rv, this.fi, new qg.n() { // from class: com.byazt.ar.n.1
                @Override // com.byazt.gu.qg.n
                public void n(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (n.this.wv != null) {
                            x xVar = n.this.wv;
                            n nVar = n.this;
                            xVar.qg(nVar, nVar.fi);
                            return;
                        }
                        return;
                    }
                    if (n.this.wv != null) {
                        x xVar2 = n.this.wv;
                        n nVar2 = n.this;
                        xVar2.n(nVar2, nVar2.fi);
                    }
                    final Bitmap bitmapN = fs.n(n.this.qg, bitmap, (int) n.this.oj);
                    if (bitmapN != null) {
                        fs.n(new Runnable() { // from class: com.byazt.ar.n.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                n.this.n(new BitmapDrawable(bitmapN));
                            }
                        });
                    }
                }
            });
            return;
        }
        if (this.wv != null) {
            this.wv.n();
        }
        RoundImageView roundImageView = new RoundImageView(this.qg);
        com.byazt.gu.w.n().qg().n(this.rv, this.fi, roundImageView, this.l.getWidth(), this.l.getHeight(), new qg.n() { // from class: com.byazt.ar.n.2
            @Override // com.byazt.gu.qg.n
            public void n(Bitmap bitmap) {
                if (bitmap == null) {
                    if (n.this.wv != null) {
                        x xVar = n.this.wv;
                        n nVar = n.this;
                        xVar.qg(nVar, nVar.fi);
                        return;
                    }
                    return;
                }
                if (n.this.wv != null) {
                    x xVar2 = n.this.wv;
                    n nVar2 = n.this;
                    xVar2.n(nVar2, nVar2.fi);
                }
            }
        });
        if (!this.u || this.df == ImageView.ScaleType.FIT_XY) {
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            roundImageView.setScaleType(this.df);
        }
        roundImageView.setCornerRadius(this.pk);
        YogaLayout.n nVar = new YogaLayout.n(-1, -1);
        nVar.w(oa.ABSOLUTE.n());
        nVar.x(0.0f);
        nVar.fs(0.0f);
        if (this.l instanceof YogaLayout) {
            ((YogaLayout) this.l).addView(roundImageView, 0, nVar);
            n(roundImageView);
        }
    }

    @Override // com.byazt.ih.s
    public void n(Drawable drawable) {
        RoundImageView roundImageView = new RoundImageView(this.qg);
        roundImageView.setImageDrawable(drawable);
        if (!this.u || this.df == ImageView.ScaleType.FIT_XY) {
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            roundImageView.setScaleType(this.df);
        }
        roundImageView.setCornerRadius(this.pk);
        YogaLayout.n nVar = new YogaLayout.n(-1, -1);
        nVar.w(oa.ABSOLUTE.n());
        nVar.x(0.0f);
        nVar.fs(0.0f);
        if (this.l instanceof YogaLayout) {
            ((YogaLayout) this.l).addView(roundImageView, 0, nVar);
            n(roundImageView);
        }
    }

    private void n(final RoundImageView roundImageView) {
        ci();
        this.ze = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.ar.n.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (n.this.l == null) {
                    n.this.ci();
                    return;
                }
                tj tjVarQg = ((YogaLayout) n.this.l).qg(roundImageView);
                if (tjVarQg == null) {
                    return;
                }
                int width = n.this.l.getWidth();
                int height = n.this.l.getHeight();
                tjVarQg.q(width);
                tjVarQg.w(height);
                roundImageView.setCornerRadius(n.this.pk);
                n.this.l.requestLayout();
                if (width > 0 || height > 0) {
                    n.this.ci();
                }
            }
        };
        this.qn = new View.OnAttachStateChangeListener() { // from class: com.byazt.ar.n.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                n.this.ci();
            }
        };
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.ze);
        this.l.addOnAttachStateChangeListener(this.qn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci() {
        if (this.ze != null && this.l != 0) {
            this.l.getViewTreeObserver().removeOnGlobalLayoutListener(this.ze);
            this.ze = null;
        }
        if (this.qn == null || this.l == 0) {
            return;
        }
        this.l.removeOnAttachStateChangeListener(this.qn);
        this.qn = null;
    }

    @Override // com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        super.qg();
        this.nk.n(this.sq);
        this.nk.n(this.ei);
        this.nk.n(this.dm);
        this.nk.n(this.vo);
        this.nk.s(this.o);
        this.nk.n(true);
    }

    @Override // com.byazt.ih.s
    public void d() {
        if (this.lh) {
            this.nk.qg(q.ALL, this.h);
        }
        if (this.v) {
            this.nk.qg(q.LEFT, this.t);
        }
        if (this.j) {
            this.nk.qg(q.RIGHT, this.ur);
        }
        if (this.an) {
            this.nk.qg(q.TOP, this.bb);
        }
        if (this.ae) {
            this.nk.qg(q.BOTTOM, this.ln);
        }
    }

    @Override // com.byazt.ih.n
    public void n(s sVar) {
        super.n(sVar);
    }

    @Override // com.byazt.ih.n
    public void n(s sVar, ViewGroup.LayoutParams layoutParams) {
        if (sVar == null) {
            return;
        }
        this.n.add(sVar);
        View viewRv = sVar.rv();
        if (viewRv != null) {
            ((YogaLayout) this.l).addView(viewRv, layoutParams);
        }
    }

    @Override // com.byazt.ih.n
    /* JADX INFO: renamed from: lq, reason: merged with bridge method [inline-methods] */
    public C0128n fs() {
        return new C0128n(this);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.vo = com.byazt.gr.n.n(str2);
                break;
            case "flexDirection":
                this.sq = l.n(str2);
                break;
            case "alignContent":
                this.o = com.byazt.gr.n.n(str2);
                break;
            case "flexWrap":
                this.ei = sz.n(str2);
                break;
            case "justifyContent":
                this.dm = w.n(str2);
                break;
        }
    }

    public l ic() {
        return this.sq;
    }

    /* JADX INFO: renamed from: com.byazt.ar.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 206, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0128n extends com.byazt.ih.n.C0202n {
        public int ae;
        public int an;
        public int bb;
        public boolean df;
        public boolean dg;
        public float f;
        public boolean fi;
        public int h;
        public int j;
        public int lh;
        public float ln;
        public boolean oj;
        public boolean pk;
        public float t;
        public boolean u;
        public float ur;
        public int v;

        public C0128n(com.byazt.ih.n nVar) {
            super(nVar);
            this.h = 1;
            this.t = 0.0f;
            this.ur = 1.0f;
            this.bb = com.byazt.gr.n.AUTO.n();
            this.ln = -1.0f;
            this.lh = oa.RELATIVE.n();
        }

        @Override // com.byazt.ih.n.C0202n
        public void n(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.n(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.fi = true;
                    float fN = com.byazt.hb.s.n(str2, -1.0f);
                    this.ln = fN;
                    this.ln = fs.n(context, fN);
                    break;
                case "bottom":
                    this.oj = true;
                    this.j = (int) fs.n(context, com.byazt.hb.s.n(str2, 0));
                    break;
                case "top":
                    this.df = true;
                    this.v = (int) fs.n(context, com.byazt.hb.s.n(str2, 0));
                    break;
                case "left":
                    this.dg = true;
                    this.an = (int) fs.n(context, com.byazt.hb.s.n(str2, 0));
                    break;
                case "order":
                    this.h = com.byazt.hb.s.n(str2, 1);
                    break;
                case "ratio":
                    this.pk = true;
                    this.f = com.byazt.hb.s.n(str2, 0.0f);
                    break;
                case "right":
                    this.u = true;
                    this.ae = (int) fs.n(context, com.byazt.hb.s.n(str2, 0));
                    break;
                case "position":
                    this.lh = oa.n(str2).n();
                    break;
                case "flexShrink":
                    this.ur = com.byazt.hb.s.n(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.t = com.byazt.hb.s.n(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.bb = com.byazt.gr.n.n(str2).n();
                    break;
            }
        }

        @Override // com.byazt.ih.n.C0202n
        /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
        public YogaLayout.n n() {
            q();
            YogaLayout.n nVar = new YogaLayout.n((int) this.n, (int) this.qg);
            nVar.d((int) (this.a ? this.w : this.l));
            nVar.sz((int) (this.py ? this.x : this.l));
            nVar.cp((int) (this.ou ? this.fs : this.l));
            nVar.oa((int) (this.wm ? this.rv : this.l));
            nVar.n(this.h);
            nVar.l(this.bb);
            nVar.qg(this.t);
            nVar.s(this.ur);
            nVar.cy(this.s);
            nVar.hd(this.q);
            if (this.fi) {
                nVar.q(this.ln);
            }
            nVar.w(this.lh);
            if (this.df) {
                nVar.x(this.v);
            }
            if (this.oj) {
                nVar.rv(this.j);
            }
            if (this.dg) {
                nVar.fs(this.an);
            }
            if (this.u) {
                nVar.tj(this.ae);
            }
            if (this.pk && s()) {
                float f = this.f;
                if (f > 0.0f) {
                    nVar.k(f);
                    nVar.s(0.0f);
                    nVar.qg(0.0f);
                }
            }
            return nVar;
        }

        public boolean s() {
            if (this.n == -1.0f && this.qg == -1.0f) {
                return false;
            }
            return this.n == -2.0f || this.qg == -2.0f;
        }

        private void q() {
            if (this.hu instanceof n) {
                if (((n) this.hu).ic() == l.ROW && this.hu.an() == -2 && this.n == -1.0f && !this.hu.wo()) {
                    this.n = -2.0f;
                    this.ur = 1.0f;
                    this.t = 1.0f;
                    this.fi = true;
                    this.ln = -1.0f;
                }
                if (((n) this.hu).ic() == l.COLUMN && this.hu.ae() == -2 && this.qg == -1.0f && !this.hu.wo()) {
                    this.qg = -2.0f;
                    this.ur = 1.0f;
                    this.t = 1.0f;
                    this.fi = true;
                    this.ln = -1.0f;
                }
            }
        }

        @Override // com.byazt.ih.n.C0202n
        public String toString() {
            return "LayoutParams{mOrder=" + this.h + ", mFlexGrow=" + this.t + ", mFlexShrink=" + this.ur + ", mAlignSelf=" + this.bb + ", mFlexBasis=" + this.ln + ", mPosition=" + this.lh + ", mTop=" + this.v + ", mBottom=" + this.j + ", mLeft=" + this.an + ", mRight=" + this.ae + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
