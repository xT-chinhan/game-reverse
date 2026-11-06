package com.anythink.core.common.h;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATRequestingInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ATRequestingInfo {
    protected List<ATAdInfo> a;
    protected List<ATAdInfo> b;

    public b(List<ATAdInfo> list, List<ATAdInfo> list2) {
        this.a = list;
        this.b = list2;
    }

    @Override // com.anythink.core.api.ATRequestingInfo
    public final List<ATAdInfo> getBiddingAttemptAdInfoList() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATRequestingInfo
    public final List<ATAdInfo> getLoadingAdInfoList() {
        return this.a;
    }
}
