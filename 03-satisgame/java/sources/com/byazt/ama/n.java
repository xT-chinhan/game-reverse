package com.byazt.ama;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.PointerIconCompat;
import com.byazt.hb.fs;
import com.byazt.prf.RecyclerView;
import com.byazt.prf.l;
import com.byazt.prf.sz;
import com.byazt.prf.w;
import com.byazt.vh.rv;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_TEXT, 19})
public class n extends com.byazt.ih.n<RecyclerView> {
    public int bz;
    public boolean dm;
    public boolean ei;
    public final Map<String, rv.n> eq;
    public int il;
    public String la;
    public RecyclerView.oa lg;
    public float nk;
    public boolean o;
    public s ox;
    public JSONArray qh;
    public int qn;
    public int sq;
    public boolean ti;
    public boolean vo;
    public Runnable xd;
    public boolean ze;

    public n(Context context) {
        super(context);
        this.sq = 1;
        this.ei = false;
        this.dm = true;
        this.vo = true;
        this.o = false;
        this.nk = 50.0f;
        this.ze = true;
        this.qn = 1;
        this.bz = 0;
        this.il = 0;
        this.la = "grid";
        this.eq = new HashMap();
        this.ti = false;
    }

    @Override // com.byazt.ih.s
    public View n() {
        return new RecyclerView(this.qg);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "columnGap":
                this.bz = (int) fs.n(this.qg, n(str2, 0.0f));
                break;
            case "autoScrollSpeed":
                float fN = n(str2, 50.0f);
                this.nk = fs.n(this.qg, fN > 0.0f ? fN : 50.0f);
                break;
            case "bounce":
            case "bounces":
                this.dm = TextUtils.isEmpty(str2) || Boolean.parseBoolean(str2);
                break;
            case "scrollEnabled":
                this.vo = TextUtils.isEmpty(str2) || Boolean.parseBoolean(str2);
                break;
            case "direction":
                this.sq = !TextUtils.equals("horizontal", str2) ? 1 : 0;
                break;
            case "rowGap":
                this.il = (int) fs.n(this.qg, n(str2, 0.0f));
                break;
            case "autoScroll":
                this.o = Boolean.parseBoolean(str2);
                break;
            case "showScrollBar":
                this.ei = Boolean.parseBoolean(str2);
                break;
            case "stopOnInteraction":
                this.ze = TextUtils.isEmpty(str2) || Boolean.parseBoolean(str2);
                break;
            case "layoutMode":
                if (TextUtils.isEmpty(str2)) {
                    str2 = "grid";
                }
                this.la = str2;
                break;
            case "columns":
                this.qn = n(str2, 1);
                break;
            case "dataList":
                this.qh = com.byazt.hb.qg.n(str2, (JSONArray) null);
                break;
        }
    }

    private int n(String str, int i) {
        try {
            int i2 = Integer.parseInt(str);
            return i2 > 0 ? i2 : i;
        } catch (Throwable unused) {
        }
    }

    private float n(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (Throwable unused) {
            return f;
        }
    }

    @Override // com.byazt.ih.n
    public void n(com.byazt.ih.s sVar) {
        if (sVar == null || sVar.ur() == null) {
            return;
        }
        String strQg = sVar.ur().qg();
        if (TextUtils.isEmpty(strQg)) {
            return;
        }
        this.n.add(sVar);
        this.eq.put(strQg, sVar.ur());
    }

    @Override // com.byazt.ih.n
    public void n(com.byazt.ih.s sVar, ViewGroup.LayoutParams layoutParams) {
        n(sVar);
    }

    private List<com.byazt.mu.s> cx() {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = this.qh;
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("id", null);
                if (!TextUtils.isEmpty(strOptString) && this.eq.containsKey(strOptString)) {
                    arrayList.add(new com.byazt.mu.s(jSONObjectOptJSONObject, strOptString));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.ih.n, com.byazt.ih.s
    public void qg() {
        super.qg();
        if (this.ox != null) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) this.l;
        s sVar = new s(this.qg, this.rv);
        this.ox = sVar;
        sVar.n(this.ry);
        this.ox.n(this.ju);
        this.ox.n(this.eq);
        recyclerView.setLayoutManager(lq());
        recyclerView.setAdapter(this.ox);
        if (this.ei) {
            n(recyclerView);
        }
        recyclerView.setVerticalScrollBarEnabled(this.ei && this.sq == 1);
        recyclerView.setHorizontalScrollBarEnabled(this.ei && this.sq == 0);
        recyclerView.setLayoutFrozen(!this.vo);
        recyclerView.setOverScrollMode(this.dm ? 0 : 2);
        if (this.bz > 0 || this.il > 0) {
            recyclerView.n((RecyclerView.fs) new q(this.qn, this.sq, this.bz, this.il));
        }
        recyclerView.n((RecyclerView.sz) new qg() { // from class: com.byazt.ama.n.1
            @Override // com.byazt.ama.qg
            public void n() {
                n.this.n("loadMore", new Object[0]);
            }
        });
        this.ox.n(cx());
        if (this.o) {
            qg(recyclerView);
        }
    }

    private void n(RecyclerView recyclerView) {
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            typedArrayObtainStyledAttributes = this.qg.obtainStyledAttributes(new int[]{R.attr.scrollbars});
            Method declaredMethod = View.class.getDeclaredMethod("initializeScrollbars", TypedArray.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(recyclerView, typedArrayObtainStyledAttributes);
            recyclerView.setScrollbarFadingEnabled(true);
            if (typedArrayObtainStyledAttributes != null) {
                typedArrayObtainStyledAttributes.recycle();
            }
        } catch (Throwable th) {
            try {
                th.getMessage();
            } finally {
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        }
    }

    private void qg(final RecyclerView recyclerView) {
        if (this.ti) {
            return;
        }
        float f = this.nk;
        if (f <= 0.0f) {
            return;
        }
        this.ti = true;
        final int iMax = Math.max(1, Math.round((f * 16.0f) / 1000.0f));
        if (this.ze) {
            RecyclerView.oa oaVar = this.lg;
            if (oaVar != null) {
                recyclerView.qg(oaVar);
            }
            RecyclerView.um umVar = new RecyclerView.um() { // from class: com.byazt.ama.n.2
                @Override // com.byazt.prf.RecyclerView.um, com.byazt.prf.RecyclerView.oa
                public boolean n(RecyclerView recyclerView2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    n.this.s(recyclerView);
                    return false;
                }
            };
            this.lg = umVar;
            recyclerView.n((RecyclerView.oa) umVar);
        }
        Runnable runnable = new Runnable() { // from class: com.byazt.ama.n.3
            @Override // java.lang.Runnable
            public void run() {
                boolean zCanScrollVertically;
                if (n.this.ti) {
                    if (n.this.sq == 0) {
                        zCanScrollVertically = recyclerView.canScrollHorizontally(1);
                    } else {
                        zCanScrollVertically = recyclerView.canScrollVertically(1);
                    }
                    if (!zCanScrollVertically) {
                        n.this.s(recyclerView);
                        return;
                    }
                    if (n.this.sq == 0) {
                        recyclerView.scrollBy(iMax, 0);
                    } else {
                        recyclerView.scrollBy(0, iMax);
                    }
                    recyclerView.postDelayed(this, 16L);
                }
            }
        };
        this.xd = runnable;
        recyclerView.postDelayed(runnable, 16L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(RecyclerView recyclerView) {
        Runnable runnable;
        this.ti = false;
        if (recyclerView == null || (runnable = this.xd) == null) {
            return;
        }
        recyclerView.removeCallbacks(runnable);
    }

    private RecyclerView.rv lq() {
        if (this.qn <= 1) {
            return new w(this.qg, this.sq, false);
        }
        if (TextUtils.equals("waterfall", this.la)) {
            return new sz(this.qn, this.sq);
        }
        return new l(this.qg, this.qn, this.sq, false);
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void w() {
        super.w();
        if (this.l instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) this.l;
            s(recyclerView);
            RecyclerView.oa oaVar = this.lg;
            if (oaVar != null) {
                recyclerView.qg(oaVar);
                this.lg = null;
            }
            recyclerView.q();
        }
    }
}
