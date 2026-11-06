package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class ak extends k {
    private static ArrayList<aj> A;
    private static Map<String, String> B;
    private static Map<String, String> C;
    private static Map<String, String> v;
    private static ai w;
    private static ah x;
    private static ArrayList<ah> y;
    private static ArrayList<ah> z;
    public String a = "";
    public long b = 0;
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public Map<String, String> h = null;
    public String i = "";
    public ai j = null;
    public int k = 0;
    public String l = "";
    public String m = "";
    public ah n = null;
    public ArrayList<ah> o = null;
    public ArrayList<ah> p = null;
    public ArrayList<aj> q = null;
    public Map<String, String> r = null;
    public Map<String, String> s = null;
    public String t = "";
    private boolean u = true;

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        jVar.a(this.c, 2);
        String str = this.d;
        if (str != null) {
            jVar.a(str, 3);
        }
        String str2 = this.e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        String str3 = this.f;
        if (str3 != null) {
            jVar.a(str3, 5);
        }
        String str4 = this.g;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        Map<String, String> map = this.h;
        if (map != null) {
            jVar.a((Map) map, 7);
        }
        String str5 = this.i;
        if (str5 != null) {
            jVar.a(str5, 8);
        }
        ai aiVar = this.j;
        if (aiVar != null) {
            jVar.a((k) aiVar, 9);
        }
        jVar.a(this.k, 10);
        String str6 = this.l;
        if (str6 != null) {
            jVar.a(str6, 11);
        }
        String str7 = this.m;
        if (str7 != null) {
            jVar.a(str7, 12);
        }
        ah ahVar = this.n;
        if (ahVar != null) {
            jVar.a((k) ahVar, 13);
        }
        ArrayList<ah> arrayList = this.o;
        if (arrayList != null) {
            jVar.a((Collection) arrayList, 14);
        }
        ArrayList<ah> arrayList2 = this.p;
        if (arrayList2 != null) {
            jVar.a((Collection) arrayList2, 15);
        }
        ArrayList<aj> arrayList3 = this.q;
        if (arrayList3 != null) {
            jVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.r;
        if (map2 != null) {
            jVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.s;
        if (map3 != null) {
            jVar.a((Map) map3, 18);
        }
        String str8 = this.t;
        if (str8 != null) {
            jVar.a(str8, 19);
        }
        jVar.a(this.u, 20);
    }

    static {
        HashMap map = new HashMap();
        v = map;
        map.put("", "");
        w = new ai();
        x = new ah();
        y = new ArrayList<>();
        y.add(new ah());
        z = new ArrayList<>();
        z.add(new ah());
        A = new ArrayList<>();
        A.add(new aj());
        HashMap map2 = new HashMap();
        B = map2;
        map2.put("", "");
        HashMap map3 = new HashMap();
        C = map3;
        map3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.b(0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.b(2, true);
        this.d = iVar.b(3, false);
        this.e = iVar.b(4, false);
        this.f = iVar.b(5, false);
        this.g = iVar.b(6, false);
        this.h = (Map) iVar.a(v, 7, false);
        this.i = iVar.b(8, false);
        this.j = (ai) iVar.a((k) w, 9, false);
        this.k = iVar.a(this.k, 10, false);
        this.l = iVar.b(11, false);
        this.m = iVar.b(12, false);
        this.n = (ah) iVar.a((k) x, 13, false);
        this.o = (ArrayList) iVar.a(y, 14, false);
        this.p = (ArrayList) iVar.a(z, 15, false);
        this.q = (ArrayList) iVar.a(A, 16, false);
        this.r = (Map) iVar.a(B, 17, false);
        this.s = (Map) iVar.a(C, 18, false);
        this.t = iVar.b(19, false);
        this.u = iVar.a(20, false);
    }
}
