package com.taptap.sdk.compilance.internal;

import com.anythink.core.common.l.f;
import com.taptap.sdk.compilance.bean.UserInfo;
import com.taptap.sdk.compilance.model.UserModel;
import com.taptap.sdk.kit.internal.http.call.ITapHttpCall;
import com.taptap.sdk.kit.internal.http.call.TapHttpCall;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpParser;
import com.taptap.sdk.kit.internal.http.hanlder.TapHttpRetry;
import com.taptap.sdk.kit.internal.http.param.AbsTapHttpParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpJsonParam;
import com.taptap.sdk.kit.internal.http.param.TapHttpNoBodyParam;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: TapComplianceApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH\u0086Hø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJT\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0086Hø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/compilance/internal/TapComplianceApi;", "", "()V", "get", "Lkotlin/Result;", "T", "path", "", "queryMap", "", "headerMap", "get-BWLJW6A", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "body", "post-BWLJW6A", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceApi {
    public static final TapComplianceApi INSTANCE = new TapComplianceApi();

    private TapComplianceApi() {
    }

    /* JADX INFO: renamed from: get-BWLJW6A$default, reason: not valid java name */
    public static /* synthetic */ Object m66getBWLJW6A$default(TapComplianceApi tapComplianceApi, String str, Map map, Map map2, Continuation continuation, int i, Object obj) {
        String accessToken;
        LinkedHashMap linkedHashMap = (i & 2) != 0 ? new LinkedHashMap() : map;
        LinkedHashMap linkedHashMap2 = (i & 4) != 0 ? new LinkedHashMap() : map2;
        TapHttpNoBodyParam tapHttpNoBodyParam = TapComplianceApiKt.getNetApi().get(str);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam, (String) entry2.getKey(), (String) entry2.getValue(), false, 4, null);
            Unit unit2 = Unit.INSTANCE;
        }
        if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
            AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, f.aI, "1", false, 4, null);
        }
        TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
            accessToken = "";
        }
        AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam2, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
        Intrinsics.needClassReification();
        TapHttpCall tapHttpCall = new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(null, TapComplianceApi$getBWLJW6A$$inlined$toCall$1.INSTANCE, 1, null), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler()));
        InlineMarker.mark(0);
        Object objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(tapHttpCall, 0L, continuation, 1, null);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object value = ((Result) objM76enqueueResultgIAlus$default).getValue();
        InlineMarker.mark(9);
        return value;
    }

    /* JADX INFO: renamed from: get-BWLJW6A, reason: not valid java name */
    public final /* synthetic */ <T> Object m68getBWLJW6A(String str, Map<String, String> map, Map<String, String> map2, Continuation<? super Result<? extends T>> continuation) {
        String accessToken;
        TapHttpNoBodyParam tapHttpNoBodyParam = TapComplianceApiKt.getNetApi().get(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, entry.getKey(), entry.getValue(), false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        for (Map.Entry<String, String> entry2 : map2.entrySet()) {
            AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam, entry2.getKey(), entry2.getValue(), false, 4, null);
            Unit unit2 = Unit.INSTANCE;
        }
        if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
            AbsTapHttpParam.addQuery$default(tapHttpNoBodyParam, f.aI, "1", false, 4, null);
        }
        TapHttpNoBodyParam tapHttpNoBodyParam2 = tapHttpNoBodyParam;
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
            accessToken = "";
        }
        AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpNoBodyParam2, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
        Intrinsics.needClassReification();
        TapHttpCall tapHttpCall = new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(null, TapComplianceApi$getBWLJW6A$$inlined$toCall$1.INSTANCE, 1, null), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler()));
        InlineMarker.mark(0);
        Object objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(tapHttpCall, 0L, continuation, 1, null);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object value = ((Result) objM76enqueueResultgIAlus$default).getValue();
        InlineMarker.mark(9);
        return value;
    }

    /* JADX INFO: renamed from: post-BWLJW6A$default, reason: not valid java name */
    public static /* synthetic */ Object m67postBWLJW6A$default(TapComplianceApi tapComplianceApi, String str, Map map, String str2, Continuation continuation, int i, Object obj) {
        JSONObject jSONObject;
        String accessToken;
        if ((i & 2) != 0) {
            map = new LinkedHashMap();
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        TapHttpJsonParam tapHttpJsonParamPostJson = TapComplianceApiKt.getNetApi().postJson(str);
        for (Map.Entry entry : map.entrySet()) {
            AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        if (str2 != null) {
            jSONObject = new JSONObject(str2);
        } else {
            jSONObject = new JSONObject();
        }
        if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
            AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, f.aI, "1", false, 4, null);
        }
        tapHttpJsonParamPostJson.addBody(jSONObject);
        TapComplianceLoggerKt.logInfo("TapComplianceApi post: body=" + jSONObject);
        TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
            accessToken = "";
        }
        AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpJsonParam, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
        Intrinsics.needClassReification();
        TapHttpCall tapHttpCall = new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(null, TapComplianceApi$postBWLJW6A$$inlined$toCall$1.INSTANCE, 1, null), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler()));
        InlineMarker.mark(0);
        Object objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(tapHttpCall, 0L, continuation, 1, null);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object value = ((Result) objM76enqueueResultgIAlus$default).getValue();
        InlineMarker.mark(9);
        return value;
    }

    /* JADX INFO: renamed from: post-BWLJW6A, reason: not valid java name */
    public final /* synthetic */ <T> Object m69postBWLJW6A(String str, Map<String, String> map, String str2, Continuation<? super Result<? extends T>> continuation) {
        JSONObject jSONObject;
        String accessToken;
        TapHttpJsonParam tapHttpJsonParamPostJson = TapComplianceApiKt.getNetApi().postJson(str);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, entry.getKey(), entry.getValue(), false, 4, null);
            Unit unit = Unit.INSTANCE;
        }
        if (str2 != null) {
            jSONObject = new JSONObject(str2);
        } else {
            jSONObject = new JSONObject();
        }
        if (TapComplianceInternal.INSTANCE.isTestEnvironment()) {
            AbsTapHttpParam.addQuery$default(tapHttpJsonParamPostJson, f.aI, "1", false, 4, null);
        }
        tapHttpJsonParamPostJson.addBody(jSONObject);
        TapComplianceLoggerKt.logInfo("TapComplianceApi post: body=" + jSONObject);
        TapHttpJsonParam tapHttpJsonParam = tapHttpJsonParamPostJson;
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser == null || (accessToken = currentUser.getAccessToken()) == null) {
            accessToken = "";
        }
        AbsTapHttpParam absTapHttpParamAddHeader$default = AbsTapHttpParam.addHeader$default(tapHttpJsonParam, "X-TAP-Anti-Addiction-Token", accessToken, false, 4, null);
        Intrinsics.needClassReification();
        TapHttpCall tapHttpCall = new TapHttpCall(absTapHttpParamAddHeader$default, new TapHttpParser.SdkDefaultParser(null, TapComplianceApi$postBWLJW6A$$inlined$toCall$1.INSTANCE, 1, null), new TapHttpRetry.SdkDefault(absTapHttpParamAddHeader$default.getBackoffHandler()));
        InlineMarker.mark(0);
        Object objM76enqueueResultgIAlus$default = ITapHttpCall.DefaultImpls.m76enqueueResultgIAlus$default(tapHttpCall, 0L, continuation, 1, null);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object value = ((Result) objM76enqueueResultgIAlus$default).getValue();
        InlineMarker.mark(9);
        return value;
    }
}
