package com.bytedance.sdk.openadsdk.core.ugeno.component.xr;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.ah.x;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bytedance.adsdk.ugeno.xr.ms<RecyclerView> {
    private ka.ah cc;
    private List<ah> gs;
    private Map<Integer, x.ms> kl;
    private ka nl;
    private d qo;
    private xr r;
    private RecyclerView.ny vf;

    public interface xr {
        void ms();

        void ms(int i, int i2);

        void ms(int i, View view, ah ahVar);

        void ms(RecyclerView recyclerView, int i);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(ViewGroup.LayoutParams layoutParams) {
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public com.bytedance.adsdk.ugeno.xr.ms.C0201ms x() {
        return null;
    }

    public c(Context context) {
        super(context);
        this.kl = new HashMap();
    }

    public void ms(d dVar) {
        this.qo = dVar;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public View ms() {
        return new RecyclerView(this.xr);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        ka kaVar = new ka(this.xr);
        this.nl = kaVar;
        kaVar.ms(this.zd);
        this.nl.ms(this.z);
        this.nl.ms(this.tk);
        this.nl.ms(this.qo);
        this.nl.ms(this.cc);
        this.nl.ms(this.kl);
        this.nl.ms(this.gs);
        ((RecyclerView) this.ka).setLayoutManager(this.vf);
        ((RecyclerView) this.ka).setAdapter(this.nl);
        ((RecyclerView) this.ka).ms((RecyclerView.x) new ms((int) com.bytedance.adsdk.ugeno.c.x.ms(this.xr, 10.0f)));
        ((RecyclerView) this.ka).ms((RecyclerView.u) new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.xr(new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ms()) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.xr
            public void ms(int i, int i2) {
                if (c.this.r != null) {
                    c.this.r.ms(i, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.xr
            public void ms(int i, View view) {
                if (c.this.r == null || i < 0 || c.this.gs == null || i >= c.this.gs.size()) {
                    return;
                }
                c.this.r.ms(i, view, (ah) c.this.gs.get(i));
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.xr
            public void xr(RecyclerView recyclerView, int i) {
                if (c.this.r != null) {
                    c.this.r.ms(recyclerView, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.xr
            public void ms() {
                if (c.this.r != null) {
                    c.this.r.ms();
                }
            }
        });
    }

    public void ms(xr xrVar) {
        this.r = xrVar;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(JSONObject jSONObject) {
        super.ms(jSONObject);
    }

    public void ms(List<ah> list) {
        this.gs = list;
    }

    public void xr(List<ah> list) {
        if (this.nl == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.gs == null) {
            this.gs = new ArrayList();
        }
        int size = this.gs.size();
        this.gs.addAll(list);
        this.nl.ms(list);
        this.nl.ms(size, this.gs.size());
    }

    public void ms(int i, Object obj) {
        ka kaVar = this.nl;
        if (kaVar != null) {
            kaVar.ms(obj);
            this.nl.ms(i, obj);
        }
    }

    public void ms(ka.d dVar) {
        this.nl.ms(dVar);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        if (ahVar == null) {
            return;
        }
        this.f438ms.add(ahVar);
        if (ahVar.of() != null) {
            this.kl.put(Integer.valueOf(ahVar.of().hashCode()), ahVar.le());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        if (str.equals("layoutType") && !TextUtils.equals("grid", str2)) {
            this.vf = new com.bytedance.sdk.component.widget.recycler.ka(this.xr);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, ViewGroup.LayoutParams layoutParams) {
        this.f438ms.add(ahVar);
        this.kl.put(Integer.valueOf(ahVar.of().hashCode()), ahVar.le());
    }

    private static class ms extends RecyclerView.x implements ka.ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f3488ms;

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.ms
        public void K_() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.ms
        public void L_() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.ms
        public View ah() {
            return null;
        }

        public ms(int i) {
            this.f3488ms = i;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.x
        public void ms(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
            super.ms(rect, view, recyclerView, tVar);
            rect.left = this.f3488ms;
            rect.right = this.f3488ms;
            rect.bottom = this.f3488ms;
            if (recyclerView.c(view) == 0) {
                rect.top = this.f3488ms;
            }
        }
    }
}
