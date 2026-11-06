package com.byazt.lz;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 53, 670})
public final class TTViewStub extends View {
    public WeakReference<View> n;
    public n q;
    public com.byazt.lz.n qg;
    public Context s;

    public interface n {
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public TTViewStub(Context context, com.byazt.lz.n nVar) {
        super(context);
        this.s = context;
        this.qg = nVar;
        setVisibility(8);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.n;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            n();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public View n() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            com.byazt.lz.n nVar = this.qg;
            if (nVar != null) {
                View viewQg = nVar.qg(this.s);
                n(viewQg, (ViewGroup) parent);
                this.n = new WeakReference<>(viewQg);
                return viewQg;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    private void n(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void setOnInflateListener(n nVar) {
        this.q = nVar;
    }
}
