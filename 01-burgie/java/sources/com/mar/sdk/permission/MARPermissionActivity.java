package com.mar.sdk.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class MARPermissionActivity extends Activity {
    private IPermissionLifeCycle permissionLifeCycle;
    private IAutoPermissionListener permissionListener = new IAutoPermissionListener() { // from class: com.mar.sdk.permission.MARPermissionActivity.1
        @Override // com.mar.sdk.permission.IAutoPermissionListener
        public void onAutoPermissionSuccess() {
            Log.d("MARSDK", "mar auto permission success. goto next activity");
            MARPermissionActivity.this.startNextActivity();
        }

        @Override // com.mar.sdk.permission.IAutoPermissionListener
        public void onAutoPermissionFailed(String[] deniedPermissions, String[] deniedForeverPermissions) {
            Log.d("MARSDK", "mar auto permission failed. goto next activity");
            MARPermissionActivity.this.startNextActivity();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MARAutoPermission.getInstance().setAutoPermission(true);
        this.permissionLifeCycle = MARAutoPermission.getInstance().getPermissionLifeCycle();
        if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onCreate(this);
        }
        Log.d("MARSDK", "mar auto permission begin.");
        MARAutoPermission.getInstance().setDirectPermission(false);
        requestPermissions();
    }

    private void requestPermissions() {
        try {
            MARAutoPermission.getInstance().requestDangerousPermissions(this, this.permissionListener);
        } catch (Exception e) {
            startNextActivity();
            Log.e("MARSDK", "auto request permission failed. exception:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNextActivity() {
        try {
            Class<?> mainClass = Class.forName("com.mar.sdk.MarMainActivity");
            Intent intent = new Intent(this, mainClass);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        Log.d("MARSDK", "onNewIntent called in MARPermissionActivity");
        if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onNewIntent(this, newIntent);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        MARAutoPermission.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("MARSDK", "MARPermissionActivity onActivityResult");
        if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onActivityResult(this, requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    public void onStart() {
        Log.d("MARSDK", "MARPermissionActivity onStart");
        if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onStart(this);
        }
        super.onStart();
    }

    @Override // android.app.Activity
    public void onPause() {
        Log.d("MARSDK", "MARPermissionActivity onPause");
        if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onPause(this);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d("MARSDK", "MARPermissionActivity onResume");
        if (MARAutoPermission.getInstance().isJumpingPermission()) {
            Log.d("MARSDK", "permission return from permission page. request again to check permission");
            requestPermissions();
        } else if (MARAutoPermission.getInstance().isJumpingWriteSettings()) {
            Log.d("MARSDK", "permission return from write settings page. request again to check permission");
            MARAutoPermission.getInstance().requestWriteSettings(this);
        } else if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onResume(this);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Log.d("MARSDK", "MARPermissionActivity onStop");
        if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onStop(this);
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Log.d("MARSDK", "MARPermissionActivity onDestroy");
        if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onDestroy(this);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onRestart() {
        Log.d("MARSDK", "MARPermissionActivity onReStart");
        if (this.permissionLifeCycle != null) {
            this.permissionLifeCycle.onRestart(this);
        }
        super.onRestart();
    }
}
