package com.byazt.jhh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.byazt.aa.zo;
import com.byazt.ch.fw;
import com.byazt.fty.c;
import com.byazt.fty.g;
import com.byazt.fty.m;
import com.byazt.fty.uc;
import com.byazt.fty.vk;
import com.byazt.fty.x;
import com.byazt.hl.RoundImageView;
import com.byazt.ik.hn;
import com.byazt.llk.hw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 37})
public class pr extends com.byazt.ik.pr<YogaLayout> {
    public g fe;
    public uc ks;
    public c qx;
    public com.byazt.fty.pr sr;
    public com.byazt.fty.pr wz;
    public vk xb;

    public pr(Context context) {
        super(context);
        this.qx = c.ROW;
        this.fe = g.NO_WRAP;
        this.ks = uc.FLEX_START;
        this.sr = com.byazt.fty.pr.STRETCH;
        this.wz = com.byazt.fty.pr.STRETCH;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: lv, reason: merged with bridge method [inline-methods] */
    public YogaLayout pr() {
        YogaLayout yogaLayout = new YogaLayout(this.hw);
        yogaLayout.pr(this);
        this.xb = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    @Override // com.byazt.ik.hn
    public void b() {
        if (this.qn) {
            if (this.eh != null) {
                this.eh.pr();
            }
            com.byazt.llk.uc.pr().hw().pr(this.aj, this.er, new hw.pr() { // from class: com.byazt.jhh.pr.1
                @Override // com.byazt.llk.hw.pr
                public void pr(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (pr.this.eh != null) {
                            fw fwVar = pr.this.eh;
                            pr prVar = pr.this;
                            fwVar.hw(prVar, prVar.er);
                            return;
                        }
                        return;
                    }
                    if (pr.this.eh != null) {
                        fw fwVar2 = pr.this.eh;
                        pr prVar2 = pr.this;
                        fwVar2.pr(prVar2, prVar2.er);
                    }
                    final Bitmap bitmapPr = zo.pr(pr.this.hw, bitmap, (int) pr.this.qi);
                    if (bitmapPr != null) {
                        zo.pr(new Runnable() { // from class: com.byazt.jhh.pr.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                pr.this.pr(new BitmapDrawable(bitmapPr));
                            }
                        });
                    }
                }
            });
            return;
        }
        if (this.eh != null) {
            this.eh.pr();
        }
        RoundImageView roundImageView = new RoundImageView(this.hw);
        com.byazt.llk.uc.pr().hw().pr(this.aj, this.er, roundImageView, this.c.getWidth(), this.c.getHeight(), new hw.pr() { // from class: com.byazt.jhh.pr.2
            @Override // com.byazt.llk.hw.pr
            public void pr(Bitmap bitmap) {
                if (bitmap == null) {
                    if (pr.this.eh != null) {
                        fw fwVar = pr.this.eh;
                        pr prVar = pr.this;
                        fwVar.hw(prVar, prVar.er);
                        return;
                    }
                    return;
                }
                if (pr.this.eh != null) {
                    fw fwVar2 = pr.this.eh;
                    pr prVar2 = pr.this;
                    fwVar2.pr(prVar2, prVar2.er);
                }
            }
        });
        if (!this.of || this.v == ImageView.ScaleType.FIT_XY) {
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            roundImageView.setScaleType(this.v);
        }
        roundImageView.setCornerRadius(this.ii);
        YogaLayout.pr prVar = new YogaLayout.pr(-1, -1);
        prVar.uc(m.ABSOLUTE.pr());
        prVar.fw(0.0f);
        prVar.zo(0.0f);
        if (this.c instanceof YogaLayout) {
            ((YogaLayout) this.c).addView(roundImageView, 0, prVar);
            pr(roundImageView);
        }
    }

    @Override // com.byazt.ik.hn
    public void pr(Drawable drawable) {
        RoundImageView roundImageView = new RoundImageView(this.hw);
        roundImageView.setImageDrawable(drawable);
        if (!this.of || this.v == ImageView.ScaleType.FIT_XY) {
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            roundImageView.setScaleType(this.v);
        }
        roundImageView.setCornerRadius(this.ii);
        YogaLayout.pr prVar = new YogaLayout.pr(-1, -1);
        prVar.uc(m.ABSOLUTE.pr());
        prVar.fw(0.0f);
        prVar.zo(0.0f);
        if (this.c instanceof YogaLayout) {
            ((YogaLayout) this.c).addView(roundImageView, 0, prVar);
            pr(roundImageView);
        }
    }

    private void pr(final RoundImageView roundImageView) {
        this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.jhh.pr.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                vk vkVarPr;
                if (pr.this.c != null && (vkVarPr = ((YogaLayout) pr.this.c).pr(roundImageView)) != null) {
                    int width = pr.this.c.getWidth();
                    vkVarPr.x(width);
                    int height = pr.this.c.getHeight();
                    vkVarPr.uc(height);
                    roundImageView.setCornerRadius(pr.this.ii);
                    pr.this.c.requestLayout();
                    if (width > 0 || height > 0) {
                        pr.this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            }
        });
    }

    @Override // com.byazt.ik.pr, com.byazt.ik.hn
    public void hw() {
        super.hw();
        this.xb.pr(this.qx);
        this.xb.pr(this.fe);
        this.xb.pr(this.ks);
        this.xb.pr(this.sr);
        this.xb.hn(this.wz);
        this.xb.pr(true);
    }

    @Override // com.byazt.ik.hn
    public void k() {
        if (this.y) {
            this.xb.hw(x.ALL, this.b);
        }
        if (this.ww) {
            this.xb.hw(x.LEFT, this.iu);
        }
        if (this.n) {
            this.xb.hw(x.RIGHT, this.ve);
        }
        if (this.e) {
            this.xb.hw(x.TOP, this.gz);
        }
        if (this.s) {
            this.xb.hw(x.BOTTOM, this.nl);
        }
    }

    @Override // com.byazt.ik.pr
    public void pr(hn hnVar) {
        super.pr(hnVar);
    }

    @Override // com.byazt.ik.pr
    public void pr(hn hnVar, ViewGroup.LayoutParams layoutParams) {
        if (hnVar == null) {
            return;
        }
        this.pr.add(hnVar);
        View viewAj = hnVar.aj();
        if (viewAj != null) {
            ((YogaLayout) this.c).addView(viewAj, layoutParams);
        }
    }

    @Override // com.byazt.ik.pr
    /* JADX INFO: renamed from: od, reason: merged with bridge method [inline-methods] */
    public C0102pr zo() {
        return new C0102pr(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "flexDirection":
                this.qx = c.pr(str2);
                break;
            case "flexWrap":
                this.fe = g.pr(str2);
                break;
            case "justifyContent":
                this.ks = uc.pr(str2);
                break;
            case "alignItems":
                this.sr = com.byazt.fty.pr.pr(str2);
                break;
            case "alignContent":
                this.wz = com.byazt.fty.pr.pr(str2);
                break;
        }
    }

    public c vj() {
        return this.qx;
    }

    /* JADX INFO: renamed from: com.byazt.jhh.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0102pr extends com.byazt.ik.pr.C0097pr {
        public int b;
        public int e;
        public boolean er;
        public int gz;
        public boolean ii;
        public float iu;
        public float ls;
        public int n;
        public float nl;
        public boolean of;
        public boolean qi;
        public boolean qn;
        public int s;
        public boolean v;
        public float ve;
        public int ww;
        public int y;

        public C0102pr(com.byazt.ik.pr prVar) {
            super(prVar);
            this.b = 1;
            this.iu = 0.0f;
            this.ve = 1.0f;
            this.gz = com.byazt.fty.pr.AUTO.pr();
            this.nl = -1.0f;
            this.y = m.RELATIVE.pr();
        }

        @Override // com.byazt.ik.pr.C0097pr
        public void pr(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.pr(context, str, str2);
            switch (str) {
                case "order":
                    this.b = com.byazt.aa.hn.pr(str2, 1);
                    break;
                case "flexGrow":
                    this.iu = com.byazt.aa.hn.pr(str2, 0.0f);
                    break;
                case "flexShrink":
                    this.ve = com.byazt.aa.hn.pr(str2, 1.0f);
                    break;
                case "flexBasis":
                    this.er = true;
                    float fPr = com.byazt.aa.hn.pr(str2, -1.0f);
                    this.nl = fPr;
                    this.nl = zo.pr(context, fPr);
                    break;
                case "alignSelf":
                    this.gz = com.byazt.fty.pr.pr(str2).pr();
                    break;
                case "position":
                    this.y = m.pr(str2).pr();
                    break;
                case "top":
                    this.v = true;
                    this.ww = (int) zo.pr(context, com.byazt.aa.hn.pr(str2, 0));
                    break;
                case "bottom":
                    this.qi = true;
                    this.n = (int) zo.pr(context, com.byazt.aa.hn.pr(str2, 0));
                    break;
                case "left":
                    this.qn = true;
                    this.e = (int) zo.pr(context, com.byazt.aa.hn.pr(str2, 0));
                    break;
                case "right":
                    this.of = true;
                    this.s = (int) zo.pr(context, com.byazt.aa.hn.pr(str2, 0));
                    break;
                case "ratio":
                    this.ii = true;
                    this.ls = com.byazt.aa.hn.pr(str2, 0.0f);
                    break;
            }
        }

        @Override // com.byazt.ik.pr.C0097pr
        /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
        public YogaLayout.pr pr() {
            x();
            YogaLayout.pr prVar = new YogaLayout.pr((int) this.pr, (int) this.hw);
            prVar.k((int) (this.a ? this.uc : this.c));
            prVar.g((int) (this.cz ? this.fw : this.c));
            prVar.w((int) (this.ny ? this.zo : this.c));
            prVar.m((int) (this.fo ? this.aj : this.c));
            prVar.pr(this.b);
            prVar.c(this.gz);
            prVar.hw(this.iu);
            prVar.hn(this.ve);
            prVar.nt(this.hn);
            prVar.yb(this.x);
            if (this.er) {
                prVar.x(this.nl);
            }
            prVar.uc(this.y);
            if (this.v) {
                prVar.fw(this.ww);
            }
            if (this.qi) {
                prVar.aj(this.n);
            }
            if (this.qn) {
                prVar.zo(this.e);
            }
            if (this.of) {
                prVar.vk(this.s);
            }
            if (this.ii && hn()) {
                float f = this.ls;
                if (f > 0.0f) {
                    prVar.ho(f);
                    prVar.hn(0.0f);
                    prVar.hw(0.0f);
                }
            }
            return prVar;
        }

        public boolean hn() {
            if (this.pr == -1.0f && this.hw == -1.0f) {
                return false;
            }
            return this.pr == -2.0f || this.hw == -2.0f;
        }

        private void x() {
            if (this.z instanceof pr) {
                if (((pr) this.z).vj() == c.ROW && this.z.e() == -2 && this.pr == -1.0f && !this.z.i()) {
                    this.pr = -2.0f;
                    this.ve = 1.0f;
                    this.iu = 1.0f;
                    this.er = true;
                    this.nl = -1.0f;
                }
                if (((pr) this.z).vj() == c.COLUMN && this.z.s() == -2 && this.hw == -1.0f && !this.z.i()) {
                    this.hw = -2.0f;
                    this.ve = 1.0f;
                    this.iu = 1.0f;
                    this.er = true;
                    this.nl = -1.0f;
                }
            }
        }

        @Override // com.byazt.ik.pr.C0097pr
        public String toString() {
            return "LayoutParams{mOrder=" + this.b + ", mFlexGrow=" + this.iu + ", mFlexShrink=" + this.ve + ", mAlignSelf=" + this.gz + ", mFlexBasis=" + this.nl + ", mPosition=" + this.y + ", mTop=" + this.ww + ", mBottom=" + this.n + ", mLeft=" + this.e + ", mRight=" + this.s + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
