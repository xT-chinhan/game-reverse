package com.byazt.ov;

import android.content.Context;
import android.net.Uri;
import com.byakv.z.TTEncryptUtils;
import com.byazt.km.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPTS_DIFF_LIST, 19})
public class n {
    public static JSONObject n(Context context, JSONObject jSONObject, boolean z) {
        byte[] bytes;
        JSONObject jSONObjectN;
        byte[] bytes2 = new byte[0];
        try {
            bytes2 = jSONObject.toString().getBytes("UTF-8");
            String strClientPackedBase64 = TTEncryptUtils.clientPackedBase64(bytes2, bytes2.length);
            if (com.byazt.nt.n.qg()) {
                com.byazt.nt.n.n("__kite", "请求体整体进行sword加密：加密内容：".concat(String.valueOf(jSONObject)));
                com.byazt.nt.n.s("__kite", "请求体整体进行sword加密：加密结果：".concat(String.valueOf(strClientPackedBase64)));
            }
            bytes = strClientPackedBase64.getBytes("UTF-8");
        } catch (Exception e) {
            com.byazt.nt.n.q("__kite", "error: " + e.getMessage());
            bytes = bytes2;
        }
        if (bytes == null) {
            com.byazt.nt.n.s("__kite", "data is null ");
            return new JSONObject();
        }
        try {
            jSONObjectN = n(context, Uri.parse("https://toblog.ctobsnssdk.com/service/2/device_sdk/kite/").buildUpon().appendQueryParameter("req_id", UUID.randomUUID().toString()).build().toString(), bytes, z);
        } catch (Exception e2) {
            com.byazt.nt.n.qg("__kiteerror " + e2.getMessage());
            jSONObjectN = null;
        }
        return jSONObjectN == null ? new JSONObject() : jSONObjectN;
    }

    public static JSONObject n(Context context, String str, byte[] bArr, boolean z) {
        String strN;
        try {
            if (sz.q()) {
                try {
                    strN = com.byazt.jy.n.n(context, str, bArr, null, false, false);
                } catch (RuntimeException e) {
                    com.byazt.nt.n.q("__kite", "error " + e.getMessage());
                    strN = com.byazt.jy.n.n(context, str, bArr, "application/json; charset=utf-8", true, true);
                }
            } else {
                try {
                    strN = com.byazt.jy.n.n(context, str, bArr, "application/json; charset=utf-8", false, true);
                } catch (Exception e2) {
                    com.byazt.nt.n.q("__kite", "error " + e2.getMessage());
                    strN = "";
                }
            }
        } catch (Exception e3) {
            com.byazt.nt.n.q("__kite", "network error " + e3.getMessage());
            strN = "";
        }
        try {
            return new JSONObject(strN);
        } catch (Exception e4) {
            com.byazt.nt.n.q("__kite", "error: " + e4.getMessage());
            return new JSONObject();
        }
    }
}
