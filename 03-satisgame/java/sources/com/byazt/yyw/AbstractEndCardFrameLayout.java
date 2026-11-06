package com.byazt.yyw;

import android.widget.FrameLayout;
import com.byazt.cp.n;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.byazt.ys.qg;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, 1298, 2190})
public abstract class AbstractEndCardFrameLayout extends FrameLayout {
    public final TTBaseVideoActivity n;
    public final pk qg;

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    public abstract void n();

    public void qg() {
    }

    public abstract void setClickListener(qg qgVar);

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity);
        this.n = tTBaseVideoActivity;
        this.qg = pkVar;
        n();
    }
}
