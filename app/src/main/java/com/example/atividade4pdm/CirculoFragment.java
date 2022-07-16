package com.example.atividade4pdm;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CirculoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CirculoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText editRaio;
    private Button btnCalculaCirculo;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CirculoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CirculoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CirculoFragment newInstance(String param1, String param2) {
        CirculoFragment fragment = new CirculoFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_circulo, container, false);

        editRaio = view.findViewById(R.id.editRaio);
        btnCalculaCirculo = view.findViewById(R.id.btnCalculaCirculo);

        btnCalculaCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editRaio.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    double raio = Double.parseDouble(editRaio.getText().toString());
                    double pi = 3.14;
                    double areaCirc = pi * (Math.pow(raio,2));

                    AlertDialog.Builder resul = new AlertDialog.Builder(getActivity());
                    resul.setTitle("Resultado!");
                    String saida = String.format("A área do círculo é de: %.2f", areaCirc);
                    resul.setMessage(saida);
                    resul.show();

                    editRaio.setText("");
                }
            }
        });
        return view;
    }
}