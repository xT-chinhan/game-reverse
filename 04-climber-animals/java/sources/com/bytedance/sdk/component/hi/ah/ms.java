package com.bytedance.sdk.component.hi.ah;

import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.umeng.ccg.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1235ms;
    private String xr;
    private final Map<String, String> d = new HashMap();
    private List<C0247ms> ka = new ArrayList();
    private final List<C0247ms> c = new ArrayList();
    private final List<C0247ms> ab = new ArrayList();

    public String ms() {
        return this.f1235ms;
    }

    public String xr() {
        return this.xr;
    }

    public Map<String, String> ah() {
        return this.d;
    }

    public List<C0247ms> d() {
        return this.ka;
    }

    public ms(JSONObject jSONObject) {
        ms(jSONObject);
    }

    public void ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f1235ms = jSONObject.optString(Common.System.NAME);
        this.ah = jSONObject.optInt(a.H);
        this.xr = jSONObject.optString("scheme");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.d.put(next, jSONObjectOptJSONObject.optString(next));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("next");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.ka.add(new C0247ms(jSONObjectOptJSONObject2.optString(Common.System.NAME), jSONObjectOptJSONObject2.optString("condition")));
                }
            }
        } else {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("next");
            if (jSONObjectOptJSONObject3 != null) {
                this.ka.add(new C0247ms(jSONObjectOptJSONObject3.optString(Common.System.NAME), jSONObjectOptJSONObject3.optString("condition")));
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("callback");
        if (jSONObjectOptJSONObject4 == null) {
            jSONObjectOptJSONObject4 = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("success");
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
            if (jSONObjectOptJSONObject5 != null) {
                this.c.add(new C0247ms(jSONObjectOptJSONObject5.optString(Common.System.NAME), jSONObjectOptJSONObject5.optString("condition")));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray(TrackAction.FAIL);
        if (jSONArrayOptJSONArray3 == null) {
            jSONArrayOptJSONArray3 = new JSONArray();
        }
        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
            if (jSONObjectOptJSONObject6 != null) {
                this.ab.add(new C0247ms(jSONObjectOptJSONObject6.optString(Common.System.NAME), jSONObjectOptJSONObject6.optString("condition")));
            }
        }
    }

    public List<C0247ms> ka() {
        return this.c;
    }

    public List<C0247ms> c() {
        return this.ab;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.hi.ah.ms$ms, reason: collision with other inner class name */
    public static class C0247ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f1236ms;
        private String xr;

        public String ms() {
            return this.f1236ms;
        }

        public String xr() {
            return this.xr;
        }

        public C0247ms(String str, String str2) {
            this.f1236ms = str;
            this.xr = str2;
        }
    }
}
