package com.tapsdk.tapad.internal.utils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    private static Subject<Object> a = PublishSubject.create().toSerialized();

    private static class b {
        private static final n a = new n();

        private b() {
        }
    }

    private n() {
    }

    public static n a() {
        return b.a;
    }

    public <T> Observable<T> a(Class<T> cls) {
        return (Observable<T>) a.ofType(cls);
    }

    public void a(Object obj) {
        a.onNext(obj);
    }

    public boolean b() {
        return a.hasObservers();
    }

    public Observable<Object> c() {
        return a;
    }
}
