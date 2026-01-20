package edu.ucsd.spendingtracker;

import edu.ucsd.spendingtracker.datasource.InMemoryDataSource;
import edu.ucsd.spendingtracker.model.Model;
import edu.ucsd.spendingtracker.presenter.SpendingPresenter;
import edu.ucsd.spendingtracker.repository.ExpenseRepository;
import edu.ucsd.spendingtracker.view.SpendingView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        InMemoryDataSource dataSource = InMemoryDataSource.getDefaulDataSource();
        ExpenseRepository repository = new ExpenseRepository(dataSource);
        Model model = new Model(repository);
        SpendingView view = new SpendingView();
        SpendingPresenter presenter = new SpendingPresenter(model, view);

        primaryStage.setTitle("Spending Tickets");
        primaryStage.setScene(new Scene(view, 500, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}