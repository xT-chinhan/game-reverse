package com.byazt.pr;

import android.os.RemoteException;
import com.byazt.ry.q;
import com.byazt.ry.sz;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1943, 26})
public class qg extends q.n {
    public final sz n;

    public qg(sz szVar) {
        this.n = szVar;
    }

    @Override // com.byazt.ry.q
    public void n(String str, int i, String str2) throws RemoteException {
        sz szVar = this.n;
        if (szVar != null) {
            szVar.n(str, i, str2);
        }
    }
}
