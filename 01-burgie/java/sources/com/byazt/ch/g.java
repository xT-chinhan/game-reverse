package com.byazt.ch;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public com.byazt.dd.nt c;
    public Set<String> fw;
    public JSONObject hn;
    public JSONObject hw;
    public Context pr;
    public String uc;
    public Map<String, Object> x;

    public Context getContext() {
        return this.pr;
    }

    public void pr(Context context) {
        this.pr = context;
    }

    public void pr(JSONObject jSONObject) {
        this.hw = jSONObject;
    }

    public JSONObject pr() {
        return this.hn;
    }

    public void hw(JSONObject jSONObject) {
        this.hn = jSONObject;
    }

    public Map<String, Object> hw() {
        return this.x;
    }

    public void pr(Map<String, Object> map) {
        this.x = map;
    }

    public void pr(com.byazt.dd.nt ntVar) {
        this.c = ntVar;
    }

    public void pr(String str) {
        this.uc = str;
    }

    public void pr(Set<String> set) {
        this.fw = set;
    }

    public com.byazt.dd.nt hn() {
        return this.c;
    }

    public String x() {
        return this.uc;
    }

    public Set<String> c() {
        return this.fw;
    }
}
