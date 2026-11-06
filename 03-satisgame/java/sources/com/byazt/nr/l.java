package com.byazt.nr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.byazt.yw.sz;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1357, 18})
public class l {
    public static JSONObject n(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", sz.n(stackTrace));
        return jSONObject;
    }

    public static String n(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoN = com.byazt.yw.n.n(context, i);
        if (processErrorStateInfoN == null || Process.myPid() != processErrorStateInfoN.pid) {
            return null;
        }
        return qg.n(processErrorStateInfoN);
    }
}
