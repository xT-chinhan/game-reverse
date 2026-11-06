package com.taptap.sdk.common.utils;

import com.tapsdk.tapad.group.constants.Constants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Chain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B7\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nJ\u0015\u0010\u0012\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00018\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/common/utils/RealChain;", "Request", "Response", "Lcom/taptap/sdk/common/utils/Interceptor$Chain;", "interceptors", "", "Lcom/taptap/sdk/common/utils/Interceptor;", Constants.INDEX_FIELD, "", "request", "(Ljava/util/List;ILjava/lang/Object;)V", "getIndex", "()I", "getInterceptors", "()Ljava/util/List;", "getRequest", "()Ljava/lang/Object;", "Ljava/lang/Object;", UMModuleRegister.PROCESS, "(Ljava/lang/Object;)Ljava/lang/Object;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealChain<Request, Response> implements Interceptor.Chain<Request, Response> {
    private final int index;
    private final List<Interceptor<Request, Response>> interceptors;
    private final Request request;

    public RealChain() {
        this(null, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealChain(List<? extends Interceptor<Request, Response>> interceptors, int index, Request request) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.interceptors = interceptors;
        this.index = index;
        this.request = request;
    }

    public /* synthetic */ RealChain(List list, int i, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : obj);
    }

    @Override // com.taptap.sdk.common.utils.Interceptor.Chain
    public List<Interceptor<Request, Response>> getInterceptors() {
        return this.interceptors;
    }

    @Override // com.taptap.sdk.common.utils.Interceptor.Chain
    public int getIndex() {
        return this.index;
    }

    @Override // com.taptap.sdk.common.utils.Interceptor.Chain
    public Request getRequest() {
        return this.request;
    }

    @Override // com.taptap.sdk.common.utils.Interceptor.Chain
    public Response process(Request request) throws Exception {
        if (getIndex() >= getInterceptors().size()) {
            throw new IllegalArgumentException("interceptors index out of range");
        }
        RealChain next = new RealChain(getInterceptors(), getIndex() + 1, request);
        return getInterceptors().get(getIndex()).intercept(next);
    }
}
