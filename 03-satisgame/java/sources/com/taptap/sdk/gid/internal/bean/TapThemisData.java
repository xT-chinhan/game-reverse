package com.taptap.sdk.gid.internal.bean;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: TapThemisData.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0002'(B9\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB%\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J!\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÇ\u0001R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/taptap/sdk/gid/internal/bean/TapThemisData;", "", "seen1", "", f.R, "", "code", "length", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;IJ)V", "getCode$annotations", "()V", "getCode", "()I", "getData$annotations", "getData", "()Ljava/lang/String;", "getLength$annotations", "getLength", "()J", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-gid_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapThemisData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int code;
    private final String data;
    private final long length;

    public TapThemisData() {
        this((String) null, 0, 0L, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TapThemisData copy$default(TapThemisData tapThemisData, String str, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tapThemisData.data;
        }
        if ((i2 & 2) != 0) {
            i = tapThemisData.code;
        }
        if ((i2 & 4) != 0) {
            j = tapThemisData.length;
        }
        return tapThemisData.copy(str, i, j);
    }

    @SerialName("code")
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName(f.R)
    public static /* synthetic */ void getData$annotations() {
    }

    @SerialName("length")
    public static /* synthetic */ void getLength$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLength() {
        return this.length;
    }

    public final TapThemisData copy(String data, int code, long length) {
        return new TapThemisData(data, code, length);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapThemisData)) {
            return false;
        }
        TapThemisData tapThemisData = (TapThemisData) other;
        return Intrinsics.areEqual(this.data, tapThemisData.data) && this.code == tapThemisData.code && this.length == tapThemisData.length;
    }

    public int hashCode() {
        String str = this.data;
        return ((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.code)) * 31) + Long.hashCode(this.length);
    }

    public String toString() {
        return "TapThemisData(data=" + this.data + ", code=" + this.code + ", length=" + this.length + ')';
    }

    /* JADX INFO: compiled from: TapThemisData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/gid/internal/bean/TapThemisData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/gid/internal/bean/TapThemisData;", "tap-gid_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapThemisData> serializer() {
            return TapThemisData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapThemisData(int i, @SerialName(f.R) String str, @SerialName("code") int i2, @SerialName("length") long j, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, TapThemisData$$serializer.INSTANCE.getDescriptor());
        }
        this.data = (i & 1) == 0 ? null : str;
        if ((i & 2) == 0) {
            this.code = -1;
        } else {
            this.code = i2;
        }
        if ((i & 4) == 0) {
            this.length = -1L;
        } else {
            this.length = j;
        }
    }

    public TapThemisData(String str, int i, long j) {
        this.data = str;
        this.code = i;
        this.length = j;
    }

    @JvmStatic
    public static final void write$Self(TapThemisData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.data);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.code != -1) {
            output.encodeIntElement(serialDesc, 1, self.code);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.length != -1) {
            output.encodeLongElement(serialDesc, 2, self.length);
        }
    }

    public /* synthetic */ TapThemisData(String str, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? -1L : j);
    }

    public final String getData() {
        return this.data;
    }

    public final int getCode() {
        return this.code;
    }

    public final long getLength() {
        return this.length;
    }
}
