package com.byazt.cqx;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Key;
import com.byakv.z.TTEncryptUtils;
import com.byazt.ec.g;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1845, 37})
public class pr {
    public static JSONObject pr(Context context, JSONObject jSONObject, boolean z) {
        byte[] bytes;
        JSONObject jSONObjectPr;
        byte[] bytes2 = new byte[0];
        try {
            bytes2 = jSONObject.toString().getBytes(Key.STRING_CHARSET_NAME);
            String strClientPackedBase64 = TTEncryptUtils.clientPackedBase64(bytes2, bytes2.length);
            if (com.byazt.wx.pr.hw()) {
                com.byazt.wx.pr.pr("__kite", "请求体整体进行sword加密：加密内容：".concat(String.valueOf(jSONObject)));
                com.byazt.wx.pr.hn("__kite", "请求体整体进行sword加密：加密结果：".concat(String.valueOf(strClientPackedBase64)));
            }
            bytes = strClientPackedBase64.getBytes(Key.STRING_CHARSET_NAME);
        } catch (Exception e) {
            com.byazt.wx.pr.x("__kite", "error: " + e.getMessage());
            bytes = bytes2;
        }
        if (bytes == null) {
            com.byazt.wx.pr.hn("__kite", "data is null ");
            return new JSONObject();
        }
        try {
            jSONObjectPr = pr(context, Uri.parse("https://toblog.ctobsnssdk.com/service/2/device_sdk/kite/").buildUpon().appendQueryParameter("req_id", UUID.randomUUID().toString()).build().toString(), bytes, z);
        } catch (Exception e2) {
            com.byazt.wx.pr.hw("__kiteerror " + e2.getMessage());
            jSONObjectPr = null;
        }
        if (jSONObjectPr == null) {
            return new JSONObject();
        }
        return jSONObjectPr;
    }

    public static JSONObject pr(Context context, String str, byte[] bArr, boolean z) {
        String strPr;
        try {
            if (g.x()) {
                try {
                    strPr = com.byazt.yj.pr.pr(context, str, bArr, null, false, false);
                } catch (RuntimeException e) {
                    com.byazt.wx.pr.x("__kite", "error " + e.getMessage());
                    strPr = com.byazt.yj.pr.pr(context, str, bArr, "application/json; charset=utf-8", true, true);
                }
            } else {
                try {
                    strPr = com.byazt.yj.pr.pr(context, str, bArr, "application/json; charset=utf-8", false, true);
                } catch (Exception e2) {
                    com.byazt.wx.pr.x("__kite", "error " + e2.getMessage());
                    strPr = "";
                }
            }
        } catch (Exception e3) {
            com.byazt.wx.pr.x("__kite", "network error " + e3.getMessage());
            strPr = "";
        }
        try {
            return new JSONObject(strPr);
        } catch (Exception e4) {
            com.byazt.wx.pr.x("__kite", "error: " + e4.getMessage());
            return new JSONObject();
        }
    }
}
