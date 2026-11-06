package com.efs.sdk.memleaksdk.monitor.shark;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bq, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener;", "", "onHprofRecord", "", TTDownloadField.TT_TAG, "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "length", "", "reader", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public interface OnHprofRecordTagListener {
    public static final a a = a.a;

    void a(HprofRecordTag hprofRecordTag, long j, HprofRecordReader hprofRecordReader);

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bq$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042 \b\u0004\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0006H\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener$Companion;", "", "()V", "invoke", "Lcom/efs/sdk/memleaksdk/monitor/shark/OnHprofRecordTagListener;", "block", "Lkotlin/Function3;", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordTag;", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/HprofRecordReader;", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }
}
