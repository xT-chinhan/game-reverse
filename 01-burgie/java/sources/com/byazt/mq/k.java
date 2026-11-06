package com.byazt.mq;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 427, 250})
public class k implements vk.pr {
    public aj hn;
    public List<vk> hw;
    public ho pr;
    public AtomicBoolean x = new AtomicBoolean(false);

    public k(List<vk> list, aj ajVar) {
        this.hw = list;
        this.hn = ajVar;
    }

    @Override // com.byazt.mq.vk.pr
    public void pr() {
        this.hn.uc();
        Iterator<vk> it = this.hw.iterator();
        while (it.hasNext() && !it.next().pr(this)) {
        }
    }

    @Override // com.byazt.mq.vk.pr
    public void pr(vk vkVar) {
        int iIndexOf = this.hw.indexOf(vkVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.hw.size()) {
                return;
            }
        } while (!this.hw.get(iIndexOf).pr(this));
    }

    @Override // com.byazt.mq.vk.pr
    public boolean hw(vk vkVar) {
        int iIndexOf = this.hw.indexOf(vkVar);
        return iIndexOf < this.hw.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.byazt.mq.vk.pr
    public ho hw() {
        return this.pr;
    }

    @Override // com.byazt.mq.vk.pr
    public void pr(ho hoVar) {
        this.pr = hoVar;
    }

    @Override // com.byazt.mq.vk.pr
    public void pr(boolean z) {
        this.x.getAndSet(z);
    }

    @Override // com.byazt.mq.vk.pr
    public boolean hn() {
        return this.x.get();
    }
}
