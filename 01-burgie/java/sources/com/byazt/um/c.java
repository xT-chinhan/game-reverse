package com.byazt.um;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.ch.a;
import com.byazt.ch.aj;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.vk;
import com.byazt.hr.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1296, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends RecyclerView.pr<RecyclerView.fo> {
    public vk aj;
    public hn c;
    public x fw;
    public Context hn;
    public Map<Integer, aj.pr> hw;
    public List<com.byazt.um.hn> pr;
    public Object uc;
    public lb vk;
    public a w;
    public com.byazt.um.x x;
    public boolean zo = true;

    public interface hn {
    }

    public interface pr {
        void V_();

        void W_();

        View hn();
    }

    public interface x {
        void pr(RecyclerView.fo foVar, int i);
    }

    public c(Context context) {
        this.hn = context;
    }

    public void pr(Map<Integer, aj.pr> map) {
        this.hw = map;
    }

    public void pr(List<com.byazt.um.hn> list) {
        if (this.pr == null) {
            this.pr = new ArrayList();
        }
        this.pr.addAll(list);
    }

    public void pr(com.byazt.um.x xVar) {
        this.x = xVar;
    }

    public void pr(vk vkVar) {
        this.aj = vkVar;
    }

    public void pr(lb lbVar) {
        this.vk = lbVar;
    }

    public void pr(a aVar) {
        this.w = aVar;
    }

    public void pr(hn hnVar) {
        this.c = hnVar;
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public RecyclerView.fo pr(ViewGroup viewGroup, int i) {
        aj.pr prVar = this.hw.get(Integer.valueOf(i));
        ho hoVar = new ho(this.hn);
        com.byazt.ik.hn<View> hnVarPr = hoVar.pr(prVar);
        hoVar.pr(hnVarPr);
        if (hnVarPr != null) {
            hnVarPr.pr(new ViewGroup.LayoutParams(hnVarPr.e(), hnVarPr.s()));
            C0210c c0210c = new C0210c(hnVarPr.aj());
            c0210c.pr((com.byazt.ik.hn) hnVarPr);
            c0210c.pr(hoVar);
            return c0210c;
        }
        return new hw(new View(this.hn));
    }

    public void pr(x xVar) {
        this.fw = xVar;
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public int pr(int i) {
        return this.pr.get(i).hw();
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public void pr(RecyclerView.fo foVar, int i, List<Object> list) {
        x xVar;
        if (list == null || list.isEmpty()) {
            pr(foVar, i);
            return;
        }
        for (Object obj : list) {
            if (obj != null && this.uc != null && TextUtils.equals(obj.toString(), this.uc.toString()) && (xVar = this.fw) != null) {
                xVar.pr(foVar, i);
            }
        }
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public void pr(RecyclerView.fo foVar, int i) {
        com.byazt.um.hn hnVar;
        com.byazt.um.x xVar;
        if (foVar == null || (hnVar = this.pr.get(i)) == null || !(foVar instanceof C0210c)) {
            return;
        }
        JSONObject jSONObjectPr = hnVar.pr();
        C0210c c0210c = (C0210c) foVar;
        c0210c.yb.pr(new ViewGroup.LayoutParams(c0210c.yb.e(), c0210c.yb.s()));
        pr(jSONObjectPr, c0210c.iu());
        pr(this.hn, jSONObjectPr, c0210c.iu());
        if (i == 0 && (xVar = this.x) != null && this.zo) {
            this.zo = false;
            xVar.pr(c0210c.yb);
        }
    }

    @Override // com.byazt.hr.RecyclerView.pr
    public int pr() {
        return this.pr.size();
    }

    public void pr(Object obj) {
        this.uc = obj;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1296, 401})
    public class hw extends RecyclerView.fo {
        public hw(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: com.byazt.um.c$c, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1296, 1548})
    public class C0210c extends RecyclerView.fo implements pr {
        public ho lb;
        public com.byazt.ik.hn yb;

        public C0210c(View view) {
            super(view);
        }

        public void pr(com.byazt.ik.hn hnVar) {
            this.yb = hnVar;
        }

        public void pr(ho hoVar) {
            this.lb = hoVar;
        }

        public com.byazt.ik.hn iu() {
            return this.yb;
        }

        @Override // com.byazt.um.c.pr
        public void V_() {
            if (c.this.x != null) {
                c.this.x.hw(this.yb);
            }
        }

        @Override // com.byazt.um.c.pr
        public void W_() {
            if (c.this.x != null) {
                c.this.x.pr(this.yb);
            }
        }

        @Override // com.byazt.um.c.pr
        public View hn() {
            return this.yb.aj();
        }
    }

    public void pr(JSONObject jSONObject, com.byazt.ik.hn hnVar) {
        if (hnVar == null) {
            return;
        }
        if (hnVar instanceof com.byazt.ik.pr) {
            hnVar.pr(jSONObject);
            List<com.byazt.ik.hn<View>> listFw = ((com.byazt.ik.pr) hnVar).fw();
            if (listFw == null || listFw.size() <= 0) {
                return;
            }
            Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
            while (it.hasNext()) {
                pr(jSONObject, it.next());
            }
            return;
        }
        hnVar.pr(jSONObject);
    }

    public void pr(Context context, JSONObject jSONObject, com.byazt.ik.hn hnVar) {
        if (hnVar == null) {
            return;
        }
        if (hnVar instanceof com.byazt.ik.pr) {
            hnVar.pr(this.aj);
            hnVar.pr(this.vk);
            hnVar.hw(true);
            hnVar.hw();
            List<com.byazt.ik.hn<View>> listFw = ((com.byazt.ik.pr) hnVar).fw();
            if (listFw == null || listFw.size() <= 0) {
                return;
            }
            Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
            while (it.hasNext()) {
                pr(context, jSONObject, it.next());
            }
            return;
        }
        JSONObject jSONObjectRc = hnVar.rc();
        Iterator<String> itKeys = jSONObjectRc.keys();
        com.byazt.ik.pr prVarY = hnVar.y();
        com.byazt.ik.pr.C0097pr c0097prZo = null;
        if (prVarY != null) {
            c0097prZo = prVarY.zo();
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPr = com.byazt.tn.hw.pr(jSONObjectRc.optString(next), jSONObject);
            hnVar.pr(next, strPr);
            hnVar.pr(this.aj);
            hnVar.pr(this.vk);
            if (c0097prZo != null) {
                c0097prZo.pr(context, next, strPr);
            }
        }
        hnVar.hw(true);
        hnVar.hw();
    }
}
