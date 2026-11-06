package com.taptap.sdk.compilance.bean;

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

/* JADX INFO: compiled from: UserAntiConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J!\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÇ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/taptap/sdk/compilance/bean/UITipsText;", "", "seen1", "", "allow", "Lcom/taptap/sdk/compilance/bean/TipsDesc;", "reject", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/compilance/bean/TipsDesc;Lcom/taptap/sdk/compilance/bean/TipsDesc;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/compilance/bean/TipsDesc;Lcom/taptap/sdk/compilance/bean/TipsDesc;)V", "getAllow$annotations", "()V", "getAllow", "()Lcom/taptap/sdk/compilance/bean/TipsDesc;", "getReject$annotations", "getReject", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class UITipsText {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TipsDesc allow;
    private final TipsDesc reject;

    /* JADX WARN: Multi-variable type inference failed */
    public UITipsText() {
        this((TipsDesc) null, (TipsDesc) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ UITipsText copy$default(UITipsText uITipsText, TipsDesc tipsDesc, TipsDesc tipsDesc2, int i, Object obj) {
        if ((i & 1) != 0) {
            tipsDesc = uITipsText.allow;
        }
        if ((i & 2) != 0) {
            tipsDesc2 = uITipsText.reject;
        }
        return uITipsText.copy(tipsDesc, tipsDesc2);
    }

    @SerialName("allow")
    public static /* synthetic */ void getAllow$annotations() {
    }

    @SerialName("reject")
    public static /* synthetic */ void getReject$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TipsDesc getAllow() {
        return this.allow;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TipsDesc getReject() {
        return this.reject;
    }

    public final UITipsText copy(TipsDesc allow, TipsDesc reject) {
        return new UITipsText(allow, reject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UITipsText)) {
            return false;
        }
        UITipsText uITipsText = (UITipsText) other;
        return Intrinsics.areEqual(this.allow, uITipsText.allow) && Intrinsics.areEqual(this.reject, uITipsText.reject);
    }

    public int hashCode() {
        TipsDesc tipsDesc = this.allow;
        int iHashCode = (tipsDesc == null ? 0 : tipsDesc.hashCode()) * 31;
        TipsDesc tipsDesc2 = this.reject;
        return iHashCode + (tipsDesc2 != null ? tipsDesc2.hashCode() : 0);
    }

    public String toString() {
        return "UITipsText(allow=" + this.allow + ", reject=" + this.reject + ')';
    }

    /* JADX INFO: compiled from: UserAntiConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compilance/bean/UITipsText$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compilance/bean/UITipsText;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UITipsText> serializer() {
            return UITipsText$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UITipsText(int i, @SerialName("allow") TipsDesc tipsDesc, @SerialName("reject") TipsDesc tipsDesc2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, UITipsText$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.allow = null;
        } else {
            this.allow = tipsDesc;
        }
        if ((i & 2) == 0) {
            this.reject = null;
        } else {
            this.reject = tipsDesc2;
        }
    }

    public UITipsText(TipsDesc tipsDesc, TipsDesc tipsDesc2) {
        this.allow = tipsDesc;
        this.reject = tipsDesc2;
    }

    @JvmStatic
    public static final void write$Self(UITipsText self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.allow != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, TipsDesc$$serializer.INSTANCE, self.allow);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.reject != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, TipsDesc$$serializer.INSTANCE, self.reject);
        }
    }

    public /* synthetic */ UITipsText(TipsDesc tipsDesc, TipsDesc tipsDesc2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tipsDesc, (i & 2) != 0 ? null : tipsDesc2);
    }

    public final TipsDesc getAllow() {
        return this.allow;
    }

    public final TipsDesc getReject() {
        return this.reject;
    }
}
