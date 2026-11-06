package com.byazt.xev;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 37})
public final class pr extends hn<com.byazt.otj.x> {
    public pr() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.byazt.xev.hn
    public z.hw<com.byazt.otj.x, String> pr() {
        return new z.hw<com.byazt.otj.x, String>() { // from class: com.byazt.xev.pr.1
            @Override // com.byazt.xev.z.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public com.byazt.otj.x hw(IBinder iBinder) {
                return com.byazt.otj.x.pr.pr(iBinder);
            }

            @Override // com.byazt.xev.z.hw
            public String pr(com.byazt.otj.x xVar) throws Exception {
                if (xVar == null) {
                    return null;
                }
                return xVar.hn();
            }
        };
    }

    @Override // com.byazt.xev.hn
    public Intent pr(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
