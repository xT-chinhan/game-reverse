package com.byazt.wt;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 101})
public class qa {
    public static final String pr = null;
    public static long hw = -1;

    public static JSONArray pr(final Context context) {
        if (System.currentTimeMillis() - hw <= 1000) {
            return null;
        }
        hw = System.currentTimeMillis();
        if (!com.byazt.is.zo.c() || !hw() || !com.byazt.sd.a.hw().jo() || !com.byazt.sd.zo.nt().yb().hw()) {
            return null;
        }
        com.byazt.xlm.c.pr(new com.byazt.xlm.fw("getIncrementalInstallApps") { // from class: com.byazt.wt.qa.1
            @Override // java.lang.Runnable
            public void run() {
                qa.hn(context);
            }
        }, 1);
        return pr();
    }

    private static JSONArray pr() {
        try {
            String strHw = com.byazt.sd.hw.pr().hw("install_app_incremental_string", pr);
            if (!TextUtils.isEmpty(strHw)) {
                return new JSONArray((Collection) x(strHw));
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(Context context) {
        try {
            List<String> listPr = com.byazt.is.hn.hw().pr(context);
            if (listPr != null && !listPr.isEmpty()) {
                List<String> listX = x(com.byazt.sd.hw.pr().hw("install_app_string", pr));
                hw(pr(listPr));
                if (listX != null && !listX.isEmpty()) {
                    listPr.removeAll(listX);
                }
                hn(pr(listPr));
            }
        } catch (Exception e) {
        }
    }

    private static void hw(String str) {
        com.byazt.sd.hw.pr().pr("install_app_string", str);
    }

    private static void hn(String str) {
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        hnVarPr.pr("install_app_incremental_string", str);
        hnVarPr.pr("apptime", System.currentTimeMillis());
    }

    private static boolean hw() {
        long jHw = com.byazt.sd.hw.pr().hw("apptime", -1L);
        return jHw == -1 || System.currentTimeMillis() - jHw > 43200000;
    }

    private static List<String> x(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    private static String pr(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            pr(0, 0, null);
            return false;
        }
        if (!ls.b() || ls.hw(str)) {
            return false;
        }
        pr(0, 0, null);
        return false;
    }

    private static void pr(final int i, final int i2, final String str) {
        com.byazt.xk.hw.pr().pr("call_active_api", new com.byazt.ttf.pr() { // from class: com.byazt.wt.qa.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("call_api_status", i);
                    jSONObject2.put("has_actived", i2);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject2.put(Constants.ERROR_MSG_FIELD, str);
                    }
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }
}
