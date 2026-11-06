package com.taptap.sdk.common.model;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
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

/* JADX INFO: compiled from: Infos.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÇ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/taptap/sdk/common/model/Video;", "", "seen1", "", "info", "Lcom/taptap/sdk/common/model/VideoInfo;", "thumbnail", "Lcom/taptap/sdk/common/model/Image;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/common/model/VideoInfo;Lcom/taptap/sdk/common/model/Image;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/common/model/VideoInfo;Lcom/taptap/sdk/common/model/Image;)V", "getInfo$annotations", "()V", "getInfo", "()Lcom/taptap/sdk/common/model/VideoInfo;", "getThumbnail$annotations", "getThumbnail", "()Lcom/taptap/sdk/common/model/Image;", "component1", "component2", "copy", "equals", "", AdnName.OTHER, TTDownloadField.TT_HASHCODE, "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class Video {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final VideoInfo info;
    private final Image thumbnail;

    /* JADX WARN: Multi-variable type inference failed */
    public Video() {
        this((VideoInfo) null, (Image) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ Video copy$default(Video video, VideoInfo videoInfo, Image image, int i, Object obj) {
        if ((i & 1) != 0) {
            videoInfo = video.info;
        }
        if ((i & 2) != 0) {
            image = video.thumbnail;
        }
        return video.copy(videoInfo, image);
    }

    @SerialName("info")
    public static /* synthetic */ void getInfo$annotations() {
    }

    @SerialName("thumbnail")
    public static /* synthetic */ void getThumbnail$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final VideoInfo getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Image getThumbnail() {
        return this.thumbnail;
    }

    public final Video copy(VideoInfo info, Image thumbnail) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        return new Video(info, thumbnail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Video)) {
            return false;
        }
        Video video = (Video) other;
        return Intrinsics.areEqual(this.info, video.info) && Intrinsics.areEqual(this.thumbnail, video.thumbnail);
    }

    public int hashCode() {
        return (this.info.hashCode() * 31) + this.thumbnail.hashCode();
    }

    public String toString() {
        return "Video(info=" + this.info + ", thumbnail=" + this.thumbnail + ')';
    }

    /* JADX INFO: compiled from: Infos.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/common/model/Video$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/common/model/Video;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Video> serializer() {
            return Video$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Video(int i, @SerialName("info") VideoInfo videoInfo, @SerialName("thumbnail") Image image, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, Video$$serializer.INSTANCE.getDescriptor());
        }
        this.info = (i & 1) == 0 ? new VideoInfo(0L, 1, (DefaultConstructorMarker) null) : videoInfo;
        this.thumbnail = (i & 2) == 0 ? new Image((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 0, (ImageInfo) null, 2047, (DefaultConstructorMarker) null) : image;
    }

    public Video(VideoInfo info, Image thumbnail) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        this.info = info;
        this.thumbnail = thumbnail;
    }

    @JvmStatic
    public static final void write$Self(Video self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.info, new VideoInfo(0L, 1, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 0, VideoInfo$$serializer.INSTANCE, self.info);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.thumbnail, new Image((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 0, (ImageInfo) null, 2047, (DefaultConstructorMarker) null))) {
            output.encodeSerializableElement(serialDesc, 1, Image$$serializer.INSTANCE, self.thumbnail);
        }
    }

    public /* synthetic */ Video(VideoInfo videoInfo, Image image, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new VideoInfo(0L, 1, (DefaultConstructorMarker) null) : videoInfo, (i & 2) != 0 ? new Image((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 0, (ImageInfo) null, 2047, (DefaultConstructorMarker) null) : image);
    }

    public final VideoInfo getInfo() {
        return this.info;
    }

    public final Image getThumbnail() {
        return this.thumbnail;
    }
}
