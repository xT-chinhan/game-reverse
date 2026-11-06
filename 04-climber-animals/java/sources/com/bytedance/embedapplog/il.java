package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class il extends le {
    private final Context ka;

    il(Context context) {
        super(true, false);
        this.ka = context;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature signature;
        String strXr = null;
        try {
            packageInfo = this.ka.getPackageManager().getPackageInfo(this.ka.getPackageName(), 64);
        } catch (Throwable th) {
            oh.xr(th);
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && (signature = packageInfo.signatures[0]) != null) {
            strXr = gy.xr(signature.toByteArray());
        }
        if (strXr == null) {
            return true;
        }
        jSONObject.put("sig_hash", strXr);
        return true;
    }
}
