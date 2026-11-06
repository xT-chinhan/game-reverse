package com.taptap.sdk.login.internal.handlers.cloud;

import com.anythink.core.api.ATAdConst;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.Arrays;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CloudConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0003*+,BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J!\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÇ\u0001R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0014¨\u0006-"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig;", "", "seen1", "", "packageName", "", "sdkInfo", "sdkTrackInfo", "cgpn", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$CPGNData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$CPGNData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$CPGNData;)V", "getCgpn$annotations", "()V", "getCgpn", "()Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$CPGNData;", "getPackageName$annotations", "getPackageName", "()Ljava/lang/String;", "getSdkInfo$annotations", "getSdkInfo", "getSdkTrackInfo$annotations", "getSdkTrackInfo", "component1", "component2", "component3", "component4", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "CPGNData", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class CloudConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CPGNData cgpn;
    private final String packageName;
    private final String sdkInfo;
    private final String sdkTrackInfo;

    public static /* synthetic */ CloudConfig copy$default(CloudConfig cloudConfig, String str, String str2, String str3, CPGNData cPGNData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cloudConfig.packageName;
        }
        if ((i & 2) != 0) {
            str2 = cloudConfig.sdkInfo;
        }
        if ((i & 4) != 0) {
            str3 = cloudConfig.sdkTrackInfo;
        }
        if ((i & 8) != 0) {
            cPGNData = cloudConfig.cgpn;
        }
        return cloudConfig.copy(str, str2, str3, cPGNData);
    }

    @SerialName("CGPN")
    public static /* synthetic */ void getCgpn$annotations() {
    }

    @SerialName("package_name")
    public static /* synthetic */ void getPackageName$annotations() {
    }

    @SerialName(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO)
    public static /* synthetic */ void getSdkInfo$annotations() {
    }

    @SerialName("sdk_track_info")
    public static /* synthetic */ void getSdkTrackInfo$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSdkInfo() {
        return this.sdkInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSdkTrackInfo() {
        return this.sdkTrackInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CPGNData getCgpn() {
        return this.cgpn;
    }

    public final CloudConfig copy(String packageName, String sdkInfo, String sdkTrackInfo, CPGNData cgpn) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sdkInfo, "sdkInfo");
        Intrinsics.checkNotNullParameter(sdkTrackInfo, "sdkTrackInfo");
        Intrinsics.checkNotNullParameter(cgpn, "cgpn");
        return new CloudConfig(packageName, sdkInfo, sdkTrackInfo, cgpn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudConfig)) {
            return false;
        }
        CloudConfig cloudConfig = (CloudConfig) other;
        return Intrinsics.areEqual(this.packageName, cloudConfig.packageName) && Intrinsics.areEqual(this.sdkInfo, cloudConfig.sdkInfo) && Intrinsics.areEqual(this.sdkTrackInfo, cloudConfig.sdkTrackInfo) && Intrinsics.areEqual(this.cgpn, cloudConfig.cgpn);
    }

    public int hashCode() {
        return (((((this.packageName.hashCode() * 31) + this.sdkInfo.hashCode()) * 31) + this.sdkTrackInfo.hashCode()) * 31) + this.cgpn.hashCode();
    }

    public String toString() {
        return "CloudConfig(packageName=" + this.packageName + ", sdkInfo=" + this.sdkInfo + ", sdkTrackInfo=" + this.sdkTrackInfo + ", cgpn=" + this.cgpn + ')';
    }

    /* JADX INFO: compiled from: CloudConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CloudConfig> serializer() {
            return CloudConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CloudConfig(int i, @SerialName("package_name") String str, @SerialName(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO) String str2, @SerialName("sdk_track_info") String str3, @SerialName("CGPN") CPGNData cPGNData, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, CloudConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.packageName = str;
        this.sdkInfo = str2;
        this.sdkTrackInfo = str3;
        this.cgpn = cPGNData;
    }

    public CloudConfig(String packageName, String sdkInfo, String sdkTrackInfo, CPGNData cgpn) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(sdkInfo, "sdkInfo");
        Intrinsics.checkNotNullParameter(sdkTrackInfo, "sdkTrackInfo");
        Intrinsics.checkNotNullParameter(cgpn, "cgpn");
        this.packageName = packageName;
        this.sdkInfo = sdkInfo;
        this.sdkTrackInfo = sdkTrackInfo;
        this.cgpn = cgpn;
    }

    @JvmStatic
    public static final void write$Self(CloudConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.packageName);
        output.encodeStringElement(serialDesc, 1, self.sdkInfo);
        output.encodeStringElement(serialDesc, 2, self.sdkTrackInfo);
        output.encodeSerializableElement(serialDesc, 3, CloudConfig$CPGNData$$serializer.INSTANCE, self.cgpn);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSdkInfo() {
        return this.sdkInfo;
    }

    public final String getSdkTrackInfo() {
        return this.sdkTrackInfo;
    }

    public final CPGNData getCgpn() {
        return this.cgpn;
    }

    /* JADX INFO: compiled from: CloudConfig.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÇ\u0001R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$CPGNData;", "", "seen1", "", "supportedVersion", "", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "([Ljava/lang/String;)V", "getSupportedVersion$annotations", "()V", "getSupportedVersion", "()[Ljava/lang/String;", "[Ljava/lang/String;", "component1", "copy", "([Ljava/lang/String;)Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$CPGNData;", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Serializable
    public static final /* data */ class CPGNData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String[] supportedVersion;

        public static /* synthetic */ CPGNData copy$default(CPGNData cPGNData, String[] strArr, int i, Object obj) {
            if ((i & 1) != 0) {
                strArr = cPGNData.supportedVersion;
            }
            return cPGNData.copy(strArr);
        }

        @SerialName("login")
        public static /* synthetic */ void getSupportedVersion$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String[] getSupportedVersion() {
            return this.supportedVersion;
        }

        public final CPGNData copy(String[] supportedVersion) {
            Intrinsics.checkNotNullParameter(supportedVersion, "supportedVersion");
            return new CPGNData(supportedVersion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CPGNData) && Intrinsics.areEqual(this.supportedVersion, ((CPGNData) other).supportedVersion);
        }

        public int hashCode() {
            return Arrays.hashCode(this.supportedVersion);
        }

        public String toString() {
            return "CPGNData(supportedVersion=" + Arrays.toString(this.supportedVersion) + ')';
        }

        /* JADX INFO: compiled from: CloudConfig.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$CPGNData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudConfig$CPGNData;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CPGNData> serializer() {
                return CloudConfig$CPGNData$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CPGNData(int i, @SerialName("login") String[] strArr, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, CloudConfig$CPGNData$$serializer.INSTANCE.getDescriptor());
            }
            this.supportedVersion = strArr;
        }

        public CPGNData(String[] supportedVersion) {
            Intrinsics.checkNotNullParameter(supportedVersion, "supportedVersion");
            this.supportedVersion = supportedVersion;
        }

        @JvmStatic
        public static final void write$Self(CPGNData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            output.encodeSerializableElement(serialDesc, 0, new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE), self.supportedVersion);
        }

        public final String[] getSupportedVersion() {
            return this.supportedVersion;
        }
    }
}
