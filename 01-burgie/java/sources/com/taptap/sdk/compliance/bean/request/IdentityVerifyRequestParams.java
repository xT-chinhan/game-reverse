package com.taptap.sdk.compliance.bean.request;

import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.db.constant.Common;
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

/* JADX INFO: compiled from: IdentityVerifyRequestParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/taptap/sdk/compliance/bean/request/IdentityVerifyRequestParams;", "", "seen1", "", Common.System.NAME, "", "idCard", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getIdCard$annotations", "()V", "getIdCard", "()Ljava/lang/String;", "getName$annotations", BillingClientConstants.METHOD_GET_PRODUCT_NAME, "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_compliance_release", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class IdentityVerifyRequestParams {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String idCard;
    private final String name;

    /* JADX WARN: Multi-variable type inference failed */
    public IdentityVerifyRequestParams() {
        this((String) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ IdentityVerifyRequestParams copy$default(IdentityVerifyRequestParams identityVerifyRequestParams, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = identityVerifyRequestParams.name;
        }
        if ((i & 2) != 0) {
            str2 = identityVerifyRequestParams.idCard;
        }
        return identityVerifyRequestParams.copy(str, str2);
    }

    @SerialName("idcard")
    public static /* synthetic */ void getIdCard$annotations() {
    }

    @SerialName(Common.System.NAME)
    public static /* synthetic */ void getName$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIdCard() {
        return this.idCard;
    }

    public final IdentityVerifyRequestParams copy(String name, String idCard) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(idCard, "idCard");
        return new IdentityVerifyRequestParams(name, idCard);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdentityVerifyRequestParams)) {
            return false;
        }
        IdentityVerifyRequestParams identityVerifyRequestParams = (IdentityVerifyRequestParams) other;
        return Intrinsics.areEqual(this.name, identityVerifyRequestParams.name) && Intrinsics.areEqual(this.idCard, identityVerifyRequestParams.idCard);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.idCard.hashCode();
    }

    public String toString() {
        return "IdentityVerifyRequestParams(name=" + this.name + ", idCard=" + this.idCard + ')';
    }

    /* JADX INFO: compiled from: IdentityVerifyRequestParams.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/request/IdentityVerifyRequestParams$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/request/IdentityVerifyRequestParams;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IdentityVerifyRequestParams> serializer() {
            return IdentityVerifyRequestParams$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ IdentityVerifyRequestParams(int seen1, @SerialName(Common.System.NAME) String name, @SerialName("idcard") String idCard, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, IdentityVerifyRequestParams$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.name = "";
        } else {
            this.name = name;
        }
        if ((seen1 & 2) == 0) {
            this.idCard = "";
        } else {
            this.idCard = idCard;
        }
    }

    public IdentityVerifyRequestParams(String name, String idCard) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(idCard, "idCard");
        this.name = name;
        this.idCard = idCard;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_compliance_release(IdentityVerifyRequestParams self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = false;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.name, "");
        if (z2) {
            output.encodeStringElement(serialDesc, 0, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.idCard, "")) {
            z = true;
        }
        if (z) {
            output.encodeStringElement(serialDesc, 1, self.idCard);
        }
    }

    public /* synthetic */ IdentityVerifyRequestParams(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final String getIdCard() {
        return this.idCard;
    }
}
