package com.taptap.sdk.update.network;

import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.retrofit2.http.GET;
import com.taptap.sdk.retrofit2.http.Query;
import com.taptap.sdk.update.bean.ForceUpdateResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: UpdateApiService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/update/network/UpdateApiService;", "", "checkForceUpdate", "Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "gamePackageName", "", "gameVersion", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module(name = "TapUpdate", version = "4.8.1-beta.7")
public interface UpdateApiService {
    @GET("/app/v1/get-latest")
    Object checkForceUpdate(@Query("identifier") String str, @Query("app_version_code") int i, Continuation<? super ForceUpdateResult> continuation);
}
