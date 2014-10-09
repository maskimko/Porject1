/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.project1.lib.routelibrary;

/**
 *
 * @author maskimko
 */
public class Converter {
     public static String macToString(byte[] mac){
          StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int b : mac) {
            sb.append(String.format("%02X", b & 0xff));
            if (counter < 5) {
                sb.append(":");
            }
            counter++;
        }
        return sb.toString();
     }
}
