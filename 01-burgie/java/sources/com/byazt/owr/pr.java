package com.byazt.owr;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.tuy.uc;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 404, 37})
public class pr extends com.byazt.lxs.pr {
    public String c;
    public final Resources hn;
    public final Context hw;
    public String uc;
    public String x;

    public pr(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.c = str2;
        this.x = str3;
        this.uc = str4;
        Context applicationContext = context.getApplicationContext();
        this.hw = applicationContext;
        this.hn = applicationContext.getResources();
    }

    @Override // com.byazt.lxs.pr
    public void pr(DownloadInfo downloadInfo) {
        super.pr(downloadInfo);
        this.c = downloadInfo.getSavePath();
        this.x = downloadInfo.getName();
        this.uc = downloadInfo.getExtra();
    }

    @Override // com.byazt.lxs.pr
    public void pr(BaseException baseException, boolean z) {
        if (this.hw == null) {
            return;
        }
        try {
            com.byazt.zkm.hn hnVarPr = com.byazt.mdu.x.w().pr();
            if (hnVarPr != null) {
                this.pr = pr(hnVarPr, baseException, z);
            }
            pr(this.pr);
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0224  */
    /* JADX WARN: Code duplicated, block: B:70:0x0226  */
    private Notification pr(com.byazt.zkm.hn hnVar, BaseException baseException, boolean z) {
        int i;
        boolean z2;
        boolean z3;
        pr prVar;
        int i2;
        Object obj;
        Object obj2;
        BaseException baseException2;
        boolean z4;
        int iC = c();
        int iPr = com.byazt.mdu.hn.pr(iC);
        if (iPr == 0) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("click_type", Integer.valueOf(iPr));
        int iPr2 = pr();
        map.put("click_download_id", Integer.valueOf(iPr2));
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(iPr2);
        long jHw = hw();
        long jHn = hn();
        if (jHn > 0) {
            i = (int) ((100 * jHw) / jHn);
        } else {
            i = 0;
        }
        String strX = x();
        int iHw = prVarPr.hw("notification_opt_2");
        map.put("notification_opt_2", Integer.valueOf(iHw));
        if (iHw != 1) {
            map.put("action_click_btn", "android.ss.intent.action.DOWNLOAD_CLICK_BTN");
        }
        int iHw2 = prVarPr.hw("enable_notification_ui");
        map.put("enable_notification_ui", Integer.valueOf(iHw2));
        map.put("show_title", strX);
        map.put("percent", Integer.valueOf(i));
        map.put("indeterminate", Boolean.valueOf(z));
        map.put("notification_type", Integer.valueOf(iPr));
        String strVk = com.byazt.mdu.x.w().vk();
        if (Build.VERSION.SDK_INT >= 26 && TextUtils.isEmpty(strVk)) {
            strVk = com.byazt.mdu.hn.pr(this.hw);
        }
        map.put("channel_id", strVk);
        map.put("download_status", Integer.valueOf(iC));
        map.put("first_time", Long.valueOf(uc()));
        if (Build.VERSION.SDK_INT >= 24 && prVarPr.pr("set_notification_group", 0) == 1) {
            map.put("notification_group", "com.ss.android.socialbase.APP_DOWNLOADER");
        }
        if (Build.VERSION.SDK_INT >= 31 && com.byazt.ew.pr.pr(iPr2).hw("enable_target_34") > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        map.put("csj_enable_target_34", Boolean.valueOf(z2));
        if (iHw2 > 0) {
            map.put("bitmap", hn.pr().pr(iPr2));
        }
        if (iPr == 1 || iPr == 4) {
            z3 = false;
            map.put("download_size", com.byazt.mdu.hn.pr(jHw) + "/" + com.byazt.mdu.hn.pr(jHn));
            i2 = iPr;
            if (i2 == 1) {
                map.put("download_status", Integer.valueOf(c()));
            }
            prVar = this;
            map.put("is_bind_app", Boolean.valueOf(com.byazt.mdu.hn.pr(prVar.uc)));
        } else if (iPr == 2) {
            map.put("download_size", com.byazt.mdu.hn.pr(jHw) + "/" + com.byazt.mdu.hn.pr(jHn));
            if (iHw == 1) {
                map.put("progress_70", Integer.valueOf(prVarPr.pr("noti_progress_show_th", 70)));
            }
            map.put("is_bind_app", Boolean.valueOf(com.byazt.mdu.hn.pr(this.uc)));
            if (com.byazt.mdu.hn.pr(this.uc) || iHw2 < 2) {
                prVarPr = prVarPr;
                z3 = false;
                prVar = this;
                i2 = iPr;
            } else {
                map.put("download_size", com.byazt.mdu.hn.pr(jHw, false) + "/" + com.byazt.mdu.hn.pr(jHn, false));
                prVarPr = prVarPr;
                z3 = false;
                prVar = this;
                i2 = iPr;
            }
        } else if (iPr != 3) {
            prVarPr = prVarPr;
            z3 = false;
            prVar = this;
            i2 = iPr;
        } else {
            DownloadInfo downloadInfo = Downloader.getInstance(com.byazt.lj.hn.of()).getDownloadInfo(iPr2);
            int iC2 = c();
            map.put("download_status", Integer.valueOf(iC2));
            if (iC2 == -1 || iC2 == -4) {
                boolean zAj = uc.aj(baseException);
                boolean zZo = uc.zo(baseException);
                map.put("is_network_error", Boolean.valueOf(zAj));
                map.put("is_insufficient_space_error", Boolean.valueOf(zZo));
                if (iHw2 >= 2 && iC2 == -1 && (zAj || zZo)) {
                    map.put("download_size", com.byazt.mdu.hn.pr(jHw) + "/" + com.byazt.mdu.hn.pr(jHn));
                }
                baseException2 = baseException;
                if (baseException2 == null) {
                    obj = "download_size";
                } else {
                    obj = "download_size";
                    if (baseException.getErrorCode() == 1006) {
                        map.put("is_error_code_insufficient_space_error", Boolean.TRUE);
                    }
                    if (iHw2 >= 2 || iC2 != -1 || !zAj) {
                        obj2 = "is_wait_wifi_and_in_net";
                    } else {
                        obj2 = "is_wait_wifi_and_in_net";
                        map.put(obj2, Boolean.valueOf(uc.hw(baseException2, downloadInfo)));
                    }
                }
                if (pr(baseException2, prVarPr, downloadInfo)) {
                    prVarPr = prVarPr;
                    map.put("is_need_show_wait_net_text", Boolean.TRUE);
                    map.put("is_wait_wifi", Boolean.valueOf(downloadInfo != null && downloadInfo.isOnlyWifi()));
                } else {
                    prVarPr = prVarPr;
                }
                obj2 = iHw2 >= 2 ? "is_wait_wifi_and_in_net" : "is_wait_wifi_and_in_net";
            } else if (iC2 != -3) {
                prVarPr = prVarPr;
                baseException2 = baseException;
                obj = "download_size";
                obj2 = "is_wait_wifi_and_in_net";
            } else {
                map.put("download_size", com.byazt.mdu.hn.pr(jHn));
                if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.getMimeType())) {
                    prVarPr = prVarPr;
                } else {
                    prVarPr = prVarPr;
                    boolean z5 = downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK);
                    map.put("is_mime_apk", Boolean.valueOf(z5));
                    map.put("is_apk_installed", Boolean.valueOf(com.byazt.mdu.hn.pr(this.hw, downloadInfo, false)));
                    if (com.byazt.lj.x.pr().m(iPr2) != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    map.put("is_have_notification_click_callback", Boolean.valueOf(z4));
                    baseException2 = baseException;
                    obj = "download_size";
                    obj2 = "is_wait_wifi_and_in_net";
                }
                map.put("is_mime_apk", Boolean.valueOf(z5));
                map.put("is_apk_installed", Boolean.valueOf(com.byazt.mdu.hn.pr(this.hw, downloadInfo, false)));
                if (com.byazt.lj.x.pr().m(iPr2) != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                map.put("is_have_notification_click_callback", Boolean.valueOf(z4));
                baseException2 = baseException;
                obj = "download_size";
                obj2 = "is_wait_wifi_and_in_net";
            }
            boolean zAj2 = uc.aj(baseException);
            boolean zZo2 = uc.zo(baseException);
            map.put("is_network_error", Boolean.valueOf(zAj2));
            map.put("is_insufficient_space_error", Boolean.valueOf(zZo2));
            if (iHw2 < 2 || iC2 != -1) {
                z3 = false;
            } else if (zAj2 || zZo2) {
                boolean zHw = uc.hw(baseException2, downloadInfo);
                map.put(obj2, Boolean.valueOf(zHw));
                if (!zHw) {
                    z3 = false;
                    prVar = this;
                    i2 = iPr;
                } else {
                    z3 = false;
                    map.put(obj, com.byazt.mdu.hn.pr(jHw, false) + "/" + com.byazt.mdu.hn.pr(jHn, false));
                    prVar = this;
                    i2 = iPr;
                }
            } else {
                z3 = false;
            }
            prVar = this;
            i2 = iPr;
        }
        String str = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (i2 == 1 || i2 == 4 || i2 == 2) {
            map.put("action_apa", "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT");
        } else if (i2 == 3) {
            if (iC != -1 && iC != -4) {
                if (iC == -3) {
                    map.put("auto_cancel", Boolean.valueOf(prVarPr.pr("notification_click_install_auto_cancel", 1) == 0 ? true : z3));
                }
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            map.put("action_complete", str);
            map.put("action_hide", "android.ss.intent.action.DOWNLOAD_HIDE");
        }
        prVar.pr = (Notification) hnVar.pr(map).get("notification");
        return prVar.pr;
    }

    private boolean pr(BaseException baseException, com.byazt.ew.pr prVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && prVar.pr("notification_text_opt", 0) == 1;
    }
}
