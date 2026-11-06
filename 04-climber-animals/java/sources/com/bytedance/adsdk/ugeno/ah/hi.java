package com.bytedance.adsdk.ugeno.ah;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hi {
    private JSONObject ah;
    private Map<String, Object> d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f330ms;
    private JSONObject xr;

    public Context getContext() {
        return this.f330ms;
    }

    public void ms(Context context) {
        this.f330ms = context;
    }

    public void ms(JSONObject jSONObject) {
        this.xr = jSONObject;
    }

    public JSONObject ms() {
        return this.ah;
    }

    public void xr(JSONObject jSONObject) {
        this.ah = jSONObject;
    }

    public Map<String, Object> xr() {
        return this.d;
    }

    public void ms(Map<String, Object> map) {
        this.d = map;
    }
}
