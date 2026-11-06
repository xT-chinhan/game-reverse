package com.byazt.nz;

import android.content.Context;
import com.byazt.ca.aj;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import com.byazt.xlm.fw;
import com.byazt.zs.uc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 684, 37})
public class pr {
    public static volatile boolean pr = false;

    private static void pr(Context context, hw hwVar) {
        if (hwVar == null || com.byazt.hs.hw.pr != null || !((com.byazt.vkw.c) uc.pr("app_process")).pr() || !hwVar.x()) {
            return;
        }
        String path = com.byazt.ca.uc.hw(context, false, null).getPath();
        String string = com.byazt.mg.hw.pr(context).toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("buffer_dir_path", path + "/aa");
            jSONObject.putOpt("log_dir_path", string + "/aa");
            jSONObject.putOpt("compress", Boolean.TRUE);
            jSONObject.putOpt("encrypt", Boolean.TRUE);
            jSONObject.putOpt("level", Integer.valueOf(hwVar.pr()));
            jSONObject.putOpt("log_file_exp_days", Integer.valueOf(hwVar.hw()));
            jSONObject.putOpt("max_dir_size", Integer.valueOf(hwVar.hn() * 1024 * 1024));
            jSONObject.putOpt("per_size", 2097152);
            jSONObject.putOpt("offload_main_write", Boolean.TRUE);
            if (hn.pr(context, jSONObject)) {
                ho.pr(new c());
                hn.pr(context, "3892", com.byazt.sd.uc.pr().hw());
                hn.pr("mon.zijieapi.com");
                pr = true;
                hn.hn();
                return;
            }
            ho.hw("ACL", "init failed");
        } catch (JSONException e) {
            ho.hw("ACL", "init failed:" + e.getMessage());
        }
    }

    public static void pr(hw hwVar) {
        if (!pr) {
            pr(a.getContext(), hwVar);
        } else if (hwVar == null || !hwVar.x()) {
            hn.pr();
        } else {
            hn.pr(hwVar.pr());
            aj.pr().postDelayed(new Runnable() { // from class: com.byazt.nz.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    pr.hw();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw() {
        com.byazt.xlm.c.hw(new fw("fetch_lg_command") { // from class: com.byazt.nz.pr.2
            @Override // java.lang.Runnable
            public void run() {
                hn.hw();
            }
        });
    }

    public static void pr(String str, String str2) {
        if (!pr) {
            return;
        }
        hn.pr(str, str2);
    }

    public static void hw(String str, String str2) {
        if (!pr) {
            return;
        }
        hn.hw(str, str2);
    }

    public static void hn(String str, String str2) {
        if (!pr) {
            return;
        }
        hn.hn(str, str2);
    }

    public static void pr(String str, String str2, Throwable th) {
        if (!pr) {
            return;
        }
        hn.pr(str, str2, th);
    }

    public static void pr(String str, Throwable th) {
        if (!pr) {
            return;
        }
        hn.pr(str, th);
    }
}
