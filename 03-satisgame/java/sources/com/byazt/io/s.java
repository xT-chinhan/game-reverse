package com.byazt.io;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1886, 8})
public class s implements Function<SparseArray<Object>, Object> {
    public final TTAppDownloadListener n;

    public s(TTAppDownloadListener tTAppDownloadListener) {
        this.n = tTAppDownloadListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 221101:
                this.n.onIdle();
                return null;
            case 221102:
                this.n.onDownloadActive(valueSetQg.longValue(0), valueSetQg.longValue(1), valueSetQg.stringValue(2), valueSetQg.stringValue(3));
                return null;
            case 221103:
                this.n.onDownloadPaused(valueSetQg.longValue(0), valueSetQg.longValue(1), valueSetQg.stringValue(2), valueSetQg.stringValue(3));
                return null;
            case 221104:
                this.n.onDownloadFailed(valueSetQg.longValue(0), valueSetQg.longValue(1), valueSetQg.stringValue(2), valueSetQg.stringValue(3));
                return null;
            case 221105:
                this.n.onDownloadFinished(valueSetQg.longValue(0), valueSetQg.stringValue(1), valueSetQg.stringValue(2));
                return null;
            case 221106:
                this.n.onInstalled(valueSetQg.stringValue(0), valueSetQg.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
