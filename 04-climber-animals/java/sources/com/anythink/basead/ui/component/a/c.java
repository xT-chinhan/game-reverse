package com.anythink.basead.ui.component.a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.ui.ScanningAnimButton;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    @Override // com.anythink.basead.ui.component.a.d
    public void b(ViewGroup viewGroup) {
        LayoutInflater.from(viewGroup.getContext()).inflate(q.a(viewGroup.getContext(), "myoffer_cta_button_layout", "layout"), viewGroup);
        this.a = (ScanningAnimButton) viewGroup.findViewById(q.a(viewGroup.getContext(), "myoffer_cta_button_major", "id"));
        this.b = (ScanningAnimButton) viewGroup.findViewById(q.a(viewGroup.getContext(), "myoffer_cta_button_minor", "id"));
    }

    @Override // com.anythink.basead.ui.component.a.d
    public final void c(ViewGroup viewGroup) {
        if (this.b != null) {
            this.b.setTextColor(Color.parseColor("#FFFFFF"));
            this.b.setBackgroundResource(q.a(viewGroup.getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem_minor_white", "drawable"));
        }
    }

    private static boolean a(w wVar, boolean z) {
        if (wVar != null) {
            int iAN = wVar.r().aN();
            if (iAN == 2) {
                return z;
            }
            if (iAN == 3) {
                return !z;
            }
            if (iAN == 4) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001c  */
    @Override // com.anythink.basead.ui.component.a.d
    public void a(ViewGroup viewGroup, w wVar, x xVar, final boolean z, final com.anythink.basead.ui.f.b.a aVar) {
        boolean z2;
        if (wVar == null) {
            z2 = false;
        } else {
            int iAN = wVar.r().aN();
            if (iAN == 2) {
                z2 = z;
            } else if (iAN == 3) {
                z2 = !z;
            } else if (iAN != 4) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (this.b != null) {
            if (z2) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams.width > 0 && layoutParams.width < q.a(viewGroup.getContext(), 240.0f)) {
                    layoutParams.width = q.a(viewGroup.getContext(), 296.0f);
                    viewGroup.setLayoutParams(layoutParams);
                }
                this.b.setVisibility(0);
                if (!TextUtils.isEmpty(xVar.o.aX())) {
                    this.b.setText(xVar.o.aX());
                }
                if (aVar != null) {
                    this.b.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.component.a.c.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            if (z) {
                                aVar.a(1, 40);
                            } else {
                                aVar.a(1, 24);
                            }
                        }
                    });
                }
            } else {
                this.b.setVisibility(8);
            }
        }
        if (this.a != null) {
            if (!TextUtils.isEmpty(wVar.D())) {
                this.a.setText(wVar.D());
            } else {
                this.a.setText(com.anythink.basead.b.e.a(viewGroup.getContext(), wVar));
            }
            if (viewGroup.getParent() != null && (viewGroup.getParent() instanceof ViewGroup)) {
                ((ViewGroup) viewGroup.getParent()).setClipChildren(false);
            }
            if (wVar.r() != null) {
                this.a.startAnimation(wVar.r().aF());
            }
            if (aVar == null || !z2) {
                return;
            }
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.component.a.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (z) {
                        aVar.a(1, 41);
                    } else {
                        aVar.a(1, 25);
                    }
                }
            });
        }
    }
}
