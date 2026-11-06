package com.bytedance.sdk.openadsdk.c.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, Map<String, Map<String, Integer>>> f1877ms = new HashMap();

    /* JADX WARN: Code duplicated, block: B:46:0x00a1  */
    public static void ms(String str, lm lmVar) {
        if (TextUtils.isEmpty(str)) {
        }
        com.bytedance.sdk.openadsdk.core.w.ah ahVar = (com.bytedance.sdk.openadsdk.core.w.ah) AutoService.ms(com.bytedance.sdk.openadsdk.core.w.ah.class);
        if (ahVar == null || ahVar.ah()) {
            try {
                String strValueOf = String.valueOf(f.x(lmVar));
                String strMs = f.ms(lmVar, "-1");
                switch (str) {
                    case "load_video_start":
                        x(strValueOf, strMs);
                        break;
                    case "load_video_cancel":
                        hi(strValueOf, strMs);
                        break;
                    case "load_video_success":
                        ny(strValueOf, strMs);
                        break;
                    case "load_video_error":
                        ch(strValueOf, strMs);
                        break;
                    case "play_start":
                        xr(strValueOf, strMs);
                        break;
                    case "feed_play":
                        ah(strValueOf, strMs);
                        break;
                    case "feed_break":
                        c(strValueOf, strMs);
                        break;
                    case "feed_pause":
                        ka(strValueOf, strMs);
                        break;
                    case "feed_over":
                        d(strValueOf, strMs);
                        break;
                    case "play_error":
                        ab(strValueOf, strMs);
                        break;
                    case "show":
                        ms(strValueOf, strMs);
                        break;
                    default:
                        break;
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
    }

    private static void ms(String str, String str2) {
        ms(str, str2, "show_c");
    }

    private static void xr(String str, String str2) {
        ms(str, str2, "ps_c");
    }

    private static void ah(String str, String str2) {
        ms(str, str2, "fpl_c");
    }

    private static void d(String str, String str2) {
        ms(str, str2, "fo_c");
    }

    private static void ka(String str, String str2) {
        ms(str, str2, "fpu_c");
    }

    private static void c(String str, String str2) {
        ms(str, str2, "fb_c");
    }

    private static void ab(String str, String str2) {
        ms(str, str2, "pe_c");
    }

    private static void x(String str, String str2) {
        ms(str, str2, "lvs_c");
    }

    private static void ny(String str, String str2) {
        ms(str, str2, "lvsu_c");
    }

    private static void ch(String str, String str2) {
        ms(str, str2, "lve_c");
    }

    private static void hi(String str, String str2) {
        ms(str, str2, "lvc_c");
    }

    private static void ms(String str, String str2, String str3) {
        Map<String, Map<String, Integer>> map = f1877ms.get(str);
        if (map == null) {
            map = new HashMap<>();
            f1877ms.put(str, map);
        }
        Map<String, Integer> map2 = map.get(str2);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str2, map2);
        }
        Integer num = map2.get(str3);
        if (num == null) {
            map2.put(str3, 1);
        } else {
            map2.put(str3, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        if (f1877ms.isEmpty()) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : f1877ms.entrySet()) {
                String key = entry.getKey();
                Map<String, Map<String, Integer>> value = entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                if (value != null) {
                    for (Map.Entry<String, Map<String, Integer>> entry2 : value.entrySet()) {
                        String key2 = entry2.getKey();
                        Map<String, Integer> value2 = entry2.getValue();
                        JSONObject jSONObject3 = new JSONObject();
                        if (value2 != null) {
                            for (Map.Entry<String, Integer> entry3 : value2.entrySet()) {
                                jSONObject3.put(entry3.getKey(), entry3.getValue());
                            }
                        }
                        jSONObject2.put(key2, jSONObject3);
                    }
                }
                jSONObject.put(key, jSONObject2);
            }
        } catch (Exception e) {
            sl.ms(e);
        }
        return jSONObject;
    }
}
