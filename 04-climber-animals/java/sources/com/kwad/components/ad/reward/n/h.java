package com.kwad.components.ad.reward.n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: classes3.dex */
public class h extends s implements View.OnClickListener {
    protected ImageView BA;
    protected KsAppTagsView BE;
    protected KsConvertButton BV;
    protected TextView BW;
    protected TextView BX;
    protected TextView BY;
    protected a BZ;
    protected int Ca = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean Cb = true;
    protected KsLogoView mLogoView;

    public interface a {
        void jk();

        void jl();

        void jm();

        void jn();

        void jo();

        void jp();
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, jj(), le());
        g(this.vV);
        if (this.vV != null) {
            this.vV.setOnClickListener(this);
            this.BV.setOnClickListener(this);
            this.BA.setOnClickListener(this);
            this.BW.setOnClickListener(this);
            TextView textView = this.BX;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.BY;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.BE;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    protected int jj() {
        return R.id.ksad_common_app_card_stub;
    }

    private static int le() {
        return R.id.ksad_common_app_card_root;
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.BA = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.BW = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.BE = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.BX = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.BY = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.BV = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    public final void a(a aVar) {
        this.BZ = aVar;
    }

    public final void show() {
        if (this.vV != null) {
            this.vV.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.Cb));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    private void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i;
        KsAppTagsView ksAppTagsView;
        KsConvertButton ksConvertButton;
        int i2;
        if (aVar == null) {
            return;
        }
        ag(aVar.im());
        KsLogoView ksLogoView = this.mLogoView;
        if (ksLogoView != null) {
            ksLogoView.aP(aVar.ii());
        }
        this.BW.setText(aVar.getTitle());
        TextView textView2 = this.BX;
        if (textView2 != null) {
            textView2.setText(aVar.hp());
        }
        TextView textView3 = this.BY;
        if (textView3 != null) {
            textView3.setText(aVar.hp());
            if (TextUtils.isEmpty(aVar.hp())) {
                i2 = 8;
                i = 8;
            } else if (aVar.il()) {
                i = 0;
                i2 = 8;
            } else {
                i2 = 0;
                i = 8;
            }
            TextView textView4 = this.BX;
            if (textView4 != null) {
                textView4.setVisibility(i2);
            }
            textView = this.BY;
        } else {
            textView = this.BX;
            if (textView != null) {
                i = TextUtils.isEmpty(aVar.hp()) ? 8 : 0;
            }
            ksAppTagsView = this.BE;
            if (ksAppTagsView != null) {
                ksAppTagsView.a(aVar.ik(), this.Ca);
                this.BE.setVisibility(aVar.il() ? 8 : 0);
            }
            ksConvertButton = this.BV;
            if (ksConvertButton != null) {
                ksConvertButton.a(aVar.ij(), aVar.ii());
            }
            KSImageLoader.loadAppIcon(this.BA, aVar.ho(), aVar.ii(), 12);
        }
        textView.setVisibility(i);
        ksAppTagsView = this.BE;
        if (ksAppTagsView != null) {
            ksAppTagsView.a(aVar.ik(), this.Ca);
            this.BE.setVisibility(aVar.il() ? 8 : 0);
        }
        ksConvertButton = this.BV;
        if (ksConvertButton != null) {
            ksConvertButton.a(aVar.ij(), aVar.ii());
        }
        KSImageLoader.loadAppIcon(this.BA, aVar.ho(), aVar.ii(), 12);
    }

    private void ag(int i) {
        KsConvertButton ksConvertButton = this.BV;
        if (ksConvertButton == null) {
            return;
        }
        if (i == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i == 2) {
            ksConvertButton.getCornerConf().cp(false).cs(false).cr(true).cq(true);
        }
        this.BV.postInvalidate();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.BV)) {
            a aVar2 = this.BZ;
            if (aVar2 != null) {
                aVar2.jk();
                return;
            }
            return;
        }
        if (view.equals(this.BA)) {
            a aVar3 = this.BZ;
            if (aVar3 != null) {
                aVar3.jl();
                return;
            }
            return;
        }
        if (view.equals(this.BW)) {
            a aVar4 = this.BZ;
            if (aVar4 != null) {
                aVar4.jm();
                return;
            }
            return;
        }
        if (view.equals(this.BX) || view.equals(this.BY)) {
            a aVar5 = this.BZ;
            if (aVar5 != null) {
                aVar5.jn();
                return;
            }
            return;
        }
        if (view.equals(this.BE)) {
            a aVar6 = this.BZ;
            if (aVar6 != null) {
                aVar6.jo();
                return;
            }
            return;
        }
        if (!view.equals(this.vV) || (aVar = this.BZ) == null) {
            return;
        }
        aVar.jp();
    }
}
