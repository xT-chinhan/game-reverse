package com.byazt.ko;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 33})
public class um extends s {
    public final Context l;

    public um(Context context) {
        super(true, false);
        this.l = context;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature signature;
        String strQg = null;
        try {
            packageInfo = this.l.getPackageManager().getPackageInfo(this.l.getPackageName(), 64);
        } catch (Throwable th) {
            com.byazt.km.cp.qg(th);
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && (signature = packageInfo.signatures[0]) != null) {
            strQg = com.byazt.km.s.qg(signature.toByteArray());
        }
        if (strQg == null) {
            return true;
        }
        jSONObject.put("sig_hash", strQg);
        return true;
    }
}
