package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends x {
    public zo(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.hw.vk() * 1000.0d));
        ((ViewGroup) this.hn.getParent()).setClipChildren(false);
        ((ViewGroup) this.hn.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.hn.getParent().getParent().getParent()).setClipChildren(false);
        this.hn.setTag(2097610712, this.hw.zo());
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        return arrayList;
    }
}
