package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.unity3d.player.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
final class C0507k implements OnCompleteListener {
    private IAssetPackManagerDownloadStatusCallback a;
    private Looper b = Looper.myLooper();
    private String c;

    public C0507k(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.a = iAssetPackManagerDownloadStatusCallback;
        this.c = str;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map mapPackStates = assetPackStates.packStates();
            if (mapPackStates.size() == 0) {
                return;
            }
            for (AssetPackState assetPackState : mapPackStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                    String strName = assetPackState.name();
                    int iStatus = assetPackState.status();
                    int iErrorCode = assetPackState.errorCode();
                    long j = assetPackStates.totalBytes();
                    new Handler(this.b).post(new RunnableC0499g(Collections.singleton(this.a), strName, iStatus, j, iStatus == 4 ? j : 0L, 0, iErrorCode));
                } else {
                    C0513n c0513n = C0513n.d;
                    String strName2 = assetPackState.name();
                    IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.a;
                    Looper looper = this.b;
                    c0513n.getClass();
                    synchronized (C0513n.d) {
                        Object obj = c0513n.c;
                        if (obj == null) {
                            C0501h c0501h = new C0501h(c0513n, iAssetPackManagerDownloadStatusCallback, looper);
                            c0513n.a.registerListener(c0501h);
                            c0513n.c = c0501h;
                        } else {
                            ((C0501h) obj).a(iAssetPackManagerDownloadStatusCallback);
                        }
                        c0513n.b.add(strName2);
                        c0513n.a.fetch(Collections.singletonList(strName2));
                    }
                }
            }
        } catch (RuntimeExecutionException e) {
            e = e;
            String str = this.c;
            while (true) {
                if (e instanceof AssetPackException) {
                    errorCode = e.getErrorCode();
                    break;
                }
                e = e.getCause();
                if (e == null) {
                    errorCode = -100;
                    break;
                }
            }
            new Handler(this.b).post(new RunnableC0499g(Collections.singleton(this.a), str, 0, 0L, 0L, 0, errorCode));
        }
    }
}
