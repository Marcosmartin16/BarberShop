package com.marramar.myapplication.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.marramar.myapplication.Citas;
import com.marramar.myapplication.EditarPerfil;
import com.marramar.myapplication.Musica;
import com.marramar.myapplication.NuevaCita;
import com.marramar.myapplication.R;
import com.marramar.myapplication.adapter.CitaAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerCitas;
    ArrayList<Citas> citas;
    Button nuevaCita,btEditar;
    private TextView tv1;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppointmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_profile,container,false);
        citas = new ArrayList<>();
        recyclerCitas = mView.findViewById(R.id.rvCitas);
        recyclerCitas.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        CitaAdapter adapter = new CitaAdapter(citas);
        recyclerCitas.setAdapter(adapter);

        nuevaCita = mView.findViewById(R.id.btNuevaCita);
        nuevaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NuevaCita.class);
                startActivity(intent);
            }
        });

        Button btMusica = mView.findViewById(R.id.btMusica);
        btMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Musica.class);
                startActivity(intent);
            }
        });

      btEditar = mView.findViewById(R.id.btEdProfile);
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditarPerfil.class);
                startActivity(intent);
            }
        });

        return mView;
    }

    //Cambiarlo para llenar con base de datos Mirar youtube
    private void llenarLista(){
        citas.add(new Citas("Marcos","10/5/2022","14:30",R.drawable.ic_check));
    }

    public void onNothingSelected(AdapterView<?> parent) {
        tv1.setText("");
    }
}