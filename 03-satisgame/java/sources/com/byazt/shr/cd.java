package com.byazt.shr;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, 86})
public class cd {
    public JSONObject l;
    public byte[] n;
    public int q;
    public Map<String, String> qg;
    public JSONObject s;

    public JSONObject n() {
        return this.l;
    }

    public void n(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public int qg() {
        return this.q;
    }

    public void n(int i) {
        this.q = i;
    }

    public byte[] s() {
        return this.n;
    }

    public void n(byte[] bArr) {
        this.n = bArr;
    }

    public JSONObject q() {
        return this.s;
    }

    public void qg(JSONObject jSONObject) {
        this.s = jSONObject;
    }

    public Map<String, String> l() {
        return this.qg;
    }

    public void n(Map<String, String> map) {
        this.qg = map;
    }
}
