package com.byazt.wp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, 26})
public final class qg {
    public final int n;
    public final long qg;
    public final List<n> s;

    public qg(int i, long j, List<n> list) {
        this.n = i;
        this.qg = j;
        this.s = list;
    }

    public void n(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        jSONObject.put("active_ad_session_count", this.n);
        jSONObject.put("active_ad_sessions", n());
    }

    private JSONArray n() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<n> list = this.s;
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(this.s.get(i).qg());
        }
        return jSONArray;
    }
}
