package com.byazt.vl;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 8})
public class s {
    public static int n = 0;
    public static int qg = 1;
    public static int s = 2;
    public int q = n;
    public long l = 0;
    public JSONObject w = null;
    public int x = 0;
    public String fs = "";
    public String rv = "";

    public boolean n() {
        return this.q == qg;
    }

    public int qg() {
        return this.x;
    }

    public s n(int i) {
        this.q = i;
        return this;
    }

    public s qg(int i) {
        this.x = i;
        return this;
    }
}
