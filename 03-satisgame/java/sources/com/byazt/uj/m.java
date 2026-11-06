package com.byazt.uj;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public class m implements hd {
    @Override // com.byazt.uj.hd
    public Object n(JSONObject jSONObject, Object[] objArr) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (objArr == null || objArr.length != 0) {
            return null;
        }
        String strValueOf = String.valueOf(objArr[2]);
        String strValueOf2 = String.valueOf(objArr[1]);
        String strValueOf3 = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(strValueOf3) || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("i18n")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(strValueOf2)) == null) {
            return strValueOf;
        }
        String strOptString = jSONObjectOptJSONObject2.optString(strValueOf3);
        return TextUtils.isEmpty(strOptString) ? strValueOf : strOptString;
    }
}
