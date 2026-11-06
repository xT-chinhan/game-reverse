package com.bytedance.sdk.component.c.ah;

import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d<T> implements hi {
    private Map<String, String> ab;
    private T ah;
    private int c;
    private com.bytedance.sdk.component.c.ab ch;
    private T d;
    private int hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1162ms;
    private boolean ny;
    private boolean x;
    private String xr;

    public d ms(ah ahVar, T t) {
        this.ah = t;
        this.f1162ms = ahVar.ab();
        this.xr = ahVar.xr();
        this.ka = ahVar.ah();
        this.c = ahVar.d();
        this.ny = ahVar.ao();
        this.ch = ahVar.h();
        this.hi = ahVar.qv();
        return this;
    }

    public d ms(ah ahVar, T t, Map<String, String> map, boolean z) {
        this.ab = map;
        this.x = z;
        return ms(ahVar, t);
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(1)
    public String ms() {
        return this.f1162ms;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(2)
    public String xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(3)
    public T ah() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(4)
    public T d() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(5)
    public void setResult(Object obj) {
        this.d = this.ah;
        this.ah = obj;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(6)
    public int ka() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(7)
    public int c() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(8)
    public Map<String, String> ab() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(9)
    public boolean x() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(10)
    public boolean ny() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(11)
    public com.bytedance.sdk.component.c.ab ch() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.component.c.hi
    @ATSMethod(12)
    public int hi() {
        return this.hi;
    }
}
