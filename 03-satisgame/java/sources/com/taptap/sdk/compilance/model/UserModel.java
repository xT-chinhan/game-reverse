package com.taptap.sdk.compilance.model;

import com.taptap.sdk.compilance.bean.IdentityVerifyState;
import com.taptap.sdk.compilance.bean.TimeRangeConfig;
import com.taptap.sdk.compilance.bean.UserAntiConfig;
import com.taptap.sdk.compilance.bean.UserInfo;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\tR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/compilance/model/UserModel;", "", "()V", "<set-?>", "Lcom/taptap/sdk/compilance/bean/UserInfo;", "currentUser", "getCurrentUser", "()Lcom/taptap/sdk/compilance/bean/UserInfo;", "currentUserAntiConfig", "Lcom/taptap/sdk/compilance/bean/UserAntiConfig;", "getCurrentUserAntiConfig", "()Lcom/taptap/sdk/compilance/bean/UserAntiConfig;", "setCurrentUserAntiConfig", "(Lcom/taptap/sdk/compilance/bean/UserAntiConfig;)V", "holidaySet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getHolidaySet", "()Ljava/util/HashSet;", "unbindUser", "", "updateCurrentUserInfo", "info", "updateIdentifyState", WebLoginFragment.QUERY_KEY_ID, "Lcom/taptap/sdk/compilance/bean/IdentityVerifyState;", "updateUserAntiConfig", "antiConfig", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserModel {
    private static UserInfo currentUser;
    private static UserAntiConfig currentUserAntiConfig;
    public static final UserModel INSTANCE = new UserModel();
    private static final HashSet<String> holidaySet = new HashSet<>();

    private UserModel() {
    }

    public final UserInfo getCurrentUser() {
        return currentUser;
    }

    public final UserAntiConfig getCurrentUserAntiConfig() {
        return currentUserAntiConfig;
    }

    public final void setCurrentUserAntiConfig(UserAntiConfig userAntiConfig) {
        currentUserAntiConfig = userAntiConfig;
    }

    public final HashSet<String> getHolidaySet() {
        return holidaySet;
    }

    public final void updateIdentifyState(IdentityVerifyState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        updateCurrentUserInfo(new UserInfo((String) null, TapComplianceInternal.INSTANCE.getUserId(), Integer.valueOf(state.getAgeLimit()), state.getAccessToken(), 0, 0L, (String) null, 113, (DefaultConstructorMarker) null));
    }

    public final void updateCurrentUserInfo(UserInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        currentUser = info;
    }

    public final void updateUserAntiConfig(UserAntiConfig antiConfig) {
        List<String> holidays;
        Intrinsics.checkNotNullParameter(antiConfig, "antiConfig");
        if (antiConfig.getLocal() == null) {
            return;
        }
        HashSet<String> hashSet = holidaySet;
        hashSet.clear();
        TimeRangeConfig timeRange = antiConfig.getLocal().getTimeRange();
        if (timeRange != null && (holidays = timeRange.getHolidays()) != null) {
            hashSet.addAll(holidays);
        }
        currentUserAntiConfig = antiConfig;
    }

    public final void unbindUser() {
        currentUser = null;
    }
}
