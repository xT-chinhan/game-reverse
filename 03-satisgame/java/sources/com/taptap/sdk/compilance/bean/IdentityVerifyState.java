package com.taptap.sdk.compilance.bean;

import com.kwad.sdk.api.model.AdnName;
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

/* JADX INFO: compiled from: IdentityVerifyState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B;\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J!\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÇ\u0001R$\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006,"}, d2 = {"Lcom/taptap/sdk/compilance/bean/IdentityVerifyState;", "", "seen1", "", "verifyState", "", "accessToken", "ageLimit", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAccessToken$annotations", "()V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getAgeLimit$annotations", "getAgeLimit", "()I", "setAgeLimit", "(I)V", "getVerifyState$annotations", "getVerifyState", "setVerifyState", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class IdentityVerifyState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String accessToken;
    private int ageLimit;
    private String verifyState;

    public IdentityVerifyState() {
        this((String) null, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IdentityVerifyState copy$default(IdentityVerifyState identityVerifyState, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = identityVerifyState.verifyState;
        }
        if ((i2 & 2) != 0) {
            str2 = identityVerifyState.accessToken;
        }
        if ((i2 & 4) != 0) {
            i = identityVerifyState.ageLimit;
        }
        return identityVerifyState.copy(str, str2, i);
    }

    @SerialName("anti_addiction_token")
    public static /* synthetic */ void getAccessToken$annotations() {
    }

    @SerialName("age_limit")
    public static /* synthetic */ void getAgeLimit$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getVerifyState$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVerifyState() {
        return this.verifyState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAgeLimit() {
        return this.ageLimit;
    }

    public final IdentityVerifyState copy(String verifyState, String accessToken, int ageLimit) {
        Intrinsics.checkNotNullParameter(verifyState, "verifyState");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return new IdentityVerifyState(verifyState, accessToken, ageLimit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdentityVerifyState)) {
            return false;
        }
        IdentityVerifyState identityVerifyState = (IdentityVerifyState) other;
        return Intrinsics.areEqual(this.verifyState, identityVerifyState.verifyState) && Intrinsics.areEqual(this.accessToken, identityVerifyState.accessToken) && this.ageLimit == identityVerifyState.ageLimit;
    }

    public int hashCode() {
        return (((this.verifyState.hashCode() * 31) + this.accessToken.hashCode()) * 31) + Integer.hashCode(this.ageLimit);
    }

    public String toString() {
        return "IdentityVerifyState(verifyState=" + this.verifyState + ", accessToken=" + this.accessToken + ", ageLimit=" + this.ageLimit + ')';
    }

    /* JADX INFO: compiled from: IdentityVerifyState.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compilance/bean/IdentityVerifyState$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compilance/bean/IdentityVerifyState;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IdentityVerifyState> serializer() {
            return IdentityVerifyState$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ IdentityVerifyState(int i, @SerialName("status") String str, @SerialName("anti_addiction_token") String str2, @SerialName("age_limit") int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, IdentityVerifyState$$serializer.INSTANCE.getDescriptor());
        }
        this.verifyState = (i & 1) == 0 ? IdentityVerifyStateKt.VERIFY_STATE_FAILED : str;
        if ((i & 2) == 0) {
            this.accessToken = "";
        } else {
            this.accessToken = str2;
        }
        if ((i & 4) == 0) {
            this.ageLimit = 0;
        } else {
            this.ageLimit = i2;
        }
    }

    public IdentityVerifyState(String verifyState, String accessToken, int i) {
        Intrinsics.checkNotNullParameter(verifyState, "verifyState");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        this.verifyState = verifyState;
        this.accessToken = accessToken;
        this.ageLimit = i;
    }

    @JvmStatic
    public static final void write$Self(IdentityVerifyState self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.verifyState, IdentityVerifyStateKt.VERIFY_STATE_FAILED)) {
            output.encodeStringElement(serialDesc, 0, self.verifyState);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.accessToken, "")) {
            output.encodeStringElement(serialDesc, 1, self.accessToken);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.ageLimit != 0) {
            output.encodeIntElement(serialDesc, 2, self.ageLimit);
        }
    }

    public /* synthetic */ IdentityVerifyState(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? IdentityVerifyStateKt.VERIFY_STATE_FAILED : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i);
    }

    public final String getVerifyState() {
        return this.verifyState;
    }

    public final void setVerifyState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verifyState = str;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessToken = str;
    }

    public final int getAgeLimit() {
        return this.ageLimit;
    }

    public final void setAgeLimit(int i) {
        this.ageLimit = i;
    }
}
