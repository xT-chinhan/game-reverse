package com.byazt.udc;

import android.util.Pair;
import com.byazt.cl.q;
import com.byazt.qk.rv;
import com.byazt.qk.x;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 8})
public class s {
    public final rv n = com.byazt.phf.s.n();

    public void n(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pairN;
        try {
            pairN = q.n().n(jSONObject.toString(), str);
        } catch (Throwable th) {
            k.n(th.getMessage());
            pairN = null;
        }
        if (pairN != null && pairN.first != null) {
            if (((Integer) pairN.first).intValue() == 4) {
                this.n.n((byte[]) pairN.second);
                this.n.n("x-pglcypher", String.valueOf(pairN.first));
                return;
            } else {
                this.n.n((JSONObject) pairN.second);
                return;
            }
        }
        com.byazt.eji.s.n().n(-1, -1L, str, -1);
        this.n.qg(com.byazt.cl.s.n(jSONObject != null ? jSONObject.toString() : null).toString());
    }

    public void qg(JSONObject jSONObject, String str) {
        if (com.byazt.nf.rv.qg().oo()) {
            n(jSONObject, str);
        } else {
            this.n.qg(com.byazt.cl.s.n(jSONObject == null ? null : jSONObject.toString()).toString());
        }
    }

    public void s(JSONObject jSONObject, String str) {
        if (com.byazt.nf.rv.qg().dz()) {
            n(jSONObject, str);
        } else {
            this.n.qg(com.byazt.cl.s.n(jSONObject == null ? null : jSONObject.toString()).toString());
        }
    }

    public void n(String str) {
        this.n.n(str);
    }

    public void n(x xVar) {
        this.n.n(xVar);
    }

    public void n(Map<String, Object> map) {
        this.n.n(map);
    }

    public rv n() {
        return this.n;
    }
}
