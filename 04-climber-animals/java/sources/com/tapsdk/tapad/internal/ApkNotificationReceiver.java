package com.tapsdk.tapad.internal;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.n;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.umeng.analytics.pro.bv;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class ApkNotificationReceiver extends BroadcastReceiver {
    public static final String DOWNLOAD_TASK_Id = "download_task_id";
    public static final String DOWNLOAD_TASK_STATE = "download_task_state";
    public static final String DOWNLOAD_TASK_TAG = "download_task_tag";
    public static final String NOTIFICATION_DELETE = "notificaton_delete";
    public static final String NOTIFICATION_PAUSE_CLICK = "notificaton_pause";
    public static final String NOTIFICATION_RESUME_CLICK = "notificaton_resume";

    class a implements Consumer<Activity> {
        final /* synthetic */ String a;
        final /* synthetic */ AdInfo b;

        a(String str, AdInfo adInfo) {
            this.a = str;
            this.b = adInfo;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Activity activity) throws Exception {
            ApkNotificationReceiver.this.startInstall(activity, this.a, this.b);
        }
    }

    class b implements Consumer<Throwable> {
        final /* synthetic */ String a;
        final /* synthetic */ AdInfo b;

        b(String str, AdInfo adInfo) {
            this.a = str;
            this.b = adInfo;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            TapADLogger.e("install failed:" + th.getMessage());
            try {
                ApkNotificationReceiver.this.startInstall(null, this.a, this.b);
            } catch (Throwable unused) {
            }
        }
    }

    class c implements com.tapsdk.tapad.internal.n.c.a {
        c() {
        }

        @Override // com.tapsdk.tapad.internal.n.c.a
        public void a(boolean z) {
            TapADLogger.d("ApkNotificationReceiver installController:" + z);
        }
    }

    private void handleDownloadSuccessToInstall(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tapsdk.tapad.internal.utils.f.d(context, new File(str));
    }

    private void handleRetryDownload(Context context, AdInfo adInfo) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (adInfo != null && adInfo.appInfo != null) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            String str2 = adInfo.trackId;
            if (str2 != null && str2.length() > 0) {
                sb.append("trackId=").append(adInfo.trackId);
            }
            String str3 = adInfo.appInfo.appName;
            if (str3 != null && str3.length() > 0) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append("appName=").append(adInfo.appInfo.appName);
            }
            sb.append("]");
        }
        if (com.tapsdk.tapad.internal.utils.d.g(context)) {
            new com.tapsdk.tapad.internal.a(context, adInfo, 1).j();
        }
        TapADLogger.d("receive notification and retry");
        if (adInfo == null || (str = adInfo.trackId) == null || str.length() <= 0) {
            return;
        }
        TapADLogger.d("receive notification and send sync message to showingAd:" + ((Object) sb));
        n.a().a(new com.tapsdk.tapad.internal.p.a().a(Constants.p.a, adInfo));
    }

    private void onDownloadFail(Context context, AdInfo adInfo, String str) {
        TapADLogger.d("receive onDownloadFail reason =  " + str);
    }

    private void onDownloadSuccess(Context context, AdInfo adInfo, String str) {
        safeOutput("ApkNotificationReceiver onDownloadSuccess");
        if (adInfo != null) {
            List<String> list = adInfo.downloadFinishUrls;
            if (list != null && list.size() > 0) {
                com.tapsdk.tapad.internal.tracker.c.a().a(adInfo.downloadFinishUrls, (Map<String, String>) null, adInfo.getDownloadFinishMonitorHeaderListWrapper());
            }
            int i = adInfo.renderStyles.b;
            if (i == 1 || i == 3) {
                com.tapsdk.tapad.internal.utils.a.a().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(str, adInfo), new b(str, adInfo));
            }
        }
    }

    private void safeOutput(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInstall(Activity activity, String str, AdInfo adInfo) {
        if (str != null) {
            TapADLogger.d("gotoInstall receiver:" + str);
            File file = new File(Uri.parse(str).getPath());
            if (file.exists()) {
                TapADLogger.d("gotoInstall downloadFile exists");
                com.tapsdk.tapad.internal.n.c cVarA = com.tapsdk.tapad.internal.n.a.a(activity, file, adInfo);
                if (cVarA != null) {
                    cVarA.a(new c());
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (NOTIFICATION_PAUSE_CLICK.equals(action)) {
            safeOutput("ApkNotificationReceiver pause Click action:" + action + ",tag:" + intent.getStringExtra(DOWNLOAD_TASK_TAG));
            com.tapsdk.tapad.internal.download.g.a().a(intent.getStringExtra(DOWNLOAD_TASK_TAG));
            return;
        }
        if (NOTIFICATION_DELETE.equals(action)) {
            safeOutput("ApkNotificationReceiver pause Click action:" + action + ",tag:" + intent.getStringExtra(DOWNLOAD_TASK_TAG));
            String stringExtra = intent.getStringExtra(DOWNLOAD_TASK_TAG);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            com.tapsdk.tapad.internal.download.g.a().a(stringExtra);
            return;
        }
        safeOutput("ApkNotificationReceiver start action:" + action);
        if (TextUtils.isEmpty(action) || NOTIFICATION_RESUME_CLICK.equals(action)) {
            AdInfo adInfo = (AdInfo) intent.getParcelableExtra(bv.aw);
            String stringExtra2 = intent.getStringExtra(TTDownloadField.TT_FILE_PATH);
            int intExtra = intent.getIntExtra("notifyId", -1);
            safeOutput("ApkNotificationReceiver resumeClick:(notifyId:" + intExtra + ",filePath:" + stringExtra2 + ",adInfo:" + (adInfo != null ? adInfo.downloadFinishUrls : "") + ")");
            if (intExtra <= 0) {
                int intExtra2 = intent.getIntExtra("download_result", -1);
                String stringExtra3 = intent.getStringExtra(MediationConstant.KEY_REASON);
                if (intExtra2 > 0) {
                    onDownloadSuccess(context, adInfo, stringExtra2);
                    return;
                } else {
                    onDownloadFail(context, adInfo, stringExtra3);
                    return;
                }
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                TapADLogger.d(" NotificationActivity cancel taskId = " + intExtra);
                notificationManager.cancel(intExtra);
            }
            int intExtra3 = intent.getIntExtra("success", 0);
            TapADLogger.d("receive notification info success = " + intExtra3 + " filePath = " + stringExtra2);
            if (intExtra3 != 0 || TextUtils.isEmpty(stringExtra2)) {
                TapADLogger.d("receive retry download:" + intent.getStringExtra(DOWNLOAD_TASK_TAG));
                handleRetryDownload(context, adInfo);
                return;
            }
            List<String> list = adInfo.installStartMonitorUrls;
            if (list != null && list.size() > 0) {
                com.tapsdk.tapad.internal.tracker.c.a().a(adInfo.installStartMonitorUrls, (Map<String, String>) null, adInfo.getInstallStartMonitorHeaderListWrapper());
            }
            handleDownloadSuccessToInstall(context, stringExtra2);
        }
    }
}
