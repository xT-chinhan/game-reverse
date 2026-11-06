package com.byazt.yhm;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.CircleLongPressView;
import com.byazt.jt.ClickSlideUpShakeView;
import com.byazt.jt.RippleView;
import com.byazt.jt.ShakeAnimationView;
import com.byazt.jt.WriggleGuideAnimationView;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.umeng.analytics.pro.cc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 2079})
public class InteractViewContainer extends FrameLayout implements zo {
    public int aj;
    public fw c;
    public RippleView fw;
    public com.byazt.rk.fw hn;
    public DynamicBaseWidget hw;
    public com.byazt.mq.m k;
    public Context pr;
    public String uc;
    public boolean vk;
    public com.byazt.rk.vk w;
    public View x;
    public View.OnTouchListener zo;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        super(context);
        this.pr = context;
        this.hw = dynamicBaseWidget;
        this.hn = fwVar;
        fw();
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar, com.byazt.rk.vk vkVar, com.byazt.mq.m mVar) {
        super(context);
        this.pr = context;
        this.hw = dynamicBaseWidget;
        this.hn = fwVar;
        this.w = vkVar;
        this.k = mVar;
        fw();
    }

    private void fw() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.uc = this.hn.qn();
        this.aj = this.hn.i();
        this.vk = this.hn.jn();
        fw fwVarPr = aj.pr(this.pr, this.hw, this.hn, this.w, this.k);
        this.c = fwVarPr;
        if (fwVarPr != null) {
            this.x = fwVarPr.hn();
            if (this.hn.of()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.uc, GlobalSetting.NATIVE_UNIFIED_AD)) {
                if (this.hn.l() && !TextUtils.isEmpty(this.hn.lv())) {
                    this.fw = new RippleView(this.pr, com.byazt.rk.fw.pr(this.hn.lv()));
                } else {
                    this.fw = new RippleView(this.pr, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.pr);
                frameLayout.addView(this.fw, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.byazt.yhm.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.fw.hw();
                    }
                });
            }
            if (pr(this.uc) && com.byazt.dj.x.pr()) {
                int color = Color.parseColor("#99000000");
                if (this.hn.l() && !TextUtils.isEmpty(this.hn.lv())) {
                    try {
                        color = com.byazt.rk.fw.pr(this.hn.lv());
                    } catch (Exception e) {
                    }
                }
                View view = new View(this.pr);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.c.hn());
            pr(this.c.hn());
            setVisibility(0);
        }
    }

    private boolean pr(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zo instanceof com.byazt.ww.hn) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void pr(ViewGroup viewGroup) {
        if (this.x == null) {
            return;
        }
        String str = this.uc;
        byte b = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    b = 7;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    b = 8;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = cc.m;
                }
                break;
            case 53:
                if (str.equals(GlobalSetting.REWARD_VIDEO_AD)) {
                    b = cc.k;
                }
                break;
            case 54:
                if (str.equals(GlobalSetting.NATIVE_UNIFIED_AD)) {
                    b = 9;
                }
                break;
            case 55:
                if (str.equals(GlobalSetting.UNIFIED_BANNER_AD)) {
                    b = cc.n;
                }
                break;
            case 56:
                if (str.equals(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                    b = 11;
                }
                break;
            case 57:
                if (str.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD)) {
                    b = 0;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b = 6;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    b = 10;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    b = 12;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    b = 2;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    b = cc.l;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    b = 17;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    b = 1;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    b = 18;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    b = 19;
                }
                break;
            case 1600:
                if (str.equals("22")) {
                    b = 20;
                }
                break;
            case 1601:
                if (str.equals("23")) {
                    b = 4;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    b = 3;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    b = 5;
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
            case 1:
                this.x.setTag(2);
                break;
            case 2:
            case 3:
                if (this.uc.equals("24") && com.byazt.dj.x.pr()) {
                    this.hw.setClipChildren(false);
                    this.zo = new com.byazt.ww.uc(this);
                } else {
                    this.zo = new com.byazt.ww.c(this, this.aj, this.k.gz());
                }
                break;
            case 4:
                if (com.byazt.dj.x.pr()) {
                    this.zo = new com.byazt.ww.uc(this);
                }
                break;
            case 5:
                if (com.byazt.dj.x.pr()) {
                    this.zo = new com.byazt.ww.zo(this, this.vk);
                }
                break;
            case 6:
                this.zo = new com.byazt.ww.x(this, this.aj, this.vk);
                break;
            case 7:
                this.zo = new com.byazt.ww.c(this, this.aj, this.k.gz());
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 8:
            case 9:
                if (!this.hn.l() || TextUtils.isEmpty(this.hn.lv())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.zo = new com.byazt.ww.uc(this);
                break;
            case 10:
            case 11:
                this.hw.setClipChildren(false);
                this.hw.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.hw.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.zo = new com.byazt.ww.uc(this);
                break;
            case 12:
                this.zo = new com.byazt.ww.hn(this);
                this.x.setTag(2);
                break;
            case 13:
                if (this.hn.l() && !TextUtils.isEmpty(this.hn.lv())) {
                    setBackgroundColor(com.byazt.rk.fw.pr(this.hn.lv()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.zo = new com.byazt.ww.hn(this);
                this.x.setTag(2);
                break;
            case 14:
                this.zo = new com.byazt.ww.hw(this, this);
                break;
            case 15:
            case 16:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.zo = new com.byazt.ww.hw(this, this);
                break;
            case 17:
                View view = this.x;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.x).getShakeLayout().setTag(2);
                }
                this.x.setTag(2);
                break;
            case 18:
                View view2 = this.x;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.x).getWriggleLayout().setTag(2);
                }
                this.x.setTag(2);
                break;
            case 19:
                this.zo = new com.byazt.ww.pr(this, this.aj, viewGroup);
                break;
            case 20:
                if (com.byazt.dj.x.pr()) {
                    this.zo = new com.byazt.ww.zo(this, this.vk);
                } else {
                    this.zo = new com.byazt.ww.fw(this, this.aj, viewGroup);
                }
                break;
            case 21:
                View view3 = this.x;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.x).getShakeView().setTag(2);
                }
                this.zo = new com.byazt.ww.c(this, this.aj, this.k.gz());
                break;
        }
        View.OnTouchListener onTouchListener = this.zo;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (zo()) {
            this.x.setTag(2);
            setOnClickListener((View.OnClickListener) this.hw.getDynamicClickListener());
        }
    }

    private boolean zo() {
        return (this.hn.jn() || TextUtils.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD, this.uc) || TextUtils.equals("16", this.uc) || TextUtils.equals("17", this.uc) || TextUtils.equals("18", this.uc) || TextUtils.equals("20", this.uc) || TextUtils.equals("29", this.uc) || TextUtils.equals("10", this.uc)) ? false : true;
    }

    public void hn() {
        fw fwVar = this.c;
        if (fwVar != null) {
            fwVar.pr();
        }
    }

    public void x() {
        fw fwVar = this.c;
        if (fwVar != null) {
            fwVar.hw();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            fw fwVar = this.c;
            if (fwVar != null) {
                fwVar.hw();
            }
        } catch (Exception e) {
            com.byazt.ca.ho.pr(e.getMessage());
        }
    }

    public void c() {
        if (this.x != null && TextUtils.equals(this.uc, "2")) {
            View view = this.x;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).hn();
            }
        }
    }

    public void uc() {
        if (this.x != null && TextUtils.equals(this.uc, "2")) {
            View view = this.x;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).x();
            }
        }
    }

    @Override // com.byazt.yhm.zo
    public void pr() {
        if (TextUtils.equals(this.uc, GlobalSetting.NATIVE_UNIFIED_AD)) {
            RippleView rippleView = this.fw;
            if (rippleView != null) {
                rippleView.hn();
                postDelayed(new Runnable() { // from class: com.byazt.yhm.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.aj();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.uc, "20")) {
            postDelayed(new Runnable() { // from class: com.byazt.yhm.InteractViewContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.aj();
                }
            }, 400L);
        } else {
            aj();
        }
    }

    @Override // com.byazt.yhm.zo
    public void hw() {
        if (zo()) {
            setOnClickListener((View.OnClickListener) this.hw.getDynamicClickListener());
            performClick();
            if (!this.hn.cr()) {
                setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        if (this.zo != null) {
            setOnClickListener((View.OnClickListener) this.hw.getDynamicClickListener());
            performClick();
            if (!this.hn.cr()) {
                setVisibility(8);
            }
        }
    }
}
