package com.byazt.tkz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.v;
import com.byazt.ndr.TTRoundRectImageView;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.wt.UpieImageView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 21})
public class x extends qg {
    public TextView cd;
    public TextView cy;
    public TextView hd;
    public TTRoundRectImageView k;
    public ImageView sz;
    public UpieImageView um;

    public x(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, z);
    }

    @Override // com.byazt.tkz.qg
    public void n() {
        super.n();
        this.rv = (FrameLayout) this.qg.findViewById(2114387915);
        n((View) this.x);
        if (com.byazt.gks.n.n(this.s)) {
            q();
        } else {
            s();
            qg();
        }
    }

    private void qg() {
        int i = (int) (this.l * 1000.0f);
        if (i == 666 || i == 1500 || i == 1777 || i == 562 || i == 1000) {
            return;
        }
        n(this.q == 1 ? 0.562f : 1.777f);
    }

    private void n(View view) {
        if (this.s == null || view == null) {
            return;
        }
        final float fFx = this.s.fx();
        if (fFx <= 0.0f) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.byazt.tkz.x.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), fFx));
            }
        });
        view.setClipToOutline(true);
    }

    private void s() {
        TextView textView;
        this.sz = (ImageView) this.qg.findViewById(2114387712);
        this.k = (TTRoundRectImageView) this.qg.findViewById(2114387722);
        this.cy = (TextView) this.qg.findViewById(2114387702);
        this.hd = (TextView) this.qg.findViewById(2114387962);
        this.cd = (TextView) this.qg.findViewById(2114387719);
        if (this.sz != null && com.byazt.aci.n.q(this.s)) {
            UpieImageView upieImageView = new UpieImageView(this.sz.getContext(), com.byazt.aci.n.tj(this.s), com.byazt.du.n.n(this.s), com.byazt.aci.n.d(this.s));
            this.um = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (!TextUtils.isEmpty(this.s.jb()) && (textView = this.hd) != null) {
            textView.setText(this.s.jb());
        }
        if (ta.k(this.s) != null && pk.s(this.s)) {
            com.byazt.okk.s.n((View) this.sz, 8);
            com.byazt.okk.s.n((View) this.rv, 0);
        } else {
            n(this.sz, this.um);
            com.byazt.okk.s.n((View) this.sz, 0);
            com.byazt.okk.s.n((View) this.rv, 8);
        }
        v vVarXu = this.s.xu();
        if (vVarXu != null) {
            com.byazt.imu.s.n(vVarXu).n(this.k);
        }
        TextView textView2 = this.cy;
        if (textView2 != null) {
            textView2.setText(sz());
        }
        TextView textView3 = this.cd;
        if (textView3 != null) {
            textView3.setText(k());
        }
        com.byazt.okk.s.n((TextView) this.qg.findViewById(2114387658), this.s);
    }

    @Override // com.byazt.tkz.qg
    public void q(int i) {
        com.byazt.okk.s.n((View) this.cp, i);
    }

    private void q() {
        this.cp = (RelativeLayout) this.qg.findViewById(2114387844);
        this.d = (TextView) this.qg.findViewById(2114387716);
        if (oj.n(this.s)) {
            String strFs = oj.fs(this.s);
            if (TextUtils.isEmpty(strFs)) {
                return;
            }
            com.byazt.imu.s.n(strFs).n(Bitmap.Config.ARGB_4444).s(2).n(new m<Bitmap>() { // from class: com.byazt.tkz.x.2
                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.si.m
                public void n(cy<Bitmap> cyVar) {
                    Bitmap bitmapN = com.byazt.cq.qg.n(x.this.qg, cyVar.s(), 25);
                    if (bitmapN == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(x.this.qg.getResources(), bitmapN);
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.tkz.x.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (x.this.x != null) {
                                x.this.x.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void n(float f) {
        float fMin;
        float fMax;
        int iMax;
        float fL = l();
        float fW = w();
        if (this.q == 2) {
            fMin = Math.max(fL, fW);
            fMax = Math.min(fL, fW);
        } else {
            fMin = Math.min(fL, fW);
            fMax = Math.max(fL, fW);
        }
        int iMin = (int) (Math.min(fMin, fMax) * this.s.zb());
        if (this.q != 2) {
            fMax -= com.byazt.okk.s.q(this.qg, com.byazt.okk.s.cp((Context) this.qg));
        }
        if (this.q != 2) {
            float f2 = iMin;
            iMin = (int) Math.max((fMax - (((fMin - f2) - f2) / f)) / 2.0f, 0.0f);
            iMax = iMin;
        } else {
            float f3 = iMin;
            iMax = (int) Math.max((fMin - (((fMax - f3) - f3) * f)) / 2.0f, 0.0f);
        }
        float f4 = iMin;
        float f5 = iMax;
        try {
            this.qg.getWindow().getDecorView().setPadding(com.byazt.okk.s.s(this.qg, f5), com.byazt.okk.s.s(this.qg, f4), com.byazt.okk.s.s(this.qg, f5), com.byazt.okk.s.s(this.qg, f4));
        } catch (Throwable unused) {
        }
    }

    private float l() {
        return com.byazt.okk.s.q(this.qg, com.byazt.okk.s.rv((Context) this.qg));
    }

    private float w() {
        return com.byazt.okk.s.q(this.qg, com.byazt.okk.s.tj((Context) this.qg));
    }

    @Override // com.byazt.tkz.qg
    public void n(com.byazt.ys.qg qgVar, com.byazt.ys.qg qgVar2) {
        n(this.hd, qgVar, qgVar);
        n(this.d, qgVar, qgVar);
        n(this.rv, qgVar2, qgVar2);
        n(this.sz, qgVar2, qgVar2);
        n(this.k, qgVar2, qgVar2);
        n(this.cy, qgVar2, qgVar2);
        n(this.cd, qgVar2, qgVar2);
        n(this.x, qgVar2, qgVar2);
        n(this.um, qgVar2, qgVar2);
    }

    private void n(View view, com.byazt.ys.qg qgVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(qgVar);
    }
}
