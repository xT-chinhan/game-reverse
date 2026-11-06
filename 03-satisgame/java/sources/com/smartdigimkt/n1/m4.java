package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.RewardExitConfirmDialogActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class m4 implements View.OnClickListener {
    public final /* synthetic */ RewardExitConfirmDialogActivity a;

    public m4(RewardExitConfirmDialogActivity rewardExitConfirmDialogActivity) {
        this.a = rewardExitConfirmDialogActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
        Runnable runnable = RewardExitConfirmDialogActivity.c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
