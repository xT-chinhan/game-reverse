package com.ss.android.downloadlib.xr;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.ab.sl;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4538ms = "ms";

    public static boolean ms(com.ss.android.downloadlib.addownload.xr.ka kaVar) {
        boolean z;
        DeepLink deepLink = kaVar.xr.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject jSONObjectMs = com.ss.android.downloadlib.ab.c.ms(new JSONObject(), kaVar);
        zb.ms(jSONObjectMs, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.d.ms.ms().xr("applink_click", jSONObjectMs, kaVar);
        com.ss.android.downloadlib.addownload.xr.ab abVarMs = com.ss.android.downloadlib.ab.ny.ms(openUrl, kaVar);
        if (abVarMs.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                xr("by_url", abVarMs, jSONObjectMs, kaVar);
            }
            abVarMs = com.ss.android.downloadlib.ab.ny.ms(hi.getContext(), kaVar.xr.getPackageName(), kaVar);
        }
        boolean z2 = false;
        if (ms(kaVar.f4454ms) && hi.ny().optInt("link_ad_click_event") == 1) {
            if (kaVar.xr instanceof AdDownloadModel) {
                ((AdDownloadModel) kaVar.xr).setFunnelType(4);
            }
            com.ss.android.downloadlib.d.ms.ms().ms(kaVar.f4454ms, 0);
            z = true;
        } else {
            z = false;
        }
        int type = abVarMs.getType();
        if (type == 1) {
            xr("by_url", jSONObjectMs, kaVar);
        } else {
            if (type == 3) {
                ms("by_package", jSONObjectMs, kaVar);
            } else if (type == 4) {
                ms("by_package", abVarMs, jSONObjectMs, kaVar);
            } else {
                com.ss.android.downloadlib.ka.ah.ms().xr("AppLinkClick default");
            }
            if (z2 && !z && ((com.ss.android.downloadlib.d.ah.ms().xr() && !com.ss.android.downloadlib.d.ah.ms().xr(kaVar.f4454ms, kaVar.xr.getLogExtra())) || com.ss.android.downloadlib.d.ah.ms().ah())) {
                com.ss.android.downloadlib.d.ms.ms().ms(kaVar.f4454ms, 2);
            }
            return z2;
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.d.ms.ms().ms(kaVar.f4454ms, 2);
        }
        return z2;
    }

    public static void ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        String strC = xrVar.c();
        JSONObject jSONObjectMs = com.ss.android.downloadlib.ab.c.ms(new JSONObject(), xrVar);
        zb.ms(jSONObjectMs, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.d.ms.ms().xr("applink_click", jSONObjectMs, xrVar);
        com.ss.android.downloadlib.addownload.xr.ab abVarMs = com.ss.android.downloadlib.ab.ny.ms(strC, xrVar);
        if (abVarMs.getType() == 2) {
            if (!TextUtils.isEmpty(strC)) {
                xr("notify_by_url", abVarMs, jSONObjectMs, xrVar);
            }
            abVarMs = com.ss.android.downloadlib.ab.ny.ms(hi.getContext(), xrVar.ka(), xrVar);
        }
        int type = abVarMs.getType();
        if (type == 1) {
            xr("notify_by_url", jSONObjectMs, xrVar);
            return;
        }
        if (type == 3) {
            ms("notify_by_package", jSONObjectMs, xrVar);
        } else if (type == 4) {
            ms("notify_by_package", abVarMs, jSONObjectMs, xrVar);
        } else {
            com.ss.android.downloadlib.ka.ah.ms().xr("AppLinkClickNotification default");
        }
    }

    public static void xr(com.ss.android.downloadad.api.ms.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        String strC = com.ss.android.socialbase.downloader.ab.ms.ah().xr("app_link_opt") == 1 ? xrVar.c() : null;
        JSONObject jSONObjectMs = com.ss.android.downloadlib.ab.c.ms(new JSONObject(), xrVar);
        zb.ms(jSONObjectMs, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.d.ms.ms().xr("applink_click", jSONObjectMs, xrVar);
        com.ss.android.downloadlib.addownload.xr.ab abVarMs = com.ss.android.downloadlib.ab.ny.ms(strC, xrVar);
        if (abVarMs.getType() == 2) {
            if (!TextUtils.isEmpty(strC)) {
                xr("dialog_by_url", abVarMs, jSONObjectMs, xrVar);
            }
            abVarMs = com.ss.android.downloadlib.ab.ny.ms(hi.getContext(), xrVar.ka(), xrVar);
        }
        int type = abVarMs.getType();
        if (type == 1) {
            xr("dialog_by_url", jSONObjectMs, xrVar);
            return;
        }
        if (type == 3) {
            ms("dialog_by_package", jSONObjectMs, xrVar);
        } else if (type == 4) {
            ms("dialog_by_package", abVarMs, jSONObjectMs, xrVar);
        } else {
            com.ss.android.downloadlib.ka.ah.ms().xr("AppLinkClickDialog default");
        }
    }

    public static boolean ms(String str, com.ss.android.downloadad.api.ms.xr xrVar) {
        if (!com.ss.android.downloadlib.addownload.ny.xr(xrVar.k())) {
            return false;
        }
        if (TextUtils.isEmpty(xrVar.c()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.xr.ms().c(xrVar.y());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.ab.c.ms(jSONObject, xrVar);
        zb.ms(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.d.ms.ms().xr("applink_click", xrVar);
        com.ss.android.downloadlib.addownload.xr.ab abVarMs = com.ss.android.downloadlib.ab.ny.ms(xrVar, xrVar.c(), xrVar.ka());
        int type = abVarMs.getType();
        if (type == 1) {
            xr("auto_by_url", jSONObject, xrVar);
            return true;
        }
        if (type == 2) {
            xr("auto_by_url", abVarMs, jSONObject, xrVar);
            return false;
        }
        if (type == 3) {
            ms("auto_by_package", jSONObject, xrVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        ms("auto_by_package", abVarMs, jSONObject, xrVar);
        return false;
    }

    public static void ms(String str, final JSONObject jSONObject, final com.ss.android.downloadad.api.ms.ms msVar) {
        zb.ms(jSONObject, "applink_source", str);
        zb.ms(jSONObject, "download_scene", Integer.valueOf(msVar.t()));
        com.ss.android.downloadlib.d.ms.ms().xr("deeplink_app_open", jSONObject, msVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((hi.ny().optInt("check_applink_mode") & 1) != 0) {
                    zb.ms(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    ka.ms().ms(new d() { // from class: com.ss.android.downloadlib.xr.ms.1
                        @Override // com.ss.android.downloadlib.xr.d
                        public void ms(boolean z) {
                            com.ss.android.downloadlib.d.ms.ms().xr(z ? "deeplink_success" : "deeplink_failed", jSONObject, msVar);
                            if (z) {
                                hi.nw();
                                hi.getContext();
                                msVar.nw();
                                msVar.re();
                                msVar.b();
                                msVar.ka();
                            }
                        }
                    });
                    break;
                } else {
                    hi.xr();
                    hi.getContext();
                    msVar.nw();
                    msVar.re();
                    msVar.b();
                    msVar.ka();
                    break;
                }
                break;
        }
    }

    public static void xr(String str, final JSONObject jSONObject, final com.ss.android.downloadad.api.ms.ms msVar) {
        zb.ms(jSONObject, "applink_source", str);
        zb.ms(jSONObject, "download_scene", Integer.valueOf(msVar.t()));
        com.ss.android.downloadlib.d.ms.ms().xr("deeplink_url_open", jSONObject, msVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((hi.ny().optInt("check_applink_mode") & 1) != 0) {
                    zb.ms(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    ka.ms().ms(new d() { // from class: com.ss.android.downloadlib.xr.ms.2
                        @Override // com.ss.android.downloadlib.xr.d
                        public void ms(boolean z) {
                            com.ss.android.downloadlib.d.ms.ms().xr(z ? "deeplink_success" : "deeplink_failed", jSONObject, msVar);
                            if (z) {
                                hi.nw();
                                hi.getContext();
                                msVar.nw();
                                msVar.re();
                                msVar.b();
                                msVar.ka();
                            }
                        }
                    });
                    break;
                } else {
                    hi.xr();
                    hi.getContext();
                    msVar.nw();
                    msVar.re();
                    msVar.b();
                    msVar.ka();
                    break;
                }
                break;
        }
    }

    public static void ms(String str, com.ss.android.downloadlib.addownload.xr.ab abVar, JSONObject jSONObject, com.ss.android.downloadad.api.ms.ms msVar) {
        zb.ms(jSONObject, "applink_source", str);
        zb.ms(jSONObject, "error_code", Integer.valueOf(abVar.ms()));
        zb.ms(jSONObject, "download_scene", Integer.valueOf(msVar.t()));
        com.ss.android.downloadlib.d.ms.ms().xr("deeplink_app_open_fail", jSONObject, msVar);
    }

    public static void xr(String str, com.ss.android.downloadlib.addownload.xr.ab abVar, JSONObject jSONObject, com.ss.android.downloadad.api.ms.ms msVar) {
        zb.ms(jSONObject, "applink_source", str);
        zb.ms(jSONObject, "error_code", Integer.valueOf(abVar.ms()));
        zb.ms(jSONObject, "download_scene", Integer.valueOf(msVar.t()));
        com.ss.android.downloadlib.d.ms.ms().xr("deeplink_url_open_fail", jSONObject, msVar);
    }

    public static boolean ms(com.ss.android.downloadlib.addownload.xr.ka kaVar, int i) {
        JSONObject jSONObject = new JSONObject();
        zb.ms(jSONObject, "download_scene", Integer.valueOf(kaVar.t()));
        com.ss.android.downloadlib.d.ms.ms().xr("market_click_open", jSONObject, kaVar);
        com.ss.android.downloadlib.addownload.xr.ab abVarMs = com.ss.android.downloadlib.ab.ny.ms(hi.getContext(), kaVar, kaVar.xr.getPackageName());
        String strMs = zb.ms(abVarMs.xr(), "open_market");
        int type = abVarMs.getType();
        if (type == 5) {
            ms(strMs, jSONObject, kaVar, true);
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
        com.ss.android.downloadlib.d.ms.ms().ms(kaVar.f4454ms, i);
        return true;
    }

    public static void ms(final String str, final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.xr.ka kaVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.ss.android.downloadlib.ka.ah.ms().ms(e, "onMarketSuccess");
                return;
            }
        }
        zb.ms(jSONObject, "applink_source", str);
        zb.ms(jSONObject, "download_scene", Integer.valueOf(kaVar.t()));
        if (z) {
            com.ss.android.downloadlib.d.ms.ms().xr("market_open_success", jSONObject, kaVar);
        }
        if ((hi.ny().optInt("check_applink_mode") & 4) != 0) {
            ka.ms().xr(new d() { // from class: com.ss.android.downloadlib.xr.ms.3
                @Override // com.ss.android.downloadlib.xr.d
                public void ms(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        ms.ms(com.ss.android.downloadlib.ab.ny.ms(hi.getContext(), Uri.parse("market://details?id=" + kaVar.ka())), kaVar, false);
                    }
                    com.ss.android.downloadlib.d.ms.ms().ms(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, kaVar);
                    if (z2) {
                        hi.nw();
                        hi.getContext();
                        kaVar.xr.getPackageName();
                    }
                }
            });
        } else {
            hi.xr();
            hi.getContext();
            kaVar.xr.getPackageName();
        }
        com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(kaVar.xr.getPackageName());
        if (xrVarMs != null) {
            sl.ms().ms(f4538ms, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            sl.ms().ms(f4538ms, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            xrVarMs = new com.ss.android.downloadad.api.ms.xr(kaVar.xr, kaVar.ah, kaVar.d);
        }
        xrVarMs.ka(2);
        xrVarMs.c(System.currentTimeMillis());
        xrVarMs.x(4);
        xrVarMs.ny(2);
        com.ss.android.downloadlib.addownload.xr.c.ms().ms(xrVarMs);
        sl.ms().ms(f4538ms, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.ss.android.downloadlib.ny.ms().ms(kaVar, xrVarMs);
    }

    public static void ms(com.ss.android.downloadlib.addownload.xr.ab abVar, com.ss.android.downloadlib.addownload.xr.ka kaVar, boolean z) {
        String strMs = zb.ms(abVar.xr(), "open_market");
        JSONObject jSONObject = new JSONObject();
        zb.ms(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = abVar.getType();
        if (type == 5) {
            ms(strMs, jSONObject, kaVar, z);
        } else {
            if (type != 6) {
                return;
            }
            zb.ms(jSONObject, "error_code", Integer.valueOf(abVar.ms()));
            zb.ms(jSONObject, "download_scene", Integer.valueOf(kaVar.t()));
            com.ss.android.downloadlib.d.ms.ms().xr("market_open_failed", jSONObject, kaVar);
        }
    }

    public static boolean ms(long j) {
        return com.ss.android.downloadlib.addownload.xr.c.ms().d(j) == null;
    }
}
