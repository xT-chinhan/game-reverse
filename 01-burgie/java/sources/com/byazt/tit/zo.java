package com.byazt.tit;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements nt {
    @Override // com.byazt.tit.nt
    public Object pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    if (sb.length() > 0) {
                        sb.append(".");
                    }
                    sb.append(obj);
                }
            }
            return pr(jSONObject, sb.toString());
        } catch (Throwable th) {
            return null;
        }
    }

    private Object pr(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.byazt.oze.pr.pr(str).pr(jSONObject);
        } catch (Throwable th) {
            return null;
        }
    }
}
