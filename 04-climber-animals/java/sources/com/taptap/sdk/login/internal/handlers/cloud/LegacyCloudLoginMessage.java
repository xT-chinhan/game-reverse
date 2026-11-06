package com.taptap.sdk.login.internal.handlers.cloud;

import com.anythink.core.api.ATAdConst;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: compiled from: LegacyCloudLoginMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0003&'(B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J!\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÇ\u0001R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0013¨\u0006)"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage;", "", "seen1", "", "type", "", "id", "data", "Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Data;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Data;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Data;)V", "getData$annotations", "()V", "getData", "()Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Data;", "getId$annotations", "getId", "()Ljava/lang/String;", "getType$annotations", "getType", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "Data", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class LegacyCloudLoginMessage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Data data;
    private final String id;
    private final String type;

    public static /* synthetic */ LegacyCloudLoginMessage copy$default(LegacyCloudLoginMessage legacyCloudLoginMessage, String str, String str2, Data data, int i, Object obj) {
        if ((i & 1) != 0) {
            str = legacyCloudLoginMessage.type;
        }
        if ((i & 2) != 0) {
            str2 = legacyCloudLoginMessage.id;
        }
        if ((i & 4) != 0) {
            data = legacyCloudLoginMessage.data;
        }
        return legacyCloudLoginMessage.copy(str, str2, data);
    }

    @SerialName("data")
    public static /* synthetic */ void getData$annotations() {
    }

    @SerialName("message_id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    public final LegacyCloudLoginMessage copy(String type, String id, Data data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(data, "data");
        return new LegacyCloudLoginMessage(type, id, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyCloudLoginMessage)) {
            return false;
        }
        LegacyCloudLoginMessage legacyCloudLoginMessage = (LegacyCloudLoginMessage) other;
        return Intrinsics.areEqual(this.type, legacyCloudLoginMessage.type) && Intrinsics.areEqual(this.id, legacyCloudLoginMessage.id) && Intrinsics.areEqual(this.data, legacyCloudLoginMessage.data);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "LegacyCloudLoginMessage(type=" + this.type + ", id=" + this.id + ", data=" + this.data + ')';
    }

    /* JADX INFO: compiled from: LegacyCloudLoginMessage.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LegacyCloudLoginMessage> serializer() {
            return LegacyCloudLoginMessage$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LegacyCloudLoginMessage(int i, @SerialName("type") String str, @SerialName("message_id") String str2, @SerialName("data") Data data, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, LegacyCloudLoginMessage$$serializer.INSTANCE.getDescriptor());
        }
        this.type = str;
        this.id = str2;
        this.data = data;
    }

    public LegacyCloudLoginMessage(String type, String id, Data data) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(data, "data");
        this.type = type;
        this.id = id;
        this.data = data;
    }

    @JvmStatic
    public static final void write$Self(LegacyCloudLoginMessage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.type);
        output.encodeStringElement(serialDesc, 1, self.id);
        output.encodeSerializableElement(serialDesc, 2, LegacyCloudLoginMessage$Data$$serializer.INSTANCE, self.data);
    }

    public final String getType() {
        return this.type;
    }

    public final String getId() {
        return this.id;
    }

    public final Data getData() {
        return this.data;
    }

    /* JADX INFO: compiled from: LegacyCloudLoginMessage.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@AB\u0089\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BW\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003Jp\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001J!\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\n\u0010\u001bR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\"R\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017¨\u0006B"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Data;", "", "seen1", "", "clientId", "", "scopes", "", "state", "sdkVersion", "isPortrait", "", "sdkInfo", "responseType", "codeChallenge", "method", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId$annotations", "()V", "getClientId", "()Ljava/lang/String;", "getCodeChallenge$annotations", "getCodeChallenge", "isPortrait$annotations", "()Z", "getMethod$annotations", "getMethod", "getResponseType$annotations", "getResponseType", "getScopes$annotations", "getScopes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSdkInfo$annotations", "getSdkInfo", "getSdkVersion$annotations", "getSdkVersion", "getState$annotations", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Data;", "equals", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Serializable
    public static final /* data */ class Data {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String clientId;
        private final String codeChallenge;
        private final boolean isPortrait;
        private final String method;
        private final String responseType;
        private final String[] scopes;
        private final String sdkInfo;
        private final String sdkVersion;
        private final String state;

        @SerialName("client_id")
        public static /* synthetic */ void getClientId$annotations() {
        }

        @SerialName("code_challenge")
        public static /* synthetic */ void getCodeChallenge$annotations() {
        }

        @SerialName("code_challenge_method")
        public static /* synthetic */ void getMethod$annotations() {
        }

        @SerialName("response_type")
        public static /* synthetic */ void getResponseType$annotations() {
        }

        @SerialName("scopes")
        public static /* synthetic */ void getScopes$annotations() {
        }

        @SerialName(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO)
        public static /* synthetic */ void getSdkInfo$annotations() {
        }

        @SerialName("sdk_version")
        public static /* synthetic */ void getSdkVersion$annotations() {
        }

        @SerialName("state")
        public static /* synthetic */ void getState$annotations() {
        }

        @SerialName("portrait")
        public static /* synthetic */ void isPortrait$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String[] getScopes() {
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
        public final String getSdkInfo() {
            return this.sdkInfo;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getResponseType() {
            return this.responseType;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        public final Data copy(String clientId, String[] scopes, String state, String sdkVersion, boolean isPortrait, String sdkInfo, String responseType, String codeChallenge, String method) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
            Intrinsics.checkNotNullParameter(sdkInfo, "sdkInfo");
            Intrinsics.checkNotNullParameter(responseType, "responseType");
            Intrinsics.checkNotNullParameter(method, "method");
            return new Data(clientId, scopes, state, sdkVersion, isPortrait, sdkInfo, responseType, codeChallenge, method);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.clientId, data.clientId) && Intrinsics.areEqual(this.scopes, data.scopes) && Intrinsics.areEqual(this.state, data.state) && Intrinsics.areEqual(this.sdkVersion, data.sdkVersion) && this.isPortrait == data.isPortrait && Intrinsics.areEqual(this.sdkInfo, data.sdkInfo) && Intrinsics.areEqual(this.responseType, data.responseType) && Intrinsics.areEqual(this.codeChallenge, data.codeChallenge) && Intrinsics.areEqual(this.method, data.method);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        public int hashCode() {
            int iHashCode = ((((((this.clientId.hashCode() * 31) + Arrays.hashCode(this.scopes)) * 31) + this.state.hashCode()) * 31) + this.sdkVersion.hashCode()) * 31;
            boolean z = this.isPortrait;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int iHashCode2 = (((((iHashCode + r1) * 31) + this.sdkInfo.hashCode()) * 31) + this.responseType.hashCode()) * 31;
            String str = this.codeChallenge;
            return ((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.method.hashCode();
        }

        public String toString() {
            return "Data(clientId=" + this.clientId + ", scopes=" + Arrays.toString(this.scopes) + ", state=" + this.state + ", sdkVersion=" + this.sdkVersion + ", isPortrait=" + this.isPortrait + ", sdkInfo=" + this.sdkInfo + ", responseType=" + this.responseType + ", codeChallenge=" + this.codeChallenge + ", method=" + this.method + ')';
        }

        /* JADX INFO: compiled from: LegacyCloudLoginMessage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Data$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/LegacyCloudLoginMessage$Data;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return LegacyCloudLoginMessage$Data$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Data(int i, @SerialName("client_id") String str, @SerialName("scopes") String[] strArr, @SerialName("state") String str2, @SerialName("sdk_version") String str3, @SerialName("portrait") boolean z, @SerialName(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO) String str4, @SerialName("response_type") String str5, @SerialName("code_challenge") String str6, @SerialName("code_challenge_method") String str7, SerializationConstructorMarker serializationConstructorMarker) {
            if (383 != (i & MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400)) {
                PluginExceptionsKt.throwMissingFieldException(i, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, LegacyCloudLoginMessage$Data$$serializer.INSTANCE.getDescriptor());
            }
            this.clientId = str;
            this.scopes = strArr;
            this.state = str2;
            this.sdkVersion = str3;
            this.isPortrait = z;
            this.sdkInfo = str4;
            this.responseType = str5;
            if ((i & 128) == 0) {
                this.codeChallenge = null;
            } else {
                this.codeChallenge = str6;
            }
            this.method = str7;
        }

        public Data(String clientId, String[] scopes, String state, String sdkVersion, boolean z, String sdkInfo, String responseType, String str, String method) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
            Intrinsics.checkNotNullParameter(sdkInfo, "sdkInfo");
            Intrinsics.checkNotNullParameter(responseType, "responseType");
            Intrinsics.checkNotNullParameter(method, "method");
            this.clientId = clientId;
            this.scopes = scopes;
            this.state = state;
            this.sdkVersion = sdkVersion;
            this.isPortrait = z;
            this.sdkInfo = sdkInfo;
            this.responseType = responseType;
            this.codeChallenge = str;
            this.method = method;
        }

        @JvmStatic
        public static final void write$Self(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            output.encodeStringElement(serialDesc, 0, self.clientId);
            output.encodeSerializableElement(serialDesc, 1, new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE), self.scopes);
            output.encodeStringElement(serialDesc, 2, self.state);
            output.encodeStringElement(serialDesc, 3, self.sdkVersion);
            output.encodeBooleanElement(serialDesc, 4, self.isPortrait);
            output.encodeStringElement(serialDesc, 5, self.sdkInfo);
            output.encodeStringElement(serialDesc, 6, self.responseType);
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.codeChallenge != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.codeChallenge);
            }
            output.encodeStringElement(serialDesc, 8, self.method);
        }

        public /* synthetic */ Data(String str, String[] strArr, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, strArr, str2, str3, z, str4, str5, (i & 128) != 0 ? null : str6, str7);
        }

        public final String getClientId() {
            return this.clientId;
        }

        public final String[] getScopes() {
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

        public final String getSdkInfo() {
            return this.sdkInfo;
        }

        public final String getResponseType() {
            return this.responseType;
        }

        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        public final String getMethod() {
            return this.method;
        }
    }
}
