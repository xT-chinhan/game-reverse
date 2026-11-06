package com.byazt.op;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.gct.hd;
import com.byazt.gct.pk;
import com.byazt.llp.cp;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 502, 18})
public class l extends n {
    @Override // com.byazt.op.n
    public boolean N_() {
        return true;
    }

    @Override // com.byazt.op.q
    public int n(Context context, pk pkVar, Map<String, Object> map) {
        return -1;
    }

    @Override // com.byazt.op.q
    public int n(com.byazt.wc.qg qgVar, boolean z) {
        return 0;
    }

    @Override // com.byazt.op.q
    public void n(com.byazt.hnb.q qVar) {
    }

    @Override // com.byazt.op.q
    public void n(String str, boolean z) {
    }

    @Override // com.byazt.op.q
    public void q() {
    }

    @Override // com.byazt.op.q
    public int n(Context context, cp cpVar, Map<String, Object> map) {
        int i;
        if (context == null || cpVar == null || !n(cpVar)) {
            return -1;
        }
        String str = map != null ? (String) map.get("event_tag") : "";
        int iL = cpVar.l();
        int iIntValue = 1;
        if (!w()) {
            n(com.byazt.ukb.qg.n(cpVar, map), str, iL, 1, iL == 7 ? 1 : 2);
            return 1;
        }
        if (this.n != null) {
            int iQg = 0;
            Object objApply = this.n.apply(com.byazt.of.qg.n().n(0).n(Integer.class).n(0, qg(cpVar, map)).qg());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            if (iIntValue != 0) {
                iQg = 3;
            } else if (n(cpVar, 0) && (iQg = qg(cpVar)) == 0) {
                try {
                    new com.byazt.xd.n().n(str).n(context, map, cpVar);
                } catch (Exception unused) {
                    iQg = 3;
                }
            }
            i = iQg;
        } else {
            i = 1;
        }
        n(com.byazt.ukb.qg.n(cpVar, map), str, iL, iL, i);
        return iIntValue;
    }

    private String qg(cp cpVar, Map<String, Object> map) {
        if (cpVar == null) {
            return "";
        }
        try {
            return com.byazt.rd.qg.n(Uri.parse("sslocal://webcast_room"), n(cpVar, map)).toString();
        } catch (Throwable unused) {
            k.qg(com.byazt.ea.s.TAG, "link: null");
            return "";
        }
    }

    public Map<String, String> n(cp cpVar, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (cpVar == null) {
            return map2;
        }
        map2.put("room_id", cpVar.tj());
        if (this.n != null) {
            int iD = com.byazt.vgx.w.d(com.byazt.ukb.qg.n(cpVar, map));
            String str = (String) this.n.apply(com.byazt.of.qg.n().n(1).n(String.class).n(0, Integer.valueOf(iD)).qg());
            String str2 = (String) this.n.apply(com.byazt.of.qg.n().n(2).n(String.class).n(0, Integer.valueOf(iD)).n(1, Boolean.valueOf(com.byazt.gks.n.n(com.byazt.ukb.qg.n(cpVar, map)))).qg());
            map2.put("enter_from_merge", str);
            map2.put("enter_method", str2);
        }
        map2.put(f.bU, "aweme");
        map2.put("is_other_channel", "union_ad");
        String strN = n(cpVar, cpVar.d(), map);
        if (!TextUtils.isEmpty(strN)) {
            map2.put("ecom_live_params", strN);
        }
        hd hdVarSz = cpVar.sz();
        if (hdVarSz != null && !TextUtils.isEmpty(hdVarSz.qg())) {
            try {
                Uri uri = Uri.parse(hdVarSz.qg());
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                String strOptString = jSONObject.optString("log_extra");
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    jSONObject3.put("ad_event_aid", jSONObject.optString("aid"));
                    jSONObject3.put("ad_event_source", com.byazt.rd.qg.n(uri, "source"));
                    jSONObject3.put("ad_event_gd_label", com.byazt.rd.qg.n(uri, "gd_label"));
                    jSONObject3.put("ad_event_union_user_id", com.byazt.rd.qg.n(uri, "union_user_id"));
                    jSONObject3.put("ad_event_app_siteid", com.byazt.vyf.s.cy().ou());
                    jSONObject3.put("ad_event_live_type", "1");
                    map2.put("log_extra", jSONObject3.toString());
                    jSONObject2.put("log_extra", jSONObject3.toString());
                }
                String strOptString2 = jSONObject.optString("cid");
                jSONObject2.put("creativeID", strOptString2);
                map2.put("creative_id", strOptString2);
                map2.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                String strN2 = com.byazt.rd.qg.n(uri, "owner_open_id");
                if (TextUtils.isEmpty(strN2)) {
                    strN2 = com.byazt.rd.qg.n(uri, "user_id");
                }
                map2.put("owner_open_id", strN2);
                String strN3 = com.byazt.rd.qg.n(uri, "pangle_live_room_data");
                if (!TextUtils.isEmpty(strN3)) {
                    map2.put("pangle_live_room_data", strN3);
                }
                map2.put("request_id", com.byazt.rd.qg.n(uri, "request_id"));
            } catch (Exception unused) {
            }
        }
        return map2;
    }

    @Override // com.byazt.op.q
    public boolean a_(pk pkVar) {
        return n((cp) pkVar) && this.n != null;
    }

    @Override // com.byazt.op.n, com.byazt.op.q
    public void n(final String str, final pk pkVar, final long j) {
        com.byazt.ag.qg.qg(new Runnable() { // from class: com.byazt.op.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.qg(str, pkVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(String str, pk pkVar, long j) {
        try {
            if (this.n == null) {
                return;
            }
            Map<String, String> mapN = n(pkVar, (Map<String, Object>) null);
            Map<String, String> mapN2 = com.byazt.gks.n.n(rv.getContext());
            mapN2.put("room_id", mapN.get("room_id"));
            mapN2.put("anchor_id", mapN.get("owner_open_id"));
            mapN2.put("enter_from_merge", mapN.get("enter_from_merge"));
            mapN2.put("enter_method", mapN.get("enter_method"));
            mapN2.put("action_type", "click");
            mapN2.put("request_id", mapN.get("request_id"));
            mapN2.put(MediationConstant.EXTRA_DURATION, new StringBuilder().append(j).toString());
            mapN2.put("is_other_channel", "union_ad");
            mapN2.put("IESLiveEffectAdTrackExtraServiceKey", mapN.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : mapN2.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.n.apply(com.byazt.of.qg.n().n(4).n(Void.class).n(0, str).n(1, jSONObject).qg());
        } catch (Throwable th) {
            if (k.s()) {
                k.n("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    @Override // com.byazt.op.q
    public int qg() {
        if (this.n != null) {
            try {
                Object objApply = this.n.apply(com.byazt.of.qg.n().n(3).n(Object.class).n(0, 1).qg());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.byazt.op.q
    public int qg(pk pkVar) {
        if (this.n != null) {
            long jN = n(pkVar);
            if (jN == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", jN);
                Object objApply = this.n.apply(com.byazt.of.qg.n().n(3).n(Object.class).n(0, 2).n(1, bundle).qg());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    @Override // com.byazt.op.q
    public int l() {
        boolean zBooleanValue = false;
        if (this.n != null) {
            try {
                Object objApply = this.n.apply(com.byazt.of.qg.n().n(3).n(Object.class).n(0, 3).qg());
                if (objApply instanceof Boolean) {
                    zBooleanValue = ((Boolean) objApply).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        return zBooleanValue ? 2 : 1;
    }

    @Override // com.byazt.op.q
    public boolean w() {
        return qg() == 2;
    }

    @Override // com.byazt.op.q
    public String x() {
        if (this.n == null) {
            return null;
        }
        try {
            Object objApply = this.n.apply(com.byazt.of.qg.n().n(3).n(Object.class).n(0, 4).qg());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.op.q
    public int n(cp cpVar, s sVar, String str, Map<String, Object> map) {
        if (cpVar == null || TextUtils.isEmpty(cpVar.C_()) || this.n == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", cpVar.C_());
            Object objApply = this.n.apply(com.byazt.of.qg.n().n(3).n(Object.class).n(0, 5).n(1, bundle).qg());
            if (objApply == null) {
                return 4;
            }
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    @Override // com.byazt.op.q
    public JSONObject fs() {
        return this.s;
    }

    @Override // com.byazt.op.q
    public int n(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", str);
            Object objApply = this.n.apply(com.byazt.of.qg.n().n(3).n(Object.class).n(0, 6).n(1, bundle).qg());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
