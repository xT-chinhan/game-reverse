package com.byazt.rcj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.llp.oa;
import com.byazt.nf.tj;
import com.byazt.q.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 104, 21})
public class x implements com.byazt.wj.n {
    public Map<String, Object> l;
    public com.byazt.gct.l n;
    public oa q;
    public Context qg;
    public String s;

    public x(com.byazt.gct.l lVar, Context context, oa oaVar, Map<String, Object> map) {
        this.n = lVar;
        this.qg = context;
        this.q = oaVar;
        this.l = map;
    }

    public void n(String str) {
        this.s = str;
    }

    @Override // com.byazt.wj.n
    public boolean n(Map<String, Object> map) {
        return n();
    }

    private boolean n() {
        com.byazt.gct.l lVar = this.n;
        if (lVar == null) {
            com.byazt.ukb.qg.n(this.l, com.byazt.wr.l.fs);
            return false;
        }
        String strN = lVar.n();
        if (this.q.w() != 3 || TextUtils.isEmpty(strN)) {
            com.byazt.ukb.qg.n(this.l, com.byazt.wr.l.fs);
            return false;
        }
        boolean zQg = qg(strN);
        if (zQg) {
            qg();
            com.byazt.ukb.qg.n(this.l, com.byazt.wr.l.s);
        } else {
            n(false);
            com.byazt.ukb.qg.n(this.l, com.byazt.wr.l.rv);
        }
        return zQg;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.byazt.rcj.x$1] */
    private void qg() {
        new CountDownTimer(3000L, 3000L) { // from class: com.byazt.rcj.x.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (com.byazt.vyf.s.cy() == null || com.byazt.vyf.s.cy().n()) {
                    x.this.n(true);
                } else {
                    x.this.n(false);
                }
            }
        }.start();
    }

    public boolean qg(String str) {
        if (this.qg == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            com.byazt.tk.n.startActivity(this.qg, intent, TextUtils.equals(tj.rv, "internal"));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        if (z) {
            com.byazt.hm.n.qg(s(), this.s, "quickapp_success");
        } else {
            com.byazt.hm.n.qg(s(), this.s, "quickapp_fail");
        }
    }

    private pk s() {
        return com.byazt.ukb.qg.n(this.q, this.l);
    }
}
