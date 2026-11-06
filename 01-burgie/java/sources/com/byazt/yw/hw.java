package com.byazt.yw;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.id.UGTextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 13})
public class hw extends com.byazt.id.hw {
    public hw(Context context) {
        super(context);
    }

    @Override // com.byazt.id.hw, com.byazt.ik.hn
    public void hw() {
        super.hw();
        if (TextUtils.isEmpty(this.pr)) {
            ((UGTextView) this.c).setText("跳过");
        }
    }

    public void x(boolean z) {
        if (z) {
            hw(0);
            pr(true, true);
        } else {
            x(0);
            c(0);
        }
    }
}
