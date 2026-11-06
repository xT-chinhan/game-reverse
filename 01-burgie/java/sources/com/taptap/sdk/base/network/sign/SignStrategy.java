package com.taptap.sdk.base.network.sign;

import com.taptap.sdk.okhttp3.Headers;
import com.taptap.sdk.okhttp3.HttpUrl;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import kotlin.Metadata;

/* JADX INFO: compiled from: SignStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/base/network/sign/SignStrategy;", "", "calculate", "", BreakpointSQLiteKey.URL, "Lcom/taptap/sdk/okhttp3/HttpUrl;", "method", "headers", "Lcom/taptap/sdk/okhttp3/Headers;", "content", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SignStrategy {
    String calculate(HttpUrl url, String method, Headers headers, String content);
}
