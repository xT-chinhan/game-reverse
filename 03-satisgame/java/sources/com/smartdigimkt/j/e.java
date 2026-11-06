package com.smartdigimkt.j;

import com.smartdigimkt.dlopt.api.ATApkDialogClickListener;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ ATApkDialogClickListener a;
    public final /* synthetic */ int b;

    public e(ATApkDialogClickListener aTApkDialogClickListener, int i) {
        this.a = aTApkDialogClickListener;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ATApkDialogClickListener aTApkDialogClickListener = this.a;
        if (aTApkDialogClickListener != null) {
            aTApkDialogClickListener.onShowResult(this.b);
        }
    }
}
