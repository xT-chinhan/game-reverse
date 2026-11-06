package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ny {
    public static boolean ms(int i) {
        return i == 0 || i == 1;
    }

    public static boolean xr(int i) {
        return i == 2 || i == 1;
    }

    public static boolean ms(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean xr(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean ms(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int ms(com.ss.android.downloadlib.addownload.xr.ka kaVar, boolean z, com.ss.android.socialbase.appdownloader.c cVar) {
        int iMs;
        if (cVar == null || TextUtils.isEmpty(cVar.ms()) || cVar.getContext() == null) {
            return 0;
        }
        try {
            iMs = ms(cVar, cVar.ms());
        } catch (Throwable th) {
            hi.t().ms(th, "redirectSavePathIfPossible");
            iMs = 4;
        }
        cVar.ms(iMs);
        if (iMs == 0) {
            cVar.ms(new com.ss.android.downloadlib.ah.ms());
        }
        if (!cVar.v()) {
            cVar.ms(new com.ss.android.downloadlib.ah.xr());
        }
        int iMs2 = com.ss.android.socialbase.appdownloader.d.ch().ms(cVar);
        com.ss.android.downloadad.api.ms.xr xrVarMs = ms(kaVar, iMs2);
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(xrVarMs);
        xrVarMs.ab(iMs2);
        xrVarMs.x(System.currentTimeMillis());
        xrVarMs.ny(0L);
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(cVar.rt());
        if (!ms(cVar, msVarMs, iMs2) && kaVar.xr.isShowToast()) {
            String startToast = kaVar.xr.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = msVarMs.ah("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            hi.ah().ms(2, cVar.getContext(), kaVar.xr, startToast, null, 0);
        }
        return iMs2;
    }

    private static com.ss.android.downloadad.api.ms.xr ms(com.ss.android.downloadlib.addownload.xr.ka kaVar, int i) {
        com.ss.android.downloadad.api.ms.xr xrVar = new com.ss.android.downloadad.api.ms.xr(kaVar.xr, kaVar.ah, kaVar.d, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("download_event_opt", 1) > 1) {
            try {
                String packageName = kaVar.xr.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (hi.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    xrVar.x(z);
                }
            } catch (Throwable unused) {
            }
        }
        return xrVar;
    }

    private static boolean ms(com.ss.android.socialbase.appdownloader.c cVar, com.ss.android.socialbase.downloader.ab.ms msVar, int i) {
        String strOptString;
        JSONArray jSONArrayKa = msVar.ka("ah_plans");
        if (jSONArrayKa != null && jSONArrayKa.length() != 0) {
            int length = jSONArrayKa.length();
            int i2 = 0;
            JSONObject jSONObject = null;
            while (true) {
                if (i2 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayKa.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.c.ms.ms(jSONObjectOptJSONObject))) {
                        strOptString.hashCode();
                        switch (strOptString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.ss.android.socialbase.appdownloader.xr.ms(jSONObjectOptJSONObject, msVar).xr != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "plan_c":
                                jSONObject = jSONObjectOptJSONObject;
                                continue;
                                break;
                            case "plan_d":
                            case "plan_h":
                                break;
                            case "plan_g":
                                if (com.ss.android.socialbase.appdownloader.xr.xr(jSONObjectOptJSONObject, msVar).xr != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            default:
                                continue;
                                break;
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.ss.android.socialbase.appdownloader.xr.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), (Intent) null, jSONObject, i, new com.ss.android.socialbase.appdownloader.ms());
                }
            }
        }
        return false;
    }

    public static String ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return null;
    }

    private static int ms(com.ss.android.socialbase.appdownloader.c cVar, String str) {
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(cVar.rt());
        JSONObject jSONObjectD = msVarMs.d("download_dir");
        if (jSONObjectD == null || TextUtils.isEmpty(jSONObjectD.optString("dir_name"))) {
            return -1;
        }
        String strXr = cVar.xr();
        String strM = cVar.m();
        if (TextUtils.isEmpty(strM)) {
            strM = com.ss.android.socialbase.appdownloader.ah.ms(str, strXr, cVar.sl(), true);
        }
        if (strM.length() > 255) {
            strM = strM.substring(strM.length() - 255);
        }
        if (TextUtils.isEmpty(strXr)) {
            strXr = strM;
        }
        String strAh = cVar.ah();
        if (TextUtils.isEmpty(strAh)) {
            strAh = com.ss.android.socialbase.appdownloader.ah.xr();
        }
        String str2 = strAh + File.separator + com.ss.android.socialbase.appdownloader.ah.ms(strXr, msVarMs);
        DownloadInfo downloadInfoMs = com.ss.android.socialbase.appdownloader.d.ch().ms(cVar.getContext(), str);
        if (downloadInfoMs != null && downloadInfoMs.isSavePathRedirected()) {
            cVar.ah(downloadInfoMs.getSavePath());
            try {
                cVar.ms(new JSONObject(downloadInfoMs.getDownloadSettingString()));
            } catch (Throwable unused) {
            }
            return 0;
        }
        if (downloadInfoMs != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.d.ch().ms(strM, cVar.sl()))) {
            return downloadInfoMs != null ? 8 : 9;
        }
        int iMs = com.ss.android.socialbase.appdownloader.xr.ms(msVarMs);
        if (iMs == 0) {
            cVar.ah(str2);
        }
        return iMs;
    }

    public static String ah(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    public static String d(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }
}
