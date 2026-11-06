package com.byazt.vh;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1778, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy {
    public cy l;
    public com.byazt.ih.s n;
    public cy q;
    public int qg;
    public JSONObject s;

    public com.byazt.ih.s n() {
        return this.n;
    }

    public void n(com.byazt.ih.s sVar) {
        this.n = sVar;
    }

    public int qg() {
        return this.qg;
    }

    public void n(int i) {
        this.qg = i;
    }

    public JSONObject s() {
        return this.s;
    }

    public void n(JSONObject jSONObject) {
        this.s = jSONObject;
    }

    public cy q() {
        return this.q;
    }

    public void n(cy cyVar) {
        this.q = cyVar;
    }

    public void qg(cy cyVar) {
        this.l = cyVar;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.n + ", mEventType=" + this.qg + ", mEvent=" + this.s + AbstractJsonLexerKt.END_OBJ;
    }
}
