package com.unity3d.player;

/* JADX INFO: loaded from: classes4.dex */
public interface IPermissionRequestCallbacks {
    void onPermissionDenied(String str);

    void onPermissionDeniedAndDontAskAgain(String str);

    void onPermissionGranted(String str);
}
