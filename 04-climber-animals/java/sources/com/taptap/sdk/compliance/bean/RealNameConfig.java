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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B/\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J!\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÇ\u0001R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/taptap/sdk/compliance/bean/RealNameConfig;", "", "seen1", "", "realNameText", "Lcom/taptap/sdk/compliance/bean/RealNameText;", "manualAuthEnable", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/compliance/bean/RealNameText;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/compliance/bean/RealNameText;Z)V", "getManualAuthEnable$annotations", "()V", "getManualAuthEnable", "()Z", "getRealNameText$annotations", "getRealNameText", "()Lcom/taptap/sdk/compliance/bean/RealNameText;", "component1", "component2", "copy", "equals", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class RealNameConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean manualAuthEnable;
    private final RealNameText realNameText;

    /* JADX WARN: Multi-variable type inference failed */
    public RealNameConfig() {
        this((RealNameText) null, false, 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ RealNameConfig copy$default(RealNameConfig realNameConfig, RealNameText realNameText, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            realNameText = realNameConfig.realNameText;
        }
        if ((i & 2) != 0) {
            z = realNameConfig.manualAuthEnable;
        }
        return realNameConfig.copy(realNameText, z);
    }

    @SerialName("manual_auth_enable")
    public static /* synthetic */ void getManualAuthEnable$annotations() {
    }

    @SerialName("real_name_text")
    public static /* synthetic */ void getRealNameText$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RealNameText getRealNameText() {
        return this.realNameText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getManualAuthEnable() {
        return this.manualAuthEnable;
    }

    public final RealNameConfig copy(RealNameText realNameText, boolean manualAuthEnable) {
        return new RealNameConfig(realNameText, manualAuthEnable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RealNameConfig)) {
            return false;
        }
        RealNameConfig realNameConfig = (RealNameConfig) other;
        return Intrinsics.areEqual(this.realNameText, realNameConfig.realNameText) && this.manualAuthEnable == realNameConfig.manualAuthEnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        RealNameText realNameText = this.realNameText;
        int iHashCode = (realNameText == null ? 0 : realNameText.hashCode()) * 31;
        boolean z = this.manualAuthEnable;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "RealNameConfig(realNameText=" + this.realNameText + ", manualAuthEnable=" + this.manualAuthEnable + ')';
    }

    /* JADX INFO: compiled from: RealNameConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/RealNameConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/RealNameConfig;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RealNameConfig> serializer() {
            return RealNameConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RealNameConfig(int i, @SerialName("real_name_text") RealNameText realNameText, @SerialName("manual_auth_enable") boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, RealNameConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.realNameText = (i & 1) == 0 ? null : realNameText;
        if ((i & 2) == 0) {
            this.manualAuthEnable = false;
        } else {
            this.manualAuthEnable = z;
        }
    }

    public RealNameConfig(RealNameText realNameText, boolean z) {
        this.realNameText = realNameText;
        this.manualAuthEnable = z;
    }

    @JvmStatic
    public static final void write$Self(RealNameConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.realNameText != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, RealNameText$$serializer.INSTANCE, self.realNameText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.manualAuthEnable) {
            output.encodeBooleanElement(serialDesc, 1, self.manualAuthEnable);
        }
    }

    public /* synthetic */ RealNameConfig(RealNameText realNameText, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : realNameText, (i & 2) != 0 ? false : z);
    }

    public final RealNameText getRealNameText() {
        return this.realNameText;
    }

    public final boolean getManualAuthEnable() {
        return this.manualAuthEnable;
    }
}
