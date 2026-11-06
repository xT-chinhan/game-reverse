package com.byazt.ns;

import com.byazt.sd.zo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1419, 121})
public class x extends com.byazt.eq.pr {
    @Override // com.byazt.eq.pr
    public boolean hw() {
        return zo.nt().x();
    }

    @Override // com.byazt.eq.pr
    public boolean hn() {
        return super.hn();
    }

    @Override // com.byazt.eq.pr
    public com.byazt.eq.x x() {
        return c();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    private com.byazt.eq.x c() {
        switch (com.byazt.hb.pr.fw()) {
            case "2g":
                return com.byazt.eq.x.TYPE_2G;
            case "3g":
                return com.byazt.eq.x.TYPE_3G;
            case "4g":
                return com.byazt.eq.x.TYPE_4G;
            case "5g":
                return com.byazt.eq.x.TYPE_5G;
            case "wifi":
                return com.byazt.eq.x.TYPE_WIFI;
            default:
                return com.byazt.eq.x.TYPE_UNKNOWN;
        }
    }
}
