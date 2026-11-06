package com.bytedance.ms.xr.ms;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.ms.xr.x.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    public static JSONObject ms(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", u.ms(stackTrace));
        return jSONObject;
    }

    static String ms(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoMs = com.bytedance.ms.xr.x.ms.ms(context, i);
        if (processErrorStateInfoMs == null || Process.myPid() != processErrorStateInfoMs.pid) {
            return null;
        }
        return xr.ms(processErrorStateInfoMs);
    }
}
