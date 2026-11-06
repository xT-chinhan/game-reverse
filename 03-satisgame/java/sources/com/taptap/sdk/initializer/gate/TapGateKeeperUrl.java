package com.taptap.sdk.initializer.gate;

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

/* JADX INFO: compiled from: TapGatekeeper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0002%&B=\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006'"}, d2 = {"Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl;", "", "seen1", "", "achievementUrl", "Lcom/taptap/sdk/initializer/gate/Url;", "shareUrl", "reviewUrl", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/initializer/gate/Url;Lcom/taptap/sdk/initializer/gate/Url;Lcom/taptap/sdk/initializer/gate/Url;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/initializer/gate/Url;Lcom/taptap/sdk/initializer/gate/Url;Lcom/taptap/sdk/initializer/gate/Url;)V", "getAchievementUrl$annotations", "()V", "getAchievementUrl", "()Lcom/taptap/sdk/initializer/gate/Url;", "getReviewUrl$annotations", "getReviewUrl", "getShareUrl$annotations", "getShareUrl", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class TapGateKeeperUrl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Url achievementUrl;
    private final Url reviewUrl;
    private final Url shareUrl;

    public TapGateKeeperUrl() {
        this((Url) null, (Url) null, (Url) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TapGateKeeperUrl copy$default(TapGateKeeperUrl tapGateKeeperUrl, Url url, Url url2, Url url3, int i, Object obj) {
        if ((i & 1) != 0) {
            url = tapGateKeeperUrl.achievementUrl;
        }
        if ((i & 2) != 0) {
            url2 = tapGateKeeperUrl.shareUrl;
        }
        if ((i & 4) != 0) {
            url3 = tapGateKeeperUrl.reviewUrl;
        }
        return tapGateKeeperUrl.copy(url, url2, url3);
    }

    @SerialName("achievement_my_list_url")
    public static /* synthetic */ void getAchievementUrl$annotations() {
    }

    @SerialName("add_review_url")
    public static /* synthetic */ void getReviewUrl$annotations() {
    }

    @SerialName("rep_share_url")
    public static /* synthetic */ void getShareUrl$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Url getAchievementUrl() {
        return this.achievementUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Url getShareUrl() {
        return this.shareUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Url getReviewUrl() {
        return this.reviewUrl;
    }

    public final TapGateKeeperUrl copy(Url achievementUrl, Url shareUrl, Url reviewUrl) {
        return new TapGateKeeperUrl(achievementUrl, shareUrl, reviewUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TapGateKeeperUrl)) {
            return false;
        }
        TapGateKeeperUrl tapGateKeeperUrl = (TapGateKeeperUrl) other;
        return Intrinsics.areEqual(this.achievementUrl, tapGateKeeperUrl.achievementUrl) && Intrinsics.areEqual(this.shareUrl, tapGateKeeperUrl.shareUrl) && Intrinsics.areEqual(this.reviewUrl, tapGateKeeperUrl.reviewUrl);
    }

    public int hashCode() {
        Url url = this.achievementUrl;
        int iHashCode = (url == null ? 0 : url.hashCode()) * 31;
        Url url2 = this.shareUrl;
        int iHashCode2 = (iHashCode + (url2 == null ? 0 : url2.hashCode())) * 31;
        Url url3 = this.reviewUrl;
        return iHashCode2 + (url3 != null ? url3.hashCode() : 0);
    }

    public String toString() {
        return "TapGateKeeperUrl(achievementUrl=" + this.achievementUrl + ", shareUrl=" + this.shareUrl + ", reviewUrl=" + this.reviewUrl + ')';
    }

    /* JADX INFO: compiled from: TapGatekeeper.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/initializer/gate/TapGateKeeperUrl;", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TapGateKeeperUrl> serializer() {
            return TapGateKeeperUrl$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TapGateKeeperUrl(int i, @SerialName("achievement_my_list_url") Url url, @SerialName("rep_share_url") Url url2, @SerialName("add_review_url") Url url3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, TapGateKeeperUrl$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.achievementUrl = null;
        } else {
            this.achievementUrl = url;
        }
        if ((i & 2) == 0) {
            this.shareUrl = null;
        } else {
            this.shareUrl = url2;
        }
        if ((i & 4) == 0) {
            this.reviewUrl = null;
        } else {
            this.reviewUrl = url3;
        }
    }

    public TapGateKeeperUrl(Url url, Url url2, Url url3) {
        this.achievementUrl = url;
        this.shareUrl = url2;
        this.reviewUrl = url3;
    }

    @JvmStatic
    public static final void write$Self(TapGateKeeperUrl self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.achievementUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, Url$$serializer.INSTANCE, self.achievementUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shareUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, Url$$serializer.INSTANCE, self.shareUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.reviewUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, Url$$serializer.INSTANCE, self.reviewUrl);
        }
    }

    public /* synthetic */ TapGateKeeperUrl(Url url, Url url2, Url url3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : url, (i & 2) != 0 ? null : url2, (i & 4) != 0 ? null : url3);
    }

    public final Url getAchievementUrl() {
        return this.achievementUrl;
    }

    public final Url getShareUrl() {
        return this.shareUrl;
    }

    public final Url getReviewUrl() {
        return this.reviewUrl;
    }
}
