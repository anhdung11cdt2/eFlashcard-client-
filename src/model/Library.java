/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Welcome
 */
public class Library {
    public String name;
    public ArrayList<Word> words;
    public String id;
    
    public Library(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Word getWord(int index){
        return words.get(index);
    }
    
    public void loadLibrary(String id){
        //8AyqBmQpncbKnjIYNRWD
        this.name = id;
        List<Word> result = new ArrayList<>();
        try{
        URL url = new URL("http://159.89.202.84:8080/api/words-file?set_id=" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                String line = inputLine;
                System.out.println(line);
                String[] tmp = line.split(",");
                Word tmpWord = new Word(tmp[0], tmp[2]);
                result.add(tmpWord);
            }
            in.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        this.words = new ArrayList<>(result);
    }
    
    public int getLength(){
        return words.size();
    }
    
    public Library(String name, File file){
        this.name = name;
        List<Word> result = new ArrayList<>();
        
        try {
            Scanner input = new Scanner(file);
            
            while (input.hasNext()){
                String line = input.nextLine();
                System.out.println(line);
                String[] tmp = line.split(",");
                Word tmpWord = new Word(tmp[0], tmp[1]);
                result.add(tmpWord);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        this.words = new ArrayList(result);
    }
}
