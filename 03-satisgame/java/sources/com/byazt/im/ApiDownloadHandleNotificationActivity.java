package com.byazt.im;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 147, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER})
public class ApiDownloadHandleNotificationActivity extends Activity {
    public static final String[] n = {"android.permission.POST_NOTIFICATIONS"};
    public ApiDownloadHandlerService qg = new ApiDownloadHandlerService();

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.im.ApiDownloadHandleNotificationActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(intent.getAction())) {
                    ApiDownloadHandleNotificationActivity.this.n();
                } else {
                    ApiDownloadHandleNotificationActivity.this.qg.onStartCommand(intent, 0, 0);
                }
                ApiDownloadHandleNotificationActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            ActivityCompat.requestPermissions(this, n, 1000);
        } catch (Throwable th) {
            w.qg("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            w.qg("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }
}
