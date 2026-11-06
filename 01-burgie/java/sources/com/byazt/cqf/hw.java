package com.byazt.cqf;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 13})
public abstract class hw {
    public DataSetObserver hw;
    public final DataSetObservable pr = new DataSetObservable();

    public abstract int pr();

    public abstract boolean pr(View view, Object obj);

    public Object pr(ViewGroup viewGroup, int i) {
        return pr((View) viewGroup, i);
    }

    public void pr(ViewGroup viewGroup, int i, Object obj) {
        pr((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object pr(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void pr(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public Parcelable hw() {
        return null;
    }

    public int pr(Object obj) {
        return -1;
    }

    public void hn() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.hw;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.pr.notifyChanged();
    }

    public void pr(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.hw = dataSetObserver;
        }
    }

    public float pr(int i) {
        return 1.0f;
    }
}
