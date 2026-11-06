package com.byazt.ez;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.aqe.tj;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1378, 8})
public class s extends n {
    @Override // com.byazt.aqe.qg
    public int x() {
        return 1;
    }

    public s(Activity activity, pk pkVar, ry ryVar) {
        super(activity, pkVar, ryVar);
    }

    @Override // com.byazt.aqe.qg
    public boolean w() {
        return (TextUtils.isEmpty(this.cp) || TextUtils.isEmpty(this.d)) ? false : true;
    }

    @Override // com.byazt.ez.n, com.byazt.aqe.qg
    public com.byazt.aqe.qg.n n(tj tjVar) {
        return s(tjVar);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reward_name", this.cp);
            jSONObject.put("reward_amount", this.d);
            jSONObject.put("extra_info", this.n);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
