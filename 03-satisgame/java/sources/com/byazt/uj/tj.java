package com.byazt.uj;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements hd {
    @Override // com.byazt.uj.hd
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public String n(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            return null;
        }
        String strValueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strValueOf);
            String strValueOf2 = String.valueOf(objArr[1]);
            if (TextUtils.isEmpty(strValueOf2)) {
                return null;
            }
            Object objN = com.byazt.sz.n.n(strValueOf2).n(jSONObject2);
            if (objN != null && !TextUtils.isEmpty(String.valueOf(objN))) {
                return String.valueOf(objN);
            }
            if (objArr.length >= 3) {
                return String.valueOf(objArr[2]);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }
}
