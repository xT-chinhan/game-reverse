package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.byazt.mdu.DownloadHandlerService;
import com.byazt.p000do.pr;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadHandleNotificationActivity extends Activity {
    private static final String[] pr = {"android.permission.POST_NOTIFICATIONS"};
    private DownloadHandlerService hw = new DownloadHandlerService();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(intent.getAction())) {
            pr();
        } else {
            this.hw.onStartCommand(intent, 0, 0);
        }
        finish();
    }

    private void pr() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(pr, 1000);
            }
        } catch (Throwable th) {
            pr.hw("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            pr.hw("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }
}
