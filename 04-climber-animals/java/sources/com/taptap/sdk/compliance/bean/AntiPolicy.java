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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: UserAntiConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J!\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÇ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006)"}, d2 = {"Lcom/taptap/sdk/compliance/bean/AntiPolicy;", "", "seen1", "", "policyActive", "", "policyModel", "policyHeartbeatInterval", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getPolicyActive$annotations", "()V", "getPolicyActive", "()Ljava/lang/String;", "getPolicyHeartbeatInterval$annotations", "getPolicyHeartbeatInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPolicyModel$annotations", "getPolicyModel", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/taptap/sdk/compliance/bean/AntiPolicy;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class AntiPolicy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String policyActive;
    private final Integer policyHeartbeatInterval;
    private final String policyModel;

    public AntiPolicy() {
        this((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AntiPolicy copy$default(AntiPolicy antiPolicy, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = antiPolicy.policyActive;
        }
        if ((i & 2) != 0) {
            str2 = antiPolicy.policyModel;
        }
        if ((i & 4) != 0) {
            num = antiPolicy.policyHeartbeatInterval;
        }
        return antiPolicy.copy(str, str2, num);
    }

    @SerialName("policy_active")
    public static /* synthetic */ void getPolicyActive$annotations() {
    }

    @SerialName("policy_heartbeat_interval")
    public static /* synthetic */ void getPolicyHeartbeatInterval$annotations() {
    }

    @SerialName("policy_model")
    public static /* synthetic */ void getPolicyModel$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPolicyActive() {
        return this.policyActive;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPolicyModel() {
        return this.policyModel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getPolicyHeartbeatInterval() {
        return this.policyHeartbeatInterval;
    }

    public final AntiPolicy copy(String policyActive, String policyModel, Integer policyHeartbeatInterval) {
        return new AntiPolicy(policyActive, policyModel, policyHeartbeatInterval);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AntiPolicy)) {
            return false;
        }
        AntiPolicy antiPolicy = (AntiPolicy) other;
        return Intrinsics.areEqual(this.policyActive, antiPolicy.policyActive) && Intrinsics.areEqual(this.policyModel, antiPolicy.policyModel) && Intrinsics.areEqual(this.policyHeartbeatInterval, antiPolicy.policyHeartbeatInterval);
    }

    public int hashCode() {
        String str = this.policyActive;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.policyModel;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.policyHeartbeatInterval;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "AntiPolicy(policyActive=" + this.policyActive + ", policyModel=" + this.policyModel + ", policyHeartbeatInterval=" + this.policyHeartbeatInterval + ')';
    }

    /* JADX INFO: compiled from: UserAntiConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/AntiPolicy$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/AntiPolicy;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AntiPolicy> serializer() {
            return AntiPolicy$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AntiPolicy(int i, @SerialName("policy_active") String str, @SerialName("policy_model") String str2, @SerialName("policy_heartbeat_interval") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, AntiPolicy$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.policyActive = "";
        } else {
            this.policyActive = str;
        }
        if ((i & 2) == 0) {
            this.policyModel = "";
        } else {
            this.policyModel = str2;
        }
        if ((i & 4) == 0) {
            this.policyHeartbeatInterval = 0;
        } else {
            this.policyHeartbeatInterval = num;
        }
    }

    public AntiPolicy(String str, String str2, Integer num) {
        this.policyActive = str;
        this.policyModel = str2;
        this.policyHeartbeatInterval = num;
    }

    @JvmStatic
    public static final void write$Self(AntiPolicy self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Integer num;
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.policyActive, "")) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.policyActive);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.policyModel, "")) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.policyModel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || (num = self.policyHeartbeatInterval) == null || num.intValue() != 0) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.policyHeartbeatInterval);
        }
    }

    public final String getPolicyActive() {
        return this.policyActive;
    }

    public final String getPolicyModel() {
        return this.policyModel;
    }

    public /* synthetic */ AntiPolicy(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0 : num);
    }

    public final Integer getPolicyHeartbeatInterval() {
        return this.policyHeartbeatInterval;
    }
}
