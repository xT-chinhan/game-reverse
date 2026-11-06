package com.byazt.xe;

import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1624, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public Map<String, JSONObject> hw;
    public int pr;

    public boolean pr() {
        int i = this.pr;
        return i > 20000 && i < 100000;
    }

    public static c pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("result");
        HashMap map = new HashMap();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("id", "");
                    String strOptString2 = jSONObjectOptJSONObject.optString("req_id", "");
                    if (!TextUtils.isEmpty(pr(strOptString, strOptString2))) {
                        map.put(pr(strOptString, strOptString2), jSONObjectOptJSONObject);
                    }
                }
            }
        }
        c cVar = new c();
        cVar.hw = map;
        cVar.pr = iOptInt;
        return cVar;
    }

    public static String pr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + "_" + str;
    }
}
