package com.byazt.jm;

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
import com.byazt.ca.g;
import com.byazt.ca.lb;
import com.byazt.ck.TTCountdownViewForBtn;
import com.byazt.ck.TTCountdownViewForCircle;
import com.byazt.hg.d;
import com.byazt.hg.ie;
import com.byazt.hg.n;
import com.byazt.hg.of;
import com.byazt.hg.wt;
import com.byazt.qx.NativeExpressView;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_INITED_TIME})
public class TsView extends FrameLayout {
    public String aj;
    public FrameLayout c;
    public SplashClickBar fw;
    public pr g;
    public com.byazt.ck.x hn;
    public boolean ho;
    public final Context hw;
    public of k;
    public final com.byazt.cy.hw lb;
    public boolean m;
    public FrameLayout nt;
    public final com.byazt.cy.pr pr;
    public TextView uc;
    public TextView vk;
    public FrameLayout w;
    public ImageView x;
    public int yb;
    public NativeExpressView zo;

    public interface pr {
        void fw();

        void pr(boolean z);

        void uc();
    }

    public TsView(Context context, String str, of ofVar) {
        super(context);
        this.m = false;
        this.ho = false;
        com.byazt.cy.hw hwVar = new com.byazt.cy.hw();
        this.lb = hwVar;
        this.pr = new com.byazt.cy.pr() { // from class: com.byazt.jm.TsView.1
            @Override // com.byazt.cy.pr
            public void pr(boolean z, JSONObject jSONObject) {
                if (!z) {
                    return;
                }
                boolean zX = n.x();
                if (ie.hw(TsView.this.k) && zX) {
                    TsView.this.lb.hw(2);
                    com.byazt.qx.zo.hw(TsView.this.zo);
                }
            }
        };
        this.hw = context;
        this.aj = str;
        this.k = ofVar;
        hwVar.pr(ofVar);
        hn();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        pr prVar = this.g;
        if (prVar != null) {
            prVar.pr(z);
        }
    }

    private View pr(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387582);
        this.c = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.c.setId(2114387581);
        this.c.setLayoutParams(layoutParams);
        frameLayout.addView(this.c);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.nt = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.x = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = er.hn(this.hw, 16.0f);
        layoutParams2.leftMargin = er.hn(this.hw, 16.0f);
        this.x.setId(2114387580);
        this.x.setLayoutParams(layoutParams2);
        g.pr(this.hw, "tt_splash_mute", this.x, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        er.pr((View) this.x, 8);
        frameLayout.addView(this.x);
        this.hn = pr(frameLayout, context);
        this.uc = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.uc.setId(2114387578);
        this.uc.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = er.hn(this.hw, 40.0f);
        layoutParams3.leftMargin = er.hn(this.hw, 20.0f);
        com.byazt.hb.x.pr(this.hw, 1, this.uc);
        this.uc.setLayoutParams(layoutParams3);
        frameLayout.addView(this.uc);
        return frameLayout;
    }

    private void hn() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        try {
            View viewPr = pr(this.hw);
            if (viewPr == null) {
                return;
            }
            addView(viewPr);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.k);
            this.fw = splashClickBar;
            addView(splashClickBar);
            this.yb = getResources().getConfiguration().orientation;
        } catch (Throwable th) {
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.hw().iu() == 0) {
            return;
        }
        if (a.hw().iu() == 1 && !x()) {
            return;
        }
        if ((a.hw().iu() == 2 && x()) || this.yb == configuration.orientation) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        setLayoutParams(layoutParams);
        this.yb = configuration.orientation;
        er.pr(this, new er.pr() { // from class: com.byazt.jm.TsView.2
            @Override // com.byazt.wt.er.pr
            public void pr(View view) {
                int height = TsView.this.getHeight();
                int width = TsView.this.getWidth();
                if (TsView.this.yb == 2) {
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

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.zo = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.zo.getParent()).removeView(this.zo);
        }
        this.c.addView(this.zo);
        setExpressViewVisibility(0);
        if (this.zo != null && com.byazt.ak.x.fw().hn()) {
            this.lb.pr(n.pr());
            this.lb.pr(ie.hw(this.k));
            this.zo.pr(this.pr);
        }
    }

    public NativeExpressView getNativeExpressView() {
        return this.zo;
    }

    public void setCountDownTime(int i) {
        com.byazt.ck.x xVar = this.hn;
        if (xVar != null) {
            xVar.setCountDownTime(i);
        }
    }

    public void setSkipIconVisibility(int i) {
        er.pr(getCountDownLayout(), i);
    }

    public void setVideoViewVisibility(int i) {
        er.pr((View) this.x, i);
    }

    public void setVideoVoiceVisibility(int i) {
        er.pr((View) this.x, i);
    }

    public void setAdlogoViewVisibility(int i) {
        er.pr((View) this.uc, i);
    }

    public void setExpressViewVisibility(int i) {
        er.pr((View) this.c, i);
    }

    public void setAttachedToWindowListener(pr prVar) {
        this.g = prVar;
    }

    public com.byazt.ck.x getCountDownView() {
        return this.hn;
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!c() && !this.ho) {
            post(new com.byazt.xlm.fw("splash_btn_adjust") { // from class: com.byazt.jm.TsView.3
                @Override // java.lang.Runnable
                public void run() {
                    TsView tsView = TsView.this;
                    er.pr(tsView, tsView.getCountDownLayout());
                    TsView tsView2 = TsView.this;
                    er.pr(tsView2, tsView2.x);
                }
            });
        }
        pr prVar = this.g;
        if (prVar != null) {
            prVar.uc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getCountDownLayout() {
        com.byazt.ck.x xVar = this.hn;
        if (xVar == null) {
            return null;
        }
        return xVar.getView();
    }

    public void setComplianceBarVisibility(int i) {
        if (i == 8) {
            er.pr((View) this.fw, i);
        }
    }

    public void pr(of ofVar) {
        SplashClickBar splashClickBar = this.fw;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.pr(ofVar);
            er.pr(this.uc, ofVar);
        } catch (Throwable th) {
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        lb.pr("不允许在Splash广告中注册OnClickListener");
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        lb.pr("不允许在Splash广告中注册OnTouchListener");
    }

    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    public final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.byazt.ck.x xVar = this.hn;
        if (xVar != null && xVar.getView() != null) {
            this.hn.getView().setOnClickListener(onClickListener);
        }
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.m) {
            SplashClickBar splashClickBar = this.fw;
            if (splashClickBar != null) {
                splashClickBar.setBtnLayout(!x());
            }
            this.m = true;
        }
    }

    public void pr(int i, com.byazt.az.pr prVar) {
        SplashClickBar splashClickBar = this.fw;
        if (splashClickBar != null) {
            splashClickBar.pr(prVar);
        }
        if (i == 1) {
            prVar.pr(this);
            setOnClickListenerInternal(prVar);
            setOnTouchListenerInternal(prVar);
        }
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    public void setCountDownViewPosition(of ofVar) {
        com.byazt.ck.x xVar = this.hn;
        if (xVar == null || xVar.getView() == null || ofVar == null) {
            return;
        }
        View view = this.hn.getView();
        wt wtVarFf = ofVar.ff();
        if (wtVarFf == null) {
            return;
        }
        int iPr = wtVarFf.pr();
        int iHn = er.hn(this.hw, wtVarFf.hw());
        int iHn2 = er.hn(this.hw, wtVarFf.hn());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        switch (iPr) {
            case 1:
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = iHn;
                layoutParams.topMargin = iHn2;
                break;
            case 2:
            default:
                layoutParams.gravity = 8388661;
                layoutParams.rightMargin = iHn;
                layoutParams.topMargin = iHn2;
                break;
            case 3:
                layoutParams.gravity = 8388691;
                layoutParams.leftMargin = iHn;
                layoutParams.bottomMargin = iHn2;
                break;
            case 4:
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = iHn;
                layoutParams.bottomMargin = iHn2;
                break;
        }
        view.setLayoutParams(layoutParams);
    }

    private boolean hw(of ofVar) {
        d dVarQr;
        if (ofVar == null || ofVar.aj() != 4 || ofVar.lb() == null || (dVarQr = ofVar.qr()) == null || dVarQr.pr() == 0) {
            return false;
        }
        return true;
    }

    private void setComplianceBarLayout(of ofVar) {
        d dVarQr;
        if (this.vk == null || !hw(ofVar) || (dVarQr = ofVar.qr()) == null) {
            return;
        }
        int iPr = dVarQr.pr();
        int iHw = dVarQr.hw();
        int iHn = dVarQr.hn();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = er.hn(a.getContext(), 25.0f);
        layoutParams.rightMargin = er.hn(a.getContext(), 25.0f);
        this.vk.setPadding(20, 20, 20, 20);
        this.vk.setHighlightColor(0);
        if (iPr == 2) {
            layoutParams.gravity = 80;
            if (x()) {
                layoutParams.bottomMargin = er.hn(a.getContext(), iHn);
            } else {
                layoutParams.bottomMargin = er.hn(a.getContext(), iHw);
            }
        } else {
            layoutParams.gravity = 48;
            if (x()) {
                layoutParams.topMargin = er.hn(a.getContext(), iHn);
            } else {
                layoutParams.topMargin = er.hn(a.getContext(), iHw);
            }
        }
        this.w.setLayoutParams(layoutParams);
    }

    private boolean x() {
        return getHeight() < er.hn(a.getContext())[1];
    }

    private boolean c() {
        of ofVar = this.k;
        return ofVar != null && ofVar.rf() == 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pr prVar = this.g;
        if (prVar != null) {
            prVar.fw();
        }
    }

    public void setIsShowSuccess(boolean z) {
        this.ho = z;
    }

    public void pr() {
        TextView textView = this.uc;
        if (textView != null) {
            g.pr(this.hw, "tt_ad_logo_backup", textView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
    }

    public com.byazt.ck.x pr(FrameLayout frameLayout, Context context) {
        com.byazt.ck.x tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        of ofVar = this.k;
        wt wtVarFf = ofVar == null ? null : ofVar.ff();
        if ((wtVarFf == null ? 1 : wtVarFf.x()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387579);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = er.hn(this.hw, 16.0f);
            layoutParams.rightMargin = er.hn(this.hw, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.nt;
    }

    public void hw() {
        TextView textView = this.uc;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.byazt.ck.x xVar = this.hn;
        if (xVar != null && xVar.getView() != null) {
            this.hn.pr(true);
            this.hn.getView().setVisibility(8);
        }
    }
}
