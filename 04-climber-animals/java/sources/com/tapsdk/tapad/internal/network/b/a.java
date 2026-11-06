package com.tapsdk.tapad.internal.network.b;

import com.tapsdk.tapad.model.entities.TrackBackData;

/* JADX INFO: loaded from: classes3.dex */
public class a extends RuntimeException {
    public final int a;
    public final String b;
    public final String c;
    public TrackBackData d;

    public a(int i, String str, String str2) {
        this(i, str, str2, null);
    }

    public a(int i, String str, String str2, TrackBackData trackBackData) {
        super(str);
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = trackBackData;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ServerException{statusCode=" + this.a + ", message='" + this.b + "', responseBody='" + this.c + "'}";
    }
}
