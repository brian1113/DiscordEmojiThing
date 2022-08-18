import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;



public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException {



        Map<String, String> gifs = Map.ofEntries(
                Map.entry("test", "https://cdn.discordapp.com/emojis/857088305149640724.gif?size=48")
        );

        GamerRobot gamer = new GamerRobot();



        Thread.sleep(5000);

        //String command = ":command:";

        String link = gifs.get("test");
        StringSelection stringSelection = new StringSelection(link);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        gamer.paste();


        //gamer.delete(100);
        //gamer.stringPress(gifs.get("test"));
        // error is that robot can't print colon ";"
        // solution: gamer.keyPress(KeyEvent.VK_SHIFT);
        //        gamer.keyPress(KeyEvent.VK_SEMICOLON);

        try{
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new KeyLogger(gifs));


    }
}

