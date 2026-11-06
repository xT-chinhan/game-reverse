package com.byazt.twu;

import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.f.e;
import com.byazt.gwu.l;
import com.byazt.ho.BaseConstants;
import com.byazt.nf.rv;
import com.byazt.tk.py;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1641, 5})
public class q implements Function<SparseArray<Object>, Object> {
    public static Function<SparseArray<Object>, Object> n;

    private q() {
    }

    public static q n() {
        return n.n;
    }

    public static void n(Function<SparseArray<Object>, Object> function) {
        n = function;
        qg();
    }

    private static void qg() {
        if (n == null) {
            return;
        }
        py.n().n(true);
        py.n().n(new py.n() { // from class: com.byazt.twu.q.1
            @Override // com.byazt.tk.py.n
            public void n(int i, Map<String, Object> map) {
                if (map != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        for (String str : map.keySet()) {
                            jSONObject.put(str, map.get(str));
                        }
                        q.n(1, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    public static void n(String str, JSONObject jSONObject) {
        if (n == null || !com.byazt.vyf.s.cy().sh()) {
            return;
        }
        JSONObject jSONObjectQg = qg(str, jSONObject);
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        qgVarN.n(10001).n(Void.class);
        qgVarN.n(20001, jSONObjectQg);
        n.apply(qgVarN.qg());
    }

    private static JSONObject qg(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject.has("log_extra") && jSONObject.has(e.a.d) && jSONObject.has("category")) {
                jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject2.putOpt("params", jSONObjectOptJSONObject);
                }
                n(jSONObject, jSONObjectOptJSONObject, "tag");
                n(jSONObject, jSONObjectOptJSONObject, "category");
                n(jSONObject, jSONObjectOptJSONObject, "log_extra");
                n(jSONObject, jSONObjectOptJSONObject, e.a.d);
                n(jSONObject, jSONObjectOptJSONObject, "ext_value");
                n(jSONObject, jSONObjectOptJSONObject, "show_time");
                n(jSONObject, jSONObjectOptJSONObject, "ttdsp_price");
                n(jSONObject, jSONObjectOptJSONObject, BaseConstants.EVENT_LABEL_IS_AD_EVENT);
                n(jSONObject, jSONObjectOptJSONObject, BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            } else {
                jSONObject2.putOpt("type", str);
                n(jSONObject, jSONObject2, "os_api");
                n(jSONObject, jSONObject2, "ad_sdk_version");
                n(jSONObject, jSONObject2, "app_version");
                n(jSONObject, jSONObject2, TapEventParamConstants.PARAM_SUB_TIMESTAMP);
                n(jSONObject, jSONObject2, ACTD.APPID_KEY);
                n(jSONObject, jSONObject2, "is_plugin");
                n(jSONObject, jSONObject2, "conn_type");
                n(jSONObject, jSONObject2, "device_info");
                n(jSONObject, jSONObject2, "event_extra");
            }
            return jSONObject2;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private static void n(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Object objOpt;
        if (jSONObject == null || jSONObject2 == null || (objOpt = jSONObject.opt(str)) == null || objOpt == JSONObject.NULL) {
            return;
        }
        try {
            jSONObject2.putOpt(str, objOpt);
        } catch (JSONException unused) {
        }
    }

    public static void n(int i, JSONObject jSONObject) {
        if (n != null) {
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
            qgVarN.n(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2).n(Void.class);
            qgVarN.n(20004, Integer.valueOf(i));
            qgVarN.n(20005, jSONObject);
            n.apply(qgVarN.qg());
        }
    }

    private void n(Map<String, String> map) {
        l lVar = rv.qg().w;
        if (map == null || lVar == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            lVar.n(entry.getKey() + "_qa_modify_setting", entry.getValue());
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        if (pluginValueSetQg.intValue(-99999987) != 10003) {
            return null;
        }
        n((Map<String, String>) pluginValueSetQg.objectValue(20003, Map.class));
        return null;
    }

    @com.byazt.cp.n(n = {0, 1, 1641, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n {
        public static final q n = new q();
    }
}
