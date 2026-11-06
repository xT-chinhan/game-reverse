package com.taptap.sdk.kit.internal.service;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;

/* JADX INFO: compiled from: AuthService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/kit/internal/service/AuthService;", "", "obtainAuthorization", "", ImagesContract.URL, "method", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface AuthService {
    String obtainAuthorization(String url, String method);
}
