/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainq6;

/**
 *
 * @author xianp
 */
public class calculate extends remove{
    public void find(){
        boolean[] is_digit=new boolean[data[0].length];
        for (int i = 0; i < is_digit.length; i++) {
            is_digit[i]=true;
        }
        
        for (int i = 1; i< data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                for (int k = 0; k < data[i][j].length(); k++) {
                    if(Character.isLetter(data[i][j].charAt(k))==true&& !data[i][j].equals(" ")){
                        is_digit[j] = false;
                        break;
                    }
                } 
            }
        }
        for (int i = 0; i < is_digit.length; i++) {
            System.out.println(is_digit[i]);
        }
    }
}
