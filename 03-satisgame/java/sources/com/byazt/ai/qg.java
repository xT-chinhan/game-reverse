package com.byazt.ai;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2168, 26})
public class qg extends com.byazt.px.n {
    public qg() {
    }

    public qg(com.byazt.px.n nVar) {
        if (nVar != null) {
            n(nVar.qg());
            qg(nVar.s());
            n(nVar.getResources());
        }
    }

    @Override // com.byazt.px.n
    public boolean w() {
        return (TextUtils.isEmpty(s()) || TextUtils.isEmpty(qg())) ? false : true;
    }

    @Override // com.byazt.px.n
    public String fs() {
        if (!w()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(TapEventParamConstants.PARAM_NAME, qg());
            jSONObject.putOpt("version", s());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (com.byazt.px.n.C0308n c0308n : getResources()) {
                    if (c0308n != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt(ImagesContract.URL, c0308n.n());
                        jSONObject2.putOpt("md5", c0308n.qg());
                        jSONObject2.putOpt("level", Integer.valueOf(c0308n.s()));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static qg l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return qg(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static qg qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        qg qgVar = new qg();
        qgVar.n(jSONObject.optString(TapEventParamConstants.PARAM_NAME));
        qgVar.qg(jSONObject.optString("version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    com.byazt.px.n.C0308n c0308n = new com.byazt.px.n.C0308n();
                    c0308n.n(jSONObjectOptJSONObject.optString(ImagesContract.URL));
                    c0308n.qg(jSONObjectOptJSONObject.optString("md5"));
                    c0308n.n(jSONObjectOptJSONObject.optInt("level"));
                    arrayList.add(c0308n);
                }
            }
        }
        qgVar.n(arrayList);
        if (qgVar.w()) {
            return qgVar;
        }
        return null;
    }
}
