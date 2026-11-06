package com.byazt.asa;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, 5})
public abstract class q implements com.byazt.vr.n {
    public int fs;
    public long l;
    public long n;
    public com.byazt.vr.qg q;
    public volatile JSONObject qg;
    public com.byazt.vf.n s;
    public String w;
    public String x;

    public static String n(int i) {
        if (i == 2) {
            return "2g";
        }
        if (i == 3) {
            return "3g";
        }
        if (i == 4) {
            return "wifi";
        }
        if (i != 5) {
            return i != 6 ? "mobile" : "5g";
        }
        return "4g";
    }

    public abstract JSONObject n(String str);

    public q(String str, JSONObject jSONObject) {
        this.w = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        this.qg = jSONObject;
        this.n = System.currentTimeMillis();
    }

    @Override // com.byazt.vr.n
    public JSONObject n() {
        if (this.qg == null) {
            synchronized (q.class) {
                if (this.qg == null) {
                    this.qg = n(l());
                }
            }
        }
        return this.qg;
    }

    @Override // com.byazt.vr.n
    public String qg() {
        if (TextUtils.isEmpty(this.w)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.w);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, n());
            jSONObject.put("type", (int) cp());
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public int s() {
        int iN = ((oa) com.byazt.qp.q.n("device_info_new")).n(60000L);
        if (iN == 1) {
            return 0;
        }
        if (iN == 4) {
            return 1;
        }
        if (iN == 5) {
            return 4;
        }
        if (iN != 6) {
            return iN;
        }
        return 6;
    }

    public static String q() {
        int iN = ((oa) com.byazt.qp.q.n("device_info_new")).n(60000L);
        return iN != 0 ? n(iN) : "unknown";
    }

    public void n(com.byazt.vf.n nVar, com.byazt.vr.qg qgVar) {
        this.s = nVar;
        this.q = qgVar;
    }

    public JSONObject n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.put(next, jSONObject.get(next));
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public void qg(String str) {
        this.x = str;
    }

    public String l() {
        return this.x;
    }

    @Override // com.byazt.vr.n
    public String w() {
        return this.w;
    }

    @Override // com.byazt.vr.n
    public long x() {
        return this.n;
    }

    @Override // com.byazt.vr.n
    public void n(long j) {
        this.l = j;
    }

    @Override // com.byazt.vr.n
    public long fs() {
        return this.l;
    }

    @Override // com.byazt.vr.n
    public void qg(int i) {
        this.fs = i;
    }

    @Override // com.byazt.vr.n
    public int rv() {
        return this.fs;
    }
}
