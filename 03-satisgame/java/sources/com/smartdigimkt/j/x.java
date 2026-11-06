package com.smartdigimkt.j;

import android.os.SystemClock;
import com.smartdigimkt.dlopt.api.CustomAdapterDownloadListener;
import com.smartdigimkt.dlopt.api.SDMAppDownloadListener;
import com.smartdigimkt.sdk.api.SDMEventInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements CustomAdapterDownloadListener {
    public final WeakReference a;
    public long b;
    public boolean c;
    public boolean d;

    public x(SDMEventInterface sDMEventInterface) {
        if (sDMEventInterface == null || !(sDMEventInterface instanceof SDMAppDownloadListener)) {
            return;
        }
        this.a = new WeakReference((SDMAppDownloadListener) sDMEventInterface);
    }

    @Override // com.smartdigimkt.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadFail(long j, long j2, String str, String str2) {
        WeakReference weakReference = this.a;
        SDMAppDownloadListener sDMAppDownloadListener = weakReference != null ? (SDMAppDownloadListener) weakReference.get() : null;
        if (sDMAppDownloadListener != null) {
            sDMAppDownloadListener.onDownloadFail(j, j2, str, str2);
        }
    }

    @Override // com.smartdigimkt.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadFinish(long j, String str, String str2) {
        if (this.b != 0 && !this.d) {
            this.d = true;
            SystemClock.elapsedRealtime();
            com.smartdigimkt.q3.f.a().c(new w());
        }
        WeakReference weakReference = this.a;
        SDMAppDownloadListener sDMAppDownloadListener = weakReference != null ? (SDMAppDownloadListener) weakReference.get() : null;
        if (sDMAppDownloadListener != null) {
            sDMAppDownloadListener.onDownloadFinish(j, str, str2);
        }
    }

    @Override // com.smartdigimkt.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadPause(long j, long j2, String str, String str2) {
        WeakReference weakReference = this.a;
        SDMAppDownloadListener sDMAppDownloadListener = weakReference != null ? (SDMAppDownloadListener) weakReference.get() : null;
        if (sDMAppDownloadListener != null) {
            sDMAppDownloadListener.onDownloadPause(j, j2, str, str2);
        }
    }

    @Override // com.smartdigimkt.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadStart(long j, long j2, String str, String str2) {
        this.b = SystemClock.elapsedRealtime();
        com.smartdigimkt.q3.f.a().c(new w());
        WeakReference weakReference = this.a;
        SDMAppDownloadListener sDMAppDownloadListener = weakReference != null ? (SDMAppDownloadListener) weakReference.get() : null;
        if (sDMAppDownloadListener != null) {
            sDMAppDownloadListener.onDownloadStart(j, j2, str, str2);
        }
    }

    @Override // com.smartdigimkt.dlopt.api.CustomAdapterDownloadListener
    public final void onDownloadUpdate(long j, long j2, String str, String str2) {
        WeakReference weakReference = this.a;
        SDMAppDownloadListener sDMAppDownloadListener = weakReference != null ? (SDMAppDownloadListener) weakReference.get() : null;
        if (sDMAppDownloadListener != null) {
            sDMAppDownloadListener.onDownloadUpdate(j, j2, str, str2);
        }
    }

    @Override // com.smartdigimkt.dlopt.api.CustomAdapterDownloadListener
    public final void onInstalled(String str, String str2) {
        if (!this.c) {
            this.c = true;
            com.smartdigimkt.q3.f.a().c(new w());
        }
        WeakReference weakReference = this.a;
        SDMAppDownloadListener sDMAppDownloadListener = weakReference != null ? (SDMAppDownloadListener) weakReference.get() : null;
        if (sDMAppDownloadListener != null) {
            sDMAppDownloadListener.onInstalled(str, str2);
        }
    }
}
