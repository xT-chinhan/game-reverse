package com.byazt.bw;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1399, 26})
public class qg {
    public String l;
    public List<Integer> n;
    public String q;
    public JSONObject qg;
    public int s;
    public String w;
    public int x;

    public qg(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("behavior_state");
        if (jSONArrayOptJSONArray != null) {
            this.n = new LinkedList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    this.n.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i)));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rule_excs");
        if (jSONObjectOptJSONObject != null) {
            this.x = jSONObjectOptJSONObject.optInt("condition");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("perform");
            this.qg = jSONObjectOptJSONObject2;
            if (jSONObjectOptJSONObject2 != null) {
                this.s = jSONObjectOptJSONObject2.optInt("condition");
                this.q = this.qg.optString("opt");
                this.l = this.qg.optString(a.C0017a.o);
                this.w = this.qg.optString("rule_timestamp");
            }
        }
    }

    public int n() {
        return this.s;
    }

    public int qg() {
        return this.x;
    }

    public String s() {
        return this.l;
    }

    public String q() {
        return this.w;
    }

    public JSONObject l() {
        return this.qg;
    }

    public boolean n(int i) {
        List<Integer> list = this.n;
        if (list != null) {
            return list.contains(Integer.valueOf(i));
        }
        return false;
    }

    public String w() {
        return this.q;
    }

    public boolean x() {
        return "1".equals(this.q) || "2".equals(this.q) || "3".equals(this.q) || "4".equals(this.q) || "5".equals(this.q);
    }

    public boolean n(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = this.qg.optJSONObject("prime_rits");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(str)) == null) {
            return false;
        }
        return (jSONObjectOptJSONObject.optJSONObject("ssr") == null && jSONObjectOptJSONObject.optJSONObject("srr") == null) ? false : true;
    }

    public double n(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.qg) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2)) == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("ssr")) == null) {
            return 0.0d;
        }
        return jSONObjectOptJSONObject3.optDouble(str, 0.0d);
    }

    public double qg(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (jSONObject = this.qg) == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("prime_rits")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2)) == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("srr")) == null) {
            return 0.0d;
        }
        return jSONObjectOptJSONObject3.optDouble(str, 0.0d);
    }
}
