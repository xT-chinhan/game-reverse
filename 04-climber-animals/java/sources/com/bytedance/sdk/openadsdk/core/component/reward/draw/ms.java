package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends RecyclerView.ms<ka> {
    private final float ah;
    private final float d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f2158ms;
    private final List<xr> xr = new ArrayList();
    private final List<ka> ka = new ArrayList();

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public int ms() {
        return Integer.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public long xr(int i) {
        return i;
    }

    public ms(Context context, float f, float f2) {
        this.f2158ms = context;
        this.ah = f;
        this.d = f2;
    }

    public void ms(List<xr> list) {
        this.xr.clear();
        this.xr.addAll(list);
        ah();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public void ms(ka kaVar) {
        super.ms(kaVar);
        kaVar.jw();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
    public ka ms(ViewGroup viewGroup, int i) {
        ka kaVar = new ka(com.bytedance.sdk.openadsdk.res.ka.hi(this.f2158ms));
        this.ka.add(kaVar);
        return kaVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public void ms(ka kaVar, int i) {
        List<xr> list = this.xr;
        kaVar.ms(list.get(i % list.size()), this.ah, this.d);
    }

    public void d() {
        Iterator<ka> it = this.ka.iterator();
        while (it.hasNext()) {
            it.next().jw();
        }
        this.ka.clear();
    }
}
