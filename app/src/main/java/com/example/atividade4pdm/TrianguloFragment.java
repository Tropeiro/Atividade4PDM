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
 * Use the {@link TrianguloFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrianguloFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText editBase, editAltura;
    private Button btnCalculaTriangulo;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TrianguloFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrianguloFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrianguloFragment newInstance(String param1, String param2) {
        TrianguloFragment fragment = new TrianguloFragment();
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
        View view = inflater.inflate(R.layout.fragment_triangulo, container, false);

        editBase = view.findViewById(R.id.editBase);
        editAltura = view.findViewById(R.id.editAltura);
        btnCalculaTriangulo = view.findViewById(R.id.btnCalculaTriangulo);

        btnCalculaTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editBase.getText().toString().isEmpty() || editAltura.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    double base = Double.parseDouble(editBase.getText().toString());
                    double altura = Double.parseDouble(editAltura.getText().toString());

                    double areaTri = (base*altura)/2;

                    AlertDialog.Builder resul = new AlertDialog.Builder(getActivity());
                    resul.setTitle("Resultado!");
                    String saida = String.format("A área do triângulo é de: %.1f", areaTri);
                    resul.setMessage(saida);
                    resul.show();

                    editAltura.setText("");
                    editBase.setText("");
                }
            }
        });

        return view;
    }
}