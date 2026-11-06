package com.bytedance.sdk.openadsdk.core.live.ms;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.e.f;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.am;
import com.bytedance.sdk.openadsdk.core.nw.az;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.umeng.analytics.pro.g;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends com.bytedance.sdk.openadsdk.core.live.ms.ms {
    protected volatile SoftReference<lm> c;
    protected String d;
    protected String ka;

    protected interface ms {
        void ms(boolean z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    @Deprecated
    public int b_(lm lmVar) {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(lm lmVar, ah ahVar, String str) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms
    protected boolean w_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms, com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(Bridge bridge) {
        super.ms(bridge);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms
    public void a_(String str) {
        this.ka = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(final Context context, final lm lmVar, final Map<String, Object> map) {
        d(lmVar);
        if (!a_(lmVar)) {
            return 6;
        }
        sl.ms("TTLiveSDkBridge", "openLive key:" + lmVar.da());
        final String str = map != null ? (String) map.get("event_tag") : "";
        final int iKu = lmVar.ku();
        if (!c()) {
            ms(lmVar, str, iKu, 1, iKu == 7 ? 1 : 2);
            return 1;
        }
        lmVar.xg();
        if (this.f2845ms == null) {
            return 4;
        }
        this.xr = str;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (ka() != 2 ? ms(lmVar, new ms() { // from class: com.bytedance.sdk.openadsdk.core.live.ms.c.1
            @Override // com.bytedance.sdk.openadsdk.core.live.ms.c.ms
            public void ms(boolean z) {
                boolean z2;
                if (atomicBoolean.compareAndSet(false, true)) {
                    c cVar = c.this;
                    cVar.ms(context, lmVar, iKu, cVar.xr, (Map<String, Object>) map);
                    z2 = false;
                } else {
                    z2 = true;
                }
                u.ms().ms(lmVar, System.currentTimeMillis() - jCurrentTimeMillis, z, z2);
            }
        }, true) : false) {
            am amVarMg = lmVar.mg();
            if (amVarMg != null) {
                long jKa = amVarMg.ka();
                if (jKa > 0) {
                    x.ah().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.ms.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                c.this.ms(context, lmVar, iKu, str, (Map<String, Object>) map);
                            }
                        }
                    }, jKa);
                }
                if (amVarMg.c() == 1 && ch.ub().d() != null) {
                    new com.bytedance.sdk.openadsdk.core.zb.ab().ms(new com.bytedance.sdk.openadsdk.core.zb.ab.ms() { // from class: com.bytedance.sdk.openadsdk.core.live.ms.c.3
                        @Override // com.bytedance.sdk.openadsdk.core.zb.ab.ms
                        public void ms(boolean z) {
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.zb.ab.ms
                        public void ms() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                c.this.ms(context, lmVar, iKu, str, (Map<String, Object>) map);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.zb.ab.ms
                        public void ms(String str2) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                c.this.ms(context, lmVar, iKu, str, (Map<String, Object>) map);
                            }
                        }
                    });
                }
            }
            return 0;
        }
        return ms(context, lmVar, iKu, str, map);
    }

    protected boolean ms(lm lmVar, final ms msVar, boolean z) {
        am amVarMg;
        if (this.ka == null || (amVarMg = lmVar.mg()) == null || amVarMg.ah() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(this.ka.replaceAll("\\.", "")) < 211413) {
                return false;
            }
        } catch (Exception unused) {
        }
        int iXr = amVarMg.xr();
        boolean z2 = iXr > 0;
        if (z) {
            z2 = iXr == 3;
        }
        if (z2) {
            this.c = new SoftReference<>(lmVar);
            if (ms(new com.bytedance.sdk.openadsdk.core.live.xr.xr() { // from class: com.bytedance.sdk.openadsdk.core.live.ms.c.4
                @Override // com.bytedance.sdk.openadsdk.core.live.xr.xr
                protected void ms(Object obj) {
                    boolean z3 = false;
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        if (map.containsKey("code")) {
                            Object obj2 = map.get("code");
                            if (obj2 instanceof String) {
                                try {
                                    int i = Integer.parseInt((String) obj2);
                                    z3 = i == 1;
                                    sl.ms("TTLiveSDkBridge", "requestDyAuth result:".concat(String.valueOf(i)));
                                } catch (NumberFormatException unused2) {
                                }
                            }
                        }
                    }
                    msVar.ms(z3);
                }
            }, iXr == 3) == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ms(Context context, lm lmVar, int i, String str, Map<String, Object> map) {
        int iIntValue;
        int i2;
        int i3;
        int i4;
        sl.ms("TTLiveSDkBridge", "openLive key:" + lmVar.xg());
        int i5 = 1;
        if (this.f2845ms != null) {
            int iAh = 0;
            iIntValue = ((Integer) this.f2845ms.call(0, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(g.X, context).ms("bundle", ah(context, lmVar, map))).xr(), Integer.class)).intValue();
            this.xr = str;
            this.d = lmVar.da();
            if (iIntValue == 0) {
                this.c = new SoftReference<>(lmVar);
                int iMs = com.bytedance.sdk.openadsdk.core.live.ka.ah.ms(map);
                if (iMs == 101 || iMs == 102) {
                    iIntValue |= iMs << 8;
                    i4 = i;
                } else if (ms(lmVar, iMs)) {
                    iAh = ah(lmVar);
                    i = 7;
                    if (iAh == 0) {
                        try {
                            new com.bytedance.sdk.openadsdk.core.live.ah.ms().ms(str).ms(context, lmVar);
                            iIntValue |= iMs << 8;
                        } catch (Exception e) {
                            sl.ms(e);
                        }
                        i4 = i;
                    } else {
                        i4 = 2;
                    }
                } else {
                    i4 = i;
                }
                i5 = iAh;
            } else {
                i5 = 3;
                i4 = i;
            }
            i3 = i4;
            i2 = i;
        } else {
            iIntValue = 4;
            i2 = i;
            i3 = i2;
        }
        ms(lmVar, str, i2, i3, i5);
        return iIntValue;
    }

    /* JADX WARN: Code duplicated, block: B:118:0x01af  */
    /* JADX WARN: Code duplicated, block: B:120:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:123:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:126:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:130:0x0212 A[Catch: Exception -> 0x02be, TryCatch #5 {Exception -> 0x02be, blocks: (B:128:0x01eb, B:130:0x0212, B:131:0x0265, B:133:0x0294, B:134:0x0297, B:136:0x02a3, B:137:0x02a9), top: B:177:0x01eb }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0294 A[Catch: Exception -> 0x02be, TryCatch #5 {Exception -> 0x02be, blocks: (B:128:0x01eb, B:130:0x0212, B:131:0x0265, B:133:0x0294, B:134:0x0297, B:136:0x02a3, B:137:0x02a9), top: B:177:0x01eb }] */
    /* JADX WARN: Code duplicated, block: B:136:0x02a3 A[Catch: Exception -> 0x02be, TryCatch #5 {Exception -> 0x02be, blocks: (B:128:0x01eb, B:130:0x0212, B:131:0x0265, B:133:0x0294, B:134:0x0297, B:136:0x02a3, B:137:0x02a9), top: B:177:0x01eb }] */
    /* JADX WARN: Code duplicated, block: B:143:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:148:0x02f9 A[Catch: Exception -> 0x031b, TRY_LEAVE, TryCatch #6 {Exception -> 0x031b, blocks: (B:146:0x02f3, B:148:0x02f9), top: B:179:0x02f3 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0331 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:154:0x0332  */
    /* JADX WARN: Code duplicated, block: B:156:0x033c  */
    /* JADX WARN: Code duplicated, block: B:158:0x0348  */
    /* JADX WARN: Code duplicated, block: B:160:0x0355  */
    /* JADX WARN: Code duplicated, block: B:179:0x02f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    /* JADX WARN: Code duplicated, block: B:189:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00e6 A[PHI: r3
      0x00e6: PHI (r3v25 org.json.JSONObject) = (r3v19 org.json.JSONObject), (r3v24 org.json.JSONObject) binds: [B:57:0x00da, B:58:0x00dc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x0112  */
    /* JADX WARN: Code duplicated, block: B:77:0x011a A[Catch: Exception -> 0x0128, TryCatch #7 {Exception -> 0x0128, blocks: (B:68:0x00f6, B:77:0x011a, B:79:0x0124), top: B:181:0x00f6 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0124 A[Catch: Exception -> 0x0128, TRY_LEAVE, TryCatch #7 {Exception -> 0x0128, blocks: (B:68:0x00f6, B:77:0x011a, B:79:0x0124), top: B:181:0x00f6 }] */
    private Bundle ah(Context context, lm lmVar, Map<String, Object> map) {
        int i;
        int i2;
        int i3;
        int i4;
        String strCs;
        Map<String, Object> map2;
        Uri uri;
        JSONObject jSONObject;
        String strOptString;
        HashMap map3;
        JSONObject jSONObject2;
        String strMs;
        String strMs2;
        JSONArray jSONArrayX;
        int i5;
        JSONObject jSONObject3;
        int i6;
        int i7;
        int i8;
        String string;
        Object obj;
        long jLongValue;
        Bundle bundle = new Bundle();
        if (lmVar != null) {
            try {
                bundle.putLong("room_id", Long.parseLong(lmVar.eo()));
            } catch (Exception e) {
                sl.ms(e);
            }
            Bundle bundle2 = new Bundle();
            h hVarTc = lmVar.tc();
            int iMs = com.bytedance.sdk.openadsdk.core.live.ka.ah.ms(map);
            am amVarMg = lmVar.mg();
            if (amVarMg == null || amVarMg.ah() != 0) {
                i = iMs;
            } else {
                int iXr = amVarMg.xr();
                if (iXr == 1) {
                    i = 101;
                } else if (iXr == 3) {
                    i = 104;
                } else {
                    i = iMs;
                }
            }
            int iKu = lmVar.ku();
            int iKa = ka(lmVar);
            az azVarMl = lmVar.ml();
            String str = "live_auto_auth_login_source";
            String strMs3 = null;
            if (!com.bytedance.sdk.openadsdk.core.xr.ms.xr.c.xr(i)) {
                str = "live_auto_auth_login_source";
                if (iKa > 0 && ka() != 2) {
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        try {
                            i.ms(lmVar.da(), new Integer(1), Integer.class);
                            jSONObject4.put("auth_reward_gold", iKa);
                            bundle2.putString("live_auth_extra_info", jSONObject4.toString());
                        } catch (JSONException e2) {
                            e = e2;
                            i4 = 1;
                            Object[] objArr = new Object[i4];
                            objArr[0] = e;
                            sl.xr("TTLiveSDkBridge", objArr);
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        i4 = 1;
                    }
                } else if (ah(lmVar) == 0) {
                    if (lmVar.ku() == 7) {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                    } else if (lmVar.ku() == 8) {
                        bundle2.putInt("live_popup_dou_deeplink_dialog", 1);
                        bundle2.putString("live_popup_dou_deeplink_url", hVarTc != null ? hVarTc.xr() : "");
                    }
                }
                i2 = iKu;
                i3 = -1;
            } else if (i == 101 || i == 102 || i == 104) {
                try {
                    jSONObject3 = new JSONObject();
                    if (azVarMl != null) {
                        if (i == 101) {
                            i6 = 1;
                        } else {
                            i6 = i == 104 ? 3 : 2;
                        }
                        try {
                            jSONObject3.put("live_auto_auth_login_source", i6);
                            int i9 = i;
                            int i10 = i6;
                            try {
                                jSONObject3.put("live_auto_auth_success_has_ticket", com.bytedance.sdk.openadsdk.core.live.ka.ah.ms(lmVar.cs()));
                                jSONObject3.put("live_auto_auth_promotion_id", azVarMl.xr());
                                i = i9;
                                i6 = i10;
                                if (iKa <= 0) {
                                    i7 = i;
                                    str = "live_auto_auth_login_source";
                                    i8 = i6;
                                } else if (jSONObject3 == null) {
                                    try {
                                        jSONObject3 = new JSONObject();
                                        i7 = i;
                                        try {
                                            i8 = i6;
                                            try {
                                                str = "live_auto_auth_login_source";
                                                try {
                                                    try {
                                                        i.ms(lmVar.da(), new Integer(1), Integer.class);
                                                        jSONObject3.put("auth_reward_gold", iKa);
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        i = i7;
                                                        i6 = i8;
                                                        i5 = 1;
                                                        Object[] objArr2 = new Object[i5];
                                                        objArr2[0] = e;
                                                        sl.xr("TTLiveSDkBridge", objArr2);
                                                        i3 = i6;
                                                        i2 = i;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    i = i7;
                                                    i5 = 1;
                                                    i6 = i8;
                                                    Object[] objArr3 = new Object[i5];
                                                    objArr3[0] = e;
                                                    sl.xr("TTLiveSDkBridge", objArr3);
                                                    i3 = i6;
                                                    i2 = i;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                str = "live_auto_auth_login_source";
                                                i = i7;
                                                i6 = i8;
                                                i5 = 1;
                                                Object[] objArr4 = new Object[i5];
                                                objArr4[0] = e;
                                                sl.xr("TTLiveSDkBridge", objArr4);
                                                i3 = i6;
                                                i2 = i;
                                                if (azVarMl != null) {
                                                    if (!TextUtils.isEmpty(azVarMl.ab())) {
                                                        bundle2.putString("live_csj_libra_param", azVarMl.ab());
                                                    }
                                                    jSONArrayX = azVarMl.x();
                                                    if (jSONArrayX != null) {
                                                        ms(jSONArrayX, lmVar);
                                                        bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                                        bundle.putString("live_tob_task_key", lmVar.da());
                                                    }
                                                }
                                                if (hVarTc != null) {
                                                    try {
                                                        uri = Uri.parse(hVarTc.xr());
                                                        jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                                                        strOptString = jSONObject.optString("log_extra");
                                                        map3 = new HashMap();
                                                        jSONObject2 = new JSONObject();
                                                        if (!TextUtils.isEmpty(strOptString)) {
                                                            JSONObject jSONObject5 = new JSONObject(strOptString);
                                                            jSONObject5.put("ad_event_aid", jSONObject.optString("aid"));
                                                            jSONObject5.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "source"));
                                                            jSONObject5.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "gd_label"));
                                                            jSONObject5.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "union_user_id"));
                                                            jSONObject5.put("ad_event_app_siteid", ch.ub().t());
                                                            jSONObject5.put("ad_event_live_type", "1");
                                                            map3.put("log_extra", jSONObject5.toString());
                                                            jSONObject2.put("log_extra", jSONObject5.toString());
                                                        }
                                                        String strOptString2 = jSONObject.optString("cid");
                                                        jSONObject2.put("creativeID", strOptString2);
                                                        bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                                                        map3.put("is_other_channel", "union_ad");
                                                        map3.put(f.a.d, strOptString2);
                                                        bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                                                        strMs = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "pangle_live_room_data");
                                                        if (!TextUtils.isEmpty(strMs)) {
                                                            bundle.putString("pangle_live_room_data", strMs);
                                                        }
                                                        strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "owner_open_id");
                                                        if (TextUtils.isEmpty(strMs2)) {
                                                            strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "user_id");
                                                        }
                                                        bundle2.putString("anchor_id", strMs2);
                                                        bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "request_id"));
                                                        strMs3 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "enter_from_merge");
                                                    } catch (Exception e7) {
                                                        sl.ms(e7);
                                                    }
                                                }
                                                if (TextUtils.isEmpty(strMs3)) {
                                                    strMs3 = ms(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar));
                                                }
                                                bundle2.putString("enter_from_merge", strMs3);
                                                bundle2.putString("enter_method", xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar)));
                                                bundle2.putInt("live_pangle_interaction_type", i2);
                                                bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                                strCs = lmVar.cs();
                                                if (i3 != -1) {
                                                    try {
                                                        if (!TextUtils.isEmpty(strCs)) {
                                                            JSONObject jSONObject6 = new JSONObject(strCs);
                                                            JSONObject jSONObjectOptJSONObject = jSONObject6.optJSONObject("enter_request");
                                                            JSONObject jSONObject7 = new JSONObject();
                                                            jSONObject7.put(str, i3);
                                                            jSONObjectOptJSONObject.put("live_commerce_sdk_custom_params", jSONObject7);
                                                            jSONObject6.remove("enter_request");
                                                            jSONObject6.put("enter_request", jSONObjectOptJSONObject);
                                                            strCs = jSONObject6.toString();
                                                        }
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                                map2 = map;
                                                bundle.putString("ecom_live_params", ms(lmVar, strCs, map2));
                                                if (lmVar.or() == null) {
                                                    return bundle;
                                                }
                                                obj = map2.get("reward_countdown");
                                                if (obj instanceof Long) {
                                                    jLongValue = ((Long) obj).longValue();
                                                    if (jLongValue > 0) {
                                                        bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                                        bundle.putInt("android.app.activity.request_code", 1);
                                                        if (map2 != null) {
                                                            bundle.putInt("live_popup_reward_auth", 1);
                                                            sl.ms("rewardAuthFlag", "liv pop rew auth:  1");
                                                        }
                                                    }
                                                }
                                                return bundle;
                                            }
                                        } catch (Exception e8) {
                                            e = e8;
                                            str = "live_auto_auth_login_source";
                                            i = i7;
                                            i5 = 1;
                                            Object[] objArr5 = new Object[i5];
                                            objArr5[0] = e;
                                            sl.xr("TTLiveSDkBridge", objArr5);
                                            i3 = i6;
                                            i2 = i;
                                            if (azVarMl != null) {
                                                if (!TextUtils.isEmpty(azVarMl.ab())) {
                                                    bundle2.putString("live_csj_libra_param", azVarMl.ab());
                                                }
                                                jSONArrayX = azVarMl.x();
                                                if (jSONArrayX != null) {
                                                    ms(jSONArrayX, lmVar);
                                                    bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                                    bundle.putString("live_tob_task_key", lmVar.da());
                                                }
                                            }
                                            if (hVarTc != null) {
                                                uri = Uri.parse(hVarTc.xr());
                                                jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                                                strOptString = jSONObject.optString("log_extra");
                                                map3 = new HashMap();
                                                jSONObject2 = new JSONObject();
                                                if (!TextUtils.isEmpty(strOptString)) {
                                                    JSONObject jSONObject8 = new JSONObject(strOptString);
                                                    jSONObject8.put("ad_event_aid", jSONObject.optString("aid"));
                                                    jSONObject8.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "source"));
                                                    jSONObject8.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "gd_label"));
                                                    jSONObject8.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "union_user_id"));
                                                    jSONObject8.put("ad_event_app_siteid", ch.ub().t());
                                                    jSONObject8.put("ad_event_live_type", "1");
                                                    map3.put("log_extra", jSONObject8.toString());
                                                    jSONObject2.put("log_extra", jSONObject8.toString());
                                                }
                                                String strOptString3 = jSONObject.optString("cid");
                                                jSONObject2.put("creativeID", strOptString3);
                                                bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                                                map3.put("is_other_channel", "union_ad");
                                                map3.put(f.a.d, strOptString3);
                                                bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                                                strMs = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "pangle_live_room_data");
                                                if (!TextUtils.isEmpty(strMs)) {
                                                    bundle.putString("pangle_live_room_data", strMs);
                                                }
                                                strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "owner_open_id");
                                                if (TextUtils.isEmpty(strMs2)) {
                                                    strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "user_id");
                                                }
                                                bundle2.putString("anchor_id", strMs2);
                                                bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "request_id"));
                                                strMs3 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "enter_from_merge");
                                            }
                                            if (TextUtils.isEmpty(strMs3)) {
                                                strMs3 = ms(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar));
                                            }
                                            bundle2.putString("enter_from_merge", strMs3);
                                            bundle2.putString("enter_method", xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar)));
                                            bundle2.putInt("live_pangle_interaction_type", i2);
                                            bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                            strCs = lmVar.cs();
                                            if (i3 != -1) {
                                                if (!TextUtils.isEmpty(strCs)) {
                                                    JSONObject jSONObject9 = new JSONObject(strCs);
                                                    JSONObject jSONObjectOptJSONObject2 = jSONObject9.optJSONObject("enter_request");
                                                    JSONObject jSONObject10 = new JSONObject();
                                                    jSONObject10.put(str, i3);
                                                    jSONObjectOptJSONObject2.put("live_commerce_sdk_custom_params", jSONObject10);
                                                    jSONObject9.remove("enter_request");
                                                    jSONObject9.put("enter_request", jSONObjectOptJSONObject2);
                                                    strCs = jSONObject9.toString();
                                                }
                                            }
                                            map2 = map;
                                            bundle.putString("ecom_live_params", ms(lmVar, strCs, map2));
                                            if (lmVar.or() == null) {
                                                return bundle;
                                            }
                                            obj = map2.get("reward_countdown");
                                            if (obj instanceof Long) {
                                                jLongValue = ((Long) obj).longValue();
                                                if (jLongValue > 0) {
                                                    bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                                    bundle.putInt("android.app.activity.request_code", 1);
                                                    if (map2 != null) {
                                                        bundle.putInt("live_popup_reward_auth", 1);
                                                        sl.ms("rewardAuthFlag", "liv pop rew auth:  1");
                                                    }
                                                }
                                            }
                                            return bundle;
                                        }
                                    } catch (Exception e9) {
                                        e = e9;
                                        str = "live_auto_auth_login_source";
                                        i5 = 1;
                                        Object[] objArr6 = new Object[i5];
                                        objArr6[0] = e;
                                        sl.xr("TTLiveSDkBridge", objArr6);
                                        i3 = i6;
                                        i2 = i;
                                        if (azVarMl != null) {
                                            if (!TextUtils.isEmpty(azVarMl.ab())) {
                                                bundle2.putString("live_csj_libra_param", azVarMl.ab());
                                            }
                                            jSONArrayX = azVarMl.x();
                                            if (jSONArrayX != null) {
                                                ms(jSONArrayX, lmVar);
                                                bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                                bundle.putString("live_tob_task_key", lmVar.da());
                                            }
                                        }
                                        if (hVarTc != null) {
                                            uri = Uri.parse(hVarTc.xr());
                                            jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                                            strOptString = jSONObject.optString("log_extra");
                                            map3 = new HashMap();
                                            jSONObject2 = new JSONObject();
                                            if (!TextUtils.isEmpty(strOptString)) {
                                                JSONObject jSONObject11 = new JSONObject(strOptString);
                                                jSONObject11.put("ad_event_aid", jSONObject.optString("aid"));
                                                jSONObject11.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "source"));
                                                jSONObject11.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "gd_label"));
                                                jSONObject11.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "union_user_id"));
                                                jSONObject11.put("ad_event_app_siteid", ch.ub().t());
                                                jSONObject11.put("ad_event_live_type", "1");
                                                map3.put("log_extra", jSONObject11.toString());
                                                jSONObject2.put("log_extra", jSONObject11.toString());
                                            }
                                            String strOptString4 = jSONObject.optString("cid");
                                            jSONObject2.put("creativeID", strOptString4);
                                            bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                                            map3.put("is_other_channel", "union_ad");
                                            map3.put(f.a.d, strOptString4);
                                            bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                                            strMs = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "pangle_live_room_data");
                                            if (!TextUtils.isEmpty(strMs)) {
                                                bundle.putString("pangle_live_room_data", strMs);
                                            }
                                            strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "owner_open_id");
                                            if (TextUtils.isEmpty(strMs2)) {
                                                strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "user_id");
                                            }
                                            bundle2.putString("anchor_id", strMs2);
                                            bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "request_id"));
                                            strMs3 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "enter_from_merge");
                                        }
                                        if (TextUtils.isEmpty(strMs3)) {
                                            strMs3 = ms(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar));
                                        }
                                        bundle2.putString("enter_from_merge", strMs3);
                                        bundle2.putString("enter_method", xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar)));
                                        bundle2.putInt("live_pangle_interaction_type", i2);
                                        bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                        strCs = lmVar.cs();
                                        if (i3 != -1) {
                                            if (!TextUtils.isEmpty(strCs)) {
                                                JSONObject jSONObject12 = new JSONObject(strCs);
                                                JSONObject jSONObjectOptJSONObject3 = jSONObject12.optJSONObject("enter_request");
                                                JSONObject jSONObject13 = new JSONObject();
                                                jSONObject13.put(str, i3);
                                                jSONObjectOptJSONObject3.put("live_commerce_sdk_custom_params", jSONObject13);
                                                jSONObject12.remove("enter_request");
                                                jSONObject12.put("enter_request", jSONObjectOptJSONObject3);
                                                strCs = jSONObject12.toString();
                                            }
                                        }
                                        map2 = map;
                                        bundle.putString("ecom_live_params", ms(lmVar, strCs, map2));
                                        if (lmVar.or() == null) {
                                            return bundle;
                                        }
                                        obj = map2.get("reward_countdown");
                                        if (obj instanceof Long) {
                                            jLongValue = ((Long) obj).longValue();
                                            if (jLongValue > 0) {
                                                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                                bundle.putInt("android.app.activity.request_code", 1);
                                                if (map2 != null) {
                                                    bundle.putInt("live_popup_reward_auth", 1);
                                                    sl.ms("rewardAuthFlag", "liv pop rew auth:  1");
                                                }
                                            }
                                        }
                                        return bundle;
                                    }
                                } else {
                                    i7 = i;
                                    i8 = i6;
                                    str = "live_auto_auth_login_source";
                                    i.ms(lmVar.da(), new Integer(1), Integer.class);
                                    jSONObject3.put("auth_reward_gold", iKa);
                                }
                                if (jSONObject3 != null) {
                                    string = jSONObject3.toString();
                                    if (!TextUtils.isEmpty(string)) {
                                        bundle2.putString("live_auth_extra_info", string);
                                    }
                                }
                                i2 = i7;
                                i3 = i8;
                            } catch (Exception e10) {
                                e = e10;
                                i6 = i10;
                                i = iKu;
                                i5 = 1;
                                str = "live_auto_auth_login_source";
                                Object[] objArr7 = new Object[i5];
                                objArr7[0] = e;
                                sl.xr("TTLiveSDkBridge", objArr7);
                                i3 = i6;
                                i2 = i;
                                if (azVarMl != null) {
                                    if (!TextUtils.isEmpty(azVarMl.ab())) {
                                        bundle2.putString("live_csj_libra_param", azVarMl.ab());
                                    }
                                    jSONArrayX = azVarMl.x();
                                    if (jSONArrayX != null) {
                                        ms(jSONArrayX, lmVar);
                                        bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                        bundle.putString("live_tob_task_key", lmVar.da());
                                    }
                                }
                                if (hVarTc != null) {
                                    uri = Uri.parse(hVarTc.xr());
                                    jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                                    strOptString = jSONObject.optString("log_extra");
                                    map3 = new HashMap();
                                    jSONObject2 = new JSONObject();
                                    if (!TextUtils.isEmpty(strOptString)) {
                                        JSONObject jSONObject14 = new JSONObject(strOptString);
                                        jSONObject14.put("ad_event_aid", jSONObject.optString("aid"));
                                        jSONObject14.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "source"));
                                        jSONObject14.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "gd_label"));
                                        jSONObject14.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "union_user_id"));
                                        jSONObject14.put("ad_event_app_siteid", ch.ub().t());
                                        jSONObject14.put("ad_event_live_type", "1");
                                        map3.put("log_extra", jSONObject14.toString());
                                        jSONObject2.put("log_extra", jSONObject14.toString());
                                    }
                                    String strOptString5 = jSONObject.optString("cid");
                                    jSONObject2.put("creativeID", strOptString5);
                                    bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                                    map3.put("is_other_channel", "union_ad");
                                    map3.put(f.a.d, strOptString5);
                                    bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                                    strMs = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "pangle_live_room_data");
                                    if (!TextUtils.isEmpty(strMs)) {
                                        bundle.putString("pangle_live_room_data", strMs);
                                    }
                                    strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "owner_open_id");
                                    if (TextUtils.isEmpty(strMs2)) {
                                        strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "user_id");
                                    }
                                    bundle2.putString("anchor_id", strMs2);
                                    bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "request_id"));
                                    strMs3 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "enter_from_merge");
                                }
                                if (TextUtils.isEmpty(strMs3)) {
                                    strMs3 = ms(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar));
                                }
                                bundle2.putString("enter_from_merge", strMs3);
                                bundle2.putString("enter_method", xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar)));
                                bundle2.putInt("live_pangle_interaction_type", i2);
                                bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                                strCs = lmVar.cs();
                                if (i3 != -1) {
                                    if (!TextUtils.isEmpty(strCs)) {
                                        JSONObject jSONObject15 = new JSONObject(strCs);
                                        JSONObject jSONObjectOptJSONObject4 = jSONObject15.optJSONObject("enter_request");
                                        JSONObject jSONObject16 = new JSONObject();
                                        jSONObject16.put(str, i3);
                                        jSONObjectOptJSONObject4.put("live_commerce_sdk_custom_params", jSONObject16);
                                        jSONObject15.remove("enter_request");
                                        jSONObject15.put("enter_request", jSONObjectOptJSONObject4);
                                        strCs = jSONObject15.toString();
                                    }
                                }
                                map2 = map;
                                bundle.putString("ecom_live_params", ms(lmVar, strCs, map2));
                                if (lmVar.or() == null) {
                                    return bundle;
                                }
                                obj = map2.get("reward_countdown");
                                if (obj instanceof Long) {
                                    jLongValue = ((Long) obj).longValue();
                                    if (jLongValue > 0) {
                                        bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                        bundle.putInt("android.app.activity.request_code", 1);
                                        if (map2 != null) {
                                            bundle.putInt("live_popup_reward_auth", 1);
                                            sl.ms("rewardAuthFlag", "liv pop rew auth:  1");
                                        }
                                    }
                                }
                                return bundle;
                            }
                        } catch (Exception e11) {
                            e = e11;
                        }
                    } else {
                        i = iKu;
                        i6 = -1;
                        if (iKa <= 0) {
                            i7 = i;
                            str = "live_auto_auth_login_source";
                            i8 = i6;
                        } else if (jSONObject3 == null) {
                            jSONObject3 = new JSONObject();
                            i7 = i;
                            i8 = i6;
                            str = "live_auto_auth_login_source";
                            i.ms(lmVar.da(), new Integer(1), Integer.class);
                            jSONObject3.put("auth_reward_gold", iKa);
                        } else {
                            i7 = i;
                            i8 = i6;
                            str = "live_auto_auth_login_source";
                            i.ms(lmVar.da(), new Integer(1), Integer.class);
                            jSONObject3.put("auth_reward_gold", iKa);
                        }
                        if (jSONObject3 != null) {
                            string = jSONObject3.toString();
                            if (!TextUtils.isEmpty(string)) {
                                bundle2.putString("live_auth_extra_info", string);
                            }
                        }
                        i2 = i7;
                        i3 = i8;
                    }
                } catch (Exception e12) {
                    e = e12;
                    i = iKu;
                    i5 = 1;
                    i6 = -1;
                    Object[] objArr8 = new Object[i5];
                    objArr8[0] = e;
                    sl.xr("TTLiveSDkBridge", objArr8);
                    i3 = i6;
                    i2 = i;
                    if (azVarMl != null) {
                        if (!TextUtils.isEmpty(azVarMl.ab())) {
                            bundle2.putString("live_csj_libra_param", azVarMl.ab());
                        }
                        jSONArrayX = azVarMl.x();
                        if (jSONArrayX != null) {
                            ms(jSONArrayX, lmVar);
                            bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                            bundle.putString("live_tob_task_key", lmVar.da());
                        }
                    }
                    if (hVarTc != null) {
                        uri = Uri.parse(hVarTc.xr());
                        jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                        strOptString = jSONObject.optString("log_extra");
                        map3 = new HashMap();
                        jSONObject2 = new JSONObject();
                        if (!TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject17 = new JSONObject(strOptString);
                            jSONObject17.put("ad_event_aid", jSONObject.optString("aid"));
                            jSONObject17.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "source"));
                            jSONObject17.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "gd_label"));
                            jSONObject17.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "union_user_id"));
                            jSONObject17.put("ad_event_app_siteid", ch.ub().t());
                            jSONObject17.put("ad_event_live_type", "1");
                            map3.put("log_extra", jSONObject17.toString());
                            jSONObject2.put("log_extra", jSONObject17.toString());
                        }
                        String strOptString6 = jSONObject.optString("cid");
                        jSONObject2.put("creativeID", strOptString6);
                        bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                        map3.put("is_other_channel", "union_ad");
                        map3.put(f.a.d, strOptString6);
                        bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                        strMs = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "pangle_live_room_data");
                        if (!TextUtils.isEmpty(strMs)) {
                            bundle.putString("pangle_live_room_data", strMs);
                        }
                        strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "owner_open_id");
                        if (TextUtils.isEmpty(strMs2)) {
                            strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "user_id");
                        }
                        bundle2.putString("anchor_id", strMs2);
                        bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "request_id"));
                        strMs3 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "enter_from_merge");
                    }
                    if (TextUtils.isEmpty(strMs3)) {
                        strMs3 = ms(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar));
                    }
                    bundle2.putString("enter_from_merge", strMs3);
                    bundle2.putString("enter_method", xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar)));
                    bundle2.putInt("live_pangle_interaction_type", i2);
                    bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                    strCs = lmVar.cs();
                    if (i3 != -1) {
                        if (!TextUtils.isEmpty(strCs)) {
                            JSONObject jSONObject18 = new JSONObject(strCs);
                            JSONObject jSONObjectOptJSONObject5 = jSONObject18.optJSONObject("enter_request");
                            JSONObject jSONObject19 = new JSONObject();
                            jSONObject19.put(str, i3);
                            jSONObjectOptJSONObject5.put("live_commerce_sdk_custom_params", jSONObject19);
                            jSONObject18.remove("enter_request");
                            jSONObject18.put("enter_request", jSONObjectOptJSONObject5);
                            strCs = jSONObject18.toString();
                        }
                    }
                    map2 = map;
                    bundle.putString("ecom_live_params", ms(lmVar, strCs, map2));
                    if (lmVar.or() == null) {
                        return bundle;
                    }
                    obj = map2.get("reward_countdown");
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                        if (jLongValue > 0) {
                            bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                            bundle.putInt("android.app.activity.request_code", 1);
                            if (map2 != null) {
                                bundle.putInt("live_popup_reward_auth", 1);
                                sl.ms("rewardAuthFlag", "liv pop rew auth:  1");
                            }
                        }
                    }
                    return bundle;
                }
            } else {
                if (i == 103) {
                    i5 = 1;
                    try {
                        bundle2.putInt("live_popup_dou_auth_dialog", 1);
                    } catch (Exception e13) {
                        e = e13;
                        i6 = -1;
                        Object[] objArr9 = new Object[i5];
                        objArr9[0] = e;
                        sl.xr("TTLiveSDkBridge", objArr9);
                        i3 = i6;
                        i2 = i;
                        if (azVarMl != null) {
                            if (!TextUtils.isEmpty(azVarMl.ab())) {
                                bundle2.putString("live_csj_libra_param", azVarMl.ab());
                            }
                            jSONArrayX = azVarMl.x();
                            if (jSONArrayX != null) {
                                ms(jSONArrayX, lmVar);
                                bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                                bundle.putString("live_tob_task_key", lmVar.da());
                            }
                        }
                        if (hVarTc != null) {
                            uri = Uri.parse(hVarTc.xr());
                            jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                            strOptString = jSONObject.optString("log_extra");
                            map3 = new HashMap();
                            jSONObject2 = new JSONObject();
                            if (!TextUtils.isEmpty(strOptString)) {
                                JSONObject jSONObject110 = new JSONObject(strOptString);
                                jSONObject110.put("ad_event_aid", jSONObject.optString("aid"));
                                jSONObject110.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "source"));
                                jSONObject110.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "gd_label"));
                                jSONObject110.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "union_user_id"));
                                jSONObject110.put("ad_event_app_siteid", ch.ub().t());
                                jSONObject110.put("ad_event_live_type", "1");
                                map3.put("log_extra", jSONObject110.toString());
                                jSONObject2.put("log_extra", jSONObject110.toString());
                            }
                            String strOptString7 = jSONObject.optString("cid");
                            jSONObject2.put("creativeID", strOptString7);
                            bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                            map3.put("is_other_channel", "union_ad");
                            map3.put(f.a.d, strOptString7);
                            bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                            strMs = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "pangle_live_room_data");
                            if (!TextUtils.isEmpty(strMs)) {
                                bundle.putString("pangle_live_room_data", strMs);
                            }
                            strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "owner_open_id");
                            if (TextUtils.isEmpty(strMs2)) {
                                strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "user_id");
                            }
                            bundle2.putString("anchor_id", strMs2);
                            bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "request_id"));
                            strMs3 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "enter_from_merge");
                        }
                        if (TextUtils.isEmpty(strMs3)) {
                            strMs3 = ms(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar));
                        }
                        bundle2.putString("enter_from_merge", strMs3);
                        bundle2.putString("enter_method", xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar)));
                        bundle2.putInt("live_pangle_interaction_type", i2);
                        bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
                        strCs = lmVar.cs();
                        if (i3 != -1) {
                            if (!TextUtils.isEmpty(strCs)) {
                                JSONObject jSONObject111 = new JSONObject(strCs);
                                JSONObject jSONObjectOptJSONObject6 = jSONObject111.optJSONObject("enter_request");
                                JSONObject jSONObject112 = new JSONObject();
                                jSONObject112.put(str, i3);
                                jSONObjectOptJSONObject6.put("live_commerce_sdk_custom_params", jSONObject112);
                                jSONObject111.remove("enter_request");
                                jSONObject111.put("enter_request", jSONObjectOptJSONObject6);
                                strCs = jSONObject111.toString();
                            }
                        }
                        map2 = map;
                        bundle.putString("ecom_live_params", ms(lmVar, strCs, map2));
                        if (lmVar.or() == null) {
                            return bundle;
                        }
                        obj = map2.get("reward_countdown");
                        if (obj instanceof Long) {
                            jLongValue = ((Long) obj).longValue();
                            if (jLongValue > 0) {
                                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                                bundle.putInt("android.app.activity.request_code", 1);
                                if (map2 != null) {
                                    bundle.putInt("live_popup_reward_auth", 1);
                                    sl.ms("rewardAuthFlag", "liv pop rew auth:  1");
                                }
                            }
                        }
                        return bundle;
                    }
                } else {
                    i = iKu;
                }
                jSONObject3 = null;
                i6 = -1;
                if (iKa <= 0) {
                    i7 = i;
                    str = "live_auto_auth_login_source";
                    i8 = i6;
                } else if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                    i7 = i;
                    i8 = i6;
                    str = "live_auto_auth_login_source";
                    i.ms(lmVar.da(), new Integer(1), Integer.class);
                    jSONObject3.put("auth_reward_gold", iKa);
                } else {
                    i7 = i;
                    i8 = i6;
                    str = "live_auto_auth_login_source";
                    i.ms(lmVar.da(), new Integer(1), Integer.class);
                    jSONObject3.put("auth_reward_gold", iKa);
                }
                if (jSONObject3 != null) {
                    string = jSONObject3.toString();
                    if (!TextUtils.isEmpty(string)) {
                        bundle2.putString("live_auth_extra_info", string);
                    }
                }
                i2 = i7;
                i3 = i8;
            }
            if (azVarMl != null) {
                if (!TextUtils.isEmpty(azVarMl.ab())) {
                    bundle2.putString("live_csj_libra_param", azVarMl.ab());
                }
                jSONArrayX = azVarMl.x();
                if (jSONArrayX != null) {
                    ms(jSONArrayX, lmVar);
                    bundle.putString("live_tob_task_center_config", jSONArrayX.toString());
                    bundle.putString("live_tob_task_key", lmVar.da());
                }
            }
            if (hVarTc != null && !TextUtils.isEmpty(hVarTc.xr())) {
                uri = Uri.parse(hVarTc.xr());
                jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                strOptString = jSONObject.optString("log_extra");
                map3 = new HashMap();
                jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject113 = new JSONObject(strOptString);
                    jSONObject113.put("ad_event_aid", jSONObject.optString("aid"));
                    jSONObject113.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "source"));
                    jSONObject113.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "gd_label"));
                    jSONObject113.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "union_user_id"));
                    jSONObject113.put("ad_event_app_siteid", ch.ub().t());
                    jSONObject113.put("ad_event_live_type", "1");
                    map3.put("log_extra", jSONObject113.toString());
                    jSONObject2.put("log_extra", jSONObject113.toString());
                }
                String strOptString8 = jSONObject.optString("cid");
                jSONObject2.put("creativeID", strOptString8);
                bundle.putString("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                map3.put("is_other_channel", "union_ad");
                map3.put(f.a.d, strOptString8);
                bundle.putSerializable("live_effect_ad_log_extra_map", map3);
                strMs = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "pangle_live_room_data");
                if (!TextUtils.isEmpty(strMs)) {
                    bundle.putString("pangle_live_room_data", strMs);
                }
                strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "owner_open_id");
                if (TextUtils.isEmpty(strMs2)) {
                    strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "user_id");
                }
                bundle2.putString("anchor_id", strMs2);
                bundle2.putString("live.intent.extra.REQUEST_ID", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "request_id"));
                strMs3 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "enter_from_merge");
            }
            if (TextUtils.isEmpty(strMs3)) {
                strMs3 = ms(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar));
            }
            bundle2.putString("enter_from_merge", strMs3);
            bundle2.putString("enter_method", xr(com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar)));
            bundle2.putInt("live_pangle_interaction_type", i2);
            bundle.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", bundle2);
            strCs = lmVar.cs();
            if (i3 != -1) {
                if (!TextUtils.isEmpty(strCs)) {
                    JSONObject jSONObject114 = new JSONObject(strCs);
                    JSONObject jSONObjectOptJSONObject7 = jSONObject114.optJSONObject("enter_request");
                    JSONObject jSONObject115 = new JSONObject();
                    jSONObject115.put(str, i3);
                    jSONObjectOptJSONObject7.put("live_commerce_sdk_custom_params", jSONObject115);
                    jSONObject114.remove("enter_request");
                    jSONObject114.put("enter_request", jSONObjectOptJSONObject7);
                    strCs = jSONObject114.toString();
                }
            }
            map2 = map;
            bundle.putString("ecom_live_params", ms(lmVar, strCs, map2));
        } else {
            map2 = map;
        }
        if (lmVar.or() == null) {
            return bundle;
        }
        obj = map2.get("reward_countdown");
        if (obj instanceof Long) {
            jLongValue = ((Long) obj).longValue();
            if (jLongValue > 0) {
                bundle.putLong("csj.reward_countdown_duration_ms", jLongValue);
                bundle.putInt("android.app.activity.request_code", 1);
                if (map2 != null && map2.containsKey("reward_live_scene") && ((Integer) map2.get("reward_live_scene")).intValue() == 1) {
                    bundle.putInt("live_popup_reward_auth", 1);
                    sl.ms("rewardAuthFlag", "liv pop rew auth:  1");
                }
            }
        }
        return bundle;
    }

    private void ms(JSONArray jSONArray, lm lmVar) {
        com.bytedance.sdk.openadsdk.core.live.d.ms msVar;
        if (lmVar == null || jSONArray == null || (msVar = (com.bytedance.sdk.openadsdk.core.live.d.ms) i.ms(lmVar.da(), com.bytedance.sdk.openadsdk.core.live.d.ms.class)) == null || msVar.xr.isEmpty()) {
            return;
        }
        String strDf = lmVar.df();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (msVar.xr.contains(strDf + "_" + jSONObject.optString("type"))) {
                    jSONObject.put("status", 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int ka(lm lmVar) {
        String strLi = lmVar.li();
        Integer num = (Integer) i.ms(lmVar.da(), Integer.class);
        if ((num != null && num.intValue() > 0) || TextUtils.isEmpty(strLi)) {
            return 0;
        }
        try {
            return new JSONObject(strLi).optInt("auth_reward_gold");
        } catch (Throwable th) {
            sl.ah("TTLiveSDkBridge", th);
            return 0;
        }
    }

    public static String ms(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION.lowerName();
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT.lowerName();
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED.lowerName();
        }
        if (i == 9) {
            return EnterFromMerge.AD_UNION_DRAW.lowerName();
        }
        if (i == 1) {
            return "ad_union_banner";
        }
        if (i == 3 || i == 4) {
            return "ad_union_topview";
        }
        if (i == 2) {
            return "ad_union_former_insert";
        }
        return i == 6 ? "ad_union_patch" : EnterFromMerge.NO_VALUE.lowerName();
    }

    public static String xr(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL.lowerName();
            case 5:
                return EnterMethod.LIVE_CARD.lowerName();
            default:
                return EnterMethod.NO_VALUE.lowerName();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int xr(Context context, lm lmVar, Map<String, Object> map) {
        long jLongValue;
        if (map != null) {
            try {
                Object obj = map.get("reward_countdown");
                if (obj instanceof Long) {
                    jLongValue = ((Long) obj).longValue();
                } else {
                    jLongValue = 0;
                }
            } catch (Exception e) {
                sl.xr("TTLiveSDkBridge", e.toString());
            }
        } else {
            jLongValue = 0;
        }
        if (context == null || lmVar == null) {
            return 5;
        }
        if (!(context instanceof Activity)) {
            return 7;
        }
        if (!xn.ms(lmVar)) {
            return 5;
        }
        if (jLongValue < 0) {
            return 8;
        }
        if (xn.xr(lmVar) == 1) {
            return 9;
        }
        return ms(context, lmVar, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public boolean ms(lm lmVar) {
        return a_(lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public String ab() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return 10;
        }
        if (this.f2845ms == null) {
            return 12;
        }
        if (!c()) {
            return 11;
        }
        Activity activityQk = ch.ub().qk();
        if (activityQk == null) {
            return 13;
        }
        try {
            Boolean bool = (Boolean) this.f2845ms.call(8, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(g.X, activityQk).ms("scheme_uri", str)).xr(), Boolean.class);
            return (bool == null || !bool.booleanValue()) ? 10 : 1;
        } catch (Exception unused) {
            return 14;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(com.bytedance.sdk.openadsdk.core.live.xr.xr xrVar, boolean z) {
        if (this.f2845ms == null) {
            return 12;
        }
        if (!c()) {
            return 11;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", "requestDyAuth");
        map.put("expand_method_param", new Object[]{ch.ub().qk(), xrVar, Boolean.valueOf(z)});
        sl.ms("TTLiveSDkBridge", "requestDyAuth:" + this.f2845ms.call(7, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), null) + ", syncAuth = " + z);
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms, com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(String str, lm lmVar, long j) {
        com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(str, lmVar, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(String str, boolean z) {
        if (this.f2845ms != null && c()) {
            HashMap map = new HashMap();
            map.put("expand_method_name", str);
            map.put("expand_method_param", new Object[]{Boolean.valueOf(z)});
            this.f2845ms.call(7, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), null);
        }
    }
}
