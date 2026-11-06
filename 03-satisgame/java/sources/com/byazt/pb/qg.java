package com.byazt.pb;

import com.byazt.ew.q;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 868, 26})
public class qg extends com.byazt.ew.n {
    @Override // com.byazt.ew.n
    public boolean qg() {
        return com.byazt.vyf.s.cy().q();
    }

    @Override // com.byazt.ew.n
    public boolean s() {
        return super.s();
    }

    @Override // com.byazt.ew.n
    public q q() {
        return l();
    }

    private q l() {
        String strX = com.byazt.ges.qg.x();
        strX.hashCode();
        switch (strX) {
            case "2g":
                return q.TYPE_2G;
            case "3g":
                return q.TYPE_3G;
            case "4g":
                return q.TYPE_4G;
            case "5g":
                return q.TYPE_5G;
            case "wifi":
                return q.TYPE_WIFI;
            default:
                return q.TYPE_UNKNOWN;
        }
    }
}
