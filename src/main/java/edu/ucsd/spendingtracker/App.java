package edu.ucsd.spendingtracker;

import edu.ucsd.spendingtracker.datasource.InMemoryDataSource;
import edu.ucsd.spendingtracker.model.Model;
import edu.ucsd.spendingtracker.presenter.SpendingPresenter;
import edu.ucsd.spendingtracker.presenter.PresenterManager;
import edu.ucsd.spendingtracker.presenter.SummaryPresenter;
import edu.ucsd.spendingtracker.repository.ExpenseRepository;
import edu.ucsd.spendingtracker.view.SpendingView;
import edu.ucsd.spendingtracker.view.SummaryView;
import javafx.application.Application;
//import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        InMemoryDataSource dataSource = InMemoryDataSource.getDefaulDataSource();
        ExpenseRepository repository = new ExpenseRepository(dataSource);
        Model model = new Model(repository);
        SpendingView view = new SpendingView();
        SummaryView summaryView = new SummaryView();
        SpendingPresenter presenter = new SpendingPresenter(model, view);
        SummaryPresenter summaryPresenter = new SummaryPresenter(model, summaryView);

        PresenterManager presenterManager = new PresenterManager();
        presenterManager.defineInteractions(primaryStage, "Spending Tickets", presenter, summaryPresenter);
    }

    public static void main(String[] args) {
        launch(args);
    }
}