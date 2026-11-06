package com.byazt.na;

import android.os.Build;
import com.byazt.kd.hn;
import com.byazt.kd.hw;
import com.byazt.mp.x;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 548, 37})
public class pr {
    public static pr pr = new pr();
    public volatile int hw = -1;
    public volatile long hn = 0;
    public volatile long x = 0;

    private pr() {
    }

    public static pr pr() {
        return pr;
    }

    public long hw() {
        return this.hn;
    }

    public long hn() {
        return this.x;
    }

    public void pr(long j, long j2) {
        this.hn = j;
        this.x = j2;
    }

    public void x() {
        JSONObject jSONObjectXg = a.hw().xg();
        if (jSONObjectXg == null) {
            this.hw = 1;
        }
        if (pr(jSONObjectXg)) {
            new hn().pr(jSONObjectXg, this.hw);
        } else if (hw(jSONObjectXg)) {
            new hw().pr(jSONObjectXg, this.hw);
        } else {
            this.hw = 1;
        }
    }

    public boolean c() {
        return this.hw == 0 || this.hw == 3;
    }

    public boolean pr(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.BRAND;
        if (str2 != null && str3 != null) {
            return str2.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str);
        }
        if (str2 != null) {
            return str2.equalsIgnoreCase(str);
        }
        if (str3 == null) {
            return false;
        }
        return str3.equalsIgnoreCase(str);
    }

    public int uc() {
        if (!zo.nt().x()) {
            return 0;
        }
        if (this.hw == -1) {
            int iNt = x.pr().nt();
            if (iNt == -1) {
                if (a.hw().xg() == null) {
                    this.hw = 1;
                } else {
                    this.hw = 2;
                }
            } else {
                this.hw = iNt;
            }
        }
        return this.hw;
    }

    public void pr(int i) {
        if (this.hw != i) {
            x.pr().uc(i);
        }
        this.hw = i;
    }

    public boolean pr(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("register")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (pr(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hw(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("callback")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (pr(jSONArrayOptJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
