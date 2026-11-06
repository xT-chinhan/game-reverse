package com.taptap.sdk.compliance.bean;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: UserAntiConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J&\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u0005\u0010\u0011¨\u0006&"}, d2 = {"Lcom/taptap/sdk/compliance/bean/UserState;", "", "seen1", "", "ageLimit", "isAdult", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAgeLimit$annotations", "()V", "getAgeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isAdult$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/taptap/sdk/compliance/bean/UserState;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_compliance_release", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class UserState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer ageLimit;
    private final Boolean isAdult;

    /* JADX WARN: Multi-variable type inference failed */
    public UserState() {
        this((Integer) null, (Boolean) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ UserState copy$default(UserState userState, Integer num, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = userState.ageLimit;
        }
        if ((i & 2) != 0) {
            bool = userState.isAdult;
        }
        return userState.copy(num, bool);
    }

    @SerialName("age_limit")
    public static /* synthetic */ void getAgeLimit$annotations() {
    }

    @SerialName("is_adult")
    public static /* synthetic */ void isAdult$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getAgeLimit() {
        return this.ageLimit;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIsAdult() {
        return this.isAdult;
    }

    public final UserState copy(Integer ageLimit, Boolean isAdult) {
        return new UserState(ageLimit, isAdult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserState)) {
            return false;
        }
        UserState userState = (UserState) other;
        return Intrinsics.areEqual(this.ageLimit, userState.ageLimit) && Intrinsics.areEqual(this.isAdult, userState.isAdult);
    }

    public int hashCode() {
        Integer num = this.ageLimit;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.isAdult;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "UserState(ageLimit=" + this.ageLimit + ", isAdult=" + this.isAdult + ')';
    }

    /* JADX INFO: compiled from: UserAntiConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/UserState$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/UserState;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UserState> serializer() {
            return UserState$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UserState(int seen1, @SerialName("age_limit") Integer ageLimit, @SerialName("is_adult") Boolean isAdult, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, UserState$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.ageLimit = 0;
        } else {
            this.ageLimit = ageLimit;
        }
        if ((seen1 & 2) == 0) {
            this.isAdult = false;
        } else {
            this.isAdult = isAdult;
        }
    }

    public UserState(Integer ageLimit, Boolean isAdult) {
        this.ageLimit = ageLimit;
        this.isAdult = isAdult;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_compliance_release(UserState self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Integer num;
        boolean z = false;
        boolean z2 = output.shouldEncodeElementDefault(serialDesc, 0) || (num = self.ageLimit) == null || num.intValue() != 0;
        if (z2) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.ageLimit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual((Object) self.isAdult, (Object) false)) {
            z = true;
        }
        if (z) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.isAdult);
        }
    }

    public /* synthetic */ UserState(Integer num, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? false : bool);
    }

    public final Integer getAgeLimit() {
        return this.ageLimit;
    }

    public final Boolean isAdult() {
        return this.isAdult;
    }
}
