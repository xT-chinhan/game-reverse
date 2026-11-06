package com.byazt.t;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.byazt.hj.DownloadController;
import com.byazt.ho.BaseConstants;
import com.byazt.os.DeepLink;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.y.AdDownloadController;
import com.byazt.y.AdDownloadModel;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL, 19})
public class n {
    public static final String n = "n";

    public static boolean n(com.byazt.vl.l lVar) {
        boolean z;
        DeepLink deepLink = lVar.qg.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject jSONObjectN = com.byazt.rz.w.n(new JSONObject(), lVar);
        oa.n(jSONObjectN, "applink_source", "click_by_sdk");
        com.byazt.vj.n.n().qg("applink_click", jSONObjectN, lVar);
        com.byazt.vl.x xVarN = com.byazt.rz.rv.n(openUrl, lVar);
        if (xVarN.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                qg("by_url", xVarN, jSONObjectN, lVar);
            }
            xVarN = com.byazt.rz.rv.n(d.getContext(), lVar.qg.getPackageName(), lVar);
        }
        boolean z2 = false;
        if (n(lVar.n) && d.rv().optInt("link_ad_click_event") == 1) {
            if (lVar.qg instanceof AdDownloadModel) {
                ((AdDownloadModel) lVar.qg).setFunnelType(4);
            }
            com.byazt.vj.n.n().n(lVar.n, 0);
            z = true;
        } else {
            z = false;
        }
        int type = xVarN.getType();
        if (type == 1) {
            qg("by_url", jSONObjectN, lVar);
        } else {
            if (type == 3) {
                n("by_package", jSONObjectN, lVar);
            } else if (type == 4) {
                n("by_package", xVarN, jSONObjectN, lVar);
            } else {
                com.byazt.ch.s.n().qg("AppLinkClick default");
            }
            if (z2 && !z && ((com.byazt.vj.s.n().qg() && !com.byazt.vj.s.n().qg(lVar.n, lVar.qg.getLogExtra())) || com.byazt.vj.s.n().s())) {
                com.byazt.vj.n.n().n(lVar.n, 2);
            }
            return z2;
        }
        z2 = true;
        if (z2) {
            com.byazt.vj.n.n().n(lVar.n, 2);
        }
        return z2;
    }

    public static void n(com.byazt.h.qg qgVar) {
        String strW = qgVar.w();
        JSONObject jSONObjectN = com.byazt.rz.w.n(new JSONObject(), qgVar);
        oa.n(jSONObjectN, "applink_source", "notify_click_by_sdk");
        com.byazt.vj.n.n().qg("applink_click", jSONObjectN, qgVar);
        com.byazt.vl.x xVarN = com.byazt.rz.rv.n(strW, qgVar);
        if (xVarN.getType() == 2) {
            if (!TextUtils.isEmpty(strW)) {
                qg("notify_by_url", xVarN, jSONObjectN, qgVar);
            }
            xVarN = com.byazt.rz.rv.n(d.getContext(), qgVar.l(), qgVar);
        }
        int type = xVarN.getType();
        if (type == 1) {
            qg("notify_by_url", jSONObjectN, qgVar);
            return;
        }
        if (type == 3) {
            n("notify_by_package", jSONObjectN, qgVar);
        } else if (type == 4) {
            n("notify_by_package", xVarN, jSONObjectN, qgVar);
        } else {
            com.byazt.ch.s.n().qg("AppLinkClickNotification default");
        }
    }

    public static void qg(com.byazt.h.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        String strW = com.byazt.f.n.s().qg("app_link_opt") == 1 ? qgVar.w() : null;
        JSONObject jSONObjectN = com.byazt.rz.w.n(new JSONObject(), qgVar);
        oa.n(jSONObjectN, "applink_source", "dialog_click_by_sdk");
        com.byazt.vj.n.n().qg("applink_click", jSONObjectN, qgVar);
        com.byazt.vl.x xVarN = com.byazt.rz.rv.n(strW, qgVar);
        if (xVarN.getType() == 2) {
            if (!TextUtils.isEmpty(strW)) {
                qg("dialog_by_url", xVarN, jSONObjectN, qgVar);
            }
            xVarN = com.byazt.rz.rv.n(d.getContext(), qgVar.l(), qgVar);
        }
        int type = xVarN.getType();
        if (type == 1) {
            qg("dialog_by_url", jSONObjectN, qgVar);
            return;
        }
        if (type == 3) {
            n("dialog_by_package", jSONObjectN, qgVar);
        } else if (type == 4) {
            n("dialog_by_package", xVarN, jSONObjectN, qgVar);
        } else {
            com.byazt.ch.s.n().qg("AppLinkClickDialog default");
        }
    }

    public static boolean n(String str, com.byazt.h.qg qgVar) {
        if (!com.byazt.ug.rv.qg(qgVar.u())) {
            return false;
        }
        if (TextUtils.isEmpty(qgVar.w()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.byazt.av.qg.n().w(qgVar.um());
        JSONObject jSONObject = new JSONObject();
        com.byazt.rz.w.n(jSONObject, qgVar);
        oa.n(jSONObject, "applink_source", "auto_click");
        com.byazt.vj.n.n().qg("applink_click", qgVar);
        com.byazt.vl.x xVarN = com.byazt.rz.rv.n(qgVar, qgVar.w(), qgVar.l());
        int type = xVarN.getType();
        if (type == 1) {
            qg("auto_by_url", jSONObject, qgVar);
            return true;
        }
        if (type == 2) {
            qg("auto_by_url", xVarN, jSONObject, qgVar);
            return false;
        }
        if (type == 3) {
            n("auto_by_package", jSONObject, qgVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        n("auto_by_package", xVarN, jSONObject, qgVar);
        return false;
    }

    public static void n(String str, final JSONObject jSONObject, final com.byazt.h.n nVar) {
        oa.n(jSONObject, "applink_source", str);
        oa.n(jSONObject, "download_scene", Integer.valueOf(nVar.a()));
        com.byazt.vj.n.n().qg("deeplink_app_open", jSONObject, nVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((d.rv().optInt("check_applink_mode") & 1) != 0) {
                    oa.n(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    l.n().n(new q() { // from class: com.byazt.t.n.1
                        @Override // com.byazt.t.q
                        public void n(boolean z) {
                            com.byazt.vj.n.n().qg(z ? "deeplink_success" : "deeplink_failed", jSONObject, nVar);
                            if (z) {
                                d.py().n(d.getContext(), nVar.py(), nVar.wm(), nVar.ou(), nVar.l(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    d.qg().n(d.getContext(), nVar.py(), nVar.wm(), nVar.ou(), nVar.l(), str);
                    break;
                }
                break;
        }
    }

    public static void qg(String str, final JSONObject jSONObject, final com.byazt.h.n nVar) {
        oa.n(jSONObject, "applink_source", str);
        oa.n(jSONObject, "download_scene", Integer.valueOf(nVar.a()));
        com.byazt.vj.n.n().qg("deeplink_url_open", jSONObject, nVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((d.rv().optInt("check_applink_mode") & 1) != 0) {
                    oa.n(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    l.n().n(new q() { // from class: com.byazt.t.n.2
                        @Override // com.byazt.t.q
                        public void n(boolean z) {
                            com.byazt.vj.n.n().qg(z ? "deeplink_success" : "deeplink_failed", jSONObject, nVar);
                            if (z) {
                                d.py().n(d.getContext(), nVar.py(), nVar.wm(), nVar.ou(), nVar.l(), 0);
                            }
                        }
                    });
                    break;
                } else {
                    d.qg().n(d.getContext(), nVar.py(), nVar.wm(), nVar.ou(), nVar.l(), str);
                    break;
                }
                break;
        }
    }

    public static void n(String str, com.byazt.vl.x xVar, JSONObject jSONObject, com.byazt.h.n nVar) {
        oa.n(jSONObject, "applink_source", str);
        oa.n(jSONObject, "error_code", Integer.valueOf(xVar.n()));
        oa.n(jSONObject, "download_scene", Integer.valueOf(nVar.a()));
        com.byazt.vj.n.n().qg("deeplink_app_open_fail", jSONObject, nVar);
    }

    public static void qg(String str, com.byazt.vl.x xVar, JSONObject jSONObject, com.byazt.h.n nVar) {
        oa.n(jSONObject, "applink_source", str);
        oa.n(jSONObject, "error_code", Integer.valueOf(xVar.n()));
        oa.n(jSONObject, "download_scene", Integer.valueOf(nVar.a()));
        com.byazt.vj.n.n().qg("deeplink_url_open_fail", jSONObject, nVar);
    }

    public static boolean n(com.byazt.vl.l lVar, int i) {
        JSONObject jSONObject = new JSONObject();
        oa.n(jSONObject, "download_scene", Integer.valueOf(lVar.a()));
        com.byazt.hj.qg marketStatusChangeListener = lVar.q.getMarketStatusChangeListener();
        com.byazt.vj.n.n().qg("market_click_open", jSONObject, lVar);
        DownloadController downloadController = lVar.q;
        Context context = d.getContext();
        if (downloadController instanceof AdDownloadController) {
            AdDownloadController adDownloadController = (AdDownloadController) downloadController;
            if (adDownloadController.getWeakActivity() != null) {
                context = adDownloadController.getWeakActivity();
            }
        }
        com.byazt.vl.x xVarN = com.byazt.rz.rv.n(context, lVar, lVar.qg.getPackageName());
        String strN = oa.n(xVarN.qg(), "open_market");
        int type = xVarN.getType();
        if (type == 5) {
            n(strN, jSONObject, lVar, true);
        } else {
            if (type == 6) {
                oa.n(jSONObject, "error_code", Integer.valueOf(xVarN.n()));
                oa.n(jSONObject, "download_scene", Integer.valueOf(lVar.a()));
                if (marketStatusChangeListener != null) {
                    marketStatusChangeListener.qg();
                }
                com.byazt.vj.n.n().qg("market_open_failed", jSONObject, lVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.byazt.vj.n.n().n(lVar.n, i);
        return true;
    }

    public static void n(final String str, final JSONObject jSONObject, final com.byazt.vl.l lVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.byazt.ch.s.n().n(e, "onMarketSuccess");
                return;
            }
        }
        oa.n(jSONObject, "applink_source", str);
        oa.n(jSONObject, "download_scene", Integer.valueOf(lVar.a()));
        if (z) {
            com.byazt.hj.qg marketStatusChangeListener = lVar.q.getMarketStatusChangeListener();
            if (marketStatusChangeListener != null) {
                marketStatusChangeListener.n();
            }
            com.byazt.vj.n.n().qg("market_open_success", jSONObject, lVar);
        }
        if ((d.rv().optInt("check_applink_mode") & 4) != 0) {
            l.n().qg(new q() { // from class: com.byazt.t.n.3
                @Override // com.byazt.t.q
                public void n(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        n.n(com.byazt.rz.rv.n(d.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + lVar.l())), lVar, false);
                    }
                    com.byazt.vj.n.n().n(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, lVar);
                    if (z2) {
                        d.py().n(d.getContext(), lVar.qg, lVar.q, lVar.s, lVar.qg.getPackageName(), 2);
                    }
                }
            });
        } else {
            d.qg().n(d.getContext(), lVar.qg, lVar.q, lVar.s, lVar.qg.getPackageName(), str);
        }
        com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(lVar.qg.getPackageName());
        if (qgVarN != null) {
            com.byazt.rz.d.n().n(n, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            com.byazt.rz.d.n().n(n, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            qgVarN = new com.byazt.h.qg(lVar.qg, lVar.s, lVar.q);
        }
        qgVarN.l(2);
        qgVarN.w(System.currentTimeMillis());
        qgVarN.fs(4);
        qgVarN.rv(2);
        com.byazt.vl.w.n().n(qgVarN);
        com.byazt.rz.d.n().n(n, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.byazt.s.rv.n().n(lVar, qgVarN);
    }

    public static void n(com.byazt.vl.x xVar, com.byazt.vl.l lVar, boolean z) {
        String strN = oa.n(xVar.qg(), "open_market");
        JSONObject jSONObject = new JSONObject();
        oa.n(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = xVar.getType();
        if (type == 5) {
            n(strN, jSONObject, lVar, z);
        } else {
            if (type != 6) {
                return;
            }
            oa.n(jSONObject, "error_code", Integer.valueOf(xVar.n()));
            oa.n(jSONObject, "download_scene", Integer.valueOf(lVar.a()));
            lVar.q.getMarketStatusChangeListener();
            com.byazt.vj.n.n().qg("market_open_failed", jSONObject, lVar);
        }
    }

    public static boolean n(long j) {
        return com.byazt.vl.w.n().q(j) == null;
    }
}
