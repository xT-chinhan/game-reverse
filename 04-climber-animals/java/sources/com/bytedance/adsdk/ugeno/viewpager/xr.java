package com.bytedance.adsdk.ugeno.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final DataSetObservable f403ms = new DataSetObservable();
    private DataSetObserver xr;

    public float ms(int i) {
        return 1.0f;
    }

    public abstract int ms();

    public int ms(Object obj) {
        return -1;
    }

    public abstract boolean ms(View view, Object obj);

    public Parcelable xr() {
        return null;
    }

    public Object ms(ViewGroup viewGroup, int i) {
        return ms((View) viewGroup, i);
    }

    public void ms(ViewGroup viewGroup, int i, Object obj) {
        ms((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object ms(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void ms(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void ah() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.xr;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.f403ms.notifyChanged();
    }

    void ms(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.xr = dataSetObserver;
        }
    }
}
