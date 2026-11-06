package com.taptap.sdk.login.internal.net;

import com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign;
import com.taptap.sdk.kit.internal.utils.PlatformXUA;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapSignLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J,\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/login/internal/net/TapSignLogin;", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign;", "()V", "getFixQueryParams", "", "", "getHeaders", "moduleName", "moduleVersion", "method", "handle", "", "data", "Lcom/taptap/sdk/kit/internal/http/hanlder/ITapHttpSign$HandleData;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapSignLogin implements ITapHttpSign {
    @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
    public void handle(ITapHttpSign.HandleData data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
    public Map<String, String> getHeaders(String moduleName, String moduleVersion, String method) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(moduleVersion, "moduleVersion");
        Intrinsics.checkNotNullParameter(method, "method");
        return MapsKt.mutableMapOf(TuplesKt.to("User-Agent", PlatformXUA.getTrackUA()));
    }

    @Override // com.taptap.sdk.kit.internal.http.hanlder.ITapHttpSign
    public Map<String, String> getFixQueryParams() {
        return MapsKt.emptyMap();
    }
}
