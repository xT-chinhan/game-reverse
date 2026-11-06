package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bw, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "", "()V", "pattern", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "getPattern", "()Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;", "Lcom/efs/sdk/memleaksdk/monitor/shark/IgnoredReferenceMatcher;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class ReferenceMatcher {
    public abstract ReferencePattern a();

    private ReferenceMatcher() {
    }

    public /* synthetic */ ReferenceMatcher(byte b) {
        this();
    }
}
