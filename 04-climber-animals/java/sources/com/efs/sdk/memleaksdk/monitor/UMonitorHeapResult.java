package com.efs.sdk.memleaksdk.monitor;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.efs.sdk.memleaksdk.monitor.shark.g;

/* JADX INFO: loaded from: classes2.dex */
public class UMonitorHeapResult extends ResultReceiver {
    private a a;

    public interface a {
        void a();

        void b();
    }

    public UMonitorHeapResult() {
        super(null);
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        try {
            a aVar = this.a;
            if (aVar != null) {
                if (i == 1001) {
                    aVar.a();
                } else {
                    aVar.b();
                }
            }
        } catch (Throwable th) {
            g.b("UMonitorHeapResult", "onReceiveResult", th);
        }
    }
}
