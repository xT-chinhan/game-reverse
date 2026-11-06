package com.tapsdk.tapad.internal.ui.views.permissions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.utils.j;
import com.tapsdk.tapad.model.entities.AdPermissionCollections;

/* JADX INFO: loaded from: classes3.dex */
public class AdPermissionsDialogFragment extends com.tapsdk.tapad.internal.v.b.a {
    public static final String ARGUMENT_PERMISSION_COLLECTIONS = "argument_permission_collections";
    public static final String TAG = "AdPermissions";
    private ImageView backImageView;
    private ImageView closeImageView;
    protected RecyclerView permissionsRecyclerView;
    private TextView titleTextView;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdPermissionsDialogFragment.this.dismissIfShowing();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdPermissionsDialogFragment.this.dismissIfShowing();
        }
    }

    private void bindView(View view) {
        this.backImageView = (ImageView) view.findViewById(R.id.backImageView);
        this.closeImageView = (ImageView) view.findViewById(R.id.closeImageView);
        this.titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        this.permissionsRecyclerView = (RecyclerView) view.findViewById(R.id.permissionsRecyclerView);
    }

    public static AdPermissionsDialogFragment newInstance(AdPermissionCollections adPermissionCollections) {
        AdPermissionsDialogFragment adPermissionsDialogFragment = new AdPermissionsDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARGUMENT_PERMISSION_COLLECTIONS, adPermissionCollections);
        adPermissionsDialogFragment.setArguments(bundle);
        return adPermissionsDialogFragment;
    }

    protected void initView() {
        AdPermissionCollections adPermissionCollections;
        Activity activity = getActivity();
        if (activity == null || activity.isDestroyed()) {
            return;
        }
        this.backImageView.setOnClickListener(new a());
        this.titleTextView.setText(R.string.tapad_permission_title);
        this.closeImageView.setOnClickListener(new b());
        Bundle arguments = getArguments();
        if (arguments == null || (adPermissionCollections = (AdPermissionCollections) arguments.getParcelable(ARGUMENT_PERMISSION_COLLECTIONS)) == null) {
            return;
        }
        if (adPermissionCollections.sensitivePermissionGroup == null && adPermissionCollections.generalPermissionGroup == null) {
            return;
        }
        this.permissionsRecyclerView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        this.permissionsRecyclerView.setAdapter(new PermissionGroupAdapter(adPermissionCollections.sensitivePermissionGroup, adPermissionCollections.generalPermissionGroup, activity));
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, android.R.style.Theme.DeviceDefault.NoActionBar.TranslucentDecor);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.tapad_ad_permission_fullscreen, viewGroup, false);
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
        attributes.width = -1;
        attributes.height = -1;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.getWindow().setAttributes(attributes);
        dialog.getWindow().setFlags(1024, 1024);
        j.c(getDialog().getWindow());
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        bindView(view);
        initView();
    }
}
