package com.byazt.uj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a implements hd {
    @Override // com.byazt.uj.hd
    public Object n(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object obj = objArr[0];
        if ((obj instanceof String) || (obj instanceof Number)) {
            return n(obj, objArr);
        }
        if (obj instanceof JSONArray) {
            return qg(obj, objArr);
        }
        return null;
    }

    private String n(Object obj, Object[] objArr) {
        String string;
        int iN;
        int iN2;
        if (obj instanceof String) {
            string = (String) obj;
        } else {
            string = obj instanceof Number ? obj.toString() : "";
        }
        Object obj2 = objArr.length >= 2 ? objArr[1] : null;
        Object obj3 = objArr.length >= 3 ? objArr[2] : null;
        int length = string.length();
        if (obj2 == null || (iN = n(obj2, 0)) < 0) {
            iN = 0;
        } else if (iN > length) {
            iN = length;
        }
        if (obj3 != null && (iN2 = n(obj3, 0)) >= 0 && iN2 <= length) {
            length = iN2;
        }
        if (iN > length) {
            iN = length;
        }
        return string.substring(iN, length);
    }

    private JSONArray qg(Object obj, Object[] objArr) {
        int iN;
        int iN2;
        JSONArray jSONArray = (JSONArray) obj;
        Object obj2 = objArr.length >= 2 ? objArr[1] : null;
        Object obj3 = objArr.length >= 3 ? objArr[2] : null;
        int length = jSONArray.length();
        if (obj2 == null || (iN = n(obj2, 0)) < 0) {
            iN = 0;
        } else if (iN > length) {
            iN = length;
        }
        if (obj3 != null && (iN2 = n(obj3, 0)) >= 0 && iN2 <= length) {
            length = iN2;
        }
        if (iN > length) {
            iN = length;
        }
        JSONArray jSONArray2 = new JSONArray();
        while (iN < length) {
            jSONArray2.put(jSONArray.opt(iN));
            iN++;
        }
        return jSONArray2;
    }

    private int n(Object obj, int i) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return (int) Double.parseDouble((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }
}
