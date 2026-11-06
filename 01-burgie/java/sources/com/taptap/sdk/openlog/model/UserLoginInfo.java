package com.taptap.sdk.openlog.model;

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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: UserLoginInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006#"}, d2 = {"Lcom/taptap/sdk/openlog/model/UserLoginInfo;", "", "seen1", "", "openId", "", "tdsUserId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getOpenId$annotations", "()V", "getOpenId", "()Ljava/lang/String;", "getTdsUserId$annotations", "getTdsUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_core_release", "$serializer", "Companion", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class UserLoginInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String openId;
    private final String tdsUserId;

    public static /* synthetic */ UserLoginInfo copy$default(UserLoginInfo userLoginInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userLoginInfo.openId;
        }
        if ((i & 2) != 0) {
            str2 = userLoginInfo.tdsUserId;
        }
        return userLoginInfo.copy(str, str2);
    }

    @SerialName(Common.Predefined.OPEN_ID)
    public static /* synthetic */ void getOpenId$annotations() {
    }

    @SerialName("tds_user_id")
    public static /* synthetic */ void getTdsUserId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTdsUserId() {
        return this.tdsUserId;
    }

    public final UserLoginInfo copy(String openId, String tdsUserId) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        return new UserLoginInfo(openId, tdsUserId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserLoginInfo)) {
            return false;
        }
        UserLoginInfo userLoginInfo = (UserLoginInfo) other;
        return Intrinsics.areEqual(this.openId, userLoginInfo.openId) && Intrinsics.areEqual(this.tdsUserId, userLoginInfo.tdsUserId);
    }

    public int hashCode() {
        int iHashCode = this.openId.hashCode() * 31;
        String str = this.tdsUserId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UserLoginInfo(openId=" + this.openId + ", tdsUserId=" + this.tdsUserId + ')';
    }

    /* JADX INFO: compiled from: UserLoginInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/openlog/model/UserLoginInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/openlog/model/UserLoginInfo;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UserLoginInfo> serializer() {
            return UserLoginInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UserLoginInfo(int seen1, @SerialName(Common.Predefined.OPEN_ID) String openId, @SerialName("tds_user_id") String tdsUserId, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen1 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 1, UserLoginInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.openId = openId;
        if ((seen1 & 2) == 0) {
            this.tdsUserId = null;
        } else {
            this.tdsUserId = tdsUserId;
        }
    }

    public UserLoginInfo(String openId, String tdsUserId) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        this.openId = openId;
        this.tdsUserId = tdsUserId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_core_release(UserLoginInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.openId);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tdsUserId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.tdsUserId);
        }
    }

    public /* synthetic */ UserLoginInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final String getTdsUserId() {
        return this.tdsUserId;
    }
}
