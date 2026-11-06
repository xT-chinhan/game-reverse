package com.byazt.ou;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.byazt.gct.bb;
import com.byazt.gct.pk;
import com.byazt.udb.sz;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 849, 13})
public class w extends n {
    public ViewGroup fs;
    public FrameLayout w;
    public boolean x;

    public w(pk pkVar, bb bbVar) {
        super(pkVar, bbVar != null ? bbVar.n() : null);
    }

    public void n(FrameLayout frameLayout) {
        this.w = frameLayout;
    }

    public void qg(ViewGroup viewGroup) {
        this.x = true;
        this.fs = viewGroup;
    }

    @Override // com.byazt.ou.n
    public void n(ViewGroup viewGroup, View view, View view2, float[] fArr, sz szVar) {
        if (view2 == null) {
            return;
        }
        n(view2);
        if (this.x) {
            n(view, view2);
        } else {
            qg(view2);
        }
    }

    private void n(View view) {
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    private void qg(View view) {
        FrameLayout frameLayout = this.w;
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.w.addView(view, new FrameLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    private void n(View view, View view2) {
        if (this.fs == null) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.fs.getContext());
        frameLayout.setTag(2136934913);
        frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        view2.setVisibility(0);
        n(this.fs, view, frameLayout);
    }

    private void n(ViewGroup viewGroup, View view, FrameLayout frameLayout) {
        int width = view != null ? view.getWidth() : 0;
        int height = view != null ? view.getHeight() : 0;
        if (view == null || width <= 0 || height <= 0) {
            viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            return;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr);
        viewGroup.getLocationInWindow(iArr2);
        int i = iArr[0] - iArr2[0];
        int i2 = iArr[1] - iArr2[1];
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        layoutParams.setMargins(i, i2, 0, 0);
        viewGroup.addView(frameLayout, layoutParams);
    }

    @Override // com.byazt.ou.n
    public void x() {
        ViewGroup viewGroup;
        View viewFindViewWithTag;
        super.x();
        if (!this.x || (viewGroup = this.fs) == null || (viewFindViewWithTag = viewGroup.findViewWithTag(2136934913)) == null) {
            return;
        }
        ViewParent parent = viewFindViewWithTag.getParent();
        ViewGroup viewGroup2 = this.fs;
        if (parent == viewGroup2) {
            viewGroup2.removeView(viewFindViewWithTag);
        }
    }
}
