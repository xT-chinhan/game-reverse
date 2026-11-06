package com.byazt.lbp;

import android.content.Context;
import com.byazt.gct.pk;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 110})
public class sz implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk n;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context qg;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        Context context;
        pk pkVar = this.n;
        if (pkVar == null || (context = this.qg) == null) {
            nVar.n(map2, (com.byazt.bds.n) null);
            return true;
        }
        com.byazt.okk.n.n(context, pkVar);
        nVar.n(map2);
        return true;
    }
}
