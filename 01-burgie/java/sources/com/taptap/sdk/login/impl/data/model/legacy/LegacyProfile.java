package com.taptap.sdk.login.impl.data.model.legacy;

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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: LegacyProfile.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB9\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006/"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/legacy/LegacyProfile;", "", "seen1", "", "avatar", "", Common.System.NAME, "openid", "unionid", "email", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar$annotations", "()V", "getAvatar", "()Ljava/lang/String;", "getEmail$annotations", "getEmail", "getName$annotations", BillingClientConstants.METHOD_GET_PRODUCT_NAME, "getOpenid$annotations", "getOpenid", "getUnionid$annotations", "getUnionid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class LegacyProfile {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatar;
    private final String email;
    private final String name;
    private final String openid;
    private final String unionid;

    public static /* synthetic */ LegacyProfile copy$default(LegacyProfile legacyProfile, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = legacyProfile.avatar;
        }
        if ((i & 2) != 0) {
            str2 = legacyProfile.name;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = legacyProfile.openid;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = legacyProfile.unionid;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = legacyProfile.email;
        }
        return legacyProfile.copy(str, str6, str7, str8, str5);
    }

    @SerialName("avatar")
    public static /* synthetic */ void getAvatar$annotations() {
    }

    @SerialName("email")
    public static /* synthetic */ void getEmail$annotations() {
    }

    @SerialName(Common.System.NAME)
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("openid")
    public static /* synthetic */ void getOpenid$annotations() {
    }

    @SerialName("unionid")
    public static /* synthetic */ void getUnionid$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOpenid() {
        return this.openid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUnionid() {
        return this.unionid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final LegacyProfile copy(String avatar, String name, String openid, String unionid, String email) {
        Intrinsics.checkNotNullParameter(openid, "openid");
        Intrinsics.checkNotNullParameter(unionid, "unionid");
        return new LegacyProfile(avatar, name, openid, unionid, email);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyProfile)) {
            return false;
        }
        LegacyProfile legacyProfile = (LegacyProfile) other;
        return Intrinsics.areEqual(this.avatar, legacyProfile.avatar) && Intrinsics.areEqual(this.name, legacyProfile.name) && Intrinsics.areEqual(this.openid, legacyProfile.openid) && Intrinsics.areEqual(this.unionid, legacyProfile.unionid) && Intrinsics.areEqual(this.email, legacyProfile.email);
    }

    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.openid.hashCode()) * 31) + this.unionid.hashCode()) * 31;
        String str3 = this.email;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "LegacyProfile(avatar=" + this.avatar + ", name=" + this.name + ", openid=" + this.openid + ", unionid=" + this.unionid + ", email=" + this.email + ')';
    }

    /* JADX INFO: compiled from: LegacyProfile.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/legacy/LegacyProfile$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/legacy/LegacyProfile;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LegacyProfile> serializer() {
            return LegacyProfile$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LegacyProfile(int seen1, @SerialName("avatar") String avatar, @SerialName(Common.System.NAME) String name, @SerialName("openid") String openid, @SerialName("unionid") String unionid, @SerialName("email") String email, SerializationConstructorMarker serializationConstructorMarker) {
        if (12 != (seen1 & 12)) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 12, LegacyProfile$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.avatar = null;
        } else {
            this.avatar = avatar;
        }
        if ((seen1 & 2) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        this.openid = openid;
        this.unionid = unionid;
        if ((seen1 & 16) == 0) {
            this.email = null;
        } else {
            this.email = email;
        }
    }

    public LegacyProfile(String avatar, String name, String openid, String unionid, String email) {
        Intrinsics.checkNotNullParameter(openid, "openid");
        Intrinsics.checkNotNullParameter(unionid, "unionid");
        this.avatar = avatar;
        this.name = name;
        this.openid = openid;
        this.unionid = unionid;
        this.email = email;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_login_release(LegacyProfile self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avatar != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.avatar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.name);
        }
        output.encodeStringElement(serialDesc, 2, self.openid);
        output.encodeStringElement(serialDesc, 3, self.unionid);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.email != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.email);
        }
    }

    public /* synthetic */ LegacyProfile(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, str3, str4, (i & 16) != 0 ? null : str5);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOpenid() {
        return this.openid;
    }

    public final String getUnionid() {
        return this.unionid;
    }

    public final String getEmail() {
        return this.email;
    }
}
