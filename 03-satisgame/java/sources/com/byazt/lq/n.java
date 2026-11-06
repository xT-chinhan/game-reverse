package com.byazt.lq;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 751, 19})
public final class n implements com.byazt.lpr.s.n {
    public final com.byazt.lpr.s.n n;
    public qg qg = new qg();

    /* JADX INFO: renamed from: com.byazt.lq.n$n, reason: collision with other inner class name */
    private interface InterfaceC0240n {
        void n(String str, String str2);
    }

    public n(com.byazt.lpr.s.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.lpr.s.n
    public void n(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            n(str, str2, new InterfaceC0240n() { // from class: com.byazt.lq.n.1
                @Override // com.byazt.lq.n.InterfaceC0240n
                public void n(String str3, String str4) {
                    n.this.n.n(str3, str4);
                }
            });
        } else {
            this.n.n(str, str2);
        }
    }

    @Override // com.byazt.lpr.s.n
    public void qg(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            n(str, str2, new InterfaceC0240n() { // from class: com.byazt.lq.n.2
                @Override // com.byazt.lq.n.InterfaceC0240n
                public void n(String str3, String str4) {
                    n.this.n.qg(str3, str4);
                }
            });
        } else {
            this.n.qg(str, str2);
        }
    }

    @Override // com.byazt.lpr.s.n
    public void s(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            n(str, str2, new InterfaceC0240n() { // from class: com.byazt.lq.n.3
                @Override // com.byazt.lq.n.InterfaceC0240n
                public void n(String str3, String str4) {
                    n.this.n.s(str3, str4);
                }
            });
        } else {
            this.n.s(str, str2);
        }
    }

    @Override // com.byazt.lpr.s.n
    public void q(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            n(str, str2, new InterfaceC0240n() { // from class: com.byazt.lq.n.4
                @Override // com.byazt.lq.n.InterfaceC0240n
                public void n(String str3, String str4) {
                    n.this.n.q(str3, str4);
                }
            });
        } else {
            this.n.q(str, str2);
        }
    }

    @Override // com.byazt.lpr.s.n
    public void n(String str, String str2, Throwable th) {
        this.n.n(str, str2, th);
    }

    @Override // com.byazt.lpr.s.n
    public void n(String str, Throwable th) {
        this.n.n(str, th);
    }

    @Override // com.byazt.lpr.s.n
    public void n() {
        this.n.n();
    }

    private void n(final String str, final String str2, final InterfaceC0240n interfaceC0240n) {
        try {
            if (com.byazt.ag.qg.n()) {
                com.byazt.ag.qg.qg(new Runnable() { // from class: com.byazt.lq.n.5
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.qg.n(str, str2, interfaceC0240n);
                    }
                });
            } else {
                this.qg.n(str, str2, interfaceC0240n);
            }
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 751, 226})
    private class qg {
        private qg() {
        }

        public void n(String str, String str2, InterfaceC0240n interfaceC0240n) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i = 0;
            while (i < str2.length()) {
                int iMin = Math.min(i + 4096, str2.length());
                interfaceC0240n.n(n(str, hexString, i, iMin), str2.substring(i, iMin));
                i = iMin;
            }
        }

        private String n(String str, String str2, int i, int i2) {
            return str + "_" + i + "_" + i2 + "_" + str2;
        }
    }
}
