package com.byazt.jmk;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.CircleLongPressView;
import com.byazt.stl.ClickSlideUpShakeView;
import com.byazt.stl.RippleView;
import com.byazt.stl.ShakeAnimationView;
import com.byazt.stl.WriggleGuideAnimationView;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, 2300})
public class InteractViewContainer extends FrameLayout implements fs {
    public com.byazt.lh.tj cp;
    public com.byazt.udb.oa d;
    public View.OnTouchListener fs;
    public x l;
    public Context n;
    public View q;
    public DynamicBaseWidget qg;
    public int rv;
    public com.byazt.lh.x s;
    public boolean tj;
    public String w;
    public RippleView x;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        super(context);
        this.n = context;
        this.qg = dynamicBaseWidget;
        this.s = xVar;
        x();
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar, com.byazt.lh.tj tjVar, com.byazt.udb.oa oaVar) {
        super(context);
        this.n = context;
        this.qg = dynamicBaseWidget;
        this.s = xVar;
        this.cp = tjVar;
        this.d = oaVar;
        x();
    }

    private void x() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.w = this.s.dg();
        this.rv = this.s.wo();
        this.tj = this.s.pe();
        x xVarN = rv.n(this.n, this.qg, this.s, this.cp, this.d);
        this.l = xVarN;
        if (xVarN != null) {
            this.q = xVarN.s();
            if (this.s.u()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.w, "6")) {
                if (this.s.e() && !TextUtils.isEmpty(this.s.yw())) {
                    this.x = new RippleView(this.n, com.byazt.lh.x.n(this.s.yw()));
                } else {
                    this.x = new RippleView(this.n, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.n);
                frameLayout.addView(this.x, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.byazt.jmk.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.x.qg();
                    }
                });
            }
            if (n(this.w) && com.byazt.twc.q.n()) {
                int color = Color.parseColor("#99000000");
                if (this.s.e() && !TextUtils.isEmpty(this.s.yw())) {
                    try {
                        color = com.byazt.lh.x.n(this.s.yw());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.n);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.l.s());
            n(this.l.s());
            setVisibility(0);
        }
    }

    private boolean n(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.fs instanceof com.byazt.bhm.s) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void n(ViewGroup viewGroup) {
        if (this.q == null) {
            return;
        }
        String str = this.w;
        str.hashCode();
        switch (str) {
            case "0":
                this.fs = new com.byazt.bhm.l(this, this.rv, this.d.bb());
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case "1":
            case "6":
                if (!this.s.e() || TextUtils.isEmpty(this.s.yw())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.fs = new com.byazt.bhm.w(this);
                break;
            case "2":
            case "7":
                setBackgroundColor(Color.parseColor("#80000000"));
                this.fs = new com.byazt.bhm.qg(this, this);
                break;
            case "5":
                if (this.s.e() && !TextUtils.isEmpty(this.s.yw())) {
                    setBackgroundColor(com.byazt.lh.x.n(this.s.yw()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.fs = new com.byazt.bhm.s(this);
                this.q.setTag(2);
                break;
            case "8":
            case "11":
                this.qg.setClipChildren(false);
                this.qg.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.qg.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.fs = new com.byazt.bhm.w(this);
                break;
            case "9":
            case "17":
                this.q.setTag(2);
                break;
            case "10":
                this.fs = new com.byazt.bhm.q(this, this.rv, this.tj);
                break;
            case "12":
                this.fs = new com.byazt.bhm.s(this);
                this.q.setTag(2);
                break;
            case "13":
            case "24":
                if (this.w.equals("24") && com.byazt.twc.q.n()) {
                    this.qg.setClipChildren(false);
                    this.fs = new com.byazt.bhm.w(this);
                    break;
                } else {
                    this.fs = new com.byazt.bhm.l(this, this.rv, this.d.bb());
                    break;
                }
                break;
            case "14":
                this.fs = new com.byazt.bhm.qg(this, this);
                break;
            case "16":
                View view = this.q;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.q).getShakeLayout().setTag(2);
                }
                this.q.setTag(2);
                break;
            case "18":
                View view2 = this.q;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.q).getWriggleLayout().setTag(2);
                }
                this.q.setTag(2);
                break;
            case "20":
                this.fs = new com.byazt.bhm.n(this, this.rv, viewGroup);
                break;
            case "22":
                if (com.byazt.twc.q.n()) {
                    this.fs = new com.byazt.bhm.fs(this, this.tj);
                    break;
                } else {
                    this.fs = new com.byazt.bhm.x(this, this.rv, viewGroup);
                    break;
                }
                break;
            case "23":
                if (com.byazt.twc.q.n()) {
                    this.fs = new com.byazt.bhm.w(this);
                    break;
                }
                break;
            case "25":
                if (com.byazt.twc.q.n()) {
                    this.fs = new com.byazt.bhm.fs(this, this.tj);
                    break;
                }
                break;
            case "29":
                View view3 = this.q;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.q).getShakeView().setTag(2);
                }
                this.fs = new com.byazt.bhm.l(this, this.rv, this.d.bb());
                break;
        }
        View.OnTouchListener onTouchListener = this.fs;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (fs()) {
            this.q.setTag(2);
            setOnClickListener((View.OnClickListener) this.qg.getDynamicClickListener());
        }
    }

    private boolean fs() {
        return (this.s.pe() || TextUtils.equals(GlobalSetting.UNIFIED_INTERSTITIAL_FS_AD, this.w) || TextUtils.equals("16", this.w) || TextUtils.equals("17", this.w) || TextUtils.equals("18", this.w) || TextUtils.equals("20", this.w) || TextUtils.equals("29", this.w) || TextUtils.equals("10", this.w)) ? false : true;
    }

    public void s() {
        x xVar = this.l;
        if (xVar != null) {
            xVar.n();
        }
    }

    public void q() {
        x xVar = this.l;
        if (xVar != null) {
            xVar.qg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            x xVar = this.l;
            if (xVar != null) {
                xVar.qg();
            }
        } catch (Exception e) {
            com.byazt.tk.k.n(e.getMessage());
        }
    }

    public void l() {
        if (this.q != null && TextUtils.equals(this.w, "2")) {
            View view = this.q;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).s();
            }
        }
    }

    public void w() {
        if (this.q != null && TextUtils.equals(this.w, "2")) {
            View view = this.q;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).q();
            }
        }
    }

    @Override // com.byazt.jmk.fs
    public void n() {
        if (TextUtils.equals(this.w, "6")) {
            RippleView rippleView = this.x;
            if (rippleView != null) {
                rippleView.s();
                postDelayed(new Runnable() { // from class: com.byazt.jmk.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.rv();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.w, "20")) {
            postDelayed(new Runnable() { // from class: com.byazt.jmk.InteractViewContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.rv();
                }
            }, 400L);
        } else {
            rv();
        }
    }

    @Override // com.byazt.jmk.fs
    public void qg() {
        if (fs()) {
            setOnClickListener((View.OnClickListener) this.qg.getDynamicClickListener());
            performClick();
            if (this.s.fl()) {
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        if (this.fs != null) {
            setOnClickListener((View.OnClickListener) this.qg.getDynamicClickListener());
            performClick();
            if (this.s.fl()) {
                return;
            }
            setVisibility(8);
        }
    }
}
