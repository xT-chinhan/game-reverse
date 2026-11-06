package com.byazt.vi;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.eld.k;
import com.byazt.now.uc;
import com.byazt.uk.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 831, 20})
public class hn implements com.byazt.pz.pr {

    @com.byazt.vzx.pr(pr = {0, 1, 831, 116})
    private static class pr {
        public static hn pr = new hn();
    }

    public static hn pr() {
        return pr.pr;
    }

    @Override // com.byazt.pz.pr
    public void pr(Throwable th, String str) {
        pr(true, th, str);
    }

    public void pr(boolean z, Throwable th, String str) {
        if (hw()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            hw(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        m.pr(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        m.pr(jSONObject, "stack", Log.getStackTraceString(th));
        k.zo();
    }

    public void pr(String str) {
        pr(true, str);
    }

    public void pr(boolean z, String str) {
        if (hw()) {
            return;
        }
        if (z) {
            hw(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        m.pr(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        m.pr(jSONObject, "stack", pr(new Throwable()));
        k.zo();
    }

    public void hw(String str) {
        hw(true, str);
    }

    public void hw(boolean z, String str) {
        if (hw()) {
            return;
        }
        if (z) {
            hw(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        m.pr(jSONObject, NotificationCompat.CATEGORY_MESSAGE, str);
        m.pr(jSONObject, "stack", pr(new Throwable()));
        k.zo();
    }

    private void hw(Throwable th) {
        if (uc.hw(k.getContext())) {
            throw new com.byazt.vi.pr(th);
        }
    }

    public static String pr(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception e) {
            return null;
        }
    }

    private boolean hw() {
        return k.aj().optInt("enable_monitor", 1) != 1;
    }
}
