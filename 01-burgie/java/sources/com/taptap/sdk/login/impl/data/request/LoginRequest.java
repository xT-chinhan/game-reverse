package com.taptap.sdk.login.impl.data.request;

import com.byazt.mg.PluginConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: LoginRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212Ba\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001J&\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÁ\u0001¢\u0006\u0002\b0R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012¨\u00063"}, d2 = {"Lcom/taptap/sdk/login/impl/data/request/LoginRequest;", "", "seen1", "", PluginConstants.KEY_ERROR_CODE, "", "codeVerifier", "redirectUri", "sessionId", "sessionType", "info", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode$annotations", "()V", "getCode", "()Ljava/lang/String;", "getCodeVerifier$annotations", "getCodeVerifier", "getInfo$annotations", "getInfo", "getRedirectUri$annotations", "getRedirectUri", "getSessionId$annotations", "getSessionId", "getSessionType$annotations", "getSessionType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class LoginRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String code;
    private final String codeVerifier;
    private final String info;
    private final String redirectUri;
    private final String sessionId;
    private final String sessionType;

    public static /* synthetic */ LoginRequest copy$default(LoginRequest loginRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginRequest.code;
        }
        if ((i & 2) != 0) {
            str2 = loginRequest.codeVerifier;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = loginRequest.redirectUri;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = loginRequest.sessionId;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = loginRequest.sessionType;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = loginRequest.info;
        }
        return loginRequest.copy(str, str7, str8, str9, str10, str6);
    }

    @SerialName(PluginConstants.KEY_ERROR_CODE)
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName("code_verifier")
    public static /* synthetic */ void getCodeVerifier$annotations() {
    }

    @SerialName("info")
    public static /* synthetic */ void getInfo$annotations() {
    }

    @SerialName("redirect_uri")
    public static /* synthetic */ void getRedirectUri$annotations() {
    }

    @SerialName("session_id")
    public static /* synthetic */ void getSessionId$annotations() {
    }

    @SerialName("session_type")
    public static /* synthetic */ void getSessionType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRedirectUri() {
        return this.redirectUri;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSessionType() {
        return this.sessionType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    public final LoginRequest copy(String code, String codeVerifier, String redirectUri, String sessionId, String sessionType, String info) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(info, "info");
        return new LoginRequest(code, codeVerifier, redirectUri, sessionId, sessionType, info);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginRequest)) {
            return false;
        }
        LoginRequest loginRequest = (LoginRequest) other;
        return Intrinsics.areEqual(this.code, loginRequest.code) && Intrinsics.areEqual(this.codeVerifier, loginRequest.codeVerifier) && Intrinsics.areEqual(this.redirectUri, loginRequest.redirectUri) && Intrinsics.areEqual(this.sessionId, loginRequest.sessionId) && Intrinsics.areEqual(this.sessionType, loginRequest.sessionType) && Intrinsics.areEqual(this.info, loginRequest.info);
    }

    public int hashCode() {
        return (((((((((this.code.hashCode() * 31) + this.codeVerifier.hashCode()) * 31) + this.redirectUri.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.sessionType.hashCode()) * 31) + this.info.hashCode();
    }

    public String toString() {
        return "LoginRequest(code=" + this.code + ", codeVerifier=" + this.codeVerifier + ", redirectUri=" + this.redirectUri + ", sessionId=" + this.sessionId + ", sessionType=" + this.sessionType + ", info=" + this.info + ')';
    }

    /* JADX INFO: compiled from: LoginRequest.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/request/LoginRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/request/LoginRequest;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LoginRequest> serializer() {
            return LoginRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LoginRequest(int seen1, @SerialName(PluginConstants.KEY_ERROR_CODE) String code, @SerialName("code_verifier") String codeVerifier, @SerialName("redirect_uri") String redirectUri, @SerialName("session_id") String sessionId, @SerialName("session_type") String sessionType, @SerialName("info") String info, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (seen1 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 63, LoginRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.code = code;
        this.codeVerifier = codeVerifier;
        this.redirectUri = redirectUri;
        this.sessionId = sessionId;
        this.sessionType = sessionType;
        this.info = info;
    }

    public LoginRequest(String code, String codeVerifier, String redirectUri, String sessionId, String sessionType, String info) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(info, "info");
        this.code = code;
        this.codeVerifier = codeVerifier;
        this.redirectUri = redirectUri;
        this.sessionId = sessionId;
        this.sessionType = sessionType;
        this.info = info;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_login_release(LoginRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.code);
        output.encodeStringElement(serialDesc, 1, self.codeVerifier);
        output.encodeStringElement(serialDesc, 2, self.redirectUri);
        output.encodeStringElement(serialDesc, 3, self.sessionId);
        output.encodeStringElement(serialDesc, 4, self.sessionType);
        output.encodeStringElement(serialDesc, 5, self.info);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionType() {
        return this.sessionType;
    }

    public final String getInfo() {
        return this.info;
    }
}
