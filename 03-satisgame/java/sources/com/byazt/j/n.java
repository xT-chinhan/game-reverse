package com.byazt.j;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.f.k;
import com.byazt.q.AdBaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.ta.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 19})
public class n extends com.byazt.av.n {
    public String l;
    public String q;
    public final Context qg;
    public final Resources s;
    public String w;

    public n(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.l = str2;
        this.q = str3;
        this.w = str4;
        Context applicationContext = context.getApplicationContext();
        this.qg = applicationContext;
        this.s = applicationContext.getResources();
    }

    @Override // com.byazt.av.n
    public void n(DownloadInfo downloadInfo) {
        super.n(downloadInfo);
        this.l = downloadInfo.getSavePath();
        this.q = downloadInfo.getName();
        this.w = downloadInfo.getExtra();
    }

    @Override // com.byazt.av.n
    public void n(BaseException baseException, boolean z) {
        if (this.qg == null) {
            return;
        }
        try {
            com.byazt.z.s sVarN = com.byazt.e.q.cp().n();
            if (sVarN != null) {
                this.n = n(sVarN, baseException, z);
            }
            n(this.n);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0307  */
    /* JADX WARN: Code duplicated, block: B:66:0x0201  */
    /* JADX WARN: Code duplicated, block: B:67:0x0203  */
    /* JADX WARN: Code duplicated, block: B:69:0x0211 A[PHI: r6 r19 r20
      0x0211: PHI (r6v17 com.byazt.qx.BaseException) = 
      (r6v10 com.byazt.qx.BaseException)
      (r6v10 com.byazt.qx.BaseException)
      (r6v10 com.byazt.qx.BaseException)
      (r6v27 com.byazt.qx.BaseException)
     binds: [B:95:0x02a2, B:97:0x02a5, B:98:0x02a7, B:68:0x0204] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r19v8 com.byazt.f.n) = (r19v6 com.byazt.f.n), (r19v6 com.byazt.f.n), (r19v6 com.byazt.f.n), (r19v12 com.byazt.f.n) binds: [B:95:0x02a2, B:97:0x02a5, B:98:0x02a7, B:68:0x0204] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r20v5 java.lang.Object) = (r20v2 java.lang.Object), (r20v2 java.lang.Object), (r20v2 java.lang.Object), (r20v7 java.lang.Object) binds: [B:95:0x02a2, B:97:0x02a5, B:98:0x02a7, B:68:0x0204] A[DONT_GENERATE, DONT_INLINE]] */
    private Notification n(com.byazt.z.s sVar, BaseException baseException, boolean z) {
        com.byazt.f.n nVar;
        boolean z2;
        int i;
        n nVar2;
        BaseException baseException2;
        Object obj;
        boolean z3;
        Object obj2;
        boolean z4;
        int iL = l();
        int iN = com.byazt.e.s.n(iL);
        if (iN == 0) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("click_type", Integer.valueOf(iN));
        int iN2 = n();
        map.put("click_download_id", Integer.valueOf(iN2));
        com.byazt.f.n nVarN = com.byazt.f.n.n(iN2);
        long jQg = qg();
        long jS = s();
        int i2 = jS > 0 ? (int) ((100 * jQg) / jS) : 0;
        String strQ = q();
        int iQg = nVarN.qg("notification_opt_2");
        map.put("notification_opt_2", Integer.valueOf(iQg));
        if (iQg != 1) {
            map.put("action_click_btn", "android.ss.intent.action.DOWNLOAD_CLICK_BTN");
        }
        int iQg2 = nVarN.qg("enable_notification_ui");
        map.put("enable_notification_ui", Integer.valueOf(iQg2));
        map.put("show_title", strQ);
        map.put("percent", Integer.valueOf(i2));
        map.put("indeterminate", Boolean.valueOf(z));
        map.put("notification_type", Integer.valueOf(iN));
        String strTj = com.byazt.e.q.cp().tj();
        if (Build.VERSION.SDK_INT >= 26 && TextUtils.isEmpty(strTj)) {
            strTj = com.byazt.e.s.n(this.qg);
        }
        map.put("channel_id", strTj);
        map.put("download_status", Integer.valueOf(iL));
        map.put("first_time", Long.valueOf(w()));
        if (nVarN.n("set_notification_group", 0) == 1) {
            map.put("notification_group", "com.ss.android.socialbase.APP_DOWNLOADER");
        }
        map.put("csj_enable_target_34", Boolean.valueOf(Build.VERSION.SDK_INT >= 31 && com.byazt.f.n.n(iN2).qg("enable_target_34") > 0));
        if (iQg2 > 0) {
            map.put("bitmap", s.n().n(iN2));
        }
        if (iN == 1 || iN == 4) {
            nVar = nVarN;
            z2 = false;
            map.put(k.a.e, com.byazt.e.s.n(jQg) + "/" + com.byazt.e.s.n(jS));
            i = iN;
            if (i == 1) {
                map.put("download_status", Integer.valueOf(l()));
            }
            nVar2 = this;
            map.put("is_bind_app", Boolean.valueOf(com.byazt.e.s.n(nVar2.w)));
        } else if (iN == 2) {
            map.put(k.a.e, com.byazt.e.s.n(jQg) + "/" + com.byazt.e.s.n(jS));
            if (iQg == 1) {
                map.put("progress_70", Integer.valueOf(nVarN.n("noti_progress_show_th", 70)));
            }
            map.put("is_bind_app", Boolean.valueOf(com.byazt.e.s.n(this.w)));
            if (!com.byazt.e.s.n(this.w) && iQg2 >= 2) {
                map.put(k.a.e, com.byazt.e.s.n(jQg, false) + "/" + com.byazt.e.s.n(jS, false));
            }
            nVar = nVarN;
            z2 = false;
            nVar2 = this;
            i = iN;
        } else if (iN == 3) {
            DownloadInfo downloadInfo = Downloader.getInstance(com.byazt.xv.s.u()).getDownloadInfo(iN2);
            int iL2 = l();
            map.put("download_status", Integer.valueOf(iL2));
            if (iL2 == -1 || iL2 == -4) {
                nVar = nVarN;
                boolean zRv = w.rv(baseException);
                boolean zFs = w.fs(baseException);
                map.put("is_network_error", Boolean.valueOf(zRv));
                map.put("is_insufficient_space_error", Boolean.valueOf(zFs));
                if (iQg2 >= 2 && iL2 == -1 && (zRv || zFs)) {
                    map.put(k.a.e, com.byazt.e.s.n(jQg) + "/" + com.byazt.e.s.n(jS));
                }
                baseException2 = baseException;
                if (baseException2 != null) {
                    int errorCode = baseException.getErrorCode();
                    obj = k.a.e;
                    if (errorCode == 1006) {
                        map.put("is_error_code_insufficient_space_error", Boolean.TRUE);
                    }
                    if (iQg2 < 2 && iL2 == -1 && zRv) {
                        obj2 = "is_wait_wifi_and_in_net";
                        map.put(obj2, Boolean.valueOf(w.qg(baseException2, downloadInfo)));
                    } else {
                        obj2 = "is_wait_wifi_and_in_net";
                    }
                } else {
                    obj = k.a.e;
                }
                if (n(baseException2, nVar, downloadInfo)) {
                    map.put("is_need_show_wait_net_text", Boolean.TRUE);
                    if (downloadInfo == null || !downloadInfo.isOnlyWifi()) {
                        nVar = nVar;
                        nVar = nVar;
                        z3 = false;
                    } else {
                        nVar = nVar;
                        z3 = true;
                    }
                    map.put("is_wait_wifi", Boolean.valueOf(z3));
                } else {
                    nVar = nVar;
                }
                if (iQg2 < 2) {
                    obj2 = "is_wait_wifi_and_in_net";
                } else {
                    obj2 = "is_wait_wifi_and_in_net";
                }
            } else if (iL2 == -3) {
                map.put(k.a.e, com.byazt.e.s.n(jS));
                if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.getMimeType())) {
                    nVar = nVarN;
                } else {
                    nVar = nVarN;
                    boolean z5 = downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK);
                    map.put("is_mime_apk", Boolean.valueOf(z5));
                    map.put("is_apk_installed", Boolean.valueOf(com.byazt.e.s.n(this.qg, downloadInfo, false)));
                    if (com.byazt.xv.q.n().oa(iN2) != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    map.put("is_have_notification_click_callback", Boolean.valueOf(z4));
                    baseException2 = baseException;
                    obj = k.a.e;
                    obj2 = "is_wait_wifi_and_in_net";
                }
                map.put("is_mime_apk", Boolean.valueOf(z5));
                map.put("is_apk_installed", Boolean.valueOf(com.byazt.e.s.n(this.qg, downloadInfo, false)));
                if (com.byazt.xv.q.n().oa(iN2) != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                map.put("is_have_notification_click_callback", Boolean.valueOf(z4));
                baseException2 = baseException;
                obj = k.a.e;
                obj2 = "is_wait_wifi_and_in_net";
            } else {
                nVar = nVarN;
                obj = k.a.e;
                obj2 = "is_wait_wifi_and_in_net";
                baseException2 = baseException;
            }
            boolean zRv2 = w.rv(baseException);
            boolean zFs2 = w.fs(baseException);
            map.put("is_network_error", Boolean.valueOf(zRv2));
            map.put("is_insufficient_space_error", Boolean.valueOf(zFs2));
            if (iQg2 >= 2 && iL2 == -1 && (zRv2 || zFs2)) {
                boolean zQg = w.qg(baseException2, downloadInfo);
                map.put(obj2, Boolean.valueOf(zQg));
                if (zQg) {
                    z2 = false;
                    map.put(obj, com.byazt.e.s.n(jQg, false) + "/" + com.byazt.e.s.n(jS, false));
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            nVar2 = this;
            i = iN;
        } else {
            nVar = nVarN;
            z2 = false;
            i = iN;
            nVar2 = this;
        }
        String str = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (i == 1 || i == 4 || i == 2) {
            map.put("action_apa", "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT");
        } else if (i == 3) {
            if (iL != -1 && iL != -4) {
                if (iL == -3) {
                    map.put("auto_cancel", Boolean.valueOf(nVar.n("notification_click_install_auto_cancel", 1) == 0 ? true : z2));
                }
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            map.put("action_complete", str);
            map.put("action_hide", "android.ss.intent.action.DOWNLOAD_HIDE");
        }
        nVar2.n = (Notification) sVar.n(map).get("notification");
        return nVar2.n;
    }

    private boolean n(BaseException baseException, com.byazt.f.n nVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && nVar.n("notification_text_opt", 0) == 1;
    }
}
