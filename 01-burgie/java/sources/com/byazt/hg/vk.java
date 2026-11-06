package com.byazt.hg;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 50})
public class vk {
    public String cz;
    public View g;
    public boolean ho;
    public View m;
    public String qa;
    public String rc;
    public float pr = -1.0f;
    public float hw = -1.0f;
    public float hn = -1.0f;
    public float x = -1.0f;
    public long c = -1;
    public long uc = -1;
    public int fw = -1;
    public int zo = -1;
    public int aj = -1024;
    public boolean vk = true;
    public int w = 0;
    public int k = 0;
    public byte nt = 0;
    public byte yb = -1;
    public boolean lb = false;
    public int a = -1;
    public SparseArray<com.byazt.az.x.pr> ny = new SparseArray<>();
    public List<Integer> fo = new ArrayList();
    public int z = -1;
    public boolean b = false;

    public void pr(boolean z) {
        this.b = z;
    }

    public boolean pr() {
        return this.b;
    }

    public void pr(byte b) {
        this.nt = b;
    }

    public byte hw() {
        return this.nt;
    }

    public byte hn() {
        return this.yb;
    }

    public void hw(byte b) {
        this.yb = b;
    }

    public boolean x() {
        return this.z == 2;
    }

    public void pr(int i) {
        this.z = i;
    }

    public int c() {
        return this.z;
    }

    public int uc() {
        return this.fw;
    }

    public void hw(int i) {
        this.fw = i;
    }

    public int fw() {
        return this.zo;
    }

    public void hn(int i) {
        this.zo = i;
    }

    public int zo() {
        return this.aj;
    }

    public void x(int i) {
        this.aj = i;
    }

    public boolean aj() {
        return this.vk;
    }

    public void hw(boolean z) {
        this.vk = z;
    }

    public View vk() {
        return this.m;
    }

    public void pr(View view) {
        this.m = (View) new WeakReference(view).get();
    }

    public View w() {
        return this.g;
    }

    public void hw(View view) {
        this.g = (View) new WeakReference(view).get();
    }

    public int k() {
        return this.w;
    }

    public void c(int i) {
        this.w = i;
    }

    public int m() {
        return this.k;
    }

    public void uc(int i) {
        this.k = i;
    }

    public SparseArray<com.byazt.az.x.pr> g() {
        return this.ny;
    }

    public void pr(SparseArray<com.byazt.az.x.pr> sparseArray) {
        this.ny = sparseArray;
    }

    public List<Integer> ho() {
        return this.fo;
    }

    public long nt() {
        return this.c;
    }

    public void pr(long j) {
        this.c = j;
    }

    public long yb() {
        return this.uc;
    }

    public void hw(long j) {
        this.uc = j;
    }

    public float lb() {
        return this.pr;
    }

    public void pr(float f) {
        this.pr = f;
    }

    public float qa() {
        return this.hw;
    }

    public void hw(float f) {
        this.hw = f;
    }

    public float a() {
        return this.hn;
    }

    public void hn(float f) {
        this.hn = f;
    }

    public float cz() {
        return this.x;
    }

    public void x(float f) {
        this.x = f;
    }

    public void hn(boolean z) {
        this.ho = z;
    }

    public void pr(String str) {
        this.qa = str;
    }

    public String ny() {
        return this.qa;
    }

    public void fw(int i) {
        this.a = i;
    }

    public int fo() {
        return this.a;
    }

    public String rc() {
        return this.cz;
    }

    public void hw(String str) {
        this.cz = str;
    }

    public void x(boolean z) {
        this.lb = z;
    }

    public String z() {
        return this.rc;
    }

    public void hn(String str) {
        this.rc = str;
    }
}
