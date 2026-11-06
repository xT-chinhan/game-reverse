package com.taptap.sdk.common.utils;

import com.tapsdk.tapad.group.constants.Constants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: Chain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\bJ!\u0010\u0004\u001a\u00028\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/common/utils/Interceptor;", "Request", "Response", "", "intercept", "chain", "Lcom/taptap/sdk/common/utils/Interceptor$Chain;", "(Lcom/taptap/sdk/common/utils/Interceptor$Chain;)Ljava/lang/Object;", "Chain", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Interceptor<Request, Response> {

    /* JADX INFO: compiled from: Chain.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003J\u0015\u0010\u0010\u001a\u00028\u00032\u0006\u0010\r\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00018\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/common/utils/Interceptor$Chain;", "Request", "Response", "", Constants.INDEX_FIELD, "", "getIndex", "()I", "interceptors", "", "Lcom/taptap/sdk/common/utils/Interceptor;", "getInterceptors", "()Ljava/util/List;", "request", "getRequest", "()Ljava/lang/Object;", UMModuleRegister.PROCESS, "(Ljava/lang/Object;)Ljava/lang/Object;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Chain<Request, Response> {
        int getIndex();

        List<Interceptor<Request, Response>> getInterceptors();

        Request getRequest();

        Response process(Request request) throws Exception;
    }

    Response intercept(Chain<Request, Response> chain);
}
