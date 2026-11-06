package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1709})
public class rf {
    public List<g> n;

    public rf(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("components")) == null) {
            return;
        }
        this.n = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            this.n.add(new g(jSONArrayOptJSONArray.optJSONObject(i), 3));
        }
    }

    public static List<g> n(pk pkVar) {
        rf rfVarPi;
        if (pkVar == null || (rfVarPi = pkVar.pi()) == null) {
            return null;
        }
        return rfVarPi.n;
    }

    public static boolean qg(pk pkVar) {
        rf rfVarPi;
        List<g> list;
        return (pkVar == null || (rfVarPi = pkVar.pi()) == null || (list = rfVarPi.n) == null || list.isEmpty()) ? false : true;
    }
}
