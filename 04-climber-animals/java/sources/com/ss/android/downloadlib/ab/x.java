package com.ss.android.downloadlib.ab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.e.f;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.download.api.config.qv;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.umeng.analytics.pro.bv;
import com.umeng.ccg.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4342ms = "x";

    public static com.ss.android.downloadlib.addownload.xr.ab ms(Context context, Uri uri) {
        Intent intent;
        if (!com.ss.android.socialbase.appdownloader.c.ka.ah() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.xr.ab(6, 12);
        }
        try {
            String strCh = com.ss.android.socialbase.appdownloader.c.ka.ch();
            if (com.ss.android.socialbase.appdownloader.c.ka.h() && (TextUtils.isEmpty(strCh) || !zb.ka(context, strCh))) {
                strCh = "com.huawei.appmarket";
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.scheme("market");
                intent = new Intent("android.intent.action.VIEW", builderBuildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!zb.ms(context, intent)) {
                return new com.ss.android.downloadlib.addownload.xr.ab(6, 13);
            }
            if (zb.ka(context, strCh) && !com.ss.android.socialbase.appdownloader.c.ka.ab()) {
                intent.setPackage(strCh);
            }
            if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            if (com.ss.android.socialbase.downloader.ab.ms.ah().xr("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.ka.ah.ms().ms(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.xr.ab(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.xr.ab(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.xr.ab(6, 14);
        }
    }

    public static com.ss.android.downloadlib.addownload.xr.ab ms(final Context context, Uri uri, com.ss.android.downloadlib.addownload.xr.ka kaVar) {
        if (context == null || !com.ss.android.downloadlib.xr.ch.ms(uri)) {
            return new com.ss.android.downloadlib.addownload.xr.ab(6, 12);
        }
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!zb.ms(context, intent)) {
                return new com.ss.android.downloadlib.addownload.xr.ab(6, 13);
            }
            String strCh = com.ss.android.socialbase.appdownloader.c.ka.ch();
            if (zb.ka(context, strCh)) {
                intent.setPackage(strCh);
            }
            intent.addFlags(335544320);
            if (com.ss.android.socialbase.downloader.ab.ms.ah().xr("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.hi.ch().ah)) {
                com.ss.android.downloadlib.ka.ah.ms().ms(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.xr.ab(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            long jOptLong = com.ss.android.downloadlib.addownload.hi.ny().optLong("market_jump_delay", 1000L);
            if (jOptLong > 0 && kaVar != null && kaVar.ka != null && !kaVar.ka.rt()) {
                com.ss.android.downloadlib.x.ms().xr().post(new Runnable() { // from class: com.ss.android.downloadlib.ab.x.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.hi.ah().ms(8, com.ss.android.downloadlib.addownload.hi.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ab.x.2
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            return new com.ss.android.downloadlib.addownload.xr.ab(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.xr.ab(6, 14);
        }
    }

    public static com.ss.android.downloadlib.addownload.xr.ab ms(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.xr.ab(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.c.ka.ab() && zb.ka(context, "com.sec.android.app.samsungapps")) {
            return d(context, str);
        }
        return ms(context, com.ss.android.download.api.ah.ms.ms(str));
    }

    public static com.ss.android.downloadlib.addownload.xr.ab ms(Context context, com.ss.android.downloadlib.addownload.xr.ka kaVar, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.xr.ab(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.c.ka.ab() && zb.ka(context, "com.sec.android.app.samsungapps")) {
            return d(context, str);
        }
        if (!kaVar.xr.isAd() || !kaVar.d.enableAM()) {
            return ms(context, Uri.parse("market://details?id=" + str));
        }
        JSONArray jSONArrayOptJSONArray = com.ss.android.downloadlib.addownload.hi.ny().optJSONArray("am_plans");
        if (com.ss.android.socialbase.appdownloader.c.ka.ka() && com.ss.android.socialbase.appdownloader.c.ms.ms(jSONArrayOptJSONArray, "am_3")) {
            return xr(context, kaVar, str);
        }
        if (com.ss.android.socialbase.appdownloader.c.ka.c() && com.ss.android.socialbase.appdownloader.c.ms.ms(jSONArrayOptJSONArray, "am_2")) {
            ka(context, kaVar, str);
            return new com.ss.android.downloadlib.addownload.xr.ab(7, "am_m2");
        }
        if (com.ss.android.socialbase.appdownloader.c.ka.d() && com.ss.android.socialbase.appdownloader.c.ms.ms(jSONArrayOptJSONArray, "am_5")) {
            x(context, kaVar, str);
            return new com.ss.android.downloadlib.addownload.xr.ab(7, "am_v1");
        }
        if (com.ss.android.socialbase.appdownloader.c.ka.ka() && com.ss.android.socialbase.appdownloader.c.ms.ms(jSONArrayOptJSONArray, "am_7") && (kaVar.d instanceof AdDownloadController) && ((AdDownloadController) kaVar.d).enableOppoAutoDownload()) {
            return d(context, kaVar, str);
        }
        if (com.ss.android.socialbase.appdownloader.c.ka.d() && com.ss.android.socialbase.appdownloader.c.ms.ms(jSONArrayOptJSONArray, "am_8") && zb.ms(zb.ah(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
            ny(context, kaVar, str);
            return new com.ss.android.downloadlib.addownload.xr.ab(7, "am_v2");
        }
        if ((com.ss.android.socialbase.appdownloader.c.ka.ms() || com.ss.android.socialbase.appdownloader.c.ka.xr()) && com.ss.android.socialbase.appdownloader.c.ms.ms(jSONArrayOptJSONArray, "am_9")) {
            c(context, kaVar, str);
            return new com.ss.android.downloadlib.addownload.xr.ab(7, "am_hr");
        }
        if ((com.ss.android.socialbase.appdownloader.c.ka.ms() || com.ss.android.socialbase.appdownloader.c.ka.xr()) && com.ss.android.socialbase.appdownloader.c.ms.ms(jSONArrayOptJSONArray, "am_10")) {
            ab(context, kaVar, str);
            return new com.ss.android.downloadlib.addownload.xr.ab(7, "am_hr2");
        }
        if ((kaVar.d instanceof AdDownloadController) && ((AdDownloadController) kaVar.d).enableOppoAutoDownload() && ((AdDownloadController) kaVar.d).getDownloadMarketInterceptor() != null && kaVar.xr.getDownloadSettings().optInt("is_use_obm_convert", 0) == 1) {
            ah(context, kaVar, str);
            return new com.ss.android.downloadlib.addownload.xr.ab(7, "am_kllk4");
        }
        return ms(context, Uri.parse("market://details?id=" + str));
    }

    private static com.ss.android.downloadlib.addownload.xr.ab d(Context context, String str) {
        try {
            Uri uri = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.xr.ab(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.xr.ab(6, 14);
        }
    }

    public static boolean ms(Context context, com.ss.android.downloadlib.addownload.xr.ka kaVar, String str, JSONObject jSONObject, boolean z, int i) {
        zb.ms(jSONObject, "download_scene", Integer.valueOf(kaVar.t()));
        com.ss.android.downloadlib.d.ms.ms().xr("market_click_open", jSONObject, kaVar);
        com.ss.android.downloadlib.addownload.xr.ab abVarMs = ms(context, Uri.parse(str));
        String strMs = zb.ms(abVarMs.xr(), "open_market");
        int type = abVarMs.getType();
        if (type == 5) {
            com.ss.android.downloadlib.xr.ms.ms(strMs, jSONObject, kaVar, true);
        } else {
            if (type == 6) {
                zb.ms(jSONObject, "error_code", Integer.valueOf(abVarMs.ms()));
                zb.ms(jSONObject, "download_scene", Integer.valueOf(kaVar.t()));
                com.ss.android.downloadlib.d.ms.ms().xr("market_open_failed", jSONObject, kaVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        if (z) {
            com.ss.android.downloadlib.d.ms.ms().ms(kaVar.f4454ms, i);
        }
        return true;
    }

    private static com.ss.android.downloadlib.addownload.xr.ab xr(Context context, com.ss.android.downloadlib.addownload.xr.ka kaVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("p", str);
        intent.putExtra("id", kaVar.f4454ms);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.xr.ab(7, "am_kllk2");
        } catch (Throwable unused) {
            xr(kaVar, jSONObject, 1, 3, "market://details?id=" + str);
            return ms(context, Uri.parse("market://details?id=" + str));
        }
    }

    private static void ah(Context context, com.ss.android.downloadlib.addownload.xr.ka kaVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.ms(context, str, kaVar.f4454ms);
        } catch (Exception unused) {
            com.ss.android.downloadlib.xr.ms.ms(ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
            xr(kaVar, jSONObject, 14, 11, "market://details?id=" + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.xr.ab d(Context context, com.ss.android.downloadlib.addownload.xr.ka kaVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("dl", true);
        intent.putExtra("p", str);
        intent.putExtra("id", kaVar.f4454ms);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (zb.ka(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else if (zb.ka(context, "com.coloros.browser")) {
            intent.putExtra("bk", "com.coloros.browser");
        } else {
            return ms(context, Uri.parse("market://details?id=" + str));
        }
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.xr.ab(7, "am_kllk3");
        } catch (Throwable unused) {
            xr(kaVar, jSONObject, 1, 3, "market://details?id=" + str);
            return ms(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static void ms(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        try {
            JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
            String strOptString = jSONObjectNy.optString("s");
            String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("aa"), strOptString);
            String strMs2 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("ac"), strOptString);
            String strMs3 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("af"), strOptString);
            boolean zMs = com.ss.android.socialbase.appdownloader.c.ms.ms(jSONObjectNy, context, strMs2);
            StringBuilder sb = new StringBuilder(String.format(strMs, str, strMs3, strMs2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strCh = com.ss.android.socialbase.appdownloader.c.ka.ch();
            if (zb.ka(context, strCh)) {
                intent.setPackage(strCh);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            zb.ms(jSONObject, "mf", Boolean.valueOf(zMs));
            zb.ms(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            com.ss.android.downloadlib.xr.ms.ms("am_kllk2", jSONObject, kaVarKa, true);
            if (zMs) {
                xr(kaVarKa, jSONObject, -1, 3, sb.toString());
            } else {
                xr(kaVarKa, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.xr.ms.ms(ms(com.ss.android.downloadlib.addownload.hi.getContext(), Uri.parse("market://details?id=" + str)), kaVarKa, true);
            xr(kaVarKa, jSONObject, 2, 3, "market://details?id=" + str);
        }
    }

    public static void ms(final Context context, String str, long j, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        try {
            JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
            String strOptString = jSONObjectNy.optString("s");
            String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("br"), strOptString);
            String strMs2 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bs_1"), strOptString);
            String strMs3 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bs_2"), strOptString);
            String strMs4 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bs_3"), strOptString);
            String strMs5 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bt"), strOptString);
            String strMs6 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bu"), strOptString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(strMs).append(strMs2).append(strMs3).append(strMs4).append(strMs5).append(strMs6);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            zb.ms(jSONObject, "dl", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            long jOptLong = com.ss.android.downloadlib.addownload.hi.ny().optLong("oppo_browser_jump_delay", 1000L);
            if (jOptLong > 0) {
                com.ss.android.downloadlib.x.ms().xr().post(new Runnable() { // from class: com.ss.android.downloadlib.ab.x.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.hi.ah().ms(12, com.ss.android.downloadlib.addownload.hi.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ab.x.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            if (kaVarKa.ka != null) {
                kaVarKa.ka.b(true);
            }
            com.ss.android.downloadlib.xr.ms.ms("am_kllk3", jSONObject, kaVarKa, true);
            xr(kaVarKa, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            if (kaVarKa.ka != null) {
                kaVarKa.ka.b(false);
            }
            com.ss.android.downloadlib.xr.ms.ms(ms(com.ss.android.downloadlib.addownload.hi.getContext(), Uri.parse("market://details?id=" + str), kaVarKa), kaVarKa, true);
            xr(kaVarKa, jSONObject, 2, 7, "market://details?id=" + str);
        }
    }

    private static boolean ms(Activity activity, String str, HashMap<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra("param", map);
        String strCh = com.ss.android.socialbase.appdownloader.c.ka.ch();
        if (zb.ka(com.ss.android.downloadlib.addownload.hi.getContext(), strCh)) {
            intent.setPackage(strCh);
        }
        if (!zb.ms(com.ss.android.downloadlib.addownload.hi.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "start v1");
            return false;
        }
    }

    private static void ka(final Context context, final com.ss.android.downloadlib.addownload.xr.ka kaVar, final String str) {
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ab.x.5
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.xr.ms.ms(x.ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
                    Thread.sleep(jSONObjectNy.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.ms.ms.ms.ms().ms(context, true);
                    com.ss.android.downloadlib.ms.ms.xr xrVar = new com.ss.android.downloadlib.ms.ms.xr();
                    xrVar.f4515ms = 1;
                    xrVar.xr = 0;
                    String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("v"), jSONObjectNy.optString("s"));
                    xrVar.ah = String.format(strMs, str);
                    com.ss.android.downloadlib.ms.ms.ms.ms().ms(xrVar, (com.ss.android.downloadlib.ms.ms.d) null);
                    com.ss.android.downloadlib.ms.ms.ms.ms().xr();
                    x.xr(kaVar, jSONObject, -1, 2, String.format(strMs, str));
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    x.xr(kaVar, jSONObject, 1, 2, "market://details?id=" + str);
                }
            }
        });
    }

    private static void c(final Context context, final com.ss.android.downloadlib.addownload.xr.ka kaVar, final String str) {
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ab.x.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String strOptString = jSONObjectNy.optString("s");
                    String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bw"), strOptString);
                    String strMs2 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bx"), strOptString);
                    String strMs3 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("by"), strOptString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(strMs).appendPath(strMs2).appendQueryParameter(strMs3, str);
                    com.ss.android.downloadlib.addownload.hi.d().ms("GET", builder.build().toString(), null, new qv() { // from class: com.ss.android.downloadlib.ab.x.6.1
                        /* JADX WARN: Code duplicated, block: B:9:0x002c  */
                        @Override // com.ss.android.download.api.config.qv
                        public void ms(String str2) {
                            boolean z;
                            if (TextUtils.isEmpty(str2)) {
                                z = false;
                            } else {
                                String strAh = x.ah(str2);
                                if (TextUtils.isEmpty(strAh)) {
                                    z = false;
                                } else {
                                    String strD = x.d(strAh);
                                    if (TextUtils.isEmpty(strD)) {
                                        z = false;
                                    } else {
                                        x.xr(context, kaVar, str, strD);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                return;
                            }
                            com.ss.android.downloadlib.xr.ms.ms(x.ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
                            x.xr(kaVar, jSONObject, 10, 9, "market://details?id=" + str);
                        }

                        @Override // com.ss.android.download.api.config.qv
                        public void ms(Throwable th) {
                            com.ss.android.downloadlib.xr.ms.ms(x.ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
                            zb.ms(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : AbstractJsonLexerKt.NULL);
                            x.xr(kaVar, jSONObject, 11, 9, "market://details?id=" + str);
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    x.xr(kaVar, jSONObject, 4, 9, "market://details?id=" + str);
                }
            }
        });
    }

    private static void ab(Context context, com.ss.android.downloadlib.addownload.xr.ka kaVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.ms(str, kaVar.f4454ms);
        } catch (Exception unused) {
            com.ss.android.downloadlib.xr.ms.ms(ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
            xr(kaVar, jSONObject, 13, 10, "market://details?id=" + str);
        }
    }

    private static void x(final Context context, final com.ss.android.downloadlib.addownload.xr.ka kaVar, final String str) {
        com.ss.android.downloadlib.ka.ms().ms(new Runnable() { // from class: com.ss.android.downloadlib.ab.x.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
                String strOptString = jSONObjectNy.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                zb.ms(jSONObject2, bv.aI, "v");
                zb.ms(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.hi.d().ms(strMs, com.ss.android.downloadlib.addownload.hi.qv().ms(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new qv() { // from class: com.ss.android.downloadlib.ab.x.7.1
                    @Override // com.ss.android.download.api.config.qv
                    public void ms(String str2) {
                        x.xr(context, str, str2, kaVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.qv
                    public void ms(Throwable th) {
                        com.ss.android.downloadlib.xr.ms.ms(x.ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
                        zb.ms(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : AbstractJsonLexerKt.NULL);
                        x.xr(kaVar, jSONObject, 7, 5, "market://details?id=" + str);
                    }
                });
            }
        });
    }

    private static void ny(Context context, com.ss.android.downloadlib.addownload.xr.ka kaVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.ms(str, kaVar.f4454ms, "need_comment");
        } catch (Exception unused) {
            com.ss.android.downloadlib.xr.ms.ms(ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
            xr(kaVar, jSONObject, 9, 8, "market://details?id=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(Context context, String str, String str2, com.ss.android.downloadlib.addownload.xr.ka kaVar, JSONObject jSONObject) {
        zb.ms(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(strMs)) {
                TTDelegateActivity.ms(str, kaVar.f4454ms, strMs, jSONObject);
            } else {
                com.ss.android.downloadlib.xr.ms.ms(ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
                xr(kaVar, jSONObject, 5, 5, "market://details?id=" + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.xr.ms.ms(ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
            xr(kaVar, jSONObject, 6, 5, "market://details?id=" + str);
        }
    }

    public static void ms(Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        try {
            JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
            boolean zMs = com.ss.android.socialbase.appdownloader.c.ms.ms(jSONObjectNy, activity, com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bg"), jSONObjectNy.optString("s")));
            HashMap<String, String> mapXr = zb.xr(new JSONObject(str2));
            if (zMs && !mapXr.isEmpty() && ms(activity, str, mapXr)) {
                xr(kaVarKa, jSONObject, -1, 5, "market://details?id=" + str);
                com.ss.android.downloadlib.xr.ms.ms("am_v1", jSONObject, kaVarKa, true);
                return;
            }
            if (zMs) {
                i = mapXr.isEmpty() ? 1 : 2;
            } else {
                i = 3;
            }
            xr(kaVarKa, jSONObject, i, 5, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms(ms((Context) activity, Uri.parse("market://details?id=" + str)), kaVarKa, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.xr.ms.ms(ms(com.ss.android.downloadlib.addownload.hi.getContext(), Uri.parse("market://details?id=" + str)), kaVarKa, true);
            xr(kaVarKa, jSONObject, 4, 5, "market://details?id=" + str);
        }
    }

    public static void ms(Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
        String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bv"), jSONObjectNy.optString("s"));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(strMs)) {
            builder.appendQueryParameter(strMs, str2);
        }
        if (ms(activity, builder.build())) {
            xr(kaVarKa, jSONObject, -1, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms("am_v2", jSONObject, kaVarKa, true);
        } else {
            xr(kaVarKa, jSONObject, 2, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms(ms((Context) activity, Uri.parse("market://details?id=" + str)), kaVarKa, true);
        }
    }

    public static boolean ms(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strCh = com.ss.android.socialbase.appdownloader.c.ka.ch();
        if (zb.ka(com.ss.android.downloadlib.addownload.hi.getContext(), strCh)) {
            intent.setPackage(strCh);
        }
        if (!zb.ms(com.ss.android.downloadlib.addownload.hi.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "start v2");
            return false;
        }
    }

    public static boolean xr(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strCh = com.ss.android.socialbase.appdownloader.c.ka.ch();
        if (zb.ka(com.ss.android.downloadlib.addownload.hi.getContext(), strCh)) {
            intent.setPackage(strCh);
        }
        if (!zb.ms(com.ss.android.downloadlib.addownload.hi.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "start HM1");
            return false;
        }
    }

    public static boolean ah(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strCh = com.ss.android.socialbase.appdownloader.c.ka.ch();
        if (zb.ka(com.ss.android.downloadlib.addownload.hi.getContext(), strCh)) {
            intent.setPackage(strCh);
        }
        if (!zb.ms(com.ss.android.downloadlib.addownload.hi.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "start HM2");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(com.ss.android.downloadlib.addownload.xr.ka kaVar, JSONObject jSONObject, int i, int i2, String str) {
        zb.ms(jSONObject, "error_code", Integer.valueOf(i));
        zb.ms(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        zb.ms(jSONObject, "rmu", str);
        zb.ms(jSONObject, com.ss.android.socialbase.appdownloader.c.ka.ch(), Integer.valueOf(zb.xr(com.ss.android.downloadlib.addownload.hi.getContext(), com.ss.android.socialbase.appdownloader.c.ka.ch())));
        com.ss.android.downloadlib.d.ms.ms().xr("am_result", jSONObject, kaVar);
    }

    static com.ss.android.downloadlib.addownload.xr.ab xr(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.xr.ab(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.hi.getContext();
        }
        Intent intentAb = zb.ab(context, str);
        if (intentAb == null) {
            return new com.ss.android.downloadlib.addownload.xr.ab(4, 22);
        }
        intentAb.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intentAb);
            return new com.ss.android.downloadlib.addownload.xr.ab(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.xr.ab(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.xr.ab ms(Context context, String str, com.ss.android.downloadad.api.ms.ms msVar) {
        Intent intentMs = ms(context, msVar, str, 1, (String) null);
        if (intentMs != null) {
            sl.ms().ms(f4342ms, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.ss.android.downloadlib.addownload.xr.ab abVarMs = ms(intentMs, true, context, str, msVar);
            if (abVarMs.getType() == 3) {
                return abVarMs;
            }
        }
        Intent intentAb = zb.ab(context, str);
        if (intentAb == null) {
            return new com.ss.android.downloadlib.addownload.xr.ab(4, 22);
        }
        return ms(intentAb, false, context, str, msVar);
    }

    private static com.ss.android.downloadlib.addownload.xr.ab ms(Intent intent, boolean z, Context context, String str, com.ss.android.downloadad.api.ms.ms msVar) {
        if (com.ss.android.downloadlib.addownload.hi.ny().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.hi.sl() != null && com.ss.android.downloadlib.addownload.hi.sl().ms() && msVar.h() && !z) {
            TTDelegateActivity.xr(str, msVar);
            return new com.ss.android.downloadlib.addownload.xr.ab(3);
        }
        intent.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.xr.ab(3);
        } catch (Exception e) {
            if (z) {
                sl.ms().xr(f4342ms, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.xr.ab(8, 23);
            }
            sl.ms().xr(f4342ms, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e.getMessage());
            return new com.ss.android.downloadlib.addownload.xr.ab(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.xr.ab ms(String str, com.ss.android.downloadad.api.ms.ms msVar) {
        return ms(com.ss.android.downloadlib.addownload.hi.getContext(), str, msVar);
    }

    static com.ss.android.downloadlib.addownload.xr.ab xr(String str, com.ss.android.downloadad.api.ms.ms msVar) {
        Intent intentMs;
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.xr.ab(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.hi.getContext();
        String packageName = msVar.nw().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            intentMs = null;
        } else {
            sl.ms().ms(f4342ms, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            intentMs = ms(context, msVar, packageName, 2, str);
            if (intentMs != null) {
                com.ss.android.downloadlib.addownload.xr.ab abVarMs = ms(context, intentMs, msVar, true, str);
                if (abVarMs.getType() == 1) {
                    return abVarMs;
                }
            }
        }
        intentMs.setData(Uri.parse(str));
        intentMs.addFlags(C.ENCODING_PCM_MU_LAW);
        intentMs.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        intentMs.putExtra("start_only_for_android", true);
        if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("fix_app_link_flag")) {
            intentMs.addFlags(TTAdConstant.KEY_CLICK_AREA);
        }
        return ms(context, intentMs, msVar, false, str);
    }

    private static com.ss.android.downloadlib.addownload.xr.ab ms(Context context, Intent intent, com.ss.android.downloadad.api.ms.ms msVar, boolean z, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.hi.getContext();
        }
        if (zb.xr(context, intent)) {
            if (com.ss.android.downloadlib.addownload.hi.ny().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.hi.sl() != null && com.ss.android.downloadlib.addownload.hi.sl().ms() && msVar.h() && !z) {
                TTDelegateActivity.ms(str, msVar);
                return new com.ss.android.downloadlib.addownload.xr.ab(1);
            }
            try {
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.xr.ab(1);
            } catch (Exception e) {
                if (z) {
                    sl.ms().xr(f4342ms, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e.getMessage());
                    return new com.ss.android.downloadlib.addownload.xr.ab(9);
                }
                sl.ms().xr(f4342ms, "realTryOpenByUrl", "url调起失败了，抛出异常" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.xr.ab(2);
            }
        }
        return new com.ss.android.downloadlib.addownload.xr.ab(2, 24);
    }

    static com.ss.android.downloadlib.addownload.xr.ab ms(com.ss.android.downloadad.api.ms.xr xrVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.xr.ab abVarXr = xr(str, xrVar);
        return (com.ss.android.downloadlib.xr.c.ms(xrVar) && abVarXr.getType() == 2) ? ms(str2, xrVar) : abVarXr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(Context context, com.ss.android.downloadlib.addownload.xr.ka kaVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.xr(str, kaVar.f4454ms, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.xr.ms.ms(ms(context, Uri.parse("market://details?id=" + str)), kaVar, true);
            xr(kaVar, jSONObject, 12, 9, "market://details?id=" + str);
        }
    }

    public static void xr(Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
        String strOptString = jSONObjectNy.optString("s");
        String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("bz"), strOptString);
        String strMs2 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("ca"), strOptString);
        String strMs3 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("cb"), strOptString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("hiapplink").authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(strMs)) {
            builder.appendQueryParameter(strMs, str2);
        }
        if (!TextUtils.isEmpty(strMs2) && !TextUtils.isEmpty(strMs3)) {
            builder.appendQueryParameter(strMs2, strMs3);
        }
        if (xr(activity, builder.build())) {
            xr(kaVarKa, jSONObject, -1, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms("am_hr", jSONObject, kaVarKa, true);
        } else {
            xr(kaVarKa, jSONObject, 2, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms(ms((Context) activity, Uri.parse("market://details?id=" + str)), kaVarKa, true);
        }
    }

    public static void ms(Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectNy = com.ss.android.downloadlib.addownload.hi.ny();
        String strOptString = jSONObjectNy.optString("s");
        String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString("ca"), strOptString);
        String strMs2 = com.ss.android.socialbase.appdownloader.c.ah.ms(jSONObjectNy.optString(a.a), strOptString);
        StringBuilder sb = new StringBuilder("market://details?id=");
        if (!TextUtils.isEmpty(strMs) && !TextUtils.isEmpty(strMs2)) {
            sb.append(str).append("&").append(strMs).append("=").append(strMs2);
        }
        if (ah(activity, Uri.parse(sb.toString()))) {
            xr(kaVarKa, jSONObject, -1, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms("am_hr2", jSONObject, kaVarKa, true);
        } else {
            xr(kaVarKa, jSONObject, 2, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms(ms((Context) activity, Uri.parse("market://details?id=" + str)), kaVarKa, true);
        }
    }

    public static void xr(Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        JSONObject jSONObject = new JSONObject();
        boolean zEnableOppoAutoDownload = ((AdDownloadController) kaVarKa.d).enableOppoAutoDownload();
        HashMap map = new HashMap();
        map.put("is_button", Boolean.valueOf(zEnableOppoAutoDownload));
        zb.ms(jSONObject, "is_button", Boolean.valueOf(zEnableOppoAutoDownload));
        Map<String, Object> mapInterceptObmMarket = ((AdDownloadController) kaVarKa.d).getDownloadMarketInterceptor().interceptObmMarket(map);
        if (mapInterceptObmMarket != null && mapInterceptObmMarket.get("convert_result") != null && Boolean.parseBoolean(mapInterceptObmMarket.get("convert_result").toString())) {
            xr(kaVarKa, jSONObject, -1, 11, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms("am_kllk4", jSONObject, kaVarKa, true);
        } else {
            xr(kaVarKa, jSONObject, 15, 11, "market://details?id=" + str);
            com.ss.android.downloadlib.xr.ms.ms(ms((Context) activity, Uri.parse("market://details?id=" + str)), kaVarKa, true);
        }
    }

    static boolean ah(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ah(String str) {
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String strGroup = matcher.find() ? matcher.group() : "";
        if (!strGroup.equals(null) && strGroup.length() > 0) {
            for (String str2 : strGroup.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith(f.a.d)) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    private static Intent ms(Context context, com.ss.android.downloadad.api.ms.ms msVar, String str, int i, String str2) {
        if (!msVar.ah() || msVar.re() == null || msVar.re().getDownloadMode() != 2 || msVar.nw() == null || ka.ms(msVar).ms("app_link_market_open_add_info", 0) != 1) {
            return null;
        }
        String strAh = com.ss.android.downloadlib.addownload.ny.ah(msVar.nw());
        String strD = com.ss.android.downloadlib.addownload.ny.d(msVar.nw());
        Intent intent = new Intent();
        intent.setClassName(str, AdBaseConstants.MARKET_OPEN_BRIDGE_ACTIVITY);
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (TextUtils.isEmpty(strAh) || resolveInfoResolveActivity == null) {
            return null;
        }
        intent.putExtra("click_id", strAh);
        if (!(context instanceof Activity)) {
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
        }
        if (!TextUtils.isEmpty(strD)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA, strD);
        }
        if (i == 2 && !TextUtils.isEmpty(str2)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str2);
        }
        return intent;
    }
}
