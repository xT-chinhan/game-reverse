package com.taptap.sdk.gid.service;

import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.gid.api.GidService;
import com.taptap.sdk.gid.internal.TapTapGidInner;
import com.taptap.sdk.kit.internal.service.ITapServiceCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GidServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/gid/service/GidServiceImpl;", "Lcom/taptap/sdk/gid/api/GidService;", "()V", "gidCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/taptap/sdk/kit/internal/service/ITapServiceCallback;", "getGid", "", "notifyUpdateCallbacks", "", "code", "", TapEventParamConstants.PARAM_SUB_GID, "registerCallback", "callback", "unregisterCallback", "tap-gid_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GidServiceImpl implements GidService {
    private final CopyOnWriteArrayList<ITapServiceCallback> gidCallbacks = new CopyOnWriteArrayList<>();

    @Override // com.taptap.sdk.gid.api.GidService
    public String getGid() {
        return TapTapGidInner.INSTANCE.getCurrentGid$tap_gid_release();
    }

    @Override // com.taptap.sdk.gid.api.GidService
    public void registerCallback(ITapServiceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.gidCallbacks.contains(callback)) {
            return;
        }
        this.gidCallbacks.add(callback);
        callback.onResult(3, TapTapGidInner.INSTANCE.getCurrentGid$tap_gid_release());
    }

    @Override // com.taptap.sdk.gid.api.GidService
    public void unregisterCallback(ITapServiceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.gidCallbacks.remove(callback);
    }

    @Override // com.taptap.sdk.gid.api.GidService
    public void notifyUpdateCallbacks(int code, String gid) {
        Intrinsics.checkNotNullParameter(gid, "gid");
        Iterator<ITapServiceCallback> it = this.gidCallbacks.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "gidCallbacks.iterator()");
        while (it.hasNext()) {
            it.next().onResult(code, gid);
        }
    }
}
