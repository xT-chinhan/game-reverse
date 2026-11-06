package com.byazt.sb;

import android.os.Message;
import com.byazt.tk.ou;
import com.byazt.tk.rv;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 527, 26})
public class qg extends n implements wo.n {
    public final t n = new t(rv.n().getLooper(), this);
    public ou qg;

    public void n(JSONObject jSONObject, int i) {
        int iN = n(i);
        if (qg(i)) {
            n(jSONObject, com.byazt.hnb.qg.n().qg(), iN);
        } else if (s(i)) {
            n(jSONObject, com.byazt.hnb.qg.n().s(), iN);
        }
    }

    private void n(JSONObject jSONObject, long j, long j2) {
        if (System.currentTimeMillis() - j > j2) {
            this.qg = n();
            this.n.removeCallbacksAndMessages(null);
            this.n.sendEmptyMessage(1);
        }
    }

    private ou n() {
        ou ouVar = new ou(com.byazt.nf.rv.getContext(), 1, com.byazt.vyf.s.cy().q());
        if (ouVar.n(0)) {
            return ouVar;
        }
        n(0, System.currentTimeMillis(), 0L);
        ouVar.qg(0);
        return null;
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            ou ouVar = this.qg;
            if (ouVar != null) {
                ouVar.qg(0);
            }
            n(3, 0L, System.currentTimeMillis());
            return;
        }
        ou ouVar2 = this.qg;
        if (ouVar2 == null) {
            return;
        }
        ouVar2.n(new ou.s() { // from class: com.byazt.sb.qg.1
            @Override // com.byazt.tk.ou.s
            public void n() {
                qg.this.n(1, System.currentTimeMillis(), 0L);
                if (qg.this.n != null) {
                    qg.this.n.removeCallbacksAndMessages(null);
                }
                if (qg.this.qg != null) {
                    qg.this.qg.qg(0);
                }
            }
        });
        this.n.sendEmptyMessageDelayed(2, n(com.byazt.nf.rv.qg().ox()));
    }
}
