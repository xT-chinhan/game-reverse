package com.byazt.yd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF, 20})
public class hn {
    public JSONObject c;
    public boolean hn;
    public String hw;
    public String pr;
    public int uc;
    public int x;

    public hn(String str, String str2, boolean z, int i, JSONObject jSONObject, int i2) {
        this.pr = str;
        this.hw = str2;
        this.hn = z;
        this.x = i;
        this.c = jSONObject;
        this.uc = i2;
    }

    public JSONObject pr() {
        if (this.c == null) {
            this.c = new JSONObject();
        }
        return this.c;
    }

    public String hw() {
        return this.pr;
    }

    public String hn() {
        return this.hw;
    }

    public boolean x() {
        return this.hn;
    }

    public int c() {
        return this.x;
    }

    public void pr(int i) {
        this.x = i;
    }
}
