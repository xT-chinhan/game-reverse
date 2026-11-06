package com.byazt.e;

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
import com.byazt.a.JumpUnknownSourceActivity;
import com.byazt.ho.BaseConstants;
import com.byazt.l.fs;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 26})
public class qg {
    public static final String n = "qg";
    public static s qg;
    public static n s;

    /* JADX INFO: renamed from: com.byazt.e.qg$qg, reason: collision with other inner class name */
    interface InterfaceC0160qg {
        boolean n(Context context);
    }

    public interface s {
        void n(DownloadInfo downloadInfo, com.byazt.e.n nVar);
    }

    public static boolean n(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray jSONArrayL = com.byazt.f.n.n(downloadInfo.getId()).l("ah_plans");
        if (jSONArrayL == null) {
            return false;
        }
        int length = jSONArrayL.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayL.optJSONObject(i);
            if (com.byazt.bk.n.n(jSONObjectOptJSONObject) && n(context, downloadInfo, intent, jSONObjectOptJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0174  */
    /* JADX WARN: Code duplicated, block: B:107:0x0197  */
    /* JADX WARN: Code duplicated, block: B:110:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:97:0x016a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0172 A[PHI: r15
      0x0172: PHI (r15v13 com.byazt.e.n) = (r15v2 com.byazt.e.n), (r15v8 com.byazt.e.n), (r15v14 com.byazt.e.n) binds: [B:98:0x0170, B:88:0x0148, B:60:0x00e8] A[DONT_GENERATE, DONT_INLINE]] */
    private static boolean n(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        com.byazt.e.n nVarN;
        boolean zN;
        boolean z2 = false;
        if (jSONObject != null && downloadInfo != null) {
            com.byazt.e.n nVar = new com.byazt.e.n();
            String strOptString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(strOptString)) {
                com.byazt.f.n nVarN2 = com.byazt.f.n.n(downloadInfo);
                nVar.n = strOptString;
                strOptString.hashCode();
                switch (strOptString) {
                    case "plan_a":
                    case "plan_e":
                        if (!downloadInfo.isSavePathRedirected()) {
                            nVar.qg = downloadInfo.getAntiHijackErrorCode(-1);
                        } else {
                            nVarN = n(jSONObject, nVarN2);
                            if (nVarN.qg == 0) {
                                nVar = nVarN;
                            } else if (!strOptString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                                nVar.qg = downloadInfo.getAntiHijackErrorCode(10);
                            } else {
                                zN = n(context, downloadInfo, jSONObject, nVar);
                                z2 = zN;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", nVar.n());
                        }
                        if (qg != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            qg.n(downloadInfo, nVar);
                            break;
                        }
                        break;
                    case "plan_b":
                        nVarN = n(jSONObject, nVarN2);
                        if (nVarN.qg != 0) {
                            nVar = nVarN;
                        } else if (!downloadInfo.isSavePathRedirected()) {
                            nVar.qg = downloadInfo.getAntiHijackErrorCode(-1);
                        } else {
                            zN = qg(context, downloadInfo, jSONObject, nVar);
                            z2 = zN;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", nVar.n());
                        }
                        if (qg != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            qg.n(downloadInfo, nVar);
                            break;
                        }
                        break;
                    case "plan_c":
                        if (Build.VERSION.SDK_INT >= 26 || com.byazt.bk.l.s()) {
                            if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                                if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                    zN = n(context, intent, jSONObject, downloadInfo.getId(), nVar);
                                    z2 = zN;
                                }
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", nVar.n());
                        }
                        if (qg != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            qg.n(downloadInfo, nVar);
                            break;
                        }
                        break;
                    case "plan_d":
                        nVar.n = "plan_d";
                        if (!com.byazt.bk.l.q()) {
                            nVar.qg = 2;
                        } else {
                            try {
                                com.byazt.e.s.n(context, intent);
                                nVar.qg = 0;
                                z2 = true;
                            } catch (Throwable th) {
                                nVar.qg = 4;
                                nVar.s = th.toString();
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", nVar.n());
                        }
                        if (qg != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            qg.n(downloadInfo, nVar);
                            break;
                        }
                        break;
                    case "plan_f":
                        nVarN = n(jSONObject, nVarN2);
                        if (nVarN.qg == 0) {
                            if (!strOptString.equals("plan_f")) {
                            }
                            zN = n(context, downloadInfo, jSONObject, nVar);
                            z2 = zN;
                            break;
                        } else {
                            nVar = nVarN;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", nVar.n());
                        }
                        if (qg != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            qg.n(downloadInfo, nVar);
                            break;
                        }
                        break;
                    case "plan_g":
                        nVarN = qg(jSONObject, nVarN2);
                        if (nVarN.qg != 0) {
                            nVar = nVarN;
                        } else {
                            zN = n(context, downloadInfo, jSONObject, nVar, nVarN2);
                            z2 = zN;
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", nVar.n());
                        }
                        if (qg != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            qg.n(downloadInfo, nVar);
                            break;
                        }
                        break;
                    case "plan_h":
                        String strN = com.byazt.bk.s.n(nVarN2.s("bh"), nVarN2.s(com.anythink.core.common.s.a));
                        com.byazt.e.n nVarN3 = n(jSONObject, strN, context, nVarN2);
                        if (nVarN3.qg != 0) {
                            nVar = nVarN3;
                        } else {
                            String packageName = context.getPackageName();
                            if (com.byazt.bk.n.n(com.byazt.f.n.qg(), context, strN)) {
                                try {
                                    com.byazt.e.s.n(context, intent);
                                    nVar.qg = 0;
                                    com.byazt.bk.n.n(com.byazt.f.n.qg(), context, packageName);
                                    z2 = true;
                                } catch (Throwable th2) {
                                    try {
                                        nVar.qg = 1;
                                        nVar.s = th2.toString();
                                        com.byazt.bk.n.n(com.byazt.f.n.qg(), context, packageName);
                                    } catch (Throwable th3) {
                                        com.byazt.bk.n.n(com.byazt.f.n.qg(), context, packageName);
                                        throw th3;
                                    }
                                }
                            } else {
                                nVar.qg = 11;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", nVar.n());
                        }
                        if (qg != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            qg.n(downloadInfo, nVar);
                            break;
                        }
                        break;
                    default:
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", nVar.n());
                        }
                        if (qg != null) {
                            downloadInfo.getTempCacheData().put("intent", intent);
                            qg.n(downloadInfo, nVar);
                            break;
                        }
                        break;
                }
            }
        }
        return z2;
    }

    private static boolean n(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.byazt.e.n nVar, com.byazt.f.n nVar2) {
        boolean zQg;
        String strOptString = jSONObject.optString("type");
        nVar.n = strOptString;
        Intent intentQg = com.byazt.o.q.n(context, "vbi", jSONObject, downloadInfo).qg();
        StringBuilder sb = new StringBuilder();
        try {
            zQg = qg(context, intentQg);
        } catch (Throwable th) {
            sb.append(strOptString).append(" startActivity failed : ").append(n(th));
            n(nVar, 1);
            zQg = false;
        }
        if (!zQg) {
            nVar.s = sb.toString();
        } else {
            nVar.qg = 0;
        }
        return true;
    }

    private static boolean n(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.byazt.e.n nVar) {
        String str;
        boolean z;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("device_plans");
            nVar.l = strOptString;
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
                    com.byazt.o.n nVarN = com.byazt.o.q.n(context, str, jSONObject, downloadInfo);
                    if (nVarN != null) {
                        Intent intentQg = nVarN.qg();
                        if (intentQg != null) {
                            if (n(file, downloadInfo, jSONObject)) {
                                z = true;
                                try {
                                    n(context, intentQg, false);
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str).append(" startActivity failed : ").append(n(th));
                                    n(nVar, 1);
                                }
                            } else {
                                n(nVar, 6);
                                sb.append(str).append(" createDescFile failed! ");
                            }
                        } else {
                            n(nVar, 3);
                            sb.append(str).append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    nVar.s = sb.toString();
                } else {
                    nVar.q = str;
                    nVar.qg = 0;
                }
                return z;
            }
        }
        return false;
    }

    private static boolean qg(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.byazt.e.n nVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            nVar.q = "custom";
            com.byazt.o.n nVarN = com.byazt.o.q.n(context, "custom", jSONObject, downloadInfo);
            if (nVarN == null || !nVarN.n()) {
                nVar.qg = 3;
            } else {
                Intent intentQg = nVarN.qg();
                if (intentQg == null) {
                    return false;
                }
                if (n(new File(savePath), downloadInfo, jSONObject)) {
                    if (qg(context, intentQg)) {
                        nVar.qg = 0;
                        return true;
                    }
                    nVar.qg = 1;
                } else {
                    nVar.qg = 6;
                }
                return false;
            }
        }
        return false;
    }

    public static int n(com.byazt.f.n nVar) {
        int i;
        JSONObject jSONObjectQ = nVar.q("download_dir");
        if (!(jSONObjectQ != null ? !TextUtils.isEmpty(jSONObjectQ.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.byazt.f.n.s().n("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayL = nVar.l("ah_plans");
        int i2 = -1;
        if (jSONArrayL != null) {
            int length = jSONArrayL.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayL.optJSONObject(i3);
                if (com.byazt.bk.n.n(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if ("plan_a".equals(strOptString) || "plan_b".equals(strOptString) || "plan_e".equals(strOptString) || "plan_f".equals(strOptString)) {
                        com.byazt.e.n nVarN = n(jSONObjectOptJSONObject, nVar);
                        i = nVarN.qg;
                        if (nVarN.qg == 0) {
                            return 0;
                        }
                    } else {
                        if (!"plan_d".equalsIgnoreCase(strOptString) && !"plan_h".equalsIgnoreCase(strOptString)) {
                            if ("plan_g".equalsIgnoreCase(strOptString)) {
                                com.byazt.e.n nVarQg = qg(jSONObjectOptJSONObject, nVar);
                                i = nVarQg.qg;
                                if (nVarQg.qg == 0) {
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

    public static com.byazt.e.n n(JSONObject jSONObject, com.byazt.f.n nVar) {
        com.byazt.e.n nVar2 = new com.byazt.e.n();
        if (jSONObject == null) {
            return nVar2;
        }
        String strOptString = jSONObject.optString("type");
        nVar2.n = strOptString;
        if ("plan_b".equals(strOptString)) {
            nVar2.l = "custom";
            if (com.byazt.o.q.n(com.byazt.xv.s.u(), "custom", jSONObject, nVar)) {
                nVar2.qg = 0;
                return nVar2;
            }
            n(nVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            nVar2.l = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.byazt.o.q.n(com.byazt.xv.s.u(), str, jSONObject, nVar)) {
                        nVar2.qg = 0;
                        return nVar2;
                    }
                    n(nVar2, 3);
                }
            }
        }
        return nVar2;
    }

    public static com.byazt.e.n qg(JSONObject jSONObject, com.byazt.f.n nVar) {
        com.byazt.e.n nVar2 = new com.byazt.e.n();
        if (jSONObject == null) {
            return nVar2;
        }
        nVar2.n = jSONObject.optString("type");
        nVar2.l = "vbi";
        if (com.byazt.o.q.n(com.byazt.xv.s.u(), "vbi", jSONObject, nVar)) {
            nVar2.qg = 0;
        } else {
            n(nVar2, 3);
        }
        return nVar2;
    }

    public static com.byazt.e.n n(JSONObject jSONObject, String str, Context context, com.byazt.f.n nVar) {
        com.byazt.e.n nVar2 = new com.byazt.e.n();
        if (jSONObject != null && com.byazt.bk.l.s()) {
            nVar2.n = jSONObject.optString("type");
            if (nVar.n("bi", 0) == 1) {
                nVar2.qg = 0;
                return nVar2;
            }
            if (n(context)) {
                nVar2.qg = 2;
            } else if (com.byazt.bk.n.n(str) != null) {
                nVar2.qg = 0;
            } else {
                nVar2.qg = 9;
            }
        }
        return nVar2;
    }

    private static void n(com.byazt.e.n nVar, int i) {
        if (nVar.qg != -1) {
            nVar.qg = (nVar.qg * 10) + i;
        } else {
            nVar.qg = i;
        }
    }

    private static boolean n(File file, DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectQ = com.byazt.f.n.n(downloadInfo.getId()).q("download_dir");
        File file2 = null;
        String strOptString = jSONObjectQ != null ? jSONObjectQ.optString("ins_desc") : null;
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

    public static boolean n(Context context, Intent intent, JSONObject jSONObject, int i, com.byazt.e.n nVar) {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong("jump_interval", 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferencesQg = com.byazt.qyu.qg.qg(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferencesQg.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= jOptLong && !n(context)) {
                sharedPreferencesQg.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(C.ENCODING_PCM_MU_LAW);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (n(context, intent2, false)) {
                            q(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (nVar != null) {
                            nVar.qg = 1;
                            nVar.s = "tryShowUnknownSourceDialog" + n(th);
                        }
                        return false;
                    }
                }
                if (n(context, intent, i, jSONObject)) {
                    s(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean n(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            if (com.byazt.bk.l.s() && Build.VERSION.SDK_INT < 26 && !q(context)) {
                com.byazt.o.w wVar = new com.byazt.o.w(context);
                if (wVar.n()) {
                    n(context, intent, i, jSONObject, new InterfaceC0160qg() { // from class: com.byazt.e.qg.1
                        @Override // com.byazt.e.qg.InterfaceC0160qg
                        public boolean n(Context context2) {
                            return qg.q(context2);
                        }
                    });
                    return qg(context, wVar.qg());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !l(context)) {
                com.byazt.o.qg qgVar = new com.byazt.o.qg(context);
                if (qgVar.n()) {
                    n(context, intent, i, jSONObject, new InterfaceC0160qg() { // from class: com.byazt.e.qg.2
                        @Override // com.byazt.e.qg.InterfaceC0160qg
                        public boolean n(Context context2) {
                            return qg.l(context2);
                        }
                    });
                    return qg(context, qgVar.qg());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean n(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (com.byazt.bk.l.s() && Build.VERSION.SDK_INT < 26) {
                return q(context);
            }
            if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
                return l(context);
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(Context context) {
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
    public static boolean l(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean n() {
        return l.n == 1;
    }

    private static void q(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception unused) {
        }
        com.byazt.xv.s.wo().qg(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void n(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception unused) {
        }
        com.byazt.xv.s.wo().qg(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    public static void qg(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception unused) {
        }
        com.byazt.xv.s.wo().qg(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    public static void s(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception unused) {
        }
        com.byazt.xv.s.wo().qg(i, "guide_auth_open_setting", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i2);
        } catch (Exception unused) {
        }
        com.byazt.xv.s.wo().qg(i, "guide_auth_result", jSONObject);
    }

    private static void n(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0160qg interfaceC0160qg) {
        if (s != null) {
            com.byazt.b.n.n().qg(s);
            s = null;
        }
        s = new n(context, intent, i, jSONObject, interfaceC0160qg);
        com.byazt.b.n.n().n(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(Context context, Intent intent) {
        return n(context, intent, true);
    }

    public static boolean n(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String n(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 1474})
    private static class q implements Callable<Boolean> {
        public final Context n;
        public final long q;
        public final InterfaceC0160qg qg;
        public final Handler s;

        public q(Handler handler, Context context, InterfaceC0160qg interfaceC0160qg, long j) {
            this.n = context;
            this.qg = interfaceC0160qg;
            this.s = handler;
            this.q = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                InterfaceC0160qg interfaceC0160qg = this.qg;
                if (interfaceC0160qg != null) {
                    long j = this.q;
                    if (j > 0 && j <= 10000) {
                        Context context = this.n;
                        boolean zN = context != null ? interfaceC0160qg.n(context) : false;
                        Message messageObtain = Message.obtain();
                        if (zN) {
                            messageObtain.what = 2;
                            this.s.sendMessage(messageObtain);
                        } else {
                            messageObtain.what = 1;
                            this.s.sendMessageDelayed(messageObtain, this.q);
                        }
                        return Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            } catch (Throwable unused) {
            }
        }
    }

    public static void n(s sVar) {
        qg = sVar;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 48})
    private static class n implements com.byazt.b.n.InterfaceC0133n {
        public final l n;
        public final int qg;
        public JSONObject s;

        public n(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0160qg interfaceC0160qg) {
            this.s = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.qg = iOptInt;
            this.n = new l(context, intent, i, interfaceC0160qg, iOptInt);
        }

        @Override // com.byazt.b.n.InterfaceC0133n
        public void qg() {
            if (!this.n.rv) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.n.w.sendMessage(messageObtain);
            }
            com.byazt.b.n.n().qg(this);
            n unused = qg.s = null;
        }

        @Override // com.byazt.b.n.InterfaceC0133n
        public void s() {
            int iOptInt = this.s.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.n.w.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.n.w.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 2200})
    private static class l implements fs.n {
        public static int n;
        public static int qg;
        public Future<Boolean> fs;
        public final InterfaceC0160qg l;
        public final Intent q;
        public boolean rv = false;
        public final Context s;
        public final Handler w;
        public final long x;

        public l(Context context, Intent intent, int i, InterfaceC0160qg interfaceC0160qg, long j) {
            this.s = context;
            this.q = intent;
            qg = i;
            this.l = interfaceC0160qg;
            this.w = new fs(Looper.getMainLooper(), this);
            this.x = j;
        }

        @Override // com.byazt.l.fs.n
        public void n(Message message) {
            if (message != null) {
                if (message.what == 1) {
                    long j = this.x;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    n = 1;
                    this.fs = com.byazt.xv.s.d().submit(new q(this.w, this.s, this.l, this.x));
                    return;
                }
                if (message.what == 2) {
                    n = 2;
                    this.w.removeMessages(2);
                    this.w.removeMessages(1);
                    Future<Boolean> future = this.fs;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.rv && (Build.VERSION.SDK_INT < 29 || com.byazt.b.n.n().qg())) {
                        Intent intent = this.q;
                        if (intent != null) {
                            qg.qg(this.s, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.s).getDownloadInfo(qg);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.byazt.e.s.qg(this.s, qg, false);
                            }
                        }
                        this.rv = true;
                    }
                    qg.qg(qg, this.q == null, qg.n(this.s));
                }
            }
        }
    }
}
