package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.d;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.adsdk.ugeno.yoga.c;
import com.bytedance.adsdk.ugeno.yoga.ch;
import com.bytedance.adsdk.ugeno.yoga.ka;
import com.bytedance.adsdk.ugeno.yoga.u;
import com.bytedance.adsdk.ugeno.yoga.zb;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.adsdk.ugeno.xr.ms<YogaLayout> {
    private c gs;
    private u kl;
    private com.bytedance.adsdk.ugeno.yoga.ms nl;
    private ch qo;
    private com.bytedance.adsdk.ugeno.yoga.ms r;
    private ka vf;

    public ms(Context context) {
        super(context);
        this.vf = ka.ROW;
        this.kl = u.NO_WRAP;
        this.gs = c.FLEX_START;
        this.r = com.bytedance.adsdk.ugeno.yoga.ms.STRETCH;
        this.nl = com.bytedance.adsdk.ugeno.yoga.ms.STRETCH;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: am, reason: merged with bridge method [inline-methods] */
    public YogaLayout ms() {
        YogaLayout yogaLayout = new YogaLayout(this.xr);
        yogaLayout.ms(this);
        this.qo = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    protected void w() {
        if (this.e) {
            d.ms().xr().ms(this.ny, this.az, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.ms.1
                @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
                public void ms(Bitmap bitmap) {
                    final Bitmap bitmapMs;
                    if (bitmap == null || (bitmapMs = x.ms(ms.this.xr, bitmap, (int) ms.this.lm)) == null) {
                        return;
                    }
                    x.ms(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.ms.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ms.this.ms(new BitmapDrawable(bitmapMs));
                        }
                    });
                }
            });
            return;
        }
        ImageView imageView = new ImageView(this.xr);
        d.ms().xr().ms(this.ny, this.az, imageView, this.ka.getWidth(), this.ka.getHeight());
        if (!this.k || this.m == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(this.m);
        }
        YogaLayout.ms msVar = new YogaLayout.ms(-1, -1);
        msVar.c(zb.ABSOLUTE.ms());
        if (this.ka instanceof YogaLayout) {
            ((YogaLayout) this.ka).addView(imageView, 0, msVar);
            ms(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    protected void ms(Drawable drawable) {
        ImageView imageView = new ImageView(this.xr);
        imageView.setImageDrawable(drawable);
        if (!this.k || this.m == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(this.m);
        }
        YogaLayout.ms msVar = new YogaLayout.ms(-1, -1);
        msVar.c(zb.ABSOLUTE.ms());
        if (this.ka instanceof YogaLayout) {
            ((YogaLayout) this.ka).addView(imageView, 0, msVar);
            ms(imageView);
        }
    }

    private void ms(final ImageView imageView) {
        this.ka.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.ms.2
            @Override // java.lang.Runnable
            public void run() {
                ch chVarMs;
                if (ms.this.ka == null || (chVarMs = ((YogaLayout) ms.this.ka).ms(imageView)) == null) {
                    return;
                }
                chVarMs.d(ms.this.ka.getWidth());
                chVarMs.c(ms.this.ka.getHeight());
                ms.this.ka.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        this.qo.ms(this.vf);
        this.qo.ms(this.kl);
        this.qo.ms(this.gs);
        this.qo.ms(this.r);
        this.qo.ah(this.nl);
        this.qo.ms(true);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    protected void sl() {
        if (this.of) {
            this.qo.xr(com.bytedance.adsdk.ugeno.yoga.d.ALL, this.yu);
        }
        if (this.p) {
            this.qo.xr(com.bytedance.adsdk.ugeno.yoga.d.LEFT, this.op);
        }
        if (this.pc) {
            this.qo.xr(com.bytedance.adsdk.ugeno.yoga.d.RIGHT, this.le);
        }
        if (this.jw) {
            this.qo.xr(com.bytedance.adsdk.ugeno.yoga.d.TOP, this.cv);
        }
        if (this.f) {
            this.qo.xr(com.bytedance.adsdk.ugeno.yoga.d.BOTTOM, this.g);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public void ms(ah ahVar) {
        super.ms(ahVar);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public void ms(ah ahVar, ViewGroup.LayoutParams layoutParams) {
        if (ahVar == null) {
            return;
        }
        this.f438ms.add(ahVar);
        View viewNy = ahVar.ny();
        if (viewNy != null) {
            ((YogaLayout) this.ka).addView(viewNy, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    /* JADX INFO: renamed from: sa, reason: merged with bridge method [inline-methods] */
    public C0203ms x() {
        return new C0203ms(this);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.r = com.bytedance.adsdk.ugeno.yoga.ms.ms(str2);
                break;
            case "flexDirection":
                this.vf = ka.ms(str2);
                break;
            case "alignContent":
                this.nl = com.bytedance.adsdk.ugeno.yoga.ms.ms(str2);
                break;
            case "flexWrap":
                this.kl = u.ms(str2);
                break;
            case "justifyContent":
                this.gs = c.ms(str2);
                break;
        }
    }

    public ka tz() {
        return this.vf;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.yoga.widget.ms$ms, reason: collision with other inner class name */
    public static class C0203ms extends com.bytedance.adsdk.ugeno.xr.ms.C0201ms {
        private boolean az;
        public int cv;
        private boolean e;
        private boolean eg;
        public int f;
        public float g;
        public int jw;
        private boolean k;
        public float le;
        private boolean lm;
        private boolean m;
        public int of;
        public float op;
        public int p;
        public int pc;
        public float ul;
        public int yu;

        public C0203ms(com.bytedance.adsdk.ugeno.xr.ms msVar) {
            super(msVar);
            this.yu = 1;
            this.op = 0.0f;
            this.le = 1.0f;
            this.cv = com.bytedance.adsdk.ugeno.yoga.ms.AUTO.ms();
            this.g = -1.0f;
            this.of = zb.RELATIVE.ms();
        }

        @Override // com.bytedance.adsdk.ugeno.xr.ms.C0201ms
        public void ms(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.ms(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.az = true;
                    float fMs = com.bytedance.adsdk.ugeno.c.ah.ms(str2, -1.0f);
                    this.g = fMs;
                    this.g = x.ms(context, fMs);
                    break;
                case "bottom":
                    this.lm = true;
                    this.pc = (int) x.ms(context, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0));
                    break;
                case "top":
                    this.m = true;
                    this.p = (int) x.ms(context, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0));
                    break;
                case "left":
                    this.e = true;
                    this.jw = (int) x.ms(context, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0));
                    break;
                case "order":
                    this.yu = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 1);
                    break;
                case "ratio":
                    this.eg = true;
                    this.ul = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                    break;
                case "right":
                    this.k = true;
                    this.f = (int) x.ms(context, com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0));
                    break;
                case "position":
                    this.of = zb.ms(str2).ms();
                    break;
                case "flexShrink":
                    this.le = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.op = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.cv = com.bytedance.adsdk.ugeno.yoga.ms.ms(str2).ms();
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xr.ms.C0201ms
        /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
        public YogaLayout.ms ms() {
            d();
            YogaLayout.ms msVar = new YogaLayout.ms((int) this.f439ms, (int) this.xr);
            msVar.sl((int) (this.t ? this.c : this.ka));
            msVar.u((int) (this.nw ? this.ab : this.ka));
            msVar.hi((int) (this.b ? this.x : this.ka));
            msVar.zb((int) (this.re ? this.ny : this.ka));
            msVar.ms(this.yu);
            msVar.ka(this.cv);
            msVar.xr(this.op);
            msVar.ah(this.le);
            msVar.ao(this.ah);
            msVar.h(this.d);
            if (this.az) {
                msVar.d(this.g);
            }
            msVar.c(this.of);
            if (this.m) {
                msVar.ab(this.p);
            }
            if (this.lm) {
                msVar.ny(this.pc);
            }
            if (this.e) {
                msVar.x(this.jw);
            }
            if (this.k) {
                msVar.ch(this.f);
            }
            if (this.eg && ah()) {
                float f = this.ul;
                if (f > 0.0f) {
                    msVar.ub(f);
                    msVar.ah(0.0f);
                    msVar.xr(0.0f);
                }
            }
            return msVar;
        }

        public boolean ah() {
            if (this.f439ms == -1.0f && this.xr == -1.0f) {
                return false;
            }
            return this.f439ms == -2.0f || this.xr == -2.0f;
        }

        private void d() {
            if (this.w instanceof ms) {
                if (((ms) this.w).tz() == ka.ROW && this.w.pc() == -2 && this.f439ms == -1.0f) {
                    this.f439ms = -2.0f;
                    this.le = 1.0f;
                    this.op = 1.0f;
                    this.az = true;
                    this.g = -1.0f;
                }
                if (((ms) this.w).tz() == ka.COLUMN && this.w.jw() == -2 && this.xr == -1.0f) {
                    this.xr = -2.0f;
                    this.le = 1.0f;
                    this.op = 1.0f;
                    this.az = true;
                    this.g = -1.0f;
                }
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xr.ms.C0201ms
        public String toString() {
            return "LayoutParams{mOrder=" + this.yu + ", mFlexGrow=" + this.op + ", mFlexShrink=" + this.le + ", mAlignSelf=" + this.cv + ", mFlexBasis=" + this.g + ", mPosition=" + this.of + ", mTop=" + this.p + ", mBottom=" + this.pc + ", mLeft=" + this.jw + ", mRight=" + this.f + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
