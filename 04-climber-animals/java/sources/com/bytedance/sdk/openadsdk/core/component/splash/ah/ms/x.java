package com.bytedance.sdk.openadsdk.core.component.splash.ah.ms;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class x extends ms {
    private com.bytedance.sdk.openadsdk.ao.xr.xr.xr ao;
    private com.bytedance.sdk.component.ny.xr c;
    private long ch;
    private com.bytedance.sdk.openadsdk.core.re.ms.xr d;
    private String h;
    private long hi;
    private long ny;
    private long qv;
    private Map<String, String> sl;
    private boolean u;
    private boolean ub;
    private String zb;
    private boolean ka = false;
    private boolean ab = false;
    private boolean x = false;
    private AtomicBoolean y = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ms
    public int ms() {
        return this.f2375ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ms
    public void ms(int i) {
        this.f2375ms = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ms
    public lm xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ms
    public void ms(lm lmVar) {
        this.xr = lmVar;
    }

    public x(lm lmVar, boolean z) {
        this.xr = lmVar;
        this.u = z;
    }

    public x(com.bytedance.sdk.openadsdk.core.re.ms.xr xrVar, lm lmVar, boolean z) {
        this.d = xrVar;
        this.xr = lmVar;
        this.u = z;
    }

    public com.bytedance.sdk.openadsdk.core.re.ms.xr d() {
        return this.d;
    }

    public boolean ka() {
        return this.ka;
    }

    public void ms(boolean z) {
        this.ka = z;
    }

    public void ms(com.bytedance.sdk.component.ny.xr xrVar) {
        this.c = xrVar;
    }

    public boolean c() {
        return this.ab;
    }

    public void xr(boolean z) {
        this.ab = z;
    }

    public long ab() {
        return this.ny;
    }

    public void xr(long j) {
        this.ny = j;
    }

    public void ah(long j) {
        this.ch = j;
    }

    public long x() {
        return this.hi;
    }

    public void d(long j) {
        this.hi = j;
    }

    public Map<String, String> ny() {
        return this.sl;
    }

    public void ms(Map<String, String> map) {
        this.sl = map;
    }

    public boolean ch() {
        return this.x;
    }

    public void ah(boolean z) {
        this.x = z;
    }

    public void ms(String str) {
        this.zb = str;
    }

    public boolean hi() {
        return this.u;
    }

    public void d(boolean z) {
        this.ub = z;
    }

    public com.bytedance.sdk.openadsdk.ao.xr.xr.xr sl() {
        return this.ao;
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar) {
        this.ao = xrVar;
    }

    public String zb() {
        return this.h;
    }

    public void xr(String str) {
        this.h = str;
    }

    public long u() {
        return this.qv;
    }

    public void ka(long j) {
        this.qv = j;
    }

    public boolean ub() {
        return this.y.get();
    }

    public void ka(boolean z) {
        this.y.set(z);
    }
}
