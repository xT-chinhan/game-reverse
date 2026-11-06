package com.byazt.ch;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, 74})
public class nt {
    public nt c;
    public JSONObject hn;
    public int hw;
    public com.byazt.ik.hn pr;
    public nt x;

    public com.byazt.ik.hn pr() {
        return this.pr;
    }

    public void pr(com.byazt.ik.hn hnVar) {
        this.pr = hnVar;
    }

    public int hw() {
        return this.hw;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public JSONObject hn() {
        return this.hn;
    }

    public void pr(JSONObject jSONObject) {
        this.hn = jSONObject;
    }

    public nt x() {
        return this.x;
    }

    public void pr(nt ntVar) {
        this.x = ntVar;
    }

    public void hw(nt ntVar) {
        this.c = ntVar;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.pr + ", mEventType=" + this.hw + ", mEvent=" + this.hn + AbstractJsonLexerKt.END_OBJ;
    }
}
