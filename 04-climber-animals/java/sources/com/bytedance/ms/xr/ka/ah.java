package com.bytedance.ms.xr.ka;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ms.xr.x.ch;
import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f566ms;

    public ah(Context context) {
        this.f566ms = context;
    }

    public void ms(boolean z) {
        ms();
        if (z) {
            xr();
        }
    }

    private void ms() {
        try {
            SharedPreferences sharedPreferencesXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.f566ms, "npth", 0);
            long j = sharedPreferencesXr.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferencesXr.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.bytedance.ms.xr.x.d.ms(com.bytedance.ms.xr.x.x.xr(this.f566ms));
                sharedPreferencesXr.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    private void xr() {
        File[] fileArrMs = ms(com.bytedance.ms.xr.x.x.ms(this.f566ms), ".npth");
        if (fileArrMs == null) {
            return;
        }
        Arrays.sort(fileArrMs, Collections.reverseOrder());
        for (int i = 0; i < fileArrMs.length && i < 50; i++) {
            File file = fileArrMs[i];
            try {
                if (com.bytedance.ms.xr.xr.ms.ms().ms(file.getAbsolutePath())) {
                    com.bytedance.ms.xr.x.d.ms(file);
                } else {
                    com.bytedance.ms.xr.ah.ah ahVarAh = com.bytedance.ms.xr.x.d.ah(file.getAbsolutePath());
                    if (ahVarAh != null && ahVarAh.xr() != null) {
                        JSONObject jSONObjectXr = ahVarAh.xr();
                        ms(file.getName(), jSONObjectXr);
                        ahVarAh.xr().put("upload_scene", "launch_scan");
                        if (com.bytedance.ms.xr.ab.xr.ms(ahVarAh.ms(), jSONObjectXr.toString(), ahVarAh.ah()).ms() && !com.bytedance.ms.xr.x.d.ms(file)) {
                            com.bytedance.ms.xr.xr.ms.ms().ms(com.bytedance.ms.xr.xr.ms.ms.ms(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e) {
                ch.xr(e);
            }
        }
    }

    private com.bytedance.ms.xr.ah ms(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return com.bytedance.ms.xr.ah.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return com.bytedance.ms.xr.ah.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return com.bytedance.ms.xr.ah.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return com.bytedance.ms.xr.ah.JAVA;
            }
        }
        return null;
    }

    private File[] ms(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new FilenameFilter() { // from class: com.bytedance.ms.xr.ka.ah.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2 != null && str2.endsWith(".npth");
            }
        });
    }
}
