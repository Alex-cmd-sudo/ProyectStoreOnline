package com.example.proyectsoreonline.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.proyectsoreonline.R;

public class LoadingDialog extends DialogFragment {
    public static final String TAG = LoadingDialog.class.getCanonicalName();
    private DismissListener mDismissListener;
    private boolean isBackEnabled;

    public static LoadingDialog show(@NonNull FragmentManager fm) {
        Log.i("Tag:",TAG);
        LoadingDialog loadingDialog = (LoadingDialog) fm.findFragmentByTag(TAG);
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog();
        }
        loadingDialog.isBackEnabled = false;
        if (!loadingDialog.isAdded()) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(loadingDialog, TAG);
            ft.commitAllowingStateLoss();
            //loadingDialog.show(fm, TAG);
        }
        return loadingDialog;
    }

    public void setDismissListener(DismissListener dismissListener) {
        if (dismissListener != null) {
            isBackEnabled = true;
        }
        mDismissListener = dismissListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Context context = getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View rootView = inflater.inflate(R.layout.dialog_fragment_loading, null, false);
        LottieAnimationView lottieAnimationView = rootView.findViewById(R.id.lav_loading);
        lottieAnimationView.setImageAssetsFolder( "assets/");
        lottieAnimationView.setAnimation("animation.json");
        lottieAnimationView.setRepeatCount(LottieDrawable.INFINITE);
        lottieAnimationView.playAnimation( );

        final AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.WhiteTransparentDialog);
        builder.setView(rootView)
                .setCancelable(false);
        // Create the AlertDialog object and return it
        final Dialog alertDialog = builder.create();

        alertDialog.setCanceledOnTouchOutside(false);
        //if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { alertDialog.getWindow().setNavigationBarColor(getResources().getColor(R.color.color_black)); }

        alertDialog.setOnKeyListener((arg0, keyCode, event) -> {
            if ((keyCode == KeyEvent.KEYCODE_BACK) && (event.getAction() == KeyEvent.ACTION_UP)) {
                if (isBackEnabled) {
                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Espere un momento…", Toast.LENGTH_SHORT).show();
                }
            }
            return true;
        });
        alertDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        alertDialog.getWindow().setNavigationBarColor(ContextCompat.getColor(context,  R.color.blanco ));
        return alertDialog;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mDismissListener != null) {
            mDismissListener.onDismiss();
        }
    }

    public interface DismissListener {
        void onDismiss();
    }

    @Override
    public void dismiss() {
        if (getFragmentManager() != null)
            dismissAllowingStateLoss();
    }
}
