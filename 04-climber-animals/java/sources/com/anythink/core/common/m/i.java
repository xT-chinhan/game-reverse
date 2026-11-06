package com.anythink.core.common.m;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.cd;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a {
    public static final int c = 1;
    String a;
    int b;
    boolean d;
    private cd e;

    @Override // com.anythink.core.common.m.a
    protected final int a() {
        return 2;
    }

    @Override // com.anythink.core.common.m.a
    protected final void a(AdError adError) {
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, String> c() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final byte[] d() {
        return new byte[0];
    }

    @Override // com.anythink.core.common.m.a
    protected final String g() {
        return "";
    }

    @Override // com.anythink.core.common.m.a
    protected final String h() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Context i() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final String j() {
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final Map<String, Object> k() {
        return null;
    }

    private i(String str) {
        this.b = 0;
        this.d = false;
        this.a = str;
    }

    private i(String str, cd cdVar) {
        this(str);
        this.b = 1;
        this.e = cdVar;
    }

    public static i a(String str) {
        return new i(str);
    }

    public static i a(String str, cd cdVar) {
        return new i(str, cdVar);
    }

    @Override // com.anythink.core.common.m.a
    protected final String b() {
        return this.a;
    }

    @Override // com.anythink.core.common.m.a
    protected final Object a(Object obj) {
        cd cdVar;
        if (1 != this.b || (cdVar = this.e) == null) {
            return null;
        }
        cdVar.a("200");
        com.anythink.core.common.v.d.a().a(this.e.y(), this.e.z(), com.anythink.core.common.v.d.c, "0");
        com.anythink.core.b.d.c.a(this.e);
        return null;
    }

    @Override // com.anythink.core.common.m.a
    protected final void b(AdError adError) {
        cd cdVar;
        if (1 != this.b || (cdVar = this.e) == null) {
            return;
        }
        int iK = cdVar.k();
        com.anythink.core.common.h.n nVarY = this.e.y();
        bv bvVarZ = this.e.z();
        if (iK == 50 && com.anythink.core.common.v.d.a().a(nVarY, bvVarZ) && !this.d) {
            this.d = true;
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.common.m.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    iVar.a(0, iVar.r);
                }
            }, com.tapsdk.tapad.e.a.f);
        } else {
            this.e.a(adError.getPlatformCode());
            this.e.b(adError.getPlatformMSG());
            com.anythink.core.common.v.d.a().a(nVarY, bvVarZ, com.anythink.core.common.v.d.c, "1");
            com.anythink.core.b.d.c.a(this.e);
        }
    }
}
