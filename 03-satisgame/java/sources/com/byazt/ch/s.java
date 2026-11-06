package com.byazt.ch;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.byazt.bk.w;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1600, 8})
public class s implements com.byazt.my.n {

    @com.byazt.cp.n(n = {0, 1, 1600, 546})
    private static class n {
        public static s n = new s();
    }

    public static s n() {
        return n.n;
    }

    @Override // com.byazt.my.n
    public void n(Throwable th, String str) {
        n(true, th, str);
    }

    public void n(boolean z, Throwable th, String str) {
        if (qg()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            qg(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        oa.n(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        oa.n(jSONObject, "stack", Log.getStackTraceString(th));
        d.fs();
    }

    public void n(String str) {
        n(true, str);
    }

    public void n(boolean z, String str) {
        if (qg()) {
            return;
        }
        if (z) {
            qg(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        oa.n(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        oa.n(jSONObject, "stack", n(new Throwable()));
        d.fs();
    }

    public void qg(String str) {
        qg(true, str);
    }

    public void qg(boolean z, String str) {
        if (qg()) {
            return;
        }
        if (z) {
            qg(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        oa.n(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        oa.n(jSONObject, "stack", n(new Throwable()));
        d.fs();
    }

    private void qg(Throwable th) {
        if (w.qg(d.getContext())) {
            throw new com.byazt.ch.n(th);
        }
    }

    public static String n(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean qg() {
        return d.rv().optInt("enable_monitor", 1) != 1;
    }
}
