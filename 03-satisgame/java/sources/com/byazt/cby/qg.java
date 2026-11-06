package com.byazt.cby;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, 26})
public class qg extends n {
    public static volatile qg q;
    public final Map<String, String> s;

    private qg() {
        super("gm_label_v_v_s_3");
        this.s = new ConcurrentHashMap();
        qg();
    }

    public static qg q() {
        if (q == null) {
            synchronized (qg.class) {
                if (q == null) {
                    q = new qg();
                }
            }
        }
        return q;
    }

    public void n(String str, int i, double d) {
        if (!com.byazt.qt.qg.n().ci() || TextUtils.isEmpty(str)) {
            return;
        }
        n(3, str, i, d);
    }

    @Override // com.byazt.cby.n
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.byazt.rb.qg.qg("DynamicLabelValueManagerAbs", "readCacheFromSp-SP_NAME_V3，cpmKey:" + str + "，type_value_timestamp:" + str2);
        if (str.startsWith("cpm_key_")) {
            this.s.put(str, str2);
        }
    }

    @Override // com.byazt.cby.n
    public Map<String, String> n() {
        return this.s;
    }

    @Override // com.byazt.cby.n
    public void n(String str, int i, String str2) {
        if (i == 3) {
            this.s.put(str, str2);
        }
    }

    @Override // com.byazt.cby.n
    public boolean qg(String str, JSONObject jSONObject, Map<String, Object> map) {
        try {
            Object obj = map.get("user_label_value");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", n(obj != null ? (com.byazt.ws.s) obj : null));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.byazt.qt.qg.n().hf()));
            jSONObject2.putOpt(a.C0017a.o, map.get(a.C0017a.o));
            jSONObject2.putOpt("group_type", map.get("group_type"));
            jSONObject2.putOpt("rule_in_use", map.get("rule_in_use"));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("ecpm", map.get("ecpm"));
            jSONObject3.putOpt(TapEventParamConstants.PARAM_SUB_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject2.putOpt("ecpm_info", jSONObject3);
            jSONObject2.putOpt("refresh_time", map.get("refresh_time"));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public void s(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.byazt.qt.qg.n().ci() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt(a.C0017a.o, map.get(a.C0017a.o));
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.cby.n
    public JSONObject n(com.byazt.ws.s sVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", sVar != null ? sVar.n() : "-1");
            jSONObject.putOpt("label_id", sVar != null ? Integer.valueOf(sVar.s()) : "-1");
            jSONObject.putOpt("label_version", sVar != null ? sVar.q() : "-1");
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
