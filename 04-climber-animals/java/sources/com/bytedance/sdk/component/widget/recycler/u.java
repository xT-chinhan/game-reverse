package com.bytedance.sdk.component.widget.recycler;

/* JADX INFO: loaded from: classes2.dex */
class u {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final com.bytedance.sdk.component.widget.recycler.ms.xr.ms<RecyclerView.re, ms> f1428ms = new com.bytedance.sdk.component.widget.recycler.ms.xr.ms<>();
    final com.bytedance.sdk.component.widget.recycler.ms.xr.ah<RecyclerView.re> xr = new com.bytedance.sdk.component.widget.recycler.ms.xr.ah<>();

    interface xr {
        void ah(RecyclerView.re reVar, RecyclerView.c.xr xrVar, RecyclerView.c.xr xrVar2);

        void ms(RecyclerView.re reVar);

        void ms(RecyclerView.re reVar, RecyclerView.c.xr xrVar, RecyclerView.c.xr xrVar2);

        void xr(RecyclerView.re reVar, RecyclerView.c.xr xrVar, RecyclerView.c.xr xrVar2);
    }

    u() {
    }

    void ms() {
        this.f1428ms.clear();
        this.xr.ah();
    }

    void ms(RecyclerView.re reVar, RecyclerView.c.xr xrVar) {
        ms msVarMs = this.f1428ms.get(reVar);
        if (msVarMs == null) {
            msVarMs = ms.ms();
            this.f1428ms.put(reVar, msVarMs);
        }
        msVarMs.xr = xrVar;
        msVarMs.f1429ms |= 4;
    }

    boolean ms(RecyclerView.re reVar) {
        ms msVar = this.f1428ms.get(reVar);
        return (msVar == null || (msVar.f1429ms & 1) == 0) ? false : true;
    }

    RecyclerView.c.xr xr(RecyclerView.re reVar) {
        return ms(reVar, 4);
    }

    RecyclerView.c.xr ah(RecyclerView.re reVar) {
        return ms(reVar, 8);
    }

    private RecyclerView.c.xr ms(RecyclerView.re reVar, int i) {
        ms msVarXr;
        RecyclerView.c.xr xrVar;
        int iMs = this.f1428ms.ms(reVar);
        if (iMs < 0 || (msVarXr = this.f1428ms.xr(iMs)) == null || (msVarXr.f1429ms & i) == 0) {
            return null;
        }
        msVarXr.f1429ms &= ~i;
        if (i == 4) {
            xrVar = msVarXr.xr;
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            xrVar = msVarXr.ah;
        }
        if ((msVarXr.f1429ms & 12) == 0) {
            this.f1428ms.ah(iMs);
            ms.ms(msVarXr);
        }
        return xrVar;
    }

    void ms(long j, RecyclerView.re reVar) {
        this.xr.xr(j, reVar);
    }

    void xr(RecyclerView.re reVar, RecyclerView.c.xr xrVar) {
        ms msVarMs = this.f1428ms.get(reVar);
        if (msVarMs == null) {
            msVarMs = ms.ms();
            this.f1428ms.put(reVar, msVarMs);
        }
        msVarMs.f1429ms |= 2;
        msVarMs.xr = xrVar;
    }

    boolean d(RecyclerView.re reVar) {
        ms msVar = this.f1428ms.get(reVar);
        return (msVar == null || (msVar.f1429ms & 4) == 0) ? false : true;
    }

    RecyclerView.re ms(long j) {
        return this.xr.ms(j);
    }

    void ah(RecyclerView.re reVar, RecyclerView.c.xr xrVar) {
        ms msVarMs = this.f1428ms.get(reVar);
        if (msVarMs == null) {
            msVarMs = ms.ms();
            this.f1428ms.put(reVar, msVarMs);
        }
        msVarMs.ah = xrVar;
        msVarMs.f1429ms |= 8;
    }

    void ka(RecyclerView.re reVar) {
        ms msVarMs = this.f1428ms.get(reVar);
        if (msVarMs == null) {
            msVarMs = ms.ms();
            this.f1428ms.put(reVar, msVarMs);
        }
        msVarMs.f1429ms |= 1;
    }

    void c(RecyclerView.re reVar) {
        ms msVar = this.f1428ms.get(reVar);
        if (msVar != null) {
            msVar.f1429ms &= -2;
        }
    }

    void ms(xr xrVar) {
        for (int size = this.f1428ms.size() - 1; size >= 0; size--) {
            RecyclerView.re reVarMs = this.f1428ms.ms(size);
            ms msVarAh = this.f1428ms.ah(size);
            if ((msVarAh.f1429ms & 3) == 3) {
                xrVar.ms(reVarMs);
            } else if ((msVarAh.f1429ms & 1) != 0) {
                if (msVarAh.xr == null) {
                    xrVar.ms(reVarMs);
                } else {
                    xrVar.ms(reVarMs, msVarAh.xr, msVarAh.ah);
                }
            } else if ((msVarAh.f1429ms & 14) == 14) {
                xrVar.xr(reVarMs, msVarAh.xr, msVarAh.ah);
            } else if ((msVarAh.f1429ms & 12) == 12) {
                xrVar.ah(reVarMs, msVarAh.xr, msVarAh.ah);
            } else if ((msVarAh.f1429ms & 4) != 0) {
                xrVar.ms(reVarMs, msVarAh.xr, null);
            } else if ((msVarAh.f1429ms & 8) != 0) {
                xrVar.xr(reVarMs, msVarAh.xr, msVarAh.ah);
            }
            ms.ms(msVarAh);
        }
    }

    void ab(RecyclerView.re reVar) {
        for (int iXr = this.xr.xr() - 1; iXr >= 0; iXr--) {
            if (reVar == this.xr.ah(iXr)) {
                this.xr.ms(iXr);
                break;
            }
        }
        ms msVarRemove = this.f1428ms.remove(reVar);
        if (msVarRemove != null) {
            ms.ms(msVarRemove);
        }
    }

    void xr() {
        ms.xr();
    }

    public void x(RecyclerView.re reVar) {
        c(reVar);
    }

    static class ms {
        static com.bytedance.sdk.component.widget.recycler.ms.xr.d.ms<ms> d = new com.bytedance.sdk.component.widget.recycler.ms.xr.d.xr(20);
        RecyclerView.c.xr ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1429ms;
        RecyclerView.c.xr xr;

        private ms() {
        }

        static ms ms() {
            ms msVarMs = d.ms();
            return msVarMs == null ? new ms() : msVarMs;
        }

        static void ms(ms msVar) {
            msVar.f1429ms = 0;
            msVar.xr = null;
            msVar.ah = null;
            d.ms(msVar);
        }

        static void xr() {
            while (d.ms() != null) {
            }
        }
    }
}
