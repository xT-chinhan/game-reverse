package com.byazt.za;

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
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.v;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.stl.GifView;
import com.byazt.wt.UpieImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 1724})
public class SplashExpressBackupView extends BackupView implements com.byazt.iag.s.InterfaceC0200s {
    public NativeVideoTsView a;
    public FrameLayout cd;
    public TextView cy;
    public Button hd;
    public GifView k;
    public NativeExpressView oa;
    public com.byazt.iag.s.InterfaceC0200s py;
    public View sz;
    public com.byazt.qdx.qg um;

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void n(long j, long j2) {
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void s_() {
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void t_() {
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void u_() {
    }

    public SplashExpressBackupView(Context context) {
        super(context);
        this.n = context;
        this.l = "splash_ad";
    }

    @Override // com.byazt.za.BackupView
    public void n(View view, int i, com.byazt.gct.wm wmVar) {
        NativeExpressView nativeExpressView = this.oa;
        if (nativeExpressView != null) {
            nativeExpressView.n(view, i, wmVar, -1);
        }
    }

    public void n(com.byazt.qdx.qg qgVar, pk pkVar, NativeExpressView nativeExpressView) {
        this.qg = pkVar;
        this.oa = nativeExpressView;
        this.w = com.byazt.okk.s.s(this.n, this.oa.getExpectExpressWidth());
        this.x = com.byazt.okk.s.s(this.n, this.oa.getExpectExpressWidth());
        this.um = qgVar;
        w();
        this.oa.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.w, this.x);
        }
        layoutParams.width = this.w;
        layoutParams.height = this.x;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        n(this.qg.ge(), this.qg);
    }

    private void n(int i, pk pkVar) {
        if (!x()) {
            if (i == 5) {
                cp();
                return;
            } else {
                d();
                return;
            }
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        oa();
                        return;
                    }
                }
            }
            if (fs()) {
                oa();
                return;
            } else {
                tj();
                return;
            }
        }
        rv();
    }

    private boolean x() {
        NativeExpressView nativeExpressView = this.oa;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            return false;
        }
        boolean z = nativeExpressView instanceof NativeExpressView;
        return true;
    }

    private boolean fs() {
        return this.qg != null && this.qg.ys() == 2;
    }

    private void rv() {
        sz();
        this.k.setVisibility(0);
        this.cd.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
        layoutParams.height = com.byazt.okk.s.s(this.n, 291.0f);
        this.k.setLayoutParams(layoutParams);
        n(this.k, this.qg, this.um);
        this.cy.setText(this.qg.m19if());
        if (this.qg.br() != null) {
            com.byazt.okk.s.n((View) this.hd, 8);
        } else {
            com.byazt.okk.s.n((View) this.hd, 0);
            this.hd.setText(this.qg.jb());
            n((View) this.hd, true);
        }
        setExpressBackupListener(this.sz);
    }

    private void tj() {
        sz();
        this.k.setVisibility(0);
        this.cd.setVisibility(8);
        n(this.k, this.qg, this.um);
        this.cy.setText(this.qg.m19if());
        if (this.qg.br() != null) {
            com.byazt.okk.s.n((View) this.hd, 8);
        } else {
            com.byazt.okk.s.n((View) this.hd, 0);
            this.hd.setText(this.qg.jb());
            n((View) this.hd, true);
        }
        setExpressBackupListener(this.sz);
    }

    private void cp() {
        sz();
        this.k.setVisibility(8);
        this.cd.setVisibility(0);
        if (ta.k(this.qg) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) n(this.oa);
            this.a = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.a == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.cd.addView(this.a, layoutParams);
        }
        this.cy.setText(this.qg.m19if());
        if (this.qg.br() != null) {
            com.byazt.okk.s.n((View) this.hd, 8);
        } else {
            com.byazt.okk.s.n((View) this.hd, 0);
            this.hd.setText(this.qg.jb());
            n((View) this.hd, true);
        }
        setExpressBackupListener(this.sz);
    }

    private void d() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) n(this.oa);
        this.a = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.a;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    public void setVideoAdListener(com.byazt.iag.s.InterfaceC0200s interfaceC0200s) {
        this.py = interfaceC0200s;
    }

    private void oa() {
        GifView gifView = new GifView(this.n);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        n(gifView, this.qg, this.um);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private void setExpressBackupListener(View view) {
        if (this.qg == null || this.qg.of() != 1) {
            return;
        }
        n(view, true);
    }

    private View n(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackground(com.byazt.cb.n.qg());
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.byazt.okk.s.s(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText("今日推荐");
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.cy = textView2;
        textView2.setId(2114387471);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = com.byazt.okk.s.s(context, 31.0f);
        layoutParams3.gravity = 1;
        this.cy.setLayoutParams(layoutParams3);
        this.cy.setGravity(1);
        this.cy.setTextSize(2, 15.0f);
        this.cy.setTextColor(Color.parseColor("#895434"));
        this.cy.setSingleLine(false);
        linearLayout.addView(this.cy);
        GifView gifView = new GifView(context);
        this.k = gifView;
        gifView.setId(2114387470);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = com.byazt.okk.s.s(context, 29.0f);
        layoutParams4.setMarginStart(com.byazt.okk.s.s(context, 15.0f));
        layoutParams4.setMarginEnd(com.byazt.okk.s.s(context, 15.0f));
        layoutParams4.gravity = 1;
        this.k.setLayoutParams(layoutParams4);
        this.k.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.k);
        FrameLayout frameLayout = new FrameLayout(context);
        this.cd = frameLayout;
        frameLayout.setId(2114387469);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(com.byazt.okk.s.s(context, 15.0f));
        layoutParams5.setMarginEnd(com.byazt.okk.s.s(context, 15.0f));
        this.cd.setLayoutParams(layoutParams5);
        this.cd.setVisibility(8);
        linearLayout.addView(this.cd);
        Button button = new Button(context);
        this.hd = button;
        button.setId(2114387468);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = com.byazt.okk.s.s(context, 37.0f);
        layoutParams6.gravity = 1;
        this.hd.setLayoutParams(layoutParams6);
        this.hd.setText("立即下载");
        this.hd.setTextColor(Color.parseColor("#ffffff"));
        this.hd.setTypeface(Typeface.defaultFromStyle(1));
        this.hd.setBackground(com.byazt.cb.n.qg(context));
        linearLayout.addView(this.hd);
        return linearLayout;
    }

    private void sz() {
        View viewN = n(this.n);
        if (viewN == null) {
            return;
        }
        addView(viewN);
    }

    private void n(GifView gifView) {
        v vVar = this.qg.jo().get(0);
        if (vVar != null) {
            com.byazt.imu.s.n(vVar).n(gifView);
        }
        if (com.byazt.aci.n.q(this.qg)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.byazt.aci.n.tj(this.qg), com.byazt.du.n.n(this.qg), com.byazt.aci.n.d(this.qg));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.byazt.aci.n.n(gifView, upieImageView);
        }
    }

    public void n(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.n(bArr, false);
    }

    public void n(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    public void n(GifView gifView, pk pkVar, com.byazt.qdx.qg qgVar) {
        Drawable drawableN;
        if (qgVar == null) {
            n(gifView);
            return;
        }
        if (qgVar.l()) {
            n(qgVar.s(), gifView);
            return;
        }
        if (pkVar.jo() == null || pkVar.jo().get(0) == null) {
            return;
        }
        if (qgVar.n() != null) {
            drawableN = new BitmapDrawable(qgVar.n());
        } else {
            drawableN = com.byazt.imu.n.n(qgVar.s(), pkVar.jo().get(0).qg());
        }
        n(drawableN, gifView);
        if (com.byazt.aci.n.q(this.qg)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.byazt.aci.n.tj(this.qg), com.byazt.du.n.n(this.qg), com.byazt.aci.n.d(this.qg));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.byazt.aci.n.n(gifView, upieImageView);
        }
    }

    @Override // com.byazt.za.BackupView
    public void n(View view, boolean z) {
        if (this.qg == null || this.qg.br() == null || this.qg.br().n() != 1) {
            return;
        }
        super.n(view, z);
    }

    public com.byazt.iag.s getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.a;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    @Override // com.byazt.iag.s.InterfaceC0200s
    public void v_() {
        com.byazt.iag.s.InterfaceC0200s interfaceC0200s = this.py;
        if (interfaceC0200s != null) {
            interfaceC0200s.v_();
        }
    }
}
