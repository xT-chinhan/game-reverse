package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import com.bytedance.sdk.openadsdk.core.dislike.ms.xr;

/* JADX INFO: loaded from: classes2.dex */
public class TTDislikeScrollListView extends ListView {
    private AdapterView.OnItemClickListener ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private xr f4294ms;
    private AdapterView.OnItemClickListener xr;

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.ah = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeScrollListView.this.getAdapter() != null && TTDislikeScrollListView.this.getAdapter().getItem(i) != null && (TTDislikeScrollListView.this.getAdapter().getItem(i) instanceof c)) {
                    c cVar = (c) TTDislikeScrollListView.this.getAdapter().getItem(i);
                    if (cVar.c()) {
                        return;
                    }
                    if (TTDislikeScrollListView.this.xr != null) {
                        TTDislikeScrollListView.this.xr.onItemClick(adapterView, view, i, j);
                    }
                    if (TTDislikeScrollListView.this.f4294ms != null) {
                        TTDislikeScrollListView.this.f4294ms.ms(cVar);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        ms();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void ms() {
        super.setOnItemClickListener(this.ah);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.xr = onItemClickListener;
    }

    public void setDislikeController(xr xrVar) {
        this.f4294ms = xrVar;
    }
}
