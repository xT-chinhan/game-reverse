package com.byazt.fq;

import android.content.Context;
import com.byazt.gct.pk;
import com.byazt.mr.EmptyView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 569, 8})
public class s extends qg {
    public Double fs;
    public n l;
    public EmptyView rv;
    public String w;
    public Map<String, Object> x;

    public interface n {
        boolean n();
    }

    public void n(n nVar) {
        this.l = nVar;
    }

    public void n(String str) {
        this.w = str;
    }

    public void n(EmptyView emptyView) {
        this.rv = emptyView;
    }

    public void n(Map<String, Object> map) {
        Map<String, Object> map2 = this.x;
        if (map2 == null) {
            this.x = map;
        } else {
            map2.putAll(map);
        }
    }

    public void n(Double d) {
        this.fs = d;
    }

    public s() {
    }

    public s(pk pkVar, Context context) {
        this.n = pkVar;
        this.qg = context;
        this.x = new HashMap();
    }

    @Override // com.byazt.fq.qg, com.byazt.dj.n
    public int n(Map<String, Object> map, com.byazt.dj.s sVar) {
        n nVar;
        if (this.n == null || !this.n.rf() || (nVar = this.l) == null || nVar.n()) {
            return 0;
        }
        EmptyView emptyView = this.rv;
        if (emptyView == null) {
            com.byazt.nj.n.qg(this.n);
            this.x.put("show_send_type", 1);
            com.byazt.hm.n.n(this.n, this.w, this.x, this.fs);
        } else {
            emptyView.n("checkWhenClicked");
        }
        return 0;
    }
}
