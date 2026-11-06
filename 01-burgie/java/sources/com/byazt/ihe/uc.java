package com.byazt.ihe;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 588, 5})
public class uc implements c, Function {
    public volatile c hw;
    public volatile Function pr;

    public uc(c cVar) {
        this.hw = cVar;
    }

    public uc(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.ihe.c
    public int a() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public String aj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void aj(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Integer.valueOf(this.hw.pr());
            case 2:
                this.hw.pr(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 3:
                return Integer.valueOf(this.hw.hw());
            case 4:
                this.hw.hw(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 5:
                return Integer.valueOf(this.hw.hn());
            case 6:
                this.hw.hn(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 7:
                return Integer.valueOf(this.hw.x());
            case 8:
                this.hw.x(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 9:
                return Long.valueOf(this.hw.c());
            case 10:
                this.hw.pr(((Long) sparseArray.get(1)).longValue());
                return null;
            case 11:
                return Double.valueOf(this.hw.uc());
            case 12:
                this.hw.pr(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 13:
                return Double.valueOf(this.hw.fw());
            case 14:
                this.hw.hw(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 15:
                return Float.valueOf(this.hw.zo());
            case 16:
                this.hw.pr(((Float) sparseArray.get(1)).floatValue());
                return null;
            case 17:
                return this.hw.aj();
            case 18:
                this.hw.pr((String) sparseArray.get(1));
                return null;
            case 19:
                return this.hw.vk();
            case 20:
                return this.hw.w();
            case 21:
                this.hw.hw((String) sparseArray.get(1));
                return null;
            case 22:
                return this.hw.k();
            case 23:
                this.hw.hn((String) sparseArray.get(1));
                return null;
            case 24:
                return this.hw.m();
            case 25:
                this.hw.x((String) sparseArray.get(1));
                return null;
            case 26:
                return this.hw.g();
            case 27:
                this.hw.c((String) sparseArray.get(1));
                return null;
            case 28:
                return this.hw.ho();
            case 29:
                this.hw.uc((String) sparseArray.get(1));
                return null;
            case 30:
                return Integer.valueOf(this.hw.nt());
            case 31:
                this.hw.c(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 32:
                return Integer.valueOf(this.hw.yb());
            case 33:
                this.hw.uc(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 34:
                return Integer.valueOf(this.hw.lb());
            case 35:
                this.hw.fw(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 36:
                return this.hw.qa();
            case 37:
                return Integer.valueOf(this.hw.a());
            case 38:
                this.hw.zo(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 39:
                return Integer.valueOf(this.hw.cz());
            case 40:
                this.hw.aj(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 41:
                return Boolean.valueOf(this.hw.ny());
            case 42:
                return Boolean.valueOf(this.hw.fo());
            case 43:
                this.hw.vk(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 44:
                return Integer.valueOf(this.hw.rc());
            default:
                return null;
        }
    }

    @Override // com.byazt.ihe.c
    public long c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ihe.c
    public void c(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void c(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int cz() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public boolean fo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.c
    public double fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return ((Double) this.pr.apply(sparseArray)).doubleValue();
    }

    @Override // com.byazt.ihe.c
    public void fw(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public String g() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public void hn(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void hn(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public String ho() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public void hw(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Double.valueOf(d));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void hw(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void hw(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public String k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int lb() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public String m() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int nt() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public boolean ny() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.c
    public int pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public void pr(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Double.valueOf(d));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void pr(float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, Float.valueOf(f));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void pr(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void pr(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Long.valueOf(j));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void pr(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public JSONObject qa() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        return (JSONObject) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int rc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public double uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Double) this.pr.apply(sparseArray)).doubleValue();
    }

    @Override // com.byazt.ihe.c
    public void uc(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void uc(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void vk(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int[] vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return (int[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public String w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public void x(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public void x(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.c
    public int yb() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.c
    public float zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return ((Float) this.pr.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.ihe.c
    public void zo(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }
}
