import java.awt.*;
import java.awt.event.KeyEvent;

public class GamerRobot extends Robot {

    public GamerRobot() throws AWTException {
    }

    public void stringPress(String string){
        for(int i = 0; i < 5; i++){
            keyType(KeyEvent.getExtendedKeyCodeForChar(string.charAt(i)));
        }
        keyPress(KeyEvent.VK_SHIFT);
        keyType(KeyEvent.VK_SEMICOLON);
        keyRelease(KeyEvent.VK_SHIFT);
        for(int j = 6; j < string.length(); j++){
            keyType(KeyEvent.getExtendedKeyCodeForChar(string.charAt(j)));
        }
    }

    public void paste(){
        keyPress(KeyEvent.VK_CONTROL);
        keyType(KeyEvent.VK_V);
        keyRelease(KeyEvent.VK_CONTROL);
    }

    public void delete(int amount){
        for (int i = 0; i < amount; i++) {
            keyType(KeyEvent.VK_BACK_SPACE);
        }
    }

    private void keyType(int keyCode){
        keyPress(keyCode);
        keyRelease(keyCode);
    }

//    gamer.keyPress(KeyEvent.VK_SHIFT);
//    gamer.keyPress(KeyEvent.VK_SEMICOLON);


}
