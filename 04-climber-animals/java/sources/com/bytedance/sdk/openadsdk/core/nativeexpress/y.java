package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.os.Looper;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class y extends com.bytedance.sdk.component.adexpress.xr.ms<BackupView> {
    private ThemeStatusBroadcastReceiver ah;
    private com.bytedance.sdk.component.adexpress.xr.zb c;
    private com.bytedance.sdk.component.adexpress.xr.ah d;
    private com.bytedance.sdk.component.adexpress.xr.ab ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private BackupView f3015ms;
    private View xr;

    public y(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.xr.zb zbVar) {
        this.xr = view;
        this.ah = themeStatusBroadcastReceiver;
        this.c = zbVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    public void ms(com.bytedance.sdk.component.adexpress.xr.ab abVar) {
        this.ka = abVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xr();
        } else {
            com.bytedance.sdk.openadsdk.core.nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y.this.xr();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        com.bytedance.sdk.component.adexpress.xr.ah ahVar = this.d;
        boolean z = false;
        if (ahVar != null && ahVar.ms((NativeExpressView) this.xr, 0)) {
            z = true;
        }
        if (!z) {
            this.ka.ms(107, (String) null);
            return;
        }
        this.c.ab().ch();
        BackupView backupView = (BackupView) this.xr.findViewWithTag("tt_express_backup_fl_tag_26");
        this.f3015ms = backupView;
        if (backupView != null) {
            backupView.setThemeChangeReceiver(this.ah);
            com.bytedance.sdk.component.adexpress.xr.u uVar = new com.bytedance.sdk.component.adexpress.xr.u();
            BackupView backupView2 = this.f3015ms;
            float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
            BackupView backupView3 = this.f3015ms;
            float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
            uVar.ms(true);
            uVar.ms(realWidth);
            uVar.xr(realHeight);
            this.ka.ms(this.f3015ms, uVar);
            return;
        }
        this.ka.ms(107, (String) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.d
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public BackupView ab() {
        return this.f3015ms;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ms
    public void ms(com.bytedance.sdk.component.adexpress.xr.ah ahVar) {
        this.d = ahVar;
    }
}
