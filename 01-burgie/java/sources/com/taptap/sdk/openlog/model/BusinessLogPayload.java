package com.taptap.sdk.openlog.model;

import com.taptap.sdk.db.constant.Common;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: BusinessLogPayload.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\fHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fJ\t\u0010#\u001a\u00020\u0005HÖ\u0001J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÁ\u0001¢\u0006\u0002\b+R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R*\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011¨\u0006."}, d2 = {"Lcom/taptap/sdk/openlog/model/BusinessLogPayload;", "", "seen1", "", "action", "", "customProject", "version", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", Common.Predefined.PROPERTIES, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAction$annotations", "()V", "getAction", "()Ljava/lang/String;", "getCustomProject$annotations", "getCustomProject", "getProperties$annotations", "getProperties", "()Ljava/util/Map;", "getVersion$annotations", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toMap", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_core_release", "$serializer", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class BusinessLogPayload {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String action;
    private final String customProject;
    private final Map<String, String> properties;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BusinessLogPayload copy$default(BusinessLogPayload businessLogPayload, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = businessLogPayload.action;
        }
        if ((i & 2) != 0) {
            str2 = businessLogPayload.customProject;
        }
        if ((i & 4) != 0) {
            str3 = businessLogPayload.version;
        }
        if ((i & 8) != 0) {
            map = businessLogPayload.properties;
        }
        return businessLogPayload.copy(str, str2, str3, map);
    }

    @SerialName("action")
    public static /* synthetic */ void getAction$annotations() {
    }

    @SerialName("tapsdk_project")
    public static /* synthetic */ void getCustomProject$annotations() {
    }

    @Transient
    public static /* synthetic */ void getProperties$annotations() {
    }

    @SerialName("tapsdk_version")
    public static /* synthetic */ void getVersion$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCustomProject() {
        return this.customProject;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final Map<String, String> component4() {
        return this.properties;
    }

    public final BusinessLogPayload copy(String action, String customProject, String version, Map<String, String> properties) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(customProject, "customProject");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new BusinessLogPayload(action, customProject, version, properties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BusinessLogPayload)) {
            return false;
        }
        BusinessLogPayload businessLogPayload = (BusinessLogPayload) other;
        return Intrinsics.areEqual(this.action, businessLogPayload.action) && Intrinsics.areEqual(this.customProject, businessLogPayload.customProject) && Intrinsics.areEqual(this.version, businessLogPayload.version) && Intrinsics.areEqual(this.properties, businessLogPayload.properties);
    }

    public int hashCode() {
        return (((((this.action.hashCode() * 31) + this.customProject.hashCode()) * 31) + this.version.hashCode()) * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "BusinessLogPayload(action=" + this.action + ", customProject=" + this.customProject + ", version=" + this.version + ", properties=" + this.properties + ')';
    }

    /* JADX INFO: compiled from: BusinessLogPayload.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/openlog/model/BusinessLogPayload$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/openlog/model/BusinessLogPayload;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BusinessLogPayload> serializer() {
            return BusinessLogPayload$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ BusinessLogPayload(int seen1, @SerialName("action") String action, @SerialName("tapsdk_project") String customProject, @SerialName("tapsdk_version") String version, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen1 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 7, BusinessLogPayload$$serializer.INSTANCE.getDescriptor());
        }
        this.action = action;
        this.customProject = customProject;
        this.version = version;
        this.properties = MapsKt.emptyMap();
    }

    public BusinessLogPayload(String action, String customProject, String version, Map<String, String> properties) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(customProject, "customProject");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.action = action;
        this.customProject = customProject;
        this.version = version;
        this.properties = properties;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_core_release(BusinessLogPayload self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.action);
        output.encodeStringElement(serialDesc, 1, self.customProject);
        output.encodeStringElement(serialDesc, 2, self.version);
    }

    public /* synthetic */ BusinessLogPayload(String str, String str2, String str3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getCustomProject() {
        return this.customProject;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Map<String, String> getProperties() {
        return this.properties;
    }

    public final Map<String, Object> toMap() {
        return MapsKt.plus(this.properties, MapsKt.mapOf(TuplesKt.to("action", this.action), TuplesKt.to("tapsdk_project", this.customProject), TuplesKt.to("tapsdk_version", this.version)));
    }
}
