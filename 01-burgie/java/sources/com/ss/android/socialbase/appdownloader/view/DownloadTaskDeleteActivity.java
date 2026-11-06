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
import com.byazt.auw.DownloadInfo;
import com.byazt.fn.b;
import com.byazt.lj.Downloader;
import com.byazt.lj.hn;
import com.byazt.lkw.pr;
import com.byazt.tuy.uc;
import com.byazt.zkm.c;
import com.byazt.zkm.k;
import com.byazt.zkm.m;
import com.byazt.zkm.x;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private Intent hw;
    private k pr;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pr();
    }

    private void pr() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.hw = getIntent();
        hw();
        k kVar = this.pr;
        if (kVar != null && !kVar.hw()) {
            this.pr.pr();
        } else if (this.pr == null) {
            finish();
        }
    }

    private void hw() {
        Intent intent;
        if (this.pr != null || (intent = this.hw) == null) {
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
                return;
            }
            String str = String.format("确认要删除%1$s的下载任务吗？", title);
            x xVarHw = com.byazt.mdu.x.w().hw();
            m prVar = null;
            if (xVarHw != null) {
                prVar = xVarHw.pr(this);
            }
            if (prVar == null) {
                prVar = new pr(this);
            }
            if (prVar != null) {
                String str2 = "确定";
                String str3 = "取消";
                if (com.byazt.ew.pr.pr(downloadInfo.getId()).pr("cancel_with_net_opt", 0) == 1 && uc.zo() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                    z = true;
                }
                if (z) {
                    str2 = "Wi-Fi下恢复";
                    str3 = "直接取消";
                    str = "您当前处于移动网络，是否需要在Wi-Fi环境下恢复下载？";
                }
                prVar.pr((CharSequence) "提示").pr(str).pr(str2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!z) {
                            DownloadTaskDeleteActivity.this.pr(downloadInfo, intExtra);
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
                }).hw(str3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (z) {
                            DownloadTaskDeleteActivity.this.pr(downloadInfo, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).pr(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        DownloadTaskDeleteActivity.this.finish();
                    }
                });
                this.pr = prVar.pr();
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(DownloadInfo downloadInfo, int i) {
        c cVarHn = com.byazt.mdu.x.w().hn();
        if (cVarHn != null) {
            cVarHn.pr(downloadInfo);
        }
        b downloadNotificationEventListener = Downloader.getInstance(hn.of()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.pr(10, downloadInfo, "", "");
        }
        if (hn.of() != null) {
            Downloader.getInstance(hn.of()).cancel(i);
        }
    }
}
