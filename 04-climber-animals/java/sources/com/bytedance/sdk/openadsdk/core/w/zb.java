package com.bytedance.sdk.openadsdk.core.w;

import android.text.TextUtils;
import com.anythink.core.common.e.a;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.umeng.analytics.pro.bv;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ConcurrentHashMap<String, JSONObject> f3692ms = new ConcurrentHashMap<>();
    private static AtomicInteger xr = new AtomicInteger();
    private JSONObject ah;
    private JSONObject d;

    private static String ms(int i, String str) {
        return i + "-" + t.ah() + "-" + xr.incrementAndGet() + "-" + str + "-" + System.currentTimeMillis();
    }

    private static JSONObject ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f3692ms.get(str);
    }

    public static void ms(int i, long j, lm lmVar, com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt;
        if (lmVar == null || dVar == null || (xrVarRt = lmVar.rt()) == null) {
            return;
        }
        try {
            JSONObject jSONObjectMs = ms(xrVarRt.d());
            if (jSONObjectMs != null) {
                String strH = dVar.h();
                String strOptString = jSONObjectMs.optString("trace_id");
                if (!TextUtils.isEmpty(strOptString) && strOptString.contains(strH)) {
                    jSONObjectMs.put("play_type", i);
                    jSONObjectMs.put("cache_size", j);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static void ms(long j, lm lmVar, com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt;
        if (lmVar == null || dVar == null || (xrVarRt = lmVar.rt()) == null) {
            return;
        }
        try {
            JSONObject jSONObjectMs = ms(xrVarRt.d());
            if (jSONObjectMs != null) {
                String strOptString = jSONObjectMs.optString("trace_id");
                if (!TextUtils.isEmpty(strOptString) && strOptString.contains(dVar.h())) {
                    jSONObjectMs.put("play_duration", j);
                    jSONObjectMs.put("pitaya_meet_cache", 1);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private JSONObject xr(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            lm lmVarMs = com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVar);
            if (lmVarMs != null) {
                String strMs = f.ms(lmVarMs, "");
                int i = !TextUtils.isEmpty(strMs) ? Integer.parseInt(strMs) : 0;
                int iX = f.x(lmVarMs);
                jSONObject.put("video_count", com.bytedance.sdk.openadsdk.c.xr.xr.ms());
                JSONObject jSONObjectMs = ms();
                jSONObject.put("device", jSONObjectMs);
                JSONObject jSONObjectMs2 = ms(dVar, i, iX);
                jSONObject.put("current_video", jSONObjectMs2);
                jSONObject.put("predict_use", ms(String.valueOf(i)));
                jSONObject.put("csj_plugin", xr());
                jSONObject.put("package", xr("video_cache"));
                jSONObject.put(a.C0080a.l, jSONObjectMs.optInt(a.C0080a.l));
                jSONObject.put("video_size", dVar.sl());
                jSONObject.put("rit", i);
                jSONObject.put("preload_size", dVar.c());
                jSONObject.put(bv.Q, jSONObjectMs.optString(bv.Q));
                jSONObject.put("sdk_fg_time", jSONObjectMs.optLong("sdk_fg_time"));
                jSONObject.put("ad_slot_type", jSONObjectMs2.optInt("ad_slot_type"));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
        return jSONObject;
    }

    private JSONObject xr(final String str) {
        ah ahVar = (ah) AutoService.ms(ah.class);
        if (ahVar != null) {
            ahVar.ms(str, new ab() { // from class: com.bytedance.sdk.openadsdk.core.w.zb.1
                @Override // com.bytedance.sdk.openadsdk.core.w.ab
                protected ValueSet ms(int i, Result result) {
                    if (result == null) {
                        return null;
                    }
                    ValueSet valueSetValues = result.values();
                    boolean zIsSuccess = result.isSuccess();
                    if (valueSetValues != null) {
                        if (TextUtils.equals(str, valueSetValues.stringValue(5))) {
                            if (zIsSuccess) {
                                zb.this.ah = (JSONObject) valueSetValues.objectValue(3, JSONObject.class);
                                Object[] objArr = new Object[1];
                                JSONObject unused = zb.this.ah;
                            } else {
                                zb.this.d = (JSONObject) valueSetValues.objectValue(4, JSONObject.class);
                            }
                        }
                    }
                    return super.ms(i, result);
                }
            });
        } else {
            this.ah = new JSONObject();
        }
        return this.ah;
    }

    private JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(bv.Q, u.ab(re.getContext()));
            jSONObject.put(a.C0080a.l, Calendar.getInstance().get(11));
            long jCurrentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.jw.ms.xr;
            if (jCurrentTimeMillis > 0) {
                jSONObject.put("sdk_fg_time", jCurrentTimeMillis);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }

    private JSONObject ms(com.bykv.vk.openvk.component.video.api.ah.d dVar, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_size", dVar.sl());
            jSONObject.put("preload_size", dVar.c());
            jSONObject.put("video_duration", dVar.w().c());
            jSONObject.put("ad_slot_type", i2);
            jSONObject.put("rit", i);
            jSONObject.put("video_url", dVar.ao());
            jSONObject.put("preload_all", dVar.zb());
            jSONObject.put("trace_id", ms(i, dVar.h()));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }

    public static void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar, JSONObject jSONObject, int i, int i2) {
        int iOptInt;
        if (dVar == null || jSONObject == null || (iOptInt = jSONObject.optInt("rit", 0)) <= 0) {
            return;
        }
        f3692ms.put(String.valueOf(iOptInt), jSONObject);
    }

    private JSONObject xr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_api_code", g.xr);
            jSONObject.put("core_plugin_code", 6923);
            jSONObject.put("ext_api_code", g.d);
            jSONObject.put("ext_plugin_code", jw.xr());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }

    public JSONObject ms(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        return xr(dVar);
    }
}
