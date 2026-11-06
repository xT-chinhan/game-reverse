package com.byazt.soz;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.gct.sz;
import com.byazt.llp.cp;
import com.byazt.nf.rv;
import com.byazt.qk.oa;
import com.byazt.tk.h;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO, 8})
public class s {
    public final AtomicBoolean l = new AtomicBoolean(true);
    public cp n;
    public String q;
    public final sz qg;
    public final Context s;
    public qg w;
    public Map<String, Object> x;

    public interface n {
        void n();
    }

    public interface qg {
        void n();

        void n(String str, boolean z);
    }

    public s(cp cpVar, sz szVar, Context context, Map<String, Object> map) {
        this.n = cpVar;
        this.s = context;
        this.qg = szVar;
        this.x = map;
    }

    public s n(String str) {
        this.q = str;
        return this;
    }

    public void n(qg qgVar) {
        this.w = qgVar;
    }

    public static boolean n(cp cpVar, boolean z) {
        sz szVarUm = cpVar != null ? cpVar.um() : null;
        return szVarUm != null && szVarUm.qg(z);
    }

    public static boolean n(sz szVar, boolean z) {
        return szVar != null && szVar.qg(z);
    }

    public int n(final n nVar) {
        sz szVar = this.qg;
        n(szVar);
        qg(szVar);
        com.byazt.vyf.l.q().postDelayed(new Runnable() { // from class: com.byazt.soz.s.1
            @Override // java.lang.Runnable
            public void run() {
                n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n();
                }
            }
        }, 500L);
        return 1;
    }

    private void n(sz szVar) {
        if (szVar == null || TextUtils.isEmpty(szVar.q())) {
            return;
        }
        final String strQ = szVar.q();
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.soz.s.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h.qg(s.this.s.getApplicationContext(), strQ, 0, 17, 0, 0);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void qg(final sz szVar) {
        if (szVar == null) {
            return;
        }
        try {
            rv.n().n(szVar.qg(), new com.byazt.mw.n.s<oa>() { // from class: com.byazt.soz.s.3
                @Override // com.byazt.mw.n.s
                public void n(int i, String str) {
                    s.this.n();
                    s.this.s(szVar);
                }

                @Override // com.byazt.mw.n.s
                public void n(oa oaVar) {
                    if (oaVar == null || !oaVar.x() || TextUtils.isEmpty(oaVar.fs())) {
                        s.this.n();
                        s.this.s(szVar);
                    } else {
                        try {
                            s.this.n(new JSONObject(oaVar.fs()));
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.byazt.hm.n.qg(com.byazt.ukb.qg.n(this.n, this.x), this.q, 4);
        qg qgVar = this.w;
        if (qgVar != null) {
            qgVar.n("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                qg(jSONObject);
            }
        } catch (Throwable unused) {
            n();
        }
    }

    private void qg(JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("is_apply_coupon");
        String strOptString = jSONObject.optString("error_type");
        pk pkVarN = com.byazt.ukb.qg.n(this.n, this.x);
        if (zOptBoolean && "success".equals(strOptString)) {
            com.byazt.hm.n.qg(pkVarN, this.q, 1);
        } else if (zOptBoolean && "has_applied".equals(strOptString)) {
            com.byazt.hm.n.qg(pkVarN, this.q, 2);
        } else if (!zOptBoolean) {
            com.byazt.hm.n.qg(pkVarN, this.q, 3);
        }
        if (this.w != null) {
            if (zOptBoolean && "success".equals(strOptString)) {
                this.w.n();
            } else {
                this.w.n(strOptString, zOptBoolean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(sz szVar) {
        if (this.l.getAndSet(false)) {
            qg(szVar);
        }
    }
}
