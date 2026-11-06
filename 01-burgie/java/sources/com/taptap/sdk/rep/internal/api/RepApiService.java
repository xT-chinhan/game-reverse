package com.taptap.sdk.rep.internal.api;

import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.rep.internal.model.RepResponse;
import com.taptap.sdk.retrofit2.http.GET;
import com.taptap.sdk.retrofit2.http.QueryMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: RepApiService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0014\b\u0003\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/rep/internal/api/RepApiService;", "", "getRepLink", "Lcom/taptap/sdk/rep/internal/model/RepResponse;", "queryMap", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-rep_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module(name = SdkModules.REP, version = "4.10.9")
public interface RepApiService {
    @GET(RepApiServiceKt.PATH_REP)
    Object getRepLink(@QueryMap Map<String, String> map, Continuation<? super RepResponse> continuation);

    /* JADX INFO: compiled from: RepApiService.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object getRepLink$default(RepApiService repApiService, Map map, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRepLink");
            }
            if ((i & 1) != 0) {
                map = MapsKt.emptyMap();
            }
            return repApiService.getRepLink(map, continuation);
        }
    }
}
