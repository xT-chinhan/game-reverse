package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 19})
public class n {
    public JSONObject l;
    public String n;
    public List<pk> q = new ArrayList();
    public int qg;
    public String s;
    public long w;

    public void n(String str) {
        this.n = str;
    }

    public int n() {
        return this.qg;
    }

    public void n(int i) {
        this.qg = i;
    }

    public void qg(String str) {
        this.s = str;
    }

    public List<pk> qg() {
        return this.q;
    }

    public void n(pk pkVar) {
        this.q.add(pkVar);
    }

    public void n(List<pk> list) {
        this.q = list;
    }

    public JSONObject s() {
        return this.l;
    }

    public void n(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public void n(long j) {
        this.w = j;
    }
}
