package com.bytedance.sdk.openadsdk.core.hi.ah.xr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.ka;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ah {
    public static AdDownloadModel.Builder ms(String str, String str2, lm lmVar, JSONObject jSONObject) {
        if (lmVar == null) {
            return new AdDownloadModel.Builder();
        }
        if (TextUtils.isEmpty(str)) {
            return new AdDownloadModel.Builder();
        }
        String strYw = lmVar.yw();
        if (TextUtils.isEmpty(strYw) && lmVar.ph() != null) {
            strYw = lmVar.ph().zb();
        }
        return ms(str2, lmVar, jSONObject, str, "", strYw);
    }

    public static AdDownloadModel.Builder ms(String str, lm lmVar, JSONObject jSONObject) {
        String str2;
        String str3;
        String strD;
        if (lmVar == null) {
            return new AdDownloadModel.Builder();
        }
        ka kaVarZh = lmVar.zh();
        if (kaVarZh != null) {
            String strXr = kaVarZh.xr();
            String strAh = kaVarZh.ah();
            strD = kaVarZh.d();
            str2 = strXr;
            str3 = strAh;
        } else {
            str2 = "";
            str3 = str2;
            strD = str3;
        }
        return ms(str, lmVar, jSONObject, str2, str3, strD);
    }

    private static AdDownloadModel.Builder ms(String str, lm lmVar, JSONObject jSONObject, String str2, String str3, String str4) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("open_ad_sdk_download_extra", ms.ms().ms(str).xr(jSONObject).ms(lmVar).xr());
        } catch (Exception unused) {
        }
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(Double.valueOf(lmVar.df()).longValue()).setAppIcon(lmVar.qd() == null ? null : lmVar.qd().ms()).setIsShowNotification(ch.ub().le()).setAutoInstallWithoutNotification(!ch.ub().le()).setLogExtra(lmVar.lx()).setExtra(jSONObject2).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str5, String str6) {
                return com.bytedance.sdk.openadsdk.ub.xr.ms(str5, str6);
            }
        });
        try {
            JSONObject jSONObjectXr = com.bytedance.sdk.openadsdk.core.hi.ch.xr();
            JSONObject jSONObject3 = new JSONObject();
            int i = 0;
            int iOptInt = jSONObjectXr.optInt("notification_opt_2", 0);
            if (iOptInt == 1) {
                i = iOptInt;
            }
            int iY = nw.y(lmVar);
            if (!g.c()) {
                jSONObject3.put("cancel_pause_optimise_switch", iY);
                jSONObject3.put("cancel_pause_optimise_wifi_retain_switch", iY);
                jSONObject3.put("cancel_pause_optimise_apk_retain_switch", iY);
                jSONObject3.put("cancel_pause_optimise_download_percent_retain_switch", iY);
            }
            jSONObject3.put("show_pause_continue_toast", iY);
            if (iY == 1) {
                fileUriProvider.setIsShowToast(true);
                jSONObject3.put("download_start_toast_text", jSONObjectXr.optString("download_start_toast_text", "已开始下载，再次点击可暂停或取消该下载任务。"));
            }
            jSONObject3.put("notification_opt_2", i);
            jSONObject3.put("is_use_obm_convert", nw.xr(lmVar));
            fileUriProvider.setDownloadSettings(jSONObject3);
        } catch (JSONException unused2) {
        }
        if (!TextUtils.isEmpty(str2)) {
            fileUriProvider.setDownloadUrl(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setAppName(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setPackageName(str4);
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            fileUriProvider.setNeedIndependentProcess(true);
        }
        fileUriProvider.setFilePath(ch.ub().xr());
        DeepLink deepLink = new DeepLink();
        if (lmVar.tc() != null) {
            deepLink.setId(Long.valueOf(lmVar.df()).longValue());
            deepLink.setOpenUrl(lmVar.tc().xr());
            deepLink.setWebTitle(lmVar.eh());
            if (lmVar.tc().ka() == 2 && !lm.xr(lmVar)) {
                deepLink.setWebUrl(null);
            } else if (lmVar.tc().ka() == 1) {
                deepLink.setWebUrl(lmVar.tc().d());
            } else {
                deepLink.setWebUrl(lmVar.ir());
            }
        } else {
            deepLink.setWebUrl(lmVar.ir());
        }
        fileUriProvider.setDeepLink(deepLink);
        return fileUriProvider;
    }

    public static AdDownloadController.Builder ms(lm lmVar, boolean z) {
        int iD = nw.d(lmVar);
        int iKa = nw.ka(lmVar);
        if (lmVar != null && (!TextUtils.isEmpty(lmVar.zm()) || z)) {
            iKa = 2;
        }
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(iD).setDownloadMode(iKa).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        if (lmVar != null && lmVar.yy() != null) {
            isAddToDownloadManage.setEnableAH(lmVar.yy().ms());
            isAddToDownloadManage.setEnableAM(lmVar.yy().xr());
        }
        return isAddToDownloadManage;
    }

    public static AdDownloadEventConfig.Builder ms(String str) {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str).setClickStartLabel("click_start").setClickContinueLabel("click_continue").setClickPauseLabel("click_pause").setStorageDenyLabel("download_failed").setClickInstallLabel("click_install").setIsEnableClickEvent(true).setIsEnableV3Event(false);
    }

    public static DownloadEventConfig ms(DownloadEventConfig downloadEventConfig, JSONObject jSONObject) {
        return (downloadEventConfig == null || jSONObject == null) ? downloadEventConfig : new AdDownloadEventConfig.Builder().setClickButtonTag(downloadEventConfig.getClickButtonTag()).setClickItemTag(downloadEventConfig.getClickItemTag()).setClickStartLabel(downloadEventConfig.getClickStartLabel()).setClickContinueLabel(downloadEventConfig.getClickContinueLabel()).setClickPauseLabel(downloadEventConfig.getClickPauseLabel()).setStorageDenyLabel(downloadEventConfig.getStorageDenyLabel()).setClickInstallLabel(downloadEventConfig.getClickInstallLabel()).setIsEnableClickEvent(downloadEventConfig.isEnableClickEvent()).setIsEnableV3Event(downloadEventConfig.isEnableV3Event()).setExtraEventObject(jSONObject).build();
    }

    public static boolean ms(Uri uri, lm lmVar, Context context, String str) {
        if (ch.ub().ul() == null || lmVar == null) {
            return false;
        }
        AdDownloadModel adDownloadModelBuild = ms(str, lmVar, null).build();
        of<String, Object> ofVarMs = new of().ms("uri", uri).ms(TTDownloadField.TT_DOWNLOAD_MODEL, adDownloadModelBuild).ms(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG, ms(str).build()).ms(TTDownloadField.TT_DOWNLOAD_CONTROLLER, ms(lmVar, false).build());
        com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVar = new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah(context, lmVar);
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ka());
        if (ms(lmVar, str, ofVarMs, ahVar)) {
            return true;
        }
        xr(ofVarMs, lmVar);
        return true;
    }

    private static boolean ms(final lm lmVar, String str, final Map<String, Object> map, com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah ahVar) {
        if (!ahVar.d(false)) {
            return false;
        }
        ahVar.ms(str, new com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ms.xr
            public void ms() {
                ah.xr(map, lmVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(final Map<String, Object> map, lm lmVar) {
        com.bytedance.sdk.openadsdk.core.hi.ch.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.3
            @Override // java.lang.Runnable
            public void run() {
                if (ch.ub().ul() != null) {
                    ch.ub().ul().call(12, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Boolean.class);
                }
            }
        }, lmVar);
    }

    public static void ms(Map<String, Object> map, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (g.xr < 4400 || map == null || iDownloadButtonClickListener == null || map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER) != null) {
            return;
        }
        map.put(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER, iDownloadButtonClickListener);
    }

    public static boolean ms(Context context, String str, lm lmVar, String str2, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            f.ms(z, lmVar, str2);
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
