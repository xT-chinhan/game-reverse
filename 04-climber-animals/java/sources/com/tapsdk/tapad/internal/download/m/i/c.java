package com.tapsdk.tapad.internal.download.m.i;

import com.tapsdk.tapad.internal.download.core.cause.EndCause;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends com.tapsdk.tapad.internal.download.m.i.a {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EndCause.values().length];
            a = iArr;
            try {
                iArr[EndCause.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EndCause.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EndCause.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EndCause.PRE_ALLOCATE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EndCause.FILE_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EndCause.SAME_TASK_BUSY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.a.InterfaceC0612a
    public void a(com.tapsdk.tapad.internal.download.f fVar, EndCause endCause, Exception exc, com.tapsdk.tapad.internal.download.m.i.g.a.b bVar) {
        switch (a.a[endCause.ordinal()]) {
            case 1:
                c(fVar);
                break;
            case 2:
                b(fVar);
                break;
            case 3:
            case 4:
                a(fVar, exc);
                break;
            case 5:
            case 6:
                e(fVar);
                break;
            default:
                com.tapsdk.tapad.internal.download.m.c.c("DownloadListener3", "Don't support " + endCause);
                break;
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.i.g.a.InterfaceC0612a
    public final void a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.m.i.g.a.b bVar) {
        d(fVar);
    }

    protected abstract void a(com.tapsdk.tapad.internal.download.f fVar, Exception exc);

    protected abstract void b(com.tapsdk.tapad.internal.download.f fVar);

    protected abstract void c(com.tapsdk.tapad.internal.download.f fVar);

    protected abstract void d(com.tapsdk.tapad.internal.download.f fVar);

    protected abstract void e(com.tapsdk.tapad.internal.download.f fVar);
}
