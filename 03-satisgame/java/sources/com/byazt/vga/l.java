package com.byazt.vga;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.f.h;
import com.byazt.ho.BaseConstants;
import com.byazt.vf.cp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 978, 18})
public class l extends qg {
    @Override // com.byazt.vga.qg
    public String n() {
        return "adevent";
    }

    public l(Context context, com.byazt.vr.w wVar, com.byazt.vr.qg qgVar, cp cpVar) {
        super(context, qgVar, wVar == null ? com.byazt.blx.n.s() : wVar, cpVar);
    }

    @Override // com.byazt.fa.n
    public boolean n(com.byazt.vr.n nVar) {
        return com.byazt.hls.q.x(nVar);
    }

    @Override // com.byazt.vga.qg
    public com.byazt.asa.q n(JSONObject jSONObject, String str, int i) throws JSONException {
        String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                String strOptString2 = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString2);
                    jSONObject2.put(h.b.h, i);
                    jSONObject2.put("db_rd", System.currentTimeMillis());
                    jSONObjectOptJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                    jSONObject.put("params", jSONObjectOptJSONObject);
                }
            }
        } else {
            JSONObject jSONObject3 = new JSONObject(strOptString);
            jSONObject3.put(h.b.h, i);
            jSONObject3.put("db_rd", System.currentTimeMillis());
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject3.toString());
        }
        return n(str, jSONObject);
    }

    public com.byazt.asa.q n(String str, JSONObject jSONObject) {
        return new com.byazt.asa.l(str, jSONObject);
    }
}
