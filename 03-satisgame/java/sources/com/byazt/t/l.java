package com.byazt.t;

import com.byazt.ug.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL, 18})
public class l implements com.byazt.b.n.InterfaceC0133n {
    public long n;

    @Override // com.byazt.b.n.InterfaceC0133n
    public void s() {
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n {
        public static l n = new l();
    }

    public static l n() {
        return n.n;
    }

    private l() {
        this.n = 0L;
        com.byazt.b.n.n().n(this);
    }

    @Override // com.byazt.b.n.InterfaceC0133n
    public void qg() {
        this.n = System.currentTimeMillis();
    }

    public void n(final q qVar, final long j) {
        if (qVar == null) {
            return;
        }
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.t.l.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.byazt.b.n.n().s() || System.currentTimeMillis() - l.this.n <= j) {
                    qVar.n(true);
                } else {
                    qVar.n(false);
                }
            }
        }, j);
    }

    public void n(q qVar) {
        n(qVar, 5000L);
    }

    public void qg(q qVar) {
        if (qVar == null) {
            return;
        }
        JSONObject jSONObjectRv = d.rv();
        int i = ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR;
        int iOptInt = jSONObjectRv.optInt("check_an_result_delay", ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        if (iOptInt > 0) {
            i = iOptInt;
        }
        n(qVar, i);
    }
}
