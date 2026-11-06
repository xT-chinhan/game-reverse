package com.byazt.uz;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.cp.n;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.byazt.mgr.q;
import com.byazt.mgr.s;
import com.byazt.xk.SlideUpLoadMoreArrow;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 748, 1066})
public class RewardJointBottomView extends FrameLayout implements s {
    public boolean fs;
    public q l;
    public float n;
    public SSWebView q;
    public int[] qg;
    public boolean rv;
    public int[] s;
    public final SlideUpLoadMoreArrow tj;
    public int w;
    public View.OnClickListener x;

    public RewardJointBottomView(Context context, pk pkVar) {
        super(context);
        this.qg = new int[2];
        this.s = new int[2];
        this.w = 0;
        this.fs = false;
        this.rv = false;
        SSWebView sSWebView = new SSWebView(context);
        this.q = sSWebView;
        sSWebView.setMaterialMeta(com.byazt.cd.s.n(pkVar));
        this.q.setWebViewClient(null);
        addView(this.q, new ViewGroup.LayoutParams(-1, -1));
        this.q.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.byazt.uz.RewardJointBottomView.1
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                if (Math.abs((RewardJointBottomView.this.q.getWebView().getHeight() + RewardJointBottomView.this.q.getWebView().getScrollY()) - (RewardJointBottomView.this.q.getWebView().getContentHeight() * RewardJointBottomView.this.q.getWebView().getScale())) < 10.0f) {
                    if (RewardJointBottomView.this.fs) {
                        return;
                    }
                    RewardJointBottomView.this.fs = true;
                    return;
                }
                RewardJointBottomView.this.fs = false;
            }
        });
        getScrollingChildHelper().n(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.tj = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.n();
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void n(String str) {
        this.q.loadUrl(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.w = 0;
            this.n = motionEvent.getY();
            n(2, 0);
            this.rv = this.fs;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.n;
                if (y < 0.0f) {
                    n();
                    if (n(0, (int) y, this.qg, this.s, 0)) {
                        y -= this.qg[1];
                    }
                    this.w += n((int) ((Math.floor((double) Math.abs(y)) != 0.0d ? y : 0.0f) - this.w));
                } else {
                    int i = (int) (y - this.w);
                    int iN = n(i);
                    this.w += iN;
                    n(0, i - iN, this.qg, this.s, 0);
                }
            }
        } else if (this.rv && this.n - motionEvent.getY() > 100.0f && (onClickListener = this.x) != null) {
            onClickListener.onClick(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return super.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return super.dispatchNestedPreFling(f, f2);
    }

    public boolean n(int i, int i2) {
        return getScrollingChildHelper().qg(0);
    }

    public boolean n(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().n(i, i2, iArr, iArr2, i3);
    }

    private q getScrollingChildHelper() {
        if (this.l == null) {
            this.l = new q(this);
        }
        return this.l;
    }

    public int n(int i) {
        if (i < 0) {
            return (int) (-Math.abs(Math.min(this.q.getWebView().getContentHeight() - (this.q.getWebView().getHeight() + this.q.getWebView().getScrollY()), -i)));
        }
        if (i > 0) {
            return Math.min(this.q.getWebView().getScrollY(), i);
        }
        return 0;
    }

    public SSWebView getWebView() {
        return this.q;
    }

    public void n() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.tj;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.tj.qg();
        }
    }

    public void qg() {
        n();
    }
}
