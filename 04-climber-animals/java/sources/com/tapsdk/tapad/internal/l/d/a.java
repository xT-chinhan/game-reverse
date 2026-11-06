package com.tapsdk.tapad.internal.l.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.ui.views.banner.FloatBottomLandscapeBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.FloatBottomPortraitBannerView;
import com.tapsdk.tapad.model.entities.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.tapsdk.tapad.internal.v.b.a {
    public static final String i = "FloatingDialogFragment";
    private static final String j = "extra_ad_info";
    private DisplayMetrics a = new DisplayMetrics();
    private FloatBottomPortraitBannerView b;
    private FloatBottomLandscapeBannerView c;
    private RelativeLayout d;
    private AdInfo e;
    private d f;
    private DownloadPresenter g;
    private ImageView h;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.l.d.a$a, reason: collision with other inner class name */
    class C0622a implements DownloadPresenter.h {
        C0622a() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
            a.this.c();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            a.this.c();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            a.this.c();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            a.this.c();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            a.this.c();
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            a.this.c();
        }
    }

    class b extends Dialog {
        b(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            super.onBackPressed();
            a.this.dismiss();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a();
        }
    }

    public interface d {
        void a();

        void b();
    }

    public static a a(AdInfo adInfo) {
        Bundle bundle = new Bundle();
        a aVar = new a();
        bundle.putParcelable(j, adInfo);
        aVar.setArguments(bundle);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        dismiss();
        d dVar = this.f;
        if (dVar != null) {
            dVar.b();
        }
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.e = (AdInfo) arguments.getParcelable(j);
        }
    }

    private void bindView(View view) {
        Activity activity = getActivity();
        if (activity == null) {
            a();
            return;
        }
        this.d = (RelativeLayout) view.findViewById(R.id.bottomFrameLayout);
        this.b = (FloatBottomPortraitBannerView) view.findViewById(R.id.bottomBannerView);
        this.c = (FloatBottomLandscapeBannerView) view.findViewById(R.id.landscapeBottomBannerView);
        this.h = (ImageView) view.findViewById(R.id.closeButton);
        if (activity.getResources().getConfiguration().orientation == 1) {
            this.c.setVisibility(8);
            ((ViewGroup) view).removeViewInLayout(this.c);
            this.c = null;
            this.b.setVisibility(0);
            this.b.setGravity(80);
            return;
        }
        this.b.setVisibility(8);
        ((ViewGroup) view).removeViewInLayout(this.b);
        this.b = null;
        this.c.setVisibility(0);
        activity.getWindowManager().getDefaultDisplay().getMetrics(this.a);
        this.d.getLayoutParams().height = this.a.heightPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        FloatBottomPortraitBannerView floatBottomPortraitBannerView = this.b;
        if (floatBottomPortraitBannerView != null) {
            floatBottomPortraitBannerView.b();
            return;
        }
        FloatBottomLandscapeBannerView floatBottomLandscapeBannerView = this.c;
        if (floatBottomLandscapeBannerView != null) {
            floatBottomLandscapeBannerView.updateInteractionLayout();
        }
    }

    private void initView() {
        Activity activity = getActivity();
        if (activity == null) {
            a();
            return;
        }
        if (this.g == null) {
            a();
            return;
        }
        if (activity.getResources().getConfiguration().orientation == 1) {
            this.b.a(activity, this.e, this.g);
        } else {
            this.c.render(activity, this.e, this.g);
        }
        this.h.setOnClickListener(new c());
    }

    public void a(DownloadPresenter downloadPresenter) {
        if (this.g == null) {
            downloadPresenter.a(new C0622a());
        }
        this.g = downloadPresenter;
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, android.R.style.Theme.Material.Dialog.Alert);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        b bVar = new b(getActivity(), getTheme());
        bVar.getWindow().requestFeature(1);
        return bVar;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.tapad_floating_dialog, viewGroup, false);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        d dVar = this.f;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Activity activity = getActivity();
        Dialog dialog = getDialog();
        if (com.tapsdk.tapad.internal.utils.a.b(activity) || dialog == null || dialog.getWindow() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            decorView.setSystemUiVisibility(1024);
        }
        dialog.getWindow().setAttributes(attributes);
        dialog.getWindow().setFlags(1024, 1024);
        com.tapsdk.tapad.internal.v.a.a(dialog);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        b();
        bindView(view);
        initView();
    }

    @Override // android.app.Fragment
    public boolean shouldShowRequestPermissionRationale(String str) {
        return super.shouldShowRequestPermissionRationale(str);
    }
}
