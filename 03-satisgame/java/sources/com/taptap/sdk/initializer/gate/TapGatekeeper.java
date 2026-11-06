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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: TapGatekeeper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 /2\u00020\u0001:\u0002./B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001J!\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÇ\u0001R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00060"}, d2 = {"Lcom/taptap/sdk/initializer/gate/TapGatekeeper;", "", "seen1", "", "switch", "Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;", "urls", "Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl;", "appId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl;Ljava/lang/Integer;)V", "getAppId$annotations", "()V", "getAppId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSwitch$annotations", "getSwitch", "()Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;", "setSwitch", "(Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;)V", "getUrls$annotations", "getUrls", "()Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl;", "setUrls", "(Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl;)V", "component1", "component2", "component3", "copy", "(Lcom/taptap/sdk/initializer/gate/TapGatekeeperSwitch;Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl;Ljava/lang/Integer;)Lcom/taptap/sdk/initializer/gate/TapGatekeeper;", "equals", "", AdnName.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapGatekeeper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer appId;
    private TapGatekeeperSwitch switch;
    private TapGateKeeperUrl urls;

    public TapGatekeeper() {
        this((TapGatekeeperSwitch) null, (TapGateKeeperUrl) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TapGatekeeper copy$default(TapGatekeeper tapGatekeeper, TapGatekeeperSwitch tapGatekeeperSwitch, TapGateKeeperUrl tapGateKeeperUrl, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            tapGatekeeperSwitch = tapGatekeeper.switch;
        }
        if ((i & 2) != 0) {
            tapGateKeeperUrl = tapGatekeeper.urls;
        }
        if ((i & 4) != 0) {
            num = tapGatekeeper.appId;
        }
        return tapGatekeeper.copy(tapGatekeeperSwitch, tapGateKeeperUrl, num);
    }

    @SerialName("taptap_app_id")
    public static /* synthetic */ void getAppId$annotations() {
    }

    @SerialName("switch")
    public static /* synthetic */ void getSwitch$annotations() {
    }

    @SerialName("urls")
    public static /* synthetic */ void getUrls$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TapGatekeeperSwitch getSwitch() {
        return this.switch;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TapGateKeeperUrl getUrls() {
        return this.urls;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getAppId() {
        return this.appId;
    }

    public final TapGatekeeper copy(TapGatekeeperSwitch tapGatekeeperSwitch, TapGateKeeperUrl urls, Integer appId) {
        return new TapGatekeeper(tapGatekeeperSwitch, urls, appId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapGatekeeper)) {
            return false;
        }
        TapGatekeeper tapGatekeeper = (TapGatekeeper) other;
        return Intrinsics.areEqual(this.switch, tapGatekeeper.switch) && Intrinsics.areEqual(this.urls, tapGatekeeper.urls) && Intrinsics.areEqual(this.appId, tapGatekeeper.appId);
    }

    public int hashCode() {
        TapGatekeeperSwitch tapGatekeeperSwitch = this.switch;
        int iHashCode = (tapGatekeeperSwitch == null ? 0 : tapGatekeeperSwitch.hashCode()) * 31;
        TapGateKeeperUrl tapGateKeeperUrl = this.urls;
        int iHashCode2 = (iHashCode + (tapGateKeeperUrl == null ? 0 : tapGateKeeperUrl.hashCode())) * 31;
        Integer num = this.appId;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "TapGatekeeper(switch=" + this.switch + ", urls=" + this.urls + ", appId=" + this.appId + ')';
    }

    /* JADX INFO: compiled from: TapGatekeeper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/initializer/gate/TapGatekeeper$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/initializer/gate/TapGatekeeper;", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapGatekeeper> serializer() {
            return TapGatekeeper$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapGatekeeper(int i, @SerialName("switch") TapGatekeeperSwitch tapGatekeeperSwitch, @SerialName("urls") TapGateKeeperUrl tapGateKeeperUrl, @SerialName("taptap_app_id") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, TapGatekeeper$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.switch = null;
        } else {
            this.switch = tapGatekeeperSwitch;
        }
        if ((i & 2) == 0) {
            this.urls = null;
        } else {
            this.urls = tapGateKeeperUrl;
        }
        if ((i & 4) == 0) {
            this.appId = null;
        } else {
            this.appId = num;
        }
    }

    public TapGatekeeper(TapGatekeeperSwitch tapGatekeeperSwitch, TapGateKeeperUrl tapGateKeeperUrl, Integer num) {
        this.switch = tapGatekeeperSwitch;
        this.urls = tapGateKeeperUrl;
        this.appId = num;
    }

    @JvmStatic
    public static final void write$Self(TapGatekeeper self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.switch != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, TapGatekeeperSwitch$$serializer.INSTANCE, self.switch);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.urls != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, TapGateKeeperUrl$$serializer.INSTANCE, self.urls);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.appId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.appId);
        }
    }

    public /* synthetic */ TapGatekeeper(TapGatekeeperSwitch tapGatekeeperSwitch, TapGateKeeperUrl tapGateKeeperUrl, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tapGatekeeperSwitch, (i & 2) != 0 ? null : tapGateKeeperUrl, (i & 4) != 0 ? null : num);
    }

    public final TapGatekeeperSwitch getSwitch() {
        return this.switch;
    }

    public final void setSwitch(TapGatekeeperSwitch tapGatekeeperSwitch) {
        this.switch = tapGatekeeperSwitch;
    }

    public final TapGateKeeperUrl getUrls() {
        return this.urls;
    }

    public final void setUrls(TapGateKeeperUrl tapGateKeeperUrl) {
        this.urls = tapGateKeeperUrl;
    }

    public final Integer getAppId() {
        return this.appId;
    }
}
