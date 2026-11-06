package com.byazt.ce;

import android.webkit.WebResourceResponse;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 37})
public class pr {
    public int hw = -1;
    public WebResourceResponse pr;

    public WebResourceResponse pr() {
        return this.pr;
    }

    public void pr(WebResourceResponse webResourceResponse) {
        this.pr = webResourceResponse;
    }

    public int getType() {
        return this.hw;
    }

    public void pr(int i) {
        this.hw = i;
    }
}
