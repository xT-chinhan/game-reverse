package com.anythink.core.bridge.entity;

/* JADX INFO: loaded from: classes.dex */
public final class a extends b {

    @DataField("med_plat")
    private int a;

    @DataField("med_version")
    private String b;

    @DataField("med_app_id")
    private String c;

    @DataField("med_app_key")
    private String d;

    public final void a() {
        this.a = 1;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void c(String str) {
        this.d = str;
    }
}
