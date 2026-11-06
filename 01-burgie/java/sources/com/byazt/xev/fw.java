package com.byazt.xev;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 62})
public final class fw {
    public static hw<nt> pr = new hw<nt>() { // from class: com.byazt.xev.fw.1
        @Override // com.byazt.xev.hw
        /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
        public nt pr(Object... objArr) {
            return new nt((Context) objArr[0]);
        }
    };

    public static void pr(Context context) {
        pr.hw(context).hw();
    }

    public static String pr(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return x.pr(sharedPreferences);
    }

    public static Map<String, String> pr(Context context, SharedPreferences sharedPreferences) {
        int i;
        SystemClock.elapsedRealtime();
        nt ntVarHw = pr.hw(context);
        if (!(ntVarHw.pr() instanceof k)) {
            i = 100;
        } else {
            i = 200;
        }
        return ntVarHw.pr(i);
    }

    public static String pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void pr(com.byazt.lq.hn hnVar) {
        nt.pr(hnVar);
    }

    public static void hw(com.byazt.lq.hn hnVar) {
        nt.hw(hnVar);
    }
}
