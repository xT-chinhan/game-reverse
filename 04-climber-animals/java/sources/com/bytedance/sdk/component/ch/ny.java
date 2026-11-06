package com.bytedance.sdk.component.ch;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ny implements Comparable<ny>, Runnable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1226ms;
    private String xr;

    public ny(String str, int i) {
        this.f1226ms = 0;
        this.f1226ms = i == 0 ? 5 : i;
        this.xr = str;
    }

    public ny(String str) {
        this.f1226ms = 5;
        this.xr = str;
    }

    public void ms(int i) {
        this.f1226ms = i;
    }

    public int ms() {
        return this.f1226ms;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public int compareTo(ny nyVar) {
        if (ms() < nyVar.ms()) {
            return 1;
        }
        return ms() >= nyVar.ms() ? -1 : 0;
    }

    public String xr() {
        return this.xr;
    }
}
