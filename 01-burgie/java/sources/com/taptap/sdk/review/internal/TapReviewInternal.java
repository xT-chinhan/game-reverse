package com.taptap.sdk.review.internal;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.taptap.sdk.initializer.api.service.InitializerService;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.extensions.StringExtKt;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.PrivateTapSdkAccount;
import com.taptap.sdk.login.api.LoginService;
import com.taptap.sdk.review.ReviewCrossAppCodeCallback;
import com.taptap.sdk.servicemanager.ServiceManager;
import com.taptap.sdk.servicemanager.utils.ServiceManagerComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TapReviewInternal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u000fJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/taptap/sdk/review/internal/TapReviewInternal;", "", "()V", "initializerService", "Lcom/taptap/sdk/initializer/api/service/InitializerService;", "getInitializerService", "()Lcom/taptap/sdk/initializer/api/service/InitializerService;", "initializerService$delegate", "Lkotlin/Lazy;", "loginService", "Lcom/taptap/sdk/login/api/LoginService;", "getLoginService", "()Lcom/taptap/sdk/login/api/LoginService;", "loginService$delegate", "goTapDownloadPage", "", "handleReviewAction", "crossAppCode", "", "openReview", "startViewIntent", "", ContentProviderManager.PROVIDER_URI, "Landroid/net/Uri;", "targetPackage", "uriForLog", "tap-review_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapReviewInternal {
    public static final TapReviewInternal INSTANCE = new TapReviewInternal();

    /* JADX INFO: renamed from: initializerService$delegate, reason: from kotlin metadata */
    private static final Lazy initializerService;

    /* JADX INFO: renamed from: loginService$delegate, reason: from kotlin metadata */
    private static final Lazy loginService;

    private TapReviewInternal() {
    }

    static {
        ServiceManagerComponent serviceManagerComponent = ServiceManagerComponent.INSTANCE;
        initializerService = LazyKt.lazy(new Function0<InitializerService>() { // from class: com.taptap.sdk.review.internal.TapReviewInternal$special$$inlined$inject$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final InitializerService invoke() {
                ServiceManager.Service service = ServiceManager.INSTANCE.getService(InitializerService.class);
                if (service != null) {
                    return (InitializerService) service;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.taptap.sdk.initializer.api.service.InitializerService");
            }
        });
        ServiceManagerComponent serviceManagerComponent2 = ServiceManagerComponent.INSTANCE;
        loginService = LazyKt.lazy(new Function0<LoginService>() { // from class: com.taptap.sdk.review.internal.TapReviewInternal$special$$inlined$inject$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoginService invoke() {
                ServiceManager.Service service = ServiceManager.INSTANCE.getService(LoginService.class);
                if (service != null) {
                    return (LoginService) service;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.taptap.sdk.login.api.LoginService");
            }
        });
    }

    private final InitializerService getInitializerService() {
        return (InitializerService) initializerService.getValue();
    }

    private final LoginService getLoginService() {
        return (LoginService) loginService.getValue();
    }

    public final void openReview() {
        AccessToken accessToken;
        ReviewTracker.trackStart$tap_review_release$default(ReviewTracker.INSTANCE, "openReview", StringExtKt.generateSessionId(), null, 4, null);
        if (!SysExtKt.isTapInstalled()) {
            SysExtKt.showToast("下载 TapTap 客户端即可发布评价");
            goTapDownloadPage();
            return;
        }
        PrivateTapSdkAccount currentTapAccount = getLoginService().getCurrentTapAccount();
        String kid = (currentTapAccount == null || (accessToken = currentTapAccount.getAccessToken()) == null) ? null : accessToken.getKid();
        boolean hasToken = !(kid == null || kid.length() == 0);
        if (!hasToken) {
            handleReviewAction(null);
        } else {
            TapReviewApi.INSTANCE.fetchCrossAppCode(new ReviewCrossAppCodeCallback() { // from class: com.taptap.sdk.review.internal.TapReviewInternal.openReview.1
                @Override // com.taptap.sdk.review.ReviewCrossAppCodeCallback
                public void onCodeResult(String crossAppCode) {
                    TapReviewInternal.INSTANCE.handleReviewAction(crossAppCode);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleReviewAction(String crossAppCode) {
        Object objM534constructorimpl;
        String reviewUri = getInitializerService().getReviewUrl(ContentProviderManager.PROVIDER_URI);
        if (reviewUri == null) {
            reviewUri = "";
        }
        if (StringsKt.isBlank(reviewUri)) {
            TapLoggerKt.logError$default("handleReviewAction: review uri is empty, fallback to download page", null, 2, null);
            goTapDownloadPage();
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TapReviewInternal $this$handleReviewAction_u24lambda_u241 = this;
            Uri parsed = Uri.parse(reviewUri);
            StringBuilder sbAppend = new StringBuilder().append("handleReviewAction: origin review uri=");
            Intrinsics.checkNotNullExpressionValue(parsed, "parsed");
            TapLoggerKt.logInfo(sbAppend.append($this$handleReviewAction_u24lambda_u241.uriForLog(parsed)).toString());
            Uri.Builder $this$handleReviewAction_u24lambda_u241_u24lambda_u240 = parsed.buildUpon();
            String str = crossAppCode;
            if (!(str == null || StringsKt.isBlank(str)) && !parsed.getQueryParameterNames().contains("tapsdk_cross_app_code")) {
                $this$handleReviewAction_u24lambda_u241_u24lambda_u240.appendQueryParameter("tapsdk_cross_app_code", crossAppCode);
            }
            Uri uri = $this$handleReviewAction_u24lambda_u241_u24lambda_u240.appendQueryParameter("sdk_identifier", TapTapKit.INSTANCE.getContext().getPackageName()).build();
            StringBuilder sbAppend2 = new StringBuilder().append("handleReviewAction: final review uri=");
            Intrinsics.checkNotNullExpressionValue(uri, "uri");
            TapLoggerKt.logInfo(sbAppend2.append($this$handleReviewAction_u24lambda_u241.uriForLog(uri)).toString());
            if (!$this$handleReviewAction_u24lambda_u241.startViewIntent(uri, SysExtKt.getTapPkgName())) {
                $this$handleReviewAction_u24lambda_u241.goTapDownloadPage();
            }
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLoggerKt.logError("handleReviewAction failed", it);
            INSTANCE.goTapDownloadPage();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    private final void goTapDownloadPage() {
        Object objM534constructorimpl;
        String url = getInitializerService().getReviewUrl("browser");
        if (url == null) {
            url = "https://www.taptap.com/mobile";
        } else {
            if (!(!StringsKt.isBlank(url))) {
                url = null;
            }
            if (url == null) {
                url = "https://www.taptap.com/mobile";
            }
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TapReviewInternal $this$goTapDownloadPage_u24lambda_u244 = this;
            Uri uri = Uri.parse(url);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(url)");
            if (!$this$goTapDownloadPage_u24lambda_u244.startViewIntent(uri, null)) {
                StringBuilder sbAppend = new StringBuilder().append("goTapDownloadPage: no activity can handle url=");
                Uri uri2 = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(uri2, "parse(url)");
                TapLoggerKt.logError$default(sbAppend.append($this$goTapDownloadPage_u24lambda_u244.uriForLog(uri2)).toString(), null, 2, null);
            }
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLoggerKt.logError("goTapDownloadPage failed", it);
        }
    }

    private final boolean startViewIntent(Uri uri, String targetPackage) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        String str = targetPackage;
        if (!(str == null || StringsKt.isBlank(str))) {
            intent.setPackage(targetPackage);
        } else {
            intent.addCategory("android.intent.category.BROWSABLE");
        }
        ResolveInfo resolved = TapTapKit.INSTANCE.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolved == null) {
            TapLoggerKt.logError$default("startViewIntent: unresolved uri=" + uriForLog(uri) + " package=" + targetPackage, null, 2, null);
            return false;
        }
        TapTapKit.INSTANCE.getContext().startActivity(intent);
        return true;
    }

    private final String uriForLog(Uri uri) {
        String authority = uri.getAuthority();
        if (authority == null) {
            authority = "";
        }
        String path = uri.getPath();
        String path2 = path != null ? path : "";
        return uri.getScheme() + "://" + authority + path2;
    }
}
