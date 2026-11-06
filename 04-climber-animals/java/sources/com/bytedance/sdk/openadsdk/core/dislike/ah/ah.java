package com.bytedance.sdk.openadsdk.core.dislike.ah;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends c {
    private boolean ah;
    private List<c> d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f2467ms;
    private String xr;

    public ah(String str, String str2) {
        super(null);
        this.f2467ms = str;
        this.xr = str2;
    }

    public ah() {
        super(null);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.c
    public String ms() {
        return this.f2467ms;
    }

    public void ms(String str) {
        this.f2467ms = str;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.c
    public String xr() {
        return this.xr;
    }

    public void xr(String str) {
        this.xr = str;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.c
    public boolean ah() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.c
    public void ms(boolean z) {
        this.ah = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.c
    public List<c> d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.c
    public void ms(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.c
    public boolean ka() {
        return (TextUtils.isEmpty(this.f2467ms) || TextUtils.isEmpty(this.xr)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.c
    public boolean c() {
        List<c> list = this.d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static ah ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            ah ahVar = new ah();
            ahVar.ms(jSONObject.optString("id"));
            ahVar.xr(jSONObject.optString(Common.System.NAME));
            ahVar.ms(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    ah ahVarMs = ms(jSONArrayOptJSONArray.optJSONObject(i));
                    if (ahVarMs != null && ahVarMs.ka()) {
                        ahVar.ms(ahVarMs);
                    }
                }
            }
            return ahVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject ab() {
        try {
            if (!ka()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", ms());
            jSONObject.put(Common.System.NAME, xr());
            jSONObject.put("is_selected", ah());
            if (c()) {
                JSONArray jSONArray = new JSONArray();
                for (c cVar : d()) {
                    if (cVar instanceof ah) {
                        jSONArray.put(((ah) cVar).ab());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("options", jSONArray);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
