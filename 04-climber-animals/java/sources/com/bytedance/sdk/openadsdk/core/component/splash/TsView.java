package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ao;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.s;
import com.bytedance.sdk.openadsdk.core.nw.vm;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class TsView extends FrameLayout {
    private NativeExpressView ab;
    private ImageView ah;
    private SplashClickBar c;
    private FrameLayout ch;
    private FrameLayout d;
    private lm hi;
    private TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f2341ms;
    private TextView ny;
    private boolean sl;
    private boolean u;
    private FrameLayout ub;
    private String x;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.d xr;
    private ms zb;

    public interface ms {
        void ab();

        void c();

        void ms(boolean z);
    }

    public TsView(Context context, String str, lm lmVar) {
        super(context);
        this.sl = false;
        this.u = false;
        this.f2341ms = context;
        this.x = str;
        this.hi = lmVar;
        ah();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ms msVar = this.zb;
        if (msVar != null) {
            msVar.ms(z);
        }
    }

    private View ms(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(2114387588);
        this.d = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.d.setId(2114387587);
        this.d.setLayoutParams(layoutParams);
        frameLayout.addView(this.d);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.ub = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.ah = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 30.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 8388659;
        layoutParams2.topMargin = ul.ah(this.f2341ms, 16.0f);
        layoutParams2.leftMargin = ul.ah(this.f2341ms, 16.0f);
        this.ah.setId(2114387586);
        this.ah.setLayoutParams(layoutParams2);
        t.ms(this.f2341ms, "tt_splash_mute", this.ah);
        ul.ms((View) this.ah, 8);
        frameLayout.addView(this.ah);
        this.xr = ms(frameLayout, context);
        this.ka = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        this.ka.setId(2114387584);
        this.ka.setGravity(17);
        layoutParams3.gravity = 8388691;
        layoutParams3.bottomMargin = ul.ah(this.f2341ms, 40.0f);
        layoutParams3.leftMargin = ul.ah(this.f2341ms, 20.0f);
        t.ms(this.f2341ms, "tt_ad_logo_new", this.ka);
        this.ka.setLayoutParams(layoutParams3);
        frameLayout.addView(this.ka);
        return frameLayout;
    }

    private void ah() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        try {
            View viewMs = ms(this.f2341ms);
            if (viewMs == null) {
                return;
            }
            addView(viewMs);
            SplashClickBar splashClickBar = new SplashClickBar(getContext(), this.hi);
            this.c = splashClickBar;
            addView(splashClickBar);
            FrameLayout frameLayoutXr = xr(this.hi);
            this.ch = frameLayoutXr;
            if (frameLayoutXr != null) {
                addView(frameLayoutXr);
            }
        } catch (Throwable unused) {
        }
    }

    public void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        this.ab = nativeExpressView;
        if (nativeExpressView.getParent() != null) {
            ((ViewGroup) this.ab.getParent()).removeView(this.ab);
        }
        this.d.addView(this.ab);
        setExpressViewVisibility(0);
    }

    public void setCountDownTime(int i) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.d dVar = this.xr;
        if (dVar != null) {
            dVar.setCountDownTime(i);
        }
    }

    public void setSkipIconVisibility(int i) {
        ul.ms(getCountDownLayout(), i);
    }

    public void setVideoViewVisibility(int i) {
        ul.ms((View) this.ah, i);
    }

    void setVideoVoiceVisibility(int i) {
        ul.ms((View) this.ah, i);
    }

    public void setAdlogoViewVisibility(int i) {
        ul.ms((View) this.ka, i);
    }

    void setExpressViewVisibility(int i) {
        ul.ms((View) this.d, i);
    }

    public void setAttachedToWindowListener(ms msVar) {
        this.zb = msVar;
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.d getCountDownView() {
        return this.xr;
    }

    public View getDislikeView() {
        return getCountDownLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!ka() && !this.u) {
            ul.ms(this, getCountDownLayout());
            ul.ms(this, this.ah);
        }
        ms msVar = this.zb;
        if (msVar != null) {
            msVar.c();
        }
    }

    private View getCountDownLayout() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.d dVar = this.xr;
        if (dVar == null) {
            return null;
        }
        return dVar.getView();
    }

    public void setComplianceBarVisibility(int i) {
        if (i == 8) {
            ul.ms((View) this.c, i);
        }
        ul.ms((View) this.ch, i);
    }

    public void ms(lm lmVar) {
        SplashClickBar splashClickBar = this.c;
        if (splashClickBar == null) {
            return;
        }
        try {
            splashClickBar.ms(lmVar);
            ul.ms(this.ka, lmVar);
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        ao.ms("不允许在Splash广告中注册OnClickListener");
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        ao.ms("不允许在Splash广告中注册OnTouchListener");
    }

    final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void setSkipListener(View.OnClickListener onClickListener) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.d dVar = this.xr;
        if (dVar == null || dVar.getView() == null) {
            return;
        }
        this.xr.getView().setOnClickListener(onClickListener);
    }

    public final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.ah;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public final void setVoiceViewImageDrawable(Drawable drawable) {
        ImageView imageView = this.ah;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.sl) {
            return;
        }
        SplashClickBar splashClickBar = this.c;
        if (splashClickBar != null) {
            splashClickBar.setBtnLayout(!d());
        }
        setComplianceBarLayout(this.hi);
        this.sl = true;
    }

    public void ms(int i, com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        SplashClickBar splashClickBar = this.c;
        if (splashClickBar != null) {
            splashClickBar.ms(msVar);
        }
        if (i == 1) {
            msVar.ms(this);
            setOnClickListenerInternal(msVar);
            setOnTouchListenerInternal(msVar);
        }
    }

    public void setSlideUpTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListenerInternal(onTouchListener);
    }

    public void setCountDownViewPosition(lm lmVar) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.d dVar = this.xr;
        if (dVar == null || dVar.getView() == null || lmVar == null) {
            return;
        }
        View view = this.xr.getView();
        vm vmVarJf = lmVar.jf();
        if (vmVarJf == null) {
            return;
        }
        int iMs = vmVarJf.ms();
        int iAh = ul.ah(this.f2341ms, vmVarJf.xr());
        int iAh2 = ul.ah(this.f2341ms, vmVarJf.ah());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (iMs == 1) {
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = iAh;
            layoutParams.topMargin = iAh2;
        } else if (iMs == 3) {
            layoutParams.gravity = 8388691;
            layoutParams.leftMargin = iAh;
            layoutParams.bottomMargin = iAh2;
        } else if (iMs == 4) {
            layoutParams.gravity = 8388693;
            layoutParams.rightMargin = iAh;
            layoutParams.bottomMargin = iAh2;
        } else {
            layoutParams.gravity = 8388661;
            layoutParams.rightMargin = iAh;
            layoutParams.topMargin = iAh2;
        }
        view.setLayoutParams(layoutParams);
    }

    public FrameLayout xr(final lm lmVar) {
        com.bytedance.sdk.openadsdk.core.nw.c cVarPh;
        s sVarQp;
        if (lmVar == null || lmVar.jr() != 4 || (cVarPh = lmVar.ph()) == null || (sVarQp = lmVar.qp()) == null || sVarQp.ms() == 0) {
            return null;
        }
        String strU = cVarPh.u();
        if (TextUtils.isEmpty(strU)) {
            strU = "暂无";
        }
        String strKa = cVarPh.ka();
        if (TextUtils.isEmpty(strKa)) {
            strKa = "补充中，可于应用官网查看";
        }
        String strAb = cVarPh.ab();
        String str = TextUtils.isEmpty(strAb) ? "补充中，可于应用官网查看" : strAb;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append("应用名：").append(strU).append("；版本号：").append(strKa).append("；开发者：").append(str);
        String strHi = cVarPh.hi();
        if (TextUtils.isEmpty(strHi)) {
            sbAppend.append("；功能 | 权限 | 隐私  ");
        } else {
            sbAppend.append("；功能 | 权限 | 隐私 | 备案  ");
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        int iIndexOf = sb.indexOf("功能");
        int i = iIndexOf + 2;
        int iIndexOf2 = sb.indexOf("隐私");
        int i2 = iIndexOf2 + 2;
        int iIndexOf3 = sb.indexOf("权限");
        int i3 = iIndexOf3 + 2;
        if (!TextUtils.isEmpty(strHi)) {
            int iIndexOf4 = sb.indexOf("备案");
            spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    TsView tsView = TsView.this;
                    tsView.ms(lmVar, tsView.f2341ms, TsView.this.x);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    if (textPaint != null) {
                        textPaint.setColor(-1);
                    }
                }
            }, iIndexOf4, iIndexOf4 + 2, 34);
        }
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.xr(lmVar, tsView.f2341ms, TsView.this.x);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf, i, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.d(lmVar, tsView.f2341ms, TsView.this.x);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf2, i2, 34);
        spannableString.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.TsView.4
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                TsView tsView = TsView.this;
                tsView.ah(lmVar, tsView.f2341ms, TsView.this.x);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                if (textPaint != null) {
                    textPaint.setColor(-1);
                }
            }
        }, iIndexOf3, i3, 34);
        this.ny = new TextView(this.f2341ms);
        this.ch = new FrameLayout(this.f2341ms);
        this.ny.setMovementMethod(LinkMovementMethod.getInstance());
        this.ny.setTextColor(-1);
        this.ny.setTextSize(11.0f);
        this.ny.setText(spannableString);
        this.ch.addView(this.ny);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#66000000"));
        gradientDrawable.setCornerRadius(ul.ah(this.f2341ms, 6.0f));
        this.ch.setBackground(gradientDrawable);
        return this.ch;
    }

    private boolean ah(lm lmVar) {
        s sVarQp;
        return (lmVar == null || lmVar.jr() != 4 || lmVar.ph() == null || (sVarQp = lmVar.qp()) == null || sVarQp.ms() == 0) ? false : true;
    }

    private void setComplianceBarLayout(lm lmVar) {
        s sVarQp;
        if (this.ny == null || !ah(lmVar) || (sVarQp = lmVar.qp()) == null) {
            return;
        }
        int iMs = sVarQp.ms();
        int iXr = sVarQp.xr();
        int iAh = sVarQp.ah();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = ul.ah(re.getContext(), 25.0f);
        layoutParams.rightMargin = ul.ah(re.getContext(), 25.0f);
        this.ny.setPadding(20, 20, 20, 20);
        this.ny.setHighlightColor(0);
        if (iMs == 2) {
            layoutParams.gravity = 80;
            if (d()) {
                layoutParams.bottomMargin = ul.ah(re.getContext(), iAh);
            } else {
                layoutParams.bottomMargin = ul.ah(re.getContext(), iXr);
            }
        } else {
            layoutParams.gravity = 48;
            if (d()) {
                layoutParams.topMargin = ul.ah(re.getContext(), iAh);
            } else {
                layoutParams.topMargin = ul.ah(re.getContext(), iXr);
            }
        }
        this.ch.setLayoutParams(layoutParams);
    }

    public void ms(lm lmVar, Context context, String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ms(lmVar, context, str);
    }

    public void xr(lm lmVar, Context context, String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ms(context, lmVar, str);
    }

    public void ah(lm lmVar, Context context, String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ah(lmVar, context, str);
    }

    public void d(lm lmVar, Context context, String str) {
        if (lmVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.xr(lmVar, context, str);
    }

    private boolean d() {
        return getHeight() < ul.xr(re.getContext())[1];
    }

    private boolean ka() {
        lm lmVar = this.hi;
        return lmVar != null && lmVar.od() == 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ms msVar = this.zb;
        if (msVar != null) {
            msVar.ab();
        }
    }

    public void setIsShowSuccess(boolean z) {
        this.u = z;
    }

    public void ms() {
        TextView textView = this.ka;
        if (textView != null) {
            t.ms(this.f2341ms, "tt_ad_logo_backup", textView);
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.countdown.d ms(FrameLayout frameLayout, Context context) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.d tTCountdownViewForBtn;
        FrameLayout.LayoutParams layoutParams;
        Resources resources = context.getResources();
        lm lmVar = this.hi;
        vm vmVarJf = lmVar == null ? null : lmVar.jf();
        if ((vmVarJf == null ? 1 : vmVarJf.d()) == 1) {
            tTCountdownViewForBtn = new TTCountdownViewForCircle(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics()));
        } else {
            tTCountdownViewForBtn = new TTCountdownViewForBtn(context);
            layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 76.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 26.0f, resources.getDisplayMetrics()));
        }
        if (tTCountdownViewForBtn.getView() != null) {
            tTCountdownViewForBtn.getView().setId(2114387585);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = ul.ah(this.f2341ms, 16.0f);
            layoutParams.rightMargin = ul.ah(this.f2341ms, 16.0f);
            tTCountdownViewForBtn.getView().setLayoutParams(layoutParams);
            frameLayout.addView(tTCountdownViewForBtn.getView());
        }
        return tTCountdownViewForBtn;
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.ub;
    }

    public void xr() {
        TextView textView = this.ka;
        if (textView != null) {
            textView.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.d dVar = this.xr;
        if (dVar == null || dVar.getView() == null) {
            return;
        }
        this.xr.ms(true);
        this.xr.getView().setVisibility(8);
    }
}
