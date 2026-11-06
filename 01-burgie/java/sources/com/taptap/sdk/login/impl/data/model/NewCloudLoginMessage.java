package com.taptap.sdk.login.impl.data.model;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NewCloudLoginMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0003'()B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0013¨\u0006*"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage;", "", "seen1", "", "type", "", "messageId", "data", "Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data;)V", "getData$annotations", "()V", "getData", "()Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data;", "getMessageId$annotations", "getMessageId", "()Ljava/lang/String;", "getType$annotations", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "Data", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class NewCloudLoginMessage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Data data;
    private final String messageId;
    private final String type;

    public static /* synthetic */ NewCloudLoginMessage copy$default(NewCloudLoginMessage newCloudLoginMessage, String str, String str2, Data data, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newCloudLoginMessage.type;
        }
        if ((i & 2) != 0) {
            str2 = newCloudLoginMessage.messageId;
        }
        if ((i & 4) != 0) {
            data = newCloudLoginMessage.data;
        }
        return newCloudLoginMessage.copy(str, str2, data);
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

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    public final NewCloudLoginMessage copy(String type, String messageId, Data data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(data, "data");
        return new NewCloudLoginMessage(type, messageId, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewCloudLoginMessage)) {
            return false;
        }
        NewCloudLoginMessage newCloudLoginMessage = (NewCloudLoginMessage) other;
        return Intrinsics.areEqual(this.type, newCloudLoginMessage.type) && Intrinsics.areEqual(this.messageId, newCloudLoginMessage.messageId) && Intrinsics.areEqual(this.data, newCloudLoginMessage.data);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.messageId.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "NewCloudLoginMessage(type=" + this.type + ", messageId=" + this.messageId + ", data=" + this.data + ')';
    }

    /* JADX INFO: compiled from: NewCloudLoginMessage.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<NewCloudLoginMessage> serializer() {
            return NewCloudLoginMessage$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ NewCloudLoginMessage(int seen1, @SerialName("type") String type, @SerialName("message_id") String messageId, @SerialName("data") Data data, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen1 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 7, NewCloudLoginMessage$$serializer.INSTANCE.getDescriptor());
        }
        this.type = type;
        this.messageId = messageId;
        this.data = data;
    }

    public NewCloudLoginMessage(String type, String messageId, Data data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(data, "data");
        this.type = type;
        this.messageId = messageId;
        this.data = data;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_login_release(NewCloudLoginMessage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.type);
        output.encodeStringElement(serialDesc, 1, self.messageId);
        output.encodeSerializableElement(serialDesc, 2, NewCloudLoginMessage$Data$$serializer.INSTANCE, self.data);
    }

    public final String getType() {
        return this.type;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final Data getData() {
        return this.data;
    }

    /* JADX INFO: compiled from: NewCloudLoginMessage.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 P2\u00020\u0001:\u0003OPQB¹\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016Bw\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u000bHÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\u0093\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001J\u0013\u0010C\u001a\u00020\u000b2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001J&\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MHÁ\u0001¢\u0006\u0002\bNR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0019\u001a\u0004\b\n\u0010%R\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001bR\u001c\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001bR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010.R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0019\u001a\u0004\b0\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010\u001bR\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0019\u001a\u0004\b4\u0010\u001b¨\u0006R"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data;", "", "seen1", "", "clientId", "", "scopes", "", "state", "sdkVersion", "isPortrait", "", "info", "trackInfo", "loginVersion", "responseType", "redirectUri", "codeChallenge", "codeChallengeMethod", "extra", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId$annotations", "()V", "getClientId", "()Ljava/lang/String;", "getCodeChallenge$annotations", "getCodeChallenge", "getCodeChallengeMethod$annotations", "getCodeChallengeMethod", "getExtra$annotations", "getExtra", "getInfo$annotations", "getInfo", "isPortrait$annotations", "()Z", "getLoginVersion$annotations", "getLoginVersion", "getRedirectUri$annotations", "getRedirectUri", "getResponseType$annotations", "getResponseType", "getScopes$annotations", "getScopes", "()Ljava/util/List;", "getSdkVersion$annotations", "getSdkVersion", "getState$annotations", "getState", "getTrackInfo$annotations", "getTrackInfo", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "Extra", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Serializable
    public static final /* data */ class Data {
        private final String clientId;
        private final String codeChallenge;
        private final String codeChallengeMethod;
        private final String extra;
        private final String info;
        private final boolean isPortrait;
        private final String loginVersion;
        private final String redirectUri;
        private final String responseType;
        private final List<String> scopes;
        private final String sdkVersion;
        private final String state;
        private final String trackInfo;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null};

        @SerialName("com.taptap.sdk.request.client_id")
        public static /* synthetic */ void getClientId$annotations() {
        }

        @SerialName("com.taptap.sdk.request.code_challenge")
        public static /* synthetic */ void getCodeChallenge$annotations() {
        }

        @SerialName("com.taptap.sdk.request.code_challenge_method")
        public static /* synthetic */ void getCodeChallengeMethod$annotations() {
        }

        @SerialName("com.taptap.sdk.request.extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @SerialName("com.taptap.sdk.request.info")
        public static /* synthetic */ void getInfo$annotations() {
        }

        @SerialName("com.taptap.sdk.request.login_version")
        public static /* synthetic */ void getLoginVersion$annotations() {
        }

        @SerialName("com.taptap.sdk.request.redirect_uri")
        public static /* synthetic */ void getRedirectUri$annotations() {
        }

        @SerialName("com.taptap.sdk.request.response_type")
        public static /* synthetic */ void getResponseType$annotations() {
        }

        @SerialName("com.taptap.sdk.request.permissions")
        public static /* synthetic */ void getScopes$annotations() {
        }

        @SerialName("com.taptap.sdk.request.sdk_version")
        public static /* synthetic */ void getSdkVersion$annotations() {
        }

        @SerialName("com.taptap.sdk.request.state")
        public static /* synthetic */ void getState$annotations() {
        }

        @SerialName("com.taptap.sdk.request.track_info")
        public static /* synthetic */ void getTrackInfo$annotations() {
        }

        @SerialName("com.taptap.sdk.request.screen.portrait")
        public static /* synthetic */ void isPortrait$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getRedirectUri() {
            return this.redirectUri;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getExtra() {
            return this.extra;
        }

        public final List<String> component2() {
            return this.scopes;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSdkVersion() {
            return this.sdkVersion;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsPortrait() {
            return this.isPortrait;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getInfo() {
            return this.info;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getTrackInfo() {
            return this.trackInfo;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getLoginVersion() {
            return this.loginVersion;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getResponseType() {
            return this.responseType;
        }

        public final Data copy(String clientId, List<String> scopes, String state, String sdkVersion, boolean isPortrait, String info, String trackInfo, String loginVersion, String responseType, String redirectUri, String codeChallenge, String codeChallengeMethod, String extra) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(trackInfo, "trackInfo");
            Intrinsics.checkNotNullParameter(loginVersion, "loginVersion");
            Intrinsics.checkNotNullParameter(responseType, "responseType");
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
            Intrinsics.checkNotNullParameter(extra, "extra");
            return new Data(clientId, scopes, state, sdkVersion, isPortrait, info, trackInfo, loginVersion, responseType, redirectUri, codeChallenge, codeChallengeMethod, extra);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.clientId, data.clientId) && Intrinsics.areEqual(this.scopes, data.scopes) && Intrinsics.areEqual(this.state, data.state) && Intrinsics.areEqual(this.sdkVersion, data.sdkVersion) && this.isPortrait == data.isPortrait && Intrinsics.areEqual(this.info, data.info) && Intrinsics.areEqual(this.trackInfo, data.trackInfo) && Intrinsics.areEqual(this.loginVersion, data.loginVersion) && Intrinsics.areEqual(this.responseType, data.responseType) && Intrinsics.areEqual(this.redirectUri, data.redirectUri) && Intrinsics.areEqual(this.codeChallenge, data.codeChallenge) && Intrinsics.areEqual(this.codeChallengeMethod, data.codeChallengeMethod) && Intrinsics.areEqual(this.extra, data.extra);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((((this.clientId.hashCode() * 31) + this.scopes.hashCode()) * 31) + this.state.hashCode()) * 31) + this.sdkVersion.hashCode()) * 31) + Boolean.hashCode(this.isPortrait)) * 31) + this.info.hashCode()) * 31) + this.trackInfo.hashCode()) * 31) + this.loginVersion.hashCode()) * 31) + this.responseType.hashCode()) * 31) + this.redirectUri.hashCode()) * 31;
            String str = this.codeChallenge;
            return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.codeChallengeMethod.hashCode()) * 31) + this.extra.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Data(clientId=").append(this.clientId).append(", scopes=").append(this.scopes).append(", state=").append(this.state).append(", sdkVersion=").append(this.sdkVersion).append(", isPortrait=").append(this.isPortrait).append(", info=").append(this.info).append(", trackInfo=").append(this.trackInfo).append(", loginVersion=").append(this.loginVersion).append(", responseType=").append(this.responseType).append(", redirectUri=").append(this.redirectUri).append(", codeChallenge=").append(this.codeChallenge).append(", codeChallengeMethod=");
            sb.append(this.codeChallengeMethod).append(", extra=").append(this.extra).append(')');
            return sb.toString();
        }

        /* JADX INFO: compiled from: NewCloudLoginMessage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return NewCloudLoginMessage$Data$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Data(int seen1, @SerialName("com.taptap.sdk.request.client_id") String clientId, @SerialName("com.taptap.sdk.request.permissions") List scopes, @SerialName("com.taptap.sdk.request.state") String state, @SerialName("com.taptap.sdk.request.sdk_version") String sdkVersion, @SerialName("com.taptap.sdk.request.screen.portrait") boolean isPortrait, @SerialName("com.taptap.sdk.request.info") String info, @SerialName("com.taptap.sdk.request.track_info") String trackInfo, @SerialName("com.taptap.sdk.request.login_version") String loginVersion, @SerialName("com.taptap.sdk.request.response_type") String responseType, @SerialName("com.taptap.sdk.request.redirect_uri") String redirectUri, @SerialName("com.taptap.sdk.request.code_challenge") String codeChallenge, @SerialName("com.taptap.sdk.request.code_challenge_method") String codeChallengeMethod, @SerialName("com.taptap.sdk.request.extra") String extra, SerializationConstructorMarker serializationConstructorMarker) {
            if (7167 != (seen1 & 7167)) {
                PluginExceptionsKt.throwMissingFieldException(seen1, 7167, NewCloudLoginMessage$Data$$serializer.INSTANCE.getDescriptor());
            }
            this.clientId = clientId;
            this.scopes = scopes;
            this.state = state;
            this.sdkVersion = sdkVersion;
            this.isPortrait = isPortrait;
            this.info = info;
            this.trackInfo = trackInfo;
            this.loginVersion = loginVersion;
            this.responseType = responseType;
            this.redirectUri = redirectUri;
            if ((seen1 & 1024) == 0) {
                this.codeChallenge = null;
            } else {
                this.codeChallenge = codeChallenge;
            }
            this.codeChallengeMethod = codeChallengeMethod;
            this.extra = extra;
        }

        public Data(String clientId, List<String> scopes, String state, String sdkVersion, boolean isPortrait, String info, String trackInfo, String loginVersion, String responseType, String redirectUri, String codeChallenge, String codeChallengeMethod, String extra) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(trackInfo, "trackInfo");
            Intrinsics.checkNotNullParameter(loginVersion, "loginVersion");
            Intrinsics.checkNotNullParameter(responseType, "responseType");
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
            Intrinsics.checkNotNullParameter(extra, "extra");
            this.clientId = clientId;
            this.scopes = scopes;
            this.state = state;
            this.sdkVersion = sdkVersion;
            this.isPortrait = isPortrait;
            this.info = info;
            this.trackInfo = trackInfo;
            this.loginVersion = loginVersion;
            this.responseType = responseType;
            this.redirectUri = redirectUri;
            this.codeChallenge = codeChallenge;
            this.codeChallengeMethod = codeChallengeMethod;
            this.extra = extra;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$tap_login_release(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.clientId);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.scopes);
            output.encodeStringElement(serialDesc, 2, self.state);
            output.encodeStringElement(serialDesc, 3, self.sdkVersion);
            output.encodeBooleanElement(serialDesc, 4, self.isPortrait);
            output.encodeStringElement(serialDesc, 5, self.info);
            output.encodeStringElement(serialDesc, 6, self.trackInfo);
            output.encodeStringElement(serialDesc, 7, self.loginVersion);
            output.encodeStringElement(serialDesc, 8, self.responseType);
            output.encodeStringElement(serialDesc, 9, self.redirectUri);
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.codeChallenge != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.codeChallenge);
            }
            output.encodeStringElement(serialDesc, 11, self.codeChallengeMethod);
            output.encodeStringElement(serialDesc, 12, self.extra);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Data(String str, List list, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str12;
            if ((i & 1024) == 0) {
                str12 = str9;
            } else {
                str12 = null;
            }
            this(str, list, str2, str3, z, str4, str5, str6, str7, str8, str12, str10, str11);
        }

        public final String getClientId() {
            return this.clientId;
        }

        public final List<String> getScopes() {
            return this.scopes;
        }

        public final String getState() {
            return this.state;
        }

        public final String getSdkVersion() {
            return this.sdkVersion;
        }

        public final boolean isPortrait() {
            return this.isPortrait;
        }

        public final String getInfo() {
            return this.info;
        }

        public final String getTrackInfo() {
            return this.trackInfo;
        }

        public final String getLoginVersion() {
            return this.loginVersion;
        }

        public final String getResponseType() {
            return this.responseType;
        }

        public final String getRedirectUri() {
            return this.redirectUri;
        }

        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        public final String getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        public final String getExtra() {
            return this.extra;
        }

        /* JADX INFO: compiled from: NewCloudLoginMessage.kt */
        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data$Extra;", "", "seen1", "", "preApproved", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(I)V", "getPreApproved$annotations", "()V", "getPreApproved", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        @Serializable
        public static final /* data */ class Extra {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final int preApproved;

            public static /* synthetic */ Extra copy$default(Extra extra, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = extra.preApproved;
                }
                return extra.copy(i);
            }

            @SerialName("preapproved")
            public static /* synthetic */ void getPreApproved$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getPreApproved() {
                return this.preApproved;
            }

            public final Extra copy(int preApproved) {
                return new Extra(preApproved);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Extra) && this.preApproved == ((Extra) other).preApproved;
            }

            public int hashCode() {
                return Integer.hashCode(this.preApproved);
            }

            public String toString() {
                return "Extra(preApproved=" + this.preApproved + ')';
            }

            /* JADX INFO: compiled from: NewCloudLoginMessage.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data$Extra$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/NewCloudLoginMessage$Data$Extra;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer<Extra> serializer() {
                    return NewCloudLoginMessage$Data$Extra$$serializer.INSTANCE;
                }
            }

            public Extra(int preApproved) {
                this.preApproved = preApproved;
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ Extra(int seen1, @SerialName("preapproved") int preApproved, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (seen1 & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(seen1, 1, NewCloudLoginMessage$Data$Extra$$serializer.INSTANCE.getDescriptor());
                }
                this.preApproved = preApproved;
            }

            public final int getPreApproved() {
                return this.preApproved;
            }
        }
    }
}
