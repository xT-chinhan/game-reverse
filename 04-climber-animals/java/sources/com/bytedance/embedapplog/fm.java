package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class fm extends le {
    fm() {
        super(true, false);
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder(16);
        if (ms()) {
            sb.append("MIUI-");
        } else if (xr()) {
            sb.append("FLYME-");
        } else {
            String strMs = ny.ms();
            if (ny.ms(strMs)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(strMs)) {
                sb.append(strMs).append("-");
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }

    private boolean ms() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean xr() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }
}
