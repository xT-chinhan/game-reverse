package com.byazt.ar;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.pg.SlideUpLoadMoreArrow;
import com.byazt.vu.hn;
import com.byazt.vu.x;
import com.byazt.vzx.pr;
import com.byazt.wt.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_PATH_INFO, 981})
public class RewardJointBottomView extends FrameLayout implements hn {
    public boolean aj;
    public x c;
    public View.OnClickListener fw;
    public int[] hn;
    public int[] hw;
    public float pr;
    public int uc;
    public final SlideUpLoadMoreArrow vk;
    public SSWebView x;
    public boolean zo;

    public RewardJointBottomView(Context context, of ofVar) {
        super(context);
        this.hw = new int[2];
        this.hn = new int[2];
        this.uc = 0;
        this.zo = false;
        this.aj = false;
        SSWebView sSWebView = new SSWebView(context);
        this.x = sSWebView;
        sSWebView.setMaterialMeta(e.pr(ofVar));
        this.x.setWebViewClient(null);
        addView(this.x, new ViewGroup.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 23) {
            this.x.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.byazt.ar.RewardJointBottomView.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (Math.abs((RewardJointBottomView.this.x.getWebView().getHeight() + RewardJointBottomView.this.x.getWebView().getScrollY()) - (RewardJointBottomView.this.x.getWebView().getContentHeight() * RewardJointBottomView.this.x.getWebView().getScale())) < 10.0f) {
                        if (!RewardJointBottomView.this.zo) {
                            RewardJointBottomView.this.zo = true;
                            return;
                        }
                        return;
                    }
                    RewardJointBottomView.this.zo = false;
                }
            });
        }
        getScrollingChildHelper().pr(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.vk = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.pr();
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.fw = onClickListener;
    }

    public void pr(String str) {
        this.x.loadUrl(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        switch (motionEvent.getAction()) {
            case 0:
                this.uc = 0;
                this.pr = motionEvent.getY();
                pr(2, 0);
                this.aj = this.zo;
                break;
            case 1:
                if (this.aj && this.pr - motionEvent.getY() > 100.0f && (onClickListener = this.fw) != null) {
                    onClickListener.onClick(this);
                }
                break;
            case 2:
                float y = motionEvent.getY() - this.pr;
                float f = 0.0f;
                if (y < 0.0f) {
                    pr();
                    if (pr(0, (int) y, this.hw, this.hn, 0)) {
                        y -= this.hw[1];
                    }
                    if (Math.floor(Math.abs(y)) != 0.0d) {
                        f = y;
                    }
                    this.uc += pr((int) (f - this.uc));
                } else {
                    int i = (int) (y - this.uc);
                    int iPr = pr(i);
                    this.uc += iPr;
                    pr(0, i - iPr, this.hw, this.hn, 0);
                }
                break;
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

    public boolean pr(int i, int i2) {
        return getScrollingChildHelper().hw(0);
    }

    public boolean pr(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().pr(i, i2, iArr, iArr2, i3);
    }

    private x getScrollingChildHelper() {
        if (this.c == null) {
            this.c = new x(this);
        }
        return this.c;
    }

    public int pr(int i) {
        if (i < 0) {
            return (int) (-Math.abs(Math.min(this.x.getWebView().getContentHeight() - (this.x.getWebView().getHeight() + this.x.getWebView().getScrollY()), -i)));
        }
        if (i > 0) {
            return Math.min(this.x.getWebView().getScrollY(), i);
        }
        return 0;
    }

    public SSWebView getWebView() {
        return this.x;
    }

    public void pr() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.vk;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.vk.hw();
        }
    }

    public void hw() {
        pr();
    }
}
