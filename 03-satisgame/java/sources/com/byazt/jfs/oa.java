package com.byazt.jfs;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.osr.DynamicImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends q {
    public oa(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        if ((this.s instanceof ImageView) && (this.s.getParent() instanceof DynamicImageView)) {
            this.s = (View) this.s.getParent();
            ((ViewGroup) this.s).setClipChildren(true);
            ((ViewGroup) this.s.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.qg.tj() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        return arrayList;
    }
}
