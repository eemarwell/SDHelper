package com.marwell.sdhelper.utils;

import com.marwell.sdhelper.model.types.ClipboardEnum;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;

/**
 *
 * @author Eduardo Marwell
 */
public class ClipboardUtil {
    private static int threadsAtivas = 0;
    
    public static boolean copiaClipboard(ClipboardEnum clipboarded){
        final javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();

        content.putString(clipboarded.getClipboard());
        clipboard.setContent(content);
        return true;
    }
    
    public static boolean copiaBotao(Button button, Long waitTime, String originalText) {
        if (threadsAtivas > 0) {
            button.setText("Aguarde!");
            button.setDisable(true);
            Task<Void> timer = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(waitTime);
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            timer.setOnSucceeded((WorkerStateEvent event) -> {
                button.setText(originalText);
                button.setDisable(false);
            });
            new Thread(timer).start();
            return false;
        } else {
            threadsAtivas = 1;
            button.setText("Copiado!");
            button.setDisable(true);
            Task<Void> timer = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(waitTime);
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            timer.setOnSucceeded((WorkerStateEvent event) -> {
                button.setText(originalText);
                button.setDisable(false);
                threadsAtivas = 0;
            });
            new Thread(timer).start();
            return true;
        }
    }
}
