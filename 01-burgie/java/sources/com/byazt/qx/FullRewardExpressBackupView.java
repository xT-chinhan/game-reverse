package com.byazt.qx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.hg.of;
import com.byazt.wt.er;
import com.byazt.wt.ls;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 2310})
public class FullRewardExpressBackupView extends BackupView {
    public NativeExpressView g;
    public FrameLayout ho;
    public View m;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.pr = context;
    }

    public void pr(of ofVar, NativeExpressView nativeExpressView) {
        setBackgroundColor(-1);
        this.hw = ofVar;
        this.g = nativeExpressView;
        if (ls.k(this.hw) == 7) {
            this.c = "rewarded_video";
        } else {
            this.c = "fullscreen_interstitial_ad";
        }
        pr();
        this.g.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void pr() {
        this.uc = er.hn(this.pr, this.g.getExpectExpressWidth());
        this.fw = er.hn(this.pr, this.g.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.uc, this.fw);
        }
        layoutParams.width = this.uc;
        layoutParams.height = this.fw;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        hw();
    }

    private void hw() {
        FrameLayout frameLayout = new FrameLayout(this.pr);
        this.m = frameLayout;
        frameLayout.setId(2114387734);
        addView(this.m);
        FrameLayout frameLayout2 = (FrameLayout) this.m.findViewById(2114387734);
        this.ho = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.ho;
    }

    @Override // com.byazt.qx.BackupView
    public void pr(View view, int i, com.byazt.hg.fo foVar) {
        NativeExpressView nativeExpressView = this.g;
        if (nativeExpressView != null) {
            nativeExpressView.pr(view, i, foVar, -1);
        }
    }
}
