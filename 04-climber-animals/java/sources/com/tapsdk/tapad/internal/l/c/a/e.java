package com.tapsdk.tapad.internal.l.c.a;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* JADX INFO: loaded from: classes3.dex */
public class e<T> implements ObservableOnSubscribe<b.a<T>> {
    private final c<T> a;

    class a implements d<T> {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.tapsdk.tapad.internal.l.c.a.d
        public void a(int i, String str) {
            this.a.a(new f(i, str));
        }

        @Override // com.tapsdk.tapad.internal.l.c.a.d
        public void a(b.a<T> aVar) {
            this.a.b(aVar);
        }
    }

    public e(c<T> cVar) {
        this.a = cVar;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<b.a<T>> observableEmitter) throws Exception {
        c<T> cVarClone = this.a.clone();
        b bVar = new b(cVarClone, observableEmitter);
        bVar.a(1L);
        cVarClone.a(new a(bVar));
    }
}
