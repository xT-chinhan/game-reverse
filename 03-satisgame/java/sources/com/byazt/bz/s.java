package com.byazt.bz;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.byazt.gct.lh;
import com.byazt.gct.pk;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 762, 8})
public class s {
    public static boolean n(Context context) {
        return q(context) && l(context);
    }

    public static void qg(Context context) {
        Vibrator vibratorS = s(context);
        if (vibratorS != null) {
            vibratorS.cancel();
        }
    }

    private static boolean q(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName()) == 0 && context.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0;
        } catch (Exception unused) {
        }
    }

    private static boolean l(Context context) {
        Vibrator vibratorS = s(context);
        return vibratorS != null && vibratorS.hasVibrator();
    }

    public static Vibrator s(Context context) {
        try {
            return (Vibrator) context.getSystemService("vibrator");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void n(Context context, lh lhVar) {
        new n(context, lhVar).qg();
    }

    public static void n(JSONObject jSONObject, Context context, pk pkVar) {
        if (jSONObject == null || context == null) {
            return;
        }
        n(jSONObject.optString("id"), jSONObject.optJSONArray("pattern"), context, pkVar);
    }

    public static void n(String str, JSONArray jSONArray, Context context, pk pkVar) {
        lh lhVarQg;
        if (jSONArray != null && jSONArray.length() > 0) {
            lhVarQg = new lh(str, jSONArray);
        } else {
            lhVarQg = (TextUtils.isEmpty(str) || pkVar == null) ? null : pkVar.qg(str);
        }
        if (lhVarQg != null) {
            n(context, lhVarQg);
        }
    }
}
