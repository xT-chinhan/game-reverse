package com.byazt.xev;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 109})
public class w extends com.byazt.vj.pr.AbstractBinderC0214pr {
    public volatile boolean pr = false;

    @Override // com.byazt.vj.pr
    public void pr(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
    }

    @Override // com.byazt.vj.pr
    public void pr(int i, Bundle bundle) throws RemoteException {
        if (i == 0 && bundle != null) {
            this.pr = bundle.getBoolean("oa_id_limit_state");
        }
    }

    public boolean pr() {
        return this.pr;
    }
}
