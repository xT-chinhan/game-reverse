package com.byazt.ar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gr.cp;
import com.byazt.gr.oa;
import com.byazt.gr.q;
import com.byazt.gr.rv;
import com.byazt.gr.s;
import com.byazt.gr.sz;
import com.byazt.gr.tj;
import com.byazt.gr.w;
import com.byazt.gu.l;
import com.byazt.kg.fs;
import com.byazt.kg.x;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 206, 207})
public class YogaLayout extends ViewGroup implements x, com.byazt.ih.qg {
    public final Map<View, tj> n;
    public fs q;
    public final tj qg;
    public l s;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = new fs(this);
        tj tjVarN = cp.n();
        this.qg = tjVarN;
        this.n = new HashMap();
        tjVarN.n(this);
        tjVarN.n((com.byazt.gr.x) new qg());
        n((n) generateDefaultLayoutParams(), tjVarN, this);
    }

    public tj getYogaNode() {
        return this.qg;
    }

    public tj qg(View view) {
        return this.n.get(view);
    }

    @Override // com.byazt.ih.qg
    public void n(int i) {
        tj tjVar = this.qg;
        if (tjVar != null) {
            n(tjVar, i);
            requestLayout();
        }
    }

    @Override // com.byazt.ih.qg
    public void qg(int i) {
        tj tjVar = this.qg;
        if (tjVar != null) {
            qg(tjVar, i);
            requestLayout();
        }
    }

    @Override // com.byazt.ih.qg
    public void n(View view, int i) {
        tj tjVarQg;
        if (view == null || (tjVarQg = qg(view)) == null) {
            return;
        }
        n(tjVarQg, i);
        view.requestLayout();
    }

    @Override // com.byazt.ih.qg
    public void qg(View view, int i) {
        tj tjVarQg;
        if (view == null || (tjVarQg = qg(view)) == null) {
            return;
        }
        qg(tjVarQg, i);
        view.requestLayout();
    }

    @Override // com.byazt.ih.qg
    public void n(View view) {
        if (view == null) {
            return;
        }
        s(view);
        view.requestLayout();
    }

    private void n(tj tjVar, int i) {
        if (i == -1) {
            tjVar.l(100.0f);
        } else if (i == -2) {
            tjVar.l();
        } else {
            tjVar.q(i);
        }
    }

    private void qg(tj tjVar, int i) {
        if (i == -1) {
            tjVar.x(100.0f);
        } else if (i == -2) {
            tjVar.w();
        } else {
            tjVar.w(i);
        }
    }

    @Override // com.byazt.ih.qg
    public void s(View view, int i) {
        q(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        tj tjVarN;
        this.qg.n((com.byazt.gr.x) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.n(this);
            tj yogaNode = virtualYogaLayout.getYogaNode();
            tj tjVar = this.qg;
            tjVar.n(yogaNode, tjVar.n());
            return;
        }
        super.addView(view, i, layoutParams);
        if (this.n.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            tjVarN = ((YogaLayout) view).getYogaNode();
        } else {
            if (this.n.containsKey(view)) {
                tjVarN = this.n.get(view);
            } else {
                tjVarN = cp.n();
            }
            tjVarN.n(view);
            tjVarN.n((com.byazt.gr.x) new qg());
        }
        n((n) view.getLayoutParams(), tjVarN, view);
        this.n.put(view, tjVarN);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.qg.n()));
        } else {
            tj tjVar2 = this.qg;
            tjVar2.n(tjVarN, tjVar2.n());
        }
    }

    public void q(View view, int i) {
        int iN;
        view.setVisibility(i);
        try {
            tj tjVar = this.n.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (iN = this.qg.n(tjVar)) == -1) {
                    return;
                }
                this.qg.qg(iN);
                view.setTag(151060224, Integer.valueOf(iN));
                n(this.qg);
                return;
            }
            if (tag == null || this.qg.n(tjVar) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.qg.n()) {
                this.qg.n(this.n.get(view), iIntValue);
            } else {
                this.qg.n(this.n.get(view), this.qg.n());
            }
            n(this.qg);
        } catch (Throwable unused) {
        }
    }

    private void n(tj tjVar) {
        if (tjVar.qg() != null) {
            n(tjVar.qg());
        } else {
            tjVar.n(Float.NaN, Float.NaN);
        }
    }

    public void n(View view, tj tjVar) {
        this.n.put(view, tjVar);
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        n(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        n(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        n(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            n(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            n(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            n(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            n(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    public void s(View view) {
        if (this.n.containsKey(view)) {
            this.n.get(view).s();
            return;
        }
        int iN = this.qg.n();
        for (int i = 0; i < iN; i++) {
            tj tjVarN = this.qg.n(i);
            if (tjVarN.cp() instanceof YogaLayout) {
                ((YogaLayout) tjVarN.cp()).s(view);
            }
        }
        invalidate();
    }

    private void n(View view, boolean z) {
        try {
            tj tjVar = this.n.get(view);
            if (tjVar == null) {
                return;
            }
            tj tjVarQg = tjVar.qg();
            for (int i = 0; i < tjVarQg.n(); i++) {
                if (tjVarQg.n(i).equals(tjVar)) {
                    tjVarQg.qg(i);
                    break;
                }
            }
            tjVar.n((Object) null);
            this.n.remove(view);
            if (z) {
                this.qg.n(Float.NaN, Float.NaN);
            }
        } catch (Throwable unused) {
        }
    }

    private void n(tj tjVar, float f, float f2) {
        View view = (View) tjVar.cp();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(tjVar.x() + f);
            int iRound2 = Math.round(tjVar.fs() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(tjVar.rv()), C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(Math.round(tjVar.tj()), C.ENCODING_PCM_32BIT));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iN = tjVar.n();
        for (int i = 0; i < iN; i++) {
            if (equals(view)) {
                n(tjVar.n(i), f, f2);
            } else if (!(view instanceof YogaLayout)) {
                n(tjVar.n(i), tjVar.x() + f, tjVar.fs() + f2);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        l lVar = this.s;
        if (lVar != null) {
            lVar.n(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        l lVar = this.s;
        if (lVar != null) {
            lVar.qg(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        l lVar = this.s;
        if (lVar != null) {
            lVar.q();
        }
        if (!(getParent() instanceof YogaLayout)) {
            n(View.MeasureSpec.makeMeasureSpec(i3 - i, C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(i4 - i2, C.ENCODING_PCM_32BIT));
        }
        n(this.qg, 0.0f, 0.0f);
        l lVar2 = this.s;
        if (lVar2 != null) {
            lVar2.n(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            n(i, i2);
        }
        l lVar = this.s;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            setMeasuredDimension(iArrN[0], iArrN[1]);
        } else {
            setMeasuredDimension(Math.round(this.qg.rv()), Math.round(this.qg.tj()));
        }
        l lVar2 = this.s;
        if (lVar2 != null) {
            lVar2.s();
        }
    }

    private void n(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.qg.w(size2);
        }
        if (mode == 1073741824) {
            this.qg.q(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.qg.cp(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.qg.tj(size);
        }
        this.qg.n(Float.NaN, Float.NaN);
    }

    public static void n(n nVar, tj tjVar, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            tjVar.n(s.LTR);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                tjVar.qg(q.LEFT, rect.left);
                tjVar.qg(q.TOP, rect.top);
                tjVar.qg(q.RIGHT, rect.right);
                tjVar.qg(q.BOTTOM, rect.bottom);
            }
        }
        for (int i = 0; i < nVar.n.size(); i++) {
            int iKeyAt = nVar.n.keyAt(i);
            float fFloatValue = nVar.n.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                tjVar.s(com.byazt.gr.n.n(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                tjVar.n(com.byazt.gr.n.n(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                tjVar.qg(com.byazt.gr.n.n(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                tjVar.d(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    tjVar.q();
                } else {
                    tjVar.s(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                tjVar.n(com.byazt.gr.l.n(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                tjVar.n(fFloatValue);
            } else if (iKeyAt == 7) {
                tjVar.qg(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    tjVar.x(100.0f);
                } else if (fFloatValue == -2.0f) {
                    tjVar.w();
                } else {
                    tjVar.w(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                tjVar.n(q.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                tjVar.n(w.n(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                tjVar.n(q.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                tjVar.n(q.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                tjVar.n(q.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                tjVar.rv(fFloatValue);
            } else if (iKeyAt == 27) {
                tjVar.fs(fFloatValue);
            } else if (iKeyAt == 22) {
                tjVar.qg(q.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                tjVar.qg(q.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                tjVar.qg(q.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                tjVar.qg(q.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                tjVar.s(q.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                tjVar.s(q.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                tjVar.s(q.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                tjVar.s(q.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                tjVar.n(oa.n(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    tjVar.l(100.0f);
                } else if (fFloatValue == -2.0f) {
                    tjVar.l();
                } else {
                    tjVar.q(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                tjVar.n(sz.n(Math.round(fFloatValue)));
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new n(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new n(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.s;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.s;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l lVar = this.s;
        if (lVar != null) {
            lVar.n(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        l lVar = this.s;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }

    public void n(com.byazt.ih.s sVar) {
        this.s = sVar;
    }

    public void setBorderRadius(float f) {
        this.q.n(f);
    }

    public float getBorderRadius() {
        return this.q.n();
    }

    public void setRipple(float f) {
        fs fsVar = this.q;
        if (fsVar != null) {
            fsVar.qg(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getRipple() {
        return this.q.getRipple();
    }

    public void setShine(float f) {
        fs fsVar = this.q;
        if (fsVar != null) {
            fsVar.s(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getShine() {
        return this.q.getShine();
    }

    public void setStretch(float f) {
        fs fsVar = this.q;
        if (fsVar != null) {
            fsVar.q(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getStretch() {
        return this.q.getStretch();
    }

    public void setRubIn(float f) {
        fs fsVar = this.q;
        if (fsVar != null) {
            fsVar.l(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getRubIn() {
        return this.q.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.q.n(i);
    }

    @com.byazt.cp.n(n = {0, 1, 206, 2569})
    public static class n extends ViewGroup.LayoutParams {
        public float cd;
        public float cp;
        public float cy;
        public float d;
        public float fs;
        public float hd;
        public float k;
        public float l;
        public SparseArray<Float> n;
        public float oa;
        public float q;
        public SparseArray<String> qg;
        public float rv;
        public float s;
        public float sz;
        public float tj;
        public float um;
        public float w;
        public float x;

        public n(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof n) {
                n nVar = (n) layoutParams;
                this.n = nVar.n.clone();
                this.qg = nVar.qg.clone();
                return;
            }
            this.n = new SparseArray<>();
            this.qg = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.n.put(15, Float.valueOf(this.width));
            }
            if (layoutParams.height >= 0) {
                this.n.put(16, Float.valueOf(this.height));
            }
        }

        public n(int i, int i2) {
            super(i, i2);
            this.n = new SparseArray<>();
            this.qg = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.n.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.n.put(16, Float.valueOf(i2));
            }
        }

        public void n(float f) {
            this.x = f;
            this.n.put(5, Float.valueOf(f));
        }

        public void qg(float f) {
            this.fs = f;
            this.n.put(6, Float.valueOf(f));
        }

        public void s(float f) {
            this.rv = f;
            this.n.put(7, Float.valueOf(f));
        }

        public void q(float f) {
            this.tj = f;
            this.n.put(8, Float.valueOf(f));
        }

        public void l(float f) {
            this.cp = f;
            this.n.put(9, Float.valueOf(f));
        }

        public void w(float f) {
            this.d = f;
            this.n.put(14, Float.valueOf(f));
        }

        public void x(float f) {
            this.oa = f;
            this.n.put(10, Float.valueOf(f));
        }

        public void fs(float f) {
            this.sz = f;
            this.n.put(11, Float.valueOf(f));
        }

        public void rv(float f) {
            this.k = f;
            this.n.put(12, Float.valueOf(f));
        }

        public void tj(float f) {
            this.cy = f;
            this.n.put(13, Float.valueOf(f));
        }

        public void cp(float f) {
            this.s = f;
            this.n.put(17, Float.valueOf(f));
        }

        public void d(float f) {
            this.q = f;
            this.n.put(18, Float.valueOf(f));
        }

        public void oa(float f) {
            this.l = f;
            this.n.put(19, Float.valueOf(f));
        }

        public void sz(float f) {
            this.w = f;
            this.n.put(20, Float.valueOf(f));
        }

        public void k(float f) {
            this.hd = f;
            this.n.put(25, Float.valueOf(f));
        }

        public void cy(float f) {
            this.cd = f;
            this.n.put(27, Float.valueOf(f));
        }

        public void hd(float f) {
            this.um = f;
            this.n.put(28, Float.valueOf(f));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 206, 2272})
    public static class qg implements com.byazt.gr.x {
        @Override // com.byazt.gr.x
        public long n(tj tjVar, float f, com.byazt.gr.fs fsVar, float f2, com.byazt.gr.fs fsVar2) {
            View view = (View) tjVar.cp();
            if (view == null || (view instanceof YogaLayout)) {
                return rv.n(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, n(fsVar)), View.MeasureSpec.makeMeasureSpec((int) f2, n(fsVar2)));
            return rv.n(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int n(com.byazt.gr.fs fsVar) {
            if (fsVar == com.byazt.gr.fs.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            if (fsVar == com.byazt.gr.fs.EXACTLY) {
                return C.ENCODING_PCM_32BIT;
            }
            return 0;
        }
    }
}
