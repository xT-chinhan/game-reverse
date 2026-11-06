package com.bytedance.sdk.openadsdk.core.dislike.ah;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private String ab;
    private String ah;
    private final String c;
    private final boolean d;
    private final String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int f2469ms;
    private final List<c> xr = new ArrayList();

    public xr(JSONObject jSONObject, ah ahVar) {
        boolean z = false;
        this.f2469ms = jSONObject.optInt("dislike_control", 0);
        this.d = jSONObject.optBoolean("close_on_dislike", false);
        String strMs = ahVar != null ? ahVar.ms() : "";
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray != null) {
            boolean zEquals = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                ah ahVarMs = ah.ms(jSONArrayOptJSONArray.optJSONObject(i));
                if (ahVarMs != null && ahVarMs.ka()) {
                    this.xr.add(ahVarMs);
                    if (!zEquals) {
                        zEquals = TextUtils.equals(ahVarMs.ms(), strMs);
                    }
                }
            }
            z = zEquals;
        }
        if (ahVar != null && !z) {
            this.xr.add(ahVar);
        }
        this.ka = jSONObject.optString("ad_id");
        this.c = jSONObject.optString("ext");
    }

    public void ms(JSONObject jSONObject) throws JSONException {
        jSONObject.put("dislike_control", this.f2469ms);
        jSONObject.put("filter_words", c());
        jSONObject.put("close_on_dislike", x());
    }

    public List<c> ms() {
        return this.xr;
    }

    public void ms(String str) {
        this.ah = str;
    }

    public String xr() {
        return this.ah;
    }

    public String ah() {
        return this.ka;
    }

    public String d() {
        return this.c;
    }

    public boolean ka() {
        return this.f2469ms == 1;
    }

    public JSONArray c() {
        JSONObject jSONObjectAb;
        JSONArray jSONArray = new JSONArray();
        List<c> list = this.xr;
        if (list != null) {
            for (c cVar : list) {
                if ((cVar instanceof ah) && (jSONObjectAb = ((ah) cVar).ab()) != null) {
                    jSONArray.put(jSONObjectAb);
                }
            }
        }
        return jSONArray;
    }

    public void xr(String str) {
        this.ab = str;
    }

    public String ab() {
        return this.ab;
    }

    public boolean x() {
        return this.d;
    }
}
