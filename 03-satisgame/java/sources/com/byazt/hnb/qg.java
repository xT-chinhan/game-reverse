package com.byazt.hnb;

import android.os.Build;
import com.byazt.nf.rv;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1322, 26})
public class qg {
    public static qg n = new qg();
    public volatile int qg = -1;
    public volatile long s = 0;
    public volatile long q = 0;

    private qg() {
    }

    public static qg n() {
        return n;
    }

    public long qg() {
        return this.s;
    }

    public long s() {
        return this.q;
    }

    public void n(long j, long j2) {
        this.s = j;
        this.q = j2;
    }

    public void q() {
        JSONObject jSONObjectOx = rv.qg().ox();
        if (jSONObjectOx == null) {
            this.qg = 1;
        }
        if (n(jSONObjectOx)) {
            new com.byazt.sb.s().n(jSONObjectOx, this.qg);
        } else if (qg(jSONObjectOx)) {
            new com.byazt.sb.qg().n(jSONObjectOx, this.qg);
        } else {
            this.qg = 1;
        }
    }

    public boolean l() {
        return this.qg == 0 || this.qg == 3;
    }

    public boolean n(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 != null && str3 != null) {
            return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
        }
        if (str2 != null) {
            return str2.equalsIgnoreCase(str);
        }
        if (str3 != null) {
            return str3.equalsIgnoreCase(str);
        }
        return false;
    }

    public int w() {
        if (!com.byazt.vyf.s.cy().q()) {
            return 0;
        }
        if (this.qg == -1) {
            int iK = com.byazt.ed.s.n().k();
            if (iK == -1) {
                if (rv.qg().ox() == null) {
                    this.qg = 1;
                } else {
                    this.qg = 2;
                }
            } else {
                this.qg = iK;
            }
        }
        return this.qg;
    }

    public void n(int i) {
        if (this.qg != i) {
            com.byazt.ed.s.n().w(i);
        }
        this.qg = i;
    }

    public boolean n(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("register")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (n(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean qg(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("callback")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (n(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
