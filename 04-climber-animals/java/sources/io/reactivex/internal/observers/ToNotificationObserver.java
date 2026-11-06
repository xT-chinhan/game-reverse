package io.reactivex.internal.observers;

import io.reactivex.Notification;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class ToNotificationObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -7420197867343208289L;
    final Consumer<? super Notification<Object>> consumer;

    public ToNotificationObserver(Consumer<? super Notification<Object>> consumer) {
        this.consumer = consumer;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (t == null) {
            get().dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        try {
            this.consumer.accept(Notification.createOnNext(t));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        try {
            this.consumer.accept(Notification.createOnError(th));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        try {
            this.consumer.accept(Notification.createOnComplete());
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }
}
