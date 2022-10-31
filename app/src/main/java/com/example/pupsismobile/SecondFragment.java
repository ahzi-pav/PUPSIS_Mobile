package com.example.pupsismobile;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pupsismobile.databinding.FragmentSecondBinding;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Spinner daysSpinner;
    private Spinner yearsSpinner;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        daysSpinner = binding.daysSpinner;
        fillDaysSpinner();

        yearsSpinner = binding.yearSpinner;
        fillYearsSpinner();

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavHostFragment.findNavController(SecondFragment.this)
                        //.navigate(R.id.action_SecondFragment_to_FirstFragment);
                Intent intent = new Intent(getActivity(), AccountContent.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void fillDaysSpinner() {
        String[] daysArray = new String[31];

        for (int i = 0; i < 31; i++ ) {
            daysArray[i] = String.valueOf(i + 1);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, daysArray);
        adapter.setDropDownViewResource
                (androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        daysSpinner.setAdapter(adapter);
    }

    private void fillYearsSpinner() {
        String[] yearsArray = new String[113];

        int initialYear = 1900;

        for (int i = 0; i <= 112; i++) {
            yearsArray[i] = String.valueOf(initialYear);
            initialYear++;
        }

        Arrays.sort(yearsArray, Collections.reverseOrder());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, yearsArray);
        adapter.setDropDownViewResource
                (androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        yearsSpinner.setAdapter(adapter);
    }

}