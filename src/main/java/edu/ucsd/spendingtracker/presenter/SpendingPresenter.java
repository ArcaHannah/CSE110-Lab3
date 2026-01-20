package edu.ucsd.spendingtracker.presenter;

import edu.ucsd.spendingtracker.model.Expense;
import edu.ucsd.spendingtracker.model.Model;
import edu.ucsd.spendingtracker.view.SpendingView;

public class SpendingPresenter {
    private final Model model;
    private final SpendingView view;

    public SpendingPresenter(Model model, SpendingView view) {
        this.model = model;
        this.view = view;
        updateView();
    }   

    public String getViewTitle() {
        return "Expenses";
    }

    public void updateView() {
        int i = 1;
        for(Expense e : model.getExpenses()) {
            view.addExpenseRow(i++, e.getName(), e.getCategory().name(), e.getCategory().color, e.getAmount());
        }
    }
}