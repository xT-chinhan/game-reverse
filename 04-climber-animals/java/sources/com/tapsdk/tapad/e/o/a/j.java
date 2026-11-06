package com.tapsdk.tapad.e.o.a;

import com.tapsdk.tapad.constants.Constants;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

/* JADX INFO: loaded from: classes3.dex */
public class j<T> implements ObservableOnSubscribe<T> {
    private final ObservableOnSubscribe<b.a<T>> a;

    private static class a<R> implements ObservableEmitter<b.a<R>> {
        private final ObservableEmitter<R> a;
        private boolean b;

        public a(ObservableEmitter<R> observableEmitter) {
            this.a = observableEmitter;
        }

        /* JADX WARN: Code duplicated, block: B:14:0x002a  */
        @Override // io.reactivex.Emitter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(b.a<R> aVar) {
            int iB;
            String strA;
            k kVar;
            if (aVar != null && (kVar = aVar.a) != null && kVar.b() == 0) {
                this.a.onNext(aVar.b);
                return;
            }
            this.b = true;
            if (aVar != null) {
                try {
                    if (aVar.a != null) {
                        iB = aVar.a.b();
                        strA = aVar.a.a();
                    } else {
                        iB = -1;
                        strA = Constants.l.b;
                    }
                } catch (Exception unused) {
                    return;
                }
            } else {
                iB = -1;
                strA = Constants.l.b;
            }
            this.a.onError(new g(iB, strA));
        }

        @Override // io.reactivex.ObservableEmitter
        public boolean isDisposed() {
            return false;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.b) {
                return;
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (this.b) {
                return;
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.ObservableEmitter
        public ObservableEmitter<b.a<R>> serialize() {
            return null;
        }

        @Override // io.reactivex.ObservableEmitter
        public void setCancellable(Cancellable cancellable) {
        }

        @Override // io.reactivex.ObservableEmitter
        public void setDisposable(Disposable disposable) {
        }
    }

    public j(ObservableOnSubscribe<b.a<T>> observableOnSubscribe) {
        this.a = observableOnSubscribe;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<T> observableEmitter) throws Exception {
        this.a.subscribe(new a(observableEmitter));
    }
}
