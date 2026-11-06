package com.byazt.ien;

import android.text.TextUtils;
import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.sz;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1989, 5})
public class q implements qg {
    public d n;

    public q() {
        this.n = null;
        this.n = com.byazt.iza.qg.s();
    }

    @Override // com.byazt.ien.qg
    public n n(l lVar) throws IOException {
        sz.n nVar = new sz.n();
        try {
            if (lVar.l != null) {
                for (Map.Entry<String, String> entry : lVar.l.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        nVar.qg(key, value);
                    }
                }
            }
            cy cyVarQg = this.n.n(nVar.qg(lVar.qg).n().qg()).qg();
            Object[] objArr = new Object[2];
            Integer.valueOf(cyVarQg.q());
            return new w(cyVarQg, lVar);
        } catch (Throwable unused) {
            return null;
        }
    }
}
