package com.byazt.tit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 48})
public class lb implements nt {
    @Override // com.byazt.tit.nt
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public Integer pr(JSONObject jSONObject, Object[] objArr) {
        Object obj;
        if (objArr == null || objArr.length == 0 || (obj = objArr[0]) == null) {
            return 0;
        }
        if (obj instanceof String) {
            return Integer.valueOf(((String) obj).length());
        }
        if (obj instanceof Set) {
            return Integer.valueOf(((Set) obj).size());
        }
        if (obj instanceof List) {
            return Integer.valueOf(((List) obj).size());
        }
        if (obj instanceof Map) {
            return Integer.valueOf(((Map) obj).size());
        }
        if (obj.getClass().isArray()) {
            return Integer.valueOf(Array.getLength(obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(obj.toString().length());
        }
        if (obj instanceof JSONObject) {
            return Integer.valueOf(((JSONObject) obj).length());
        }
        if (!(obj instanceof JSONArray)) {
            return 0;
        }
        return Integer.valueOf(((JSONArray) obj).length());
    }
}
