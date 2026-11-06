package com.byazt.qi;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.yw.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 8})
public final class s {
    public Context n;

    public s(Context context) {
        this.n = context;
    }

    public void n(boolean z) {
        n();
        if (z) {
            qg();
        }
    }

    private void n() {
        try {
            SharedPreferences sharedPreferencesQg = com.byazt.qyu.qg.qg(this.n, "npth", 0);
            long j = sharedPreferencesQg.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferencesQg.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.byazt.yw.q.n(com.byazt.yw.fs.qg(this.n));
                sharedPreferencesQg.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception unused) {
        }
    }

    private void qg() {
        File[] fileArrN = n(com.byazt.yw.fs.n(this.n), ".npth");
        if (fileArrN == null) {
            return;
        }
        Arrays.sort(fileArrN, Collections.reverseOrder());
        for (int i = 0; i < fileArrN.length && i < 50; i++) {
            File file = fileArrN[i];
            try {
                if (com.byazt.hu.n.n().n(file.getAbsolutePath())) {
                    com.byazt.yw.q.n(file);
                } else {
                    com.byazt.ub.s sVarS = com.byazt.yw.q.s(file.getAbsolutePath());
                    if (sVarS != null && sVarS.qg() != null) {
                        JSONObject jSONObjectQg = sVarS.qg();
                        n(file.getName(), jSONObjectQg);
                        sVarS.qg().put("upload_scene", "launch_scan");
                        if (com.byazt.xh.qg.n(sVarS.n(), jSONObjectQg.toString(), sVarS.s()).n() && !com.byazt.yw.q.n(file)) {
                            com.byazt.hu.n.n().n(com.byazt.da.n.n(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e) {
                tj.qg(e);
            }
        }
    }

    private com.byazt.qf.s n(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return com.byazt.qf.s.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return com.byazt.qf.s.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return com.byazt.qf.s.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return com.byazt.qf.s.JAVA;
            }
        }
        return null;
    }

    private File[] n(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new FilenameFilter() { // from class: com.byazt.qi.s.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2 != null && str2.endsWith(".npth");
            }
        });
    }
}
