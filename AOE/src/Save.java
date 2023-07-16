
import java.io.*;
import java.util.Locale;

public class Save {
    Game g;
    String filename;

    Save(Game g, String filename) {
        this.filename = filename;
        this.g = g;
    }
    public void save_binary() {

        try {
            ObjectOutputStream saving = new ObjectOutputStream(new FileOutputStream(filename));
            saving.writeObject(g);
            saving.close();
            System.out.println("Saving complate" + filename.toUpperCase(Locale.ROOT));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void save_text(){
        try {
            PrintWriter saving = new PrintWriter(new FileOutputStream(filename));
            saving.print(g);
            saving.close();
            System.out.println("Saving complate" + filename.toUpperCase(Locale.ROOT));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
