package com.meta.android.mpg.cm.core;

import c1m.m2a.m1g.e;
import c1m.m2a.m1g.g;
import c1m.m2a.m1g.j;
import c1m.m2a.m1g.k;
import c1m.m2a.m1g.v;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
final class d {

    static class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ e c;

        a(String str, String str2, e eVar) {
            this.a = str;
            this.b = str2;
            this.c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap map = new HashMap();
            map.put("gamePackage", this.a);
            map.put("appKey", this.b);
            g.a().a(new j().a(map).b().a("https://combine.233lyly.com/apiserv/api/intermodal/sdkVerification"), this.c);
        }
    }

    static <T> void a(String str, String str2, e<k<T>> eVar) {
        v.a(new a(str, str2, eVar));
    }
}
