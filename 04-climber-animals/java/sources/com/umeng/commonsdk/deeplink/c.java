package com.umeng.commonsdk.deeplink;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.ab;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeepLinkAttribution.java */
/* JADX INFO: loaded from: classes4.dex */
final class c {
    private c() {
    }

    static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "url";
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (UMUtils.isMainProgress(applicationContext)) {
                String strD = ab.a().d(applicationContext);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str3, str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("_umlnk_refid", str2);
                }
                if (!TextUtils.isEmpty(strD)) {
                    jSONObject.put("session_id", strD);
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(t.q, jSONObject);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] attribution report: " + jSONObject3.toString());
                JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(applicationContext, jSONObject2, jSONObject3, "um_attribution_dp_log", "dl", "9.9.6");
                if (jSONObjectBuildEnvelopeWithExtHeader != null && jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [deeplink] attribution report failed: " + jSONObjectBuildEnvelopeWithExtHeader.optString("exception"));
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] attribution report success");
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }
}
