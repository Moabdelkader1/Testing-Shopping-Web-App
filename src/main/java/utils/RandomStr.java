package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStr {



    public String randomize(int len,Boolean useLetters,Boolean useNumbers){
        return RandomStringUtils.random(len, useLetters, useNumbers);

    }
}
