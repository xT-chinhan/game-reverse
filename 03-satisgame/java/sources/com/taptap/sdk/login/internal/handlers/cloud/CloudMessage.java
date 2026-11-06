package com.taptap.sdk.login.internal.handlers.cloud;

import com.anythink.core.common.l.f;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: CloudMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 ,*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002+,B=\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB%\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J;\u0010!\u001a\u00020\"\"\u0004\b\u0001\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H#0*HÇ\u0001R \u0010\b\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0014¨\u0006-"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudMessage;", "T", "", "seen1", "", "type", "", "messageId", f.R, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getData$annotations", "()V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMessageId$annotations", "getMessageId", "()Ljava/lang/String;", "getType$annotations", "getType", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/taptap/sdk/login/internal/handlers/cloud/CloudMessage;", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "T0", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class CloudMessage<T> {
    private static final SerialDescriptor $cachedDescriptor;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final T data;
    private final String messageId;
    private final String type;

    public CloudMessage() {
        this((String) null, (String) null, (Object) null, 7, (DefaultConstructorMarker) null);
    }

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

    @SerialName(f.R)
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\u0004\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004HÆ\u0001¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudMessage$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudMessage;", "T0", "typeSerial0", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.taptap.sdk.login.internal.handlers.cloud.CloudMessage", null, 3);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("message_id", true);
        pluginGeneratedSerialDescriptor.addElement(f.R, true);
        $cachedDescriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CloudMessage(int i, @SerialName("type") String str, @SerialName("message_id") String str2, @SerialName(f.R) Object obj, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, $cachedDescriptor);
        }
        if ((i & 1) == 0) {
            this.type = "";
        } else {
            this.type = str;
        }
        if ((i & 2) == 0) {
            this.messageId = "";
        } else {
            this.messageId = str2;
        }
        if ((i & 4) == 0) {
            this.data = null;
        } else {
            this.data = obj;
        }
    }

    public CloudMessage(String type, String messageId, T t) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        this.type = type;
        this.messageId = messageId;
        this.data = t;
    }

    @JvmStatic
    public static final <T0> void write$Self(CloudMessage<T0> self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer<T0> typeSerial0) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(((CloudMessage) self).type, "")) {
            output.encodeStringElement(serialDesc, 0, ((CloudMessage) self).type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(((CloudMessage) self).messageId, "")) {
            output.encodeStringElement(serialDesc, 1, ((CloudMessage) self).messageId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || ((CloudMessage) self).data != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, typeSerial0, ((CloudMessage) self).data);
        }
    }

    public /* synthetic */ CloudMessage(String str, String str2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : obj);
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
}
