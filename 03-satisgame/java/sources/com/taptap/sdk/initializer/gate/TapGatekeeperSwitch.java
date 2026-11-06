package com.taptap.sdk.initializer.gate;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: TapGatekeeper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0002%&B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ&\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001R(\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0011\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0011\u0012\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006'"}, d2 = {"Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;", "", "seen1", "", "autoEvent", "", "heartbeat", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAutoEvent$annotations", "()V", "getAutoEvent", "()Ljava/lang/Boolean;", "setAutoEvent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHeartbeat$annotations", "getHeartbeat", "setHeartbeat", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;", "equals", AdnName.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapGatekeeperSwitch {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Boolean autoEvent;
    private Boolean heartbeat;

    /* JADX WARN: Multi-variable type inference failed */
    public TapGatekeeperSwitch() {
        this((Boolean) null, (Boolean) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ TapGatekeeperSwitch copy$default(TapGatekeeperSwitch tapGatekeeperSwitch, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = tapGatekeeperSwitch.autoEvent;
        }
        if ((i & 2) != 0) {
            bool2 = tapGatekeeperSwitch.heartbeat;
        }
        return tapGatekeeperSwitch.copy(bool, bool2);
    }

    @SerialName("auto_event")
    public static /* synthetic */ void getAutoEvent$annotations() {
    }

    @SerialName("heartbeat")
    public static /* synthetic */ void getHeartbeat$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getAutoEvent() {
        return this.autoEvent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getHeartbeat() {
        return this.heartbeat;
    }

    public final TapGatekeeperSwitch copy(Boolean autoEvent, Boolean heartbeat) {
        return new TapGatekeeperSwitch(autoEvent, heartbeat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapGatekeeperSwitch)) {
            return false;
        }
        TapGatekeeperSwitch tapGatekeeperSwitch = (TapGatekeeperSwitch) other;
        return Intrinsics.areEqual(this.autoEvent, tapGatekeeperSwitch.autoEvent) && Intrinsics.areEqual(this.heartbeat, tapGatekeeperSwitch.heartbeat);
    }

    public int hashCode() {
        Boolean bool = this.autoEvent;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.heartbeat;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "TapGatekeeperSwitch(autoEvent=" + this.autoEvent + ", heartbeat=" + this.heartbeat + ')';
    }

    /* JADX INFO: compiled from: TapGatekeeper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapGatekeeperSwitch> serializer() {
            return TapGatekeeperSwitch$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapGatekeeperSwitch(int i, @SerialName("auto_event") Boolean bool, @SerialName("heartbeat") Boolean bool2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, TapGatekeeperSwitch$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.autoEvent = null;
        } else {
            this.autoEvent = bool;
        }
        if ((i & 2) == 0) {
            this.heartbeat = null;
        } else {
            this.heartbeat = bool2;
        }
    }

    public TapGatekeeperSwitch(Boolean bool, Boolean bool2) {
        this.autoEvent = bool;
        this.heartbeat = bool2;
    }

    @JvmStatic
    public static final void write$Self(TapGatekeeperSwitch self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.autoEvent != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.autoEvent);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.heartbeat != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.heartbeat);
        }
    }

    public /* synthetic */ TapGatekeeperSwitch(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2);
    }

    public final Boolean getAutoEvent() {
        return this.autoEvent;
    }

    public final void setAutoEvent(Boolean bool) {
        this.autoEvent = bool;
    }

    public final Boolean getHeartbeat() {
        return this.heartbeat;
    }

    public final void setHeartbeat(Boolean bool) {
        this.heartbeat = bool;
    }
}
