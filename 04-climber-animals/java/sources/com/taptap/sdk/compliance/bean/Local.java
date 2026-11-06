package com.taptap.sdk.compliance.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
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

/* JADX INFO: compiled from: UserAntiConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J!\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÇ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/compliance/bean/Local;", "", "seen1", "", "timeRange", "Lcom/taptap/sdk/compliance/bean/TimeRangeConfig;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/compliance/bean/TimeRangeConfig;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/compliance/bean/TimeRangeConfig;)V", "getTimeRange$annotations", "()V", "getTimeRange", "()Lcom/taptap/sdk/compliance/bean/TimeRangeConfig;", "component1", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class Local {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TimeRangeConfig timeRange;

    /* JADX WARN: Multi-variable type inference failed */
    public Local() {
        this((TimeRangeConfig) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ Local copy$default(Local local, TimeRangeConfig timeRangeConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            timeRangeConfig = local.timeRange;
        }
        return local.copy(timeRangeConfig);
    }

    @SerialName(TapComplianceSettings.TIME_RANGE_MODE)
    public static /* synthetic */ void getTimeRange$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TimeRangeConfig getTimeRange() {
        return this.timeRange;
    }

    public final Local copy(TimeRangeConfig timeRange) {
        return new Local(timeRange);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Local) && Intrinsics.areEqual(this.timeRange, ((Local) other).timeRange);
    }

    public int hashCode() {
        TimeRangeConfig timeRangeConfig = this.timeRange;
        if (timeRangeConfig == null) {
            return 0;
        }
        return timeRangeConfig.hashCode();
    }

    public String toString() {
        return "Local(timeRange=" + this.timeRange + ')';
    }

    /* JADX INFO: compiled from: UserAntiConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/Local$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/Local;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Local> serializer() {
            return Local$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Local(int i, @SerialName(TapComplianceSettings.TIME_RANGE_MODE) TimeRangeConfig timeRangeConfig, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, Local$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.timeRange = null;
        } else {
            this.timeRange = timeRangeConfig;
        }
    }

    public Local(TimeRangeConfig timeRangeConfig) {
        this.timeRange = timeRangeConfig;
    }

    @JvmStatic
    public static final void write$Self(Local self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.timeRange == null) {
            z = false;
        }
        if (z) {
            output.encodeNullableSerializableElement(serialDesc, 0, TimeRangeConfig$$serializer.INSTANCE, self.timeRange);
        }
    }

    public /* synthetic */ Local(TimeRangeConfig timeRangeConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : timeRangeConfig);
    }

    public final TimeRangeConfig getTimeRange() {
        return this.timeRange;
    }
}
