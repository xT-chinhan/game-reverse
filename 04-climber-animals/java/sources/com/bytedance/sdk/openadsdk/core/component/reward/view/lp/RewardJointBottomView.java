package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.ms.ah.ah;
import com.bytedance.sdk.component.widget.recycler.ms.ah.d;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class RewardJointBottomView extends FrameLayout implements ah {
    private View.OnClickListener ab;
    private int[] ah;
    private int c;
    private final SlideUpLoadMoreArrow ch;
    private SSWebView d;
    private d ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f2265ms;
    private boolean ny;
    private boolean x;
    private int[] xr;

    public RewardJointBottomView(Context context, lm lmVar) {
        super(context);
        this.xr = new int[2];
        this.ah = new int[2];
        this.c = 0;
        this.x = false;
        this.ny = false;
        SSWebView sSWebView = new SSWebView(context);
        this.d = sSWebView;
        sSWebView.setMaterialMeta(pc.ms(lmVar));
        this.d.setWebViewClient(null);
        addView(this.d, new ViewGroup.LayoutParams(-1, -1));
        this.d.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView.1
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                if (Math.abs((RewardJointBottomView.this.d.getWebView().getHeight() + RewardJointBottomView.this.d.getWebView().getScrollY()) - (RewardJointBottomView.this.d.getWebView().getContentHeight() * RewardJointBottomView.this.d.getWebView().getScale())) < 10.0f) {
                    if (RewardJointBottomView.this.x) {
                        return;
                    }
                    RewardJointBottomView.this.x = true;
                    return;
                }
                RewardJointBottomView.this.x = false;
            }
        });
        getScrollingChildHelper().ms(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.ch = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.ms();
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.ab = onClickListener;
    }

    public void ms(String str) {
        this.d.loadUrl(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = 0;
            this.f2265ms = motionEvent.getY();
            ms(2, 0);
            this.ny = this.x;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.f2265ms;
                if (y < 0.0f) {
                    ms();
                    if (ms(0, (int) y, this.xr, this.ah, 0)) {
                        y -= this.xr[1];
                    }
                    this.c += ms((int) ((Math.floor((double) Math.abs(y)) != 0.0d ? y : 0.0f) - this.c));
                } else {
                    int i = (int) (y - this.c);
                    int iMs = ms(i);
                    this.c += iMs;
                    ms(0, i - iMs, this.xr, this.ah, 0);
                }
            }
        } else if (this.ny && this.f2265ms - motionEvent.getY() > 100.0f && (onClickListener = this.ab) != null) {
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

    public boolean ms(int i, int i2) {
        return getScrollingChildHelper().xr(0);
    }

    public boolean ms(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().ms(i, i2, iArr, iArr2, i3);
    }

    private d getScrollingChildHelper() {
        if (this.ka == null) {
            this.ka = new d(this);
        }
        return this.ka;
    }

    public int ms(int i) {
        if (i < 0) {
            return (int) (-Math.abs(Math.min(this.d.getWebView().getContentHeight() - (this.d.getWebView().getHeight() + this.d.getWebView().getScrollY()), -i)));
        }
        if (i > 0) {
            return Math.min(this.d.getWebView().getScrollY(), i);
        }
        return 0;
    }

    public SSWebView getWebView() {
        return this.d;
    }

    public void ms() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.ch;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.ch.xr();
        }
    }

    public void xr() {
        ms();
    }
}
