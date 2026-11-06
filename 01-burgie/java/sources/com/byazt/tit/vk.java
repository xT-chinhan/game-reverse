package com.byazt.tit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 50})
public class vk implements nt {
    @Override // com.byazt.tit.nt
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public String pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null) {
            try {
                if (objArr.length >= 2) {
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    if (((obj instanceof String) || (obj instanceof Number)) && (obj2 instanceof String)) {
                        return com.byazt.es.hw.pr(new BigDecimal(String.valueOf(obj)), (String) obj2, Locale.getDefault(), 2, 1, 2);
                    }
                    return "";
                }
                return "";
            } catch (Throwable th) {
                return "";
            }
        }
        return "";
    }
}
