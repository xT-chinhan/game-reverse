package com.taptap.sdk.compliance.bean;

import com.byazt.mg.PluginConstants;
import com.taptap.sdk.db.constant.Common;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: UserInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002?@Bc\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBU\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÂ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J^\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u00100\u001a\u00020\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0006\u00102\u001a\u00020.J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J\u000e\u00107\u001a\u0002042\u0006\u00105\u001a\u00020\u0003J&\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=HÁ\u0001¢\u0006\u0002\b>R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014¨\u0006A"}, d2 = {"Lcom/taptap/sdk/compliance/bean/UserInfo;", "", "seen1", "", PluginConstants.KEY_ERROR_CODE, "", "userId", "ageLimit", "accessToken", "remainTime", "saveTimeStamp", "", "game", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IJLjava/lang/String;)V", "getAccessToken$annotations", "()V", "getAccessToken", "()Ljava/lang/String;", "getAgeLimit$annotations", "getAgeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode$annotations", "getCode", "getGame", "setGame", "(Ljava/lang/String;)V", "getSaveTimeStamp", "()J", "setSaveTimeStamp", "(J)V", "getUserId$annotations", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IJLjava/lang/String;)Lcom/taptap/sdk/compliance/bean/UserInfo;", "equals", "", "other", "getRemainTime", "hashCode", "isAdult", "resetRemainTime", "", "time", "toString", "updateRemainTime", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_compliance_release", "$serializer", "Companion", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class UserInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String accessToken;
    private final Integer ageLimit;
    private final String code;
    private String game;
    private int remainTime;
    private long saveTimeStamp;
    private final String userId;

    public UserInfo() {
        this((String) null, (String) null, (Integer) null, (String) null, 0, 0L, (String) null, WorkQueueKt.MASK, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final int getRemainTime() {
        return this.remainTime;
    }

    @SerialName("access_token")
    public static /* synthetic */ void getAccessToken$annotations() {
    }

    @SerialName("ageLimit")
    public static /* synthetic */ void getAgeLimit$annotations() {
    }

    @SerialName(PluginConstants.KEY_ERROR_CODE)
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName(Common.System.USER_ID)
    public static /* synthetic */ void getUserId$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getAgeLimit() {
        return this.ageLimit;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSaveTimeStamp() {
        return this.saveTimeStamp;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGame() {
        return this.game;
    }

    public final UserInfo copy(String code, String userId, Integer ageLimit, String accessToken, int remainTime, long saveTimeStamp, String game) {
        return new UserInfo(code, userId, ageLimit, accessToken, remainTime, saveTimeStamp, game);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.code, userInfo.code) && Intrinsics.areEqual(this.userId, userInfo.userId) && Intrinsics.areEqual(this.ageLimit, userInfo.ageLimit) && Intrinsics.areEqual(this.accessToken, userInfo.accessToken) && this.remainTime == userInfo.remainTime && this.saveTimeStamp == userInfo.saveTimeStamp && Intrinsics.areEqual(this.game, userInfo.game);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.ageLimit;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.accessToken;
        int iHashCode4 = (((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.remainTime)) * 31) + Long.hashCode(this.saveTimeStamp)) * 31;
        String str4 = this.game;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "UserInfo(code=" + this.code + ", userId=" + this.userId + ", ageLimit=" + this.ageLimit + ", accessToken=" + this.accessToken + ", remainTime=" + this.remainTime + ", saveTimeStamp=" + this.saveTimeStamp + ", game=" + this.game + ')';
    }

    /* JADX INFO: compiled from: UserInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/compliance/bean/UserInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/compliance/bean/UserInfo;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UserInfo> serializer() {
            return UserInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UserInfo(int seen1, @SerialName(PluginConstants.KEY_ERROR_CODE) String code, @SerialName(Common.System.USER_ID) String userId, @SerialName("ageLimit") Integer ageLimit, @SerialName("access_token") String accessToken, int remainTime, long saveTimeStamp, String game, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, UserInfo$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            this.code = null;
        } else {
            this.code = code;
        }
        if ((seen1 & 2) == 0) {
            this.userId = null;
        } else {
            this.userId = userId;
        }
        if ((seen1 & 4) == 0) {
            this.ageLimit = null;
        } else {
            this.ageLimit = ageLimit;
        }
        if ((seen1 & 8) == 0) {
            this.accessToken = null;
        } else {
            this.accessToken = accessToken;
        }
        if ((seen1 & 16) == 0) {
            this.remainTime = 0;
        } else {
            this.remainTime = remainTime;
        }
        if ((seen1 & 32) == 0) {
            this.saveTimeStamp = 0L;
        } else {
            this.saveTimeStamp = saveTimeStamp;
        }
        if ((seen1 & 64) == 0) {
            this.game = null;
        } else {
            this.game = game;
        }
    }

    public UserInfo(String code, String userId, Integer ageLimit, String accessToken, int remainTime, long saveTimeStamp, String game) {
        this.code = code;
        this.userId = userId;
        this.ageLimit = ageLimit;
        this.accessToken = accessToken;
        this.remainTime = remainTime;
        this.saveTimeStamp = saveTimeStamp;
        this.game = game;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_compliance_release(UserInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.code);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.userId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.userId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.ageLimit != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.ageLimit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.accessToken != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.accessToken);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.remainTime != 0) {
            output.encodeIntElement(serialDesc, 4, self.remainTime);
        }
        boolean z = output.shouldEncodeElementDefault(serialDesc, 5) || self.saveTimeStamp != 0;
        if (z) {
            output.encodeLongElement(serialDesc, 5, self.saveTimeStamp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.game != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.game);
        }
    }

    public /* synthetic */ UserInfo(String str, String str2, Integer num, String str3, int i, long j, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? 0L : j, (i2 & 64) == 0 ? str4 : null);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Integer getAgeLimit() {
        return this.ageLimit;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final long getSaveTimeStamp() {
        return this.saveTimeStamp;
    }

    public final void setSaveTimeStamp(long j) {
        this.saveTimeStamp = j;
    }

    public final String getGame() {
        return this.game;
    }

    public final void setGame(String str) {
        this.game = str;
    }

    public final synchronized void updateRemainTime(int time) {
        int i = this.remainTime - time;
        this.remainTime = i;
        if (i < 0) {
            this.remainTime = 0;
        }
    }

    public final void resetRemainTime(int time) {
        this.remainTime = time;
    }

    public final int getRemainTime() {
        return this.remainTime;
    }

    public final boolean isAdult() {
        Integer num;
        Integer num2 = this.ageLimit;
        return (num2 != null && num2.intValue() == 18) || ((num = this.ageLimit) != null && num.intValue() == 110);
    }
}
