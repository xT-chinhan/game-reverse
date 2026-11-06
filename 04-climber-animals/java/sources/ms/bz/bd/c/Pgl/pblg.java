package ms.bz.bd.c.Pgl;

import android.os.Build;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class pblg {
    public static String ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap mapXr = xr();
            for (String str : mapXr.keySet()) {
                jSONObject.put(str, mapXr.get(str));
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "604297", new byte[]{60, 47});
        }
    }

    private static HashMap xr() {
        HashMap map = new HashMap();
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6383d8", new byte[]{118}), Build.MODEL);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "18e935", new byte[]{114}), Build.BRAND);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "317f81", new byte[]{113}), Build.BOARD);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "551583", new byte[]{112}), Build.VERSION.RELEASE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "59f549", new byte[]{113}), Build.DISPLAY);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "487ab7", new byte[]{115}), Build.HARDWARE);
        map.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4c4241", new byte[]{114}), Build.FINGERPRINT);
        return map;
    }
}
