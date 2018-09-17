package com.shushper.loftmoneyaug18;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BalanceFragment extends Fragment {

    public static BalanceFragment newInstance() {

        Bundle args = new Bundle();
        
        BalanceFragment fragment = new BalanceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Api api;
    private TextView expense;
    private TextView income;
    private TextView balance;
    private DiagramView diagramView;

    public BalanceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        api = ((App) getActivity().getApplication()).getApi();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_balance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expense = view.findViewById(R.id.expense_value);
        income = view.findViewById(R.id.income_value);
        balance = view.findViewById(R.id.balance_value);
        diagramView = view.findViewById(R.id.diagram);

        updateData();
    }

    private void updateData() {
        int expense = 45000;
        int income = 20000;
        int balance = 67000;

        this.expense.setText(String.valueOf(expense));
        this.income.setText(String.valueOf(income));
        this.balance.setText(String.valueOf(balance));

        diagramView.update(income, expense);
    }
}
