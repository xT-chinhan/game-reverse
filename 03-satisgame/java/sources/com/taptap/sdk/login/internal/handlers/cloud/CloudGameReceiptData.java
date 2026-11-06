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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CloudGameReceiptData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B/\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÇ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameReceiptData;", "", "seen1", "", "success", "", "id", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/lang/String;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getSuccess$annotations", "getSuccess", "()Z", "component1", "component2", "copy", "equals", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class CloudGameReceiptData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public CloudGameReceiptData() {
        this(false, (String) null, 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ CloudGameReceiptData copy$default(CloudGameReceiptData cloudGameReceiptData, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = cloudGameReceiptData.success;
        }
        if ((i & 2) != 0) {
            str = cloudGameReceiptData.id;
        }
        return cloudGameReceiptData.copy(z, str);
    }

    @SerialName("message_id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("success")
    public static /* synthetic */ void getSuccess$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final CloudGameReceiptData copy(boolean success, String id) {
        return new CloudGameReceiptData(success, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudGameReceiptData)) {
            return false;
        }
        CloudGameReceiptData cloudGameReceiptData = (CloudGameReceiptData) other;
        return this.success == cloudGameReceiptData.success && Intrinsics.areEqual(this.id, cloudGameReceiptData.id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.id;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CloudGameReceiptData(success=" + this.success + ", id=" + this.id + ')';
    }

    /* JADX INFO: compiled from: CloudGameReceiptData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameReceiptData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/internal/handlers/cloud/CloudGameReceiptData;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CloudGameReceiptData> serializer() {
            return CloudGameReceiptData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CloudGameReceiptData(int i, @SerialName("success") boolean z, @SerialName("message_id") String str, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, CloudGameReceiptData$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.success = false;
        } else {
            this.success = z;
        }
        if ((i & 2) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
    }

    public CloudGameReceiptData(boolean z, String str) {
        this.success = z;
        this.id = str;
    }

    @JvmStatic
    public static final void write$Self(CloudGameReceiptData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.success) {
            output.encodeBooleanElement(serialDesc, 0, self.success);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.id);
        }
    }

    public /* synthetic */ CloudGameReceiptData(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getId() {
        return this.id;
    }
}
