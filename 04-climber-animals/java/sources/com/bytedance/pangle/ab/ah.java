package com.bytedance.pangle.ab;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.d;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ZeusPluginStateListener {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final d f609ms;
    private final int xr;

    public ah(d dVar, int i) {
        this.f609ms = dVar;
        this.xr = i;
    }

    public int ms() {
        return this.xr;
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
            this.f609ms.ms(str, i, strValueOf);
        }
    }
}
