package com.byazt.kl;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.gu.c;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 20})
public class hn extends c {
    public hn(Context context, of ofVar, com.byazt.gu.hw hwVar, ViewGroup viewGroup) {
        super(context, ofVar, hwVar, viewGroup);
    }

    @Override // com.byazt.gu.c
    public JSONObject pr() {
        return nt();
    }

    private JSONObject nt() {
        try {
            return new JSONObject(pr.pr(this.uc, this.fw).pr(this.uc));
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.byazt.gu.c, com.byazt.mq.x
    public int hw() {
        return 8;
    }
}
