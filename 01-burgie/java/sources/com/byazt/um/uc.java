package com.byazt.um;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aa.zo;
import com.byazt.ch.aj;
import com.byazt.hr.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1296, 5})
public class uc extends com.byazt.ik.pr<RecyclerView> {
    public Map<Integer, aj.pr> fe;
    public List<hn> ks;
    public c.hn p;
    public RecyclerView.aj qx;
    public hw sr;
    public c wz;
    public x xb;

    public interface hw {
        void pr();

        void pr(int i, int i2);

        void pr(int i, View view, hn hnVar);

        void pr(RecyclerView recyclerView, int i);
    }

    public uc(Context context) {
        super(context);
        this.fe = new HashMap();
    }

    public void pr(x xVar) {
        this.xb = xVar;
    }

    @Override // com.byazt.ik.hn
    public View pr() {
        return new RecyclerView(this.hw);
    }

    @Override // com.byazt.ik.pr, com.byazt.ik.hn
    public void hw() {
        super.hw();
        c cVar = new c(this.hw);
        this.wz = cVar;
        cVar.pr(this.qv);
        this.wz.pr(this.u);
        this.wz.pr(this.np);
        this.wz.pr(this.xb);
        this.wz.pr(this.p);
        this.wz.pr(this.fe);
        this.wz.pr(this.ks);
        ((RecyclerView) this.c).setLayoutManager(this.qx);
        ((RecyclerView) this.c).setAdapter(this.wz);
        ((RecyclerView) this.c).pr((RecyclerView.zo) new pr((int) zo.pr(this.hw, 10.0f)));
        ((RecyclerView) this.c).pr((RecyclerView.g) new com.byazt.um.hw(new com.byazt.um.pr()) { // from class: com.byazt.um.uc.1
            @Override // com.byazt.um.hw
            public void pr(int i, int i2) {
                if (uc.this.sr != null) {
                    uc.this.sr.pr(i, i2);
                }
            }

            @Override // com.byazt.um.hw
            public void pr(int i, View view) {
                if (uc.this.sr != null && i >= 0 && uc.this.ks != null && i < uc.this.ks.size()) {
                    uc.this.sr.pr(i, view, (hn) uc.this.ks.get(i));
                }
            }

            @Override // com.byazt.um.hw
            public void hw(RecyclerView recyclerView, int i) {
                if (uc.this.sr != null) {
                    uc.this.sr.pr(recyclerView, i);
                }
            }

            @Override // com.byazt.um.hw
            public void pr() {
                if (uc.this.sr != null) {
                    uc.this.sr.pr();
                }
            }
        });
    }

    public void pr(hw hwVar) {
        this.sr = hwVar;
    }

    @Override // com.byazt.ik.hn
    public void pr(JSONObject jSONObject) {
        super.pr(jSONObject);
    }

    public void pr(List<hn> list) {
        this.ks = list;
    }

    public void hw(List<hn> list) {
        if (this.wz == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.ks == null) {
            this.ks = new ArrayList();
        }
        int size = this.ks.size();
        this.ks.addAll(list);
        this.wz.pr(list);
        this.wz.pr(size, this.ks.size());
    }

    public void pr(int i, Object obj) {
        c cVar = this.wz;
        if (cVar != null) {
            cVar.pr(obj);
            this.wz.pr(i, obj);
        }
    }

    public void pr(c.x xVar) {
        this.wz.pr(xVar);
    }

    @Override // com.byazt.ik.pr
    public void pr(com.byazt.ik.hn hnVar) {
        if (hnVar == null) {
            return;
        }
        this.pr.add(hnVar);
        if (hnVar.ww() != null) {
            this.fe.put(Integer.valueOf(hnVar.ww().hashCode()), hnVar.ve());
        }
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "layoutType":
                if (!TextUtils.equals("grid", str2)) {
                    this.qx = new com.byazt.hr.c(this.hw);
                    break;
                }
                break;
        }
    }

    @Override // com.byazt.ik.pr
    public com.byazt.ik.pr.C0097pr zo() {
        return null;
    }

    @Override // com.byazt.ik.hn
    public void pr(ViewGroup.LayoutParams layoutParams) {
    }

    @Override // com.byazt.ik.pr
    public void pr(com.byazt.ik.hn hnVar, ViewGroup.LayoutParams layoutParams) {
        this.pr.add(hnVar);
        this.fe.put(Integer.valueOf(hnVar.ww().hashCode()), hnVar.ve());
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1296, 129})
    private static class pr extends RecyclerView.zo implements c.pr {
        public int pr;

        public pr(int i) {
            this.pr = i;
        }

        @Override // com.byazt.hr.RecyclerView.zo
        public void pr(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a aVar) {
            super.pr(rect, view, recyclerView, aVar);
            rect.left = this.pr;
            rect.right = this.pr;
            rect.bottom = this.pr;
            if (recyclerView.uc(view) == 0) {
                rect.top = this.pr;
            }
        }

        @Override // com.byazt.um.c.pr
        public void V_() {
        }

        @Override // com.byazt.um.c.pr
        public void W_() {
        }

        @Override // com.byazt.um.c.pr
        public View hn() {
            return null;
        }
    }
}
