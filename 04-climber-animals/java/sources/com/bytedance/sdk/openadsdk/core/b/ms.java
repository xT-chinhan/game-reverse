package com.bytedance.sdk.openadsdk.core.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static HashSet<String> f2008ms = new HashSet<>();

    public static void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f2008ms.add(str);
    }

    public static void xr(final String str) {
        if (TextUtils.isEmpty(str) || !f2008ms.contains(str)) {
            return;
        }
        f2008ms.remove(str);
        u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.b.ms.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("union_key", str);
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("listener_process_but_not_register").xr(jSONObject.toString());
            }
        }, "listener_process_but_not_register");
    }
}
