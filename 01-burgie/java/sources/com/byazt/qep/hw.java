package com.byazt.qep;

import android.os.RemoteException;
import com.byazt.ae.g;
import com.byazt.ae.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1973, 13})
public class hw extends x.pr {
    public final g pr;

    public hw(g gVar) {
        this.pr = gVar;
    }

    @Override // com.byazt.ae.x
    public void pr(String str, int i, String str2) throws RemoteException {
        g gVar = this.pr;
        if (gVar != null) {
            gVar.pr(str, i, str2);
        }
    }
}
