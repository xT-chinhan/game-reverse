package com.byazt.bpa;

import com.byazt.cd.s;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.gct.ur;
import com.byazt.ly.qg;
import com.byazt.za.NativeExpressView;
import com.byazt.za.bb;
import com.byazt.zsl.l;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 405, 19})
public class n extends qg {
    public boolean w;

    public n(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, String str, boolean z, boolean z2) {
        super(tTBaseVideoActivity, pkVar, str, z, z2);
    }

    @Override // com.byazt.ly.qg
    public void n(NativeExpressView nativeExpressView) {
        Map<String, Object> mapN = this.n.n(this.qg);
        if (nativeExpressView.getDynamicShowType() == 0) {
            bb.n(mapN, this.qg, nativeExpressView);
        } else {
            mapN.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            byte showDLFactorsEventParams = nativeExpressView.getShowDLFactorsEventParams();
            if (showDLFactorsEventParams != -1) {
                mapN.put("biz_type", Byte.valueOf(showDLFactorsEventParams));
            }
        }
        ur urVarNq = this.qg.nq();
        Double dWo = null;
        if (urVarNq != null) {
            mapN.put("refresh_num", Integer.valueOf(urVarNq.s()));
            if (this.w) {
                dWo = this.n.wo();
            }
        }
        com.byazt.hm.n.n(this.qg, this.s, mapN, dWo);
        nativeExpressView.getAdShowTime().n(1.0f, 11);
        com.byazt.hnb.qg.n().q();
        s.n(this.qg.v());
    }

    public void s(boolean z) {
        this.w = z;
    }

    @Override // com.byazt.ly.qg
    public l tj() {
        l lVarN = ta.n(1, this.qg);
        lVarN.qg(this.qg.q());
        lVarN.qg(100);
        lVarN.s(100);
        lVarN.s(this.qg.F_());
        lVarN.qg(this.q);
        if (com.byazt.ql.s.n(this.qg)) {
            lVarN.n(true);
        }
        return lVarN;
    }
}
