package com.bytedance.sdk.openadsdk.core.ugeno.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.sdk.component.adexpress.ms.ah.ms {
    public xr() {
    }

    public xr(com.bytedance.sdk.component.adexpress.ms.ah.ms msVar) {
        if (msVar != null) {
            ms(msVar.xr());
            xr(msVar.ah());
            ms(msVar.getResources());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ms.ah.ms
    public boolean c() {
        return (TextUtils.isEmpty(ah()) || TextUtils.isEmpty(xr())) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.ms.ah.ms
    public String x() {
        if (!c()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(Common.System.NAME, xr());
            jSONObject.putOpt("version", ah());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms : getResources()) {
                    if (c0231ms != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", c0231ms.ms());
                        jSONObject2.putOpt("md5", c0231ms.xr());
                        jSONObject2.putOpt("level", Integer.valueOf(c0231ms.ah()));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            sl.ms(e);
            return null;
        }
    }

    public static xr ka(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return xr(new JSONObject(str));
        } catch (JSONException e) {
            sl.ms(e);
            return null;
        }
    }

    public static xr xr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xr xrVar = new xr();
        xrVar.ms(jSONObject.optString(Common.System.NAME));
        xrVar.xr(jSONObject.optString("version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms c0231ms = new com.bytedance.sdk.component.adexpress.ms.ah.ms.C0231ms();
                    c0231ms.ms(jSONObjectOptJSONObject.optString("url"));
                    c0231ms.xr(jSONObjectOptJSONObject.optString("md5"));
                    c0231ms.ms(jSONObjectOptJSONObject.optInt("level"));
                    arrayList.add(c0231ms);
                }
            }
        }
        xrVar.ms(arrayList);
        if (xrVar.c()) {
            return xrVar;
        }
        return null;
    }
}
