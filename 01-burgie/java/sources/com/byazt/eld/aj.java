package com.byazt.eld;

import android.content.Intent;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadModel;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.km.AdDownloadModel;
import com.byazt.zv.IDownloadButtonClickListener;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 61})
public class aj {
    public static boolean pr(int i) {
        return i == 0 || i == 1;
    }

    public static boolean hw(int i) {
        return i == 2 || i == 1;
    }

    public static boolean pr(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean hw(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean pr(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int pr(com.byazt.shh.c cVar, boolean z, com.byazt.mdu.c cVar2) {
        int iPr;
        String str;
        if (cVar2 == null || TextUtils.isEmpty(cVar2.pr()) || cVar2.getContext() == null) {
            return 0;
        }
        try {
            iPr = pr(cVar2, cVar2.pr());
        } catch (Throwable th) {
            k.a().pr(th, "redirectSavePathIfPossible");
            iPr = 4;
        }
        cVar2.pr(iPr);
        if (iPr == 0) {
            cVar2.pr(new com.byazt.sxm.pr());
        }
        if (!cVar2.lv()) {
            cVar2.pr(new com.byazt.sxm.hw());
        }
        int iPr2 = com.byazt.mdu.x.w().pr(cVar2);
        com.byazt.tia.hw hwVarPr = pr(cVar, iPr2);
        com.byazt.shh.uc.pr().pr(hwVarPr);
        hwVarPr.fw(iPr2);
        hwVarPr.zo(System.currentTimeMillis());
        hwVarPr.aj(0L);
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(cVar2.sv());
        if (!pr(cVar2, prVarPr, iPr2) && cVar.hw.isShowToast()) {
            String startToast = cVar.hw.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = prVarPr.hn("download_start_toast_text");
            }
            if (!TextUtils.isEmpty(startToast)) {
                str = startToast;
            } else {
                str = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            k.hn().pr(2, cVar2.getContext(), cVar.hw, str, null, 0);
        }
        return iPr2;
    }

    private static com.byazt.tia.hw pr(com.byazt.shh.c cVar, int i) {
        com.byazt.tia.hw hwVar = new com.byazt.tia.hw(cVar.hw, cVar.hn, cVar.x, i);
        boolean z = true;
        if (com.byazt.ew.pr.pr(i).pr("download_event_opt", 1) > 1) {
            try {
                String packageName = cVar.hw.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (k.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    hwVar.zo(z);
                }
            } catch (Throwable th) {
            }
        }
        return hwVar;
    }

    private static boolean pr(com.byazt.mdu.c cVar, com.byazt.ew.pr prVar, int i) {
        String strOptString;
        JSONArray jSONArrayC = prVar.c("ah_plans");
        if (jSONArrayC == null || jSONArrayC.length() == 0) {
            return false;
        }
        int length = jSONArrayC.length();
        int i2 = 0;
        JSONObject jSONObject = null;
        while (true) {
            if (i2 < length) {
                JSONObject jSONObjectOptJSONObject = jSONArrayC.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.byazt.now.pr.pr(jSONObjectOptJSONObject))) {
                    switch (strOptString) {
                        case "plan_a":
                        case "plan_b":
                        case "plan_e":
                        case "plan_f":
                            if (com.byazt.mdu.hw.pr(jSONObjectOptJSONObject, prVar).hw != 0) {
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "plan_d":
                        case "plan_h":
                            break;
                        case "plan_g":
                            if (com.byazt.mdu.hw.hw(jSONObjectOptJSONObject, prVar).hw != 0) {
                                break;
                            } else {
                                break;
                            }
                            break;
                        case "plan_c":
                            jSONObject = jSONObjectOptJSONObject;
                            continue;
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
                return com.byazt.mdu.hw.pr(com.byazt.lj.hn.of(), (Intent) null, jSONObject, i, new com.byazt.mdu.pr());
            }
        }
        return false;
    }

    public static String pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
        }
        return null;
    }

    private static int pr(com.byazt.mdu.c cVar, String str) {
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(cVar.sv());
        JSONObject jSONObjectX = prVarPr.x("download_dir");
        if (jSONObjectX == null || TextUtils.isEmpty(jSONObjectX.optString("dir_name"))) {
            return -1;
        }
        String strHw = cVar.hw();
        String strV = cVar.v();
        if (TextUtils.isEmpty(strV)) {
            strV = com.byazt.mdu.hn.pr(str, strHw, cVar.k(), true);
        }
        if (strV.length() > 255) {
            strV = strV.substring(strV.length() - 255);
        }
        if (TextUtils.isEmpty(strHw)) {
            strHw = strV;
        }
        String strHn = cVar.hn();
        if (TextUtils.isEmpty(strHn)) {
            strHn = com.byazt.mdu.hn.hw();
        }
        String str2 = strHn + File.separator + com.byazt.mdu.hn.pr(strHw, prVarPr);
        DownloadInfo downloadInfoPr = com.byazt.mdu.x.w().pr(cVar.getContext(), str);
        if (downloadInfoPr != null && downloadInfoPr.isSavePathRedirected()) {
            cVar.hn(downloadInfoPr.getSavePath());
            try {
                cVar.pr(new JSONObject(downloadInfoPr.getDownloadSettingString()));
                return 0;
            } catch (Throwable th) {
                return 0;
            }
        }
        if (downloadInfoPr == null && AdBaseConstants.MIME_APK.equalsIgnoreCase(com.byazt.mdu.x.w().pr(strV, cVar.k()))) {
            int iPr = com.byazt.mdu.hw.pr(prVarPr);
            if (iPr == 0) {
                cVar.hn(str2);
                return iPr;
            }
            return iPr;
        }
        if (downloadInfoPr != null) {
            return 8;
        }
        return 9;
    }

    public static String hn(DownloadModel downloadModel) {
        try {
            if (!TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }

    public static String x(DownloadModel downloadModel) {
        try {
            if (!TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
            }
            return null;
        } catch (JSONException e) {
            return null;
        }
    }
}
