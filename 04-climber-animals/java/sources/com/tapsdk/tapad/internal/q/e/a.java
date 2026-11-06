package com.tapsdk.tapad.internal.q.e;

import java.net.URL;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public final int a;
    public URL b;
    public String c;
    public long d;
    public long e;
    public RequestBody f;
    public ResponseBody g;
    public String h;
    public int i;
    public long j;
    public long k;

    public a(int i) {
        this.a = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Id : ");
        sb.append(this.a).append("\nMethod : ").append(this.c).append("\nHost : ").append(this.h).append("\nStatusCode : ").append(this.i).append("\nRequest Size : ").append(this.d).append("\nResponse Size : ").append(this.e).append("\nTime Taken : ").append(this.k - this.j).append("\nUrl : ").append(this.b).append("\nRequest Body : ").append(this.f).append("\nResponse Body : ").append(this.g);
        return sb.toString();
    }
}
