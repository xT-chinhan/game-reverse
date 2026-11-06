package com.taptap.sdk.kit.internal.p001const;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdkModules.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/taptap/sdk/kit/internal/const/SdkModules;", "", "()V", "ACHIEVEMENT", "", "BATTLE", "CLOUD_SAVE", "COMPLIANCE", "CORE", "LEADERBOARD", "LICENSE", "LOGIN", "MOMENT", "PAYMENT", "PROFILE", "RELATION", "RELATION_LITE", "REP", "REVIEW", "SHARE", "UPDATE", "getBuildClz", "moduleName", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SdkModules {
    public static final String ACHIEVEMENT = "TapAchievement";
    public static final String BATTLE = "TapOnlineBattle";
    public static final String CLOUD_SAVE = "TapCloudSave";
    public static final String COMPLIANCE = "TapCompliance";
    public static final String CORE = "TapSDKCore";
    public static final SdkModules INSTANCE = new SdkModules();
    public static final String LEADERBOARD = "TapLeaderboard";
    public static final String LICENSE = "TapLicense";
    public static final String LOGIN = "TapLogin";
    public static final String MOMENT = "TapMoment";
    public static final String PAYMENT = "TapPayment";
    public static final String PROFILE = "TapProfile";
    public static final String RELATION = "TapRelation";
    public static final String RELATION_LITE = "TapRelationLite";
    public static final String REP = "TapRep";
    public static final String REVIEW = "TapReview";
    public static final String SHARE = "TapShare";
    public static final String UPDATE = "TapUpdate";

    private SdkModules() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[ORIG_RETURN, RETURN] */
    public final String getBuildClz(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        switch (moduleName) {
            case "TapLeaderboard":
                return SdkModulesKt.BUILD_CLZ_LEADERBOARD;
            case "TapRelation":
                return SdkModulesKt.BUILD_CLZ_RELATION;
            case "TapRelationLite":
                return SdkModulesKt.BUILD_CLZ_RELATION_LITE;
            default:
                return "";
        }
    }
}
