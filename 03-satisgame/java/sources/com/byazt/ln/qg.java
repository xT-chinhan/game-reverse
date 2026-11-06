package com.byazt.ln;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.PointerIconCompat;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 26})
public abstract class qg {
    public final DataSetObservable n = new DataSetObservable();
    public DataSetObserver qg;

    public float n(int i) {
        return 1.0f;
    }

    public abstract int n();

    public int n(Object obj) {
        return -1;
    }

    public abstract boolean n(View view, Object obj);

    public Parcelable qg() {
        return null;
    }

    public Object n(ViewGroup viewGroup, int i) {
        return n((View) viewGroup, i);
    }

    public void n(ViewGroup viewGroup, int i, Object obj) {
        n((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object n(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void n(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void s() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.qg;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.n.notifyChanged();
    }

    public void n(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.qg = dataSetObserver;
        }
    }
}
