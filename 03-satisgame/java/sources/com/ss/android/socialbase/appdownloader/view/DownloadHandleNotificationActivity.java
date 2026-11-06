package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.byazt.e.DownloadHandlerService;
import com.byazt.fe.n;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadHandleNotificationActivity extends Activity {
    private static final String[] n = {"android.permission.POST_NOTIFICATIONS"};
    private DownloadHandlerService qg = new DownloadHandlerService();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(intent.getAction())) {
            n();
        } else {
            this.qg.onStartCommand(intent, 0, 0);
        }
        finish();
    }

    private void n() {
        try {
            requestPermissions(n, 1000);
        } catch (Throwable th) {
            n.qg("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            n.qg("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }
}
