package com.bytedance.sdk.openadsdk.core.ab;

import android.content.Context;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile boolean f1891ms = false;

    private static void ms(Context context, xr xrVar) {
        if (xrVar != null && LogAdapter.f4121ms == null && h.ms(re.getContext()) && xrVar.d()) {
            String path = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context).getPath();
            String string = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context).toString();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("buffer_dir_path", path + "/aa");
                jSONObject.putOpt("log_dir_path", string + "/aa");
                jSONObject.putOpt("compress", Boolean.TRUE);
                jSONObject.putOpt("encrypt", Boolean.TRUE);
                jSONObject.putOpt("level", Integer.valueOf(xrVar.ms()));
                jSONObject.putOpt("log_file_exp_days", Integer.valueOf(xrVar.xr()));
                jSONObject.putOpt("max_dir_size", Integer.valueOf(xrVar.ah() * 1024 * 1024));
                jSONObject.putOpt("per_size", 2097152);
                jSONObject.putOpt("offload_main_write", Boolean.TRUE);
                if (ah.ms(context, jSONObject)) {
                    sl.ms(new ka());
                    ah.ms(context, "3892", c.ms().ah());
                    ah.ms("mon.zijieapi.com");
                    f1891ms = true;
                    ah.ah();
                    return;
                }
                sl.d("ACL", "init failed");
            } catch (JSONException e) {
                sl.d("ACL", "init failed:" + e.getMessage());
            }
        }
    }

    public static void ms(xr xrVar) {
        if (!f1891ms) {
            ms(re.getContext(), xrVar);
        } else if (xrVar == null || !xrVar.d()) {
            ah.ms();
        } else {
            ah.ms(xrVar.ms());
            x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ab.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.xr();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr() {
        ab.xr(new ny("fetch_lg_command") { // from class: com.bytedance.sdk.openadsdk.core.ab.ms.2
            @Override // java.lang.Runnable
            public void run() {
                ah.xr();
            }
        });
    }

    public static void ms(String str, String str2) {
        if (f1891ms) {
            ah.ms(str, str2);
        }
    }

    public static void xr(String str, String str2) {
        if (f1891ms) {
            ah.xr(str, str2);
        }
    }

    public static void ah(String str, String str2) {
        if (f1891ms) {
            ah.ah(str, str2);
        }
    }

    public static void ms(String str, String str2, Throwable th) {
        if (f1891ms) {
            ah.ms(str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (f1891ms) {
            ah.d(str, str2);
        }
    }

    public static void xr(String str, String str2, Throwable th) {
        if (f1891ms) {
            ah.xr(str, str2, th);
        }
    }

    public static void ms(String str, Throwable th) {
        if (f1891ms) {
            ah.ms(str, th);
        }
    }
}
