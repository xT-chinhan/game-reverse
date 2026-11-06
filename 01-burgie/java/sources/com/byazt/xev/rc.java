package com.byazt.xev;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 91})
public final class rc extends hn<com.byazt.otj.hw> {
    public rc() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.byazt.xev.hn
    public z.hw<com.byazt.otj.hw, String> pr() {
        return new z.hw<com.byazt.otj.hw, String>() { // from class: com.byazt.xev.rc.1
            @Override // com.byazt.xev.z.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public com.byazt.otj.hw hw(IBinder iBinder) {
                return com.byazt.otj.hw.pr.pr(iBinder);
            }

            @Override // com.byazt.xev.z.hw
            public String pr(com.byazt.otj.hw hwVar) throws Exception {
                return hwVar.pr();
            }
        };
    }

    @Override // com.byazt.xev.hn
    public Intent pr(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
