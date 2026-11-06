package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.umeng.analytics.pro.cc;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class p0 extends pbls.pgla {
    p0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        String string;
        Context contextHw = pblp.pr().hw();
        ApplicationInfo applicationInfo = contextHw.getPackageManager().getApplicationInfo(contextHw.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        if (str2 == null) {
            str2 = applicationInfo.publicSourceDir;
        }
        HashMap mapPr = pgla.pr(str2);
        String string2 = "";
        String str3 = (mapPr == null || !mapPr.containsKey(1903654775)) ? "" : (String) mapPr.get(1903654775);
        if (str3 != null && str3.length() > 0) {
            JSONObject jSONObject = new JSONObject(str3);
            try {
                string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d403d6", new byte[]{120, 51, 87, 70, 100, 52, 106, cc.n, 111, 100, 74, 53, 75, 70, 85, 47, 98, 25}));
            } catch (JSONException e) {
                string = "";
            }
            StringBuilder sbAppend = new StringBuilder().append(string).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e5f264", new byte[]{47}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "87e9dc", new byte[]{59, 48, 26, 72, 90, 103, 62, 41, 54, 124, 32, 57, 18}));
            } catch (JSONException e2) {
            }
            string2 = sbAppend.append(string2).toString();
        }
        return string2.length() == 0 ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f91987", new byte[]{89, 52, 76, 72}) : string2;
    }
}
