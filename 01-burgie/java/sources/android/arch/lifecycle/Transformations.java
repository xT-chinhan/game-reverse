package android.arch.lifecycle;

import android.arch.core.util.Function;

/* JADX INFO: loaded from: classes.dex */
public class Transformations {
    private Transformations() {
    }

    public static <X, Y> LiveData<Y> map(LiveData<X> source, final Function<X, Y> func) {
        final MediatorLiveData<Y> result = new MediatorLiveData<>();
        result.addSource(source, new Observer<X>() { // from class: android.arch.lifecycle.Transformations.1
            @Override // android.arch.lifecycle.Observer
            public void onChanged(X x) {
                result.setValue(func.apply(x));
            }
        });
        return result;
    }

    public static <X, Y> LiveData<Y> switchMap(LiveData<X> trigger, final Function<X, LiveData<Y>> func) {
        final MediatorLiveData<Y> result = new MediatorLiveData<>();
        result.addSource(trigger, new Observer<X>() { // from class: android.arch.lifecycle.Transformations.2
            LiveData<Y> mSource;

            @Override // android.arch.lifecycle.Observer
            public void onChanged(X x) {
                LiveData<Y> liveData = (LiveData) func.apply(x);
                Object obj = this.mSource;
                if (obj == liveData) {
                    return;
                }
                if (obj != null) {
                    result.removeSource(obj);
                }
                this.mSource = liveData;
                if (liveData != 0) {
                    result.addSource(liveData, new Observer<Y>() { // from class: android.arch.lifecycle.Transformations.2.1
                        @Override // android.arch.lifecycle.Observer
                        public void onChanged(Y y) {
                            result.setValue(y);
                        }
                    });
                }
            }
        });
        return result;
    }
}
