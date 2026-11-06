package com.byazt.mh;

import android.util.SparseArray;
import com.anythink.core.common.q.g;
import com.byazt.af.x;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1196, 8})
public class s implements com.byazt.zh.s {
    public String n;
    public Function<SparseArray<Object>, Object> qg;
    public String s;

    public s(String str) {
        this.n = str;
    }

    @Override // com.byazt.zh.s
    public Function<SparseArray<Object>, Object> n() {
        return l.qg(this.n);
    }

    @Override // com.byazt.zh.s
    public String qg() {
        return fs() + "_class_name";
    }

    @Override // com.byazt.zh.s
    public String s() {
        return fs() + "_adn_version";
    }

    @Override // com.byazt.zh.s
    public String q() {
        String str = this.n;
        str.hashCode();
        switch (str) {
            case "xiaomi":
                return com.byazt.zh.l.fs();
            case "ks":
                return com.byazt.zh.l.w();
            case "gdt":
                return com.byazt.zh.l.x();
            default:
                return null;
        }
    }

    @Override // com.byazt.zh.s
    public void n(Function<SparseArray<Object>, Object> function) {
        this.qg = function;
    }

    @Override // com.byazt.zh.s
    public Function<SparseArray<Object>, Object> l() {
        return this.qg;
    }

    @Override // com.byazt.zh.s
    public void n(String str) {
        this.s = str;
    }

    @Override // com.byazt.zh.s
    public String w() {
        return this.s;
    }

    @Override // com.byazt.zh.s
    public String x() {
        return this.n;
    }

    private String fs() {
        String str = this.n;
        str.hashCode();
        switch (str) {
            case "sigmob":
                return com.anythink.core.common.s.a;
            case "xiaomi":
                return x.n;
            case "ks":
                return "k";
            case "gdt":
                return g.a;
            case "baidu":
                return "b";
            case "unity":
                return "u";
            default:
                return null;
        }
    }
}
