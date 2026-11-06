package com.taptap.sdk.db.event.model;

import com.kwad.sdk.api.model.AdnName;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: TapPlayGameDurationBean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 )2\u00020\u0001:\u0002()B5\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J#\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J!\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÇ\u0001R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/taptap/sdk/db/event/model/TapPlayGameDurationBean;", "", "seen1", "", "deviceDuration", "", "userDuration", "", "Lcom/taptap/sdk/db/event/model/TapUserDurationBean;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JLjava/util/List;)V", "getDeviceDuration$annotations", "()V", "getDeviceDuration", "()J", "setDeviceDuration", "(J)V", "getUserDuration$annotations", "getUserDuration", "()Ljava/util/List;", "setUserDuration", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapPlayGameDurationBean {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long deviceDuration;
    private List<TapUserDurationBean> userDuration;

    public TapPlayGameDurationBean() {
        this(0L, (List) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TapPlayGameDurationBean copy$default(TapPlayGameDurationBean tapPlayGameDurationBean, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = tapPlayGameDurationBean.deviceDuration;
        }
        if ((i & 2) != 0) {
            list = tapPlayGameDurationBean.userDuration;
        }
        return tapPlayGameDurationBean.copy(j, list);
    }

    @SerialName("deviceDuration")
    public static /* synthetic */ void getDeviceDuration$annotations() {
    }

    @SerialName("userDuration")
    public static /* synthetic */ void getUserDuration$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDeviceDuration() {
        return this.deviceDuration;
    }

    public final List<TapUserDurationBean> component2() {
        return this.userDuration;
    }

    public final TapPlayGameDurationBean copy(long deviceDuration, List<TapUserDurationBean> userDuration) {
        Intrinsics.checkNotNullParameter(userDuration, "userDuration");
        return new TapPlayGameDurationBean(deviceDuration, userDuration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapPlayGameDurationBean)) {
            return false;
        }
        TapPlayGameDurationBean tapPlayGameDurationBean = (TapPlayGameDurationBean) other;
        return this.deviceDuration == tapPlayGameDurationBean.deviceDuration && Intrinsics.areEqual(this.userDuration, tapPlayGameDurationBean.userDuration);
    }

    public int hashCode() {
        return (Long.hashCode(this.deviceDuration) * 31) + this.userDuration.hashCode();
    }

    public String toString() {
        return "TapPlayGameDurationBean(deviceDuration=" + this.deviceDuration + ", userDuration=" + this.userDuration + ')';
    }

    /* JADX INFO: compiled from: TapPlayGameDurationBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/db/event/model/TapPlayGameDurationBean$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/db/event/model/TapPlayGameDurationBean;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapPlayGameDurationBean> serializer() {
            return TapPlayGameDurationBean$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapPlayGameDurationBean(int i, @SerialName("deviceDuration") long j, @SerialName("userDuration") List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, TapPlayGameDurationBean$$serializer.INSTANCE.getDescriptor());
        }
        this.deviceDuration = (i & 1) == 0 ? -1L : j;
        if ((i & 2) == 0) {
            this.userDuration = new ArrayList();
        } else {
            this.userDuration = list;
        }
    }

    public TapPlayGameDurationBean(long j, List<TapUserDurationBean> userDuration) {
        Intrinsics.checkNotNullParameter(userDuration, "userDuration");
        this.deviceDuration = j;
        this.userDuration = userDuration;
    }

    @JvmStatic
    public static final void write$Self(TapPlayGameDurationBean self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.deviceDuration != -1) {
            output.encodeLongElement(serialDesc, 0, self.deviceDuration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.userDuration, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 1, new ArrayListSerializer(TapUserDurationBean$$serializer.INSTANCE), self.userDuration);
        }
    }

    public final long getDeviceDuration() {
        return this.deviceDuration;
    }

    public final void setDeviceDuration(long j) {
        this.deviceDuration = j;
    }

    public /* synthetic */ TapPlayGameDurationBean(long j, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1L : j, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    public final List<TapUserDurationBean> getUserDuration() {
        return this.userDuration;
    }

    public final void setUserDuration(List<TapUserDurationBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.userDuration = list;
    }
}
