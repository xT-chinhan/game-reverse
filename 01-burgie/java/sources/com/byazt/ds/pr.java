package com.byazt.ds;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.bek.DownloadController;
import com.byazt.cxa.DeepLink;
import com.byazt.eld.k;
import com.byazt.fi.BaseConstants;
import com.byazt.km.AdDownloadController;
import com.byazt.km.AdDownloadModel;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 37})
public class pr {
    public static final String pr = pr.class.getSimpleName();

    public static boolean pr(com.byazt.shh.c cVar) {
        boolean z;
        DeepLink deepLink = cVar.hw.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject jSONObjectPr = com.byazt.uk.uc.pr(new JSONObject(), cVar);
        m.pr(jSONObjectPr, "applink_source", "click_by_sdk");
        com.byazt.mf.pr.pr().hw("applink_click", jSONObjectPr, cVar);
        com.byazt.shh.fw fwVarPr = com.byazt.uk.aj.pr(openUrl, cVar);
        if (fwVarPr.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                hw("by_url", fwVarPr, jSONObjectPr, cVar);
            }
            fwVarPr = com.byazt.uk.aj.pr(k.getContext(), cVar.hw.getPackageName(), cVar);
        }
        boolean z2 = true;
        if (pr(cVar.pr) && k.aj().optInt("link_ad_click_event") == 1) {
            if (cVar.hw instanceof AdDownloadModel) {
                ((AdDownloadModel) cVar.hw).setFunnelType(4);
            }
            com.byazt.mf.pr.pr().pr(cVar.pr, 0);
            z = true;
        } else {
            z = false;
        }
        switch (fwVarPr.getType()) {
            case 1:
                hw("by_url", jSONObjectPr, cVar);
                break;
            case 2:
            default:
                com.byazt.vi.hn.pr().hw("AppLinkClick default");
                z2 = false;
                break;
            case 3:
                pr("by_package", jSONObjectPr, cVar);
                break;
            case 4:
                pr("by_package", fwVarPr, jSONObjectPr, cVar);
                z2 = false;
                break;
        }
        if (z2 && !z && ((com.byazt.mf.hn.pr().hw() && !com.byazt.mf.hn.pr().hw(cVar.pr, cVar.hw.getLogExtra())) || com.byazt.mf.hn.pr().hn())) {
            com.byazt.mf.pr.pr().pr(cVar.pr, 2);
        }
        return z2;
    }

    public static void pr(com.byazt.tia.hw hwVar) {
        String strUc = hwVar.uc();
        JSONObject jSONObjectPr = com.byazt.uk.uc.pr(new JSONObject(), hwVar);
        m.pr(jSONObjectPr, "applink_source", "notify_click_by_sdk");
        com.byazt.mf.pr.pr().hw("applink_click", jSONObjectPr, hwVar);
        com.byazt.shh.fw fwVarPr = com.byazt.uk.aj.pr(strUc, hwVar);
        if (fwVarPr.getType() == 2) {
            if (!TextUtils.isEmpty(strUc)) {
                hw("notify_by_url", fwVarPr, jSONObjectPr, hwVar);
            }
            fwVarPr = com.byazt.uk.aj.pr(k.getContext(), hwVar.c(), hwVar);
        }
        switch (fwVarPr.getType()) {
            case 1:
                hw("notify_by_url", jSONObjectPr, hwVar);
                break;
            case 2:
            default:
                com.byazt.vi.hn.pr().hw("AppLinkClickNotification default");
                break;
            case 3:
                pr("notify_by_package", jSONObjectPr, hwVar);
                break;
            case 4:
                pr("notify_by_package", fwVarPr, jSONObjectPr, hwVar);
                break;
        }
    }

    public static void hw(com.byazt.tia.hw hwVar) {
        if (hwVar == null) {
        }
        String strUc = null;
        if (com.byazt.ew.pr.hn().hw("app_link_opt") == 1) {
            strUc = hwVar.uc();
        }
        JSONObject jSONObjectPr = com.byazt.uk.uc.pr(new JSONObject(), hwVar);
        m.pr(jSONObjectPr, "applink_source", "dialog_click_by_sdk");
        com.byazt.mf.pr.pr().hw("applink_click", jSONObjectPr, hwVar);
        com.byazt.shh.fw fwVarPr = com.byazt.uk.aj.pr(strUc, hwVar);
        if (fwVarPr.getType() == 2) {
            if (!TextUtils.isEmpty(strUc)) {
                hw("dialog_by_url", fwVarPr, jSONObjectPr, hwVar);
            }
            fwVarPr = com.byazt.uk.aj.pr(k.getContext(), hwVar.c(), hwVar);
        }
        switch (fwVarPr.getType()) {
            case 1:
                hw("dialog_by_url", jSONObjectPr, hwVar);
                break;
            case 2:
            default:
                com.byazt.vi.hn.pr().hw("AppLinkClickDialog default");
                break;
            case 3:
                pr("dialog_by_package", jSONObjectPr, hwVar);
                break;
            case 4:
                pr("dialog_by_package", fwVarPr, jSONObjectPr, hwVar);
                break;
        }
    }

    public static boolean pr(String str, com.byazt.tia.hw hwVar) {
        if (!com.byazt.eld.aj.hw(hwVar.of())) {
            return false;
        }
        if (TextUtils.isEmpty(hwVar.uc()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.byazt.lxs.hw.pr().uc(hwVar.qa());
        JSONObject jSONObject = new JSONObject();
        com.byazt.uk.uc.pr(jSONObject, hwVar);
        m.pr(jSONObject, "applink_source", "auto_click");
        com.byazt.mf.pr.pr().hw("applink_click", hwVar);
        com.byazt.shh.fw fwVarPr = com.byazt.uk.aj.pr(hwVar, hwVar.uc(), hwVar.c());
        switch (fwVarPr.getType()) {
            case 1:
                hw("auto_by_url", jSONObject, hwVar);
                return true;
            case 2:
                hw("auto_by_url", fwVarPr, jSONObject, hwVar);
                return false;
            case 3:
                pr("auto_by_package", jSONObject, hwVar);
                return true;
            case 4:
                pr("auto_by_package", fwVarPr, jSONObject, hwVar);
                return false;
            default:
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x004c  */
    public static void pr(String str, final JSONObject jSONObject, final com.byazt.tia.pr prVar) {
        m.pr(jSONObject, "applink_source", str);
        m.pr(jSONObject, "download_scene", Integer.valueOf(prVar.a()));
        com.byazt.mf.pr.pr().hw("deeplink_app_open", jSONObject, prVar);
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((k.aj().optInt("check_applink_mode") & 1) != 0) {
                    m.pr(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    c.pr().pr(new x() { // from class: com.byazt.ds.pr.1
                        @Override // com.byazt.ds.x
                        public void pr(boolean z) {
                            com.byazt.mf.pr.pr().hw(z ? "deeplink_success" : "deeplink_failed", jSONObject, prVar);
                            if (z) {
                                k.cz().pr(k.getContext(), prVar.cz(), prVar.fo(), prVar.ny(), prVar.c(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    k.hw().pr(k.getContext(), prVar.cz(), prVar.fo(), prVar.ny(), prVar.c(), str);
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x004c  */
    public static void hw(String str, final JSONObject jSONObject, final com.byazt.tia.pr prVar) {
        m.pr(jSONObject, "applink_source", str);
        m.pr(jSONObject, "download_scene", Integer.valueOf(prVar.a()));
        com.byazt.mf.pr.pr().hw("deeplink_url_open", jSONObject, prVar);
        switch (str) {
            case "notify_by_url":
            case "auto_by_url":
            case "by_url":
            case "dialog_by_url":
                if ((k.aj().optInt("check_applink_mode") & 1) != 0) {
                    m.pr(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    c.pr().pr(new x() { // from class: com.byazt.ds.pr.2
                        @Override // com.byazt.ds.x
                        public void pr(boolean z) {
                            com.byazt.mf.pr.pr().hw(z ? "deeplink_success" : "deeplink_failed", jSONObject, prVar);
                            if (z) {
                                k.cz().pr(k.getContext(), prVar.cz(), prVar.fo(), prVar.ny(), prVar.c(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    k.hw().pr(k.getContext(), prVar.cz(), prVar.fo(), prVar.ny(), prVar.c(), str);
                    break;
                }
                break;
        }
    }

    public static void pr(String str, com.byazt.shh.fw fwVar, JSONObject jSONObject, com.byazt.tia.pr prVar) {
        m.pr(jSONObject, "applink_source", str);
        m.pr(jSONObject, Constants.ERROR_CODE_FIELD, Integer.valueOf(fwVar.pr()));
        m.pr(jSONObject, "download_scene", Integer.valueOf(prVar.a()));
        com.byazt.mf.pr.pr().hw("deeplink_app_open_fail", jSONObject, prVar);
    }

    public static void hw(String str, com.byazt.shh.fw fwVar, JSONObject jSONObject, com.byazt.tia.pr prVar) {
        m.pr(jSONObject, "applink_source", str);
        m.pr(jSONObject, Constants.ERROR_CODE_FIELD, Integer.valueOf(fwVar.pr()));
        m.pr(jSONObject, "download_scene", Integer.valueOf(prVar.a()));
        com.byazt.mf.pr.pr().hw("deeplink_url_open_fail", jSONObject, prVar);
    }

    public static boolean pr(com.byazt.shh.c cVar, int i) {
        JSONObject jSONObject = new JSONObject();
        m.pr(jSONObject, "download_scene", Integer.valueOf(cVar.a()));
        com.byazt.bek.hw marketStatusChangeListener = cVar.x.getMarketStatusChangeListener();
        com.byazt.mf.pr.pr().hw("market_click_open", jSONObject, cVar);
        DownloadController downloadController = cVar.x;
        Context context = k.getContext();
        if (downloadController instanceof AdDownloadController) {
            AdDownloadController adDownloadController = (AdDownloadController) downloadController;
            if (adDownloadController.getWeakActivity() != null) {
                context = adDownloadController.getWeakActivity();
            }
        }
        com.byazt.shh.fw fwVarPr = com.byazt.uk.aj.pr(context, cVar, cVar.hw.getPackageName());
        String strPr = m.pr(fwVarPr.hw(), "open_market");
        switch (fwVarPr.getType()) {
            case 5:
                pr(strPr, jSONObject, cVar, true);
                break;
            case 6:
                m.pr(jSONObject, Constants.ERROR_CODE_FIELD, Integer.valueOf(fwVarPr.pr()));
                m.pr(jSONObject, "download_scene", Integer.valueOf(cVar.a()));
                if (marketStatusChangeListener != null) {
                    marketStatusChangeListener.hw();
                }
                com.byazt.mf.pr.pr().hw("market_open_failed", jSONObject, cVar);
                return false;
            case 7:
                break;
            default:
                return false;
        }
        com.byazt.mf.pr.pr().pr(cVar.pr, i);
        return true;
    }

    public static void pr(final String str, final JSONObject jSONObject, final com.byazt.shh.c cVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.byazt.vi.hn.pr().pr(e, "onMarketSuccess");
                return;
            }
        }
        m.pr(jSONObject, "applink_source", str);
        m.pr(jSONObject, "download_scene", Integer.valueOf(cVar.a()));
        if (z) {
            com.byazt.bek.hw marketStatusChangeListener = cVar.x.getMarketStatusChangeListener();
            if (marketStatusChangeListener != null) {
                marketStatusChangeListener.pr();
            }
            com.byazt.mf.pr.pr().hw("market_open_success", jSONObject, cVar);
        }
        if ((k.aj().optInt("check_applink_mode") & 4) != 0) {
            c.pr().hw(new x() { // from class: com.byazt.ds.pr.3
                @Override // com.byazt.ds.x
                public void pr(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        pr.pr(com.byazt.uk.aj.pr(k.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + cVar.c())), cVar, false);
                    }
                    com.byazt.mf.pr.pr().pr(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, cVar);
                    if (z2) {
                        k.cz().pr(k.getContext(), cVar.hw, cVar.x, cVar.hn, cVar.hw.getPackageName(), 2);
                    }
                }
            });
        } else {
            k.hw().pr(k.getContext(), cVar.hw, cVar.x, cVar.hn, cVar.hw.getPackageName(), str);
        }
        com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(cVar.hw.getPackageName());
        if (hwVarPr != null) {
            com.byazt.uk.k.pr().pr(pr, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            com.byazt.uk.k.pr().pr(pr, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            hwVarPr = new com.byazt.tia.hw(cVar.hw, cVar.hn, cVar.x);
        }
        hwVarPr.c(2);
        hwVarPr.uc(System.currentTimeMillis());
        hwVarPr.zo(4);
        hwVarPr.aj(2);
        com.byazt.shh.uc.pr().pr(hwVarPr);
        com.byazt.uk.k.pr().pr(pr, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.byazt.cvl.aj.pr().pr(cVar, hwVarPr);
    }

    public static void pr(com.byazt.shh.fw fwVar, com.byazt.shh.c cVar, boolean z) {
        String strPr = m.pr(fwVar.hw(), "open_market");
        JSONObject jSONObject = new JSONObject();
        m.pr(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        switch (fwVar.getType()) {
            case 5:
                pr(strPr, jSONObject, cVar, z);
                break;
            case 6:
                m.pr(jSONObject, Constants.ERROR_CODE_FIELD, Integer.valueOf(fwVar.pr()));
                m.pr(jSONObject, "download_scene", Integer.valueOf(cVar.a()));
                cVar.x.getMarketStatusChangeListener();
                com.byazt.mf.pr.pr().hw("market_open_failed", jSONObject, cVar);
                break;
        }
    }

    public static boolean pr(long j) {
        return com.byazt.shh.uc.pr().x(j) == null;
    }
}
