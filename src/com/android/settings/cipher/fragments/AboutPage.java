/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.cipher.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.search.SearchIndexable;

@SearchIndexable
public class AboutPage extends DashboardFragment {

    public static final String TAG = "AboutPage";

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.CIPHER;
    }

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.about_page;
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        super.onCreatePreferences(savedInstanceState, rootKey);
        final PreferenceScreen screen = getPreferenceScreen();
        if (screen == null) {
            return;
        }
        final int count = screen.getPreferenceCount();
        for (int i = 0; i < count; i++) {
            final Preference preference = screen.getPreference(i);
            if (preference == null) {
                break;
            }
            if ("cipher_version".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_with_logo_top);
            }
            if ("cipher_status".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_with_logo_middle);
            }
            if ("cipher_maintainer".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_with_logo_bottom);
            }
            if ("cipher_about_spacer".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_spacer);
            }
            if ("cipher_model".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_top);
            }
            if ("cipher_firmware_version".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_middle);
            }
            if ("cipher_security_key".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_middle);
            }
            if ("cipher_base_band".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_middle);
            }
            if ("cipher_kernel_version".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_kernel);
            }
            if ("cipher_selinux_status".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_middle);
            }
            if ("cipher_build_date".equals(preference.getKey())){
                preference.setLayoutResource(R.layout.cipher_about_bottom);
            }
        }
    }

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider(R.xml.about_page);
}
