package com.taptap.sdk.db.event.model;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
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

/* JADX INFO: compiled from: TapPlayGameDurationBean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 '2\u00020\u0001:\u0002&'B/\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J!\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÇ\u0001R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/taptap/sdk/db/event/model/TapUserDurationBean;", "", "seen1", "", "userId", "", MediationConstant.EXTRA_DURATION, "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;J)V", "getDuration$annotations", "()V", "getDuration", "()J", "setDuration", "(J)V", "getUserId$annotations", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapUserDurationBean {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private long duration;
    private String userId;

    public static /* synthetic */ TapUserDurationBean copy$default(TapUserDurationBean tapUserDurationBean, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tapUserDurationBean.userId;
        }
        if ((i & 2) != 0) {
            j = tapUserDurationBean.duration;
        }
        return tapUserDurationBean.copy(str, j);
    }

    @SerialName(MediationConstant.EXTRA_DURATION)
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("userId")
    public static /* synthetic */ void getUserId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final TapUserDurationBean copy(String userId, long duration) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new TapUserDurationBean(userId, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapUserDurationBean)) {
            return false;
        }
        TapUserDurationBean tapUserDurationBean = (TapUserDurationBean) other;
        return Intrinsics.areEqual(this.userId, tapUserDurationBean.userId) && this.duration == tapUserDurationBean.duration;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + Long.hashCode(this.duration);
    }

    public String toString() {
        return "TapUserDurationBean(userId=" + this.userId + ", duration=" + this.duration + ')';
    }

    /* JADX INFO: compiled from: TapPlayGameDurationBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/db/event/model/TapUserDurationBean$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/db/event/model/TapUserDurationBean;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapUserDurationBean> serializer() {
            return TapUserDurationBean$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapUserDurationBean(int i, @SerialName("userId") String str, @SerialName(MediationConstant.EXTRA_DURATION) long j, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, TapUserDurationBean$$serializer.INSTANCE.getDescriptor());
        }
        this.userId = str;
        if ((i & 2) == 0) {
            this.duration = 0L;
        } else {
            this.duration = j;
        }
    }

    public TapUserDurationBean(String userId, long j) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.userId = userId;
        this.duration = j;
    }

    @JvmStatic
    public static final void write$Self(TapUserDurationBean self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.userId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.duration != 0) {
            output.encodeLongElement(serialDesc, 1, self.duration);
        }
    }

    public /* synthetic */ TapUserDurationBean(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }
}
