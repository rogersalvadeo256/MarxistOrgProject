package view.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import application.main.Window;
import listeners.Close;


public class Initial extends Scene{

    private final Label messageLoginValidation;
    private Label lblSignIn, lblPassword, lblWelcome, lblUser;
    private TextField txtLogin;
    private PasswordField passwordField;
    private Button btnLogin, btnExit;
    private Button btnSignUp;
    private RadioButton btnStayConnected;
    private Label lblStayConnected;
    private HBox layoutContent, hbStayConnected;
    private Hyperlink forgotPassword, reactivateAccount;
    private VBox vbLogin;
    private AnchorPane layout;
    private ImageView imgIcon;

    private Tooltip toolLogin = new Tooltip();
    private Tooltip toolExit = new Tooltip();
    private Tooltip toolSignup = new Tooltip();

    public Initial() throws ClassNotFoundException {
        super(new HBox());

        this.getStylesheets().add(this.getClass().getResource("/css/LOGIN_SCENE.css").toExternalForm());

        Window.mainStage.setTitle("Tela Login");
        Window.mainStage.sizeToScene();

        this.layout = new AnchorPane();
        this.layoutContent = new HBox();


        this.vbLogin = new VBox();

        this.txtLogin = new TextField();
        this.txtLogin.setPromptText("Username");
        this.txtLogin.setAlignment(Pos.CENTER);
        this.passwordField = new PasswordField();
        this.passwordField.setAlignment(Pos.CENTER);

        this.txtLogin.setPromptText("Username");
        this.passwordField.setPromptText("Digite sua senha");

        this.lblUser = new Label("Username");
        this.lblPassword = new Label("Senha");

        this.lblWelcome = new Label("Bem Vindo Ao  Scrum Manager");
        this.lblSignIn = new Label("Entrar");

        this.lblWelcome.getStyleClass().add("title");
        this.lblSignIn.getStyleClass().add("title");

        toolLogin.setText("Fazer Login");
        toolExit.setText("Sair");
        toolSignup.setText("Cadastre-se");

        this.messageLoginValidation = new Label("Login ou senha incorretos");
        this.messageLoginValidation.setVisible(false);
        this.messageLoginValidation.setId("messageWrong");
        this.forgotPassword = new Hyperlink("Esqueci minha senha");
        this.reactivateAccount = new Hyperlink("Reativar conta");

        this.btnStayConnected = new RadioButton();
        this.lblStayConnected = new Label("Mantenha-me conentado");
        this.hbStayConnected = new HBox();
        this.hbStayConnected.getChildren().addAll(btnStayConnected, lblStayConnected);

        this.btnLogin = new Button("LOGIN");
        this.btnExit = new Button("SAIR");
        this.btnSignUp = new Button("Cadastre-se");

        this.btnExit.setId("exitbtn");
        this.btnSignUp.setId("btnSingUp");

        btnLogin.setTooltip(toolLogin);
        btnExit.setTooltip(toolExit);
        btnSignUp.setTooltip(toolSignup);

        this.imgIcon = new ImageView();

        this.imgIcon.setFitWidth(200);
        this.imgIcon.setFitHeight(200);

        this.layout.setPrefHeight(450);
        this.layout.setPrefWidth(300);

        this.txtLogin.setOnMouseClicked(e -> {
            this.messageLoginValidation.setVisible(false);
        });
        this.passwordField.setOnMouseClicked(e -> {
            this.messageLoginValidation.setVisible(false);
        });




        this.btnSignUp.setOnAction(e -> {
            this.layoutContent.getChildren().clear();
            this.getWindow().setWidth(300);
            this.getWindow().setHeight(700);
        });


        this.btnExit.setOnAction(new Close(Window.mainStage));

        this.imgIcon.setId("logoImage");

        HBox.setHgrow(txtLogin, Priority.ALWAYS);
        HBox.setHgrow(passwordField, Priority.ALWAYS);
        HBox.setHgrow(btnLogin, Priority.ALWAYS);
        HBox.setHgrow(btnExit, Priority.ALWAYS);
        this.txtLogin.setMaxWidth(Double.MAX_VALUE);
        this.passwordField.setMaxWidth(Double.MAX_VALUE);
        this.btnExit.setMaxWidth(Double.MAX_VALUE);
        this.btnLogin.setMaxWidth(Double.MAX_VALUE);

        this.vbLogin.getChildren().addAll(lblUser, txtLogin, lblPassword);
        this.vbLogin.getChildren().addAll(passwordField, messageLoginValidation, forgotPassword, reactivateAccount,
                hbStayConnected, btnLogin, btnExit, btnSignUp);

        VBox.setVgrow(vbLogin, Priority.ALWAYS);
        this.vbLogin.setMaxWidth(Double.MAX_VALUE);
        this.vbLogin.setMaxHeight(Double.MAX_VALUE);
        this.vbLogin.setAlignment(Pos.CENTER);

        this.vbLogin.setSpacing(5);

        this.layoutContent.setAlignment(Pos.CENTER);

        AnchorPane.setTopAnchor(vbLogin, 10d);
        AnchorPane.setLeftAnchor(vbLogin, 10d);
        AnchorPane.setRightAnchor(vbLogin, 10d);
        AnchorPane.setBottomAnchor(vbLogin, 10d);
        vbLogin.setId("fundo");

        AnchorPane.setTopAnchor(this.layoutContent, 0.0);
        AnchorPane.setLeftAnchor(this.layoutContent, 0.0);
        AnchorPane.setRightAnchor(this.layoutContent, 0.0);
        AnchorPane.setBottomAnchor(this.layoutContent, 0.0);
        this.layout.getChildren().add(layoutContent);

        this.setRoot(layout);
    }


}
