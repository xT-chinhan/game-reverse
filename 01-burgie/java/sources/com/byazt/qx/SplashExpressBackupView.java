package com.byazt.qx;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.y;
import com.byazt.jt.GifView;
import com.byazt.oc.UpieImageView;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 1989})
public class SplashExpressBackupView extends BackupView implements com.byazt.w.hn.InterfaceC0220hn {
    public NativeVideoTsView a;
    public com.byazt.w.hn.InterfaceC0220hn cz;
    public View g;
    public GifView ho;
    public FrameLayout lb;
    public NativeExpressView m;
    public TextView nt;
    public com.byazt.bd.hw qa;
    public Button yb;

    public SplashExpressBackupView(Context context) {
        super(context);
        this.pr = context;
        this.c = "splash_ad";
    }

    @Override // com.byazt.qx.BackupView
    public void pr(View view, int i, com.byazt.hg.fo foVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.pr(view, i, foVar, -1);
        }
    }

    public void pr(com.byazt.bd.hw hwVar, of ofVar, NativeExpressView nativeExpressView) {
        this.hw = ofVar;
        this.m = nativeExpressView;
        this.uc = er.hn(this.pr, this.m.getExpectExpressWidth());
        this.fw = er.hn(this.pr, this.m.getExpectExpressWidth());
        this.qa = hwVar;
        uc();
        this.m.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void uc() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.uc, this.fw);
        }
        layoutParams.width = this.uc;
        layoutParams.height = this.fw;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        pr(this.hw.jg(), this.hw);
    }

    private void pr(int i, of ofVar) {
        if (fw()) {
            switch (i) {
                case 2:
                case 4:
                    aj();
                    break;
                case 3:
                case 5:
                    if (zo()) {
                        m();
                    } else {
                        vk();
                    }
                    break;
                default:
                    m();
                    break;
            }
        }
        switch (i) {
            case 5:
                w();
                break;
            default:
                k();
                break;
        }
    }

    private boolean fw() {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            return false;
        }
        boolean z = nativeExpressView instanceof NativeExpressView;
        return true;
    }

    private boolean zo() {
        return this.hw != null && this.hw.rf() == 2;
    }

    private void aj() {
        g();
        this.ho.setVisibility(0);
        this.lb.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.ho.getLayoutParams();
        layoutParams.height = er.hn(this.pr, 291.0f);
        this.ho.setLayoutParams(layoutParams);
        pr(this.ho, this.hw, this.qa);
        this.nt.setText(this.hw.jv());
        if (this.hw.jl() != null) {
            er.pr((View) this.yb, 8);
        } else {
            er.pr((View) this.yb, 0);
            this.yb.setText(this.hw.se());
            pr((View) this.yb, true);
        }
        setExpressBackupListener(this.g);
    }

    private void vk() {
        g();
        this.ho.setVisibility(0);
        this.lb.setVisibility(8);
        pr(this.ho, this.hw, this.qa);
        this.nt.setText(this.hw.jv());
        if (this.hw.jl() != null) {
            er.pr((View) this.yb, 8);
        } else {
            er.pr((View) this.yb, 0);
            this.yb.setText(this.hw.se());
            pr((View) this.yb, true);
        }
        setExpressBackupListener(this.g);
    }

    private void w() {
        g();
        this.ho.setVisibility(8);
        this.lb.setVisibility(0);
        if (qv.ho(this.hw) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) pr(this.m);
            this.a = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.a == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.lb.addView(this.a, layoutParams);
        }
        this.nt.setText(this.hw.jv());
        if (this.hw.jl() != null) {
            er.pr((View) this.yb, 8);
        } else {
            er.pr((View) this.yb, 0);
            this.yb.setText(this.hw.se());
            pr((View) this.yb, true);
        }
        setExpressBackupListener(this.g);
    }

    private void k() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) pr(this.m);
        this.a = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.a;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    public void setVideoAdListener(com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn) {
        this.cz = interfaceC0220hn;
    }

    private void m() {
        GifView gifView = new GifView(this.pr);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        pr(gifView, this.hw, this.qa);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private void setExpressBackupListener(View view) {
        if (this.hw != null && this.hw.lj() == 1) {
            pr(view, true);
        }
    }

    private View pr(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackground(com.byazt.sdv.x.hw());
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = er.hn(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText("今日推荐");
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.nt = textView2;
        textView2.setId(2114387471);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = er.hn(context, 31.0f);
        layoutParams3.gravity = 1;
        this.nt.setLayoutParams(layoutParams3);
        this.nt.setGravity(1);
        this.nt.setTextSize(2, 15.0f);
        this.nt.setTextColor(Color.parseColor("#895434"));
        this.nt.setSingleLine(false);
        linearLayout.addView(this.nt);
        GifView gifView = new GifView(context);
        this.ho = gifView;
        gifView.setId(2114387470);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = er.hn(context, 29.0f);
        layoutParams4.setMarginStart(er.hn(context, 15.0f));
        layoutParams4.setMarginEnd(er.hn(context, 15.0f));
        layoutParams4.gravity = 1;
        this.ho.setLayoutParams(layoutParams4);
        this.ho.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.ho);
        FrameLayout frameLayout = new FrameLayout(context);
        this.lb = frameLayout;
        frameLayout.setId(2114387469);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(er.hn(context, 15.0f));
        layoutParams5.setMarginEnd(er.hn(context, 15.0f));
        this.lb.setLayoutParams(layoutParams5);
        this.lb.setVisibility(8);
        linearLayout.addView(this.lb);
        Button button = new Button(context);
        this.yb = button;
        button.setId(2114387468);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = er.hn(context, 37.0f);
        layoutParams6.gravity = 1;
        this.yb.setLayoutParams(layoutParams6);
        this.yb.setText("立即下载");
        this.yb.setTextColor(Color.parseColor("#ffffff"));
        this.yb.setTypeface(Typeface.defaultFromStyle(1));
        this.yb.setBackground(com.byazt.sdv.x.hw(context));
        linearLayout.addView(this.yb);
        return linearLayout;
    }

    private void g() {
        View viewPr = pr(this.pr);
        if (viewPr == null) {
            return;
        }
        addView(viewPr);
    }

    private void pr(GifView gifView) {
        y yVar = this.hw.de().get(0);
        if (yVar != null) {
            com.byazt.ub.hw.pr(yVar).pr(gifView);
        }
        if (com.byazt.ja.pr.x(this.hw)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.byazt.ja.pr.vk(this.hw), com.byazt.vr.pr.pr(this.hw), com.byazt.ja.pr.w(this.hw));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.byazt.ja.pr.pr(gifView, upieImageView);
        }
    }

    public void pr(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.pr(bArr, false);
    }

    public void pr(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    public void pr(GifView gifView, of ofVar, com.byazt.bd.hw hwVar) {
        Drawable drawablePr;
        if (hwVar == null) {
            pr(gifView);
            return;
        }
        if (hwVar.c()) {
            pr(hwVar.hn(), gifView);
            return;
        }
        if (ofVar.de() != null && ofVar.de().get(0) != null) {
            if (hwVar.pr() != null) {
                drawablePr = new BitmapDrawable(hwVar.pr());
            } else {
                drawablePr = com.byazt.wt.yb.pr(hwVar.hn(), ofVar.de().get(0).hw());
            }
            pr(drawablePr, gifView);
            if (com.byazt.ja.pr.x(this.hw)) {
                UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.byazt.ja.pr.vk(this.hw), com.byazt.vr.pr.pr(this.hw), com.byazt.ja.pr.w(this.hw));
                upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                com.byazt.ja.pr.pr(gifView, upieImageView);
            }
        }
    }

    @Override // com.byazt.qx.BackupView
    public void pr(View view, boolean z) {
        if (this.hw != null && this.hw.jl() != null && this.hw.jl().pr() == 1) {
            super.pr(view, z);
        }
    }

    public com.byazt.w.hn getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.a;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void m_() {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void n_() {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void o_() {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void pr(long j, long j2) {
    }

    @Override // com.byazt.w.hn.InterfaceC0220hn
    public void p_() {
        com.byazt.w.hn.InterfaceC0220hn interfaceC0220hn = this.cz;
        if (interfaceC0220hn != null) {
            interfaceC0220hn.p_();
        }
    }
}
