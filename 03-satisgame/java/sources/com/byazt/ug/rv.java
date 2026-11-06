package com.byazt.ug;

import android.content.Intent;
import android.text.TextUtils;
import com.byazt.hj.DownloadModel;
import com.byazt.ky.IDownloadButtonClickListener;
import com.byazt.q.AdBaseConstants;
import com.byazt.wm.DownloadInfo;
import com.byazt.y.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static boolean n(int i) {
        return i == 0 || i == 1;
    }

    public static boolean qg(int i) {
        return i == 2 || i == 1;
    }

    public static boolean n(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean qg(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean n(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int n(com.byazt.vl.l lVar, boolean z, com.byazt.e.l lVar2) {
        int iN;
        if (lVar2 == null || TextUtils.isEmpty(lVar2.n()) || lVar2.getContext() == null) {
            return 0;
        }
        try {
            iN = n(lVar2, lVar2.n());
        } catch (Throwable th) {
            d.a().n(th, "redirectSavePathIfPossible");
            iN = 4;
        }
        lVar2.n(iN);
        if (iN == 0) {
            lVar2.n(new com.byazt.ht.n());
        }
        if (!lVar2.yw()) {
            lVar2.n(new com.byazt.ht.qg());
        }
        int iN2 = com.byazt.e.q.cp().n(lVar2);
        com.byazt.h.qg qgVarN = n(lVar, iN2);
        com.byazt.vl.w.n().n(qgVarN);
        qgVarN.x(iN2);
        qgVarN.fs(System.currentTimeMillis());
        qgVarN.rv(0L);
        com.byazt.f.n nVarN = com.byazt.f.n.n(lVar2.ci());
        if (!n(lVar2, nVarN, iN2) && lVar.qg.isShowToast()) {
            String startToast = lVar.qg.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = nVarN.s("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            d.s().n(2, lVar2.getContext(), lVar.qg, startToast, null, 0);
        }
        return iN2;
    }

    private static com.byazt.h.qg n(com.byazt.vl.l lVar, int i) {
        com.byazt.h.qg qgVar = new com.byazt.h.qg(lVar.qg, lVar.s, lVar.q, i);
        boolean z = true;
        if (com.byazt.f.n.n(i).n("download_event_opt", 1) > 1) {
            try {
                String packageName = lVar.qg.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (d.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    qgVar.fs(z);
                }
            } catch (Throwable unused) {
            }
        }
        return qgVar;
    }

    private static boolean n(com.byazt.e.l lVar, com.byazt.f.n nVar, int i) {
        String strOptString;
        JSONArray jSONArrayL = nVar.l("ah_plans");
        if (jSONArrayL != null && jSONArrayL.length() != 0) {
            int length = jSONArrayL.length();
            int i2 = 0;
            JSONObject jSONObject = null;
            while (true) {
                if (i2 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayL.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.byazt.bk.n.n(jSONObjectOptJSONObject))) {
                        strOptString.hashCode();
                        switch (strOptString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.byazt.e.qg.n(jSONObjectOptJSONObject, nVar).qg != 0) {
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
                                if (com.byazt.e.qg.qg(jSONObjectOptJSONObject, nVar).qg != 0) {
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
                    return com.byazt.e.qg.n(com.byazt.xv.s.u(), (Intent) null, jSONObject, i, new com.byazt.e.n());
                }
            }
        }
        return false;
    }

    public static String n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static int n(com.byazt.e.l lVar, String str) {
        com.byazt.f.n nVarN = com.byazt.f.n.n(lVar.ci());
        JSONObject jSONObjectQ = nVarN.q("download_dir");
        if (jSONObjectQ == null || TextUtils.isEmpty(jSONObjectQ.optString("dir_name"))) {
            return -1;
        }
        String strQg = lVar.qg();
        String strDf = lVar.df();
        if (TextUtils.isEmpty(strDf)) {
            strDf = com.byazt.e.s.n(str, strQg, lVar.d(), true);
        }
        if (strDf.length() > 255) {
            strDf = strDf.substring(strDf.length() - 255);
        }
        if (TextUtils.isEmpty(strQg)) {
            strQg = strDf;
        }
        String strS = lVar.s();
        if (TextUtils.isEmpty(strS)) {
            strS = com.byazt.e.s.qg();
        }
        String str2 = strS + File.separator + com.byazt.e.s.n(strQg, nVarN);
        DownloadInfo downloadInfoN = com.byazt.e.q.cp().n(lVar.getContext(), str);
        if (downloadInfoN != null && downloadInfoN.isSavePathRedirected()) {
            lVar.s(downloadInfoN.getSavePath());
            try {
                lVar.n(new JSONObject(downloadInfoN.getDownloadSettingString()));
            } catch (Throwable unused) {
            }
            return 0;
        }
        if (downloadInfoN != null || !AdBaseConstants.MIME_APK.equalsIgnoreCase(com.byazt.e.q.cp().n(strDf, lVar.d()))) {
            return downloadInfoN != null ? 8 : 9;
        }
        int iN = com.byazt.e.qg.n(nVarN);
        if (iN == 0) {
            lVar.s(str2);
        }
        return iN;
    }

    public static String s(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String q(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
        } catch (JSONException unused) {
            return null;
        }
    }
}
