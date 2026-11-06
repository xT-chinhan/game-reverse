package com.taptap.sdk.kit.internal.p000const;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkModules.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/kit/internal/const/SdkModules;", "", "()V", "ACHIEVEMENT", "", "CLOUD_SAVE", "COMPLIANCE", "CORE", "LEADERBOARD", "MOMENT", "PAYMENT", "PROFILE", "RELATION", "RELATION_LITE", "getBuildClz", "moduleName", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SdkModules {
    public static final String ACHIEVEMENT = "TapAchievement";
    public static final String CLOUD_SAVE = "TapCloudSave";
    public static final String COMPLIANCE = "TapCompliance";
    public static final String CORE = "TapSDKCore";
    public static final SdkModules INSTANCE = new SdkModules();
    public static final String LEADERBOARD = "TapLeaderboard";
    public static final String MOMENT = "TapMoment";
    public static final String PAYMENT = "TapPayment";
    public static final String PROFILE = "TapProfile";
    public static final String RELATION = "TapRelation";
    public static final String RELATION_LITE = "TapRelationLite";

    private SdkModules() {
    }

    public final String getBuildClz(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        int iHashCode = moduleName.hashCode();
        if (iHashCode != -673380358) {
            if (iHashCode != 731738783) {
                if (iHashCode == 1685663725 && moduleName.equals(RELATION_LITE)) {
                    return SdkModulesKt.BUILD_CLZ_RELATION_LITE;
                }
            } else if (moduleName.equals(RELATION)) {
                return SdkModulesKt.BUILD_CLZ_RELATION;
            }
        } else if (moduleName.equals(LEADERBOARD)) {
            return SdkModulesKt.BUILD_CLZ_LEADERBOARD;
        }
        return "";
    }
}
