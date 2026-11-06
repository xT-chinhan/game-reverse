package com.bytedance.sdk.openadsdk.core.nw;

import com.meta.android.mpg.cm.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class az {
    private JSONArray ab;
    private boolean ah;
    private String c;
    private ms ch;
    private String d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3033ms;
    private xr ny;
    private int x;
    private boolean xr;

    public static az ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        az azVar = new az();
        azVar.f3033ms = jSONObject.optString("promotion_id");
        azVar.xr = jSONObject.optBoolean("is_silent_auth", false);
        azVar.ah = jSONObject.optBoolean("enable_playable_auth", false);
        azVar.d = jSONObject.optString("aweme_agreements");
        azVar.ka = jSONObject.optString("aweme_privacy");
        azVar.c = jSONObject.optString("live_csj_libra_param");
        azVar.ab = jSONObject.optJSONArray("tasks");
        azVar.x = jSONObject.optInt("live_playable");
        azVar.ch = ms.ms(jSONObject.optJSONObject(BuildConfig.FLAVOR));
        azVar.ny = xr.ms(jSONObject.optJSONObject("coupon"));
        return azVar;
    }

    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.f3033ms);
            jSONObject.put("is_silent_auth", this.xr);
            jSONObject.put("enable_playable_auth", this.ah);
            jSONObject.put("aweme_agreements", this.d);
            jSONObject.put("aweme_privacy", this.ka);
            jSONObject.put("live_csj_libra_param", this.c);
            jSONObject.put("tasks", this.ab);
            jSONObject.put("live_playable", this.x);
            ms msVar = this.ch;
            if (msVar != null) {
                jSONObject.put(BuildConfig.FLAVOR, msVar.ka());
            }
            xr xrVar = this.ny;
            if (xrVar != null) {
                jSONObject.put("coupon", xrVar.ah());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }

    public String xr() {
        return this.f3033ms;
    }

    public boolean ah() {
        return this.xr;
    }

    public boolean d() {
        return this.ah;
    }

    public String ka() {
        return this.d;
    }

    public String c() {
        return this.ka;
    }

    public String ab() {
        return this.c;
    }

    public JSONArray x() {
        return this.ab;
    }

    public boolean ny() {
        return this.x == 2 && this.ah;
    }

    public xr ch() {
        return this.ny;
    }

    public ms hi() {
        return this.ch;
    }

    public static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f3035ms;
        int xr;

        public static xr ms(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            xr xrVar = new xr();
            xrVar.f3035ms = jSONObject.optInt(com.tapsdk.tapad.internal.tracker.experiment.d.q);
            xrVar.xr = jSONObject.optInt("threshold");
            return xrVar;
        }

        public int ms() {
            return this.f3035ms;
        }

        public int xr() {
            return this.xr;
        }

        public JSONObject ah() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.tapsdk.tapad.internal.tracker.experiment.d.q, this.f3035ms);
                jSONObject.put("threshold", this.xr);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static class ms {
        double ah;
        double d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f3034ms;
        String xr;

        public static ms ms(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            ms msVar = new ms();
            msVar.f3034ms = jSONObject.optString("title");
            msVar.xr = jSONObject.optString("image");
            msVar.d = jSONObject.optDouble("price");
            msVar.ah = jSONObject.optDouble("origin_price");
            return msVar;
        }

        public String ms() {
            return this.f3034ms;
        }

        public String xr() {
            return this.xr;
        }

        public double ah() {
            return this.ah;
        }

        public double d() {
            return this.d;
        }

        public JSONObject ka() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.f3034ms);
                jSONObject.put("image", this.xr);
                jSONObject.put("price", this.d);
                jSONObject.put("origin_price", this.ah);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }
}
