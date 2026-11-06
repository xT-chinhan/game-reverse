package com.byazt.vzj;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, 1537})
public class TTLottieVideoContainer extends FrameLayout implements com.byazt.hlq.qg {
    public com.byazt.hlq.qg.n n;

    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.byazt.hlq.qg
    public View getView() {
        return this;
    }

    @Override // com.byazt.hlq.qg
    public void n(com.byazt.hlq.n nVar) {
    }

    public TTLottieVideoContainer(Context context) {
        super(context);
    }

    @Override // com.byazt.hlq.qg
    public void n(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(com.byazt.hlq.qg.n nVar) {
        this.n = nVar;
    }
}
