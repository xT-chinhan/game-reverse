package com.taptap.sdk.compilance.option;

import com.taptap.sdk.core.TapTapSdkBaseOptions;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
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
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: TapTapComplianceOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB-\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/taptap/sdk/compilance/option/TapTapComplianceOptions;", "Lcom/taptap/sdk/core/TapTapSdkBaseOptions;", "seen1", "", "showSwitchAccount", "", "useAgeRange", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZZ)V", "getShowSwitchAccount$annotations", "()V", "getShowSwitchAccount", "()Z", "getUseAgeRange$annotations", "getUseAgeRange", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final class TapTapComplianceOptions implements TapTapSdkBaseOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean showSwitchAccount;
    private final boolean useAgeRange;

    /* JADX WARN: Illegal instructions before constructor call */
    public TapTapComplianceOptions() {
        boolean z = false;
        this(z, z, 3, (DefaultConstructorMarker) null);
    }

    @SerialName("showSwitchAccount")
    public static /* synthetic */ void getShowSwitchAccount$annotations() {
    }

    @SerialName("useAgeRange")
    public static /* synthetic */ void getUseAgeRange$annotations() {
    }

    /* JADX INFO: compiled from: TapTapComplianceOptions.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compilance/option/TapTapComplianceOptions$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compilance/option/TapTapComplianceOptions;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapTapComplianceOptions> serializer() {
            return TapTapComplianceOptions$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapTapComplianceOptions(int i, @SerialName("showSwitchAccount") boolean z, @SerialName("useAgeRange") boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, TapTapComplianceOptions$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.showSwitchAccount = false;
        } else {
            this.showSwitchAccount = z;
        }
        if ((i & 2) == 0) {
            this.useAgeRange = true;
        } else {
            this.useAgeRange = z2;
        }
    }

    public TapTapComplianceOptions(boolean z, boolean z2) {
        this.showSwitchAccount = z;
        this.useAgeRange = z2;
    }

    @JvmStatic
    public static final void write$Self(TapTapComplianceOptions self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.showSwitchAccount) {
            output.encodeBooleanElement(serialDesc, 0, self.showSwitchAccount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !self.useAgeRange) {
            output.encodeBooleanElement(serialDesc, 1, self.useAgeRange);
        }
    }

    public /* synthetic */ TapTapComplianceOptions(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2);
    }

    public final boolean getShowSwitchAccount() {
        return this.showSwitchAccount;
    }

    public final boolean getUseAgeRange() {
        return this.useAgeRange;
    }

    public String toString() {
        String strEncodeToString;
        try {
            Json json = TapJson.INSTANCE.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapTapComplianceOptions.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = json.encodeToString(kSerializerSerializer, this);
        } catch (Exception e) {
            TapLogger.loge$default(TapJson.TAG, null, e, 2, null);
            strEncodeToString = null;
        }
        if (strEncodeToString != null) {
            return strEncodeToString;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
