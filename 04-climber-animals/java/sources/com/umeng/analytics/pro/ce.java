package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import org.json.JSONObject;

/* JADX INFO: compiled from: RequestRecorder.java */
/* JADX INFO: loaded from: classes4.dex */
public class ce implements cd {
    private static final String a = "cache_domain";
    private static volatile String b = "";

    @Override // com.umeng.analytics.pro.cd
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cd
    public void a(Throwable th) {
    }

    /* JADX INFO: compiled from: RequestRecorder.java */
    private static class a {
        public static final ce a = new ce();

        private a() {
        }
    }

    public static ce b() {
        return a.a;
    }

    private ce() {
        d();
    }

    private void d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
        if (sharedPreferences != null) {
            b = sharedPreferences.getString(a, "");
        }
    }

    public String c() {
        return b;
    }

    @Override // com.umeng.analytics.pro.cd
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("Status") && jSONObject.getInt("Status") == 0 && jSONObject.has("Answer")) {
                String strOptString = jSONObject.optString("Answer");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                String strOptString2 = jSONObject.has("ip") ? jSONObject.optString("ip") : "";
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> domain下发结果：" + strOptString);
                if (!TextUtils.isEmpty(strOptString2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 对应domain下发请求ip：" + strOptString2);
                }
                b = strOptString;
                e();
            }
        } catch (Throwable unused) {
        }
    }

    private void e() {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(a, b).commit();
            }
        } catch (Throwable unused) {
        }
    }
}
