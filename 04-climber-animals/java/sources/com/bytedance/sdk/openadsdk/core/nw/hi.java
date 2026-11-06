package com.bytedance.sdk.openadsdk.core.nw;

import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hi {
    private String b;
    private String h;
    private int re;
    private View u;
    private boolean ub;
    private String y;
    private View zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f3056ms = -1.0f;
    private float xr = -1.0f;
    private float ah = -1.0f;
    private float d = -1.0f;
    private long ka = -1;
    private long c = -1;
    private int ab = -1;
    private int x = -1;
    private int ny = -1024;
    private boolean ch = true;
    private int hi = 0;
    private int sl = 0;
    private boolean ao = false;
    private int qv = -1;
    private SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> t = new SparseArray<>();
    private List<Integer> nw = new ArrayList();

    public boolean ms() {
        return this.re == 2;
    }

    public void ms(int i) {
        this.re = i;
    }

    public int xr() {
        return this.ab;
    }

    public void xr(int i) {
        this.ab = i;
    }

    public int ah() {
        return this.x;
    }

    public void ah(int i) {
        this.x = i;
    }

    public int d() {
        return this.ny;
    }

    public void d(int i) {
        this.ny = i;
    }

    public boolean ka() {
        return this.ch;
    }

    public void ms(boolean z) {
        this.ch = z;
    }

    public View c() {
        return this.zb;
    }

    public void ms(View view) {
        this.zb = (View) new WeakReference(view).get();
    }

    public View ab() {
        return this.u;
    }

    public void xr(View view) {
        this.u = (View) new WeakReference(view).get();
    }

    public int x() {
        return this.hi;
    }

    public void ka(int i) {
        this.hi = i;
    }

    public int ny() {
        return this.sl;
    }

    public void c(int i) {
        this.sl = i;
    }

    public SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> ch() {
        return this.t;
    }

    public void ms(SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms> sparseArray) {
        this.t = sparseArray;
    }

    public List<Integer> hi() {
        return this.nw;
    }

    public long sl() {
        return this.ka;
    }

    public void ms(long j) {
        this.ka = j;
    }

    public long zb() {
        return this.c;
    }

    public void xr(long j) {
        this.c = j;
    }

    public float u() {
        return this.f3056ms;
    }

    public void ms(float f) {
        this.f3056ms = f;
    }

    public float ub() {
        return this.xr;
    }

    public void xr(float f) {
        this.xr = f;
    }

    public float ao() {
        return this.ah;
    }

    public void ah(float f) {
        this.ah = f;
    }

    public float h() {
        return this.d;
    }

    public void d(float f) {
        this.d = f;
    }

    public void xr(boolean z) {
        this.ub = z;
    }

    public void ms(String str) {
        this.h = str;
    }

    public String qv() {
        return this.h;
    }

    public void ab(int i) {
        this.qv = i;
    }

    public int y() {
        return this.qv;
    }

    public String t() {
        return this.y;
    }

    public void xr(String str) {
        this.y = str;
    }

    public boolean nw() {
        return this.ao;
    }

    public void ah(boolean z) {
        this.ao = z;
    }

    public String b() {
        return this.b;
    }

    public void ah(String str) {
        this.b = str;
    }
}
