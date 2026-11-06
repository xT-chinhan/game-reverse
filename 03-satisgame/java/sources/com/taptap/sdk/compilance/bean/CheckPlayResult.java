package com.taptap.sdk.compilance.bean;

import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
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

/* JADX INFO: compiled from: CheckPlayResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B;\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J!\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÇ\u0001R$\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006,"}, d2 = {"Lcom/taptap/sdk/compilance/bean/CheckPlayResult;", "", "seen1", "", "remainTime", "title", "", BundleKey.DESCRIPTION, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Ljava/lang/String;)V", "getDescription$annotations", "()V", BillingClientConstants.METHOD_GET_PRODUCT_DESCRIPTION, "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getRemainTime$annotations", "getRemainTime", "()I", "setRemainTime", "(I)V", "getTitle$annotations", BillingClientConstants.METHOD_GET_PRODUCT_TITLE, "setTitle", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class CheckPlayResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String description;
    private int remainTime;
    private String title;

    public CheckPlayResult() {
        this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CheckPlayResult copy$default(CheckPlayResult checkPlayResult, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = checkPlayResult.remainTime;
        }
        if ((i2 & 2) != 0) {
            str = checkPlayResult.title;
        }
        if ((i2 & 4) != 0) {
            str2 = checkPlayResult.description;
        }
        return checkPlayResult.copy(i, str, str2);
    }

    @SerialName(BundleKey.DESCRIPTION)
    public static /* synthetic */ void getDescription$annotations() {
    }

    @SerialName("remain_time")
    public static /* synthetic */ void getRemainTime$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getRemainTime() {
        return this.remainTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final CheckPlayResult copy(int remainTime, String title, String description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        return new CheckPlayResult(remainTime, title, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckPlayResult)) {
            return false;
        }
        CheckPlayResult checkPlayResult = (CheckPlayResult) other;
        return this.remainTime == checkPlayResult.remainTime && Intrinsics.areEqual(this.title, checkPlayResult.title) && Intrinsics.areEqual(this.description, checkPlayResult.description);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.remainTime) * 31) + this.title.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        return "CheckPlayResult(remainTime=" + this.remainTime + ", title=" + this.title + ", description=" + this.description + ')';
    }

    /* JADX INFO: compiled from: CheckPlayResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compilance/bean/CheckPlayResult$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compilance/bean/CheckPlayResult;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CheckPlayResult> serializer() {
            return CheckPlayResult$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CheckPlayResult(int i, @SerialName("remain_time") int i2, @SerialName("title") String str, @SerialName(BundleKey.DESCRIPTION) String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, CheckPlayResult$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.remainTime = 0;
        } else {
            this.remainTime = i2;
        }
        if ((i & 2) == 0) {
            this.title = "";
        } else {
            this.title = str;
        }
        if ((i & 4) == 0) {
            this.description = "";
        } else {
            this.description = str2;
        }
    }

    public CheckPlayResult(int i, String title, String description) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.remainTime = i;
        this.title = title;
        this.description = description;
    }

    @JvmStatic
    public static final void write$Self(CheckPlayResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.remainTime != 0) {
            output.encodeIntElement(serialDesc, 0, self.remainTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.title, "")) {
            output.encodeStringElement(serialDesc, 1, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.description, "")) {
            output.encodeStringElement(serialDesc, 2, self.description);
        }
    }

    public /* synthetic */ CheckPlayResult(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }

    public final int getRemainTime() {
        return this.remainTime;
    }

    public final void setRemainTime(int i) {
        this.remainTime = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }
}
