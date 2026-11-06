package com.bytedance.sdk.openadsdk.ao.xr;

import android.app.Dialog;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ao.xr.xr.u;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends u {
    public abstract void ms(Dialog dialog, int[] iArr);

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.u
    public void ms(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        ms(tTDislikeDialogAbstract, tTDislikeDialogAbstract != null ? tTDislikeDialogAbstract.getTTDislikeListViewIds() : new int[0]);
    }
}
