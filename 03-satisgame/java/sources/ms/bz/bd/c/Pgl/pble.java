package ms.bz.bd.c.Pgl;

import android.os.Build;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class pble {
    public static String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap mapQg = qg();
            for (String str : mapQg.keySet()) {
                jSONObject.put(str, mapQg.get(str));
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "51e243", new byte[]{com.anythink.core.common.r.a.c.c, 46});
        }
    }

    private static HashMap qg() {
        HashMap map = new HashMap();
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c629fc", new byte[]{35}), Build.MODEL);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6362d2", new byte[]{117}), Build.BRAND);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "72bcfa", new byte[]{117}), Build.BOARD);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ae99a3", new byte[]{36}), Build.VERSION.RELEASE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "392e84", new byte[]{119}), Build.DISPLAY);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "337dc9", new byte[]{116}), Build.HARDWARE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f740d4", new byte[]{32}), Build.FINGERPRINT);
        return map;
    }
}
