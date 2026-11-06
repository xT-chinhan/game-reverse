package com.byazt.hi;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.gct.an;
import com.byazt.gct.fl;
import com.byazt.gct.he;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.pi.TTCountdownViewForBtn;
import com.byazt.pi.TTCountdownViewForCircle;
import com.byazt.tk.cd;
import com.byazt.tk.sz;
import com.byazt.za.NativeExpressView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 867})
public class TsView extends FrameLayout {
    public final com.byazt.mkl.qg cd;
    public FrameLayout cp;
    public FrameLayout cy;
    public pk d;
    public NativeExpressView fs;
    public int hd;
    public boolean k;
    public FrameLayout l;
    public final com.byazt.mkl.n n;
    public boolean oa;
    public ImageView q;
    public final Context qg;
    public String rv;
    public com.byazt.pi.q s;
    public n sz;
    public TextView tj;
    public TextView w;
    public SplashClickBar x;

    public interface n {
        void n(boolean z);

        void rv();

        void tj();
    }

    public TsView(Context context, String str, pk pkVar) {
        super(context);
        this.oa = false;
        this.k = false;
        com.byazt.mkl.qg qgVar = new com.byazt.mkl.qg();
        this.cd = qgVar;
        this.n = new com.byazt.mkl.n() { // from class: com.byazt.hi.TsView.1
            @Override // com.byazt.mkl.n
            public void n(boolean z, JSONObject jSONObject) {
                if (z) {
                    boolean zQ = an.q();
                    if (nf.qg(TsView.this.d) && zQ) {
                        TsView.this.cd.qg(2);
                        com.byazt.za.rv.qg(TsView.this.fs);
                    }
                }
            }
        };
        this.qg = context;
        this.rv = str;
        this.d = pkVar;
        qgVar.n(pkVar);
        s();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        n nVar = this.sz;
        if (nVar != null) {
            nVar.n(z);
        }
    }

    private View n(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387582);
        this.l = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.l.setId(2114387581);
        this.l.setLayoutParams(layoutParams);
        frameLayout.addView(this.l);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.cy = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.q = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = com.byazt.okk.s.s(this.qg, 16.0f);
        layoutParams2.leftMargin = com.byazt.okk.s.s(this.qg, 16.0f);
        this.q.setId(2114387580);
        this.q.setLayoutParams(layoutParams2);
        sz.n(this.qg, "tt_splash_mute", this.q, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        com.byazt.okk.s.n((View) this.q, 8);
        frameLayout.addView(this.q);
        this.s = n(frameLayout, context);
        this.w = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.w.setId(2114387578);
        this.w.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = com.byazt.okk.s.s(this.qg, 40.0f);
        layoutParams3.leftMargin = com.byazt.okk.s.s(this.qg, 20.0f);
        com.byazt.iu.qg.n(this.qg, 1, this.w);
        this.w.setLayoutParams(layoutParams3);
        frameLayout.addView(this.w);
        return frameLayout;
    }

    private void s() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        try {
            View viewN = n(this.qg);
            if (viewN == null) {
                return;
            }
            addView(viewN);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.d);
            this.x = splashClickBar;
            addView(splashClickBar);
            this.hd = getResources().getConfiguration().orientation;
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (com.byazt.nf.rv.qg().t() == 0) {
            return;
        }
        if (com.byazt.nf.rv.qg().t() != 1 || q()) {
            if ((com.byazt.nf.rv.qg().t() == 2 && q()) || this.hd == configuration.orientation) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            setLayoutParams(layoutParams);
            this.hd = configuration.orientation;
            com.byazt.okk.s.n(this, new com.byazt.okk.s.n() { // from class: com.byazt.hi.TsView.2
                @Override // com.byazt.okk.s.n
                public void n(View view) {
                    int height = TsView.this.getHeight();
                    int width = TsView.this.getWidth();
                    if (TsView.this.hd == 2) {
                        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                        layoutParams2.width = height;
                        layoutParams2.height = width;
                        view.setLayoutParams(layoutParams2);
                        view.setRotation(-90.0f);
                        return;
                    }
                    view.setRotation(0.0f);
                    TsView.this.getWidth();
                    TsView.this.getHeight();
                }
            });
        }
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.fs = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.fs.getParent()).removeView(this.fs);
        }
        this.l.addView(this.fs);
        setExpressViewVisibility(0);
        if (this.fs == null || !com.byazt.vhv.q.x().s()) {
            return;
        }
        this.cd.n(an.n());
        this.cd.n(nf.qg(this.d));
        this.fs.n(this.n);
    }

    public NativeExpressView getNativeExpressView() {
        return this.fs;
    }

    public void setCountDownTime(int i) {
        com.byazt.pi.q qVar = this.s;
        if (qVar != null) {
            qVar.setCountDownTime(i);
        }
    }

    public void setSkipIconVisibility(int i) {
        com.byazt.okk.s.n(getCountDownLayout(), i);
    }

    public void setVideoViewVisibility(int i) {
        com.byazt.okk.s.n((View) this.q, i);
    }

    public void setVideoVoiceVisibility(int i) {
        com.byazt.okk.s.n((View) this.q, i);
    }

    public void setAdlogoViewVisibility(int i) {
        com.byazt.okk.s.n((View) this.w, i);
    }

    public void setExpressViewVisibility(int i) {
        com.byazt.okk.s.n((View) this.l, i);
    }

    public void setAttachedToWindowListener(n nVar) {
        this.sz = nVar;
    }

    public com.byazt.pi.q getCountDownView() {
        return this.s;
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!l() && !this.k) {
            post(new com.byazt.qit.x("splash_btn_adjust") { // from class: com.byazt.hi.TsView.3
                @Override // java.lang.Runnable
                public void run() {
                    TsView tsView = TsView.this;
                    com.byazt.okk.s.n(tsView, tsView.getCountDownLayout());
                    TsView tsView2 = TsView.this;
                    com.byazt.okk.s.n(tsView2, tsView2.q);
                }
            });
        }
        n nVar = this.sz;
        if (nVar != null) {
            nVar.rv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getCountDownLayout() {
        com.byazt.pi.q qVar = this.s;
        if (qVar == null) {
            return null;
        }
        return qVar.getView();
    }

    public void setComplianceBarVisibility(int i) {
        if (i == 8) {
            com.byazt.okk.s.n((View) this.x, i);
        }
    }

    public void n(pk pkVar) {
        SplashClickBar splashClickBar = this.x;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.n(pkVar);
            com.byazt.okk.s.n(this.w, pkVar);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        cd.n("不允许在Splash广告中注册OnClickListener");
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        cd.n("不允许在Splash广告中注册OnTouchListener");
    }

    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.byazt.pi.q qVar = this.s;
        if (qVar == null || qVar.getView() == null) {
            return;
        }
        this.s.getView().setOnClickListener(onClickListener);
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.q;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.q;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.oa) {
            return;
        }
        SplashClickBar splashClickBar = this.x;
        if (splashClickBar != null) {
            splashClickBar.setBtnLayout(!q());
        }
        this.oa = true;
    }

    public void n(int i, com.byazt.ys.n nVar) {
        SplashClickBar splashClickBar = this.x;
        if (splashClickBar != null) {
            splashClickBar.n(nVar);
        }
        if (i == 1) {
            nVar.n(this);
            setOnClickListenerInternal(nVar);
            setOnTouchListenerInternal(nVar);
        }
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    public void setCountDownViewPosition(pk pkVar) {
        com.byazt.pi.q qVar = this.s;
        if (qVar == null || qVar.getView() == null || pkVar == null) {
            return;
        }
        View view = this.s.getView();
        fl flVarBa = pkVar.ba();
        if (flVarBa == null) {
            return;
        }
        int iN = flVarBa.n();
        int iS = com.byazt.okk.s.s(this.qg, flVarBa.qg());
        int iS2 = com.byazt.okk.s.s(this.qg, flVarBa.s());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (iN == 1) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = iS;
            layoutParams.topMargin = iS2;
        } else if (iN == 3) {
            layoutParams.gravity = 8388691;
            layoutParams.leftMargin = iS;
            layoutParams.bottomMargin = iS2;
        } else if (iN == 4) {
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = iS;
            layoutParams.bottomMargin = iS2;
        } else {
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = iS;
            layoutParams.topMargin = iS2;
        }
        view.setLayoutParams(layoutParams);
    }

    private boolean qg(pk pkVar) {
        he heVarZo;
        return (pkVar == null || pkVar.rv() != 4 || pkVar.cd() == null || (heVarZo = pkVar.zo()) == null || heVarZo.n() == 0) ? false : true;
    }

    private void setComplianceBarLayout(pk pkVar) {
        he heVarZo;
        if (this.tj == null || !qg(pkVar) || (heVarZo = pkVar.zo()) == null) {
            return;
        }
        int iN = heVarZo.n();
        int iQg = heVarZo.qg();
        int iS = heVarZo.s();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), 25.0f);
        layoutParams.rightMargin = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), 25.0f);
        this.tj.setPadding(20, 20, 20, 20);
        this.tj.setHighlightColor(0);
        if (iN == 2) {
            layoutParams.gravity = 80;
            if (q()) {
                layoutParams.bottomMargin = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), iS);
            } else {
                layoutParams.bottomMargin = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), iQg);
            }
        } else {
            layoutParams.gravity = 48;
            if (q()) {
                layoutParams.topMargin = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), iS);
            } else {
                layoutParams.topMargin = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), iQg);
            }
        }
        this.cp.setLayoutParams(layoutParams);
    }

    private boolean q() {
        return getHeight() < com.byazt.okk.s.s(com.byazt.nf.rv.getContext())[1];
    }

    private boolean l() {
        pk pkVar = this.d;
        return pkVar != null && pkVar.ys() == 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n nVar = this.sz;
        if (nVar != null) {
            nVar.tj();
        }
    }

    public void setIsShowSuccess(boolean z) {
        this.k = z;
    }

    public void n() {
        TextView textView = this.w;
        if (textView != null) {
            sz.n(this.qg, "tt_ad_logo_backup", textView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    public com.byazt.pi.q n(FrameLayout frameLayout, Context context) {
        com.byazt.pi.q tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        pk pkVar = this.d;
        fl flVarBa = pkVar == null ? null : pkVar.ba();
        if ((flVarBa == null ? 1 : flVarBa.q()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387579);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = com.byazt.okk.s.s(this.qg, 16.0f);
            layoutParams.rightMargin = com.byazt.okk.s.s(this.qg, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.cy;
    }

    public void qg() {
        TextView textView = this.w;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.byazt.pi.q qVar = this.s;
        if (qVar == null || qVar.getView() == null) {
            return;
        }
        this.s.n(true);
        this.s.getView().setVisibility(8);
    }
}
