package com.byazt.aj;

import android.text.TextUtils;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 61, 121})
public class x implements hw {
    public k pr;

    public x() {
        this.pr = null;
        this.pr = com.byazt.y.hw.hn();
    }

    @Override // com.byazt.aj.hw
    public pr pr(c cVar) throws IOException {
        g.pr prVar = new g.pr();
        try {
            if (cVar.c != null) {
                for (Map.Entry<String, String> entry : cVar.c.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        prVar.hw(key, value);
                    }
                }
            }
            nt ntVarHw = this.pr.pr(prVar.pr(cVar.hw).pr().hw()).hw();
            Object[] objArr = {"response code = ", Integer.valueOf(ntVarHw.hn())};
            return new uc(ntVarHw, cVar);
        } catch (Throwable th) {
            return null;
        }
    }
}
