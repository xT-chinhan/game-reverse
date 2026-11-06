package com.byazt.qep;

import android.os.RemoteException;
import com.byazt.ae.x;
import com.bytedance.pangle.ZeusPluginStateListener;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1973, 20})
public class hn extends ZeusPluginStateListener {
    public final int hw;
    public final x pr;

    public hn(x xVar, int i) {
        this.pr = xVar;
        this.hw = i;
    }

    public int pr() {
        return this.hw;
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
                } catch (RemoteException e) {
                    return;
                }
            }
            this.pr.pr(str, i, strValueOf);
        }
    }
}
