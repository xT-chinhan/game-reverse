package com.smartdigimkt.x4;

import android.text.TextUtils;
import com.anythink.core.api.ErrorCode;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends com.smartdigimkt.v4.c {
    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        if (aVar.a == null || TextUtils.isEmpty(aVar.e)) {
            aVar.a(com.smartdigimkt.z3.b.a("10001", "The context or placementId can not be empty."));
            return false;
        }
        if (!SDKContext.getInstance().d) {
            aVar.a(com.smartdigimkt.z3.b.a("10002", ""));
            return false;
        }
        if (!TextUtils.isEmpty(SDKContext.getInstance().a()) && !TextUtils.isEmpty(SDKContext.getInstance().b())) {
            return true;
        }
        aVar.a(com.smartdigimkt.z3.b.a(ErrorCode.appIdError, ""));
        return false;
    }
}
