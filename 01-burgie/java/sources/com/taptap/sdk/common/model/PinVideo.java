package com.taptap.sdk.common.model;

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

/* JADX INFO: compiled from: Infos.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B/\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/taptap/sdk/common/model/PinVideo;", "", "seen1", "", "duration", "", "thumbnail", "Lcom/taptap/sdk/common/model/Image;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLcom/taptap/sdk/common/model/Image;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JLcom/taptap/sdk/common/model/Image;)V", "getDuration$annotations", "()V", "getDuration", "()J", "getThumbnail$annotations", "getThumbnail", "()Lcom/taptap/sdk/common/model/Image;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_common_release", "$serializer", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class PinVideo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long duration;
    private final Image thumbnail;

    public PinVideo() {
        this(0L, (Image) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PinVideo copy$default(PinVideo pinVideo, long j, Image image, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pinVideo.duration;
        }
        if ((i & 2) != 0) {
            image = pinVideo.thumbnail;
        }
        return pinVideo.copy(j, image);
    }

    @SerialName("duration")
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("thumbnail")
    public static /* synthetic */ void getThumbnail$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Image getThumbnail() {
        return this.thumbnail;
    }

    public final PinVideo copy(long duration, Image thumbnail) {
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        return new PinVideo(duration, thumbnail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PinVideo)) {
            return false;
        }
        PinVideo pinVideo = (PinVideo) other;
        return this.duration == pinVideo.duration && Intrinsics.areEqual(this.thumbnail, pinVideo.thumbnail);
    }

    public int hashCode() {
        return (Long.hashCode(this.duration) * 31) + this.thumbnail.hashCode();
    }

    public String toString() {
        return "PinVideo(duration=" + this.duration + ", thumbnail=" + this.thumbnail + ')';
    }

    /* JADX INFO: compiled from: Infos.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/common/model/PinVideo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/common/model/PinVideo;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PinVideo> serializer() {
            return PinVideo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PinVideo(int seen1, @SerialName("duration") long duration, @SerialName("thumbnail") Image thumbnail, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, PinVideo$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.duration = 0L;
        } else {
            this.duration = duration;
        }
        if ((seen1 & 2) == 0) {
            this.thumbnail = new Image((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 0, (ImageInfo) null, 2047, (DefaultConstructorMarker) null);
        } else {
            this.thumbnail = thumbnail;
        }
    }

    public PinVideo(long duration, Image thumbnail) {
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        this.duration = duration;
        this.thumbnail = thumbnail;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_common_release(PinVideo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = output.shouldEncodeElementDefault(serialDesc, 0) || self.duration != 0;
        if (z) {
            output.encodeLongElement(serialDesc, 0, self.duration);
        }
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.thumbnail, new Image((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 0, (ImageInfo) null, 2047, (DefaultConstructorMarker) null));
        if (z2) {
            output.encodeSerializableElement(serialDesc, 1, Image$$serializer.INSTANCE, self.thumbnail);
        }
    }

    public /* synthetic */ PinVideo(long j, Image image, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j2;
        Image image2;
        if ((i & 1) == 0) {
            j2 = j;
        } else {
            j2 = 0;
        }
        if ((i & 2) == 0) {
            image2 = image;
        } else {
            image2 = new Image((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 0, (ImageInfo) null, 2047, (DefaultConstructorMarker) null);
        }
        this(j2, image2);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final Image getThumbnail() {
        return this.thumbnail;
    }
}
