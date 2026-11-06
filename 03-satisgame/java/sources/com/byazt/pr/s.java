package com.byazt.pr;

import android.os.RemoteException;
import com.byazt.ry.q;
import com.bytedance.pangle.ZeusPluginStateListener;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1943, 8})
public class s extends ZeusPluginStateListener {
    public final q n;
    public final int qg;

    public s(q qVar, int i) {
        this.n = qVar;
        this.qg = i;
    }

    public int n() {
        return this.qg;
    }

    @Override // com.bytedance.pangle.ZeusPluginStateListener
    public void onStateChangeOnCurThread(String str, int i, Object... objArr) {
        if (i == 5 || i == 7 || i == 6) {
            String strValueOf = "";
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        strValueOf = String.valueOf(objArr[0]);
                    }
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.n.n(str, i, strValueOf);
        }
    }
}
