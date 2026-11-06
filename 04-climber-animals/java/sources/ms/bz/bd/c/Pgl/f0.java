package ms.bz.bd.c.Pgl;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.umeng.analytics.pro.ek;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class f0 extends pbly.pgla {
    f0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        List<AccessibilityServiceInfo> list;
        Context contextXr = pblv.ms().xr();
        JSONArray jSONArray = new JSONArray();
        AccessibilityManager accessibilityManager = (AccessibilityManager) contextXr.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "33fa29", new byte[]{35, 50, 22, ek.n, 30, 61, 57, ek.n, 62, 61, 43, 37, 12}));
        if (accessibilityManager != null) {
            try {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0372e3", new byte[]{38, 52, 80, 111, 84, 55, 39, 19, 106, 110, 36, 53, 101, 69, 89, 33, 32, 1, 111, 96, 40, 61, 77, 82, 67, 23, 54, 0, 112, 107, 34, 52, 104, 79, 73, 48}), new Class[0]);
                list = declaredMethod != null ? (List) declaredMethod.invoke(accessibilityManager, new Object[0]) : null;
            } catch (Throwable unused) {
            }
            if (list == null || list.size() == 0) {
                return jSONArray.toString();
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "59bda6", new byte[]{33, 45}), accessibilityServiceInfo.eventTypes);
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "361b90", new byte[]{43, 48}), accessibilityServiceInfo.getId());
                    jSONArray.put(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        }
        return jSONArray.toString();
    }
}
