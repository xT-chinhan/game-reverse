package com.byazt.jmk;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.osr.DynamicBaseWidget;
import com.byazt.stl.SlideUpView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1291, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd<E extends SlideUpView> implements x<E> {
    public int l;
    public SlideUpView n;
    public com.byazt.lh.x q;
    public Context qg;
    public DynamicBaseWidget s;

    public hd(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar, int i) {
        this.l = i;
        this.qg = context;
        this.s = dynamicBaseWidget;
        this.q = xVar;
        q();
    }

    public hd(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.lh.x xVar) {
        this(context, dynamicBaseWidget, xVar, 0);
    }

    public void q() {
        this.n = new SlideUpView(this.qg, this.q.dg());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.cq.fs.n(this.qg, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.byazt.cq.fs.n(this.qg, 100 - this.l);
        this.n.setLayoutParams(layoutParams);
        try {
            this.n.setGuideText(this.q.b());
        } catch (Throwable unused) {
        }
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
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public E s() {
        return (E) this.n;
    }
}
