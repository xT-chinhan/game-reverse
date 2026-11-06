package com.ss.android.socialbase.downloader.x;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.ny;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    void ah(BaseException baseException);

    com.ss.android.socialbase.downloader.exception.x ms(BaseException baseException, long j);

    com.ss.android.socialbase.downloader.exception.x ms(com.ss.android.socialbase.downloader.model.xr xrVar, BaseException baseException, long j);

    com.ss.android.socialbase.downloader.model.xr ms(int i);

    void ms(long j) throws BaseException;

    void ms(BaseException baseException, boolean z);

    void ms(com.ss.android.socialbase.downloader.network.ab abVar);

    void ms(xr xrVar);

    void ms(String str, com.ss.android.socialbase.downloader.network.ab abVar, long j) throws ny, BaseException;

    boolean ms(BaseException baseException);

    void xr(BaseException baseException);

    boolean xr(long j) throws BaseException;
}
