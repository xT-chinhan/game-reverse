package com.smartdigimkt.b2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView;
import com.smartdigimkt.sdk.basead.ui.specialnote.ScreenSpecialNoteView;
import com.smartdigimkt.sdk.basead.ui.specialnote.SimpleSpecialNoteView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 extends f {
    public BaseSpecialNoteView i;
    public long j;
    public boolean k = false;
    public boolean l = false;

    @Override // com.smartdigimkt.b2.f
    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        com.smartdigimkt.b3.e eVar2;
        super.a(context, cVar, aVar, viewGroup, relativeLayout, view, i, eVar);
        int i2 = this.e;
        if (i2 == 4 || i2 == 5 || i2 == 6) {
            this.i = new SimpleSpecialNoteView(this.a);
        } else {
            this.i = new ScreenSpecialNoteView(this.a);
        }
        com.smartdigimkt.a3.a aVar2 = this.c;
        if (aVar2 == null || !String.valueOf(aVar2.c).equals("4") || (eVar2 = this.c.s) == null) {
            return;
        }
        this.j = eVar2.l;
    }

    @Override // com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        if (i == 102) {
            this.l = true;
            return;
        }
        if (i == 103) {
            Object obj = map.get("key_has_endcard_improve");
            if (!(obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) && com.smartdigimkt.z.c0.h(this.b, this.c)) {
                a(7);
                return;
            }
            return;
        }
        if (i != 119) {
            switch (i) {
                case 112:
                    break;
                case 113:
                    this.k = true;
                    break;
                case 114:
                    if (com.smartdigimkt.z.c0.h(this.b, this.c)) {
                        if (this.e != 1) {
                            a(6);
                            return;
                        } else {
                            if (this.l) {
                                return;
                            }
                            a(6);
                            return;
                        }
                    }
                    a(5);
                    return;
                default:
                    return;
            }
            BaseSpecialNoteView baseSpecialNoteView = this.i;
            if (baseSpecialNoteView != null) {
                baseSpecialNoteView.release();
                return;
            }
            return;
        }
        BaseSpecialNoteView baseSpecialNoteView2 = this.i;
        if (baseSpecialNoteView2 != null) {
            baseSpecialNoteView2.release();
        }
    }

    public final void a(int i) {
        long j;
        long j2;
        long j3;
        this.b.getClass();
        if (this.k || this.i == null) {
            return;
        }
        if (i == 5) {
            com.smartdigimkt.b3.e eVar = this.c.s;
            if (!eVar.a0) {
                return;
            }
            j = eVar.d0;
            j2 = eVar.e0;
        } else if (i == 6) {
            com.smartdigimkt.b3.e eVar2 = this.c.s;
            if (!eVar2.b0) {
                return;
            }
            j = eVar2.d0;
            j2 = eVar2.e0;
        } else {
            if (i != 7) {
                return;
            }
            com.smartdigimkt.b3.e eVar3 = this.c.s;
            if (!eVar3.c0) {
                return;
            }
            j = eVar3.f0;
            j2 = eVar3.g0;
        }
        long j4 = this.j;
        if (j4 <= 0 || j4 >= j + j2 + 1000) {
            j3 = j2;
        } else if (j2 + 1000 >= j4) {
            j3 = j4 - 1000;
            j = 0;
        } else {
            j = (j4 - j2) - 1000;
            j3 = j2;
        }
        if (j >= 0 && j3 >= 0) {
            com.smartdigimkt.q3.f.a().a(new i0(this, i, j, j3));
        }
    }
}
