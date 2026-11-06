package com.byazt.xev;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 108})
public final class m extends hn<com.byazt.otj.hn> {
    public m() {
        super("com.zui.deviceidservice");
    }

    @Override // com.byazt.xev.hn
    public z.hw<com.byazt.otj.hn, String> pr() {
        return new z.hw<com.byazt.otj.hn, String>() { // from class: com.byazt.xev.m.1
            @Override // com.byazt.xev.z.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public com.byazt.otj.hn hw(IBinder iBinder) {
                return com.byazt.otj.hn.pr.pr(iBinder);
            }

            @Override // com.byazt.xev.z.hw
            public String pr(com.byazt.otj.hn hnVar) throws Exception {
                if (hnVar == null) {
                    return null;
                }
                return hnVar.pr();
            }
        };
    }

    @Override // com.byazt.xev.hn
    public Intent pr(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
