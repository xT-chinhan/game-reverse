package com.anythink.basead.exoplayer.g.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements com.anythink.basead.exoplayer.g.a.InterfaceC0027a {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
