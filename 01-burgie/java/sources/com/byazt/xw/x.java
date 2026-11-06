package com.byazt.xw;

import com.byazt.ld.fw;
import com.byazt.ld.zo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1525, 121})
public class x<T> implements fw {
    public zo c;
    public T hn;
    public int hw;
    public Map<String, String> pr;
    public String x;

    public x(int i, T t, String str) {
        this.hw = i;
        this.hn = t;
        this.x = str;
    }

    public x(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.pr = map;
    }

    @Override // com.byazt.ld.fw
    public zo pr() {
        return this.c;
    }

    public void pr(zo zoVar) {
        this.c = zoVar;
    }

    @Override // com.byazt.ld.fw
    public int hw() {
        return this.hw;
    }

    @Override // com.byazt.ld.fw
    public T hn() {
        return this.hn;
    }

    @Override // com.byazt.ld.fw
    public String x() {
        return this.x;
    }

    @Override // com.byazt.ld.fw
    public Map<String, String> c() {
        return this.pr;
    }
}
