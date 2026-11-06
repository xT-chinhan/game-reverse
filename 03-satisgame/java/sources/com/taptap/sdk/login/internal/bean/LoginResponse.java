package com.taptap.sdk.login.internal.bean;

import android.os.Bundle;
import com.anythink.core.common.h.au;
import com.anythink.core.common.l.f;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.AccessToken$$serializer;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: LoginResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234B_\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBI\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003JM\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J!\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÇ\u0001R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010 ¨\u00065"}, d2 = {"Lcom/taptap/sdk/login/internal/bean/LoginResponse;", "", "seen1", "", "id", "", au.b.a, "Lcom/taptap/sdk/login/AccessToken;", "code", "errorMessage", "cancel", "", "serverUri", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/taptap/sdk/login/AccessToken;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/taptap/sdk/login/AccessToken;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCancel$annotations", "()V", "getCancel", "()Z", "getCode$annotations", "getCode", "()Ljava/lang/String;", "getErrorMessage$annotations", "getErrorMessage", "getId$annotations", "getId", "getServerUri$annotations", "getServerUri", "getToken$annotations", "getToken", "()Lcom/taptap/sdk/login/AccessToken;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class LoginResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String RES_KEY_CANCEL = "com.taptap.sdk.response.cancel";
    public static final String RES_KEY_CODE = "com.taptap.sdk.response.code";
    public static final String RES_KEY_ERROR = "com.taptap.sdk.response.error";
    public static final String RES_KEY_SERVER_URI = "com.taptap.sdk.response.server_uri";
    public static final String RES_KEY_STATE = "com.taptap.sdk.response.state";
    public static final String RES_KEY_TOKEN = "com.taptap.sdk.response.token";
    public static final String RES_KEY_TOKEN_PARCELABLE = "com.taptap.sdk.response.token.parcel";
    private final boolean cancel;
    private final String code;
    private final String errorMessage;
    private final String id;
    private final String serverUri;
    private final AccessToken token;

    public LoginResponse() {
        this((String) null, (AccessToken) null, (String) null, (String) null, false, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LoginResponse copy$default(LoginResponse loginResponse, String str, AccessToken accessToken, String str2, String str3, boolean z, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginResponse.id;
        }
        if ((i & 2) != 0) {
            accessToken = loginResponse.token;
        }
        AccessToken accessToken2 = accessToken;
        if ((i & 4) != 0) {
            str2 = loginResponse.code;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = loginResponse.errorMessage;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            z = loginResponse.cancel;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str4 = loginResponse.serverUri;
        }
        return loginResponse.copy(str, accessToken2, str5, str6, z2, str4);
    }

    @SerialName("cancel")
    public static /* synthetic */ void getCancel$annotations() {
    }

    @SerialName("code")
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName("error_message")
    public static /* synthetic */ void getErrorMessage$annotations() {
    }

    @SerialName(WebLoginFragment.QUERY_KEY_ID)
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("server_uri")
    public static /* synthetic */ void getServerUri$annotations() {
    }

    @SerialName(au.b.a)
    public static /* synthetic */ void getToken$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AccessToken getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCancel() {
        return this.cancel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getServerUri() {
        return this.serverUri;
    }

    public final LoginResponse copy(String id, AccessToken token, String code, String errorMessage, boolean cancel, String serverUri) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new LoginResponse(id, token, code, errorMessage, cancel, serverUri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginResponse)) {
            return false;
        }
        LoginResponse loginResponse = (LoginResponse) other;
        return Intrinsics.areEqual(this.id, loginResponse.id) && Intrinsics.areEqual(this.token, loginResponse.token) && Intrinsics.areEqual(this.code, loginResponse.code) && Intrinsics.areEqual(this.errorMessage, loginResponse.errorMessage) && this.cancel == loginResponse.cancel && Intrinsics.areEqual(this.serverUri, loginResponse.serverUri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        AccessToken accessToken = this.token;
        int iHashCode2 = (iHashCode + (accessToken == null ? 0 : accessToken.hashCode())) * 31;
        String str = this.code;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorMessage;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.cancel;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode4 + r1) * 31;
        String str3 = this.serverUri;
        return i + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "LoginResponse(id=" + this.id + ", token=" + this.token + ", code=" + this.code + ", errorMessage=" + this.errorMessage + ", cancel=" + this.cancel + ", serverUri=" + this.serverUri + ')';
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LoginResponse(int i, @SerialName(WebLoginFragment.QUERY_KEY_ID) String str, @SerialName(au.b.a) AccessToken accessToken, @SerialName("code") String str2, @SerialName("error_message") String str3, @SerialName("cancel") boolean z, @SerialName("server_uri") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, LoginResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.token = null;
        } else {
            this.token = accessToken;
        }
        if ((i & 4) == 0) {
            this.code = null;
        } else {
            this.code = str2;
        }
        if ((i & 8) == 0) {
            this.errorMessage = null;
        } else {
            this.errorMessage = str3;
        }
        if ((i & 16) == 0) {
            this.cancel = false;
        } else {
            this.cancel = z;
        }
        if ((i & 32) == 0) {
            this.serverUri = null;
        } else {
            this.serverUri = str4;
        }
    }

    public LoginResponse(String id, AccessToken accessToken, String str, String str2, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.token = accessToken;
        this.code = str;
        this.errorMessage = str2;
        this.cancel = z;
        this.serverUri = str3;
    }

    @JvmStatic
    public static final void write$Self(LoginResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.id, "")) {
            output.encodeStringElement(serialDesc, 0, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.token != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, AccessToken$$serializer.INSTANCE, self.token);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.code != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.code);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.errorMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.errorMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.cancel) {
            output.encodeBooleanElement(serialDesc, 4, self.cancel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.serverUri != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.serverUri);
        }
    }

    public /* synthetic */ LoginResponse(String str, AccessToken accessToken, String str2, String str3, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : accessToken, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? false : z, (i & 32) == 0 ? str4 : null);
    }

    public final String getId() {
        return this.id;
    }

    public final AccessToken getToken() {
        return this.token;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getCancel() {
        return this.cancel;
    }

    public final String getServerUri() {
        return this.serverUri;
    }

    /* JADX INFO: compiled from: LoginResponse.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010HÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/login/internal/bean/LoginResponse$Companion;", "", "()V", "RES_KEY_CANCEL", "", "RES_KEY_CODE", "RES_KEY_ERROR", "RES_KEY_SERVER_URI", "RES_KEY_STATE", "RES_KEY_TOKEN", "RES_KEY_TOKEN_PARCELABLE", "parseFromBundle", "Lcom/taptap/sdk/login/internal/bean/LoginResponse;", f.R, "Landroid/os/Bundle;", "serializer", "Lkotlinx/serialization/KSerializer;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LoginResponse> serializer() {
            return LoginResponse$$serializer.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0056  */
        public final LoginResponse parseFromBundle(Bundle data) {
            AccessToken accessToken;
            Intrinsics.checkNotNullParameter(data, "data");
            String string = data.getString(LoginResponse.RES_KEY_STATE);
            Object objDecodeFromString = null;
            if (string == null) {
                return null;
            }
            String string2 = data.getString(LoginResponse.RES_KEY_TOKEN);
            if (string2 == null) {
                accessToken = (AccessToken) data.getParcelable(LoginResponse.RES_KEY_TOKEN_PARCELABLE);
            } else {
                TapJson tapJson = TapJson.INSTANCE;
                if (!(string2.length() == 0)) {
                    try {
                        Json json = tapJson.getJson();
                        KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(AccessToken.class));
                        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        objDecodeFromString = json.decodeFromString(kSerializerSerializer, string2);
                    } catch (Exception e) {
                        TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
                    }
                }
                accessToken = (AccessToken) objDecodeFromString;
                if (accessToken == null) {
                    accessToken = (AccessToken) data.getParcelable(LoginResponse.RES_KEY_TOKEN_PARCELABLE);
                }
            }
            return new LoginResponse(string, accessToken, data.getString(LoginResponse.RES_KEY_CODE), data.getString(LoginResponse.RES_KEY_ERROR), data.getBoolean(LoginResponse.RES_KEY_CANCEL, false), data.getString(LoginResponse.RES_KEY_SERVER_URI));
        }
    }
}
