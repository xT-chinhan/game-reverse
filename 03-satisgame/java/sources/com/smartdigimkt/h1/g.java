package com.smartdigimkt.h1;

import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.smartdigimkt.x.b {
    public final /* synthetic */ k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, com.smartdigimkt.b3.l lVar) {
        super(lVar);
        this.b = kVar;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandlerBaseAd.DataFetchListener
    public final void onStatusChanged(int i, String str) {
        WeakReference weakReference = this.b.r;
        if (weakReference == null || weakReference.get() == null) {
            this.b.f();
        }
        WeakReference weakReference2 = this.b.r;
        View view = weakReference2 != null ? (View) weakReference2.get() : null;
        if (view != null && (view instanceof TextView)) {
            ((TextView) view).setText(str);
        }
        if (i == 2) {
            this.b.a(128);
        } else if (i == 4) {
            this.b.a(126);
        } else {
            if (i != 5) {
                return;
            }
            this.b.a(WorkQueueKt.MASK);
        }
    }
}
