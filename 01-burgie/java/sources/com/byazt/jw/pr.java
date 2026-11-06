package com.byazt.jw;

import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.dr.hw;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.ve;
import com.byazt.n.uc;
import com.byazt.qx.NativeExpressView;
import com.byazt.qx.b;
import com.byazt.wt.e;
import com.byazt.zp.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 37})
public class pr extends hw {
    public boolean uc;

    public pr(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, String str, boolean z, boolean z2) {
        super(tTBaseVideoActivity, ofVar, str, z, z2);
    }

    @Override // com.byazt.dr.hw
    public void pr(NativeExpressView nativeExpressView) {
        Map<String, Object> mapPr = this.pr.pr(this.hw);
        if (nativeExpressView.getDynamicShowType() == 0) {
            b.pr(mapPr, this.hw, nativeExpressView);
        } else {
            mapPr.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            byte showDLFactorsEventParams = nativeExpressView.getShowDLFactorsEventParams();
            if (showDLFactorsEventParams != -1) {
                mapPr.put("biz_type", Byte.valueOf(showDLFactorsEventParams));
            }
        }
        ve veVarSb = this.hw.sb();
        Double dI = null;
        if (veVarSb != null) {
            mapPr.put("refresh_num", Integer.valueOf(veVarSb.hn()));
            if (this.uc) {
                dI = this.pr.i();
            }
        }
        com.byazt.pj.pr.pr(this.hw, this.hn, mapPr, dI);
        nativeExpressView.getAdShowTime().pr(1.0f, 11);
        com.byazt.na.pr.pr().x();
        e.pr(this.hw.nl());
    }

    public void hn(boolean z) {
        this.uc = z;
    }

    @Override // com.byazt.dr.hw
    public uc vk() {
        uc ucVarPr = qv.pr(1, this.hw);
        ucVarPr.hw(this.hw.x());
        ucVarPr.hw(100);
        ucVarPr.hn(100);
        ucVarPr.hn(this.hw.B_());
        ucVarPr.hw(this.x);
        if (k.pr(this.hw)) {
            ucVarPr.pr(true);
        }
        return ucVarPr;
    }
}
