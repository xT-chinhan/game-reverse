package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    JSONArray ab;
    int ah;
    boolean c;
    int ch;
    int d;
    private boolean hi;
    boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    String f2105ms;
    String ny;
    boolean x;
    int xr;

    private ah(String str, int i, int i2, int i3, boolean z, boolean z2, JSONArray jSONArray, boolean z3, com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms msVar, int i4, boolean z4) {
        this.f2105ms = str;
        this.xr = i;
        this.ah = i2;
        this.d = i3;
        this.ka = z;
        this.c = z2;
        this.ab = jSONArray;
        this.x = z3;
        this.ny = msVar.x();
        this.ch = i4;
        this.hi = z4;
    }

    public String ms() {
        return this.f2105ms;
    }

    public int xr() {
        return this.xr;
    }

    public int ah() {
        return this.ah;
    }

    public boolean d() {
        return this.ka;
    }

    public boolean ka() {
        return this.c;
    }

    public boolean c() {
        return this.x;
    }

    public String ab() {
        return this.ny;
    }

    public int x() {
        return this.ch;
    }

    public Map<Integer, Boolean> ny() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.ab.length(); i++) {
            try {
                map.put((Integer) this.ab.get(i), Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        return map;
    }

    public ah(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f2105ms = jSONObject.optString("meta_md5");
            this.xr = jSONObject.optInt("consume_time");
            this.ah = jSONObject.optInt("reduce_time");
            this.ka = jSONObject.optBoolean("is_video_completed");
            this.c = jSONObject.optBoolean("is_user_interacted");
            this.ab = jSONObject.optJSONArray("reward_verify_array");
            this.x = jSONObject.optBoolean("is_mute");
            this.ny = jSONObject.optString("play_again_string");
            this.ch = jSONObject.optInt("carousel_type");
            this.d = jSONObject.optInt("eternal_global_time");
            this.hi = jSONObject.optBoolean("first_ad_is_video");
        } catch (Exception unused) {
        }
    }

    public JSONObject ch() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("meta_md5", this.f2105ms);
            jSONObject.put("consume_time", this.xr);
            jSONObject.put("reduce_time", this.ah);
            jSONObject.put("is_video_completed", this.ka);
            jSONObject.put("is_user_interacted", this.c);
            jSONObject.put("reward_verify_array", this.ab);
            jSONObject.put("is_mute", this.x);
            jSONObject.put("play_again_string", this.ny);
            jSONObject.put("carousel_type", this.ch);
            jSONObject.put("eternal_global_time", this.d);
            jSONObject.put("first_ad_is_video", this.hi);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int hi() {
        return this.d;
    }

    public boolean sl() {
        return this.hi;
    }

    public static class ms {
        boolean ab;
        int ah;
        JSONArray c;
        boolean ch;
        boolean d;
        com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms hi;
        boolean ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f2106ms;
        int ny;
        int x;
        int xr;

        public ah ms() {
            return new ah(this.f2106ms, this.xr, this.ah, this.ny, this.d, this.ka, this.c, this.ab, this.hi, this.x, this.ch);
        }

        public ms ms(String str) {
            this.f2106ms = str;
            return this;
        }

        public ms ms(int i) {
            this.xr = i;
            return this;
        }

        public ms xr(int i) {
            this.ah = i;
            return this;
        }

        public ms ms(boolean z) {
            this.d = z;
            return this;
        }

        public ms xr(boolean z) {
            this.ka = z;
            return this;
        }

        public ms ms(Set<Integer> set) {
            this.c = new JSONArray((Collection) set);
            return this;
        }

        public ms ah(boolean z) {
            this.ab = z;
            return this;
        }

        public ms ms(com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms msVar) {
            this.hi = msVar;
            return this;
        }

        public ms ah(int i) {
            this.x = i;
            return this;
        }

        public ms d(int i) {
            this.ny = i;
            return this;
        }

        public ms d(boolean z) {
            this.ch = z;
            return this;
        }
    }
}
