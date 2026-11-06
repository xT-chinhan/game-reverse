package com.byazt.war;

import com.byazt.si.m;
import com.taptap.sdk.compilance.bean.IdentityVerifyStateKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 101})
public class fs extends n {
    public Throwable n;
    public int qg;
    public String s;

    @Override // com.byazt.war.rv
    public String n() {
        return IdentityVerifyStateKt.VERIFY_STATE_FAILED;
    }

    public fs(int i, String str, Throwable th) {
        this.qg = i;
        this.s = str;
        this.n = th;
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        sVar.n(new com.byazt.gxb.n(this.qg, this.s, this.n));
        String strHu = sVar.hu();
        Map<String, List<com.byazt.gxb.s>> mapX = sVar.py().x();
        List<com.byazt.gxb.s> list = mapX.get(strHu);
        if (list == null) {
            qg(sVar);
            return;
        }
        synchronized (list) {
            Iterator<com.byazt.gxb.s> it = list.iterator();
            while (it.hasNext()) {
                qg(it.next());
            }
            list.clear();
            mapX.remove(strHu);
        }
    }

    private void qg(com.byazt.gxb.s sVar) {
        m mVarCp = sVar.cp();
        if (mVarCp != null) {
            mVarCp.n(this.qg, this.s, this.n);
        }
    }
}
