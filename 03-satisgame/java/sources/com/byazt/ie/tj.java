package com.byazt.ie;

import android.text.TextUtils;
import com.byazt.vy.py;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends qg {
    public final com.byazt.ws.qg l;
    public final com.byazt.zb.qg q;
    public final List<com.byazt.ws.tj> w;
    public final HashSet<String> x = new HashSet<>();

    public tj(com.byazt.zb.qg qgVar, com.byazt.ws.qg qgVar2, List<com.byazt.ws.tj> list) {
        this.q = qgVar;
        this.l = qgVar2;
        this.w = list;
    }

    @Override // com.byazt.ie.qg
    public boolean qg(com.byazt.ws.tj tjVar, int i) {
        com.byazt.ws.tj tjVarW;
        if (i == 1) {
            com.byazt.ws.tj tjVarW2 = w();
            if (tjVarW2 != null && tjVar != null && TextUtils.equals(tjVarW2.cd(), tjVar.cd())) {
                s();
                return true;
            }
        } else if (i == 2) {
            if (tjVar != null) {
                this.x.add(tjVar.cd());
                CopyOnWriteArrayList<com.byazt.sg.s> copyOnWriteArrayListD = this.q.d();
                com.byazt.sg.s sVar = (copyOnWriteArrayListD == null || copyOnWriteArrayListD.size() <= 0) ? null : copyOnWriteArrayListD.get(0);
                if (sVar != null && (tjVarW = w()) != null && TextUtils.equals(tjVarW.cd(), sVar.el())) {
                    s();
                    return true;
                }
            }
            if (this.qg.fs()) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "全部广告完成响应...");
                if (py.n(this.q.d())) {
                    n(new com.byazt.mj.n(20005, com.byazt.mj.n.n(20005)));
                }
                return true;
            }
        } else if (this.qg.l()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.qg.l() + "  allWtfFinish:" + this.qg.fs());
            if (!py.n(this.q.d())) {
                s();
            } else {
                n(new com.byazt.mj.n(10003, com.byazt.mj.n.n(10003)));
            }
            return true;
        }
        return false;
    }

    private com.byazt.ws.tj w() {
        List<com.byazt.ws.tj> list = this.w;
        if (list == null) {
            return null;
        }
        for (com.byazt.ws.tj tjVar : list) {
            if (tjVar != null) {
                if (!this.x.contains(tjVar.cd())) {
                    return tjVar;
                }
            }
        }
        return null;
    }
}
