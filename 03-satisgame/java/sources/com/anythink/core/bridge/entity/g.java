package com.anythink.core.bridge.entity;

import com.anythink.core.common.d.s;
import com.anythink.core.common.f.i;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public final class g extends b {

    @DataField("placement_id")
    public String a;

    @DataField(com.anythink.core.common.f.a.C0017a.d)
    public int b;

    @DataField("traffic_group_id")
    public int c;

    @DataField("group_id")
    public int d;

    @DataField(i.a.d)
    public String e;

    @DataField("request_id")
    public String f;

    @DataField("origin_request_id")
    public String g;

    @DataField("x_c")
    public String h;

    @DataField(i.a.c)
    public String i;

    @DataField("network_firm_id")
    public int j;

    @DataField("network_name")
    public String k;

    @DataField("tp_bid_id")
    public String l;

    @DataField(com.anythink.core.common.l.f.bB)
    public int m;

    @DataField("mtg_mix_format")
    public int n;

    @DataField("unit_group_content")
    public String o;

    @DataField("bid_result_out_date_time")
    public long p;

    @DataField("request_url")
    public String q;

    @DataField("max_install_id_size")
    public int r;

    @DataField("max_exclude_id_size")
    public int s;

    public g(x xVar) {
        this.m = s.b().F();
        this.n = -1;
        if (xVar != null) {
            this.a = xVar.a;
            this.b = xVar.b;
            this.c = xVar.c;
            this.d = xVar.d;
            this.e = xVar.e;
            this.f = xVar.f;
            this.g = xVar.g;
            this.h = xVar.h;
            this.i = xVar.i;
            this.j = xVar.j;
            this.k = xVar.k;
            this.l = xVar.l;
            this.m = xVar.m;
            this.n = xVar.n;
            this.o = xVar.o;
            this.p = xVar.p;
            this.q = xVar.q;
            this.r = xVar.r;
            this.s = xVar.s;
        }
    }
}
