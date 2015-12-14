package de.qudosoft.praktikum;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jburmester on 14.12.2015.
 */
public class TokenReader {

    public List<Object> tokenize(String s) {
        List<Object> tokens = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            int start;
            int finish;
            if (s.charAt(i) != ' ') {
                start = i;
                if (s.charAt(i) == ' ') {
                    finish = i-1;
                    tokens.add(s.substring(start, finish));
                }else{
                    finish = s.length();
                    tokens.add(s.substring(start, finish));
                    break;
                }
            }
        }
        return tokens;
    }
}
