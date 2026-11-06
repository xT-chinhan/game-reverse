package com.byazt.iz;

import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.vf.k;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 861, 21})
public class x implements q {
    public s n;

    @Override // com.byazt.iz.q
    public boolean qg(com.byazt.esa.n nVar) {
        return false;
    }

    public x(s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.iz.q
    public boolean n(final com.byazt.esa.n nVar) {
        if (!this.n.s()) {
            return false;
        }
        long jQ = this.n.q();
        final com.byazt.mi.qg qgVarN = com.byazt.ms.rv.n();
        if (qgVarN == null || !n(1440L, this.n.x())) {
            return false;
        }
        com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.iz.x.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("app_name", nVar.n());
                map.put("app_icon_url", nVar.qg());
                map.put("event_id", Integer.valueOf(nVar.q()));
                map.put("package_name", nVar.s());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(e.a.d, nVar.fs());
                    jSONObject.putOpt("log_extra", nVar.l());
                    jSONObject.putOpt("tag", nVar.x());
                    jSONObject.putOpt(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, nVar.tj());
                    jSONObject.putOpt("save_path", nVar.rv());
                } catch (Exception unused) {
                }
                boolean zQg = com.byazt.vgx.w.qg(nVar.s());
                map.put("event_token", ((k) com.byazt.qp.q.n("encrypt_service")).s(jSONObject.toString()));
                qgVarN.n(zQg ? 102 : 101, map);
            }
        }, jQ * 1000);
        return true;
    }

    public boolean n(long j, int i) {
        try {
            Long lValueOf = -1L;
            try {
                lValueOf = Long.valueOf(j * 60 * 1000);
            } catch (Exception e) {
                Object[] objArr = new Object[2];
                e.getMessage();
                i = -1;
            }
            if (lValueOf.longValue() >= 0 && i >= 0 && lValueOf.longValue() != 0 && i != 0) {
                String strN = n();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                if (TextUtils.isEmpty(strN)) {
                    sb.append(jCurrentTimeMillis);
                    n(sb.toString());
                    return true;
                }
                String[] strArrSplit = strN.split("_");
                int length = strArrSplit.length;
                if (length < i) {
                    Long.parseLong(strArrSplit[length - 1]);
                    for (String str : strArrSplit) {
                        sb.append(str).append("_");
                    }
                    sb.append(jCurrentTimeMillis);
                    n(sb.toString());
                    return true;
                }
                int i2 = length - i;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i2])).longValue() <= lValueOf.longValue()) {
                    z = false;
                }
                for (int i3 = i2; i3 < length; i3++) {
                    String str2 = strArrSplit[i3];
                    if (i3 != i2 && !TextUtils.isEmpty(str2)) {
                        sb.append(str2).append("_");
                    }
                }
                sb.append(jCurrentTimeMillis);
                n(sb.toString());
                return z;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String n() {
        return com.byazt.ikv.n.n().qg("notification_b", "");
    }

    public static void n(String str) {
        com.byazt.ikv.n.n().n("notification_b", str);
    }
}
