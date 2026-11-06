package com.byazt.jfs;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy extends q {
    public cy(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "translationX", 0.0f, com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), 20.0f), 0.0f, -com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), 20.0f), 0.0f).setDuration((int) (this.qg.tj() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        return arrayList;
    }
}
