package com.taptap.sdk.compliance.internal;

import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.base.network.annotation.RequiresAuthorization;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.retrofit2.http.Body;
import com.taptap.sdk.retrofit2.http.GET;
import com.taptap.sdk.retrofit2.http.HeaderMap;
import com.taptap.sdk.retrofit2.http.POST;
import com.taptap.sdk.retrofit2.http.QueryMap;
import com.taptap.sdk.retrofit2.http.Url;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: TapComplianceApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@RequiresAuthorization
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H§@¢\u0006\u0002\u0010\tJN\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0001\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/compliance/internal/ComplianceApiService;", "", "get", "Lkotlinx/serialization/json/JsonElement;", "path", "", "query", "", "headers", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "post", "body", "Lkotlinx/serialization/json/JsonObject;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/json/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module(name = SdkModules.COMPLIANCE, version = "4.10.9")
public interface ComplianceApiService {
    @GET
    Object get(@Url String str, @QueryMap Map<String, String> map, @HeaderMap Map<String, String> map2, Continuation<? super JsonElement> continuation);

    @POST
    Object post(@Url String str, @QueryMap Map<String, String> map, @HeaderMap Map<String, String> map2, @Body JsonObject jsonObject, Continuation<? super JsonElement> continuation);
}
