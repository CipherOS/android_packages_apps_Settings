package com.android.settings.cipher.controllers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.UserHandle;

import androidx.preference.Preference;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;
import com.android.settings.slices.SliceBackgroundWorker;

import com.android.settingslib.core.lifecycle.LifecycleObserver;

public class TopLevelThemePreferenceController extends BasePreferenceController implements LifecycleObserver {

    private static final String KEY_TOP_LEVEL_THEME = "top_level_theme";
    private Context mContext;

    @Override
    public void copy() {
        super.copy();
    }

    @Override
    public Class<? extends SliceBackgroundWorker> getBackgroundWorkerClass() {
        return super.getBackgroundWorkerClass();
    }

    @Override
    public IntentFilter getIntentFilter() {
        return super.getIntentFilter();
    }

    @Override
    public boolean hasAsyncUpdate() {
        return super.hasAsyncUpdate();
    }

    @Override
    public boolean isCopyableSlice() {
        return super.isCopyableSlice();
    }

    @Override
    public boolean isPublicSlice() {
        return super.isPublicSlice();
    }

    @Override
    public boolean isSliceable() {
        return super.isSliceable();
    }

    @Override
    public boolean useDynamicSliceSummary() {
        return super.useDynamicSliceSummary();
    }

    public ComponentName getComponentName() {
        return new ComponentName(mContext.getString(R.string.config_wallpaper_picker_package),
                mContext.getString(R.string.config_styles_and_wallpaper_picker_class));
    }

    @Override
    public boolean handlePreferenceTreeClick(Preference preference) {
        if (getPreferenceKey().equals(preference.getKey())) {
            final Intent intent = new Intent().setComponent(getComponentName());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            preference.getContext().startActivity(intent);
            return true;
        }
        return super.handlePreferenceTreeClick(preference);
    }

    public TopLevelThemePreferenceController(Context context, String str) {
        super(context, str);
        mContext = context;
    }

    @Override
    public int getAvailabilityStatus() {
        return UserHandle.myUserId() != 0 ? UNSUPPORTED_ON_DEVICE : AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        return mContext.getString(R.string.theme_settings_summary);
    }
}
