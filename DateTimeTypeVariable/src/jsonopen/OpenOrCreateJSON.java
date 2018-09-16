package jsonopen;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class OpenOrCreateJSON {
	
	public static String lastedOpenFmain()
    {
		Date newdate = new Date();
        DateFormat newdf = new SimpleDateFormat("[dd/MM/yyyy - HH:mm]");
        String strLastedOpen="";
        String strnewdf = newdf.format(newdate);
        @SuppressWarnings("unused")
		JSONObject lastedOpen = new JSONObject();
        File js = new File("log\\lastedopen.json");
        if(js.exists())
        {
            try{
            Scanner input = new Scanner(js);
            StringBuilder jsonString = new StringBuilder();
            while(input.hasNext())
            {
                jsonString.append(input.nextLine());
            }
            input.close();
            JSONParser parser = new JSONParser();
            JSONObject rootIn = (JSONObject) parser.parse(jsonString.toString());
            JSONObject newRoot = new JSONObject();
            JSONArray lastedOpensArray = (JSONArray) rootIn.get("Lasted opens");
            lastedOpensArray.add(strnewdf);
            newRoot.put("Lasted opens", lastedOpensArray);
            //System.out.println(newRoot.toJSONString());
            try(PrintWriter writer2 = new PrintWriter(js))
            {
                writer2.write(newRoot.toJSONString());
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            strLastedOpen = (String) lastedOpensArray.get(lastedOpensArray.size()-1);
            return strLastedOpen;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        }
        else
        {
            JSONObject root1 = new JSONObject();
//            JSONObject nowObj = new JSONObject();
            JSONArray nowArray= new JSONArray();
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("[dd/MM/yyyy - HH:mm]");
            strLastedOpen = df.format(date);
//            nowObj.put("Opened", strLastedOpen);
            nowArray.add(strLastedOpen);
            root1.put("Lasted opens", nowArray);
            try(PrintWriter writer = new PrintWriter(js))
            {
                writer.write(root1.toJSONString());
                return strLastedOpen;
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return strLastedOpen;
    }
public static void main(String[] args) {
	System.out.println(lastedOpenFmain());
}
}
