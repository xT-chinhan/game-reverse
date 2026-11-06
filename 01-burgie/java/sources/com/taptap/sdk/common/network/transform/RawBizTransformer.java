package com.taptap.sdk.common.network.transform;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.taptap.sdk.base.network.transform.BizTransformer;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawBizTransformer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/common/network/transform/RawBizTransformer;", "Lcom/taptap/sdk/base/network/transform/BizTransformer;", "()V", "transform", "Ljava/io/InputStream;", LiveConfigKey.ORIGIN, "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RawBizTransformer implements BizTransformer {
    @Override // com.taptap.sdk.base.network.transform.BizTransformer
    public InputStream transform(InputStream origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        return origin;
    }
}
