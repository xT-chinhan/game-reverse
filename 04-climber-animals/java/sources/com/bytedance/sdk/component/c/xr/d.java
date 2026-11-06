package com.bytedance.sdk.component.c.xr;

import com.bytedance.sdk.component.c.ab;
import com.bytedance.sdk.component.c.c;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d<T> implements c {
    private T ah;
    private String d;
    private ab ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Map<String, String> f1194ms;
    private int xr;

    public d(int i, T t, String str) {
        this.xr = i;
        this.ah = t;
        this.d = str;
    }

    public d(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.f1194ms = map;
    }

    @Override // com.bytedance.sdk.component.c.c
    public ab ms() {
        return this.ka;
    }

    public void ms(ab abVar) {
        this.ka = abVar;
    }

    @Override // com.bytedance.sdk.component.c.c
    public int xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.c.c
    public T ah() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.c.c
    public String d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.c.c
    public Map<String, String> ka() {
        return this.f1194ms;
    }
}
