/*
 * Copyright 2019, The Android Open Source Project
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

package com.example.jetpack.viewModel.step5;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.jetpack.R;

/**
 * Shows a SeekBar that should be synced with a value in a ViewModel.
 */
public class Fragment_step5 extends Fragment {
    private static final String TAG = "Fragment_step5";
    private SeekBar mSeekBar;
    private Fragment_step5 mFragment_step5;
    private SeekBarViewModel mSeekBarViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragment_step5 = this;
        View root = inflater.inflate(R.layout.fragment_step5, container, false);
        mSeekBar = root.findViewById(R.id.seekBar);

        // TODO: get ViewModel  这里是getActivity()
        mSeekBarViewModel = ViewModelProviders.of(getActivity()).get(SeekBarViewModel.class);
        subscribeSeekBar();

        return root;
    }

    private void subscribeSeekBar() {

        // Update the ViewModel when the SeekBar is changed.

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO: Set the ViewModel's value when the change comes from the user.
                Log.d(TAG, "onProgressChanged()   fromUser = [" + fromUser + "]" + ", "+ mFragment_step5.toString());
                if (fromUser) {
                    //TODO 注意 fromUser 的判断
                    Log.d(TAG, "Progress setValue " + mFragment_step5.toString());
                    mSeekBarViewModel.seekbarValue.setValue(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // TODO: Update the SeekBar when the ViewModel is changed.
         mSeekBarViewModel.seekbarValue.observe(this, new Observer<Integer>() {
             @Override
             public void onChanged(Integer integer) {
                 if (integer != null) {
                     Log.i(TAG, "onChanged: integer = "+ integer + ", "+ mFragment_step5.toString());
                     mSeekBar.setProgress(integer);
                 }
             }
         });
    }
}
