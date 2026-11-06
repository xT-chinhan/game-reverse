package com.byazt.pr;

import android.support.v4.app.NotificationCompat;
import android.util.SparseArray;
import com.byazt.ca.cz;
import com.byazt.fi.BaseConstants;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.zq.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.qq.e.comm.pi.ACTD;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 37, 20})
public class hn implements Function<SparseArray<Object>, Object> {
    public static Function<SparseArray<Object>, Object> pr;

    private hn() {
    }

    public static hn pr() {
        return pr.pr;
    }

    public static void pr(Function<SparseArray<Object>, Object> function) {
        pr = function;
        hw();
    }

    private static void hw() {
        if (pr == null) {
            return;
        }
        cz.pr().pr(true);
        cz.pr().pr(new cz.pr() { // from class: com.byazt.pr.hn.1
            @Override // com.byazt.ca.cz.pr
            public void pr(int i, Map<String, Object> map) {
                if (map != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        for (String str : map.keySet()) {
                            jSONObject.put(str, map.get(str));
                        }
                        hn.pr(1, jSONObject);
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    public static void pr(String str, JSONObject jSONObject) {
        if (pr == null || !zo.nt().i()) {
            return;
        }
        JSONObject jSONObjectHw = hw(str, jSONObject);
        com.byazt.xi.hw hwVarPr = com.byazt.xi.hw.pr();
        hwVarPr.pr(10001).pr(Void.class);
        hwVarPr.pr(20001, jSONObjectHw);
        pr.apply(hwVarPr.hw());
    }

    private static JSONObject hw(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject.has("log_extra") && jSONObject.has(Constants.VALUE_FIELD) && jSONObject.has("category")) {
                jSONObject2.putOpt(NotificationCompat.CATEGORY_EVENT, str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("params");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject2.putOpt("params", jSONObjectOptJSONObject);
                }
                pr(jSONObject, jSONObjectOptJSONObject, "tag");
                pr(jSONObject, jSONObjectOptJSONObject, "category");
                pr(jSONObject, jSONObjectOptJSONObject, "log_extra");
                pr(jSONObject, jSONObjectOptJSONObject, Constants.VALUE_FIELD);
                pr(jSONObject, jSONObjectOptJSONObject, "ext_value");
                pr(jSONObject, jSONObjectOptJSONObject, BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            } else {
                jSONObject2.putOpt("type", str);
                pr(jSONObject, jSONObject2, "os_api");
                pr(jSONObject, jSONObject2, "ad_sdk_version");
                pr(jSONObject, jSONObject2, "app_version");
                pr(jSONObject, jSONObject2, "timestamp");
                pr(jSONObject, jSONObject2, ACTD.APPID_KEY);
                pr(jSONObject, jSONObject2, "is_plugin");
                pr(jSONObject, jSONObject2, "conn_type");
                pr(jSONObject, jSONObject2, "device_info");
                pr(jSONObject, jSONObject2, "event_extra");
            }
            return jSONObject2;
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    private static void pr(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Object objOpt;
        if (jSONObject != null && jSONObject2 != null && (objOpt = jSONObject.opt(str)) != null && objOpt != JSONObject.NULL) {
            try {
                jSONObject2.putOpt(str, objOpt);
            } catch (JSONException e) {
            }
        }
    }

    public static void pr(int i, JSONObject jSONObject) {
        if (pr != null) {
            com.byazt.xi.hw hwVarPr = com.byazt.xi.hw.pr();
            hwVarPr.pr(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2).pr(Void.class);
            hwVarPr.pr(20004, Integer.valueOf(i));
            hwVarPr.pr(20005, jSONObject);
            pr.apply(hwVarPr.hw());
        }
    }

    private void pr(Map<String, String> map) {
        c cVar = a.hw().uc;
        if (map != null && cVar != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                cVar.pr(entry.getKey() + "_qa_modify_setting", entry.getValue());
            }
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        if (pluginValueSetHw.intValue(-99999987) == 10003) {
            pr((Map<String, String>) pluginValueSetHw.objectValue(20003, Map.class));
            return null;
        }
        return null;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 37, 116})
    private static class pr {
        public static final hn pr = new hn();
    }
}
