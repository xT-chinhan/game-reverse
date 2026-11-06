package com.bytedance.sdk.openadsdk.core.ugeno;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.g;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ab f3379ms;
    private com.bytedance.sdk.component.d.ms.xr xr = g.ms("ugeno_template_file");

    private ab() {
    }

    public static ab ms() {
        if (f3379ms == null) {
            synchronized (ab.class) {
                if (f3379ms == null) {
                    f3379ms = new ab();
                }
            }
        }
        return f3379ms;
    }

    public void ms(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.xr.ms("ugeno_".concat(String.valueOf(str)), str3);
        this.xr.ms("ugeno__md5_".concat(String.valueOf(str)), str2);
    }

    public JSONObject ms(String str, String str2) {
        String strXr = this.xr.xr("ugeno_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(strXr)) {
            return null;
        }
        String strXr2 = this.xr.xr("ugeno__md5_".concat(String.valueOf(str)), "");
        if (!TextUtils.isEmpty(strXr2) && TextUtils.equals(strXr2, str2)) {
            try {
                return new JSONObject(strXr);
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
        return null;
    }

    public boolean xr(String str, String str2) {
        return ms(str, str2) != null;
    }
}
