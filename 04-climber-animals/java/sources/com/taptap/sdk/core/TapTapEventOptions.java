package com.taptap.sdk.core;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.core.serialize.JSONObjectSerializer;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.json.TapJson;
import com.umeng.analytics.pro.cl;
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
import org.json.JSONObject;

/* JADX INFO: compiled from: TapTapEventOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u0003456BY\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBC\b\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003JE\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\b\u0010,\u001a\u00020\u0005H\u0016J!\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203HÇ\u0001R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u001c\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Lcom/taptap/sdk/core/TapTapEventOptions;", "Lcom/taptap/sdk/core/TapTapSdkBaseOptions;", "seen1", "", "channel", "", "autoIAPEventEnabled", "", "overrideBuiltInParameters", Common.Predefined.PROPERTIES, "Lorg/json/JSONObject;", "disableAutoLogDeviceLogin", "enableTapTapEvent", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZZLorg/json/JSONObject;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ZZLorg/json/JSONObject;ZZ)V", "getAutoIAPEventEnabled$annotations", "()V", "getAutoIAPEventEnabled", "()Z", "getChannel$annotations", "getChannel", "()Ljava/lang/String;", "getDisableAutoLogDeviceLogin$annotations", "getDisableAutoLogDeviceLogin", "getEnableTapTapEvent$annotations", "getEnableTapTapEvent", "getOverrideBuiltInParameters$annotations", "getOverrideBuiltInParameters", "getProperties$annotations", "getProperties", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", AdnName.OTHER, "", TTDownloadField.TT_HASHCODE, "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Builder", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapTapEventOptions implements TapTapSdkBaseOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean autoIAPEventEnabled;
    private final String channel;
    private final boolean disableAutoLogDeviceLogin;
    private final boolean enableTapTapEvent;
    private final boolean overrideBuiltInParameters;
    private final JSONObject properties;

    public /* synthetic */ TapTapEventOptions(String str, boolean z, boolean z2, JSONObject jSONObject, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, z2, jSONObject, z3, z4);
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    @JvmStatic
    public static final Builder builder(TapTapEventOptions tapTapEventOptions) {
        return INSTANCE.builder(tapTapEventOptions);
    }

    public static /* synthetic */ TapTapEventOptions copy$default(TapTapEventOptions tapTapEventOptions, String str, boolean z, boolean z2, JSONObject jSONObject, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tapTapEventOptions.channel;
        }
        if ((i & 2) != 0) {
            z = tapTapEventOptions.autoIAPEventEnabled;
        }
        boolean z5 = z;
        if ((i & 4) != 0) {
            z2 = tapTapEventOptions.overrideBuiltInParameters;
        }
        boolean z6 = z2;
        if ((i & 8) != 0) {
            jSONObject = tapTapEventOptions.properties;
        }
        JSONObject jSONObject2 = jSONObject;
        if ((i & 16) != 0) {
            z3 = tapTapEventOptions.disableAutoLogDeviceLogin;
        }
        boolean z7 = z3;
        if ((i & 32) != 0) {
            z4 = tapTapEventOptions.enableTapTapEvent;
        }
        return tapTapEventOptions.copy(str, z5, z6, jSONObject2, z7, z4);
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

    @SerialName("enableTapTapEvent")
    public static /* synthetic */ void getEnableTapTapEvent$annotations() {
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
    public final boolean getEnableTapTapEvent() {
        return this.enableTapTapEvent;
    }

    public final TapTapEventOptions copy(String channel, boolean autoIAPEventEnabled, boolean overrideBuiltInParameters, JSONObject properties, boolean disableAutoLogDeviceLogin, boolean enableTapTapEvent) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new TapTapEventOptions(channel, autoIAPEventEnabled, overrideBuiltInParameters, properties, disableAutoLogDeviceLogin, enableTapTapEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapTapEventOptions)) {
            return false;
        }
        TapTapEventOptions tapTapEventOptions = (TapTapEventOptions) other;
        return Intrinsics.areEqual(this.channel, tapTapEventOptions.channel) && this.autoIAPEventEnabled == tapTapEventOptions.autoIAPEventEnabled && this.overrideBuiltInParameters == tapTapEventOptions.overrideBuiltInParameters && Intrinsics.areEqual(this.properties, tapTapEventOptions.properties) && this.disableAutoLogDeviceLogin == tapTapEventOptions.disableAutoLogDeviceLogin && this.enableTapTapEvent == tapTapEventOptions.enableTapTapEvent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.channel.hashCode() * 31;
        boolean z = this.autoIAPEventEnabled;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.overrideBuiltInParameters;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iHashCode2 = (((i + r2) * 31) + this.properties.hashCode()) * 31;
        boolean z3 = this.disableAutoLogDeviceLogin;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode2 + r3) * 31;
        boolean z4 = this.enableTapTapEvent;
        return i2 + (z4 ? 1 : z4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapTapEventOptions(int i, @SerialName("channel") String str, @SerialName("autoIAPEventEnabled") boolean z, @SerialName("overrideBuiltInParameters") boolean z2, @SerialName(Common.Predefined.PROPERTIES) @Serializable(with = JSONObjectSerializer.class) JSONObject jSONObject, @SerialName("disableAutoLogDeviceLogin") boolean z3, @SerialName("enableTapTapEvent") boolean z4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, TapTapEventOptions$$serializer.INSTANCE.getDescriptor());
        }
        this.channel = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.autoIAPEventEnabled = false;
        } else {
            this.autoIAPEventEnabled = z;
        }
        if ((i & 4) == 0) {
            this.overrideBuiltInParameters = false;
        } else {
            this.overrideBuiltInParameters = z2;
        }
        if ((i & 8) == 0) {
            this.properties = new JSONObject();
        } else {
            this.properties = jSONObject;
        }
        if ((i & 16) == 0) {
            this.disableAutoLogDeviceLogin = false;
        } else {
            this.disableAutoLogDeviceLogin = z3;
        }
        if ((i & 32) == 0) {
            this.enableTapTapEvent = true;
        } else {
            this.enableTapTapEvent = z4;
        }
    }

    private TapTapEventOptions(String str, boolean z, boolean z2, JSONObject jSONObject, boolean z3, boolean z4) {
        this.channel = str;
        this.autoIAPEventEnabled = z;
        this.overrideBuiltInParameters = z2;
        this.properties = jSONObject;
        this.disableAutoLogDeviceLogin = z3;
        this.enableTapTapEvent = z4;
    }

    @JvmStatic
    public static final void write$Self(TapTapEventOptions self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.channel, "")) {
            output.encodeStringElement(serialDesc, 0, self.channel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.autoIAPEventEnabled) {
            output.encodeBooleanElement(serialDesc, 1, self.autoIAPEventEnabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.overrideBuiltInParameters) {
            output.encodeBooleanElement(serialDesc, 2, self.overrideBuiltInParameters);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.properties, new JSONObject())) {
            output.encodeSerializableElement(serialDesc, 3, JSONObjectSerializer.INSTANCE, self.properties);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.disableAutoLogDeviceLogin) {
            output.encodeBooleanElement(serialDesc, 4, self.disableAutoLogDeviceLogin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !self.enableTapTapEvent) {
            output.encodeBooleanElement(serialDesc, 5, self.enableTapTapEvent);
        }
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

    /* synthetic */ TapTapEventOptions(String str, boolean z, boolean z2, JSONObject jSONObject, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? new JSONObject() : jSONObject, (i & 16) == 0 ? z3 : false, (i & 32) != 0 ? true : z4);
    }

    public final JSONObject getProperties() {
        return this.properties;
    }

    public final boolean getDisableAutoLogDeviceLogin() {
        return this.disableAutoLogDeviceLogin;
    }

    public final boolean getEnableTapTapEvent() {
        return this.enableTapTapEvent;
    }

    public String toString() {
        String strEncodeToString;
        try {
            Json json = TapJson.INSTANCE.getJson();
            KSerializer<Object> kSerializerSerializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(TapTapEventOptions.class));
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
            Builder builder = new Builder();
            builder.channel(from.getChannel());
            builder.autoIAPEventEnabled(from.getAutoIAPEventEnabled());
            builder.overrideBuiltInParameters(from.getOverrideBuiltInParameters());
            builder.properties(from.getProperties());
            builder.disableAutoLogDeviceLogin(from.getDisableAutoLogDeviceLogin());
            builder.enableTapTapEvent(from.getEnableTapTapEvent());
            return builder;
        }
    }

    /* JADX INFO: compiled from: TapTapEventOptions.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/core/TapTapEventOptions$Builder;", "", "()V", "autoIAPEventEnabled", "", "channel", "", "disableAutoLogDeviceLogin", "enableTapTapEvent", "overrideBuiltInParameters", Common.Predefined.PROPERTIES, "Lorg/json/JSONObject;", "enabled", "build", "Lcom/taptap/sdk/core/TapTapEventOptions;", "disable", cl.q, "override", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private boolean autoIAPEventEnabled;
        private boolean disableAutoLogDeviceLogin;
        private boolean overrideBuiltInParameters;
        private String channel = "";
        private JSONObject properties = new JSONObject();
        private boolean enableTapTapEvent = true;

        public final Builder channel(String channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            return this;
        }

        public final Builder autoIAPEventEnabled(boolean enabled) {
            this.autoIAPEventEnabled = enabled;
            return this;
        }

        public final Builder overrideBuiltInParameters(boolean override) {
            this.overrideBuiltInParameters = override;
            return this;
        }

        public final Builder properties(JSONObject properties) {
            Intrinsics.checkNotNullParameter(properties, "properties");
            this.properties = properties;
            return this;
        }

        public final Builder disableAutoLogDeviceLogin(boolean disable) {
            this.disableAutoLogDeviceLogin = disable;
            return this;
        }

        public final Builder enableTapTapEvent(boolean enable) {
            this.enableTapTapEvent = enable;
            return this;
        }

        public final TapTapEventOptions build() {
            return new TapTapEventOptions(this.channel, this.autoIAPEventEnabled, this.overrideBuiltInParameters, this.properties, this.disableAutoLogDeviceLogin, this.enableTapTapEvent, null);
        }
    }
}
