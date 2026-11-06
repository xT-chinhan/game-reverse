package com.taptap.sdk.compliance.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
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

/* JADX INFO: compiled from: RealNameConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J!\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÇ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010¨\u0006+"}, d2 = {"Lcom/taptap/sdk/compliance/bean/RealNameText;", "", "seen1", "", "tapAuth", "Lcom/taptap/sdk/compliance/bean/Prompt;", "manualAuth", "authWaiting", "authFailed", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/compliance/bean/Prompt;Lcom/taptap/sdk/compliance/bean/Prompt;Lcom/taptap/sdk/compliance/bean/Prompt;Lcom/taptap/sdk/compliance/bean/Prompt;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/compliance/bean/Prompt;Lcom/taptap/sdk/compliance/bean/Prompt;Lcom/taptap/sdk/compliance/bean/Prompt;Lcom/taptap/sdk/compliance/bean/Prompt;)V", "getAuthFailed$annotations", "()V", "getAuthFailed", "()Lcom/taptap/sdk/compliance/bean/Prompt;", "getAuthWaiting$annotations", "getAuthWaiting", "getManualAuth$annotations", "getManualAuth", "getTapAuth$annotations", "getTapAuth", "component1", "component2", "component3", "component4", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class RealNameText {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Prompt authFailed;
    private final Prompt authWaiting;
    private final Prompt manualAuth;
    private final Prompt tapAuth;

    public RealNameText() {
        this((Prompt) null, (Prompt) null, (Prompt) null, (Prompt) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RealNameText copy$default(RealNameText realNameText, Prompt prompt, Prompt prompt2, Prompt prompt3, Prompt prompt4, int i, Object obj) {
        if ((i & 1) != 0) {
            prompt = realNameText.tapAuth;
        }
        if ((i & 2) != 0) {
            prompt2 = realNameText.manualAuth;
        }
        if ((i & 4) != 0) {
            prompt3 = realNameText.authWaiting;
        }
        if ((i & 8) != 0) {
            prompt4 = realNameText.authFailed;
        }
        return realNameText.copy(prompt, prompt2, prompt3, prompt4);
    }

    @SerialName("auth_failed")
    public static /* synthetic */ void getAuthFailed$annotations() {
    }

    @SerialName("auth_waiting")
    public static /* synthetic */ void getAuthWaiting$annotations() {
    }

    @SerialName("manual_auth")
    public static /* synthetic */ void getManualAuth$annotations() {
    }

    @SerialName("taptap_auth")
    public static /* synthetic */ void getTapAuth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Prompt getTapAuth() {
        return this.tapAuth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Prompt getManualAuth() {
        return this.manualAuth;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Prompt getAuthWaiting() {
        return this.authWaiting;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Prompt getAuthFailed() {
        return this.authFailed;
    }

    public final RealNameText copy(Prompt tapAuth, Prompt manualAuth, Prompt authWaiting, Prompt authFailed) {
        return new RealNameText(tapAuth, manualAuth, authWaiting, authFailed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RealNameText)) {
            return false;
        }
        RealNameText realNameText = (RealNameText) other;
        return Intrinsics.areEqual(this.tapAuth, realNameText.tapAuth) && Intrinsics.areEqual(this.manualAuth, realNameText.manualAuth) && Intrinsics.areEqual(this.authWaiting, realNameText.authWaiting) && Intrinsics.areEqual(this.authFailed, realNameText.authFailed);
    }

    public int hashCode() {
        Prompt prompt = this.tapAuth;
        int iHashCode = (prompt == null ? 0 : prompt.hashCode()) * 31;
        Prompt prompt2 = this.manualAuth;
        int iHashCode2 = (iHashCode + (prompt2 == null ? 0 : prompt2.hashCode())) * 31;
        Prompt prompt3 = this.authWaiting;
        int iHashCode3 = (iHashCode2 + (prompt3 == null ? 0 : prompt3.hashCode())) * 31;
        Prompt prompt4 = this.authFailed;
        return iHashCode3 + (prompt4 != null ? prompt4.hashCode() : 0);
    }

    public String toString() {
        return "RealNameText(tapAuth=" + this.tapAuth + ", manualAuth=" + this.manualAuth + ", authWaiting=" + this.authWaiting + ", authFailed=" + this.authFailed + ')';
    }

    /* JADX INFO: compiled from: RealNameConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/RealNameText$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/RealNameText;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RealNameText> serializer() {
            return RealNameText$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RealNameText(int i, @SerialName("taptap_auth") Prompt prompt, @SerialName("manual_auth") Prompt prompt2, @SerialName("auth_waiting") Prompt prompt3, @SerialName("auth_failed") Prompt prompt4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, RealNameText$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.tapAuth = null;
        } else {
            this.tapAuth = prompt;
        }
        if ((i & 2) == 0) {
            this.manualAuth = null;
        } else {
            this.manualAuth = prompt2;
        }
        if ((i & 4) == 0) {
            this.authWaiting = null;
        } else {
            this.authWaiting = prompt3;
        }
        if ((i & 8) == 0) {
            this.authFailed = null;
        } else {
            this.authFailed = prompt4;
        }
    }

    public RealNameText(Prompt prompt, Prompt prompt2, Prompt prompt3, Prompt prompt4) {
        this.tapAuth = prompt;
        this.manualAuth = prompt2;
        this.authWaiting = prompt3;
        this.authFailed = prompt4;
    }

    @JvmStatic
    public static final void write$Self(RealNameText self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.tapAuth != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, Prompt$$serializer.INSTANCE, self.tapAuth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.manualAuth != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, Prompt$$serializer.INSTANCE, self.manualAuth);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.authWaiting != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, Prompt$$serializer.INSTANCE, self.authWaiting);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.authFailed != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, Prompt$$serializer.INSTANCE, self.authFailed);
        }
    }

    public /* synthetic */ RealNameText(Prompt prompt, Prompt prompt2, Prompt prompt3, Prompt prompt4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : prompt, (i & 2) != 0 ? null : prompt2, (i & 4) != 0 ? null : prompt3, (i & 8) != 0 ? null : prompt4);
    }

    public final Prompt getTapAuth() {
        return this.tapAuth;
    }

    public final Prompt getManualAuth() {
        return this.manualAuth;
    }

    public final Prompt getAuthWaiting() {
        return this.authWaiting;
    }

    public final Prompt getAuthFailed() {
        return this.authFailed;
    }
}
