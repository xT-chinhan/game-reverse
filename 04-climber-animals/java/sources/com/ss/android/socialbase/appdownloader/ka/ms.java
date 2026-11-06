package com.ss.android.socialbase.appdownloader.ka;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.ka;
import com.ss.android.socialbase.appdownloader.ny;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ny.c;

/* JADX INFO: loaded from: classes3.dex */
public class ms extends com.ss.android.socialbase.downloader.notification.ms {
    private final Resources ah;
    private String c;
    private String d;
    private String ka;
    private final Context xr;

    public ms(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.ka = str2;
        this.d = str3;
        this.c = str4;
        Context applicationContext = context.getApplicationContext();
        this.xr = applicationContext;
        this.ah = applicationContext.getResources();
    }

    @Override // com.ss.android.socialbase.downloader.notification.ms
    public void ms(DownloadInfo downloadInfo) {
        super.ms(downloadInfo);
        this.ka = downloadInfo.getSavePath();
        this.d = downloadInfo.getName();
        this.c = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.ms
    public void ms(BaseException baseException, boolean z) {
        if (this.xr == null) {
            return;
        }
        try {
            this.f4742ms = xr(baseException, z);
            ms(this.f4742ms);
        } catch (Exception e) {
            ab.ms(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:157:0x0444  */
    /* JADX WARN: Code duplicated, block: B:77:0x020f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0219  */
    /* JADX WARN: Code duplicated, block: B:80:0x0238 A[PHI: r3 r4 r10 r14 r22
      0x0238: PHI (r3v30 java.lang.String) = (r3v25 java.lang.String), (r3v35 java.lang.String) binds: [B:170:0x04c4, B:76:0x020d] A[DONT_GENERATE, DONT_INLINE]
      0x0238: PHI (r4v79 int) = (r4v71 int), (r4v83 int) binds: [B:170:0x04c4, B:76:0x020d] A[DONT_GENERATE, DONT_INLINE]
      0x0238: PHI (r10v25 java.lang.String) = (r10v20 java.lang.String), (r10v27 java.lang.String) binds: [B:170:0x04c4, B:76:0x020d] A[DONT_GENERATE, DONT_INLINE]
      0x0238: PHI (r14v39 java.lang.String) = (r14v19 java.lang.String), (r14v45 java.lang.String) binds: [B:170:0x04c4, B:76:0x020d] A[DONT_GENERATE, DONT_INLINE]
      0x0238: PHI (r22v10 androidx.core.app.NotificationCompat$Builder) = (r22v8 androidx.core.app.NotificationCompat$Builder), (r22v0 androidx.core.app.NotificationCompat$Builder) binds: [B:170:0x04c4, B:76:0x020d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v34, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v43 */
    private Notification xr(BaseException baseException, boolean z) {
        boolean z2;
        int iXr;
        String string;
        String string2;
        String str;
        BaseException baseException2;
        String str2;
        String string3;
        int iXr2;
        String str3;
        int iHi;
        int iXr3;
        int iXr4;
        boolean z3;
        int i;
        ?? r13;
        boolean z4;
        int iKa = ka();
        int iMs = com.ss.android.socialbase.appdownloader.ah.ms(iKa);
        if (iMs == 0) {
            return null;
        }
        NotificationCompat.Builder builderCh = ch();
        builderCh.setWhen(c());
        int iMs2 = ms();
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(iMs2);
        if (msVarMs.ms("set_notification_group", 0) == 1) {
            builderCh.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            builderCh.setGroupSummary(false);
        }
        int iRe = ka.re();
        if (iRe != 0) {
            builderCh.setSmallIcon(iRe);
            z2 = false;
        } else {
            z2 = true;
        }
        builderCh.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        int iMs3 = ms(iMs, iMs2);
        if (z2 && iMs3 != 0) {
            builderCh.setSmallIcon(iMs3);
        }
        String str4 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (iMs == 1 || iMs == 4 || iMs == 2) {
            builderCh.setContentIntent(ms("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", iMs, iMs2));
            builderCh.setAutoCancel(false);
        } else if (iMs == 3) {
            builderCh.setAutoCancel(true);
            if (iKa != -1 && iKa != -4) {
                if (iKa == -3 && msVarMs.ms("notification_click_install_auto_cancel", 1) == 0) {
                    builderCh.setAutoCancel(false);
                }
                str4 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            builderCh.setContentIntent(ms(str4, iMs, iMs2));
            builderCh.setDeleteIntent(ms("android.ss.intent.action.DOWNLOAD_HIDE", iMs, iMs2));
        }
        long jXr = xr();
        long jAh = ah();
        int i2 = jAh > 0 ? (int) ((100 * jXr) / jAh) : 0;
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            strD = this.ah.getString(ny.xr("tt_appdownloader_download_unknown_title"));
        }
        RemoteViews remoteViewsNy = ny();
        int iHi2 = ka.hi();
        NotificationCompat.Builder builder = builderCh;
        if (com.ss.android.socialbase.downloader.ab.ms.ms(iMs2).xr("notification_opt_2") != 1) {
            remoteViewsNy.setOnClickPendingIntent(iHi2, ms("android.ss.intent.action.DOWNLOAD_CLICK_BTN", iMs, iMs2));
        }
        if (com.ss.android.socialbase.downloader.ab.ms.ms(iMs2).xr("enable_notification_ui") > 0) {
            remoteViewsNy.setInt(iHi2, "setBackgroundResource", ka.y());
            remoteViewsNy.setTextColor(iHi2, -1);
        }
        remoteViewsNy.setTextViewText(ka.zb(), strD);
        int iMs4 = ms(iMs2);
        remoteViewsNy.setViewVisibility(iMs4, 0);
        remoteViewsNy.setProgressBar(iMs4, 100, i2, z);
        int iSl = ka.sl();
        if (iMs3 != 0) {
            remoteViewsNy.setImageViewResource(iSl, iMs3);
        }
        if (com.ss.android.socialbase.downloader.ab.ms.ms(iMs2).xr("enable_notification_ui") > 0) {
            Bitmap bitmapMs = ah.ms().ms(iMs2);
            if (bitmapMs != null) {
                remoteViewsNy.setInt(iSl, "setBackgroundColor", 0);
                remoteViewsNy.setImageViewBitmap(iSl, bitmapMs);
            } else {
                remoteViewsNy.setInt(iSl, "setBackgroundResource", ka.y());
            }
        }
        if (iMs == 1 || iMs == 4) {
            String str5 = com.ss.android.socialbase.appdownloader.ah.ms(jXr) + "/" + com.ss.android.socialbase.appdownloader.ah.ms(jAh);
            if (iMs == 1) {
                if (ka() == 11) {
                    iXr = ny.xr("tt_appdownloader_notification_waiting_download_complete_handler");
                } else {
                    iXr = ny.xr("tt_appdownloader_notification_downloading");
                }
            } else {
                iXr = ny.xr("tt_appdownloader_notification_prepare");
            }
            string = this.xr.getResources().getString(iXr);
            string2 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_download_pause"));
            remoteViewsNy.setViewVisibility(ms(iMs2), 0);
            remoteViewsNy.setViewVisibility(ka.ny(), 8);
            remoteViewsNy.setViewVisibility(ka.ch(), 0);
            int iHi3 = ka.hi();
            if (com.ss.android.socialbase.appdownloader.ah.ms(this.c)) {
                remoteViewsNy.setViewVisibility(iHi3, 8);
            } else {
                remoteViewsNy.setViewVisibility(iHi3, 0);
            }
            if (msVarMs.xr("enable_notification_ui") >= 2) {
                remoteViewsNy.setViewVisibility(iHi3, 8);
            }
            str = str5;
        } else if (iMs == 2) {
            str = com.ss.android.socialbase.appdownloader.ah.ms(jXr) + "/" + com.ss.android.socialbase.appdownloader.ah.ms(jAh);
            string = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_pausing"));
            string2 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_download_resume"));
            if (msVarMs.xr("notification_opt_2") == 1) {
                if (i2 >= msVarMs.ms("noti_progress_show_th", 70)) {
                    z4 = false;
                    remoteViewsNy.setViewVisibility(ms(iMs2), 0);
                    remoteViewsNy.setViewVisibility(ka.ch(), 0);
                } else {
                    r13 = 0;
                    remoteViewsNy.setViewVisibility(ms(iMs2), 8);
                    remoteViewsNy.setViewVisibility(ka.ch(), 8);
                    remoteViewsNy.setViewVisibility(ka.ny(), 0);
                    remoteViewsNy.setViewVisibility(ka.ub(), 8);
                    string = this.ah.getString(ny.xr("tt_appdownloader_notification_download_continue"));
                }
                iHi = ka.hi();
                if (!com.ss.android.socialbase.appdownloader.ah.ms(this.c)) {
                    remoteViewsNy.setViewVisibility(iHi, r13);
                    if (msVarMs.xr("enable_notification_ui") >= 2) {
                        str = com.ss.android.socialbase.appdownloader.ah.ms(jXr, (boolean) r13) + "/" + com.ss.android.socialbase.appdownloader.ah.ms(jAh, (boolean) r13);
                    }
                } else {
                    remoteViewsNy.setViewVisibility(iHi, 8);
                }
            } else {
                z3 = false;
                z4 = false;
                remoteViewsNy.setViewVisibility(ka.ch(), 0);
                int iMs5 = ms(iMs2);
                if (msVarMs.xr("enable_notification_ui") >= 2) {
                    remoteViewsNy.setViewVisibility(iMs5, 0);
                } else {
                    i = 8;
                    remoteViewsNy.setViewVisibility(iMs5, 8);
                }
                remoteViewsNy.setViewVisibility(ka.ny(), i);
                r13 = z3;
                iHi = ka.hi();
                if (!com.ss.android.socialbase.appdownloader.ah.ms(this.c)) {
                    remoteViewsNy.setViewVisibility(iHi, r13);
                    if (msVarMs.xr("enable_notification_ui") >= 2) {
                        str = com.ss.android.socialbase.appdownloader.ah.ms(jXr, (boolean) r13) + "/" + com.ss.android.socialbase.appdownloader.ah.ms(jAh, (boolean) r13);
                    }
                } else {
                    remoteViewsNy.setViewVisibility(iHi, 8);
                }
            }
            i = 8;
            z3 = z4;
            remoteViewsNy.setViewVisibility(ka.ny(), i);
            r13 = z3;
            iHi = ka.hi();
            if (!com.ss.android.socialbase.appdownloader.ah.ms(this.c)) {
                remoteViewsNy.setViewVisibility(iHi, r13);
                if (msVarMs.xr("enable_notification_ui") >= 2) {
                    str = com.ss.android.socialbase.appdownloader.ah.ms(jXr, (boolean) r13) + "/" + com.ss.android.socialbase.appdownloader.ah.ms(jAh, (boolean) r13);
                }
            } else {
                remoteViewsNy.setViewVisibility(iHi, 8);
            }
        } else {
            String string4 = "";
            if (iMs == 3) {
                DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getDownloadInfo(iMs2);
                if (ka() == -1 || ka() == -4) {
                    builder = builder;
                    String str6 = (msVarMs.xr("enable_notification_ui") >= 2 && ka() == -1 && (c.ny(baseException) || c.x(baseException))) ? com.ss.android.socialbase.appdownloader.ah.ms(jXr) + "/" + com.ss.android.socialbase.appdownloader.ah.ms(jAh) : "";
                    remoteViewsNy.setViewVisibility(ka.ub(), 8);
                    baseException2 = baseException;
                    if (baseException2 != null) {
                        str2 = str6;
                        if (baseException.getErrorCode() == 1006) {
                            string3 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_download_space_failed"));
                        }
                        str3 = string3;
                        String string5 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_download_restart"));
                        remoteViewsNy.setViewVisibility(ka.hi(), 8);
                        if (msVarMs.xr("enable_notification_ui") >= 2 || ka() != -1) {
                            string4 = str3;
                        } else if (c.ny(baseException)) {
                            if (c.xr(baseException2, downloadInfo)) {
                                string4 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_no_wifi_and_in_net"));
                                string2 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_download_resume"));
                                builder = builder;
                            } else {
                                string4 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_no_internet_error"));
                                builder = builder;
                                string2 = string5;
                            }
                        } else if (c.x(baseException)) {
                            string4 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_insufficient_space_error"), com.ss.android.socialbase.appdownloader.ah.xr(jAh - jXr));
                        } else {
                            string4 = str3;
                        }
                        string2 = string5;
                    } else {
                        str2 = str6;
                    }
                    if (ms(baseException2, msVarMs, downloadInfo)) {
                        if (downloadInfo != null && downloadInfo.isOnlyWifi()) {
                            iXr2 = ny.xr("tt_appdownloader_notification_download_waiting_wifi");
                        } else {
                            iXr2 = ny.xr("tt_appdownloader_notification_download_waiting_net");
                        }
                        string3 = this.xr.getResources().getString(iXr2);
                    } else {
                        string3 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_download_failed"));
                    }
                    str3 = string3;
                    String string6 = this.xr.getResources().getString(ny.xr("tt_appdownloader_notification_download_restart"));
                    remoteViewsNy.setViewVisibility(ka.hi(), 8);
                    if (msVarMs.xr("enable_notification_ui") >= 2) {
                        string4 = str3;
                    } else {
                        string4 = str3;
                    }
                    string2 = string6;
                } else if (ka() == -3) {
                    String strMs = com.ss.android.socialbase.appdownloader.ah.ms(jAh);
                    if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                        if (com.ss.android.socialbase.appdownloader.ah.ms(this.xr, downloadInfo, false)) {
                            iXr3 = ny.xr("tt_appdownloader_notification_install_finished_open");
                            iXr4 = ny.xr("tt_appdownloader_notification_download_open");
                        } else {
                            iXr3 = ny.xr("tt_appdownloader_notification_download_complete_with_install");
                            iXr4 = ny.xr("tt_appdownloader_notification_download_install");
                        }
                    } else {
                        iXr3 = ny.xr("tt_appdownloader_notification_download_complete_without_install");
                        if (com.ss.android.socialbase.downloader.downloader.d.ms().zb(iMs2) != null) {
                            iXr3 = ny.xr("tt_appdownloader_notification_download_complete_open");
                        }
                        iXr4 = 0;
                    }
                    String string7 = this.ah.getString(iXr3);
                    builder.setContentText(string7);
                    String string8 = iXr4 != 0 ? this.ah.getString(iXr4) : "";
                    if (msVarMs.xr("notification_opt_2") == 1) {
                        remoteViewsNy.setTextViewText(ka.hi(), string8);
                        remoteViewsNy.setViewVisibility(ka.ub(), 8);
                    } else {
                        remoteViewsNy.setViewVisibility(ka.hi(), 8);
                    }
                    baseException2 = baseException;
                    str2 = strMs;
                    builder = builder;
                    string2 = string8;
                    string4 = string7;
                } else {
                    str2 = "";
                    baseException2 = baseException;
                    string2 = "";
                }
                remoteViewsNy.setViewVisibility(ms(iMs2), 8);
                remoteViewsNy.setViewVisibility(ka.ny(), 0);
                remoteViewsNy.setViewVisibility(ka.ch(), 8);
                if (msVarMs.xr("enable_notification_ui") >= 2 && ka() == -1 && (c.ny(baseException) || c.x(baseException))) {
                    remoteViewsNy.setViewVisibility(ms(iMs2), 0);
                    remoteViewsNy.setViewVisibility(ka.ny(), 8);
                    remoteViewsNy.setViewVisibility(ka.ch(), 0);
                    int iHi4 = ka.hi();
                    if (c.xr(baseException2, downloadInfo)) {
                        remoteViewsNy.setViewVisibility(iHi4, 0);
                        str = com.ss.android.socialbase.appdownloader.ah.ms(jXr, false) + "/" + com.ss.android.socialbase.appdownloader.ah.ms(jAh, false);
                        string = string4;
                    } else {
                        string = string4;
                        iHi = iHi4;
                        str = str2;
                        remoteViewsNy.setViewVisibility(iHi, 8);
                    }
                } else {
                    string = string4;
                    str = str2;
                }
            } else {
                str = "";
                string2 = str;
                string = string2;
            }
        }
        remoteViewsNy.setTextViewText(ka.u(), str);
        remoteViewsNy.setTextViewText(ka.ao(), string);
        remoteViewsNy.setTextViewText(ka.ub(), str);
        remoteViewsNy.setTextViewText(ka.h(), string);
        int iHi5 = ka.hi();
        if (TextUtils.isEmpty(string2)) {
            remoteViewsNy.setViewVisibility(iHi5, 8);
        } else {
            remoteViewsNy.setTextViewText(iHi5, string2);
        }
        Notification notificationBuild = builder.build();
        notificationBuild.contentView = remoteViewsNy;
        return notificationBuild;
    }

    private boolean ms(BaseException baseException, com.ss.android.socialbase.downloader.ab.ms msVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && msVar.ms("notification_text_opt", 0) == 1;
    }

    private RemoteViews ny() {
        RemoteViews remoteViews = new RemoteViews(this.xr.getPackageName(), ka.ms());
        try {
            if (com.ss.android.socialbase.appdownloader.ah.ms(this.xr)) {
                remoteViews.setInt(ka.c(), "setBackgroundColor", this.xr.getResources().getColor(ka.qv()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    private int ms(int i, int i2) {
        if (com.ss.android.socialbase.downloader.ab.ms.ms(i2).xr("notification_opt_2") == 1) {
            return ka.b();
        }
        if (i == 1 || i == 4) {
            return ka.t();
        }
        if (i == 2) {
            return ka.nw();
        }
        if (i == 3) {
            return ka.b();
        }
        return 0;
    }

    private PendingIntent ms(String str, int i, int i2) {
        Intent intent = new Intent(this.xr, (Class<?>) DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return PendingIntent.getService(this.xr, i2, intent, 201326592);
    }

    private NotificationCompat.Builder ch() {
        String strNy = com.ss.android.socialbase.appdownloader.d.ch().ny();
        if (TextUtils.isEmpty(strNy)) {
            strNy = com.ss.android.socialbase.appdownloader.ah.xr(this.xr);
        }
        try {
            if (com.ss.android.socialbase.appdownloader.d.ch().zb() != null) {
                return com.ss.android.socialbase.appdownloader.d.ch().zb().ms(this.xr, strNy);
            }
            return new NotificationCompat.Builder(this.xr, strNy);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.xr);
        }
    }

    private int ms(int i) {
        if (com.ss.android.socialbase.downloader.ab.ms.ms(i).xr("enable_notification_ui") > 0) {
            return ka.x();
        }
        return ka.ab();
    }
}
