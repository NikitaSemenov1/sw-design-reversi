package reversi.interactors.validators;

import reversi.interactors.MenuInteractorStrings;

/**
 * Class validating GameMode command input. Implements Validator interface
 */
public class GameModeValidator implements Validator {
    @Override
    public boolean validate(String input) {
        return MenuInteractorStrings.VS_HUMAN.equals(input) || MenuInteractorStrings.VS_COMPUTER.equals(input) || MenuInteractorStrings.EXIT.equals(input);
    }
}
