package com.bytedance.pangle.ab;

import android.os.RemoteException;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.d;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends d.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ZeusPluginInstallListener f616ms;

    public xr(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.f616ms = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.d
    public void ms(String str, int i, String str2) throws RemoteException {
        ZeusPluginInstallListener zeusPluginInstallListener = this.f616ms;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i, str2);
        }
    }
}
