package com.byazt.da;

import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.zp.m;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1572, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static int hw;
    public static String pr;

    public static void pr() {
        if (!hw() || !zo.nt().n() || !hn()) {
            return;
        }
        zo.nt().s();
    }

    public static boolean hw() {
        return true;
    }

    public static boolean hn() {
        JSONObject jSONObjectFu = a.hw().fu();
        return jSONObjectFu == null || jSONObjectFu.optInt("can_req_plugin", 1) == 1;
    }

    public static String x() {
        if (!TextUtils.isEmpty(pr)) {
            return pr;
        }
        try {
            Object objInvoke = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                pr = str;
                return str;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static int c() {
        if (hw == 0) {
            hw = m.hn("com.byted.mixed");
        }
        return hw;
    }

    public static void pr(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            pr prVar = (pr) uc.pr("adapter_dex");
            if (prVar != null) {
                Map<String, Map<String, Object>> mapPr = prVar.pr();
                Map<String, Object> concurrentHashMap = mapPr.get(str);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    mapPr.put(str, concurrentHashMap);
                } else {
                    Object obj = concurrentHashMap.get(str2);
                    int iIntValue = obj == null ? 0 : ((Integer) obj).intValue();
                    if (iIntValue != 0 && iIntValue >= i) {
                        return;
                    }
                }
                concurrentHashMap.put(str2, Integer.valueOf(i));
            }
        } catch (Throwable th) {
        }
    }

    public static void pr(String str, int i) {
        pr("common_dex", str, i);
    }
}
