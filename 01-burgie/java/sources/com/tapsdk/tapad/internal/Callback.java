package com.tapsdk.tapad.internal;

/* JADX INFO: loaded from: classes2.dex */
public interface Callback<T> {
    void onFail(Exception exc);

    void onSuccess(T t);
}
