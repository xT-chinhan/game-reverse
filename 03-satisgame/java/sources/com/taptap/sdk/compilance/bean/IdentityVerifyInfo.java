package com.taptap.sdk.compilance.bean;

import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: IdentityVerifyInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234BQ\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB=\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003JF\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001J!\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÇ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R(\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001b\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0015¨\u00065"}, d2 = {"Lcom/taptap/sdk/compilance/bean/IdentityVerifyInfo;", "", "seen1", "", "identifyState", "idCard", "", "antiAddictionToken", TapEventParamConstants.PARAM_NAME, "phoneNumber", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAntiAddictionToken$annotations", "()V", "getAntiAddictionToken", "()Ljava/lang/String;", "getIdCard$annotations", "getIdCard", "setIdCard", "(Ljava/lang/String;)V", "getIdentifyState$annotations", "getIdentifyState", "()Ljava/lang/Integer;", "setIdentifyState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", BillingClientConstants.METHOD_GET_PRODUCT_NAME, "setName", "getPhoneNumber", "setPhoneNumber", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/taptap/sdk/compilance/bean/IdentityVerifyInfo;", "equals", "", AdnName.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class IdentityVerifyInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String antiAddictionToken;
    private String idCard;
    private Integer identifyState;
    private String name;
    private String phoneNumber;

    public IdentityVerifyInfo() {
        this((Integer) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IdentityVerifyInfo copy$default(IdentityVerifyInfo identityVerifyInfo, Integer num, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = identityVerifyInfo.identifyState;
        }
        if ((i & 2) != 0) {
            str = identityVerifyInfo.idCard;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = identityVerifyInfo.antiAddictionToken;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = identityVerifyInfo.name;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = identityVerifyInfo.phoneNumber;
        }
        return identityVerifyInfo.copy(num, str5, str6, str7, str4);
    }

    @SerialName("anti_addiction_token")
    public static /* synthetic */ void getAntiAddictionToken$annotations() {
    }

    @SerialName("id_card")
    public static /* synthetic */ void getIdCard$annotations() {
    }

    @SerialName("identify_state")
    public static /* synthetic */ void getIdentifyState$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getIdentifyState() {
        return this.identifyState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIdCard() {
        return this.idCard;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAntiAddictionToken() {
        return this.antiAddictionToken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final IdentityVerifyInfo copy(Integer identifyState, String idCard, String antiAddictionToken, String name, String phoneNumber) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return new IdentityVerifyInfo(identifyState, idCard, antiAddictionToken, name, phoneNumber);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IdentityVerifyInfo)) {
            return false;
        }
        IdentityVerifyInfo identityVerifyInfo = (IdentityVerifyInfo) other;
        return Intrinsics.areEqual(this.identifyState, identityVerifyInfo.identifyState) && Intrinsics.areEqual(this.idCard, identityVerifyInfo.idCard) && Intrinsics.areEqual(this.antiAddictionToken, identityVerifyInfo.antiAddictionToken) && Intrinsics.areEqual(this.name, identityVerifyInfo.name) && Intrinsics.areEqual(this.phoneNumber, identityVerifyInfo.phoneNumber);
    }

    public int hashCode() {
        Integer num = this.identifyState;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.idCard;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.antiAddictionToken;
        return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.name.hashCode()) * 31) + this.phoneNumber.hashCode();
    }

    public String toString() {
        return "IdentityVerifyInfo(identifyState=" + this.identifyState + ", idCard=" + this.idCard + ", antiAddictionToken=" + this.antiAddictionToken + ", name=" + this.name + ", phoneNumber=" + this.phoneNumber + ')';
    }

    /* JADX INFO: compiled from: IdentityVerifyInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compilance/bean/IdentityVerifyInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compilance/bean/IdentityVerifyInfo;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IdentityVerifyInfo> serializer() {
            return IdentityVerifyInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ IdentityVerifyInfo(int i, @SerialName("identify_state") Integer num, @SerialName("id_card") String str, @SerialName("anti_addiction_token") String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, IdentityVerifyInfo$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.identifyState = null;
        } else {
            this.identifyState = num;
        }
        if ((i & 2) == 0) {
            this.idCard = null;
        } else {
            this.idCard = str;
        }
        if ((i & 4) == 0) {
            this.antiAddictionToken = null;
        } else {
            this.antiAddictionToken = str2;
        }
        if ((i & 8) == 0) {
            this.name = "";
        } else {
            this.name = str3;
        }
        if ((i & 16) == 0) {
            this.phoneNumber = "";
        } else {
            this.phoneNumber = str4;
        }
    }

    public IdentityVerifyInfo(Integer num, String str, String str2, String name, String phoneNumber) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.identifyState = num;
        this.idCard = str;
        this.antiAddictionToken = str2;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @JvmStatic
    public static final void write$Self(IdentityVerifyInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.identifyState != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.identifyState);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.idCard != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.idCard);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.antiAddictionToken != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.antiAddictionToken);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.name, "")) {
            output.encodeStringElement(serialDesc, 3, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.phoneNumber, "")) {
            output.encodeStringElement(serialDesc, 4, self.phoneNumber);
        }
    }

    public /* synthetic */ IdentityVerifyInfo(Integer num, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) == 0 ? str2 : null, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4);
    }

    public final Integer getIdentifyState() {
        return this.identifyState;
    }

    public final void setIdentifyState(Integer num) {
        this.identifyState = num;
    }

    public final String getIdCard() {
        return this.idCard;
    }

    public final void setIdCard(String str) {
        this.idCard = str;
    }

    public final String getAntiAddictionToken() {
        return this.antiAddictionToken;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.phoneNumber = str;
    }
}
