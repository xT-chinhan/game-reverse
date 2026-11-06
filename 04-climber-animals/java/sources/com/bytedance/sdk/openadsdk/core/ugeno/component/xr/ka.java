package com.bytedance.sdk.openadsdk.core.ugeno.component.xr;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.ah.ao;
import com.bytedance.adsdk.ugeno.ah.ny;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.x;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends RecyclerView.ms<RecyclerView.re> {
    private d ab;
    private Context ah;
    private Object c;
    private ub ch;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.xr.d d;
    private ao hi;
    private ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> f3489ms;
    private ny ny;
    private boolean x = true;
    private Map<Integer, x.ms> xr;

    public interface ah {
    }

    public interface d {
        void ms(RecyclerView.re reVar, int i);
    }

    public interface ms {
        void K_();

        void L_();

        View ah();
    }

    public ka(Context context) {
        this.ah = context;
    }

    public void ms(Map<Integer, x.ms> map) {
        this.xr = map;
    }

    public void ms(List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> list) {
        if (this.f3489ms == null) {
            this.f3489ms = new ArrayList();
        }
        this.f3489ms.addAll(list);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.component.xr.d dVar) {
        this.d = dVar;
    }

    public void ms(ny nyVar) {
        this.ny = nyVar;
    }

    public void ms(ub ubVar) {
        this.ch = ubVar;
    }

    public void ms(ao aoVar) {
        this.hi = aoVar;
    }

    public void ms(ah ahVar) {
        this.ka = ahVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public RecyclerView.re ms(ViewGroup viewGroup, int i) {
        x.ms msVar = this.xr.get(Integer.valueOf(i));
        sl slVar = new sl(this.ah);
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarMs = slVar.ms(msVar);
        slVar.ms(ahVarMs);
        if (ahVarMs != null) {
            ahVarMs.ms(new ViewGroup.LayoutParams(ahVarMs.pc(), ahVarMs.jw()));
            C0319ka c0319ka = new C0319ka(ahVarMs.ny());
            c0319ka.ms((com.bytedance.adsdk.ugeno.xr.ah) ahVarMs);
            c0319ka.ms(slVar);
            return c0319ka;
        }
        return new xr(new View(this.ah));
    }

    public void ms(d dVar) {
        this.ab = dVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public int ms(int i) {
        return this.f3489ms.get(i).xr();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public void ms(RecyclerView.re reVar, int i, List<Object> list) {
        d dVar;
        if (list == null || list.isEmpty()) {
            ms(reVar, i);
            return;
        }
        for (Object obj : list) {
            if (obj != null && this.c != null && TextUtils.equals(obj.toString(), this.c.toString()) && (dVar = this.ab) != null) {
                dVar.ms(reVar, i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public void ms(RecyclerView.re reVar, int i) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah ahVar;
        com.bytedance.sdk.openadsdk.core.ugeno.component.xr.d dVar;
        if (reVar == null || (ahVar = this.f3489ms.get(i)) == null || !(reVar instanceof C0319ka)) {
            return;
        }
        JSONObject jSONObjectMs = ahVar.ms();
        C0319ka c0319ka = (C0319ka) reVar;
        c0319ka.h.ms(new ViewGroup.LayoutParams(c0319ka.h.pc(), c0319ka.h.jw()));
        ms(jSONObjectMs, c0319ka.op());
        ms(this.ah, jSONObjectMs, c0319ka.op());
        if (i == 0 && (dVar = this.d) != null && this.x) {
            this.x = false;
            dVar.ms(c0319ka.h);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ms
    public int ms() {
        return this.f3489ms.size();
    }

    public void ms(Object obj) {
        this.c = obj;
    }

    public class xr extends RecyclerView.re {
        public xr(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka$ka, reason: collision with other inner class name */
    public class C0319ka extends RecyclerView.re implements ms {
        com.bytedance.adsdk.ugeno.xr.ah h;
        sl qv;

        C0319ka(View view) {
            super(view);
        }

        public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
            this.h = ahVar;
        }

        public void ms(sl slVar) {
            this.qv = slVar;
        }

        public com.bytedance.adsdk.ugeno.xr.ah op() {
            return this.h;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.ms
        public void K_() {
            if (ka.this.d != null) {
                ka.this.d.xr(this.h);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.ms
        public void L_() {
            if (ka.this.d != null) {
                ka.this.d.ms(this.h);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.ms
        public View ah() {
            return this.h.ny();
        }
    }

    public void ms(JSONObject jSONObject, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        if (ahVar == null) {
            return;
        }
        if (ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) {
            ahVar.ms(jSONObject);
            List<com.bytedance.adsdk.ugeno.xr.ah<View>> listAb = ((com.bytedance.adsdk.ugeno.xr.ms) ahVar).ab();
            if (listAb == null || listAb.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.xr.ah<View>> it = listAb.iterator();
            while (it.hasNext()) {
                ms(jSONObject, it.next());
            }
            return;
        }
        ahVar.ms(jSONObject);
    }

    public void ms(Context context, JSONObject jSONObject, com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        if (ahVar == null) {
            return;
        }
        if (ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) {
            ahVar.ms(this.ny);
            ahVar.ms(this.ch);
            ahVar.xr(true);
            ahVar.xr();
            List<com.bytedance.adsdk.ugeno.xr.ah<View>> listAb = ((com.bytedance.adsdk.ugeno.xr.ms) ahVar).ab();
            if (listAb == null || listAb.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.xr.ah<View>> it = listAb.iterator();
            while (it.hasNext()) {
                ms(context, jSONObject, it.next());
            }
            return;
        }
        JSONObject jSONObjectRe = ahVar.re();
        Iterator<String> itKeys = jSONObjectRe.keys();
        com.bytedance.adsdk.ugeno.xr.ms msVarG = ahVar.g();
        com.bytedance.adsdk.ugeno.xr.ms.C0201ms c0201msX = msVarG != null ? msVarG.x() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectRe.optString(next), jSONObject);
            ahVar.ms(next, strMs);
            ahVar.ms(this.ny);
            ahVar.ms(this.ch);
            if (c0201msX != null) {
                c0201msX.ms(context, next, strMs);
            }
        }
        ahVar.xr(true);
        ahVar.xr();
    }
}
