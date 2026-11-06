package com.smartdigimkt.p1;

import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {
    public final h q;

    public d(View view) {
        super(view);
        if (view == null) {
            return;
        }
        h hVar = new h(view);
        this.q = hVar;
        hVar.e = 0.85f;
    }

    @Override // com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public final void a() {
        super.a();
        h hVar = this.q;
        if (hVar != null) {
            hVar.a();
        }
    }

    @Override // com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public final void pause() {
        super.pause();
        h hVar = this.q;
        if (hVar != null) {
            hVar.pause();
        }
    }

    @Override // com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public final synchronized void start() {
        super.start();
        h hVar = this.q;
        if (hVar != null) {
            hVar.start();
        }
    }

    @Override // com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public final void stop() {
        super.stop();
        h hVar = this.q;
        if (hVar != null) {
            hVar.stop();
        }
    }

    @Override // com.smartdigimkt.p1.f, com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public final void a(Canvas canvas) {
        super.a(canvas);
    }

    @Override // com.smartdigimkt.p1.f, com.smartdigimkt.p1.b, com.smartdigimkt.o1.b
    public final void a(int i, int i2) {
        super.a(i, i2);
        h hVar = this.q;
        if (hVar != null) {
            hVar.c = i;
            hVar.d = i2;
        }
    }
}
