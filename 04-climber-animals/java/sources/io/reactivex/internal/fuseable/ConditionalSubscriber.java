package io.reactivex.internal.fuseable;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public interface ConditionalSubscriber<T> extends Subscriber<T> {
    boolean tryOnNext(T t);
}
