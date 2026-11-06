package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class db implements w {
    final /* synthetic */ cy a;

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(JSONObject jSONObject) {
    }

    db(cy cyVar) {
        this.a = cyVar;
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("interstitial_container", viewGroup);
        map.put("entry", Integer.valueOf(this.a.G));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.H));
        map.put("novel_id", this.a.I);
        this.a.a(cy.u, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.g()));
        map.put("entry", Integer.valueOf(this.a.G));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.H));
        map.put("novel_id", this.a.I);
        map.put("novel_info", jSONObject);
        this.a.a(cy.v, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("banner_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.g()));
        map.put("entry", Integer.valueOf(this.a.G));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.H));
        map.put("novel_id", this.a.I);
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
        map.put("entry", Integer.valueOf(this.a.G));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.H));
        map.put("novel_id", this.a.I);
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
        if (this.a.K != null) {
            this.a.K.onReadTime(j);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", viewGroup.getContext());
        map.put("banner_container", viewGroup);
        map.put("entry", Integer.valueOf(this.a.G));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.H));
        map.put("novel_id", this.a.I);
        map.put("isnight", Boolean.valueOf(this.a.x()));
        this.a.a(cy.y, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(ViewGroup viewGroup, int i) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.g()));
        map.put("entry", Integer.valueOf(this.a.G));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.H));
        map.put("novel_id", this.a.I);
        map.put("count_down", Integer.valueOf(i));
        this.a.a(cy.A, map);
    }

    @Override // com.baidu.mobads.sdk.internal.w
    public void a(boolean z) {
        RelativeLayout relativeLayout;
        if (this.a.L == null || (relativeLayout = (RelativeLayout) this.a.L.get()) == null) {
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", (Activity) this.a.i);
        map.put("interstitial_container", null);
        map.put("banner_container", relativeLayout);
        map.put("entry", Integer.valueOf(this.a.G));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.H));
        map.put("novel_id", this.a.I);
        map.put("isnight", Boolean.valueOf(this.a.x()));
        this.a.a(cy.z, map);
    }
}
