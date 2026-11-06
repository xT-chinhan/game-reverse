package com.byazt.ie;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 5})
public class q implements n {
    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        qgVarN.hd().n(0);
        int iS = qgVarN.wm().s();
        List<com.byazt.ws.tj> list = qgVarN.cy().ur().get(0);
        JSONObject jSONObject = new JSONObject();
        String strN = com.byazt.bp.n.n().n(qgVarN.m(), qgVarN.getContext(), qgVarN.wm(), list, qgVarN.cy(), iS, !qgVarN.h(), jSONObject);
        com.byazt.gp.s.n(qgVarN.wm(), jSONObject);
        qgVarN.n(strN);
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        interfaceC0201n.n((String) null);
    }
}
