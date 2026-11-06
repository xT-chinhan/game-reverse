package com.taptap.sdk.core;

import com.taptap.sdk.core.serialize.JSONObjectSerializer;
import com.taptap.sdk.db.constant.Common;
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
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.modules.SerializersModule;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapTapEventOptions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0003=>?Bo\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\r\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BY\b\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u0012J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J[\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\b\u00104\u001a\u00020\u0005H\u0016J&\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;HÁ\u0001¢\u0006\u0002\b<R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R\u001c\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u001c\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0019R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010&¨\u0006@"}, d2 = {"Lcom/taptap/sdk/core/TapTapEventOptions;", "Lcom/taptap/sdk/core/TapTapSdkBaseOptions;", "seen1", "", "channel", "", "autoIAPEventEnabled", "", "overrideBuiltInParameters", Common.Predefined.PROPERTIES, "Lorg/json/JSONObject;", "disableAutoLogDeviceLogin", "oaidCert", "disableReflectionOAID", "enableTapTapEvent", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZZLorg/json/JSONObject;ZLjava/lang/String;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ZZLorg/json/JSONObject;ZLjava/lang/String;ZZ)V", "getAutoIAPEventEnabled$annotations", "()V", "getAutoIAPEventEnabled", "()Z", "getChannel$annotations", "getChannel", "()Ljava/lang/String;", "getDisableAutoLogDeviceLogin$annotations", "getDisableAutoLogDeviceLogin", "getDisableReflectionOAID$annotations", "getDisableReflectionOAID", "getEnableTapTapEvent$annotations", "getEnableTapTapEvent", "getOaidCert$annotations", "getOaidCert", "getOverrideBuiltInParameters$annotations", "getOverrideBuiltInParameters", "getProperties$annotations", "getProperties", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_db_release", "$serializer", "Builder", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapTapEventOptions implements TapTapSdkBaseOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean autoIAPEventEnabled;
    private final String channel;
    private final boolean disableAutoLogDeviceLogin;
    private final boolean disableReflectionOAID;
    private final boolean enableTapTapEvent;
    private final String oaidCert;
    private final boolean overrideBuiltInParameters;
    private final JSONObject properties;

    public /* synthetic */ TapTapEventOptions(String str, boolean z, boolean z2, JSONObject jSONObject, boolean z3, String str2, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, z2, jSONObject, z3, str2, z4, z5);
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    @JvmStatic
    public static final Builder builder(TapTapEventOptions tapTapEventOptions) {
        return INSTANCE.builder(tapTapEventOptions);
    }

    @SerialName("autoIAPEventEnabled")
    public static /* synthetic */ void getAutoIAPEventEnabled$annotations() {
    }

    @SerialName("channel")
    public static /* synthetic */ void getChannel$annotations() {
    }

    @SerialName("disableAutoLogDeviceLogin")
    public static /* synthetic */ void getDisableAutoLogDeviceLogin$annotations() {
    }

    @SerialName("disableReflectionOAID")
    public static /* synthetic */ void getDisableReflectionOAID$annotations() {
    }

    @SerialName("enableTapTapEvent")
    public static /* synthetic */ void getEnableTapTapEvent$annotations() {
    }

    @SerialName("oaidCert")
    public static /* synthetic */ void getOaidCert$annotations() {
    }

    @SerialName("overrideBuiltInParameters")
    public static /* synthetic */ void getOverrideBuiltInParameters$annotations() {
    }

    @SerialName(Common.Predefined.PROPERTIES)
    @Serializable(with = JSONObjectSerializer.class)
    public static /* synthetic */ void getProperties$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAutoIAPEventEnabled() {
        return this.autoIAPEventEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getOverrideBuiltInParameters() {
        return this.overrideBuiltInParameters;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final JSONObject getProperties() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDisableAutoLogDeviceLogin() {
        return this.disableAutoLogDeviceLogin;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOaidCert() {
        return this.oaidCert;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDisableReflectionOAID() {
        return this.disableReflectionOAID;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getEnableTapTapEvent() {
        return this.enableTapTapEvent;
    }

    public final TapTapEventOptions copy(String channel, boolean autoIAPEventEnabled, boolean overrideBuiltInParameters, JSONObject properties, boolean disableAutoLogDeviceLogin, String oaidCert, boolean disableReflectionOAID, boolean enableTapTapEvent) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new TapTapEventOptions(channel, autoIAPEventEnabled, overrideBuiltInParameters, properties, disableAutoLogDeviceLogin, oaidCert, disableReflectionOAID, enableTapTapEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapTapEventOptions)) {
            return false;
        }
        TapTapEventOptions tapTapEventOptions = (TapTapEventOptions) other;
        return Intrinsics.areEqual(this.channel, tapTapEventOptions.channel) && this.autoIAPEventEnabled == tapTapEventOptions.autoIAPEventEnabled && this.overrideBuiltInParameters == tapTapEventOptions.overrideBuiltInParameters && Intrinsics.areEqual(this.properties, tapTapEventOptions.properties) && this.disableAutoLogDeviceLogin == tapTapEventOptions.disableAutoLogDeviceLogin && Intrinsics.areEqual(this.oaidCert, tapTapEventOptions.oaidCert) && this.disableReflectionOAID == tapTapEventOptions.disableReflectionOAID && this.enableTapTapEvent == tapTapEventOptions.enableTapTapEvent;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.channel.hashCode() * 31) + Boolean.hashCode(this.autoIAPEventEnabled)) * 31) + Boolean.hashCode(this.overrideBuiltInParameters)) * 31) + this.properties.hashCode()) * 31) + Boolean.hashCode(this.disableAutoLogDeviceLogin)) * 31;
        String str = this.oaidCert;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.disableReflectionOAID)) * 31) + Boolean.hashCode(this.enableTapTapEvent);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapTapEventOptions(int seen1, @SerialName("channel") String channel, @SerialName("autoIAPEventEnabled") boolean autoIAPEventEnabled, @SerialName("overrideBuiltInParameters") boolean overrideBuiltInParameters, @SerialName(Common.Predefined.PROPERTIES) @Serializable(with = JSONObjectSerializer.class) JSONObject properties, @SerialName("disableAutoLogDeviceLogin") boolean disableAutoLogDeviceLogin, @SerialName("oaidCert") String oaidCert, @SerialName("disableReflectionOAID") boolean disableReflectionOAID, @SerialName("enableTapTapEvent") boolean enableTapTapEvent, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, TapTapEventOptions$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.channel = "";
        } else {
            this.channel = channel;
        }
        if ((seen1 & 2) == 0) {
            this.autoIAPEventEnabled = false;
        } else {
            this.autoIAPEventEnabled = autoIAPEventEnabled;
        }
        if ((seen1 & 4) == 0) {
            this.overrideBuiltInParameters = false;
        } else {
            this.overrideBuiltInParameters = overrideBuiltInParameters;
        }
        if ((seen1 & 8) == 0) {
            this.properties = new JSONObject();
        } else {
            this.properties = properties;
        }
        if ((seen1 & 16) == 0) {
            this.disableAutoLogDeviceLogin = false;
        } else {
            this.disableAutoLogDeviceLogin = disableAutoLogDeviceLogin;
        }
        if ((seen1 & 32) == 0) {
            this.oaidCert = null;
        } else {
            this.oaidCert = oaidCert;
        }
        if ((seen1 & 64) == 0) {
            this.disableReflectionOAID = true;
        } else {
            this.disableReflectionOAID = disableReflectionOAID;
        }
        if ((seen1 & 128) == 0) {
            this.enableTapTapEvent = true;
        } else {
            this.enableTapTapEvent = enableTapTapEvent;
        }
    }

    private TapTapEventOptions(String channel, boolean autoIAPEventEnabled, boolean overrideBuiltInParameters, JSONObject properties, boolean disableAutoLogDeviceLogin, String oaidCert, boolean disableReflectionOAID, boolean enableTapTapEvent) {
        this.channel = channel;
        this.autoIAPEventEnabled = autoIAPEventEnabled;
        this.overrideBuiltInParameters = overrideBuiltInParameters;
        this.properties = properties;
        this.disableAutoLogDeviceLogin = disableAutoLogDeviceLogin;
        this.oaidCert = oaidCert;
        this.disableReflectionOAID = disableReflectionOAID;
        this.enableTapTapEvent = enableTapTapEvent;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_db_release(TapTapEventOptions self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.channel, "");
        if (z2) {
            output.encodeStringElement(serialDesc, 0, self.channel);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 1) || self.autoIAPEventEnabled;
        if (z3) {
            output.encodeBooleanElement(serialDesc, 1, self.autoIAPEventEnabled);
        }
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 2) || self.overrideBuiltInParameters;
        if (z4) {
            output.encodeBooleanElement(serialDesc, 2, self.overrideBuiltInParameters);
        }
        boolean z5 = output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.properties, new JSONObject());
        if (z5) {
            output.encodeSerializableElement(serialDesc, 3, JSONObjectSerializer.INSTANCE, self.properties);
        }
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 4) || self.disableAutoLogDeviceLogin;
        if (z6) {
            output.encodeBooleanElement(serialDesc, 4, self.disableAutoLogDeviceLogin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.oaidCert != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.oaidCert);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 6) || !self.disableReflectionOAID;
        if (z7) {
            output.encodeBooleanElement(serialDesc, 6, self.disableReflectionOAID);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !self.enableTapTapEvent) {
            z = true;
        }
        if (z) {
            output.encodeBooleanElement(serialDesc, 7, self.enableTapTapEvent);
        }
    }

    /* synthetic */ TapTapEventOptions(String str, boolean z, boolean z2, JSONObject jSONObject, boolean z3, String str2, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? new JSONObject() : jSONObject, (i & 16) == 0 ? z3 : false, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? true : z4, (i & 128) == 0 ? z5 : true);
    }

    public final String getChannel() {
        return this.channel;
    }

    public final boolean getAutoIAPEventEnabled() {
        return this.autoIAPEventEnabled;
    }

    public final boolean getOverrideBuiltInParameters() {
        return this.overrideBuiltInParameters;
    }

    public final JSONObject getProperties() {
        return this.properties;
    }

    public final boolean getDisableAutoLogDeviceLogin() {
        return this.disableAutoLogDeviceLogin;
    }

    public final String getOaidCert() {
        return this.oaidCert;
    }

    public final boolean getDisableReflectionOAID() {
        return this.disableReflectionOAID;
    }

    public final boolean getEnableTapTapEvent() {
        return this.enableTapTapEvent;
    }

    public String toString() {
        TapJson this_$iv = TapJson.INSTANCE;
        String strEncodeToString = null;
        try {
            StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
            SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(TapTapEventOptions.class));
            Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, this);
        } catch (Exception e$iv) {
            TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
        }
        if (strEncodeToString != null) {
            return strEncodeToString;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: compiled from: TapTapEventOptions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0001¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/core/TapTapEventOptions$Companion;", "", "()V", "builder", "Lcom/taptap/sdk/core/TapTapEventOptions$Builder;", "from", "Lcom/taptap/sdk/core/TapTapEventOptions;", "serializer", "Lkotlinx/serialization/KSerializer;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapTapEventOptions> serializer() {
            return TapTapEventOptions$$serializer.INSTANCE;
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }

        @JvmStatic
        public final Builder builder(TapTapEventOptions from) {
            Intrinsics.checkNotNullParameter(from, "from");
            Builder $this$builder_u24lambda_u240 = new Builder();
            $this$builder_u24lambda_u240.channel(from.getChannel());
            $this$builder_u24lambda_u240.autoIAPEventEnabled(from.getAutoIAPEventEnabled());
            $this$builder_u24lambda_u240.overrideBuiltInParameters(from.getOverrideBuiltInParameters());
            $this$builder_u24lambda_u240.properties(from.getProperties());
            $this$builder_u24lambda_u240.disableAutoLogDeviceLogin(from.getDisableAutoLogDeviceLogin());
            $this$builder_u24lambda_u240.enableTapTapEvent(from.getEnableTapTapEvent());
            $this$builder_u24lambda_u240.disableReflectionOAID(from.getDisableReflectionOAID());
            $this$builder_u24lambda_u240.setOaidCert(from.getOaidCert());
            return $this$builder_u24lambda_u240;
        }
    }

    /* JADX INFO: compiled from: TapTapEventOptions.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/taptap/sdk/core/TapTapEventOptions$Builder;", "", "()V", "autoIAPEventEnabled", "", "channel", "", "disableAutoLogDeviceLogin", "disableReflectionOAID", "enableTapTapEvent", "oaidCert", "overrideBuiltInParameters", Common.Predefined.PROPERTIES, "Lorg/json/JSONObject;", "enabled", "build", "Lcom/taptap/sdk/core/TapTapEventOptions;", "disable", "enable", "override", "setOaidCert", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private boolean autoIAPEventEnabled;
        private boolean disableAutoLogDeviceLogin;
        private String oaidCert;
        private boolean overrideBuiltInParameters;
        private String channel = "";
        private JSONObject properties = new JSONObject();
        private boolean enableTapTapEvent = true;
        private boolean disableReflectionOAID = true;

        public final Builder channel(String channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            Builder $this$channel_u24lambda_u240 = this;
            $this$channel_u24lambda_u240.channel = channel;
            return this;
        }

        public final Builder autoIAPEventEnabled(boolean enabled) {
            Builder $this$autoIAPEventEnabled_u24lambda_u241 = this;
            $this$autoIAPEventEnabled_u24lambda_u241.autoIAPEventEnabled = enabled;
            return this;
        }

        public final Builder overrideBuiltInParameters(boolean override) {
            Builder $this$overrideBuiltInParameters_u24lambda_u242 = this;
            $this$overrideBuiltInParameters_u24lambda_u242.overrideBuiltInParameters = override;
            return this;
        }

        public final Builder properties(JSONObject properties) {
            Intrinsics.checkNotNullParameter(properties, "properties");
            Builder $this$properties_u24lambda_u243 = this;
            $this$properties_u24lambda_u243.properties = properties;
            return this;
        }

        public final Builder disableAutoLogDeviceLogin(boolean disable) {
            Builder $this$disableAutoLogDeviceLogin_u24lambda_u244 = this;
            $this$disableAutoLogDeviceLogin_u24lambda_u244.disableAutoLogDeviceLogin = disable;
            return this;
        }

        public final Builder enableTapTapEvent(boolean enable) {
            Builder $this$enableTapTapEvent_u24lambda_u245 = this;
            $this$enableTapTapEvent_u24lambda_u245.enableTapTapEvent = enable;
            return this;
        }

        public final Builder setOaidCert(String oaidCert) {
            Builder $this$setOaidCert_u24lambda_u246 = this;
            $this$setOaidCert_u24lambda_u246.oaidCert = oaidCert;
            return this;
        }

        public final Builder disableReflectionOAID(boolean disableReflectionOAID) {
            Builder $this$disableReflectionOAID_u24lambda_u247 = this;
            $this$disableReflectionOAID_u24lambda_u247.disableReflectionOAID = disableReflectionOAID;
            return this;
        }

        public final TapTapEventOptions build() {
            return new TapTapEventOptions(this.channel, this.autoIAPEventEnabled, this.overrideBuiltInParameters, this.properties, this.disableAutoLogDeviceLogin, this.oaidCert, this.disableReflectionOAID, this.enableTapTapEvent, null);
        }
    }
}
