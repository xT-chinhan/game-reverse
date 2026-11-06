package com.smartdigimkt.k2;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ WTWebView b;

    public p(WTWebView wTWebView, String str) {
        this.b = wTWebView;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.a3.a aVar;
        WTWebView wTWebView = this.b;
        com.smartdigimkt.b3.c cVar = wTWebView.e;
        com.smartdigimkt.a3.a aVar2 = wTWebView.f;
        String str = this.a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c();
        if (TextUtils.isEmpty(str)) {
            aVar = aVar2;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(com.anythink.core.common.f.e.a.b)) {
                    cVar2.a = jSONObject.optString(com.anythink.core.common.f.e.a.b, "");
                }
                if (jSONObject.has("requestid")) {
                    cVar2.b = jSONObject.optString("requestid", "");
                }
                if (jSONObject.has("unitid")) {
                    cVar2.c = jSONObject.optString("unitid", "");
                }
                if (jSONObject.has(com.anythink.core.common.d.f.c)) {
                    cVar2.d = jSONObject.optString(com.anythink.core.common.d.f.c, "");
                }
                if (jSONObject.has("sessionid")) {
                    cVar2.e = jSONObject.optString("sessionid", "");
                }
                if (jSONObject.has("groupid")) {
                    cVar2.f = jSONObject.optString("groupid", "");
                }
                if (jSONObject.has("unitgroupid")) {
                    cVar2.g = jSONObject.optString("unitgroupid", "");
                }
                if (jSONObject.has(TapEventParamConstants.PARAM_SUB_TIMESTAMP)) {
                    cVar2.h = jSONObject.optString(TapEventParamConstants.PARAM_SUB_TIMESTAMP, "");
                }
                if (jSONObject.has("asid")) {
                    cVar2.i = jSONObject.optString("asid", "");
                }
                if (jSONObject.has("refresh")) {
                    cVar2.j = jSONObject.optString("refresh", "");
                }
                if (jSONObject.has(com.anythink.core.common.l.f.bh)) {
                    cVar2.O = jSONObject.optInt(com.anythink.core.common.l.f.bh, 0);
                }
                if (jSONObject.has("traffic_group_id")) {
                    cVar2.k = jSONObject.optString("traffic_group_id", "");
                }
                if (jSONObject.has(NotificationCompat.CATEGORY_MESSAGE)) {
                    cVar2.l = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
                }
                if (jSONObject.has("msg1")) {
                    cVar2.m = jSONObject.optString("msg1", "");
                }
                if (jSONObject.has("msg2")) {
                    cVar2.n = jSONObject.optString("msg2", "");
                }
                if (jSONObject.has("msg3")) {
                    cVar2.o = jSONObject.optString("msg3", "");
                }
                if (jSONObject.has("msg4")) {
                    cVar2.p = jSONObject.optString("msg4", "");
                }
                if (jSONObject.has("msg5")) {
                    cVar2.q = jSONObject.optString("msg5", "");
                }
                if (jSONObject.has("msg6")) {
                    cVar2.r = jSONObject.optString("msg6", "");
                }
                if (jSONObject.has("msg7")) {
                    cVar2.s = jSONObject.optString("msg7", "");
                }
                if (jSONObject.has("msg8")) {
                    cVar2.t = jSONObject.optString("msg8", "");
                }
                if (jSONObject.has("msg9")) {
                    cVar2.u = jSONObject.optString("msg9", "");
                }
                if (jSONObject.has("msg10")) {
                    cVar2.v = jSONObject.optString("msg10", "");
                }
                if (jSONObject.has("msg11")) {
                    cVar2.w = jSONObject.optString("msg11", "");
                }
                if (jSONObject.has("msg12")) {
                    cVar2.x = jSONObject.optString("msg12", "");
                }
                if (jSONObject.has("msg13")) {
                    cVar2.y = jSONObject.optString("msg13", "");
                }
                if (jSONObject.has("msg14")) {
                    cVar2.z = jSONObject.optString("msg14", "");
                }
                if (jSONObject.has("msg15")) {
                    cVar2.A = jSONObject.optString("msg15", "");
                }
                if (jSONObject.has(com.anythink.core.e.l.a.T)) {
                    cVar2.I = jSONObject.optString(com.anythink.core.e.l.a.T, "");
                }
                if (jSONObject.has(com.anythink.core.common.l.f.aj)) {
                    cVar2.J = jSONObject.optString(com.anythink.core.common.l.f.aj, "");
                }
                if (jSONObject.has(com.anythink.core.e.l.a.aa)) {
                    cVar2.K = jSONObject.optJSONObject(com.anythink.core.e.l.a.aa);
                }
                if (jSONObject.has("adap_c")) {
                    cVar2.P = jSONObject.optJSONObject("adap_c");
                }
                cVar2.L = jSONObject.optString("real_p", "");
                cVar2.M = jSONObject.optInt("real_g", -1);
                cVar2.N = jSONObject.optInt("real_t", -1);
                if (jSONObject.has("x_c")) {
                    cVar2.Q = jSONObject.optString("x_c");
                }
                if (jSONObject.has("tp_bid_id_req_id")) {
                    cVar2.S = jSONObject.optString("tp_bid_id_req_id", "");
                }
                if (jSONObject.has("link_type")) {
                    cVar2.U = jSONObject.optString("link_type", "");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            aVar = aVar2;
        }
        cVar2.a(aVar);
        com.smartdigimkt.n3.k.a(cVar2);
    }
}
