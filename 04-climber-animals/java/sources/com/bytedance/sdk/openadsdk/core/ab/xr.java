package com.bytedance.sdk.openadsdk.core.ab;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private int ah;
    private boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1892ms;
    private int xr;

    public int ms() {
        return this.f1892ms;
    }

    public void ms(int i) {
        this.f1892ms = i;
    }

    public int xr() {
        return this.xr;
    }

    public void xr(int i) {
        this.xr = i;
    }

    public int ah() {
        return this.ah;
    }

    public void ah(int i) {
        this.ah = i;
    }

    public static xr ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ms(new JSONObject(str));
        } catch (JSONException e) {
            sl.xr("CLogConfig", "parse failed:".concat(String.valueOf(e)));
            return null;
        }
    }

    public static xr ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xr xrVar = new xr();
        xrVar.xr(jSONObject.optInt("expire_days"));
        xrVar.ms(jSONObject.optInt("log_level"));
        xrVar.ah(jSONObject.optInt("max_size"));
        xrVar.ms(jSONObject.optBoolean("is_open"));
        return xrVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", xr());
            jSONObject.put("log_level", ms());
            jSONObject.put("max_size", ah());
            jSONObject.put("is_open", d());
        } catch (JSONException e) {
            sl.ms(e);
        }
        return jSONObject.toString();
    }

    public boolean d() {
        return this.d;
    }

    public void ms(boolean z) {
        this.d = z;
    }
}
