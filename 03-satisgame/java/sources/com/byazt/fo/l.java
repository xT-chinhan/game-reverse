package com.byazt.fo;

import android.text.TextUtils;
import com.byazt.km.cp;
import com.byazt.km.sz;
import com.byazt.ko.rv;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1154, 18})
public class l extends qg {
    public boolean l;
    public static final long[] qg = {920000};
    public static final long[] s = {920000};
    public static final long[] q = {10000, 10000, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    @Override // com.byazt.fo.qg
    public String q() {
        return "r";
    }

    public l(q qVar) {
        super(qVar);
        this.l = true;
    }

    @Override // com.byazt.fo.qg
    public long n() {
        return this.n.q().oa() + ((long) (this.n.w().s() ? 21600000 : 43200000));
    }

    @Override // com.byazt.fo.qg
    public long[] qg() {
        int iD = this.n.q().d();
        if (iD == 0) {
            return q;
        }
        if (iD == 1) {
            return s;
        }
        if (iD == 2) {
            return qg;
        }
        cp.qg((Throwable) null);
        return s;
    }

    @Override // com.byazt.fo.qg
    public boolean s() throws JSONException {
        JSONObject jSONObjectN;
        JSONObject jSONObject = new JSONObject();
        rv rvVarQ = this.n.q();
        JSONObject jSONObjectN2 = rvVarQ.n();
        JSONObject jSONObject2 = null;
        if (jSONObjectN2 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            synchronized (rvVarQ) {
                jSONObjectN = sz.n(jSONObjectN2);
            }
            jSONObject.put("header", jSONObjectN);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(jSONObjectN.optString(TapEventParamConstants.PARAM_DEVICE_ID)) && sz.s() && this.l) {
                this.l = false;
                return false;
            }
            JSONObject jSONObjectN3 = this.n.q().n();
            com.byazt.jy.s sVarN = com.byazt.jy.n.n(com.byazt.jy.qg.n(this.n.getContext(), jSONObjectN3, this.n.x().n(), true, com.byazt.wv.n.q()), jSONObject);
            if (sVarN != null && sVarN.n() != null) {
                try {
                    jSONObject2 = new JSONObject(sVarN.n());
                } catch (JSONException unused) {
                }
            }
            if (jSONObject2 != null) {
                String strOptString = jSONObject2.optString(TapEventParamConstants.PARAM_DEVICE_ID, "");
                boolean zN = this.n.q().n(jSONObject2, strOptString, jSONObject2.optString("install_id", ""), jSONObject2.optString("ssid", ""));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.toString());
                jSONObject3.put("headers", sVarN.qg());
                sz.qg(jSONObject, jSONObject3);
                com.byazt.nt.n.qg("__kite", "start:" + sz.l());
                try {
                    if (sz.l()) {
                        new com.byazt.kn.qg(this.n.getContext()).n(jSONObjectN3, strOptString);
                    }
                } catch (Throwable th) {
                    com.byazt.nt.n.n("__kite", "error:" + sz.l(), th);
                }
                return zN;
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("headers", sVarN.qg());
            sz.qg(jSONObject, jSONObject4);
        } else {
            cp.qg((Throwable) null);
        }
        return false;
    }
}
