package io.reactivex.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DisposableSubscriber<T> implements Subscriber<T>, Disposable {
    final AtomicReference<Subscription> s = new AtomicReference<>();

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.s, subscription)) {
            onStart();
        }
    }

    protected void onStart() {
        this.s.get().request(Long.MAX_VALUE);
    }

    protected final void request(long j) {
        this.s.get().request(j);
    }

    protected final void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.s.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.cancel(this.s);
    }
}
