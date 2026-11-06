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
import com.byazt.je.h;
import com.byazt.n.n;
import com.byazt.ta.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.xv.s;
import com.byazt.z.d;
import com.byazt.z.l;
import com.byazt.z.oa;
import com.byazt.z.q;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private d n;
    private Intent qg;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n();
    }

    private void n() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.qg = getIntent();
        qg();
        d dVar = this.n;
        if (dVar != null && !dVar.qg()) {
            this.n.n();
        } else if (this.n == null) {
            finish();
        }
    }

    private void qg() {
        Intent intent;
        if (this.n != null || (intent = this.qg) == null) {
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
            q qVarQg = com.byazt.e.q.cp().qg();
            oa oaVarN = qVarQg != null ? qVarQg.n(this) : null;
            if (oaVarN == null) {
                oaVarN = new n(this);
            }
            if (oaVarN != null) {
                String str2 = "确定";
                String str3 = "取消";
                if (com.byazt.f.n.n(downloadInfo.getId()).n("cancel_with_net_opt", 0) == 1 && w.fs() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                    z = true;
                }
                if (z) {
                    str2 = "Wi-Fi下恢复";
                    str3 = "直接取消";
                    str = "您当前处于移动网络，是否需要在Wi-Fi环境下恢复下载？";
                }
                oaVarN.n((CharSequence) "提示").n(str).n(str2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!z) {
                            DownloadTaskDeleteActivity.this.n(downloadInfo, intExtra);
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
                }).qg(str3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (z) {
                            DownloadTaskDeleteActivity.this.n(downloadInfo, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).n(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        DownloadTaskDeleteActivity.this.finish();
                    }
                });
                this.n = oaVarN.n();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(DownloadInfo downloadInfo, int i) {
        l lVarS = com.byazt.e.q.cp().s();
        if (lVarS != null) {
            lVarS.n(downloadInfo);
        }
        h downloadNotificationEventListener = Downloader.getInstance(s.u()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.n(10, downloadInfo, "", "");
        }
        if (s.u() != null) {
            Downloader.getInstance(s.u()).cancel(i);
        }
    }
}
