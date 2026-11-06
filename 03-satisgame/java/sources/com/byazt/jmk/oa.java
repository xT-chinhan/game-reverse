package com.byazt.jmk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.PressInteractView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements x<PressInteractView> {
    public PressInteractView n;

    public oa(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        this.n = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.cq.fs.n(context, 180.0f), (int) com.byazt.cq.fs.n(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.byazt.cq.fs.n(context, 20.0f);
        this.n.setLayoutParams(layoutParams);
        this.n.setGuideText(xVar.b());
    }

    @Override // com.byazt.jmk.x
    public void n() {
        this.n.n();
    }

    @Override // com.byazt.jmk.x
    public void qg() {
        this.n.qg();
    }

    @Override // com.byazt.jmk.x
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PressInteractView s() {
        return this.n;
    }
}
