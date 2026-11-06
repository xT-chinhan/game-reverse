package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class t0 extends pbly.pgla {
    t0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        String string;
        Context contextXr = pblv.ms().xr();
        ApplicationInfo applicationInfo = contextXr.getPackageManager().getApplicationInfo(contextXr.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        if (str2 == null) {
            str2 = applicationInfo.publicSourceDir;
        }
        HashMap mapMs = pblc.ms(str2);
        String string2 = "";
        String str3 = (mapMs == null || !mapMs.containsKey(1903654775)) ? "" : (String) mapMs.get(1903654775);
        if (str3 != null && str3.length() > 0) {
            JSONObject jSONObject = new JSONObject(str3);
            try {
                string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f05b16", new byte[]{122, 55, 82, 23, 49, 52, 104, 20, 106, 53, 72, 49, 78, 23, 0, 47, 96, 29}));
            } catch (JSONException unused) {
                string = "";
            }
            StringBuilder sbAppend = new StringBuilder().append(string).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3e10d3", new byte[]{121}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2066ae", new byte[]{49, 55, 73, 71, 95, 97, 52, 46, 101, 115, 42, 62, 65}));
            } catch (JSONException unused2) {
            }
            string2 = sbAppend.append(string2).toString();
        }
        return string2.length() == 0 ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "97bda5", new byte[]{6, 58, 31, 21}) : string2;
    }
}
