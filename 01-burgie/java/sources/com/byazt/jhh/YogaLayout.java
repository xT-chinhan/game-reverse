package com.byazt.jhh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.fty.aj;
import com.byazt.fty.g;
import com.byazt.fty.hn;
import com.byazt.fty.m;
import com.byazt.fty.uc;
import com.byazt.fty.vk;
import com.byazt.fty.w;
import com.byazt.fty.x;
import com.byazt.iza.fw;
import com.byazt.iza.zo;
import com.byazt.llk.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS})
public class YogaLayout extends ViewGroup implements com.byazt.ik.hw, fw {
    public c hn;
    public final vk hw;
    public final Map<View, vk> pr;
    public zo x;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = new zo(this);
        vk vkVarPr = w.pr();
        this.hw = vkVarPr;
        this.pr = new HashMap();
        vkVarPr.pr(this);
        vkVarPr.pr((com.byazt.fty.fw) new hw());
        pr((pr) generateDefaultLayoutParams(), vkVarPr, this);
    }

    public vk getYogaNode() {
        return this.hw;
    }

    public vk pr(View view) {
        return this.pr.get(view);
    }

    @Override // com.byazt.ik.hw
    public void pr(int i) {
        vk vkVar = this.hw;
        if (vkVar != null) {
            pr(vkVar, i);
            requestLayout();
        }
    }

    @Override // com.byazt.ik.hw
    public void hw(int i) {
        vk vkVar = this.hw;
        if (vkVar != null) {
            hw(vkVar, i);
            requestLayout();
        }
    }

    @Override // com.byazt.ik.hw
    public void pr(View view, int i) {
        vk vkVarPr;
        if (view == null || (vkVarPr = pr(view)) == null) {
            return;
        }
        pr(vkVarPr, i);
        view.requestLayout();
    }

    @Override // com.byazt.ik.hw
    public void hw(View view, int i) {
        vk vkVarPr;
        if (view == null || (vkVarPr = pr(view)) == null) {
            return;
        }
        hw(vkVarPr, i);
        view.requestLayout();
    }

    private void pr(vk vkVar, int i) {
        if (i == -1) {
            vkVar.c(100.0f);
        } else if (i == -2) {
            vkVar.x();
        } else {
            vkVar.x(i);
        }
    }

    private void hw(vk vkVar, int i) {
        if (i == -1) {
            vkVar.fw(100.0f);
        } else if (i == -2) {
            vkVar.c();
        } else {
            vkVar.uc(i);
        }
    }

    @Override // com.byazt.ik.hw
    public void hn(View view, int i) {
        x(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        vk vkVarPr;
        this.hw.pr((com.byazt.fty.fw) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.pr(this);
            vk yogaNode = virtualYogaLayout.getYogaNode();
            vk vkVar = this.hw;
            vkVar.pr(yogaNode, vkVar.pr());
            return;
        }
        super.addView(view, i, layoutParams);
        if (this.pr.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            vkVarPr = ((YogaLayout) view).getYogaNode();
        } else {
            if (this.pr.containsKey(view)) {
                vkVarPr = this.pr.get(view);
            } else {
                vkVarPr = w.pr();
            }
            vkVarPr.pr(view);
            vkVarPr.pr((com.byazt.fty.fw) new hw());
        }
        pr((pr) view.getLayoutParams(), vkVarPr, view);
        this.pr.put(view, vkVarPr);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.hw.pr()));
        } else {
            vk vkVar2 = this.hw;
            vkVar2.pr(vkVarPr, vkVar2.pr());
        }
    }

    public void x(View view, int i) {
        int iPr;
        view.setVisibility(i);
        try {
            vk vkVar = this.pr.get(view);
            Object tag = view.getTag(151060224);
            if (i == 0) {
                if (tag != null && this.hw.pr(vkVar) == -1) {
                    int iIntValue = ((Integer) tag).intValue();
                    if (iIntValue < this.hw.pr()) {
                        this.hw.pr(this.pr.get(view), iIntValue);
                    } else {
                        this.hw.pr(this.pr.get(view), this.hw.pr());
                    }
                    pr(this.hw);
                    return;
                }
                return;
            }
            if (i == 8 && (iPr = this.hw.pr(vkVar)) != -1) {
                this.hw.hw(iPr);
                view.setTag(151060224, Integer.valueOf(iPr));
                pr(this.hw);
            }
        } catch (Throwable th) {
        }
    }

    private void pr(vk vkVar) {
        if (vkVar.hw() != null) {
            pr(vkVar.hw());
        } else {
            vkVar.pr(Float.NaN, Float.NaN);
        }
    }

    public void pr(View view, vk vkVar) {
        this.pr.put(view, vkVar);
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        pr(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        pr(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        pr(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            pr(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            pr(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            pr(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            pr(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    private void pr(View view, boolean z) {
        try {
            vk vkVar = this.pr.get(view);
            if (vkVar == null) {
                return;
            }
            vk vkVarHw = vkVar.hw();
            for (int i = 0; i < vkVarHw.pr(); i++) {
                if (vkVarHw.pr(i).equals(vkVar)) {
                    vkVarHw.hw(i);
                    break;
                }
            }
            vkVar.pr((Object) null);
            this.pr.remove(view);
            if (z) {
                this.hw.pr(Float.NaN, Float.NaN);
            }
        } catch (Throwable th) {
        }
    }

    private void pr(vk vkVar, float f, float f2) {
        View view = (View) vkVar.vk();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(vkVar.uc() + f);
            int iRound2 = Math.round(vkVar.fw() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(vkVar.zo()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(vkVar.aj()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iPr = vkVar.pr();
        for (int i = 0; i < iPr; i++) {
            if (equals(view)) {
                pr(vkVar.pr(i), f, f2);
            } else if (!(view instanceof YogaLayout)) {
                pr(vkVar.pr(i), vkVar.uc() + f, vkVar.fw() + f2);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c cVar = this.hn;
        if (cVar != null) {
            cVar.pr(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        c cVar = this.hn;
        if (cVar != null) {
            cVar.hw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cVar = this.hn;
        if (cVar != null) {
            cVar.x();
        }
        if (!(getParent() instanceof YogaLayout)) {
            pr(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        pr(this.hw, 0.0f, 0.0f);
        c cVar2 = this.hn;
        if (cVar2 != null) {
            cVar2.pr(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            pr(i, i2);
        }
        c cVar = this.hn;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            setMeasuredDimension(iArrPr[0], iArrPr[1]);
        } else {
            setMeasuredDimension(Math.round(this.hw.zo()), Math.round(this.hw.aj()));
        }
        c cVar2 = this.hn;
        if (cVar2 != null) {
            cVar2.hn();
        }
    }

    private void pr(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.hw.uc(size2);
        }
        if (mode == 1073741824) {
            this.hw.x(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.hw.w(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.hw.vk(size);
        }
        this.hw.pr(Float.NaN, Float.NaN);
    }

    public static void pr(pr prVar, vk vkVar, View view) {
        if (Build.VERSION.SDK_INT >= 17 && view.getResources().getConfiguration().getLayoutDirection() == 1) {
            vkVar.pr(hn.LTR);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                vkVar.hw(x.LEFT, rect.left);
                vkVar.hw(x.TOP, rect.top);
                vkVar.hw(x.RIGHT, rect.right);
                vkVar.hw(x.BOTTOM, rect.bottom);
            }
        }
        for (int i = 0; i < prVar.pr.size(); i++) {
            int iKeyAt = prVar.pr.keyAt(i);
            float fFloatValue = prVar.pr.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                vkVar.hn(com.byazt.fty.pr.pr(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                vkVar.pr(com.byazt.fty.pr.pr(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                vkVar.hw(com.byazt.fty.pr.pr(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                vkVar.k(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    vkVar.hn();
                } else {
                    vkVar.hn(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                vkVar.pr(com.byazt.fty.c.pr(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                vkVar.pr(fFloatValue);
            } else if (iKeyAt == 7) {
                vkVar.hw(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    vkVar.fw(100.0f);
                } else if (fFloatValue == -2.0f) {
                    vkVar.c();
                } else {
                    vkVar.uc(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                vkVar.pr(x.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                vkVar.pr(uc.pr(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                vkVar.pr(x.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                vkVar.pr(x.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                vkVar.pr(x.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                vkVar.aj(fFloatValue);
            } else if (iKeyAt == 27) {
                vkVar.zo(fFloatValue);
            } else if (iKeyAt == 22) {
                vkVar.hw(x.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                vkVar.hw(x.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                vkVar.hw(x.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                vkVar.hw(x.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                vkVar.hn(x.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                vkVar.hn(x.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                vkVar.hn(x.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                vkVar.hn(x.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                vkVar.pr(m.pr(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    vkVar.c(100.0f);
                } else if (fFloatValue == -2.0f) {
                    vkVar.x();
                } else {
                    vkVar.x(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                vkVar.pr(g.pr(Math.round(fFloatValue)));
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new pr(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new pr(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof pr;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.hn;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.hn;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c cVar = this.hn;
        if (cVar != null) {
            cVar.pr(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c cVar = this.hn;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i4);
        }
    }

    public void pr(com.byazt.ik.hn hnVar) {
        this.hn = hnVar;
    }

    public void setBorderRadius(float f) {
        this.x.pr(f);
    }

    public float getBorderRadius() {
        return this.x.pr();
    }

    public void setRipple(float f) {
        zo zoVar = this.x;
        if (zoVar != null) {
            zoVar.hw(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getRipple() {
        return this.x.getRipple();
    }

    public void setShine(float f) {
        zo zoVar = this.x;
        if (zoVar != null) {
            zoVar.hn(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getShine() {
        return this.x.getShine();
    }

    public void setStretch(float f) {
        zo zoVar = this.x;
        if (zoVar != null) {
            zoVar.x(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getStretch() {
        return this.x.getStretch();
    }

    public void setRubIn(float f) {
        zo zoVar = this.x;
        if (zoVar != null) {
            zoVar.c(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getRubIn() {
        return this.x.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.x.pr(i);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 2052})
    public static class pr extends ViewGroup.LayoutParams {
        public float aj;
        public float c;
        public float fw;
        public float g;
        public float hn;
        public float ho;
        public SparseArray<String> hw;
        public float k;
        public float lb;
        public float m;
        public float nt;
        public SparseArray<Float> pr;
        public float qa;
        public float uc;
        public float vk;
        public float w;
        public float x;
        public float yb;
        public float zo;

        public pr(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof pr) {
                pr prVar = (pr) layoutParams;
                this.pr = prVar.pr.clone();
                this.hw = prVar.hw.clone();
                return;
            }
            this.pr = new SparseArray<>();
            this.hw = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.pr.put(15, Float.valueOf(this.width));
            }
            if (layoutParams.height >= 0) {
                this.pr.put(16, Float.valueOf(this.height));
            }
        }

        public pr(int i, int i2) {
            super(i, i2);
            this.pr = new SparseArray<>();
            this.hw = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.pr.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.pr.put(16, Float.valueOf(i2));
            }
        }

        public void pr(float f) {
            this.fw = f;
            this.pr.put(5, Float.valueOf(f));
        }

        public void hw(float f) {
            this.zo = f;
            this.pr.put(6, Float.valueOf(f));
        }

        public void hn(float f) {
            this.aj = f;
            this.pr.put(7, Float.valueOf(f));
        }

        public void x(float f) {
            this.vk = f;
            this.pr.put(8, Float.valueOf(f));
        }

        public void c(float f) {
            this.w = f;
            this.pr.put(9, Float.valueOf(f));
        }

        public void uc(float f) {
            this.k = f;
            this.pr.put(14, Float.valueOf(f));
        }

        public void fw(float f) {
            this.m = f;
            this.pr.put(10, Float.valueOf(f));
        }

        public void zo(float f) {
            this.g = f;
            this.pr.put(11, Float.valueOf(f));
        }

        public void aj(float f) {
            this.ho = f;
            this.pr.put(12, Float.valueOf(f));
        }

        public void vk(float f) {
            this.nt = f;
            this.pr.put(13, Float.valueOf(f));
        }

        public void w(float f) {
            this.hn = f;
            this.pr.put(17, Float.valueOf(f));
        }

        public void k(float f) {
            this.x = f;
            this.pr.put(18, Float.valueOf(f));
        }

        public void m(float f) {
            this.c = f;
            this.pr.put(19, Float.valueOf(f));
        }

        public void g(float f) {
            this.uc = f;
            this.pr.put(20, Float.valueOf(f));
        }

        public void ho(float f) {
            this.yb = f;
            this.pr.put(25, Float.valueOf(f));
        }

        public void nt(float f) {
            this.lb = f;
            this.pr.put(27, Float.valueOf(f));
        }

        public void yb(float f) {
            this.qa = f;
            this.pr.put(28, Float.valueOf(f));
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 2078})
    public static class hw implements com.byazt.fty.fw {
        @Override // com.byazt.fty.fw
        public long pr(vk vkVar, float f, com.byazt.fty.zo zoVar, float f2, com.byazt.fty.zo zoVar2) {
            View view = (View) vkVar.vk();
            if (view == null || (view instanceof YogaLayout)) {
                return aj.pr(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, pr(zoVar)), View.MeasureSpec.makeMeasureSpec((int) f2, pr(zoVar2)));
            return aj.pr(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int pr(com.byazt.fty.zo zoVar) {
            if (zoVar == com.byazt.fty.zo.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            if (zoVar == com.byazt.fty.zo.EXACTLY) {
                return 1073741824;
            }
            return 0;
        }
    }
}
