package com.taptap.sdk.update.network;

import com.taptap.sdk.base.network.annotation.Module;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.kit.internal.p001const.SdkModules;
import com.taptap.sdk.retrofit2.http.GET;
import com.taptap.sdk.retrofit2.http.Query;
import com.taptap.sdk.update.bean.ForceUpdateResult;
import com.taptap.sdk.update.bean.UpdateResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: UpdateApiService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/update/network/UpdateApiService;", "", "checkForceUpdate", "Lcom/taptap/sdk/update/bean/ForceUpdateResult;", "gamePackageName", "", "gameVersion", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUpdateInfo", "Lcom/taptap/sdk/update/bean/UpdateResult;", BillingClientConstants.PACKAGE_NAME, "versionCode", "updateId", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Module(name = SdkModules.UPDATE, version = "4.10.9")
public interface UpdateApiService {
    @GET("/app/v1/get-latest")
    Object checkForceUpdate(@Query("identifier") String str, @Query("app_version_code") int i, Continuation<? super ForceUpdateResult> continuation);

    @GET("/app/v1/get-uri-by-identifier")
    Object requestUpdateInfo(@Query("identifier") String str, @Query("taptap_version_code") int i, @Query("update_id") String str2, Continuation<? super UpdateResult> continuation);
}
