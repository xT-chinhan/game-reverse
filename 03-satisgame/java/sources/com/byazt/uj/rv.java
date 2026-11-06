package com.byazt.uj;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements hd {
    @Override // com.byazt.uj.hd
    public Object n(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            try {
                StringBuilder sb = new StringBuilder();
                for (Object obj : objArr) {
                    if (obj != null) {
                        if (sb.length() > 0) {
                            sb.append(i.E);
                        }
                        sb.append(obj);
                    }
                }
                return n(jSONObject, sb.toString());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private Object n(JSONObject jSONObject, String str) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                return com.byazt.sz.n.n(str).n(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
