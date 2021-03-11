# ProjectWork
Alpamys Primkulov, Abzal Bissembayev, Abzal Kalibayev
The client is greeted with an authorization window where he must enter his username and password. If it is correct, the window will change to the profile window. There, he will have access to his balance,deposit, and loan balance. The client can transfer money to another account using the Transfer window, and can also repay the loan ahead of time if he has enough money
Classes: 9 ( 2 interface)
PostgresDB: returns connection to database;
User: main entity class with all client info.
FLogin,FProfile,FTransfer: JFrame windows, UI elements
LoginRepositories: Database queries
ImagePanel: JPanel that can change background image of JFrame
Controller: Controller between UI and data
Main: Initializer
