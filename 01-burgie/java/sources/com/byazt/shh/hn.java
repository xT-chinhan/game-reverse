package com.byazt.shh;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 20})
public class hn {
    public static int pr = 0;
    public static int hw = 1;
    public static int hn = 2;
    public int x = pr;
    public long c = 0;
    public JSONObject uc = null;
    public int fw = 0;
    public String zo = "";
    public String aj = "";

    public boolean pr() {
        return this.x == hw;
    }

    public int hw() {
        return this.fw;
    }

    public hn pr(int i) {
        this.x = i;
        return this;
    }

    public hn hw(int i) {
        this.fw = i;
        return this;
    }
}
