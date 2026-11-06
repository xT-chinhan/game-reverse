package com.byazt.za;

import android.os.Looper;
import android.view.View;
import com.byazt.hne.ThemeStatusBroadcastReceiver;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a extends com.byazt.udb.n<BackupView> {
    public com.byazt.udb.x l;
    public BackupView n;
    public com.byazt.udb.s q;
    public View qg;
    public ThemeStatusBroadcastReceiver s;
    public com.byazt.udb.oa w;

    @Override // com.byazt.udb.q
    public void n(boolean z) {
    }

    public a(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.byazt.udb.oa oaVar) {
        this.qg = view;
        this.s = themeStatusBroadcastReceiver;
        this.w = oaVar;
    }

    @Override // com.byazt.udb.q
    public void n(com.byazt.udb.x xVar) {
        this.l = xVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            s();
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.za.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.s();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.byazt.udb.s sVar = this.q;
        boolean z = false;
        if (sVar != null && sVar.n((NativeExpressView) this.qg, 0)) {
            z = true;
        }
        if (!z) {
            this.l.n(107, (String) null);
            return;
        }
        this.w.x().tj();
        BackupView backupView = (BackupView) this.qg.findViewWithTag("tt_express_backup_fl_tag_26");
        this.n = backupView;
        if (backupView != null) {
            backupView.setThemeChangeReceiver(this.s);
            com.byazt.udb.sz szVar = new com.byazt.udb.sz();
            BackupView backupView2 = this.n;
            float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
            BackupView backupView3 = this.n;
            float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
            szVar.n(true);
            szVar.n(realWidth);
            szVar.qg(realHeight);
            this.l.n(this.n, szVar);
            return;
        }
        this.l.n(107, (String) null);
    }

    @Override // com.byazt.udb.q
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public BackupView w() {
        return this.n;
    }

    @Override // com.byazt.udb.n
    public void n(com.byazt.udb.s sVar) {
        this.q = sVar;
    }
}
