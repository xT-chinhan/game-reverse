package com.bytedance.sdk.component.adexpress.dynamic.ah;

import com.bytedance.sdk.component.utils.sl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public String ah;
    public String d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public List<ms> f762ms;
    public String xr;

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public int f763ms;
        public JSONObject xr;
    }

    public static d ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    ms msVar = new ms();
                    msVar.f763ms = jSONObjectOptJSONObject.optInt("id");
                    msVar.xr = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(msVar);
                }
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        dVar.f762ms = arrayList;
        dVar.xr = jSONObject.optString("diff_data");
        dVar.ah = jSONObject.optString("style_diff");
        dVar.d = jSONObject.optString("tag_diff");
        return dVar;
    }
}
