package Google_Translate.google_translate;

import java.io.IOException;

import com.darkprograms.speech.translator.GoogleTranslate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	System.out.println("Tiếng nhật:" + GoogleTranslate.translate("vi", "hello"));
    	new Text_To_Speech("Tiếng nhật");
    }
}
