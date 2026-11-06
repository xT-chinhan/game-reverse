package com.byazt.yu;

import android.text.TextUtils;
import com.byazt.ehw.x;
import com.byazt.qp.q;
import com.byazt.tk.rv;
import com.byazt.vf.s;
import com.byazt.zve.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, 19})
public class n {
    public volatile String n;
    public com.byazt.ot.n.qg q;
    public String qg;
    public AtomicBoolean s;

    /* JADX INFO: renamed from: com.byazt.yu.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0406n {
        public static final n n = new n();
    }

    public static String l() {
        return "164362";
    }

    public static String w() {
        return "unionser_slardar_applog";
    }

    private n() {
        this.n = null;
        this.qg = null;
        this.s = new AtomicBoolean(false);
        x();
    }

    private void x() {
        fs();
        final s sVar = (s) q.n("embed_applog");
        this.q = new com.byazt.ot.n.qg() { // from class: com.byazt.yu.n.1
            @Override // com.byazt.ot.n.qg
            public void q() {
            }

            @Override // com.byazt.ot.n.qg
            public void s() {
            }

            @Override // com.byazt.ot.n.qg
            public void n() {
                sVar.qg();
            }

            @Override // com.byazt.ot.n.qg
            public void qg() {
                sVar.s();
            }
        };
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS != null) {
            nVarS.n(this.q);
        }
    }

    private void fs() {
        final boolean zX = com.byazt.vyf.s.cy().x();
        boolean zFs = com.byazt.vyf.s.cy().fs();
        final boolean zTj = com.byazt.vyf.s.cy().tj();
        ((s) q.n("embed_applog")).n(new com.byazt.zve.s() { // from class: com.byazt.yu.n.2
            @Override // com.byazt.zve.s
            public void n(qg qgVar) {
                if (qgVar != null) {
                    x.n(qgVar.n());
                }
                if (zTj || !zX || n.this.s.get()) {
                    return;
                }
                n.this.n(new com.byazt.hnb.q(qgVar));
            }
        });
        if (zFs) {
            rv.n().post(new Runnable() { // from class: com.byazt.yu.n.3
                @Override // java.lang.Runnable
                public void run() {
                    n.this.n(new com.byazt.hnb.q(x.s(((s) q.n("embed_applog")).n(false))));
                }
            });
        } else {
            if (zTj || !zX) {
                return;
            }
            rv.n().postDelayed(new Runnable() { // from class: com.byazt.yu.n.4
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.s.get()) {
                        return;
                    }
                    n.this.n(new com.byazt.hnb.q("timeout"));
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.hnb.q qVar) {
        this.s.set(true);
        x.n(qVar);
    }

    public static n n() {
        return C0406n.n;
    }

    public String qg() {
        if (TextUtils.isEmpty(this.n)) {
            this.n = ((s) q.n("embed_applog")).n();
            com.byazt.lq.s.s(16, this.n);
            com.byazt.ed.s.n().tj(this.n == null ? "" : this.n);
        }
        return this.n;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String s() {
        if (TextUtils.isEmpty(this.qg)) {
            this.qg = ((s) q.n("embed_applog")).q();
        }
        return this.qg;
    }

    public String q() {
        return ((s) q.n("embed_applog")).n("sdk_version_name", "");
    }

    public static void n(String str, JSONObject jSONObject) {
        ((s) q.n("embed_applog")).qg(str, jSONObject);
    }
}
