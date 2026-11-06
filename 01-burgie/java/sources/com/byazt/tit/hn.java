package com.byazt.tit;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 20})
public class hn implements nt {
    @Override // com.byazt.tit.nt
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public String pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        try {
            String strValueOf = String.valueOf(objArr[0]);
            if (TextUtils.isEmpty(strValueOf)) {
                if (objArr.length < 2) {
                    return null;
                }
                return String.valueOf(objArr[1]);
            }
            return new SimpleDateFormat(strValueOf, Locale.getDefault()).format(new Date());
        } catch (Throwable th) {
            return null;
        }
    }
}
