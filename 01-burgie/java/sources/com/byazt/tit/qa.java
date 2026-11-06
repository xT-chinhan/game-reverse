package com.byazt.tit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 101})
public class qa implements nt {
    @Override // com.byazt.tit.nt
    public Object pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object obj = objArr[0];
        if ((obj instanceof String) || (obj instanceof Number)) {
            return pr(obj, objArr);
        }
        if (!(obj instanceof JSONArray)) {
            return null;
        }
        return hw(obj, objArr);
    }

    private String pr(Object obj, Object[] objArr) {
        String string;
        Object obj2;
        int iPr;
        int iPr2;
        if (obj instanceof String) {
            string = (String) obj;
        } else if (!(obj instanceof Number)) {
            string = "";
        } else {
            string = obj.toString();
        }
        if (objArr.length < 2) {
            obj2 = null;
        } else {
            obj2 = objArr[1];
        }
        Object obj3 = objArr.length >= 3 ? objArr[2] : null;
        int length = string.length();
        if (obj2 == null || (iPr = pr(obj2, 0)) < 0) {
            iPr = 0;
        } else if (iPr > length) {
            iPr = length;
        }
        if (obj3 != null && (iPr2 = pr(obj3, 0)) >= 0 && iPr2 <= length) {
            length = iPr2;
        }
        if (iPr > length) {
            iPr = length;
        }
        return string.substring(iPr, length);
    }

    private JSONArray hw(Object obj, Object[] objArr) {
        Object obj2;
        int iPr;
        int iPr2;
        JSONArray jSONArray = (JSONArray) obj;
        if (objArr.length < 2) {
            obj2 = null;
        } else {
            obj2 = objArr[1];
        }
        Object obj3 = objArr.length >= 3 ? objArr[2] : null;
        int length = jSONArray.length();
        if (obj2 == null || (iPr = pr(obj2, 0)) < 0) {
            iPr = 0;
        } else if (iPr > length) {
            iPr = length;
        }
        if (obj3 != null && (iPr2 = pr(obj3, 0)) >= 0 && iPr2 <= length) {
            length = iPr2;
        }
        if (iPr > length) {
            iPr = length;
        }
        JSONArray jSONArray2 = new JSONArray();
        while (iPr < length) {
            jSONArray2.put(jSONArray.opt(iPr));
            iPr++;
        }
        return jSONArray2;
    }

    private int pr(Object obj, int i) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return (int) Double.parseDouble((String) obj);
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i;
    }
}
