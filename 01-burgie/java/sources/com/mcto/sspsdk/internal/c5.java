package com.mcto.sspsdk.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c5 {
    public final d5 a;
    public final boolean[] b;
    public boolean c;
    public final /* synthetic */ f5 d;

    public c5(f5 f5Var, d5 d5Var) {
        this.d = f5Var;
        this.a = d5Var;
        this.b = d5Var.c ? null : new boolean[f5Var.g];
    }

    public final OutputStream a() {
        FileOutputStream fileOutputStream;
        b5 b5Var;
        f5 f5Var = this.d;
        if (f5Var.g <= 0) {
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.d.g);
        }
        synchronized (f5Var) {
            d5 d5Var = this.a;
            if (d5Var.d != this) {
                throw new IllegalStateException();
            }
            if (!d5Var.c) {
                this.b[0] = true;
            }
            File fileB = d5Var.b(0);
            try {
                fileOutputStream = new FileOutputStream(fileB);
            } catch (FileNotFoundException e) {
                this.d.a.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(fileB);
                } catch (FileNotFoundException e2) {
                    return f5.p;
                }
            }
            b5Var = new b5(this, fileOutputStream);
        }
        return b5Var;
    }
}
