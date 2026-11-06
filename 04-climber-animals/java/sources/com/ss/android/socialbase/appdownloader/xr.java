package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.provider.FontsContractCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.umeng.ccg.a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    private static ms ah = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4606ms = "xr";
    private static ah xr;

    public interface ah {
        void ms(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ms msVar);
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.xr$xr, reason: collision with other inner class name */
    interface InterfaceC0547xr {
        boolean ms(Context context);
    }

    public static boolean ms(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray jSONArrayKa = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ka("ah_plans");
        if (jSONArrayKa == null) {
            return false;
        }
        int length = jSONArrayKa.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayKa.optJSONObject(i);
            if (com.ss.android.socialbase.appdownloader.c.ms.ms(jSONObjectOptJSONObject) && ms(context, downloadInfo, intent, jSONObjectOptJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:103:0x018b  */
    /* JADX WARN: Code duplicated, block: B:106:0x019c  */
    /* JADX WARN: Code duplicated, block: B:93:0x015e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0166 A[PHI: r15
      0x0166: PHI (r15v13 com.ss.android.socialbase.appdownloader.ms) = 
      (r15v2 com.ss.android.socialbase.appdownloader.ms)
      (r15v8 com.ss.android.socialbase.appdownloader.ms)
      (r15v14 com.ss.android.socialbase.appdownloader.ms)
     binds: [B:94:0x0164, B:84:0x013c, B:60:0x00e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x0168  */
    private static boolean ms(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        com.ss.android.socialbase.appdownloader.ms msVarMs;
        boolean zMs;
        boolean z2 = false;
        if (jSONObject != null && downloadInfo != null) {
            com.ss.android.socialbase.appdownloader.ms msVar = new com.ss.android.socialbase.appdownloader.ms();
            String strOptString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(strOptString)) {
                com.ss.android.socialbase.downloader.ab.ms msVarMs2 = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo);
                msVar.f4589ms = strOptString;
                strOptString.hashCode();
                switch (strOptString) {
                    case "plan_a":
                    case "plan_e":
                        if (!downloadInfo.isSavePathRedirected()) {
                            msVar.xr = downloadInfo.getAntiHijackErrorCode(-1);
                        } else {
                            msVarMs = ms(jSONObject, msVarMs2);
                            if (msVarMs.xr == 0) {
                                msVar = msVarMs;
                            } else if (!strOptString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                                msVar.xr = downloadInfo.getAntiHijackErrorCode(10);
                            } else {
                                zMs = ms(context, downloadInfo, jSONObject, msVar);
                                z2 = zMs;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", msVar.ms());
                        }
                        if (xr != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            xr.ms(downloadInfo, msVar);
                            break;
                        }
                        break;
                    case "plan_b":
                        msVarMs = ms(jSONObject, msVarMs2);
                        if (msVarMs.xr != 0) {
                            msVar = msVarMs;
                        } else if (!downloadInfo.isSavePathRedirected()) {
                            msVar.xr = downloadInfo.getAntiHijackErrorCode(-1);
                        } else {
                            zMs = xr(context, downloadInfo, jSONObject, msVar);
                            z2 = zMs;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", msVar.ms());
                        }
                        if (xr != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            xr.ms(downloadInfo, msVar);
                            break;
                        }
                        break;
                    case "plan_c":
                        if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                            if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                zMs = ms(context, intent, jSONObject, downloadInfo.getId(), msVar);
                                z2 = zMs;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", msVar.ms());
                        }
                        if (xr != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            xr.ms(downloadInfo, msVar);
                            break;
                        }
                        break;
                    case "plan_d":
                        msVar.f4589ms = "plan_d";
                        if (!com.ss.android.socialbase.appdownloader.c.ka.d()) {
                            msVar.xr = 2;
                        } else {
                            try {
                                com.ss.android.socialbase.appdownloader.ah.ms(context, intent);
                                msVar.xr = 0;
                                z2 = true;
                            } catch (Throwable th) {
                                msVar.xr = 4;
                                msVar.ah = th.toString();
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", msVar.ms());
                        }
                        if (xr != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            xr.ms(downloadInfo, msVar);
                            break;
                        }
                        break;
                    case "plan_f":
                        msVarMs = ms(jSONObject, msVarMs2);
                        if (msVarMs.xr == 0) {
                            if (!strOptString.equals("plan_f")) {
                            }
                            zMs = ms(context, downloadInfo, jSONObject, msVar);
                            z2 = zMs;
                            break;
                        } else {
                            msVar = msVarMs;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", msVar.ms());
                        }
                        if (xr != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            xr.ms(downloadInfo, msVar);
                            break;
                        }
                        break;
                    case "plan_g":
                        msVarMs = xr(jSONObject, msVarMs2);
                        if (msVarMs.xr != 0) {
                            msVar = msVarMs;
                        } else {
                            zMs = ms(context, downloadInfo, jSONObject, msVar, msVarMs2);
                            z2 = zMs;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", msVar.ms());
                        }
                        if (xr != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            xr.ms(downloadInfo, msVar);
                            break;
                        }
                        break;
                    case "plan_h":
                        String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(msVarMs2.ah("bh"), msVarMs2.ah("s"));
                        com.ss.android.socialbase.appdownloader.ms msVarMs3 = ms(jSONObject, strMs, context, msVarMs2);
                        if (msVarMs3.xr != 0) {
                            msVar = msVarMs3;
                        } else {
                            String packageName = context.getPackageName();
                            if (com.ss.android.socialbase.appdownloader.c.ms.ms(com.ss.android.socialbase.downloader.ab.ms.xr(), context, strMs)) {
                                try {
                                    com.ss.android.socialbase.appdownloader.ah.ms(context, intent);
                                    msVar.xr = 0;
                                    com.ss.android.socialbase.appdownloader.c.ms.ms(com.ss.android.socialbase.downloader.ab.ms.xr(), context, packageName);
                                    z2 = true;
                                } catch (Throwable th2) {
                                    try {
                                        msVar.xr = 1;
                                        msVar.ah = th2.toString();
                                        com.ss.android.socialbase.appdownloader.c.ms.ms(com.ss.android.socialbase.downloader.ab.ms.xr(), context, packageName);
                                    } catch (Throwable th3) {
                                        com.ss.android.socialbase.appdownloader.c.ms.ms(com.ss.android.socialbase.downloader.ab.ms.xr(), context, packageName);
                                        throw th3;
                                    }
                                }
                            } else {
                                msVar.xr = 11;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", msVar.ms());
                        }
                        if (xr != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            xr.ms(downloadInfo, msVar);
                            break;
                        }
                        break;
                    default:
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", msVar.ms());
                        }
                        if (xr != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            xr.ms(downloadInfo, msVar);
                            break;
                        }
                        break;
                }
            }
        }
        return z2;
    }

    private static boolean ms(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.ms msVar, com.ss.android.socialbase.downloader.ab.ms msVar2) {
        boolean zXr;
        String strOptString = jSONObject.optString("type");
        msVar.f4589ms = strOptString;
        Intent intentXr = com.ss.android.socialbase.appdownloader.ms.d.ms(context, "vbi", jSONObject, downloadInfo).xr();
        StringBuilder sb = new StringBuilder();
        try {
            zXr = xr(context, intentXr);
        } catch (Throwable th) {
            sb.append(strOptString).append(" startActivity failed : ").append(ms(th));
            ms(msVar, 1);
            zXr = false;
        }
        if (!zXr) {
            msVar.ah = sb.toString();
        } else {
            msVar.xr = 0;
        }
        return true;
    }

    private static boolean ms(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.ms msVar) {
        String str;
        boolean z;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("device_plans");
            msVar.ka = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                String[] strArrSplit = strOptString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                int length = strArrSplit.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        z = false;
                        break;
                    }
                    str = strArrSplit[i];
                    com.ss.android.socialbase.appdownloader.ms.ms msVarMs = com.ss.android.socialbase.appdownloader.ms.d.ms(context, str, jSONObject, downloadInfo);
                    if (msVarMs != null) {
                        Intent intentXr = msVarMs.xr();
                        if (intentXr != null) {
                            if (ms(file, downloadInfo, jSONObject)) {
                                z = true;
                                try {
                                    ms(context, intentXr, false);
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str).append(" startActivity failed : ").append(ms(th));
                                    ms(msVar, 1);
                                }
                            } else {
                                ms(msVar, 6);
                                sb.append(str).append(" createDescFile failed! ");
                            }
                        } else {
                            ms(msVar, 3);
                            sb.append(str).append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    msVar.ah = sb.toString();
                } else {
                    msVar.d = str;
                    msVar.xr = 0;
                }
                return z;
            }
        }
        return false;
    }

    private static boolean xr(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.ms msVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            msVar.d = "custom";
            com.ss.android.socialbase.appdownloader.ms.ms msVarMs = com.ss.android.socialbase.appdownloader.ms.d.ms(context, "custom", jSONObject, downloadInfo);
            if (msVarMs == null || !msVarMs.ms()) {
                msVar.xr = 3;
            } else {
                Intent intentXr = msVarMs.xr();
                if (intentXr == null) {
                    return false;
                }
                if (ms(new File(savePath), downloadInfo, jSONObject)) {
                    if (xr(context, intentXr)) {
                        msVar.xr = 0;
                        return true;
                    }
                    msVar.xr = 1;
                } else {
                    msVar.xr = 6;
                }
                return false;
            }
        }
        return false;
    }

    public static int ms(com.ss.android.socialbase.downloader.ab.ms msVar) {
        int i;
        JSONObject jSONObjectD = msVar.d("download_dir");
        if (!(jSONObjectD != null ? !TextUtils.isEmpty(jSONObjectD.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.ab.ms.ah().ms("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayKa = msVar.ka("ah_plans");
        int i2 = -1;
        if (jSONArrayKa != null) {
            int length = jSONArrayKa.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayKa.optJSONObject(i3);
                if (com.ss.android.socialbase.appdownloader.c.ms.ms(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if ("plan_a".equals(strOptString) || "plan_b".equals(strOptString) || "plan_e".equals(strOptString) || "plan_f".equals(strOptString)) {
                        com.ss.android.socialbase.appdownloader.ms msVarMs = ms(jSONObjectOptJSONObject, msVar);
                        i = msVarMs.xr;
                        if (msVarMs.xr == 0) {
                            return 0;
                        }
                    } else {
                        if (!"plan_d".equalsIgnoreCase(strOptString) && !"plan_h".equalsIgnoreCase(strOptString)) {
                            if ("plan_g".equalsIgnoreCase(strOptString)) {
                                com.ss.android.socialbase.appdownloader.ms msVarXr = xr(jSONObjectOptJSONObject, msVar);
                                i = msVarXr.xr;
                                if (msVarXr.xr == 0) {
                                }
                            } else {
                                continue;
                            }
                        }
                        return 0;
                    }
                    i2 = i;
                }
            }
        }
        return i2;
    }

    public static com.ss.android.socialbase.appdownloader.ms ms(JSONObject jSONObject, com.ss.android.socialbase.downloader.ab.ms msVar) {
        com.ss.android.socialbase.appdownloader.ms msVar2 = new com.ss.android.socialbase.appdownloader.ms();
        if (jSONObject == null) {
            return msVar2;
        }
        String strOptString = jSONObject.optString("type");
        msVar2.f4589ms = strOptString;
        if ("plan_b".equals(strOptString)) {
            msVar2.ka = "custom";
            if (com.ss.android.socialbase.appdownloader.ms.d.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), "custom", jSONObject, msVar)) {
                msVar2.xr = 0;
                return msVar2;
            }
            ms(msVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            msVar2.ka = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.ms.d.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), str, jSONObject, msVar)) {
                        msVar2.xr = 0;
                        return msVar2;
                    }
                    ms(msVar2, 3);
                }
            }
        }
        return msVar2;
    }

    public static com.ss.android.socialbase.appdownloader.ms xr(JSONObject jSONObject, com.ss.android.socialbase.downloader.ab.ms msVar) {
        com.ss.android.socialbase.appdownloader.ms msVar2 = new com.ss.android.socialbase.appdownloader.ms();
        if (jSONObject == null) {
            return msVar2;
        }
        msVar2.f4589ms = jSONObject.optString("type");
        msVar2.ka = "vbi";
        if (com.ss.android.socialbase.appdownloader.ms.d.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), "vbi", jSONObject, msVar)) {
            msVar2.xr = 0;
        } else {
            ms(msVar2, 3);
        }
        return msVar2;
    }

    public static com.ss.android.socialbase.appdownloader.ms ms(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.ab.ms msVar) {
        com.ss.android.socialbase.appdownloader.ms msVar2 = new com.ss.android.socialbase.appdownloader.ms();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.c.ka.ah()) {
            msVar2.f4589ms = jSONObject.optString("type");
            if (msVar.ms("bi", 0) == 1) {
                msVar2.xr = 0;
                return msVar2;
            }
            if (ms(context)) {
                msVar2.xr = 2;
            } else if (com.ss.android.socialbase.appdownloader.c.ms.ms(str) != null) {
                msVar2.xr = 0;
            } else {
                msVar2.xr = 9;
            }
        }
        return msVar2;
    }

    private static void ms(com.ss.android.socialbase.appdownloader.ms msVar, int i) {
        if (msVar.xr != -1) {
            msVar.xr = (msVar.xr * 10) + i;
        } else {
            msVar.xr = i;
        }
    }

    private static boolean ms(File file, DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectD = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).d("download_dir");
        File file2 = null;
        String strOptString = jSONObjectD != null ? jSONObjectD.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
            file2 = new File(path + File.separator + strOptString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean ms(Context context, Intent intent, JSONObject jSONObject, int i, com.ss.android.socialbase.appdownloader.ms msVar) {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong("jump_interval", 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferencesXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferencesXr.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= jOptLong && !ms(context)) {
                sharedPreferencesXr.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(C.ENCODING_PCM_MU_LAW);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (ms(context, intent2, false)) {
                            d(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (msVar != null) {
                            msVar.xr = 1;
                            msVar.ah = "tryShowUnknownSourceDialog" + ms(th);
                        }
                        return false;
                    }
                }
                if (ms(context, intent, i, jSONObject)) {
                    ah(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean ms(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            com.ss.android.socialbase.appdownloader.c.ka.ah();
            if (context.getApplicationInfo().targetSdkVersion >= 26 && !ka(context)) {
                com.ss.android.socialbase.appdownloader.ms.xr xrVar = new com.ss.android.socialbase.appdownloader.ms.xr(context);
                if (xrVar.ms()) {
                    ms(context, intent, i, jSONObject, new InterfaceC0547xr() { // from class: com.ss.android.socialbase.appdownloader.xr.2
                        @Override // com.ss.android.socialbase.appdownloader.xr.InterfaceC0547xr
                        public boolean ms(Context context2) {
                            return xr.ka(context2);
                        }
                    });
                    return xr(context, xrVar.xr());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.xr$1, reason: invalid class name */
    static class AnonymousClass1 implements InterfaceC0547xr {
        AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.appdownloader.xr.InterfaceC0547xr
        public boolean ms(Context context) {
            return xr.d(context);
        }
    }

    public static boolean ms(Context context) {
        if (context == null) {
            return true;
        }
        try {
            com.ss.android.socialbase.appdownloader.c.ka.ah();
            if (context.getApplicationInfo().targetSdkVersion >= 26) {
                return ka(context);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ka(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean ms() {
        return ka.f4608ms == 1;
    }

    private static void d(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(a.j, i2);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.socialbase.downloader.downloader.ah.fm().xr(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void ms(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(a.j, i2);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.socialbase.downloader.downloader.ah.fm().xr(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    public static void xr(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(a.j, i2);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.socialbase.downloader.downloader.ah.fm().xr(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    public static void ah(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put(a.j, i2);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.socialbase.downloader.downloader.ah.fm().xr(i, "guide_auth_open_setting", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put(a.j, z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i2);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.socialbase.downloader.downloader.ah.fm().xr(i, "guide_auth_result", jSONObject);
    }

    private static void ms(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0547xr interfaceC0547xr) {
        if (ah != null) {
            com.ss.android.socialbase.downloader.ms.ms.ms().xr(ah);
            ah = null;
        }
        ah = new ms(context, intent, i, jSONObject, interfaceC0547xr);
        com.ss.android.socialbase.downloader.ms.ms.ms().ms(ah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xr(Context context, Intent intent) {
        return ms(context, intent, true);
    }

    public static boolean ms(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    public static String ms(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    private static class d implements Callable<Boolean> {
        private final Handler ah;
        private final long d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final Context f4607ms;
        private final InterfaceC0547xr xr;

        public d(Handler handler, Context context, InterfaceC0547xr interfaceC0547xr, long j) {
            this.f4607ms = context;
            this.xr = interfaceC0547xr;
            this.ah = handler;
            this.d = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                InterfaceC0547xr interfaceC0547xr = this.xr;
                if (interfaceC0547xr != null) {
                    long j = this.d;
                    if (j > 0 && j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        Context context = this.f4607ms;
                        boolean zMs = context != null ? interfaceC0547xr.ms(context) : false;
                        Message messageObtain = Message.obtain();
                        if (zMs) {
                            messageObtain.what = 2;
                            this.ah.sendMessage(messageObtain);
                        } else {
                            messageObtain.what = 1;
                            this.ah.sendMessageDelayed(messageObtain, this.d);
                        }
                        return Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            } catch (Throwable unused) {
            }
        }
    }

    public static void ms(ah ahVar) {
        xr = ahVar;
    }

    private static class ms implements com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms {
        private JSONObject ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final ka f4609ms;
        private final int xr;

        public ms(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0547xr interfaceC0547xr) {
            this.ah = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.xr = iOptInt;
            this.f4609ms = new ka(context, intent, i, interfaceC0547xr, iOptInt);
        }

        @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
        public void xr() {
            if (!this.f4609ms.ny) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.f4609ms.c.sendMessage(messageObtain);
            }
            com.ss.android.socialbase.downloader.ms.ms.ms().xr(this);
            ms unused = xr.ah = null;
        }

        @Override // com.ss.android.socialbase.downloader.ms.ms.InterfaceC0570ms
        public void ah() {
            int iOptInt = this.ah.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.f4609ms.c.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.f4609ms.c.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }
    }

    private static class ka implements com.ss.android.socialbase.downloader.x.x.ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public static int f4608ms;
        private static int xr;
        private final long ab;
        private final Context ah;
        private final Handler c;
        private final Intent d;
        private final InterfaceC0547xr ka;
        private boolean ny = false;
        private Future<Boolean> x;

        public ka(Context context, Intent intent, int i, InterfaceC0547xr interfaceC0547xr, long j) {
            this.ah = context;
            this.d = intent;
            xr = i;
            this.ka = interfaceC0547xr;
            this.c = new com.ss.android.socialbase.downloader.x.x(Looper.getMainLooper(), this);
            this.ab = j;
        }

        @Override // com.ss.android.socialbase.downloader.x.x.ms
        public void ms(Message message) {
            if (message != null) {
                if (message.what == 1) {
                    long j = this.ab;
                    if (j <= 0 || j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return;
                    }
                    f4608ms = 1;
                    this.x = com.ss.android.socialbase.downloader.downloader.ah.sl().submit(new d(this.c, this.ah, this.ka, this.ab));
                    return;
                }
                if (message.what == 2) {
                    f4608ms = 2;
                    this.c.removeMessages(2);
                    this.c.removeMessages(1);
                    Future<Boolean> future = this.x;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.ny && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.ms.ms.ms().xr())) {
                        Intent intent = this.d;
                        if (intent != null) {
                            xr.xr(this.ah, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.ah).getDownloadInfo(xr);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.ah.xr(this.ah, xr, false);
                            }
                        }
                        this.ny = true;
                    }
                    xr.xr(xr, this.d == null, xr.ms(this.ah));
                }
            }
        }
    }
}
