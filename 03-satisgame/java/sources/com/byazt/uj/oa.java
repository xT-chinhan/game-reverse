package com.byazt.uj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements hd {
    @Override // com.byazt.uj.hd
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public Boolean n(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length >= 2) {
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            if (obj2 == null) {
                return Boolean.FALSE;
            }
            if (obj instanceof String) {
                return Boolean.valueOf(((String) obj).contains(String.valueOf(obj2)));
            }
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray.length() > 0) {
                    return Boolean.valueOf(n(jSONArray, obj2));
                }
            }
        }
        return Boolean.FALSE;
    }

    private boolean n(JSONArray jSONArray, Object obj) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (jSONArray.get(i).equals(obj)) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
