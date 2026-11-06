package com.mar.sdk.permission;

/* JADX INFO: loaded from: classes2.dex */
public interface IPermissionResultListener {
    void onPermissionCanceled();

    void onPermissionFailed(String[] strArr, String[] strArr2);

    void onPermissionSuccess();
}
