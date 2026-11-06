package com.taptap.sdk.common.model;

import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0002HIB\u0097\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bs\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0014J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003Jw\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001J&\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FHÁ\u0001¢\u0006\u0002\bGR\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\u001c\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u001dR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u001d¨\u0006J"}, d2 = {"Lcom/taptap/sdk/common/model/Image;", "", "seen1", "", BreakpointSQLiteKey.URL, "", "mediumUrl", "smallUrl", "originalUrl", "gifUrl", "originalFormat", "width", "height", "color", "originalSize", "info", "Lcom/taptap/sdk/common/model/ImageInfo;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILcom/taptap/sdk/common/model/ImageInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILcom/taptap/sdk/common/model/ImageInfo;)V", "getColor$annotations", "()V", "getColor", "()Ljava/lang/String;", "getGifUrl$annotations", "getGifUrl", "getHeight$annotations", "getHeight", "()I", "getInfo$annotations", "getInfo", "()Lcom/taptap/sdk/common/model/ImageInfo;", "getMediumUrl$annotations", "getMediumUrl", "getOriginalFormat$annotations", "getOriginalFormat", "getOriginalSize$annotations", "getOriginalSize", "getOriginalUrl$annotations", "getOriginalUrl", "getSmallUrl$annotations", "getSmallUrl", "getUrl$annotations", "getUrl", "getWidth$annotations", "getWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_common_release", "$serializer", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class Image {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String color;
    private final String gifUrl;
    private final int height;
    private final ImageInfo info;
    private final String mediumUrl;
    private final String originalFormat;
    private final int originalSize;
    private final String originalUrl;
    private final String smallUrl;
    private final String url;
    private final int width;

    public Image() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, 0, (ImageInfo) null, 2047, (DefaultConstructorMarker) null);
    }

    @SerialName("color")
    public static /* synthetic */ void getColor$annotations() {
    }

    @SerialName("gif_url")
    public static /* synthetic */ void getGifUrl$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("info")
    public static /* synthetic */ void getInfo$annotations() {
    }

    @SerialName("medium_url")
    public static /* synthetic */ void getMediumUrl$annotations() {
    }

    @SerialName("original_format")
    public static /* synthetic */ void getOriginalFormat$annotations() {
    }

    @SerialName("original_size")
    public static /* synthetic */ void getOriginalSize$annotations() {
    }

    @SerialName("original_url")
    public static /* synthetic */ void getOriginalUrl$annotations() {
    }

    @SerialName("small_url")
    public static /* synthetic */ void getSmallUrl$annotations() {
    }

    @SerialName(BreakpointSQLiteKey.URL)
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getOriginalSize() {
        return this.originalSize;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ImageInfo getInfo() {
        return this.info;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMediumUrl() {
        return this.mediumUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSmallUrl() {
        return this.smallUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOriginalUrl() {
        return this.originalUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGifUrl() {
        return this.gifUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOriginalFormat() {
        return this.originalFormat;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    public final Image copy(String url, String mediumUrl, String smallUrl, String originalUrl, String gifUrl, String originalFormat, int width, int height, String color, int originalSize, ImageInfo info) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(mediumUrl, "mediumUrl");
        Intrinsics.checkNotNullParameter(smallUrl, "smallUrl");
        Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
        Intrinsics.checkNotNullParameter(gifUrl, "gifUrl");
        Intrinsics.checkNotNullParameter(originalFormat, "originalFormat");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(info, "info");
        return new Image(url, mediumUrl, smallUrl, originalUrl, gifUrl, originalFormat, width, height, color, originalSize, info);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Image)) {
            return false;
        }
        Image image = (Image) other;
        return Intrinsics.areEqual(this.url, image.url) && Intrinsics.areEqual(this.mediumUrl, image.mediumUrl) && Intrinsics.areEqual(this.smallUrl, image.smallUrl) && Intrinsics.areEqual(this.originalUrl, image.originalUrl) && Intrinsics.areEqual(this.gifUrl, image.gifUrl) && Intrinsics.areEqual(this.originalFormat, image.originalFormat) && this.width == image.width && this.height == image.height && Intrinsics.areEqual(this.color, image.color) && this.originalSize == image.originalSize && Intrinsics.areEqual(this.info, image.info);
    }

    public int hashCode() {
        return (((((((((((((((((((this.url.hashCode() * 31) + this.mediumUrl.hashCode()) * 31) + this.smallUrl.hashCode()) * 31) + this.originalUrl.hashCode()) * 31) + this.gifUrl.hashCode()) * 31) + this.originalFormat.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + this.color.hashCode()) * 31) + Integer.hashCode(this.originalSize)) * 31) + this.info.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Image(url=").append(this.url).append(", mediumUrl=").append(this.mediumUrl).append(", smallUrl=").append(this.smallUrl).append(", originalUrl=").append(this.originalUrl).append(", gifUrl=").append(this.gifUrl).append(", originalFormat=").append(this.originalFormat).append(", width=").append(this.width).append(", height=").append(this.height).append(", color=").append(this.color).append(", originalSize=").append(this.originalSize).append(", info=").append(this.info).append(')');
        return sb.toString();
    }

    /* JADX INFO: compiled from: Infos.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/common/model/Image$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/common/model/Image;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Image> serializer() {
            return Image$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Image(int seen1, @SerialName(BreakpointSQLiteKey.URL) String url, @SerialName("medium_url") String mediumUrl, @SerialName("small_url") String smallUrl, @SerialName("original_url") String originalUrl, @SerialName("gif_url") String gifUrl, @SerialName("original_format") String originalFormat, @SerialName("width") int width, @SerialName("height") int height, @SerialName("color") String color, @SerialName("original_size") int originalSize, @SerialName("info") ImageInfo info, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, Image$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.url = "";
        } else {
            this.url = url;
        }
        if ((seen1 & 2) == 0) {
            this.mediumUrl = "";
        } else {
            this.mediumUrl = mediumUrl;
        }
        if ((seen1 & 4) == 0) {
            this.smallUrl = "";
        } else {
            this.smallUrl = smallUrl;
        }
        if ((seen1 & 8) == 0) {
            this.originalUrl = "";
        } else {
            this.originalUrl = originalUrl;
        }
        if ((seen1 & 16) == 0) {
            this.gifUrl = "";
        } else {
            this.gifUrl = gifUrl;
        }
        if ((seen1 & 32) == 0) {
            this.originalFormat = "";
        } else {
            this.originalFormat = originalFormat;
        }
        if ((seen1 & 64) == 0) {
            this.width = -1;
        } else {
            this.width = width;
        }
        if ((seen1 & 128) == 0) {
            this.height = -1;
        } else {
            this.height = height;
        }
        if ((seen1 & 256) == 0) {
            this.color = "";
        } else {
            this.color = color;
        }
        if ((seen1 & 512) == 0) {
            this.originalSize = 0;
        } else {
            this.originalSize = originalSize;
        }
        if ((seen1 & 1024) == 0) {
            this.info = new ImageInfo(0, 0, 3, (DefaultConstructorMarker) null);
        } else {
            this.info = info;
        }
    }

    public Image(String url, String mediumUrl, String smallUrl, String originalUrl, String gifUrl, String originalFormat, int width, int height, String color, int originalSize, ImageInfo info) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(mediumUrl, "mediumUrl");
        Intrinsics.checkNotNullParameter(smallUrl, "smallUrl");
        Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
        Intrinsics.checkNotNullParameter(gifUrl, "gifUrl");
        Intrinsics.checkNotNullParameter(originalFormat, "originalFormat");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(info, "info");
        this.url = url;
        this.mediumUrl = mediumUrl;
        this.smallUrl = smallUrl;
        this.originalUrl = originalUrl;
        this.gifUrl = gifUrl;
        this.originalFormat = originalFormat;
        this.width = width;
        this.height = height;
        this.color = color;
        this.originalSize = originalSize;
        this.info = info;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_common_release(Image self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.url, "");
        if (z2) {
            output.encodeStringElement(serialDesc, 0, self.url);
        }
        boolean z3 = output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.mediumUrl, "");
        if (z3) {
            output.encodeStringElement(serialDesc, 1, self.mediumUrl);
        }
        boolean z4 = output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.smallUrl, "");
        if (z4) {
            output.encodeStringElement(serialDesc, 2, self.smallUrl);
        }
        boolean z5 = output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.originalUrl, "");
        if (z5) {
            output.encodeStringElement(serialDesc, 3, self.originalUrl);
        }
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.gifUrl, "");
        if (z6) {
            output.encodeStringElement(serialDesc, 4, self.gifUrl);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.originalFormat, "");
        if (z7) {
            output.encodeStringElement(serialDesc, 5, self.originalFormat);
        }
        boolean z8 = output.shouldEncodeElementDefault(serialDesc, 6) || self.width != -1;
        if (z8) {
            output.encodeIntElement(serialDesc, 6, self.width);
        }
        boolean z9 = output.shouldEncodeElementDefault(serialDesc, 7) || self.height != -1;
        if (z9) {
            output.encodeIntElement(serialDesc, 7, self.height);
        }
        boolean z10 = output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.color, "");
        if (z10) {
            output.encodeStringElement(serialDesc, 8, self.color);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.originalSize != 0) {
            output.encodeIntElement(serialDesc, 9, self.originalSize);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || !Intrinsics.areEqual(self.info, new ImageInfo(0, 0, 3, (DefaultConstructorMarker) null))) {
            z = true;
        }
        if (z) {
            output.encodeSerializableElement(serialDesc, 10, ImageInfo$$serializer.INSTANCE, self.info);
        }
    }

    public /* synthetic */ Image(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, String str7, int i3, ImageInfo imageInfo, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? "" : str4, (i4 & 16) != 0 ? "" : str5, (i4 & 32) != 0 ? "" : str6, (i4 & 64) != 0 ? -1 : i, (i4 & 128) == 0 ? i2 : -1, (i4 & 256) == 0 ? str7 : "", (i4 & 512) != 0 ? 0 : i3, (i4 & 1024) != 0 ? new ImageInfo(0, 0, 3, (DefaultConstructorMarker) null) : imageInfo);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMediumUrl() {
        return this.mediumUrl;
    }

    public final String getSmallUrl() {
        return this.smallUrl;
    }

    public final String getOriginalUrl() {
        return this.originalUrl;
    }

    public final String getGifUrl() {
        return this.gifUrl;
    }

    public final String getOriginalFormat() {
        return this.originalFormat;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getColor() {
        return this.color;
    }

    public final int getOriginalSize() {
        return this.originalSize;
    }

    public final ImageInfo getInfo() {
        return this.info;
    }
}
