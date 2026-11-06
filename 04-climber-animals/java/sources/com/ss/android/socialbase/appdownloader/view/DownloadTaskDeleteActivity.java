package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.appdownloader.ah.ah;
import com.ss.android.socialbase.appdownloader.ah.hi;
import com.ss.android.socialbase.appdownloader.ah.sl;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.ny;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ny.c;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private hi f4591ms;
    private Intent xr;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ms();
    }

    private void ms() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.xr = getIntent();
        xr();
        hi hiVar = this.f4591ms;
        if (hiVar != null && !hiVar.xr()) {
            this.f4591ms.ms();
        } else if (this.f4591ms == null) {
            finish();
        }
    }

    private void xr() {
        Intent intent;
        if (this.f4591ms != null || (intent = this.xr) == null) {
            return;
        }
        try {
            final boolean z = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                ab.d("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String string = String.format(getString(ny.ms(this, "tt_appdownloader_notification_download_delete")), title);
            ah ahVarMs = d.ch().ms();
            sl slVarMs = ahVarMs != null ? ahVarMs.ms(this) : null;
            if (slVarMs == null) {
                slVarMs = new com.ss.android.socialbase.appdownloader.d.ms(this);
            }
            if (slVarMs != null) {
                int iMs = ny.ms(this, "tt_appdownloader_tip");
                int iMs2 = ny.ms(this, "tt_appdownloader_label_ok");
                int iMs3 = ny.ms(this, "tt_appdownloader_label_cancel");
                if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("cancel_with_net_opt", 0) == 1 && c.x() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                    z = true;
                }
                if (z) {
                    iMs2 = ny.ms(this, "tt_appdownloader_label_reserve_wifi");
                    iMs3 = ny.ms(this, "tt_appdownloader_label_cancel_directly");
                    string = getResources().getString(ny.ms(this, "tt_appdownloader_resume_in_wifi"));
                }
                slVarMs.ms(iMs).ms(string).ms(iMs2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!z) {
                            DownloadTaskDeleteActivity.this.ms(downloadInfo, intExtra);
                        } else {
                            downloadInfo.setOnlyWifi(true);
                            Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                                }
                            }, 100L);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).xr(iMs3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (z) {
                            DownloadTaskDeleteActivity.this.ms(downloadInfo, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).ms(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        DownloadTaskDeleteActivity.this.finish();
                    }
                });
                this.f4591ms = slVarMs.ms();
            }
        } catch (Exception e) {
            ab.ms(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(DownloadInfo downloadInfo, int i) {
        com.ss.android.socialbase.appdownloader.ah.d dVarXr = d.ch().xr();
        if (dVarXr != null) {
            dVarXr.ms(downloadInfo);
        }
        yu downloadNotificationEventListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.ms(10, downloadInfo, "", "");
        }
        if (com.ss.android.socialbase.downloader.downloader.ah.k() != null) {
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).cancel(i);
        }
    }
}
