package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: InstallReferrerHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static final boolean a = false;
    private static volatile JSONObject b = null;
    private static boolean c = true;
    private static final a d = new a();

    public static JSONArray a(Context context) {
        if (c && context != null) {
            return d.a(context);
        }
        return null;
    }

    public static JSONObject a() {
        return b;
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            MLog.w("[iReferrer] args cannot empty source: " + str + " referrer: " + str2);
            return;
        }
        if (str.length() > 128) {
            MLog.w("[iReferrer] source too long[>128]: " + str);
            return;
        }
        if (str2.length() > 4096) {
            MLog.w("[iReferrer] referrer too long[>4096]: " + str2);
            return;
        }
        if (b == null) {
            b = new JSONObject();
        }
        try {
            b.put("source", str);
            b.put("referrer", str2);
        } catch (Throwable unused) {
        }
        MLog.i("[iReferrer] set: " + b);
    }

    public static void a(boolean z) {
        c = z;
    }

    /* JADX INFO: compiled from: InstallReferrerHelper.java */
    private static class a {
        private static final String a = "ins_referrer";
        private JSONArray b;

        private a() {
        }

        JSONArray a(Context context) {
            JSONArray jSONArray = this.b;
            if (jSONArray != null) {
                if (jSONArray.length() > 0) {
                    return this.b;
                }
                return null;
            }
            if (!a()) {
                this.b = new JSONArray();
                return null;
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            String string = sharedPreferences.getString(a, null);
            if (string != null) {
                String str = new String(Base64.decode(string, 2));
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] cache: ".concat(str));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("ver", 0) == 1) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ref");
                        this.b = jSONArrayOptJSONArray;
                        if (jSONArrayOptJSONArray == null) {
                            this.b = new JSONArray();
                        }
                        if (this.b.length() == 0) {
                            return null;
                        }
                        return this.b;
                    }
                } catch (Throwable unused) {
                }
            }
            this.b = b(context);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ver", 1);
                jSONObject2.put("ref", this.b);
                sharedPreferences.edit().putString(a, Base64.encodeToString(jSONObject2.toString().getBytes(), 2)).apply();
            } catch (Throwable th) {
                UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
            }
            if (this.b.length() > 0) {
                return this.b;
            }
            return null;
        }

        private boolean a() {
            return f() || b() || c() || e() || d() || g();
        }

        private JSONArray b(Context context) {
            String str;
            JSONObject jSONObjectD;
            JSONArray jSONArray = new JSONArray();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] start");
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                if (f() || bt.c()) {
                    str = "huawei";
                    jSONObjectD = d(context);
                } else if (g()) {
                    str = "honor";
                    jSONObjectD = c(context);
                } else if (b()) {
                    str = MediationConstant.ADN_XIAOMI;
                    jSONObjectD = e(context);
                } else if (c()) {
                    str = "vivo";
                    jSONObjectD = f(context);
                } else if (e()) {
                    str = "samsung";
                    jSONObjectD = h(context);
                } else if (d()) {
                    str = "oppo";
                    jSONObjectD = g(context);
                } else {
                    str = null;
                    jSONObjectD = null;
                }
                if (jSONObjectD != null && jSONObjectD.length() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("source", str);
                    jSONObject.put("referrer", jSONObjectD);
                    jSONArray.put(jSONObject);
                    MLog.i("[iReferrer] get:" + jSONObject);
                }
            } catch (Throwable th) {
                UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] result: " + jSONArray + " cost: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            return jSONArray;
        }

        private JSONObject c(Context context) {
            Uri uri = Uri.parse("content://com.hihonor.appmarket.commondata/item/wisepackage");
            String[] strArr = {context.getPackageName()};
            if (a(context, uri.getAuthority())) {
                return a(context, uri, strArr);
            }
            return null;
        }

        private JSONObject d(Context context) {
            Uri uri = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
            String[] strArr = {context.getPackageName()};
            if (a(context, uri.getAuthority())) {
                return a(context, uri, strArr);
            }
            return null;
        }

        private JSONObject e(Context context) {
            Uri uri = Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/referrer/v3");
            if (a(context, uri.getAuthority())) {
                return a(context, uri, null);
            }
            return null;
        }

        private JSONObject f(Context context) {
            try {
                Uri uri = Uri.parse("content://com.bbk.appstore.provider.appstatus");
                if (!a(context, uri.getAuthority())) {
                    return null;
                }
                Bundle bundle = new Bundle();
                bundle.putString("package_name", context.getPackageName());
                Bundle bundleCall = context.getContentResolver().call(uri, "read_channel", (String) null, bundle);
                if (bundleCall != null && !bundleCall.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : bundleCall.keySet()) {
                        Object obj = bundleCall.get(str);
                        if (obj != null) {
                            jSONObject.put(str, obj.toString());
                        }
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
                return null;
            }
        }

        private JSONObject g(Context context) {
            Bundle bundleCall;
            try {
                Uri uri = Uri.parse("content://com.heytap.market.TrackProvider");
                if (a(context, uri.getAuthority()) && (bundleCall = context.getContentResolver().call(uri, "getTrackInfo", (String) null, (Bundle) null)) != null && !bundleCall.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : bundleCall.keySet()) {
                        Object obj = bundleCall.get(str);
                        if (obj != null) {
                            jSONObject.put(str, obj.toString());
                        }
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
                return null;
            }
        }

        private JSONObject h(Context context) {
            Uri uri = Uri.parse("content://com.sec.android.app.samsungapps.referrer");
            if (a(context, uri.getAuthority())) {
                return a(context, uri, null);
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0026 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r9
          0x0026: PHI (r9v3 android.database.Cursor) = (r9v2 android.database.Cursor), (r9v4 android.database.Cursor) binds: [B:19:0x0042, B:13:0x0024] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        private JSONObject a(Context context, Uri uri, String[] strArr) {
            Cursor cursorQuery;
            try {
                cursorQuery = context.getContentResolver().query(uri, null, null, strArr, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            JSONObject jSONObjectA = a(cursorQuery);
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                } catch (Throwable unused) {
                                }
                            }
                            return jSONObjectA;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
                        } finally {
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                    }
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
            return null;
        }

        private boolean a(Context context, String str) {
            try {
                ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 0);
                if (providerInfoResolveContentProvider != null) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] pi: " + providerInfoResolveContentProvider.packageName + "/" + providerInfoResolveContentProvider.name);
                    return true;
                }
            } catch (Throwable unused) {
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] pi: null");
            return false;
        }

        private JSONObject a(Cursor cursor) {
            JSONObject jSONObject = new JSONObject();
            int iMin = Math.min(cursor.getColumnCount(), 20);
            for (int i = 0; i < iMin; i++) {
                try {
                    jSONObject.put(cursor.getColumnName(i), cursor.getString(i));
                } catch (Throwable th) {
                    UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
                }
            }
            return jSONObject;
        }

        private boolean b() {
            return a("XIAOMI", "REDMI", "BLACKSHARK");
        }

        private boolean c() {
            return a("VIVO");
        }

        private boolean d() {
            return a(BaseConstants.ROM_OPPO_UPPER_CONSTANT, "REALME", "ONEPLUS");
        }

        private boolean e() {
            return a("SAMSUNG");
        }

        private boolean f() {
            return a("HUAWEI");
        }

        private boolean g() {
            return a("HONOR");
        }

        private boolean a(String... strArr) {
            String str = Build.BRAND;
            String str2 = Build.MANUFACTURER;
            for (String str3 : strArr) {
                if (str3.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
            return false;
        }
    }
}
