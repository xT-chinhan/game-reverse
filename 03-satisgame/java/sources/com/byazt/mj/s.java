package com.byazt.mj;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1480, 8})
public class s {
    public final Map<String, String> cd = new HashMap();
    public String cp;
    public String cy;
    public String d;
    public String fs;
    public String hd;
    public String k;
    public String l;
    public int n;
    public String oa;
    public String q;
    public String qg;
    public String rv;
    public String s;
    public String sz;
    public String tj;
    public String w;
    public int x;

    public void n(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.cd.clear();
        this.cd.putAll(map);
    }

    public Map<String, String> n() {
        return this.cd;
    }

    public String qg() {
        return this.tj;
    }

    public void n(String str) {
        this.tj = str;
    }

    public String s() {
        return this.cp;
    }

    public void qg(String str) {
        this.cp = str;
    }

    public String q() {
        return this.d;
    }

    public void s(String str) {
        this.d = str;
    }

    public String l() {
        return this.oa;
    }

    public void q(String str) {
        this.oa = str;
    }

    public String w() {
        return this.sz;
    }

    public void l(String str) {
        this.sz = str;
    }

    public String x() {
        return this.k;
    }

    public void w(String str) {
        this.k = str;
    }

    public String fs() {
        return this.cy;
    }

    public void x(String str) {
        this.cy = str;
    }

    public String rv() {
        return this.qg;
    }

    public void fs(String str) {
        this.qg = str;
    }

    public String tj() {
        return this.s;
    }

    public void rv(String str) {
        this.s = str;
    }

    public void n(int i) {
        this.n = i;
    }

    public String cp() {
        return this.q;
    }

    public void tj(String str) {
        this.q = str;
    }

    public String d() {
        return TextUtils.isEmpty(this.s) ? this.qg : this.s;
    }

    public String oa() {
        return this.w;
    }

    public void cp(String str) {
        this.w = str;
    }

    public void d(String str) {
        this.hd = str;
    }

    public String sz() {
        return this.hd;
    }

    public String k() {
        return this.l;
    }

    public void oa(String str) {
        this.l = str;
    }

    public int cy() {
        return this.x;
    }

    public void qg(int i) {
        this.x = i;
    }

    public String hd() {
        return this.fs;
    }

    public void sz(String str) {
        this.fs = str;
    }

    public String cd() {
        return this.rv;
    }

    public void k(String str) {
        this.rv = str;
    }

    public String toString() {
        return "{mSdkNum='" + this.n + "', mSlotId='" + this.q + "', mLevelTag='" + this.l + "', mEcpm=" + this.w + ", mReqBiddingType=" + this.x + "', mRequestId=" + this.rv + ", mSubRitType=" + this.cp + AbstractJsonLexerKt.END_OBJ;
    }
}
