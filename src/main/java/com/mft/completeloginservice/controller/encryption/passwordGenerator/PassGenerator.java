package com.mft.completeloginservice.controller.encryption.passwordGenerator;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class PassGenerator {

    public static String passWordGenerator() {
        CharacterRule lowerCaseRule = new CharacterRule(EnglishCharacterData.LowerCase);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterRule upperCaseRule = new CharacterRule(EnglishCharacterData.UpperCase);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterRule digitRule = new CharacterRule(EnglishCharacterData.Digit);
        digitRule.setNumberOfCharacters(2);

//        CharacterRule specialRule = new CharacterRule(EnglishCharacterData.Special);
//        specialRule.setNumberOfCharacters(2);




        PasswordGenerator passwordGenerator = new PasswordGenerator();

        String password = passwordGenerator.generatePassword(
                10
                , lowerCaseRule
                , upperCaseRule
                , digitRule);


        return password;
    }
}
