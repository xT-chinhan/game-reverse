package com.byazt.ss;

import android.view.View;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1334, 8})
public class s extends n {
    @Override // com.byazt.ss.n
    public void qg() {
    }

    public s(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
        super(sVar, str, nVar);
    }

    @Override // com.byazt.ss.n
    public void n() {
        Object obj;
        String strValueOf = (this.w == null || this.w.size() <= 0 || (obj = this.w.get(TapEventParamConstants.PARAM_NAME)) == null) ? "" : String.valueOf(obj);
        com.byazt.ih.s sVarQg = this.s.qg(this.s);
        if (sVarQg == null) {
            return;
        }
        n(sVarQg, strValueOf);
    }

    private void n(com.byazt.ih.s sVar, String str) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        com.byazt.xz.tj tjVarYw = sVar.yw();
        if (tjVarYw != null) {
            tjVarYw.s(str);
        }
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null || listX.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next(), str);
        }
    }
}
