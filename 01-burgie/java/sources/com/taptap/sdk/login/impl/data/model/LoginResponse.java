package com.taptap.sdk.login.impl.data.model;

import com.byazt.mg.PluginConstants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.AccessToken$$serializer;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: LoginResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245B_\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBI\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003JM\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÁ\u0001¢\u0006\u0002\b3R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010 ¨\u00066"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/LoginResponse;", "", "seen1", "", "id", "", "token", "Lcom/taptap/sdk/login/AccessToken;", PluginConstants.KEY_ERROR_CODE, "errorMessage", TrackAction.CANCEL, "", "serverUri", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/taptap/sdk/login/AccessToken;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Lcom/taptap/sdk/login/AccessToken;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCancel$annotations", "()V", "getCancel", "()Z", "getCode$annotations", "getCode", "()Ljava/lang/String;", "getErrorMessage$annotations", "getErrorMessage", "getId$annotations", "getId", "getServerUri$annotations", "getServerUri", "getToken$annotations", "getToken", "()Lcom/taptap/sdk/login/AccessToken;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class LoginResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    @SerialName(TrackAction.CANCEL)
    public static /* synthetic */ void getCancel$annotations() {
    }

    @SerialName(PluginConstants.KEY_ERROR_CODE)
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName("error_message")
    public static /* synthetic */ void getErrorMessage$annotations() {
    }

    @SerialName("state")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("server_uri")
    public static /* synthetic */ void getServerUri$annotations() {
    }

    @SerialName("token")
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

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        AccessToken accessToken = this.token;
        int iHashCode2 = (iHashCode + (accessToken == null ? 0 : accessToken.hashCode())) * 31;
        String str = this.code;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorMessage;
        int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.cancel)) * 31;
        String str3 = this.serverUri;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "LoginResponse(id=" + this.id + ", token=" + this.token + ", code=" + this.code + ", errorMessage=" + this.errorMessage + ", cancel=" + this.cancel + ", serverUri=" + this.serverUri + ')';
    }

    /* JADX INFO: compiled from: LoginResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/LoginResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/LoginResponse;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LoginResponse> serializer() {
            return LoginResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LoginResponse(int seen1, @SerialName("state") String id, @SerialName("token") AccessToken token, @SerialName(PluginConstants.KEY_ERROR_CODE) String code, @SerialName("error_message") String errorMessage, @SerialName(TrackAction.CANCEL) boolean cancel, @SerialName("server_uri") String serverUri, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, LoginResponse$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.id = "";
        } else {
            this.id = id;
        }
        if ((seen1 & 2) == 0) {
            this.token = null;
        } else {
            this.token = token;
        }
        if ((seen1 & 4) == 0) {
            this.code = null;
        } else {
            this.code = code;
        }
        if ((seen1 & 8) == 0) {
            this.errorMessage = null;
        } else {
            this.errorMessage = errorMessage;
        }
        if ((seen1 & 16) == 0) {
            this.cancel = false;
        } else {
            this.cancel = cancel;
        }
        if ((seen1 & 32) == 0) {
            this.serverUri = null;
        } else {
            this.serverUri = serverUri;
        }
    }

    public LoginResponse(String id, AccessToken token, String code, String errorMessage, boolean cancel, String serverUri) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.token = token;
        this.code = code;
        this.errorMessage = errorMessage;
        this.cancel = cancel;
        this.serverUri = serverUri;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_login_release(LoginResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.id, "");
        if (z) {
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
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 4) || self.cancel;
        if (z2) {
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
}
