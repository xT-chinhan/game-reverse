package com.byazt.tm;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.byazt.hg.nl;
import com.byazt.hg.of;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2289, 20})
public class hn {
    public static boolean pr(Context context) {
        return x(context) && c(context);
    }

    public static void hw(Context context) {
        Vibrator vibratorHn = hn(context);
        if (vibratorHn != null) {
            vibratorHn.cancel();
        }
    }

    private static boolean x(Context context) {
        try {
            return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean c(Context context) {
        Vibrator vibratorHn = hn(context);
        return vibratorHn != null && vibratorHn.hasVibrator();
    }

    public static Vibrator hn(Context context) {
        try {
            return (Vibrator) context.getSystemService("vibrator");
        } catch (Exception e) {
            return null;
        }
    }

    public static void pr(Context context, nl nlVar) {
        new pr(context, nlVar).hw();
    }

    public static void pr(JSONObject jSONObject, Context context, of ofVar) {
        if (jSONObject == null || context == null) {
            return;
        }
        pr(jSONObject.optString("id"), jSONObject.optJSONArray("pattern"), context, ofVar);
    }

    public static void pr(String str, JSONArray jSONArray, Context context, of ofVar) {
        nl nlVarHw;
        if (jSONArray != null && jSONArray.length() > 0) {
            nlVarHw = new nl(str, jSONArray);
        } else if (!TextUtils.isEmpty(str) && ofVar != null) {
            nlVarHw = ofVar.hw(str);
        } else {
            nlVarHw = null;
        }
        if (nlVarHw != null) {
            pr(context, nlVarHw);
        }
    }
}
