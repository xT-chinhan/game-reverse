package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class vf {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ce<si> f536ms = new ce<si>() { // from class: com.bytedance.embedapplog.vf.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.ce
        /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
        public si ms(Object... objArr) {
            return new si((Context) objArr[0]);
        }
    };

    public static void ms(Context context) {
        f536ms.xr(context).xr();
    }

    public static String ms(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return o.ms(sharedPreferences);
    }

    public static Map<String, String> ms(Context context, SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        si siVarXr = f536ms.xr(context);
        return siVarXr.ms(siVarXr.ms() instanceof qo ? 200 : 100);
    }

    public static String ms(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void ms(ka kaVar) {
        si.ms(kaVar);
    }
}
