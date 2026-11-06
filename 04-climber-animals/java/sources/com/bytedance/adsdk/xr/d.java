package com.bytedance.adsdk.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c {
    @Override // com.bytedance.adsdk.xr.c
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public String ms(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length == 3) {
            String strValueOf = String.valueOf(objArr[0]);
            if (TextUtils.isEmpty(strValueOf)) {
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strValueOf);
                String strValueOf2 = String.valueOf(objArr[1]);
                if (TextUtils.isEmpty(strValueOf2)) {
                    return null;
                }
                Object objMs = com.bytedance.adsdk.xr.xr.ms.ms(strValueOf2).ms(jSONObject2);
                if (TextUtils.isEmpty(String.valueOf(objMs))) {
                    return String.valueOf(objArr[2]);
                }
                return String.valueOf(objMs);
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
        return null;
    }
}
