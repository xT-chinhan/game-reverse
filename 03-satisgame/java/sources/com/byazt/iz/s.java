package com.byazt.iz;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 861, 8})
public class s {
    public JSONObject n;

    public s(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public boolean n() {
        JSONObject jSONObject = this.n;
        return jSONObject == null || jSONObject.optInt("enable_install_notification", 1) == 1;
    }

    public boolean qg() {
        JSONObject jSONObject = this.n;
        return jSONObject == null || jSONObject.optInt("enable_active_notification", 1) == 1;
    }

    public boolean s() {
        JSONObject jSONObject = this.n;
        return jSONObject != null && jSONObject.optInt("enable_install_interface", 0) == 1;
    }

    public long q() {
        JSONObject jSONObject = this.n;
        if (jSONObject == null) {
            return 300L;
        }
        return jSONObject.optLong("uninstall_delay", 300L);
    }

    public long l() {
        JSONObject jSONObject = this.n;
        if (jSONObject == null) {
            return 1800L;
        }
        return jSONObject.optLong("notification_internal", 1800L);
    }

    public int w() {
        JSONObject jSONObject = this.n;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_notification", 1);
    }

    public int x() {
        JSONObject jSONObject = this.n;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_interface", 1);
    }
}
