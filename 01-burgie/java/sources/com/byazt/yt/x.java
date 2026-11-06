package com.byazt.yt;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.vkw.g;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1312, 121})
public abstract class x implements com.byazt.hh.pr {
    public long c;
    public String fw;
    public com.byazt.vkw.pr hn;
    public volatile JSONObject hw;
    public long pr;
    public String uc;
    public com.byazt.hh.hw x;
    public int zo;

    public abstract JSONObject pr(String str);

    public x(String str, JSONObject jSONObject) {
        this.uc = TextUtils.isEmpty(str) ? UUID.randomUUID().toString() : str;
        this.hw = jSONObject;
        this.pr = System.currentTimeMillis();
    }

    @Override // com.byazt.hh.pr
    public JSONObject pr() {
        if (this.hw == null) {
            synchronized (x.class) {
                if (this.hw == null) {
                    this.hw = pr(c());
                }
            }
        }
        return this.hw;
    }

    @Override // com.byazt.hh.pr
    public String hw() {
        if (!TextUtils.isEmpty(this.uc)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("localId", this.uc);
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, pr());
                jSONObject.put("type", (int) w());
            } catch (Throwable th) {
            }
            return jSONObject.toString();
        }
        return null;
    }

    public int hn() {
        int iPr = ((g) com.byazt.zs.uc.pr("device_info_new")).pr(60000L);
        switch (iPr) {
            case 1:
                return 0;
            case 2:
            case 3:
            default:
                return iPr;
            case 4:
                return 1;
            case 5:
                return 4;
            case 6:
                return 6;
        }
    }

    public static String x() {
        int iPr = ((g) com.byazt.zs.uc.pr("device_info_new")).pr(60000L);
        switch (iPr) {
            case 0:
                return "unknown";
            default:
                return pr(iPr);
        }
    }

    public static String pr(int i) {
        switch (i) {
            case 2:
                return NetworkUtil.NETWORK_CLASS_2G;
            case 3:
                return NetworkUtil.NETWORK_CLASS_3G;
            case 4:
                return NetworkUtil.NETWORK_TYPE_WIFI;
            case 5:
                return NetworkUtil.NETWORK_CLASS_4G;
            case 6:
                return NetworkUtil.NETWORK_CLASS_5G;
            default:
                return "mobile";
        }
    }

    public void pr(com.byazt.vkw.pr prVar, com.byazt.hh.hw hwVar) {
        this.hn = prVar;
        this.x = hwVar;
    }

    public JSONObject pr(JSONObject jSONObject, JSONObject jSONObject2) {
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
        } catch (Exception e) {
        }
        return jSONObject2;
    }

    public void hw(String str) {
        this.fw = str;
    }

    public String c() {
        return this.fw;
    }

    @Override // com.byazt.hh.pr
    public String uc() {
        return this.uc;
    }

    @Override // com.byazt.hh.pr
    public long fw() {
        return this.pr;
    }

    @Override // com.byazt.hh.pr
    public void pr(long j) {
        this.c = j;
    }

    @Override // com.byazt.hh.pr
    public long zo() {
        return this.c;
    }

    @Override // com.byazt.hh.pr
    public void hw(int i) {
        this.zo = i;
    }

    @Override // com.byazt.hh.pr
    public int aj() {
        return this.zo;
    }
}
