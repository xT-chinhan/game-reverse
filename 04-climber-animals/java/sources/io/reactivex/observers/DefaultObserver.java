package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable s;

    protected void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.s, disposable)) {
            this.s = disposable;
            onStart();
        }
    }

    protected final void cancel() {
        Disposable disposable = this.s;
        this.s = DisposableHelper.DISPOSED;
        disposable.dispose();
    }
}
