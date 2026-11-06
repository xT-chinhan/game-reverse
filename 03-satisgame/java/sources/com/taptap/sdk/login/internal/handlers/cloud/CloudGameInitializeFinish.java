package com.taptap.sdk.login.internal.handlers.cloud;

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

/* JADX INFO: compiled from: CloudGameInitializeFinish.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J!\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish;", "", "seen1", "", "cgpn", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish$CPGNData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish$CPGNData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish$CPGNData;)V", "getCgpn$annotations", "()V", "getCgpn", "()Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish$CPGNData;", "component1", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "CPGNData", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class CloudGameInitializeFinish {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CPGNData cgpn;

    /* JADX WARN: Multi-variable type inference failed */
    public CloudGameInitializeFinish() {
        this((CPGNData) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ CloudGameInitializeFinish copy$default(CloudGameInitializeFinish cloudGameInitializeFinish, CPGNData cPGNData, int i, Object obj) {
        if ((i & 1) != 0) {
            cPGNData = cloudGameInitializeFinish.cgpn;
        }
        return cloudGameInitializeFinish.copy(cPGNData);
    }

    @SerialName("CGPN")
    public static /* synthetic */ void getCgpn$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CPGNData getCgpn() {
        return this.cgpn;
    }

    public final CloudGameInitializeFinish copy(CPGNData cgpn) {
        Intrinsics.checkNotNullParameter(cgpn, "cgpn");
        return new CloudGameInitializeFinish(cgpn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CloudGameInitializeFinish) && Intrinsics.areEqual(this.cgpn, ((CloudGameInitializeFinish) other).cgpn);
    }

    public int hashCode() {
        return this.cgpn.hashCode();
    }

    public String toString() {
        return "CloudGameInitializeFinish(cgpn=" + this.cgpn + ')';
    }

    /* JADX INFO: compiled from: CloudGameInitializeFinish.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CloudGameInitializeFinish> serializer() {
            return CloudGameInitializeFinish$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CloudGameInitializeFinish(int i, @SerialName("CGPN") CPGNData cPGNData, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, CloudGameInitializeFinish$$serializer.INSTANCE.getDescriptor());
        }
        int i2 = 1;
        if ((i & 1) == 0) {
            this.cgpn = new CPGNData((String) null, i2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        } else {
            this.cgpn = cPGNData;
        }
    }

    public CloudGameInitializeFinish(CPGNData cgpn) {
        Intrinsics.checkNotNullParameter(cgpn, "cgpn");
        this.cgpn = cgpn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void write$Self(CloudGameInitializeFinish self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        int i = 1;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.cgpn, new CPGNData((String) null, i, (DefaultConstructorMarker) (0 == true ? 1 : 0)))) {
            i = 0;
        }
        if (i != 0) {
            output.encodeSerializableElement(serialDesc, 0, CloudGameInitializeFinish$CPGNData$$serializer.INSTANCE, self.cgpn);
        }
    }

    /* JADX INFO: compiled from: CloudGameInitializeFinish.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish$CPGNData;", "", "seen1", "", "version", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getVersion$annotations", "()V", "getVersion", "()Ljava/lang/String;", "component1", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Serializable
    public static final /* data */ class CPGNData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String version;

        /* JADX WARN: Multi-variable type inference failed */
        public CPGNData() {
            this((String) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ CPGNData copy$default(CPGNData cPGNData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cPGNData.version;
            }
            return cPGNData.copy(str);
        }

        @SerialName("login")
        public static /* synthetic */ void getVersion$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        public final CPGNData copy(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            return new CPGNData(version);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CPGNData) && Intrinsics.areEqual(this.version, ((CPGNData) other).version);
        }

        public int hashCode() {
            return this.version.hashCode();
        }

        public String toString() {
            return "CPGNData(version=" + this.version + ')';
        }

        /* JADX INFO: compiled from: CloudGameInitializeFinish.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish$CPGNData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameInitializeFinish$CPGNData;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CPGNData> serializer() {
                return CloudGameInitializeFinish$CPGNData$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CPGNData(int i, @SerialName("login") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 0) != 0) {
                PluginExceptionsKt.throwMissingFieldException(i, 0, CloudGameInitializeFinish$CPGNData$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.version = "";
            } else {
                this.version = str;
            }
        }

        public CPGNData(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            this.version = version;
        }

        @JvmStatic
        public static final void write$Self(CPGNData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            boolean z = true;
            if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.version, "")) {
                z = false;
            }
            if (z) {
                output.encodeStringElement(serialDesc, 0, self.version);
            }
        }

        public /* synthetic */ CPGNData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str);
        }

        public final String getVersion() {
            return this.version;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CloudGameInitializeFinish(CPGNData cPGNData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CPGNData((String) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : cPGNData);
    }

    public final CPGNData getCgpn() {
        return this.cgpn;
    }
}
