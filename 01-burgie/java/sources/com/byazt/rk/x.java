package com.byazt.rk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1536, 121})
public class x {
    public String hn;
    public String hw;
    public List<pr> pr;
    public String x;

    @com.byazt.vzx.pr(pr = {0, 1, 1536, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static class pr {
        public JSONObject hw;
        public int pr;
    }

    public static x pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        x xVar = new x();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    pr prVar = new pr();
                    prVar.pr = jSONObjectOptJSONObject.optInt("id");
                    prVar.hw = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(prVar);
                }
            }
        } catch (JSONException e) {
        }
        xVar.pr = arrayList;
        xVar.hw = jSONObject.optString("diff_data");
        xVar.hn = jSONObject.optString("style_diff");
        xVar.x = jSONObject.optString("tag_diff");
        return xVar;
    }
}
