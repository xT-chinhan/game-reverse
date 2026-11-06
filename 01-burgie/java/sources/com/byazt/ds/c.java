package com.byazt.ds;

import com.byazt.eld.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.wel.pr.InterfaceC0223pr {
    public long pr;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 169})
    private static class pr {
        public static c pr = new c();
    }

    public static c pr() {
        return pr.pr;
    }

    private c() {
        this.pr = 0L;
        com.byazt.wel.pr.pr().pr(this);
    }

    @Override // com.byazt.wel.pr.InterfaceC0223pr
    public void hw() {
        this.pr = System.currentTimeMillis();
    }

    @Override // com.byazt.wel.pr.InterfaceC0223pr
    public void hn() {
    }

    public void pr(final x xVar, final long j) {
        if (xVar == null) {
            return;
        }
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.ds.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.byazt.wel.pr.pr().hn() || System.currentTimeMillis() - c.this.pr <= j) {
                    xVar.pr(true);
                } else {
                    xVar.pr(false);
                }
            }
        }, j);
    }

    public void pr(x xVar) {
        pr(xVar, 5000L);
    }

    public void hw(x xVar) {
        if (xVar == null) {
            return;
        }
        JSONObject jSONObjectAj = k.aj();
        int i = ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR;
        int iOptInt = jSONObjectAj.optInt("check_an_result_delay", ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR);
        if (iOptInt > 0) {
            i = iOptInt;
        }
        pr(xVar, i);
    }
}
