package com.byazt.ie;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 8})
public class s implements n {
    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        com.byazt.qn.qg qgVarWm = qgVarN.wm();
        com.byazt.ws.qg qgVarCy = qgVarN.cy();
        com.byazt.ws.qg qgVarN2 = com.byazt.bw.s.n(qgVarWm, qgVarCy);
        if (qgVarN2 != null) {
            if (qgVarWm.s() == 2 || qgVarWm.s() == 4 || qgVarWm.s() == 5) {
                com.byazt.qa.q.n().n(qgVarWm.a(), qgVarWm);
            }
            qgVarCy = qgVarN2;
        }
        if (qgVarCy.y() == null || qgVarCy.y().size() == 0) {
            com.byazt.gp.s.n(qgVarWm, qgVarN.cy() != null ? qgVarN.cy().rf() : null, !qgVarN.h(), qgVarN.fi().n, 810085, (Map<String, Object>) null);
            qgVarN.n(new com.byazt.mj.n(810085, com.byazt.mj.n.n(810085)));
        } else {
            qgVarN.n(qgVarCy);
            interfaceC0201n.n(interfaceC0201n.n());
        }
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        interfaceC0201n.n((String) null);
    }
}
