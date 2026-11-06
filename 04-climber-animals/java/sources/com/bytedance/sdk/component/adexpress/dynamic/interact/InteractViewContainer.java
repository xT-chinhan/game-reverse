package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes2.dex */
public class InteractViewContainer extends FrameLayout implements x {
    private RippleView ab;
    private com.bytedance.sdk.component.adexpress.dynamic.ah.ab ah;
    private String c;
    private boolean ch;
    private View d;
    private com.bytedance.sdk.component.adexpress.dynamic.ah.ch hi;
    private ab ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f843ms;
    private int ny;
    private com.bytedance.sdk.component.adexpress.xr.zb sl;
    private View.OnTouchListener x;
    private DynamicBaseWidget xr;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        super(context);
        this.f843ms = context;
        this.xr = dynamicBaseWidget;
        this.ah = abVar;
        ab();
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar, com.bytedance.sdk.component.adexpress.dynamic.ah.ch chVar, com.bytedance.sdk.component.adexpress.xr.zb zbVar) {
        super(context);
        this.f843ms = context;
        this.xr = dynamicBaseWidget;
        this.ah = abVar;
        this.hi = chVar;
        this.sl = zbVar;
        ab();
    }

    private void ab() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.c = this.ah.e();
        this.ny = this.ah.fm();
        this.ch = this.ah.ti();
        ab abVarMs = ny.ms(this.f843ms, this.xr, this.ah, this.hi, this.sl);
        this.ka = abVarMs;
        if (abVarMs != null) {
            this.d = abVarMs.ah();
            if (this.ah.k()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.c, "6")) {
                if (this.ah.s() && !TextUtils.isEmpty(this.ah.v())) {
                    this.ab = new RippleView(this.f843ms, com.bytedance.sdk.component.adexpress.dynamic.ah.ab.ms(this.ah.v()));
                } else {
                    this.ab = new RippleView(this.f843ms, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.f843ms);
                frameLayout.addView(this.ab, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.ab.xr();
                    }
                });
            }
            if (ms(this.c) && com.bytedance.sdk.component.adexpress.d.ms()) {
                int color = Color.parseColor("#99000000");
                if (this.ah.s() && !TextUtils.isEmpty(this.ah.v())) {
                    try {
                        color = com.bytedance.sdk.component.adexpress.dynamic.ah.ab.ms(this.ah.v());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.f843ms);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.ka.ah());
            ms(this.ka.ah());
            setVisibility(0);
        }
    }

    private boolean ms(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.x instanceof com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ah) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void ms(ViewGroup viewGroup) {
        if (this.d == null) {
            return;
        }
        String str = this.c;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (str.equals(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                    b = 6;
                }
                break;
            case 57:
                if (str.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD)) {
                    b = 7;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    b = 10;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    b = 11;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    b = 12;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    b = ek.k;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    b = ek.l;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    b = ek.m;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    b = ek.n;
                }
                break;
            case 1600:
                if (str.equals("22")) {
                    b = 17;
                }
                break;
            case 1601:
                if (str.equals("23")) {
                    b = 18;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    b = 20;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    b = 21;
                }
                break;
        }
        switch (b) {
            case 0:
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ka(this, this.ny);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.ah.s() || TextUtils.isEmpty(this.ah.v())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.c(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.xr(this, this);
                break;
            case 3:
                if (this.ah.s() && !TextUtils.isEmpty(this.ah.v())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.ah.ab.ms(this.ah.v()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ah(this);
                this.d.setTag(2);
                break;
            case 6:
            case 9:
                this.xr.setClipChildren(false);
                this.xr.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.xr.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.c(this);
                break;
            case 7:
            case 14:
                this.d.setTag(2);
                break;
            case 8:
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.d(this, this.ny, this.ch);
                break;
            case 10:
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ah(this);
                this.d.setTag(2);
                break;
            case 11:
            case 19:
                if (this.c.equals("24") && com.bytedance.sdk.component.adexpress.d.ms()) {
                    this.xr.setClipChildren(false);
                    this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.c(this);
                } else {
                    this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ka(this, this.ny);
                }
                break;
            case 12:
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.xr(this, this);
                break;
            case 13:
                View view = this.d;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.d).getShakeLayout().setTag(2);
                }
                this.d.setTag(2);
                break;
            case 15:
                View view2 = this.d;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.d).getWriggleLayout().setTag(2);
                }
                this.d.setTag(2);
                break;
            case 16:
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ms(this, this.ny, viewGroup);
                break;
            case 17:
                if (com.bytedance.sdk.component.adexpress.d.ms()) {
                    this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.x(this, this.ch);
                } else {
                    this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ab(this, this.ny, viewGroup);
                }
                break;
            case 18:
                if (com.bytedance.sdk.component.adexpress.d.ms()) {
                    this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.c(this);
                }
                break;
            case 20:
                if (com.bytedance.sdk.component.adexpress.d.ms()) {
                    this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.x(this, this.ch);
                }
                break;
            case 21:
                View view3 = this.d;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.d).getShakeView().setTag(2);
                }
                this.x = new com.bytedance.sdk.component.adexpress.dynamic.interact.ms.ka(this, this.ny);
                break;
        }
        View.OnTouchListener onTouchListener = this.x;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (x()) {
            this.d.setTag(2);
            setOnClickListener((View.OnClickListener) this.xr.getDynamicClickListener());
        }
    }

    private boolean x() {
        return (this.ah.ti() || TextUtils.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD, this.c) || TextUtils.equals("16", this.c) || TextUtils.equals("17", this.c) || TextUtils.equals("18", this.c) || TextUtils.equals("20", this.c) || TextUtils.equals("29", this.c) || TextUtils.equals("10", this.c)) ? false : true;
    }

    public void ah() {
        ab abVar = this.ka;
        if (abVar != null) {
            abVar.ms();
        }
    }

    public void d() {
        ab abVar = this.ka;
        if (abVar != null) {
            abVar.xr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            ab abVar = this.ka;
            if (abVar != null) {
                abVar.xr();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.xr(e.getMessage());
        }
    }

    public void ka() {
        if (this.d != null && TextUtils.equals(this.c, "2")) {
            View view = this.d;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).ah();
            }
        }
    }

    public void c() {
        if (this.d != null && TextUtils.equals(this.c, "2")) {
            View view = this.d;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).d();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void ms() {
        if (TextUtils.equals(this.c, "6")) {
            RippleView rippleView = this.ab;
            if (rippleView != null) {
                rippleView.ah();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.ny();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.c, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.ny();
                }
            }, 400L);
        } else {
            ny();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.x
    public void xr() {
        if (x()) {
            setOnClickListener((View.OnClickListener) this.xr.getDynamicClickListener());
            performClick();
            if (this.ah.bz()) {
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        if (this.x != null) {
            setOnClickListener((View.OnClickListener) this.xr.getDynamicClickListener());
            performClick();
            if (this.ah.bz()) {
                return;
            }
            setVisibility(8);
        }
    }
}
