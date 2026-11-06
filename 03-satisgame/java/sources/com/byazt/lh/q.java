package com.byazt.lh;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1475, 5})
public class q {
    public List<n> n;
    public String q;
    public String qg;
    public String s;

    @com.byazt.cp.n(n = {0, 1, 1475, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n {
        public int n;
        public JSONObject qg;
    }

    public static q n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        q qVar = new q();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    n nVar = new n();
                    nVar.n = jSONObjectOptJSONObject.optInt("id");
                    nVar.qg = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(nVar);
                }
            }
        } catch (JSONException unused) {
        }
        qVar.n = arrayList;
        qVar.qg = jSONObject.optString("diff_data");
        qVar.s = jSONObject.optString("style_diff");
        qVar.q = jSONObject.optString("tag_diff");
        return qVar;
    }
}
