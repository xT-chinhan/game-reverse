package com.taptap.sdk.common.services;

import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.servicemanager.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: GidService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u0010\u0011J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH&¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/common/services/GidService;", "Lcom/taptap/sdk/servicemanager/ServiceManager$Service;", "getCurrentGid", "", "getCurrentTdid", "getGid", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTdid", "registerGidCallback", "", "callback", "Lcom/taptap/sdk/common/services/GidService$GidCallback;", "registerTdidCallback", "Lcom/taptap/sdk/common/services/GidService$TdidCallback;", "unregisterGidCallback", "unregisterTdidCallback", "GidCallback", "TdidCallback", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface GidService extends ServiceManager.Service {

    /* JADX INFO: compiled from: GidService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/common/services/GidService$GidCallback;", "", "onGidUpdated", "", Common.Predefined.GID, "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface GidCallback {
        void onGidUpdated(String gid);
    }

    /* JADX INFO: compiled from: GidService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/common/services/GidService$TdidCallback;", "", "onTdidUpdated", "", Common.Predefined.TDID, "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface TdidCallback {
        void onTdidUpdated(String tdid);
    }

    String getCurrentGid();

    String getCurrentTdid();

    Object getGid(Continuation<? super String> continuation);

    Object getTdid(Continuation<? super String> continuation);

    void registerGidCallback(GidCallback callback);

    void registerTdidCallback(TdidCallback callback);

    void unregisterGidCallback(GidCallback callback);

    void unregisterTdidCallback(TdidCallback callback);
}
