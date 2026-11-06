package com.tapsdk.tapad.internal.r.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.utils.t;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.tapsdk.tapad.internal.v.b.a {
    public static final String e = "RewardSkipDialogFragment";
    public static final int f = -1;
    public static final String g = "argument_left_time_in_seconds";
    private d a;
    private TextView b;
    private TextView c;
    private TextView d;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.r.b.a$a, reason: collision with other inner class name */
    class C0631a extends ViewOutlineProvider {
        C0631a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), t.a(a.this.getActivity(), 8.0f));
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.a != null) {
                a.this.a.b();
            }
            a.this.dismissIfShowing();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.a != null) {
                a.this.a.a();
            }
            a.this.dismissIfShowing();
        }
    }

    public interface d {
        void a();

        void b();
    }

    public static a a(int i, d dVar) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt(g, i);
        aVar.setArguments(bundle);
        if (dVar == null) {
            throw new IllegalArgumentException("rewardSkipInterface can't be null");
        }
        aVar.a = dVar;
        return aVar;
    }

    public static void a(Dialog dialog) {
        try {
            View viewFindViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundColor(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void bindView(View view) {
        this.b = (TextView) view.findViewById(R.id.resumePlayAdTextView);
        this.c = (TextView) view.findViewById(R.id.abortRewardTextView);
        this.d = (TextView) view.findViewById(R.id.rewardHintTextView);
    }

    private void initView() {
        this.b.setOnClickListener(new b());
        this.c.setOnClickListener(new c());
        int i = getArguments() != null ? getArguments().getInt(g, -1) : -1;
        if (-1 == i) {
            this.d.setText(getString(R.string.tapad_abort_reward_hint_default));
        } else {
            this.d.setText(getString(R.string.tapad_abort_reward_hint, Integer.valueOf(i)));
        }
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

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.tapad_ad_dialog_reward_skip, viewGroup, false);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Activity activity = getActivity();
        Dialog dialog = getDialog();
        if (activity == null || activity.isDestroyed() || dialog == null || dialog.getWindow() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = t.a(activity, 300.0f);
        attributes.height = t.a(activity, 336.0f);
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            decorView.setSystemUiVisibility(1024);
        }
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.getWindow().setFlags(1024, 1024);
        a(dialog);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.setOutlineProvider(new C0631a());
        view.setClipToOutline(true);
        bindView(view);
        initView();
    }
}
