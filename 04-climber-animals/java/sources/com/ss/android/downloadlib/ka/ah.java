package com.ss.android.downloadlib.ka;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.appdownloader.c.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ah implements com.ss.android.download.api.xr.ms {

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ah f4500ms = new ah();
    }

    public static ah ms() {
        return ms.f4500ms;
    }

    @Override // com.ss.android.download.api.xr.ms
    public void ms(Throwable th, String str) {
        ms(true, th, str);
    }

    public void ms(boolean z, Throwable th, String str) {
        if (xr()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            xr(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        zb.ms(jSONObject, "msg", str);
        zb.ms(jSONObject, "stack", Log.getStackTraceString(th));
        hi.x();
    }

    public void ms(String str) {
        ms(true, str);
    }

    public void ms(boolean z, String str) {
        if (xr()) {
            return;
        }
        if (z) {
            xr(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        zb.ms(jSONObject, "msg", str);
        zb.ms(jSONObject, "stack", ms(new Throwable()));
        hi.x();
    }

    public void xr(String str) {
        xr(true, str);
    }

    public void xr(boolean z, String str) {
        if (xr()) {
            return;
        }
        if (z) {
            xr(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        zb.ms(jSONObject, "msg", str);
        zb.ms(jSONObject, "stack", ms(new Throwable()));
        hi.x();
    }

    private void xr(Throwable th) {
        if (c.xr(hi.getContext())) {
            throw new com.ss.android.downloadlib.ka.ms(th);
        }
    }

    public static String ms(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean xr() {
        return hi.ny().optInt("enable_monitor", 1) != 1;
    }
}
