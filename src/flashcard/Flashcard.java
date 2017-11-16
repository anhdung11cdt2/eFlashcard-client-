/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcard;

import model.Library;
import view.view1;
import view.view2;
import controller.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.*;
import java.io.File;
/**
 *
 * @author Welcome
 */
public class Flashcard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Load list lib
        // doan nay t load ra cai list rồi, h tạo cái view để hiện cái list này lên, mỗi  thằng click vào thì load
//        ArrayList<Library> libs = new ArrayList<>();
//         try{
//        URL url = new URL("http://159.89.202.84:8080/api/sets?user_id=rmIh9UFwfDFFLQepx3jr");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setDoOutput(true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String m = "";
//            String inputLine;
//            while ((inputLine = in.readLine()) != null){
//               m += inputLine + "\n";
//            }
//            System.out.println(m);
//            JSONObject json = new JSONObject(m);
//            System.out.println(json.getString("message"));
//            JSONArray libss = json.getJSONArray("resources");
//            for (int i = 0; i< json.getJSONArray("resources").length(); i++){
//                System.out.println(libss.getJSONObject(i).getString("Id"));
//            }
//            in.close();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
        File file = new File("1.csv");
        Library library1 = new Library("lib1", file);
        //library1.loadLibrary("8AyqBmQpncbKnjIYNRWD");
        view1 view1 = new view1();
        view2 view2 = new view2();
        controller con = new controller(view2, library1);
        view2.setVisible(true);

    }
}
