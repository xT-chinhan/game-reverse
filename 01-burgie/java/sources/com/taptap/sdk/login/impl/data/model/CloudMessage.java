package com.taptap.sdk.login.impl.data.model;

import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CloudMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 -*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003,-.B=\b\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J@\u0010!\u001a\u00020\"\"\u0004\b\u0001\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H#0*HÁ\u0001¢\u0006\u0002\b+R \u0010\b\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0014¨\u0006/"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/CloudMessage;", "T", "", "seen1", "", "type", "", "messageId", "data", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getData$annotations", "()V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessageId$annotations", "getMessageId", "()Ljava/lang/String;", "getType$annotations", "getType", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/taptap/sdk/login/impl/data/model/CloudMessage;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "T0", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$tap_login_release", "$serializer", "Companion", "Config", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class CloudMessage<T> {
    private static final SerialDescriptor $cachedDescriptor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T data;
    private final String messageId;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CloudMessage copy$default(CloudMessage cloudMessage, String str, String str2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = cloudMessage.type;
        }
        if ((i & 2) != 0) {
            str2 = cloudMessage.messageId;
        }
        if ((i & 4) != 0) {
            obj = cloudMessage.data;
        }
        return cloudMessage.copy(str, str2, obj);
    }

    @SerialName("data")
    public static /* synthetic */ void getData$annotations() {
    }

    @SerialName("message_id")
    public static /* synthetic */ void getMessageId$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    public final T component3() {
        return this.data;
    }

    public final CloudMessage<T> copy(String type, String messageId, T data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        return new CloudMessage<>(type, messageId, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudMessage)) {
            return false;
        }
        CloudMessage cloudMessage = (CloudMessage) other;
        return Intrinsics.areEqual(this.type, cloudMessage.type) && Intrinsics.areEqual(this.messageId, cloudMessage.messageId) && Intrinsics.areEqual(this.data, cloudMessage.data);
    }

    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.messageId.hashCode()) * 31;
        T t = this.data;
        return iHashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "CloudMessage(type=" + this.type + ", messageId=" + this.messageId + ", data=" + this.data + ')';
    }

    /* JADX INFO: compiled from: CloudMessage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0004\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004HÆ\u0001¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/CloudMessage;", "T0", "typeSerial0", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T0> KSerializer<CloudMessage<T0>> serializer(KSerializer<T0> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
            return new CloudMessage$$serializer(typeSerial0);
        }
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.login.impl.data.model.CloudMessage", null, 3);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("message_id", false);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CloudMessage(int seen1, @SerialName("type") String type, @SerialName("message_id") String messageId, @SerialName("data") Object obj, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen1 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 7, $cachedDescriptor);
        }
        this.type = type;
        this.messageId = messageId;
        this.data = obj;
    }

    public CloudMessage(String type, String messageId, T t) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        this.type = type;
        this.messageId = messageId;
        this.data = t;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_login_release(CloudMessage self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
        output.encodeStringElement(serialDesc, 0, self.type);
        output.encodeStringElement(serialDesc, 1, self.messageId);
        output.encodeNullableSerializableElement(serialDesc, 2, typeSerial0, self.data);
    }

    public final String getType() {
        return this.type;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final T getData() {
        return this.data;
    }

    /* JADX INFO: compiled from: CloudMessage.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0003+,-BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J&\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÁ\u0001¢\u0006\u0002\b*R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0014¨\u0006."}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config;", "", "seen1", "", BillingClientConstants.PACKAGE_NAME, "", "sdkInfo", "sdkTrackInfo", "cgpn", "Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config$CPGNData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config$CPGNData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config$CPGNData;)V", "getCgpn$annotations", "()V", "getCgpn", "()Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config$CPGNData;", "getPackageName$annotations", "getPackageName", "()Ljava/lang/String;", "getSdkInfo$annotations", "getSdkInfo", "getSdkTrackInfo$annotations", "getSdkTrackInfo", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "CPGNData", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Serializable
    public static final /* data */ class Config {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CPGNData cgpn;
        private final String packageName;
        private final String sdkInfo;
        private final String sdkTrackInfo;

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, String str3, CPGNData cPGNData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = config.packageName;
            }
            if ((i & 2) != 0) {
                str2 = config.sdkInfo;
            }
            if ((i & 4) != 0) {
                str3 = config.sdkTrackInfo;
            }
            if ((i & 8) != 0) {
                cPGNData = config.cgpn;
            }
            return config.copy(str, str2, str3, cPGNData);
        }

        @SerialName("CGPN")
        public static /* synthetic */ void getCgpn$annotations() {
        }

        @SerialName("package_name")
        public static /* synthetic */ void getPackageName$annotations() {
        }

        @SerialName("sdk_info")
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

        public final Config copy(String packageName, String sdkInfo, String sdkTrackInfo, CPGNData cgpn) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(sdkInfo, "sdkInfo");
            Intrinsics.checkNotNullParameter(sdkTrackInfo, "sdkTrackInfo");
            Intrinsics.checkNotNullParameter(cgpn, "cgpn");
            return new Config(packageName, sdkInfo, sdkTrackInfo, cgpn);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.packageName, config.packageName) && Intrinsics.areEqual(this.sdkInfo, config.sdkInfo) && Intrinsics.areEqual(this.sdkTrackInfo, config.sdkTrackInfo) && Intrinsics.areEqual(this.cgpn, config.cgpn);
        }

        public int hashCode() {
            return (((((this.packageName.hashCode() * 31) + this.sdkInfo.hashCode()) * 31) + this.sdkTrackInfo.hashCode()) * 31) + this.cgpn.hashCode();
        }

        public String toString() {
            return "Config(packageName=" + this.packageName + ", sdkInfo=" + this.sdkInfo + ", sdkTrackInfo=" + this.sdkTrackInfo + ", cgpn=" + this.cgpn + ')';
        }

        /* JADX INFO: compiled from: CloudMessage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Config> serializer() {
                return CloudMessage$Config$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Config(int seen1, @SerialName("package_name") String packageName, @SerialName("sdk_info") String sdkInfo, @SerialName("sdk_track_info") String sdkTrackInfo, @SerialName("CGPN") CPGNData cgpn, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (seen1 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(seen1, 15, CloudMessage$Config$$serializer.INSTANCE.getDescriptor());
            }
            this.packageName = packageName;
            this.sdkInfo = sdkInfo;
            this.sdkTrackInfo = sdkTrackInfo;
            this.cgpn = cgpn;
        }

        public Config(String packageName, String sdkInfo, String sdkTrackInfo, CPGNData cgpn) {
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
        public static final /* synthetic */ void write$Self$tap_login_release(Config self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.packageName);
            output.encodeStringElement(serialDesc, 1, self.sdkInfo);
            output.encodeStringElement(serialDesc, 2, self.sdkTrackInfo);
            output.encodeSerializableElement(serialDesc, 3, CloudMessage$Config$CPGNData$$serializer.INSTANCE, self.cgpn);
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

        /* JADX INFO: compiled from: CloudMessage.kt */
        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB+\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0019\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cHÁ\u0001¢\u0006\u0002\b\u001dR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config$CPGNData;", "", "seen1", "", "supportedVersion", "", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "getSupportedVersion$annotations", "()V", "getSupportedVersion", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        @Serializable
        public static final /* data */ class CPGNData {
            private final List<String> supportedVersion;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE)};

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CPGNData copy$default(CPGNData cPGNData, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = cPGNData.supportedVersion;
                }
                return cPGNData.copy(list);
            }

            @SerialName("login")
            public static /* synthetic */ void getSupportedVersion$annotations() {
            }

            public final List<String> component1() {
                return this.supportedVersion;
            }

            public final CPGNData copy(List<String> supportedVersion) {
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
                return this.supportedVersion.hashCode();
            }

            public String toString() {
                return "CPGNData(supportedVersion=" + this.supportedVersion + ')';
            }

            /* JADX INFO: compiled from: CloudMessage.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config$CPGNData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/CloudMessage$Config$CPGNData;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<CPGNData> serializer() {
                    return CloudMessage$Config$CPGNData$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ CPGNData(int seen1, @SerialName("login") List supportedVersion, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (seen1 & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(seen1, 1, CloudMessage$Config$CPGNData$$serializer.INSTANCE.getDescriptor());
                }
                this.supportedVersion = supportedVersion;
            }

            public CPGNData(List<String> supportedVersion) {
                Intrinsics.checkNotNullParameter(supportedVersion, "supportedVersion");
                this.supportedVersion = supportedVersion;
            }

            public final List<String> getSupportedVersion() {
                return this.supportedVersion;
            }
        }
    }
}
