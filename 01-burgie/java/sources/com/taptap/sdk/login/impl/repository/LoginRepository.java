package com.taptap.sdk.login.impl.repository;

import android.os.Build;
import com.byazt.mg.PluginConstants;
import com.taptap.sdk.initializer.api.option.TapTapSdkOptions;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.impl.data.request.LoginRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: LoginRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ6\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/login/impl/repository/LoginRepository;", "", "loginApiService", "Lcom/taptap/sdk/login/impl/repository/LoginApiService;", "(Lcom/taptap/sdk/login/impl/repository/LoginApiService;)V", "generateInfo", "", "loginByToken", "Lcom/taptap/sdk/login/PrivateTapSdkAccount;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginWithCode", PluginConstants.KEY_ERROR_CODE, "codeVerifier", "redirectUri", "sessionId", "sessionType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LoginRepository {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile LoginRepository INSTANCE;
    private final LoginApiService loginApiService;

    public /* synthetic */ LoginRepository(LoginApiService loginApiService, DefaultConstructorMarker defaultConstructorMarker) {
        this(loginApiService);
    }

    private LoginRepository(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }

    public final Object loginWithCode(String code, String codeVerifier, String redirectUri, String sessionId, String sessionType, Continuation<? super PrivateTapSdkAccount> continuation) {
        return this.loginApiService.loginByCode(new LoginRequest(code, codeVerifier, redirectUri, sessionId, sessionType, generateInfo()), continuation);
    }

    public final Object loginByToken(Continuation<? super PrivateTapSdkAccount> continuation) {
        return this.loginApiService.loginByToken(MapsKt.mapOf(TuplesKt.to("info", generateInfo())), continuation);
    }

    private final String generateInfo() {
        StringFormat $this$encodeToString$iv = Json.INSTANCE;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("device_id", Build.MANUFACTURER + ' ' + Build.MODEL), TuplesKt.to("uuid", TapIdentifierUtil.INSTANCE.getInstallUUID()));
        SerializersModule $this$serializer$iv$iv = $this$encodeToString$iv.getSerializersModule();
        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv, Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class))));
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return $this$encodeToString$iv.encodeToString(kSerializerSerializer, mapMapOf);
    }

    /* JADX INFO: compiled from: LoginRepository.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/login/impl/repository/LoginRepository$Companion;", "", "()V", "INSTANCE", "Lcom/taptap/sdk/login/impl/repository/LoginRepository;", "create", "getInstance", "options", "Lcom/taptap/sdk/initializer/api/option/TapTapSdkOptions;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginRepository getInstance(TapTapSdkOptions options) {
            LoginRepository it;
            Intrinsics.checkNotNullParameter(options, "options");
            LoginRepository loginRepository = LoginRepository.INSTANCE;
            if (loginRepository != null) {
                return loginRepository;
            }
            synchronized (this) {
                it = LoginRepository.INSTANCE;
                if (it == null) {
                    it = LoginRepository.INSTANCE.create();
                    Companion companion = LoginRepository.INSTANCE;
                    LoginRepository.INSTANCE = it;
                }
            }
            return it;
        }

        private final LoginRepository create() {
            return new LoginRepository(LoginApiServiceProviderKt.provideLoginApiService(), null);
        }
    }
}
