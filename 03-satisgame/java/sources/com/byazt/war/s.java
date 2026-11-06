package com.byazt.war;

import android.text.TextUtils;
import com.byazt.si.cd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 8})
public class s extends n {
    @Override // com.byazt.war.rv
    public String n() {
        return "generate_key";
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        if (TextUtils.isEmpty(sVar.x())) {
            cd cdVarL = sVar.py().l();
            sVar.qg(cdVarL.n(sVar));
            sVar.n(cdVarL.qg(sVar));
        }
        sVar.n(new x());
    }
}
