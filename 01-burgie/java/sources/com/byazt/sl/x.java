package com.byazt.sl;

import com.byazt.ld.nt;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 4, 121})
public class x<T> implements nt {
    public boolean aj;
    public int c;
    public Map<String, String> fw;
    public T hn;
    public String hw;
    public String pr;
    public int uc;
    public com.byazt.ld.zo vk;
    public int w;
    public T x;
    public boolean zo;

    public x pr(hn hnVar, T t) {
        this.hn = t;
        this.pr = hnVar.fw();
        this.hw = hnVar.hw();
        this.c = hnVar.hn();
        this.uc = hnVar.x();
        this.aj = hnVar.nt();
        this.vk = hnVar.lb();
        this.w = hnVar.qa();
        return this;
    }

    public x pr(hn hnVar, T t, Map<String, String> map, boolean z) {
        this.fw = map;
        this.zo = z;
        return pr(hnVar, t);
    }

    @Override // com.byazt.ld.nt
    public String pr() {
        return this.pr;
    }

    @Override // com.byazt.ld.nt
    public String hw() {
        return this.hw;
    }

    @Override // com.byazt.ld.nt
    public T hn() {
        return this.hn;
    }

    @Override // com.byazt.ld.nt
    public T x() {
        return this.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.ld.nt
    public void setResult(Object obj) {
        this.x = this.hn;
        this.hn = obj;
    }

    @Override // com.byazt.ld.nt
    public int c() {
        return this.c;
    }

    @Override // com.byazt.ld.nt
    public int uc() {
        return this.uc;
    }

    @Override // com.byazt.ld.nt
    public Map<String, String> fw() {
        return this.fw;
    }

    @Override // com.byazt.ld.nt
    public boolean zo() {
        return this.zo;
    }

    @Override // com.byazt.ld.nt
    public boolean aj() {
        return this.aj;
    }

    @Override // com.byazt.ld.nt
    public com.byazt.ld.zo vk() {
        return this.vk;
    }

    @Override // com.byazt.ld.nt
    public int w() {
        return this.w;
    }
}
