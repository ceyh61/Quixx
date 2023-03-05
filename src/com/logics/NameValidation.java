package com.logics;

public class NameValidation {

    private int nameEmptyCheck = 0;
    private int nameLengthCheck = 0;
    private int nameCharacterCheck = 0;
    
    protected NameValidation () {
    }

    protected String checkPlayerInput (String Name) {
        String answer = "";
        // checks if name entry is empty or not
        if (Name.isEmpty()) {
            nameEmptyCheck = 1;
            answer = "Name field can't be Empty";
        }
        if (!Name.isEmpty()) {
            if (!isName_Length_Valid(Name)) {
                nameLengthCheck = 1;
                answer = "Name can contain only 1 to 10 characters";
            }
            if (isName_Length_Valid(Name)) {
                if (!isName_Character_Valid(Name)) {
                    nameCharacterCheck = 1;
                    answer = "Name can only contain letters";
                }
                if (isName_Character_Valid(Name)) {
                    answer = "";
                }
            }
        }

        // add all the above integer value to see if all conditions are meet
        // if total is zero the all conditions are meet else not
        int totalCheck = nameEmptyCheck + nameLengthCheck + nameCharacterCheck;

        // if there are no mistake found!
        if (totalCheck == 0) {
            answer = "Player Registred Successfully!";
        }
        // if there is at least one mistake found!
        else if (totalCheck != 0) {
            answer = ""+"!";
        }
        return answer;
    }

    // checks if the user input has meet the conditions
    // Player name can only have max. 10 letters
    protected boolean isName_Length_Valid (String playerName) {
        boolean b = false;
        int nameLength = playerName.length();
            //checks if name length has max. 10 letter
            if (  (nameLength <= 10) && (nameLength > 0) ) {
                b = true;
            }
        return b;
    }

    // checks if the player name input has correct datatype
    // Name: only letters are allowed (no number, no space, no symbol) 
    protected boolean isName_Character_Valid (String playerName) {
        boolean b = false;
        int count = 0;
        for (int i = 0; i < playerName.length(); i++) {
            // checks if the user ID contains only numbers
            if ( !Character.isLetter(playerName.charAt(i)) ) {
                count++;
            }
        }
        if (count == 0) {
            b = true;
        }
        if (count > 0) {
            b = false;
        }
        return b;
    }

    
}