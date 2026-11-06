package com.tapsdk.tapad.exceptions;

import android.util.Pair;
import com.tapsdk.tapad.constants.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class AdException extends Throwable {
    public int code;
    public String message;

    public AdException(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public AdException(Throwable th) {
        String message;
        if (th instanceof com.tapsdk.tapad.internal.network.b.a) {
            try {
                Pair<Integer, String> pairA = com.tapsdk.tapad.internal.network.c.a.a((com.tapsdk.tapad.internal.network.b.a) th);
                if (((Integer) pairA.first).intValue() == -1) {
                    this.code = Constants.AdError.ERROR_CODE_UNKNOWN;
                } else {
                    this.code = ((Integer) pairA.first).intValue();
                }
                this.message = (String) pairA.second;
                return;
            } catch (Exception e) {
                this.code = Constants.AdError.ERROR_CODE_UNKNOWN;
                message = "parse server response error:" + e.getMessage();
            }
        } else {
            this.code = Constants.AdError.ERROR_CODE_UNKNOWN;
            message = th.getMessage() != null ? th.getMessage() : th.toString();
        }
        this.message = message;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AdException{code=" + this.code + ", message='" + this.message + "'}";
    }
}
