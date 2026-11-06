package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ne extends ld {
    public final /* synthetic */ long f;
    public final /* synthetic */ ve g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ne(ve veVar, long j, long j2) {
        super(j);
        this.g = veVar;
        this.f = j2;
    }

    @Override // com.mcto.sspsdk.internal.ld
    public final void a(long j) {
        this.g.a(100 - ((int) (((j * 100) - 10) / this.f)), false);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    @Override // com.mcto.sspsdk.internal.ld
    public final void b() {
        this.g.a(100, false);
        this.g.B.onAdSkip();
    }
}
