package com.byazt.kru;

import android.content.Context;
import android.view.View;
import com.byazt.gu.l;
import com.byazt.ivn.w;
import com.byazt.nf.rv;
import com.byazt.pp.LottieAnimationView;
import com.byazt.sx.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 1685})
public class UgenLottieView extends LottieAnimationView {
    public l n;
    public n qg;

    public interface n {
        void n(int i);

        void n(boolean z);
    }

    public UgenLottieView(Context context) {
        super(context);
        fs();
    }

    private void fs() {
        w wVarQg = rv.qg();
        if (wVarQg == null || !wVarQg.tv()) {
            return;
        }
        setTriggerManagerProxy(new s(q.n()));
    }

    public void n(l lVar) {
        this.n = lVar;
    }

    public void setTriggerVisibilityListener(n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.pp.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // com.byazt.pp.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        n nVar = this.qg;
        if (nVar != null) {
            nVar.n(z);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        n nVar = this.qg;
        if (nVar == null || view != this) {
            return;
        }
        nVar.n(i);
    }
}
