package com.byazt.ln;

import android.view.View;
import com.byazt.hg.vk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 573, 20})
public class hn {
    public volatile int c;
    public vk hn;
    public View x;
    public final com.byazt.az.x zo;
    public List<pr> pr = new ArrayList();
    public Map<String, Object> hw = new HashMap();
    public volatile int uc = 0;
    public long fw = -1;

    public hn(com.byazt.az.x xVar) {
        this.zo = xVar;
    }

    public long pr() {
        return this.fw;
    }

    public void pr(View view) {
        this.x = view;
    }

    public void pr(pr prVar) {
        this.pr.add(prVar);
    }

    public void pr(vk vkVar) {
        this.hn = vkVar;
        Iterator<pr> it = this.pr.iterator();
        while (it.hasNext()) {
            it.next().pr(this.hn);
        }
    }

    private void hn() {
        this.c = 0;
        this.uc = 0;
    }

    public void hw() {
        this.fw = System.currentTimeMillis();
        ((com.byazt.yx.pr) this.zo.pr(com.byazt.yx.pr.class)).pr(false);
        hn();
        pr(0);
    }

    private void pr(int i) {
        int size = this.pr.size();
        while (i < size) {
            int i2 = i + 1;
            this.c = i2;
            pr prVar = this.pr.get(i);
            prVar.pr(this.x);
            this.uc = prVar.pr(this.hw, this);
            if (this.uc == 0) {
                i = i2;
            } else {
                if (this.uc == 2) {
                    ((com.byazt.yx.pr) this.zo.pr(com.byazt.yx.pr.class)).pr(this.hw, this);
                    return;
                }
                return;
            }
        }
    }

    public <T extends pr> T pr(Class<T> cls) {
        return (T) this.zo.pr(cls);
    }
}
