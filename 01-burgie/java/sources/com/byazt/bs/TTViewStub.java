package com.byazt.bs;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 446, 1150})
public final class TTViewStub extends View {
    public Context hn;
    public com.byazt.bs.pr hw;
    public WeakReference<View> pr;
    public pr x;

    public interface pr {
    }

    public TTViewStub(Context context, com.byazt.bs.pr prVar) {
        super(context);
        this.hn = context;
        this.hw = prVar;
        setVisibility(8);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.pr;
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
            pr();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public View pr() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            com.byazt.bs.pr prVar = this.hw;
            if (prVar != null) {
                View viewHw = prVar.hw(this.hn);
                pr(viewHw, (ViewGroup) parent);
                this.pr = new WeakReference<>(viewHw);
                return viewHw;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    private void pr(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void setOnInflateListener(pr prVar) {
        this.x = prVar;
    }
}
