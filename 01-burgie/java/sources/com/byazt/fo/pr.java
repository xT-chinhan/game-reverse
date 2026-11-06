package com.byazt.fo;

import android.content.Context;
import android.widget.ScrollView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 37})
public class pr extends com.byazt.ik.pr<ScrollView> {
    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: lv, reason: merged with bridge method [inline-methods] */
    public ScrollView pr() {
        UGScrollView uGScrollView = new UGScrollView(this.hw);
        uGScrollView.pr(this);
        return uGScrollView;
    }

    @Override // com.byazt.ik.pr
    public com.byazt.ik.pr.C0097pr zo() {
        return new com.byazt.ajv.pr.C0013pr(this);
    }
}
