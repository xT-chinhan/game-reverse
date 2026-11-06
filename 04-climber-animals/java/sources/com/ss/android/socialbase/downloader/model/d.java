package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.ab;
import com.ss.android.socialbase.downloader.ny.c;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public final int ah;
    private long d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final String f4712ms;
    public final ab xr;

    public d(String str, ab abVar) throws IOException {
        this.f4712ms = str;
        this.ah = abVar.xr();
        this.xr = abVar;
    }

    public boolean ms() {
        return c.ah(this.ah);
    }

    public boolean xr() {
        return c.ms(this.ah, this.xr.ms("Accept-Ranges"));
    }

    public String ah() {
        return this.xr.ms("Etag");
    }

    public String d() {
        return this.xr.ms("Content-Type");
    }

    public String ka() {
        return c.xr(this.xr, "Content-Range");
    }

    public String c() {
        String strXr = c.xr(this.xr, "last-modified");
        return TextUtils.isEmpty(strXr) ? c.xr(this.xr, "Last-Modified") : strXr;
    }

    public String ab() {
        return c.xr(this.xr, "Cache-Control");
    }

    public long x() {
        if (this.d <= 0) {
            this.d = c.ms(this.xr);
        }
        return this.d;
    }

    public boolean ny() {
        if (com.ss.android.socialbase.downloader.ny.ms.ms(8)) {
            return c.ah(this.xr);
        }
        return c.xr(x());
    }

    public long ch() {
        if (this.ka <= 0) {
            if (!ny()) {
                String strKa = ka();
                if (!TextUtils.isEmpty(strKa)) {
                    this.ka = c.xr(strKa);
                }
            } else {
                this.ka = -1L;
            }
        }
        return this.ka;
    }

    public long hi() {
        return c.ny(ab());
    }
}
