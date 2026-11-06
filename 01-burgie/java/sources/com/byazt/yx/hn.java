package com.byazt.yx;

import android.content.Context;
import com.byazt.hg.of;
import com.byazt.sd.EmptyView;
import com.byazt.sd.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2286, 20})
public class hn extends hw {
    public EmptyView aj;
    public pr c;
    public Map<String, Object> fw;
    public String uc;
    public Double zo;

    public interface pr {
        boolean pr();
    }

    public void pr(pr prVar) {
        this.c = prVar;
    }

    public void pr(String str) {
        this.uc = str;
    }

    public void pr(EmptyView emptyView) {
        this.aj = emptyView;
    }

    public void pr(Map<String, Object> map) {
        Map<String, Object> map2 = this.fw;
        if (map2 == null) {
            this.fw = map;
        } else {
            map2.putAll(map);
        }
    }

    public void pr(Double d) {
        this.zo = d;
    }

    public hn() {
    }

    public hn(of ofVar, Context context) {
        this.pr = ofVar;
        this.hw = context;
        this.fw = new HashMap();
    }

    @Override // com.byazt.yx.hw, com.byazt.ln.pr
    public int pr(Map<String, Object> map, com.byazt.ln.hn hnVar) {
        pr prVar;
        if (!a.hw().hv() || (prVar = this.c) == null || prVar.pr()) {
            return 0;
        }
        EmptyView emptyView = this.aj;
        if (emptyView == null) {
            this.fw.put("show_send_type", 1);
            com.byazt.pj.pr.pr(this.pr, this.uc, this.fw, this.zo);
        } else {
            emptyView.pr("checkWhenClicked");
        }
        return 0;
    }
}
