package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class q9 {
    public StringBuilder a = new StringBuilder();

    public static void a(int i, p pVar, String str) {
        if (pVar == null) {
            return;
        }
        eh.a.a(new n9(i, pVar, str));
    }

    public final synchronized void a(Object... objArr) {
        try {
            this.a.append(System.currentTimeMillis()).append(" ; ");
            for (Object obj : objArr) {
                this.a.append(obj).append("; ");
            }
            this.a.append("\n");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
