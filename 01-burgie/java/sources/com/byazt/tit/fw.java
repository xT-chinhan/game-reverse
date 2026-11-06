package com.byazt.tit;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 62})
public class fw implements nt {
    @Override // com.byazt.tit.nt
    public Object pr(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        for (Object obj : objArr) {
            String strValueOf = String.valueOf(obj);
            if (!TextUtils.isEmpty(strValueOf) && !TextUtils.equals(strValueOf, AbstractJsonLexerKt.NULL)) {
                return strValueOf;
            }
        }
        return null;
    }
}
