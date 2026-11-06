package com.smartdigimkt.odopt.api;

import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* JADX INFO: loaded from: classes3.dex */
public interface OaidSDKCallbackListener extends IIdentifierListener {
    void onSupport(IdSupplier idSupplier);

    void onSupport(boolean z, IdSupplier idSupplier);
}
