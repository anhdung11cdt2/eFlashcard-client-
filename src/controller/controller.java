/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.View;
import model.Library;
import view.view2;
/**
 *
 * @author Welcome
 */
public class controller {
    public view2 view;
    public Library lib;
    public int index;
    
    public controller(view2 view, Library lib) {
        this.view = view;
        this.lib = lib;
        index = 0;
        view.setWord(lib.getWord(index).name);
        view.setMean(lib.getWord(index).meaning);
        view.actionNext(new nextWord());
        view.actionPrev(new prevWord());
        view.changeShowMean(new changeShowMean());
        view.showMean(true);
        view.checkShowMean(true);
    }
    
    class nextWord implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (index == lib.getLength()-1){
                index = 0;
            } else {
                index++;
            }
            view.setWord(lib.getWord(index).name);
            view.setMean(lib.getWord(index).meaning);
        }
    }
    
    class prevWord implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (index == 0){
                index = lib.getLength()-1;
            } else {
                index--;
            }
            view.setWord(lib.getWord(index).name);
            view.setMean(lib.getWord(index).meaning);
        }
    }
    
    class changeShowMean implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            if (view.isShowMean()){
                view.showMean(true);
            } else {
                view.showMean(false);
            }
        }
        
    }
}
