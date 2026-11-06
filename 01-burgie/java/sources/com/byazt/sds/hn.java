package com.byazt.sds;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.wf.vk;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1663, 20})
public final class hn {
    public Context pr;

    public hn(Context context) {
        this.pr = context;
    }

    public void pr(boolean z) {
        pr();
        if (z) {
            hw();
        }
    }

    private void pr() {
        try {
            SharedPreferences sharedPreferencesHw = com.byazt.mg.hw.hw(this.pr, "npth", 0);
            long j = sharedPreferencesHw.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferencesHw.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.byazt.wf.x.pr(com.byazt.wf.zo.hw(this.pr));
                sharedPreferencesHw.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
        }
    }

    private void hw() {
        File[] fileArrPr = pr(com.byazt.wf.zo.pr(this.pr), ".npth");
        if (fileArrPr == null) {
            return;
        }
        Arrays.sort(fileArrPr, Collections.reverseOrder());
        for (int i = 0; i < fileArrPr.length && i < 50; i++) {
            File file = fileArrPr[i];
            try {
                if (com.byazt.kvy.pr.pr().pr(file.getAbsolutePath())) {
                    com.byazt.wf.x.pr(file);
                } else {
                    com.byazt.lee.hn hnVarHn = com.byazt.wf.x.hn(file.getAbsolutePath());
                    if (hnVarHn != null && hnVarHn.hw() != null) {
                        JSONObject jSONObjectHw = hnVarHn.hw();
                        pr(file.getName(), jSONObjectHw);
                        hnVarHn.hw().put("upload_scene", "launch_scan");
                        if (com.byazt.tv.hw.pr(hnVarHn.pr(), jSONObjectHw.toString(), hnVarHn.hn()).pr() && !com.byazt.wf.x.pr(file)) {
                            com.byazt.kvy.pr.pr().pr(com.byazt.yf.pr.pr(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e) {
                vk.hw(e);
            }
        }
    }

    private com.byazt.vlj.hn pr(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return com.byazt.vlj.hn.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return com.byazt.vlj.hn.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return com.byazt.vlj.hn.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return com.byazt.vlj.hn.JAVA;
            }
        }
        return null;
    }

    private File[] pr(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new FilenameFilter() { // from class: com.byazt.sds.hn.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2 != null && str2.endsWith(".npth");
            }
        });
    }
}
