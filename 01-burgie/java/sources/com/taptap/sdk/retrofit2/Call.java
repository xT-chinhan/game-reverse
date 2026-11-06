package com.taptap.sdk.retrofit2;

import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okio.Timeout;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* JADX INFO: renamed from: clone */
    Call<T> m429clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
