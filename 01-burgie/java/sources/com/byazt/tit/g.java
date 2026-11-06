package com.byazt.tit;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g implements nt {
    @Override // com.byazt.tit.nt
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public Boolean pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj == null) {
                return Boolean.TRUE;
            }
            if (obj instanceof String) {
                return Boolean.valueOf(TextUtils.isEmpty((String) obj));
            }
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return Boolean.FALSE;
            }
            if (obj instanceof JSONArray) {
                return Boolean.valueOf(((JSONArray) obj).length() == 0);
            }
        }
        return Boolean.TRUE;
    }
}
