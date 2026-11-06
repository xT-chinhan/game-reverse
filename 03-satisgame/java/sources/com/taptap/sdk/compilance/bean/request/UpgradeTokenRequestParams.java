package com.taptap.sdk.compilance.bean.request;

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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: UpgradeTokenRequestParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÇ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/taptap/sdk/compilance/bean/request/UpgradeTokenRequestParams;", "", "seen1", "", "v1Token", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getV1Token$annotations", "()V", "getV1Token", "()Ljava/lang/String;", "component1", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class UpgradeTokenRequestParams {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String v1Token;

    /* JADX WARN: Multi-variable type inference failed */
    public UpgradeTokenRequestParams() {
        this((String) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ UpgradeTokenRequestParams copy$default(UpgradeTokenRequestParams upgradeTokenRequestParams, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = upgradeTokenRequestParams.v1Token;
        }
        return upgradeTokenRequestParams.copy(str);
    }

    @SerialName("anti_addiction_token_v1")
    public static /* synthetic */ void getV1Token$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getV1Token() {
        return this.v1Token;
    }

    public final UpgradeTokenRequestParams copy(String v1Token) {
        return new UpgradeTokenRequestParams(v1Token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UpgradeTokenRequestParams) && Intrinsics.areEqual(this.v1Token, ((UpgradeTokenRequestParams) other).v1Token);
    }

    public int hashCode() {
        String str = this.v1Token;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "UpgradeTokenRequestParams(v1Token=" + this.v1Token + ')';
    }

    /* JADX INFO: compiled from: UpgradeTokenRequestParams.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compilance/bean/request/UpgradeTokenRequestParams$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compilance/bean/request/UpgradeTokenRequestParams;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UpgradeTokenRequestParams> serializer() {
            return UpgradeTokenRequestParams$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UpgradeTokenRequestParams(int i, @SerialName("anti_addiction_token_v1") String str, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, UpgradeTokenRequestParams$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.v1Token = null;
        } else {
            this.v1Token = str;
        }
    }

    public UpgradeTokenRequestParams(String str) {
        this.v1Token = str;
    }

    @JvmStatic
    public static final void write$Self(UpgradeTokenRequestParams self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.v1Token == null) {
            z = false;
        }
        if (z) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.v1Token);
        }
    }

    public /* synthetic */ UpgradeTokenRequestParams(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getV1Token() {
        return this.v1Token;
    }
}
