package com.taptap.sdk.services;

import com.taptap.sdk.common.services.AuthorizationService;
import com.taptap.sdk.login.api.LoginService;
import com.taptap.sdk.login.impl.service.AuthorizationServiceImpl;
import com.taptap.sdk.login.impl.service.LoginServiceImpl;
import com.taptap.sdk.servicemanager.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: Sdk_tap_login_ServiceFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00070\u0004¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/services/Sdk_tap_login_ServiceFactory;", "", "()V", "provide", "", "Ljava/lang/Class;", "Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Sdk_tap_login_ServiceFactory {
    public final Map<Class<? extends ServiceManager.Service>, Set<Class<? extends ServiceManager.Service>>> provide() {
        Object answer$iv;
        Object answer$iv2;
        Map result = new LinkedHashMap();
        Object value$iv = result.get(AuthorizationService.class);
        if (value$iv == null) {
            answer$iv = SetsKt.emptySet();
            result.put(AuthorizationService.class, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        Pair pair = TuplesKt.to(AuthorizationService.class, SetsKt.plus((Set<? extends Class>) answer$iv, AuthorizationServiceImpl.class));
        result.put(pair.getFirst(), pair.getSecond());
        Object value$iv2 = result.get(LoginService.class);
        if (value$iv2 == null) {
            answer$iv2 = SetsKt.emptySet();
            result.put(LoginService.class, answer$iv2);
        } else {
            answer$iv2 = value$iv2;
        }
        Pair pair2 = TuplesKt.to(LoginService.class, SetsKt.plus((Set<? extends Class>) answer$iv2, LoginServiceImpl.class));
        result.put(pair2.getFirst(), pair2.getSecond());
        return result;
    }
}
