package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseATView;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import java.util.HashMap;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends com.smartdigimkt.x.b {
    public final /* synthetic */ com.smartdigimkt.b3.c b;
    public final /* synthetic */ BaseATView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(BaseATView baseATView, com.smartdigimkt.b3.c cVar, com.smartdigimkt.b3.c cVar2) {
        super(cVar);
        this.c = baseATView;
        this.b = cVar2;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd.DataFetchListener
    public final void onStatusChanged(int i, String str) {
        View view = this.c.m;
        if (view != null && (view instanceof CTAButtonLayout)) {
            ((CTAButtonLayout) view).setMajorCTAText(str);
        }
        if (this.c.o != null) {
            HashMap map = new HashMap();
            map.put("cta_text", str);
            this.c.o.a(map);
        }
        this.c.a(121);
        if (i == 2) {
            BaseATView baseATView = this.c;
            String str2 = baseATView.a;
            String str3 = this.b.m;
            baseATView.a(128);
            return;
        }
        if (i == 4) {
            this.c.a(126);
        } else {
            if (i != 5) {
                return;
            }
            this.c.a(WorkQueueKt.MASK);
        }
    }
}
