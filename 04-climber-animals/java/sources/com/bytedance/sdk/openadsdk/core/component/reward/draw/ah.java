package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.ny;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.component.widget.recycler.ka {
    private boolean b;
    private int i;
    private int nw;
    public boolean qv;
    private boolean re;
    private int t;
    private ms w;
    private final ny y;
    private final RecyclerView.hi yu;

    public interface ms {
        void ms();

        void ms(boolean z, int i);

        void ms(boolean z, int i, boolean z2);
    }

    public ah(Context context, int i, boolean z) {
        super(context, i, z);
        this.b = false;
        this.qv = true;
        this.re = true;
        this.yu = new RecyclerView.hi() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.ah.1
            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.hi
            public void ms(View view) {
                if (ah.this.w == null || ah.this.y() != 1) {
                    return;
                }
                ah.this.w.ms();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.hi
            public void xr(View view) {
                if (ah.this.w != null) {
                    ah.this.w.ms(ah.this.t >= 0, ah.this.d(view));
                }
            }
        };
        this.y = new ny();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void ah(RecyclerView recyclerView) {
        super.ah(recyclerView);
        this.y.ms(recyclerView);
        recyclerView.ms(this.yu);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ka, com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void ms(RecyclerView recyclerView, RecyclerView.ao aoVar) {
        super.ms(recyclerView, aoVar);
        try {
            ka kaVar = (ka) recyclerView.ah(this.i);
            if (kaVar != null) {
                kaVar.cv();
            }
        } catch (Exception e) {
            sl.xr("cubic detached exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public void hi(int i) {
        boolean z;
        ms msVar;
        this.nw = i;
        if (i == 0) {
            View viewMs = this.y.ms(this);
            if (viewMs != null) {
                int iD = d(viewMs);
                z = this.i == iD;
                this.i = iD;
            } else {
                z = true;
            }
            if (this.b) {
                this.b = false;
                this.re = this.qv;
                if (!z && (msVar = this.w) != null) {
                    boolean z2 = this.t >= 0;
                    int i2 = this.i;
                    msVar.ms(z2, i2, i2 == cv() - 1);
                }
            }
        }
        if (i == 2) {
            this.b = true;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ka, com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public boolean d() {
        return this.re;
    }

    public void xr(boolean z) {
        this.qv = z;
        if (z || this.nw == 0) {
            this.re = z;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ka, com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int xr(int i, RecyclerView.ao aoVar, RecyclerView.t tVar) {
        this.t = i;
        return super.xr(i, aoVar, tVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.ka, com.bytedance.sdk.component.widget.recycler.RecyclerView.ny
    public int ms(int i, RecyclerView.ao aoVar, RecyclerView.t tVar) {
        this.t = i;
        return super.ms(i, aoVar, tVar);
    }

    public void ms(ms msVar) {
        this.w = msVar;
    }
}
