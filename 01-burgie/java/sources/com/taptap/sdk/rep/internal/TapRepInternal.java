package com.taptap.sdk.rep.internal;

import android.content.Intent;
import android.net.Uri;
import com.byazt.eyv.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.C;
import com.taptap.sdk.common.network.throwable.ApiErr;
import com.taptap.sdk.common.network.throwable.TapNetworkException;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.StringExtKt;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.rep.internal.api.RepRepository;
import com.taptap.sdk.rep.internal.model.RepResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapRepInternal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/rep/internal/TapRepInternal;", "", "()V", "open", "", "openUrl", "", "callback", "Lcom/taptap/sdk/rep/internal/TapRepResultCallback;", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapRepInternal {
    public static final TapRepInternal INSTANCE = new TapRepInternal();

    private TapRepInternal() {
    }

    public final void open(final String openUrl, final TapRepResultCallback callback) {
        Intrinsics.checkNotNullParameter(openUrl, "openUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String sessionId = StringExtKt.generateSessionId();
        RepTracker.trackStart("open", sessionId, MapsKt.mapOf(TuplesKt.to(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, openUrl)));
        RepRepository.INSTANCE.getRepLink(openUrl, new TapTapCallback<RepResponse>() { // from class: com.taptap.sdk.rep.internal.TapRepInternal.open.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x005f A[Catch: all -> 0x009f, TryCatch #0 {all -> 0x009f, blocks: (B:3:0x000f, B:5:0x001c, B:10:0x002d, B:12:0x0067, B:11:0x005f), top: B:24:0x000f }] */
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(RepResponse result) {
                Object objM534constructorimpl;
                Uri clientUri;
                Intrinsics.checkNotNullParameter(result, "result");
                String str = sessionId;
                String str2 = openUrl;
                TapRepResultCallback tapRepResultCallback = callback;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AnonymousClass1 anonymousClass1 = this;
                    if (SysExtKt.isTapInstalled()) {
                        if (result.getUri().length() > 0) {
                            clientUri = Uri.parse(result.getUri()).buildUpon().appendQueryParameter("ch_src", result.getChSrcPrefix() + '-' + str).build();
                        } else {
                            clientUri = Uri.parse(result.getUrl());
                        }
                    } else {
                        clientUri = Uri.parse(result.getUrl());
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(clientUri);
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                    TapTapKit.INSTANCE.getContext().startActivity(intent);
                    RepTracker.trackSuccess("open", str, MapsKt.mapOf(TuplesKt.to(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str2)));
                    tapRepResultCallback.onRepSuccess();
                    objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
                }
                String str3 = sessionId;
                String str4 = openUrl;
                TapRepResultCallback tapRepResultCallback2 = callback;
                Throwable error = Result.m537exceptionOrNullimpl(objM534constructorimpl);
                if (error != null) {
                    RepTracker.trackFail("open", str3, MapsKt.mapOf(TuplesKt.to(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str4)), Integer.valueOf(TapRepResultCallbackKt.REP_FAIL_UNKNOWN_ERROR), "请求rep链接错误");
                    String message = error.getMessage();
                    tapRepResultCallback2.onRepFail(TapRepResultCallbackKt.REP_FAIL_UNKNOWN_ERROR, message != null ? message : "请求rep链接错误");
                }
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                if (exception instanceof TapNetworkException) {
                    String err = ((TapNetworkException) exception).getErr().getApiErr().getErr();
                    if (Intrinsics.areEqual(err, ApiErr.INVALID_CLIENT.INSTANCE.getErr())) {
                        RepTracker.trackFail("open", sessionId, MapsKt.mapOf(TuplesKt.to(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, openUrl)), Integer.valueOf(TapRepResultCallbackKt.REP_FAIL_CLIENT_ERROR), com.taptap.sdk.rep.internal.extensions.SysExtKt.getErrorMessage(exception, "请求rep链接错误，请检查clientId"));
                        callback.onRepFail(TapRepResultCallbackKt.REP_FAIL_CLIENT_ERROR, com.taptap.sdk.rep.internal.extensions.SysExtKt.getErrorMessage(exception, "请求rep链接错误，请检查clientId"));
                        return;
                    } else {
                        if (Intrinsics.areEqual(err, ApiErr.INVALID_REQUEST.INSTANCE.getErr())) {
                            RepTracker.trackFail("open", sessionId, MapsKt.mapOf(TuplesKt.to(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, openUrl)), Integer.valueOf(TapRepResultCallbackKt.REP_FAIL_PARAM_ERROR), com.taptap.sdk.rep.internal.extensions.SysExtKt.getErrorMessage(exception, "请求rep链接错误，请检查参数"));
                            callback.onRepFail(TapRepResultCallbackKt.REP_FAIL_PARAM_ERROR, com.taptap.sdk.rep.internal.extensions.SysExtKt.getErrorMessage(exception, "请求rep链接错误，请检查参数"));
                            return;
                        }
                        return;
                    }
                }
                String str = sessionId;
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, openUrl));
                Integer numValueOf = Integer.valueOf(TapRepResultCallbackKt.REP_FAIL_UNKNOWN_ERROR);
                String message = exception.getMessage();
                if (message == null) {
                    message = "请求rep链接错误";
                }
                RepTracker.trackFail("open", str, mapMapOf, numValueOf, message);
                TapRepResultCallback tapRepResultCallback = callback;
                String message2 = exception.getMessage();
                tapRepResultCallback.onRepFail(TapRepResultCallbackKt.REP_FAIL_UNKNOWN_ERROR, message2 != null ? message2 : "请求rep链接错误");
            }
        });
    }
}
