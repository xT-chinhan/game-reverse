package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: com.unity3d.player.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0501h implements AssetPackStateUpdateListener {
    private HashSet a;
    private Looper b;
    final /* synthetic */ C0513n c;

    public C0501h(C0513n c0513n, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, Looper looper) {
        this.c = c0513n;
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add(iAssetPackManagerDownloadStatusCallback);
        this.b = looper;
    }

    public final synchronized void a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.a.add(iAssetPackManagerDownloadStatusCallback);
    }

    public final void onStateUpdate(Object obj) {
        AssetPackState assetPackState = (AssetPackState) obj;
        synchronized (this) {
            if (assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                synchronized (C0513n.d) {
                    this.c.b.remove(assetPackState.name());
                    if (this.c.b.isEmpty()) {
                        C0513n c0513n = this.c;
                        c0513n.a(c0513n.c);
                        this.c.c = null;
                    }
                }
            }
            if (this.a.size() != 0) {
                new Handler(this.b).post(new RunnableC0499g((Set) this.a.clone(), assetPackState.name(), assetPackState.status(), assetPackState.totalBytesToDownload(), assetPackState.bytesDownloaded(), assetPackState.transferProgressPercentage(), assetPackState.errorCode()));
            }
        }
    }
}
