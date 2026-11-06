package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.ah;
import com.bytedance.adsdk.ugeno.ms.c;
import com.bytedance.adsdk.ugeno.ms.ka;
import com.bytedance.adsdk.ugeno.yoga.ab;
import com.bytedance.adsdk.ugeno.yoga.ch;
import com.bytedance.adsdk.ugeno.yoga.d;
import com.bytedance.adsdk.ugeno.yoga.hi;
import com.bytedance.adsdk.ugeno.yoga.ny;
import com.bytedance.adsdk.ugeno.yoga.u;
import com.bytedance.adsdk.ugeno.yoga.x;
import com.bytedance.adsdk.ugeno.yoga.zb;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class YogaLayout extends ViewGroup implements ka, com.bytedance.adsdk.ugeno.xr.xr {
    private ah ah;
    private c d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<View, ch> f449ms;
    private final ch xr;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new c(this);
        ch chVarMs = hi.ms();
        this.xr = chVarMs;
        this.f449ms = new HashMap();
        chVarMs.ms(this);
        chVarMs.ms((ab) new xr());
        ms((ms) generateDefaultLayoutParams(), chVarMs, this);
    }

    public ch getYogaNode() {
        return this.xr;
    }

    public ch ms(View view) {
        return this.f449ms.get(view);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.xr
    public void ms(int i) {
        ch chVar = this.xr;
        if (chVar != null) {
            ms(chVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.xr
    public void xr(int i) {
        ch chVar = this.xr;
        if (chVar != null) {
            xr(chVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.xr
    public void ms(View view, int i) {
        ch chVarMs;
        if (view == null || (chVarMs = ms(view)) == null) {
            return;
        }
        ms(chVarMs, i);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.xr
    public void xr(View view, int i) {
        ch chVarMs;
        if (view == null || (chVarMs = ms(view)) == null) {
            return;
        }
        xr(chVarMs, i);
        view.requestLayout();
    }

    private void ms(ch chVar, int i) {
        if (i == -1) {
            chVar.ka(100.0f);
        } else if (i == -2) {
            chVar.d();
        } else {
            chVar.d(i);
        }
    }

    private void xr(ch chVar, int i) {
        if (i == -1) {
            chVar.ab(100.0f);
        } else if (i == -2) {
            chVar.ka();
        } else {
            chVar.c(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.xr
    public void ah(View view, int i) {
        d(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ch chVarMs;
        this.xr.ms((ab) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.ms(this);
            ch yogaNode = virtualYogaLayout.getYogaNode();
            ch chVar = this.xr;
            chVar.ms(yogaNode, chVar.ms());
            return;
        }
        super.addView(view, i, layoutParams);
        if (this.f449ms.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            chVarMs = ((YogaLayout) view).getYogaNode();
        } else {
            if (this.f449ms.containsKey(view)) {
                chVarMs = this.f449ms.get(view);
            } else {
                chVarMs = hi.ms();
            }
            chVarMs.ms(view);
            chVarMs.ms((ab) new xr());
        }
        ms((ms) view.getLayoutParams(), chVarMs, view);
        this.f449ms.put(view, chVarMs);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.xr.ms()));
        } else {
            ch chVar2 = this.xr;
            chVar2.ms(chVarMs, chVar2.ms());
        }
    }

    public void d(View view, int i) {
        int iMs;
        view.setVisibility(i);
        try {
            ch chVar = this.f449ms.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (iMs = this.xr.ms(chVar)) == -1) {
                    return;
                }
                this.xr.xr(iMs);
                view.setTag(151060224, Integer.valueOf(iMs));
                ms(this.xr);
                return;
            }
            if (tag == null || this.xr.ms(chVar) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.xr.ms()) {
                this.xr.ms(this.f449ms.get(view), iIntValue);
            } else {
                this.xr.ms(this.f449ms.get(view), this.xr.ms());
            }
            ms(this.xr);
        } catch (Throwable unused) {
        }
    }

    private void ms(ch chVar) {
        if (chVar.xr() != null) {
            ms(chVar.xr());
        } else {
            chVar.ms(Float.NaN, Float.NaN);
        }
    }

    public void ms(View view, ch chVar) {
        this.f449ms.put(view, chVar);
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        ms(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        ms(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        ms(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            ms(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            ms(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ms(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ms(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    private void ms(View view, boolean z) {
        ch chVar = this.f449ms.get(view);
        if (chVar == null) {
            return;
        }
        ch chVarXr = chVar.xr();
        for (int i = 0; i < chVarXr.ms(); i++) {
            if (chVarXr.ms(i).equals(chVar)) {
                chVarXr.xr(i);
                break;
            }
        }
        chVar.ms((Object) null);
        this.f449ms.remove(view);
        if (z) {
            this.xr.ms(Float.NaN, Float.NaN);
        }
    }

    private void ms(ch chVar, float f, float f2) {
        View view = (View) chVar.ch();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(chVar.c() + f);
            int iRound2 = Math.round(chVar.ab() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(chVar.x()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(chVar.ny()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iMs = chVar.ms();
        for (int i = 0; i < iMs; i++) {
            if (equals(view)) {
                ms(chVar.ms(i), f, f2);
            } else if (!(view instanceof YogaLayout)) {
                ms(chVar.ms(i), chVar.c() + f, chVar.ab() + f2);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ah ahVar = this.ah;
        if (ahVar != null) {
            ahVar.ms(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ah ahVar = this.ah;
        if (ahVar != null) {
            ahVar.d();
        }
        if (!(getParent() instanceof YogaLayout)) {
            ms(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        ms(this.xr, 0.0f, 0.0f);
        ah ahVar2 = this.ah;
        if (ahVar2 != null) {
            ahVar2.ms(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            ms(i, i2);
        }
        ah ahVar = this.ah;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            setMeasuredDimension(iArrMs[0], iArrMs[1]);
        } else {
            setMeasuredDimension(Math.round(this.xr.x()), Math.round(this.xr.ny()));
        }
        ah ahVar2 = this.ah;
        if (ahVar2 != null) {
            ahVar2.ah();
        }
    }

    private void ms(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.xr.c(size2);
        }
        if (mode == 1073741824) {
            this.xr.d(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.xr.hi(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.xr.ch(size);
        }
        this.xr.ms(Float.NaN, Float.NaN);
    }

    protected static void ms(ms msVar, ch chVar, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            chVar.ms(com.bytedance.adsdk.ugeno.yoga.ah.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                chVar.xr(d.LEFT, rect.left);
                chVar.xr(d.TOP, rect.top);
                chVar.xr(d.RIGHT, rect.right);
                chVar.xr(d.BOTTOM, rect.bottom);
            }
        }
        for (int i = 0; i < msVar.f450ms.size(); i++) {
            int iKeyAt = msVar.f450ms.keyAt(i);
            float fFloatValue = msVar.f450ms.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                chVar.ah(com.bytedance.adsdk.ugeno.yoga.ms.ms(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                chVar.ms(com.bytedance.adsdk.ugeno.yoga.ms.ms(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                chVar.xr(com.bytedance.adsdk.ugeno.yoga.ms.ms(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                chVar.sl(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    chVar.ah();
                } else {
                    chVar.ah(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                chVar.ms(com.bytedance.adsdk.ugeno.yoga.ka.ms(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                chVar.ms(fFloatValue);
            } else if (iKeyAt == 7) {
                chVar.xr(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    chVar.ab(100.0f);
                } else if (fFloatValue == -2.0f) {
                    chVar.ka();
                } else {
                    chVar.c(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                chVar.ms(d.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                chVar.ms(com.bytedance.adsdk.ugeno.yoga.c.ms(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                chVar.ms(d.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                chVar.ms(d.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                chVar.ms(d.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                chVar.ny(fFloatValue);
            } else if (iKeyAt == 27) {
                chVar.x(fFloatValue);
            } else if (iKeyAt == 22) {
                chVar.xr(d.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                chVar.xr(d.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                chVar.xr(d.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                chVar.xr(d.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                chVar.ah(d.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                chVar.ah(d.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                chVar.ah(d.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                chVar.ah(d.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                chVar.ms(zb.ms(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    chVar.ka(100.0f);
                } else if (fFloatValue == -2.0f) {
                    chVar.d();
                } else {
                    chVar.d(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                chVar.ms(u.ms(Math.round(fFloatValue)));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ms(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ms(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ms;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.ah;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.ah;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.ah;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ah ahVar = this.ah;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i4);
        }
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.ah = ahVar;
    }

    public void setBorderRadius(float f) {
        this.d.ms(f);
    }

    public float getBorderRadius() {
        return this.d.ms();
    }

    public void setRipple(float f) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.xr(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getRipple() {
        return this.d.getRipple();
    }

    public void setShine(float f) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.ah(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getShine() {
        return this.d.getShine();
    }

    public void setStretch(float f) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.d(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getStretch() {
        return this.d.getStretch();
    }

    public void setRubIn(float f) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.ka(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getRubIn() {
        return this.d.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.d.ms(i);
    }

    public static class ms extends ViewGroup.LayoutParams {
        private float ab;
        private float ah;
        private float ao;
        private float c;
        private float ch;
        private float d;
        private float h;
        private float hi;
        private float ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        SparseArray<Float> f450ms;
        private float ny;
        private float qv;
        private float sl;
        private float u;
        private float ub;
        private float x;
        SparseArray<String> xr;
        private float y;
        private float zb;

        public ms(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof ms) {
                ms msVar = (ms) layoutParams;
                this.f450ms = msVar.f450ms.clone();
                this.xr = msVar.xr.clone();
                return;
            }
            this.f450ms = new SparseArray<>();
            this.xr = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.f450ms.put(15, Float.valueOf(this.width));
            }
            if (layoutParams.height >= 0) {
                this.f450ms.put(16, Float.valueOf(this.height));
            }
        }

        public ms(int i, int i2) {
            super(i, i2);
            this.f450ms = new SparseArray<>();
            this.xr = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.f450ms.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.f450ms.put(16, Float.valueOf(i2));
            }
        }

        public void ms(float f) {
            this.ab = f;
            this.f450ms.put(5, Float.valueOf(f));
        }

        public void xr(float f) {
            this.x = f;
            this.f450ms.put(6, Float.valueOf(f));
        }

        public void ah(float f) {
            this.ny = f;
            this.f450ms.put(7, Float.valueOf(f));
        }

        public void d(float f) {
            this.ch = f;
            this.f450ms.put(8, Float.valueOf(f));
        }

        public void ka(float f) {
            this.hi = f;
            this.f450ms.put(9, Float.valueOf(f));
        }

        public void c(float f) {
            this.sl = f;
            this.f450ms.put(14, Float.valueOf(f));
        }

        public void ab(float f) {
            this.zb = f;
            this.f450ms.put(10, Float.valueOf(f));
        }

        public void x(float f) {
            this.u = f;
            this.f450ms.put(11, Float.valueOf(f));
        }

        public void ny(float f) {
            this.ub = f;
            this.f450ms.put(12, Float.valueOf(f));
        }

        public void ch(float f) {
            this.ao = f;
            this.f450ms.put(13, Float.valueOf(f));
        }

        public void hi(float f) {
            this.ah = f;
            this.f450ms.put(17, Float.valueOf(f));
        }

        public void sl(float f) {
            this.d = f;
            this.f450ms.put(18, Float.valueOf(f));
        }

        public void zb(float f) {
            this.ka = f;
            this.f450ms.put(19, Float.valueOf(f));
        }

        public void u(float f) {
            this.c = f;
            this.f450ms.put(20, Float.valueOf(f));
        }

        public void ub(float f) {
            this.h = f;
            this.f450ms.put(25, Float.valueOf(f));
        }

        public void ao(float f) {
            this.qv = f;
            this.f450ms.put(27, Float.valueOf(f));
        }

        public void h(float f) {
            this.y = f;
            this.f450ms.put(28, Float.valueOf(f));
        }
    }

    public static class xr implements ab {
        @Override // com.bytedance.adsdk.ugeno.yoga.ab
        public long ms(ch chVar, float f, x xVar, float f2, x xVar2) {
            View view = (View) chVar.ch();
            if (view == null || (view instanceof YogaLayout)) {
                return ny.ms(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, ms(xVar)), View.MeasureSpec.makeMeasureSpec((int) f2, ms(xVar2)));
            return ny.ms(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int ms(x xVar) {
            if (xVar == x.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return xVar == x.EXACTLY ? 1073741824 : 0;
        }
    }
}
