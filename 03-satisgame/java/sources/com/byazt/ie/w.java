package com.byazt.ie;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 13})
public class w implements n {
    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        String strA = qgVarN.wm().a();
        if (com.byazt.sq.n.n().qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(strA) + "请求过于频繁，触发了熔断机制");
            n(qgVarN, 840043);
            qgVarN.n(new com.byazt.pu.n(840043, com.byazt.mj.n.n(840043)));
            return;
        }
        com.byazt.ws.qg qgVarCy = qgVarN.cy();
        if (qgVarCy != null && qgVarCy.oa()) {
            if (!com.byazt.bf.oa.n().fs(String.valueOf(strA))) {
                com.byazt.rb.qg.q("TMe", "广告位 请求触发次数拦截............");
                Pair<String, String> pairW = com.byazt.bf.oa.n().w(strA);
                com.byazt.pu.qg qgVar = new com.byazt.pu.qg(840041, com.byazt.mj.n.n(840041), pairW != null ? (String) pairW.second : "", pairW != null ? (String) pairW.first : "");
                n(qgVarN, qgVar.n);
                qgVarN.n(qgVar);
                return;
            }
            if (!com.byazt.bf.oa.n().s(String.valueOf(strA)) && !qgVarN.h()) {
                com.byazt.rb.qg.q("TMe", "广告位 请求触发时间间隔拦截............");
                com.byazt.bf.rv rvVarL = com.byazt.bf.oa.n().l(String.valueOf(strA));
                com.byazt.pu.s sVar = new com.byazt.pu.s(840042, com.byazt.mj.n.n(840042), new StringBuilder().append(com.byazt.bf.oa.n().n(strA)).toString(), rvVarL != null ? rvVarL.tj() : "");
                n(qgVarN, sVar.n);
                qgVarN.n(sVar);
                return;
            }
        }
        interfaceC0201n.n(interfaceC0201n.n());
    }

    private void n(com.byazt.zb.qg qgVar, int i) {
        com.byazt.gp.s.n(qgVar.wm(), (String) null, !qgVar.h(), qgVar.fi().n, i, (Map<String, Object>) null);
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        interfaceC0201n.n((String) null);
    }
}
