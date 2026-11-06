package com.byazt.xz;

import android.widget.FrameLayout;
import com.byazt.az.hw;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.fj.SSWebView;
import com.byazt.hg.of;
import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 1173, 1964})
public abstract class AbstractEndCardFrameLayout extends FrameLayout {
    public final of hw;
    public final TTBaseVideoActivity pr;

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    public abstract void pr();

    public abstract void setClickListener(hw hwVar);

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity);
        this.pr = tTBaseVideoActivity;
        this.hw = ofVar;
        pr();
    }

    public void hw() {
    }
}
