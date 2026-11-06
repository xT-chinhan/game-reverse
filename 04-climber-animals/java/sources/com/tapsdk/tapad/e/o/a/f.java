package com.tapsdk.tapad.e.o.a;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* JADX INFO: loaded from: classes3.dex */
public class f<T> implements ObservableOnSubscribe<b.a<T>> {
    private final d<T> a;

    class a implements e<T> {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.tapsdk.tapad.e.o.a.e
        public void a(int i, String str) {
            this.a.a(new g(i, str));
        }

        @Override // com.tapsdk.tapad.e.o.a.e
        public void a(b.a<T> aVar) {
            this.a.b(aVar);
        }
    }

    public f(d<T> dVar) {
        this.a = dVar;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<b.a<T>> observableEmitter) throws Exception {
        this.a.clone().a(new a(new b(observableEmitter)));
    }
}
