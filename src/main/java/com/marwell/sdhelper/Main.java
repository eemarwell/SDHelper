package com.marwell.sdhelper;

import com.marwell.sdhelper.dao.AgenteDAO;
import com.marwell.sdhelper.dao.ClipboardDAO;
import com.marwell.sdhelper.model.Agente;
import com.marwell.sdhelper.model.Clipboard;
import com.marwell.sdhelper.utils.GerenciadorStage;
import com.marwell.sdhelper.utils.VerificaChatTimer;
import javafx.application.Application;
import javafx.stage.Stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Eduardo Marwell
 */
@SpringBootApplication
public class Main extends Application {
	String TITULO = "HeinekenSD Helper";
	private static Stage pStage;
	GerenciadorStage iniciador;

	@Override
	public void start(Stage stage) throws Exception {
		iniciador = new GerenciadorStage(stage,TITULO,"MainWindow.fxml");
		setPrimaryStage(stage);
		pStage = stage;

		//new VerificaChatTimer().executarTimer();

/*		Agente user = new Agente(1, "Eduardo", "123456", false, true);
		Agente user1 = new Agente(0, "Daniel", "123121", true, false);
		user.setId(1L);
        AgenteDAO dao = new AgenteDAO();
        AgenteDAO dao1 = new AgenteDAO();
        AgenteDAO dao2 = new AgenteDAO();
		dao.add(user);
		dao1.add(user1);
		List<Agente> users = dao2.buscaBacklog(user);
		users.forEach(u-> {
		    System.out.println(u.getName());
		});
		System.out.println(users.size());*/

		//Clipboard
//        Clipboard clip1 = new Clipboard();
        ClipboardDAO daoclip1 = new ClipboardDAO();
//        clip1.setId(3L);
//        daoclip1.add(clip1);


        List<Clipboard> users = daoclip1.buscaClipboards(Clipboard.class);
        users.forEach(u-> {
            System.out.println(u.getClipboardString());
        });
        System.out.println(users.size());

	}

	public static void main(String[] args) {
		launch(args);
		SpringApplication.run(Main.class, args);
	}

	public static Stage getPrimaryStage() {
		return pStage;
	}

	private void setPrimaryStage(Stage pStage) {
		Main.pStage = pStage;
	}

}
