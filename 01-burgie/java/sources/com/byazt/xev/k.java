package com.byazt.xev;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 250})
public class k extends hn<com.byazt.vj.hw> {
    public final w hw;
    public final vk pr;

    @Override // com.byazt.xev.hn, com.byazt.xev.yb
    public /* bridge */ /* synthetic */ boolean hw(Context context) {
        return super.hw(context);
    }

    public k() {
        super("com.hihonor.id");
        this.pr = new vk();
        this.hw = new w();
    }

    @Override // com.byazt.xev.hn
    public z.hw<com.byazt.vj.hw, String> pr() {
        return new z.hw<com.byazt.vj.hw, String>() { // from class: com.byazt.xev.k.1
            @Override // com.byazt.xev.z.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public com.byazt.vj.hw hw(IBinder iBinder) {
                return com.byazt.vj.hw.pr.pr(iBinder);
            }

            @Override // com.byazt.xev.z.hw
            public String pr(com.byazt.vj.hw hwVar) throws Exception {
                if (hwVar == null) {
                    com.byazt.ca.ho.hw("honor# ", "service is null");
                    return null;
                }
                hwVar.pr(k.this.pr);
                hwVar.hw(k.this.hw);
                return "";
            }
        };
    }

    @Override // com.byazt.xev.hn
    public Intent pr(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.byazt.xev.hn, com.byazt.xev.yb
    public yb.pr hn(Context context) {
        new z(context, pr(context), pr()).pr();
        yb.pr prVar = new yb.pr();
        prVar.hw = this.pr.pr();
        prVar.hn = this.hw.pr();
        return prVar;
    }
}
