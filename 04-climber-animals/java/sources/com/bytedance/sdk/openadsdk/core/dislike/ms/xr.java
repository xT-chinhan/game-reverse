package com.bytedance.sdk.openadsdk.core.dislike.ms;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.dislike.ah.xr f2472ms;

    public xr(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        this.f2472ms = xrVar;
    }

    public void ms(c cVar) {
        if (this.f2472ms == null || cVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ms.ms.ms().ms(this.f2472ms, cVar);
    }

    public static final void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar, Dialog dialog, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        xr xrVar2 = new xr(xrVar);
        for (int i : iArr) {
            View viewFindViewById = dialog.findViewById(i);
            if (viewFindViewById instanceof ListView) {
                ((ListView) viewFindViewById).setOnItemClickListener(new ms());
            }
        }
    }

    private static final class ms implements AdapterView.OnItemClickListener, EventListener {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final xr f2473ms;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }

        private ms(xr xrVar) {
            this.f2473ms = xrVar;
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i, Result result) {
            if (result == null || result.values() == null) {
                return null;
            }
            this.f2473ms.ms(new com.bytedance.sdk.openadsdk.core.dislike.ah.ah(result.values().stringValue(0), result.values().stringValue(1)));
            return null;
        }
    }
}
