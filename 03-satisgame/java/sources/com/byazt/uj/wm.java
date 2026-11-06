package com.byazt.uj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public class wm implements hd {
    @Override // com.byazt.uj.hd
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public String n(JSONObject jSONObject, Object[] objArr) {
        Object obj;
        if (objArr == null || objArr.length == 0 || (obj = objArr[0]) == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Number) {
            return obj.toString();
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        return null;
    }
}
