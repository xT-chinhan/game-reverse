package com.byazt.ww;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.jp.cp;
import com.byazt.ju.q;
import com.byazt.ju.s;
import com.byazt.vy.a;
import com.byazt.vy.hd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, 26})
public abstract class qg {
    public s n;
    public final Set<String> qg = new CopyOnWriteArraySet();
    public boolean q = false;
    public boolean s = false;

    public abstract Map<String, Object> n();

    public abstract String qg();

    public abstract String s();

    public void q() {
        qg((cp) null);
    }

    public void n(cp cpVar) {
        this.q = true;
        qg(cpVar);
    }

    public void n(cp cpVar, s sVar) {
        this.n = sVar;
        this.q = true;
        qg(cpVar);
    }

    private void qg(cp cpVar) {
        com.byazt.ws.n nVarN = com.byazt.qt.qg.n().n(qg());
        if (cpVar == null && nVarN == null && !MediationConstant.ADN_PANGLE.equals(qg())) {
            return;
        }
        s(cpVar);
    }

    private synchronized void s(cp cpVar) {
        try {
            if (this.q || !com.byazt.ya.n.s(qg(), this.s)) {
                String strS = s();
                if (!TextUtils.isEmpty(strS)) {
                    throw new Exception("adn init ".concat(String.valueOf(strS)));
                }
                Map<String, Object> mapN = n();
                if (mapN == null) {
                    throw new Exception("adn init getConfig() is null");
                }
                mapN.put(MediationConstant.EXTRA_ADN_NAME, qg());
                mapN.put("q_x_c", Integer.valueOf(com.byazt.ir.qg.n().q()));
                mapN.put("wf_q_x_c", Integer.valueOf(com.byazt.ir.qg.n().l()));
                q qVarN = com.byazt.ya.qg.n().n(qg(), cpVar);
                if (qVarN == null) {
                    throw new Exception("configuration is null");
                }
                n(qVarN, mapN);
                if (!this.q) {
                    com.byazt.ya.n.qg(qg(), this.s);
                }
            }
        } catch (Throwable th) {
            com.byazt.ya.n.n(qg(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, th.toString()));
        }
    }

    private synchronized void n(q qVar, Map<String, Object> map) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.byazt.rb.qg.n("TMe", "--==--time: start " + qg());
        qVar.n(com.byazt.qt.qg.getContext(), map, new s() { // from class: com.byazt.ww.qg.1
            @Override // com.byazt.ju.s
            public void n() {
                if (qg.this.n != null) {
                    qg.this.n.n();
                }
                if (TextUtils.equals(qg.this.qg(), MediationConstant.ADN_PANGLE)) {
                    hd.n();
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                com.byazt.rb.qg.n("TMe", "--==--time: " + qg.this.qg() + ", ----==----- " + jElapsedRealtime2);
                if (!qg.this.qg.contains(qg.this.qg())) {
                    qg.this.qg.add(qg.this.qg());
                    a.n(qg.this.qg(), jElapsedRealtime2);
                }
                com.byazt.ya.n.n(qg.this.qg(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
            }

            @Override // com.byazt.ju.s
            public void n(com.byazt.mj.n nVar) {
                if (qg.this.n != null) {
                    qg.this.n.n(nVar);
                }
                if (nVar != null) {
                    com.byazt.ya.n.n(qg.this.qg(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + nVar.n + " errorMessage = " + nVar.qg));
                }
            }
        });
    }
}
