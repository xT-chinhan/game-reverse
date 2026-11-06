package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class aj implements w {
    final /* synthetic */ ae a;

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(JSONObject jSONObject) {
    }

    aj(ae aeVar) {
        this.a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("interstitial_container", viewGroup);
        map.put("entry", 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.w[0]));
        this.a.a(cy.u, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.g()));
        map.put("entry", 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.w[0]));
        map.put("novel_info", jSONObject);
        this.a.a(cy.v, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("banner_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.g()));
        map.put("entry", 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.w[0]));
        map.put("novel_info", jSONObject);
        this.a.a(cy.w, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("banner_container", viewGroup2);
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.g()));
        map.put("entry", 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.w[0]));
        map.put("backgroundColor", Integer.valueOf(i));
        this.a.a(cy.z, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String strI = this.a.i("get_cuid");
        String strI2 = this.a.i("get_imei");
        String strI3 = this.a.i("get_oaid");
        try {
            jSONObject.put("cuid", strI);
            jSONObject.put("imei", strI2);
            jSONObject.put("oaid", strI3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(long j) {
        this.a.k.a("单次阅读器打开时长 = " + j);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", viewGroup.getContext());
        map.put("banner_container", viewGroup);
        map.put("entry", 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.w[0]));
        this.a.a(cy.y, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.g()));
        map.put("entry", 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.w[0]));
        map.put("count_down", Integer.valueOf(i));
        this.a.a(cy.A, map);
    }
}
