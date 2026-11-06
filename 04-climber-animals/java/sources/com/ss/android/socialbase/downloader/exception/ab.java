package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes3.dex */
public class ab extends BaseException {
    public ab(int i, String str) {
        super(i, str);
    }

    public ab ms(String str) {
        setExtraInfo(str);
        return this;
    }

    public String ms() {
        return getExtraInfo();
    }
}
