package com.taptap.sdk.compliance.bean;

import com.taptap.sdk.compliance.internal.TapComplianceSettings;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J9\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.HÁ\u0001¢\u0006\u0002\b/R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Lcom/taptap/sdk/compliance/bean/UserAntiConfig;", "", "seen1", "", "realNameState", "Lcom/taptap/sdk/compliance/bean/UserState;", "antiAddiction", "Lcom/taptap/sdk/compliance/bean/AntiPolicy;", "ageCheckResult", "Lcom/taptap/sdk/compliance/bean/AgeCheckResult;", TapComplianceSettings.STRATEGY_LOCAL, "Lcom/taptap/sdk/compliance/bean/Local;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/taptap/sdk/compliance/bean/UserState;Lcom/taptap/sdk/compliance/bean/AntiPolicy;Lcom/taptap/sdk/compliance/bean/AgeCheckResult;Lcom/taptap/sdk/compliance/bean/Local;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/taptap/sdk/compliance/bean/UserState;Lcom/taptap/sdk/compliance/bean/AntiPolicy;Lcom/taptap/sdk/compliance/bean/AgeCheckResult;Lcom/taptap/sdk/compliance/bean/Local;)V", "getAgeCheckResult$annotations", "()V", "getAgeCheckResult", "()Lcom/taptap/sdk/compliance/bean/AgeCheckResult;", "getAntiAddiction$annotations", "getAntiAddiction", "()Lcom/taptap/sdk/compliance/bean/AntiPolicy;", "getLocal$annotations", "getLocal", "()Lcom/taptap/sdk/compliance/bean/Local;", "getRealNameState$annotations", "getRealNameState", "()Lcom/taptap/sdk/compliance/bean/UserState;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_compliance_release", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class UserAntiConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AgeCheckResult ageCheckResult;
    private final AntiPolicy antiAddiction;
    private final Local local;
    private final UserState realNameState;

    public UserAntiConfig() {
        this((UserState) null, (AntiPolicy) null, (AgeCheckResult) null, (Local) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserAntiConfig copy$default(UserAntiConfig userAntiConfig, UserState userState, AntiPolicy antiPolicy, AgeCheckResult ageCheckResult, Local local, int i, Object obj) {
        if ((i & 1) != 0) {
            userState = userAntiConfig.realNameState;
        }
        if ((i & 2) != 0) {
            antiPolicy = userAntiConfig.antiAddiction;
        }
        if ((i & 4) != 0) {
            ageCheckResult = userAntiConfig.ageCheckResult;
        }
        if ((i & 8) != 0) {
            local = userAntiConfig.local;
        }
        return userAntiConfig.copy(userState, antiPolicy, ageCheckResult, local);
    }

    @SerialName("content_rating_check")
    public static /* synthetic */ void getAgeCheckResult$annotations() {
    }

    @SerialName("anti_addiction")
    public static /* synthetic */ void getAntiAddiction$annotations() {
    }

    @SerialName(TapComplianceSettings.STRATEGY_LOCAL)
    public static /* synthetic */ void getLocal$annotations() {
    }

    @SerialName("real_name")
    public static /* synthetic */ void getRealNameState$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UserState getRealNameState() {
        return this.realNameState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AntiPolicy getAntiAddiction() {
        return this.antiAddiction;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AgeCheckResult getAgeCheckResult() {
        return this.ageCheckResult;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Local getLocal() {
        return this.local;
    }

    public final UserAntiConfig copy(UserState realNameState, AntiPolicy antiAddiction, AgeCheckResult ageCheckResult, Local local) {
        return new UserAntiConfig(realNameState, antiAddiction, ageCheckResult, local);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAntiConfig)) {
            return false;
        }
        UserAntiConfig userAntiConfig = (UserAntiConfig) other;
        return Intrinsics.areEqual(this.realNameState, userAntiConfig.realNameState) && Intrinsics.areEqual(this.antiAddiction, userAntiConfig.antiAddiction) && Intrinsics.areEqual(this.ageCheckResult, userAntiConfig.ageCheckResult) && Intrinsics.areEqual(this.local, userAntiConfig.local);
    }

    public int hashCode() {
        UserState userState = this.realNameState;
        int iHashCode = (userState == null ? 0 : userState.hashCode()) * 31;
        AntiPolicy antiPolicy = this.antiAddiction;
        int iHashCode2 = (iHashCode + (antiPolicy == null ? 0 : antiPolicy.hashCode())) * 31;
        AgeCheckResult ageCheckResult = this.ageCheckResult;
        int iHashCode3 = (iHashCode2 + (ageCheckResult == null ? 0 : ageCheckResult.hashCode())) * 31;
        Local local = this.local;
        return iHashCode3 + (local != null ? local.hashCode() : 0);
    }

    public String toString() {
        return "UserAntiConfig(realNameState=" + this.realNameState + ", antiAddiction=" + this.antiAddiction + ", ageCheckResult=" + this.ageCheckResult + ", local=" + this.local + ')';
    }

    /* JADX INFO: compiled from: UserAntiConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/UserAntiConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/UserAntiConfig;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UserAntiConfig> serializer() {
            return UserAntiConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UserAntiConfig(int seen1, @SerialName("real_name") UserState realNameState, @SerialName("anti_addiction") AntiPolicy antiAddiction, @SerialName("content_rating_check") AgeCheckResult ageCheckResult, @SerialName(TapComplianceSettings.STRATEGY_LOCAL) Local local, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, UserAntiConfig$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.realNameState = null;
        } else {
            this.realNameState = realNameState;
        }
        if ((seen1 & 2) == 0) {
            this.antiAddiction = null;
        } else {
            this.antiAddiction = antiAddiction;
        }
        if ((seen1 & 4) == 0) {
            this.ageCheckResult = null;
        } else {
            this.ageCheckResult = ageCheckResult;
        }
        if ((seen1 & 8) == 0) {
            this.local = null;
        } else {
            this.local = local;
        }
    }

    public UserAntiConfig(UserState realNameState, AntiPolicy antiAddiction, AgeCheckResult ageCheckResult, Local local) {
        this.realNameState = realNameState;
        this.antiAddiction = antiAddiction;
        this.ageCheckResult = ageCheckResult;
        this.local = local;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_compliance_release(UserAntiConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.realNameState != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, UserState$$serializer.INSTANCE, self.realNameState);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.antiAddiction != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, AntiPolicy$$serializer.INSTANCE, self.antiAddiction);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.ageCheckResult != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, AgeCheckResult$$serializer.INSTANCE, self.ageCheckResult);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.local != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, Local$$serializer.INSTANCE, self.local);
        }
    }

    public /* synthetic */ UserAntiConfig(UserState userState, AntiPolicy antiPolicy, AgeCheckResult ageCheckResult, Local local, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : userState, (i & 2) != 0 ? null : antiPolicy, (i & 4) != 0 ? null : ageCheckResult, (i & 8) != 0 ? null : local);
    }

    public final UserState getRealNameState() {
        return this.realNameState;
    }

    public final AntiPolicy getAntiAddiction() {
        return this.antiAddiction;
    }

    public final AgeCheckResult getAgeCheckResult() {
        return this.ageCheckResult;
    }

    public final Local getLocal() {
        return this.local;
    }
}
