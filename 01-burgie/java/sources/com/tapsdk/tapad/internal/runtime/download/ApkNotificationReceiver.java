package com.tapsdk.tapad.internal.runtime.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ApkNotificationReceiver extends BroadcastReceiver {
    public static final String ACTION_CANCEL = "_download_cancel";
    public static final String ACTION_DELETE = "_notification_delete";
    public static final String ACTION_RESUME = "_download_resume";
    public static final String EXTRA_DOWNLOAD_ID = "download_id";
    public static final String EXTRA_PROCESS_ID = "process_id";
    private static final String TAG = "ApkNotificationReceiver";
    private static boolean registered;
    private static volatile String sPackagePrefix;
    private final int mProcessId;

    private ApkNotificationReceiver(int i) {
        this.mProcessId = i;
    }

    public static IntentFilter createIntentFilter(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getActionName(context, ACTION_RESUME));
        intentFilter.addAction(getActionName(context, ACTION_CANCEL));
        intentFilter.addAction(getActionName(context, ACTION_DELETE));
        return intentFilter;
    }

    public static synchronized void ensureRegistered(Context context) {
        if (!registered && context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            try {
                ApkNotificationReceiver apkNotificationReceiver = new ApkNotificationReceiver(Process.myPid());
                IntentFilter intentFilterCreateIntentFilter = createIntentFilter(context);
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(apkNotificationReceiver, intentFilterCreateIntentFilter, 4);
                } else {
                    context.registerReceiver(apkNotificationReceiver, intentFilterCreateIntentFilter);
                }
                registered = true;
            } catch (Throwable th) {
            }
        }
    }

    public static String getActionName(Context context, String str) {
        if (sPackagePrefix == null) {
            try {
                sPackagePrefix = context.getPackageName();
            } catch (Exception e) {
                sPackagePrefix = "com.tapsdk.tapad.internal.runtime";
            }
        }
        return sPackagePrefix + str;
    }

    private void handleCancel(Context context, int i) {
        AndroidDownloadHost.get(context).cancel(i);
    }

    private void handleIntent(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        int intExtra = intent.getIntExtra(EXTRA_PROCESS_ID, -1);
        if (intExtra == -1 || intExtra == this.mProcessId) {
            int intExtra2 = intent.getIntExtra(EXTRA_DOWNLOAD_ID, -1);
            if (action.endsWith(ACTION_RESUME)) {
                handleResume(context, intExtra2);
            } else if (action.endsWith(ACTION_CANCEL) || action.endsWith(ACTION_DELETE)) {
                handleCancel(context, intExtra2);
            }
        }
    }

    private void handleResume(Context context, int i) {
        AndroidDownloadHost.get(context).resume(i);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            handleIntent(context, intent);
        } catch (Throwable th) {
        }
    }
}
