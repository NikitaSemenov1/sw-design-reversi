package reversi.interactors.validators;

import reversi.interactors.MenuInteractor;
import reversi.interactors.MenuInteractorStrings;

public class GameModeValidator implements Validator{
    @Override
    public boolean validate(String input) {
        return MenuInteractorStrings.VS_HUMAN.equals(input) || MenuInteractorStrings.VS_COMPUTER.equals(input) || MenuInteractorStrings.EXIT.equals(input);
    }
}
