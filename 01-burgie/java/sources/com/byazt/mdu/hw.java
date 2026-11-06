package com.byazt.mdu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.provider.FontsContractCompat;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.fi.BaseConstants;
import com.byazt.gi.zo;
import com.byazt.lj.Downloader;
import com.byazt.sv.JumpUnknownSourceActivity;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 13})
public class hw {
    public static pr hn;
    public static hn hw;
    public static final String pr = hw.class.getSimpleName();

    public interface hn {
        void pr(DownloadInfo downloadInfo, com.byazt.mdu.pr prVar);
    }

    /* JADX INFO: renamed from: com.byazt.mdu.hw$hw, reason: collision with other inner class name */
    interface InterfaceC0132hw {
        boolean pr(Context context);
    }

    public static boolean pr(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray jSONArrayC = com.byazt.ew.pr.pr(downloadInfo.getId()).c("ah_plans");
        if (jSONArrayC == null) {
            return false;
        }
        int length = jSONArrayC.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayC.optJSONObject(i);
            if (com.byazt.now.pr.pr(jSONObjectOptJSONObject) && pr(context, downloadInfo, intent, jSONObjectOptJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:89:0x016e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0177  */
    /* JADX WARN: Code duplicated, block: B:92:0x0179  */
    /* JADX WARN: Code duplicated, block: B:97:0x0194  */
    /* JADX WARN: Code duplicated, block: B:99:0x019b  */
    private static boolean pr(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        com.byazt.mdu.pr prVarPr;
        boolean zPr = false;
        if (jSONObject == null || downloadInfo == null) {
            return false;
        }
        com.byazt.mdu.pr prVar = new com.byazt.mdu.pr();
        String strOptString = jSONObject.optString("type");
        if (!TextUtils.isEmpty(strOptString)) {
            com.byazt.ew.pr prVarPr2 = com.byazt.ew.pr.pr(downloadInfo);
            prVar.pr = strOptString;
            switch (strOptString) {
                case "plan_a":
                case "plan_e":
                    if (!downloadInfo.isSavePathRedirected()) {
                        prVar.hw = downloadInfo.getAntiHijackErrorCode(-1);
                    } else {
                        prVarPr = pr(jSONObject, prVarPr2);
                        if (prVarPr.hw != 0) {
                            prVar = prVarPr;
                        } else if (!strOptString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                            prVar.hw = downloadInfo.getAntiHijackErrorCode(10);
                        } else {
                            zPr = pr(context, downloadInfo, jSONObject, prVar);
                        }
                    }
                    if (zPr) {
                        downloadInfo.getTempCacheData().put("ah_attempt", prVar.pr());
                    }
                    if (hw != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        hw.pr(downloadInfo, prVar);
                        break;
                    }
                    break;
                case "plan_f":
                    prVarPr = pr(jSONObject, prVarPr2);
                    if (prVarPr.hw != 0) {
                        prVar = prVarPr;
                    } else if (!strOptString.equals("plan_f")) {
                        zPr = pr(context, downloadInfo, jSONObject, prVar);
                    } else {
                        zPr = pr(context, downloadInfo, jSONObject, prVar);
                    }
                    if (zPr) {
                        downloadInfo.getTempCacheData().put("ah_attempt", prVar.pr());
                    }
                    if (hw != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        hw.pr(downloadInfo, prVar);
                        break;
                    }
                    break;
                case "plan_b":
                    com.byazt.mdu.pr prVarPr3 = pr(jSONObject, prVarPr2);
                    if (prVarPr3.hw != 0) {
                        prVar = prVarPr3;
                    } else if (!downloadInfo.isSavePathRedirected()) {
                        prVar.hw = downloadInfo.getAntiHijackErrorCode(-1);
                    } else {
                        zPr = hw(context, downloadInfo, jSONObject, prVar);
                    }
                    if (zPr) {
                        downloadInfo.getTempCacheData().put("ah_attempt", prVar.pr());
                    }
                    if (hw != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        hw.pr(downloadInfo, prVar);
                        break;
                    }
                    break;
                case "plan_d":
                    prVar.pr = "plan_d";
                    if (!com.byazt.now.c.x()) {
                        prVar.hw = 2;
                    } else {
                        try {
                            com.byazt.mdu.hn.pr(context, intent);
                            prVar.hw = 0;
                            zPr = true;
                        } catch (Throwable th) {
                            prVar.hw = 4;
                            prVar.hn = th.toString();
                        }
                    }
                    if (zPr) {
                        downloadInfo.getTempCacheData().put("ah_attempt", prVar.pr());
                    }
                    if (hw != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        hw.pr(downloadInfo, prVar);
                        break;
                    }
                    break;
                case "plan_g":
                    com.byazt.mdu.pr prVarHw = hw(jSONObject, prVarPr2);
                    if (prVarHw.hw != 0) {
                        prVar = prVarHw;
                    } else {
                        zPr = pr(context, downloadInfo, jSONObject, prVar, prVarPr2);
                    }
                    if (zPr) {
                        downloadInfo.getTempCacheData().put("ah_attempt", prVar.pr());
                    }
                    if (hw != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        hw.pr(downloadInfo, prVar);
                        break;
                    }
                    break;
                case "plan_h":
                    String strPr = com.byazt.now.hn.pr(prVarPr2.hn("bh"), prVarPr2.hn(an.aB));
                    com.byazt.mdu.pr prVarPr4 = pr(jSONObject, strPr, context, prVarPr2);
                    if (prVarPr4.hw != 0) {
                        prVar = prVarPr4;
                    } else {
                        String packageName = context.getPackageName();
                        if (com.byazt.now.pr.pr(com.byazt.ew.pr.hw(), context, strPr)) {
                            try {
                                com.byazt.mdu.hn.pr(context, intent);
                                prVar.hw = 0;
                                com.byazt.now.pr.pr(com.byazt.ew.pr.hw(), context, packageName);
                                zPr = true;
                            } catch (Throwable th2) {
                                try {
                                    prVar.hw = 1;
                                    prVar.hn = th2.toString();
                                    com.byazt.now.pr.pr(com.byazt.ew.pr.hw(), context, packageName);
                                } catch (Throwable th3) {
                                    com.byazt.now.pr.pr(com.byazt.ew.pr.hw(), context, packageName);
                                    throw th3;
                                }
                            }
                        } else {
                            prVar.hw = 11;
                        }
                    }
                    if (zPr) {
                        downloadInfo.getTempCacheData().put("ah_attempt", prVar.pr());
                    }
                    if (hw != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        hw.pr(downloadInfo, prVar);
                        break;
                    }
                    break;
                case "plan_c":
                    if (Build.VERSION.SDK_INT >= 26 || com.byazt.now.c.hn()) {
                        if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                            if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                zPr = pr(context, intent, jSONObject, downloadInfo.getId(), prVar);
                            }
                        }
                    }
                    if (zPr) {
                        downloadInfo.getTempCacheData().put("ah_attempt", prVar.pr());
                    }
                    if (hw != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        hw.pr(downloadInfo, prVar);
                        break;
                    }
                    break;
                default:
                    if (zPr) {
                        downloadInfo.getTempCacheData().put("ah_attempt", prVar.pr());
                    }
                    if (hw != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        hw.pr(downloadInfo, prVar);
                        break;
                    }
                    break;
            }
        }
        return zPr;
    }

    private static boolean pr(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.byazt.mdu.pr prVar, com.byazt.ew.pr prVar2) {
        boolean zHw;
        String strOptString = jSONObject.optString("type");
        prVar.pr = strOptString;
        Intent intentHw = com.byazt.rte.x.pr(context, "vbi", jSONObject, downloadInfo).hw();
        StringBuilder sb = new StringBuilder();
        try {
            zHw = hw(context, intentHw);
        } catch (Throwable th) {
            sb.append(strOptString).append(" startActivity failed : ").append(pr(th));
            pr(prVar, 1);
            zHw = false;
        }
        if (!zHw) {
            prVar.hn = sb.toString();
        } else {
            prVar.hw = 0;
        }
        return true;
    }

    private static boolean pr(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.byazt.mdu.pr prVar) {
        boolean z;
        if (context == null || jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("device_plans");
        prVar.c = strOptString;
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        String[] strArrSplit = strOptString.split(",");
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath)) {
            return false;
        }
        File file = new File(savePath);
        StringBuilder sb = new StringBuilder();
        String str = null;
        int length = strArrSplit.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                z = false;
                break;
            }
            String str2 = strArrSplit[i];
            com.byazt.rte.pr prVarPr = com.byazt.rte.x.pr(context, str2, jSONObject, downloadInfo);
            if (prVarPr != null) {
                Intent intentHw = prVarPr.hw();
                if (intentHw != null) {
                    if (pr(file, downloadInfo, jSONObject)) {
                        try {
                            pr(context, intentHw, false);
                            str = str2;
                            break;
                        } catch (Throwable th) {
                            sb.append(str2).append(" startActivity failed : ").append(pr(th));
                            pr(prVar, 1);
                        }
                    } else {
                        pr(prVar, 6);
                        sb.append(str2).append(" createDescFile failed! ");
                    }
                } else {
                    pr(prVar, 3);
                    sb.append(str2).append(" resolveActivity failed! ");
                }
            }
            sb.append("  ");
            i++;
        }
        if (!z) {
            prVar.hn = sb.toString();
        } else {
            prVar.x = str;
            prVar.hw = 0;
        }
        return z;
    }

    private static boolean hw(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.byazt.mdu.pr prVar) {
        if (context == null || jSONObject == null) {
            return false;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath)) {
            return false;
        }
        prVar.x = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
        com.byazt.rte.pr prVarPr = com.byazt.rte.x.pr(context, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, downloadInfo);
        if (prVarPr == null || !prVarPr.pr()) {
            prVar.hw = 3;
            return false;
        }
        Intent intentHw = prVarPr.hw();
        if (intentHw == null) {
            return false;
        }
        if (pr(new File(savePath), downloadInfo, jSONObject)) {
            if (hw(context, intentHw)) {
                prVar.hw = 0;
                return true;
            }
            prVar.hw = 1;
        } else {
            prVar.hw = 6;
        }
        return false;
    }

    public static int pr(com.byazt.ew.pr prVar) {
        boolean z;
        JSONObject jSONObjectX = prVar.x("download_dir");
        if (jSONObjectX == null) {
            z = false;
        } else {
            z = !TextUtils.isEmpty(jSONObjectX.optString("dir_name"));
        }
        if (!z) {
            return 5;
        }
        if (!com.byazt.ew.pr.hn().pr("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayC = prVar.c("ah_plans");
        int i = -1;
        if (jSONArrayC != null) {
            int length = jSONArrayC.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayC.optJSONObject(i2);
                if (com.byazt.now.pr.pr(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if ("plan_a".equals(strOptString) || "plan_b".equals(strOptString) || "plan_e".equals(strOptString) || "plan_f".equals(strOptString)) {
                        com.byazt.mdu.pr prVarPr = pr(jSONObjectOptJSONObject, prVar);
                        int i3 = prVarPr.hw;
                        if (prVarPr.hw == 0) {
                            return 0;
                        }
                        i = i3;
                    } else {
                        if ("plan_d".equalsIgnoreCase(strOptString) || "plan_h".equalsIgnoreCase(strOptString)) {
                            return 0;
                        }
                        if ("plan_g".equalsIgnoreCase(strOptString)) {
                            com.byazt.mdu.pr prVarHw = hw(jSONObjectOptJSONObject, prVar);
                            int i4 = prVarHw.hw;
                            if (prVarHw.hw == 0) {
                                return 0;
                            }
                            i = i4;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return i;
    }

    public static com.byazt.mdu.pr pr(JSONObject jSONObject, com.byazt.ew.pr prVar) {
        com.byazt.mdu.pr prVar2 = new com.byazt.mdu.pr();
        if (jSONObject == null) {
            return prVar2;
        }
        String strOptString = jSONObject.optString("type");
        prVar2.pr = strOptString;
        if ("plan_b".equals(strOptString)) {
            prVar2.c = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
            if (com.byazt.rte.x.pr(com.byazt.lj.hn.of(), MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, prVar)) {
                prVar2.hw = 0;
                return prVar2;
            }
            pr(prVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            prVar2.c = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.byazt.rte.x.pr(com.byazt.lj.hn.of(), str, jSONObject, prVar)) {
                        prVar2.hw = 0;
                        return prVar2;
                    }
                    pr(prVar2, 3);
                }
            }
        }
        return prVar2;
    }

    public static com.byazt.mdu.pr hw(JSONObject jSONObject, com.byazt.ew.pr prVar) {
        com.byazt.mdu.pr prVar2 = new com.byazt.mdu.pr();
        if (jSONObject == null) {
            return prVar2;
        }
        prVar2.pr = jSONObject.optString("type");
        prVar2.c = "vbi";
        if (com.byazt.rte.x.pr(com.byazt.lj.hn.of(), "vbi", jSONObject, prVar)) {
            prVar2.hw = 0;
        } else {
            pr(prVar2, 3);
        }
        return prVar2;
    }

    public static com.byazt.mdu.pr pr(JSONObject jSONObject, String str, Context context, com.byazt.ew.pr prVar) {
        com.byazt.mdu.pr prVar2 = new com.byazt.mdu.pr();
        if (jSONObject == null || !com.byazt.now.c.hn()) {
            return prVar2;
        }
        prVar2.pr = jSONObject.optString("type");
        if (prVar.pr("bi", 0) == 1) {
            prVar2.hw = 0;
            return prVar2;
        }
        if (pr(context)) {
            prVar2.hw = 2;
        } else if (com.byazt.now.pr.pr(str) != null) {
            prVar2.hw = 0;
        } else {
            prVar2.hw = 9;
        }
        return prVar2;
    }

    private static void pr(com.byazt.mdu.pr prVar, int i) {
        if (prVar.hw != -1) {
            prVar.hw = (prVar.hw * 10) + i;
        } else {
            prVar.hw = i;
        }
    }

    private static boolean pr(File file, DownloadInfo downloadInfo, JSONObject jSONObject) {
        String strOptString;
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectX = com.byazt.ew.pr.pr(downloadInfo.getId()).x("download_dir");
        File file2 = null;
        if (jSONObjectX == null) {
            strOptString = null;
        } else {
            strOptString = jSONObjectX.optString("ins_desc");
        }
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
            file2 = new File(path + File.separator + strOptString);
        }
        if (file2 != null) {
            try {
                if (file2.createNewFile()) {
                    file2.deleteOnExit();
                    return true;
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean pr(Context context, Intent intent, JSONObject jSONObject, int i, com.byazt.mdu.pr prVar) {
        if (context == null || jSONObject == null) {
            return false;
        }
        long jOptLong = jSONObject.optLong("jump_interval", 0L);
        if (jOptLong <= 0) {
            return false;
        }
        SharedPreferences sharedPreferencesHw = com.byazt.mg.hw.hw(context, "sp_ah_config", 0);
        if ((System.currentTimeMillis() - sharedPreferencesHw.getLong("last_jump_unknown_source_time", 0L)) / 60000 < jOptLong || pr(context)) {
            return false;
        }
        sharedPreferencesHw.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
        if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
            Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
            intent2.addFlags(C.ENCODING_PCM_MU_LAW);
            intent2.putExtra("intent", intent);
            intent2.putExtra("config", jSONObject.toString());
            intent2.putExtra("id", i);
            try {
                if (pr(context, intent2, false)) {
                    x(i, jSONObject);
                }
                return true;
            } catch (Throwable th) {
                if (prVar != null) {
                    prVar.hw = 1;
                    prVar.hn = "tryShowUnknownSourceDialog" + pr(th);
                }
                return false;
            }
        }
        if (pr(context, intent, i, jSONObject)) {
            hn(i, jSONObject);
        }
        return true;
    }

    public static boolean pr(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            if (com.byazt.now.c.hn() && Build.VERSION.SDK_INT < 26 && !x(context)) {
                com.byazt.rte.uc ucVar = new com.byazt.rte.uc(context);
                if (ucVar.pr()) {
                    pr(context, intent, i, jSONObject, new InterfaceC0132hw() { // from class: com.byazt.mdu.hw.1
                        @Override // com.byazt.mdu.hw.InterfaceC0132hw
                        public boolean pr(Context context2) {
                            return hw.x(context2);
                        }
                    });
                    return hw(context, ucVar.hw());
                }
            } else {
                if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26 || c(context)) {
                    return false;
                }
                com.byazt.rte.hw hwVar = new com.byazt.rte.hw(context);
                if (hwVar.pr()) {
                    pr(context, intent, i, jSONObject, new InterfaceC0132hw() { // from class: com.byazt.mdu.hw.2
                        @Override // com.byazt.mdu.hw.InterfaceC0132hw
                        public boolean pr(Context context2) {
                            return hw.c(context2);
                        }
                    });
                    return hw(context, hwVar.hw());
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean pr(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (com.byazt.now.c.hn() && Build.VERSION.SDK_INT < 26) {
                return x(context);
            }
            if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26) {
                return true;
            }
            return c(context);
        } catch (Throwable th) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable th) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th) {
            return true;
        }
    }

    public static boolean pr() {
        return c.pr == 1;
    }

    private static void x(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
        }
        com.byazt.lj.hn.i().hw(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void pr(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
        }
        com.byazt.lj.hn.i().hw(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    public static void hw(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
        }
        com.byazt.lj.hn.i().hw(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    public static void hn(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
        }
        com.byazt.lj.hn.i().hw(i, "guide_auth_open_setting", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i2);
        } catch (Exception e) {
        }
        com.byazt.lj.hn.i().hw(i, "guide_auth_result", jSONObject);
    }

    private static void pr(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0132hw interfaceC0132hw) {
        if (hn != null) {
            com.byazt.wel.pr.pr().hw(hn);
            hn = null;
        }
        hn = new pr(context, intent, i, jSONObject, interfaceC0132hw);
        com.byazt.wel.pr.pr().pr(hn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(Context context, Intent intent) {
        return pr(context, intent, true);
    }

    public static boolean pr(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String pr(Throwable th) {
        String string = th.toString();
        if (string.length() > 800) {
            return string.substring(0, 500);
        }
        return string;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 1243})
    private static class x implements Callable<Boolean> {
        public final Handler hn;
        public final InterfaceC0132hw hw;
        public final Context pr;
        public final long x;

        public x(Handler handler, Context context, InterfaceC0132hw interfaceC0132hw, long j) {
            this.pr = context;
            this.hw = interfaceC0132hw;
            this.hn = handler;
            this.x = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                InterfaceC0132hw interfaceC0132hw = this.hw;
                if (interfaceC0132hw != null) {
                    long j = this.x;
                    if (j > 0 && j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        boolean zPr = false;
                        Context context = this.pr;
                        if (context != null) {
                            zPr = interfaceC0132hw.pr(context);
                        }
                        Message messageObtain = Message.obtain();
                        if (zPr) {
                            messageObtain.what = 2;
                            this.hn.sendMessage(messageObtain);
                        } else {
                            messageObtain.what = 1;
                            this.hn.sendMessageDelayed(messageObtain, this.x);
                        }
                        return Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            } catch (Throwable th) {
            }
        }
    }

    public static void pr(hn hnVar) {
        hw = hnVar;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr implements com.byazt.wel.pr.InterfaceC0223pr {
        public JSONObject hn;
        public final int hw;
        public final c pr;

        public pr(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0132hw interfaceC0132hw) {
            this.hn = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.hw = iOptInt;
            this.pr = new c(context, intent, i, interfaceC0132hw, iOptInt);
        }

        @Override // com.byazt.wel.pr.InterfaceC0223pr
        public void hw() {
            if (!this.pr.aj) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.pr.uc.sendMessage(messageObtain);
            }
            com.byazt.wel.pr.pr().hw(this);
            pr unused = hw.hn = null;
        }

        @Override // com.byazt.wel.pr.InterfaceC0223pr
        public void hn() {
            int iOptInt = this.hn.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.pr.uc.sendMessage(messageObtain);
            if (iOptInt > 0 && iOptInt < 60) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 2;
                this.pr.uc.sendMessageDelayed(messageObtain2, iOptInt * 1000);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 1494})
    private static class c implements zo.pr {
        public static int hw;
        public static int pr;
        public boolean aj = false;
        public final InterfaceC0132hw c;
        public final long fw;
        public final Context hn;
        public final Handler uc;
        public final Intent x;
        public Future<Boolean> zo;

        public c(Context context, Intent intent, int i, InterfaceC0132hw interfaceC0132hw, long j) {
            this.hn = context;
            this.x = intent;
            hw = i;
            this.c = interfaceC0132hw;
            this.uc = new zo(Looper.getMainLooper(), this);
            this.fw = j;
        }

        @Override // com.byazt.gi.zo.pr
        public void pr(Message message) {
            if (message != null) {
                if (message.what == 1) {
                    long j = this.fw;
                    if (j <= 0 || j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return;
                    }
                    pr = 1;
                    this.zo = com.byazt.lj.hn.k().submit(new x(this.uc, this.hn, this.c, this.fw));
                    return;
                }
                if (message.what == 2) {
                    pr = 2;
                    this.uc.removeMessages(2);
                    this.uc.removeMessages(1);
                    Future<Boolean> future = this.zo;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.aj && (Build.VERSION.SDK_INT < 29 || com.byazt.wel.pr.pr().hw())) {
                        Intent intent = this.x;
                        if (intent != null) {
                            hw.hw(this.hn, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.hn).getDownloadInfo(hw);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.byazt.mdu.hn.hw(this.hn, hw, false);
                            }
                        }
                        this.aj = true;
                    }
                    hw.hw(hw, this.x == null, hw.pr(this.hn));
                }
            }
        }
    }
}
