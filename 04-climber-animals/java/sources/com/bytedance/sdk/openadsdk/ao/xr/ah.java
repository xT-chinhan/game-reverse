package com.bytedance.sdk.openadsdk.ao.xr;

import android.app.Dialog;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ab;
import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah extends zb {
    public abstract ab ms(Dialog dialog, int[] iArr);

    public abstract void xr(Dialog dialog, int[] iArr);

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void xr(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        xr(tTDislikeDialogAbstract, tTDislikeDialogAbstract != null ? tTDislikeDialogAbstract.getTTDislikeListViewIds() : new int[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public ab ms(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        return ms(tTDislikeDialogAbstract, tTDislikeDialogAbstract != null ? tTDislikeDialogAbstract.getTTDislikeListViewIds() : new int[0]);
    }
}
