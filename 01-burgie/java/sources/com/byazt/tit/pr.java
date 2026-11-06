package com.byazt.tit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 37})
public class pr implements nt {
    @Override // com.byazt.tit.nt
    public Object pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length != 2) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArrayPr = pr(objArr[0]);
            if (jSONArrayPr == null) {
                return jSONArray;
            }
            int i = Integer.parseInt(String.valueOf(objArr[1]));
            for (int i2 = 0; i2 < jSONArrayPr.length(); i2 += i) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = i2 + i3;
                    if (i4 >= jSONArrayPr.length()) {
                        break;
                    }
                    jSONArray2.put(jSONArrayPr.opt(i4));
                }
                jSONObject2.put("$chunk", jSONArray2);
                jSONArray.put(jSONObject2);
            }
        } catch (Throwable th) {
        }
        return jSONArray;
    }

    private JSONArray pr(Object obj) {
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if (obj != null && obj.getClass().isArray()) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                jSONArray.put(obj2);
            }
            return jSONArray;
        }
        try {
            return new JSONArray(String.valueOf(obj));
        } catch (JSONException e) {
            return null;
        }
    }
}
