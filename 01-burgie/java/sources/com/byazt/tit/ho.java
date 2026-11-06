package com.byazt.tit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 19})
public class ho implements nt {
    @Override // com.byazt.tit.nt
    public Object pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            return null;
        }
        int i = 0;
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        if (obj == null || !(obj2 instanceof String)) {
            return null;
        }
        String str = (String) obj2;
        StringBuilder sb = new StringBuilder();
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            while (i < jSONArray.length()) {
                if (i > 0) {
                    sb.append(str);
                }
                sb.append(String.valueOf(jSONArray.opt(i)));
                i++;
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr2 = (Object[]) obj;
            while (i < objArr2.length) {
                if (i > 0) {
                    sb.append(str);
                }
                sb.append(String.valueOf(objArr2[i]));
                i++;
            }
        } else {
            return String.valueOf(obj);
        }
        return sb.toString();
    }
}
