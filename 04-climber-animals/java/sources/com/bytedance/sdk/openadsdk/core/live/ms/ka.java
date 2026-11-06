package com.bytedance.sdk.openadsdk.core.live.ms;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ms {
    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(com.bytedance.sdk.openadsdk.core.live.xr.xr xrVar, boolean z) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(com.bytedance.sdk.openadsdk.ub.d dVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(String str, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms
    protected boolean w_() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int xr(Context context, lm lmVar, Map<String, Object> map) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(Context context, lm lmVar, Map<String, Object> map) {
        int i;
        if (context == null || lmVar == null) {
            return -1;
        }
        if (!a_(lmVar)) {
            sl.ms("TTLiveSDkBridge", "mata has not le property");
            return -1;
        }
        String str = map != null ? (String) map.get("event_tag") : "";
        int iKu = lmVar.ku();
        int iIntValue = 1;
        if (!c()) {
            ms(lmVar, str, iKu, 1, iKu == 7 ? 1 : 2);
            return 1;
        }
        if (this.f2845ms != null) {
            int iAh = 0;
            iIntValue = ((Integer) this.f2845ms.call(0, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, xr(lmVar, map)).xr(), Integer.class)).intValue();
            if (iIntValue != 0) {
                iAh = 3;
            } else if (ms(lmVar, 0) && (iAh = ah(lmVar)) == 0) {
                try {
                    new com.bytedance.sdk.openadsdk.core.live.ah.ms().ms(str).ms(context, lmVar);
                } catch (Exception e) {
                    sl.ms(e);
                    iAh = 3;
                }
            }
            sl.ms("TTLiveSDkBridge", iIntValue == 0 ? "le openliv succ" : "callR: " + iIntValue);
            i = iAh;
        } else {
            i = 1;
        }
        ms(lmVar, str, iKu, iKu, i);
        return iIntValue;
    }

    private String xr(lm lmVar, Map<String, Object> map) {
        if (lmVar == null) {
            return "";
        }
        try {
            Uri uriMs = com.bytedance.sdk.openadsdk.core.live.ah.ms(Uri.parse("sslocal://webcast_room"), ms(lmVar, map));
            sl.ms("TTLiveSDkBridge", "link: " + uriMs.toString());
            return uriMs.toString();
        } catch (Throwable th) {
            sl.ms(th);
            sl.d("TTLiveSDkBridge", "link: null");
            return "";
        }
    }

    public Map<String, String> ms(lm lmVar, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (lmVar == null) {
            return map2;
        }
        map2.put("room_id", lmVar.eo());
        if (this.f2845ms != null) {
            int iX = f.x(lmVar);
            String str = (String) this.f2845ms.call(1, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, iX).xr(), String.class);
            String str2 = (String) this.f2845ms.call(2, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, iX).ms(1, com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)).xr(), String.class);
            map2.put("enter_from_merge", str);
            map2.put("enter_method", str2);
        }
        map2.put("host", "aweme");
        map2.put("is_other_channel", "union_ad");
        String strMs = ms(lmVar, lmVar.cs(), map);
        if (!TextUtils.isEmpty(strMs)) {
            map2.put("ecom_live_params", strMs);
        }
        h hVarTc = lmVar.tc();
        if (hVarTc != null && !TextUtils.isEmpty(hVarTc.xr())) {
            try {
                Uri uri = Uri.parse(hVarTc.xr());
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                String strOptString = jSONObject.optString("log_extra");
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    jSONObject3.put("ad_event_aid", jSONObject.optString("aid"));
                    jSONObject3.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "source"));
                    jSONObject3.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "gd_label"));
                    jSONObject3.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "union_user_id"));
                    jSONObject3.put("ad_event_app_siteid", ch.ub().t());
                    jSONObject3.put("ad_event_live_type", "1");
                    map2.put("log_extra", jSONObject3.toString());
                    jSONObject2.put("log_extra", jSONObject3.toString());
                }
                String strOptString2 = jSONObject.optString("cid");
                jSONObject2.put("creativeID", strOptString2);
                map2.put("creative_id", strOptString2);
                map2.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                String strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "owner_open_id");
                if (TextUtils.isEmpty(strMs2)) {
                    strMs2 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "user_id");
                }
                map2.put("owner_open_id", strMs2);
                String strMs3 = com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "pangle_live_room_data");
                if (!TextUtils.isEmpty(strMs3)) {
                    map2.put("pangle_live_room_data", strMs3);
                }
                map2.put("request_id", com.bytedance.sdk.openadsdk.core.live.ah.ms(uri, "request_id"));
            } catch (Exception e) {
                sl.ms(e);
            }
        }
        return map2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public boolean ms(lm lmVar) {
        return a_(lmVar) && this.f2845ms != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.ms, com.bytedance.sdk.openadsdk.core.live.ms.d
    public void ms(final String str, final lm lmVar, final long j) {
        com.bytedance.sdk.openadsdk.op.ab.xr(new ny("csj_live_log_event_v2") { // from class: com.bytedance.sdk.openadsdk.core.live.ms.ka.1
            @Override // java.lang.Runnable
            public void run() {
                ka.this.xr(str, lmVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(String str, lm lmVar, long j) {
        try {
            if (this.f2845ms == null) {
                return;
            }
            Map<String, String> mapMs = ms(lmVar, (Map<String, Object>) null);
            Map<String, String> mapMs2 = com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(re.getContext());
            mapMs2.put("room_id", mapMs.get("room_id"));
            mapMs2.put("anchor_id", mapMs.get("owner_open_id"));
            mapMs2.put("enter_from_merge", mapMs.get("enter_from_merge"));
            mapMs2.put("enter_method", mapMs.get("enter_method"));
            mapMs2.put("action_type", "click");
            mapMs2.put("request_id", mapMs.get("request_id"));
            mapMs2.put("duration", new StringBuilder().append(j).toString());
            mapMs2.put("is_other_channel", "union_ad");
            mapMs2.put("IESLiveEffectAdTrackExtraServiceKey", mapMs.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : mapMs2.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.f2845ms.call(4, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, str).ms(1, jSONObject).xr(), Void.class);
        } catch (Throwable th) {
            if (sl.ah()) {
                sl.ah("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int xr() {
        if (this.f2845ms != null) {
            try {
                Object objCall = this.f2845ms.call(3, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, 1).xr(), Object.class);
                if (objCall != null && (objCall instanceof Integer)) {
                    return ((Integer) objCall).intValue();
                }
            } catch (Throwable th) {
                sl.xr("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int b_(lm lmVar) {
        if (this.f2845ms != null) {
            long jXr = xr(lmVar);
            if (jXr == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", jXr);
                Object objCall = this.f2845ms.call(3, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, 2).ms(1, bundle).xr(), Object.class);
                if (objCall != null && (objCall instanceof Integer)) {
                    return ((Integer) objCall).intValue();
                }
            } catch (Throwable th) {
                sl.xr("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ka() {
        boolean zBooleanValue = false;
        if (this.f2845ms != null) {
            try {
                Object objCall = this.f2845ms.call(3, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, 3).xr(), Object.class);
                if (objCall != null && (objCall instanceof Boolean)) {
                    zBooleanValue = ((Boolean) objCall).booleanValue();
                }
            } catch (Throwable th) {
                sl.xr("TTLiveSDkBridge", th);
            }
        }
        return zBooleanValue ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public boolean c() {
        return xr() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public String ab() {
        if (this.f2845ms == null) {
            return null;
        }
        try {
            Object objCall = this.f2845ms.call(3, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, 4).xr(), Object.class);
            if (objCall == null || !(objCall instanceof String)) {
                return null;
            }
            return (String) objCall;
        } catch (Throwable th) {
            sl.xr("TTLiveSDkBridge", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(lm lmVar, ah ahVar, String str) {
        if (lmVar == null || TextUtils.isEmpty(lmVar.l()) || this.f2845ms == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", lmVar.l());
            Object objCall = this.f2845ms.call(3, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, 5).ms(1, bundle).xr(), Object.class);
            if (objCall == null) {
                return 4;
            }
            if (objCall instanceof Integer) {
                return ((Integer) objCall).intValue();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public JSONObject x() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.ms.d
    public int ms(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", str);
            Object objCall = this.f2845ms.call(3, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, 6).ms(1, bundle).xr(), Object.class);
            if (objCall instanceof Integer) {
                return ((Integer) objCall).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
