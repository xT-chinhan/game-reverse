package com.byazt.az;

import android.content.Context;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 513, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public abstract class c extends pr {
    public c(Context context, of ofVar, String str, int i) {
        super(context, ofVar, str, i);
    }

    @Override // com.byazt.az.hw, com.byazt.az.x
    public void pr(View view, vk vkVar) {
        if (of.uc(this.pr)) {
            return;
        }
        super.pr(view, vkVar);
    }
}
