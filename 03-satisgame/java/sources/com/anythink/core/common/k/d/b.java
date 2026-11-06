package com.anythink.core.common.k.d;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.bridge.IATBaseAdAdapter;
import com.anythink.core.common.k;
import com.anythink.core.common.u.p;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final int a = -1;
    private Map<String, Object> b;
    private Map<String, Object> c;
    private int d;
    private int e;
    private int f;
    private String g;
    private IATBaseAdAdapter h;
    private int i;

    public b(Map<String, Object> map) {
        this.i = 0;
        this.b = map;
        this.d = p.a(map, ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, -1);
        this.e = p.a(map, "ad_type", -1);
        this.f = p.a(map, k.aI, 1);
        this.g = p.a(map, k.aJ, "");
        this.i = p.a(map, "render_type", 0);
    }

    public final <T> T a(String str, T t) {
        return (T) p.a(this.b, str, t);
    }

    public final Map<String, Object> a() {
        return this.b;
    }

    public final int b() {
        return this.e;
    }

    private void a(int i) {
        this.e = i;
    }

    public final int c() {
        return this.f;
    }

    private void b(int i) {
        this.f = i;
    }

    public final String d() {
        return this.g;
    }

    private void a(String str) {
        this.g = str;
    }

    public final int e() {
        return this.d;
    }

    private void c(int i) {
        this.d = i;
    }

    public final boolean f() {
        return String.valueOf(this.d).equals("2");
    }

    public final boolean g() {
        return String.valueOf(this.d).equals("4");
    }

    public final boolean h() {
        return String.valueOf(this.d).equals("3");
    }

    public final boolean i() {
        return String.valueOf(this.d).equals("1");
    }

    public final boolean j() {
        return String.valueOf(this.d).equals("0");
    }

    public final boolean k() {
        int i;
        int i2 = this.d;
        return (i2 == -1 || (i = this.e) == -1 || i2 == i) ? false : true;
    }

    public final boolean l() {
        return k() && this.e == 0;
    }

    public final boolean m() {
        return k() && this.e == 4;
    }

    public final boolean n() {
        return k() && this.e == 2;
    }

    public final boolean o() {
        return k() && this.e == 3;
    }

    public final int p() {
        return this.i;
    }

    public final Map<String, Object> q() {
        return this.c;
    }

    public final void a(Map<String, Object> map) {
        this.c = map;
    }

    public final IATBaseAdAdapter r() {
        return this.h;
    }

    public final void a(IATBaseAdAdapter iATBaseAdAdapter) {
        this.h = iATBaseAdAdapter;
    }
}
