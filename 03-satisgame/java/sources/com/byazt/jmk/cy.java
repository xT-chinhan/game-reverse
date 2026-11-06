package com.byazt.jmk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.SlideRightView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements x {
    public SlideRightView n;
    public com.byazt.lh.x q;
    public Context qg;
    public DynamicBaseWidget s;

    public cy(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        this.qg = context;
        this.s = dynamicBaseWidget;
        this.q = xVar;
        q();
    }

    private void q() {
        this.n = new SlideRightView(this.qg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.byazt.cq.fs.n(this.qg, 120.0f));
        layoutParams.gravity = 17;
        this.n.setLayoutParams(layoutParams);
        this.n.setClipChildren(false);
        this.n.setGuideText(this.q.b());
        DynamicBaseWidget dynamicBaseWidget = this.s;
        if (dynamicBaseWidget != null) {
            this.n.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.byazt.jmk.x
    public void n() {
        SlideRightView slideRightView = this.n;
        if (slideRightView != null) {
            slideRightView.n();
        }
    }

    @Override // com.byazt.jmk.x
    public void qg() {
        SlideRightView slideRightView = this.n;
        if (slideRightView != null) {
            slideRightView.qg();
        }
    }

    @Override // com.byazt.jmk.x
    public ViewGroup s() {
        return this.n;
    }
}
