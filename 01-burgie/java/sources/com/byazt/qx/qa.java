package com.byazt.qx;

import android.os.Looper;
import android.view.View;
import com.byazt.mo.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 101})
public class qa extends com.byazt.mq.pr<BackupView> {
    public com.byazt.mq.fw c;
    public ThemeStatusBroadcastReceiver hn;
    public View hw;
    public BackupView pr;
    public com.byazt.mq.m uc;
    public com.byazt.mq.hn x;

    public qa(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.byazt.mq.m mVar) {
        this.hw = view;
        this.hn = themeStatusBroadcastReceiver;
        this.uc = mVar;
    }

    @Override // com.byazt.mq.x
    public void pr(com.byazt.mq.fw fwVar) {
        this.c = fwVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hn();
        } else {
            com.byazt.sd.lb.uc().post(new Runnable() { // from class: com.byazt.qx.qa.1
                @Override // java.lang.Runnable
                public void run() {
                    qa.this.hn();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        com.byazt.mq.hn hnVar = this.x;
        boolean z = false;
        if (hnVar != null && hnVar.pr((NativeExpressView) this.hw, 0)) {
            z = true;
        }
        if (!z) {
            this.c.pr(107, (String) null);
            return;
        }
        this.uc.fw().vk();
        BackupView backupView = (BackupView) this.hw.findViewWithTag("tt_express_backup_fl_tag_26");
        this.pr = backupView;
        if (backupView == null) {
            this.c.pr(107, (String) null);
            return;
        }
        backupView.setThemeChangeReceiver(this.hn);
        com.byazt.mq.g gVar = new com.byazt.mq.g();
        BackupView backupView2 = this.pr;
        float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
        BackupView backupView3 = this.pr;
        float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
        gVar.pr(true);
        gVar.pr(realWidth);
        gVar.hw(realHeight);
        this.c.pr(this.pr, gVar);
    }

    @Override // com.byazt.mq.x
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public BackupView uc() {
        return this.pr;
    }

    @Override // com.byazt.mq.x
    public void pr(boolean z) {
    }

    @Override // com.byazt.mq.pr
    public void pr(com.byazt.mq.hn hnVar) {
        this.x = hnVar;
    }
}
