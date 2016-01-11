package de.htwg.se.wizard.control.gamestate.impl.PreparingState;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.impl.GameState;

import java.util.List;

/**
 * Created by Jan on 30.12.2015.
 */
public class PreparingState extends GameState {

    private static final int MAX_COUNT = 6;

    IState preparingState;


    public PreparingState(GameControl controller) {
        super(controller);

        preparingState = new PlayerCountSubState(this, MAX_COUNT);
        System.out.println("Construktor PreparingState");
    }


    public void handle() {

        System.out.println("handle PreparingState");

        this.controller.updateObserver();
    }

    @Override
    public void handleUserInput(String userInput) {
        this.preparingState.handleUserInput(userInput);
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        controller.setNumberOfPlayers(numberOfPlayers);

        System.out.printf("PreparingState - SetNumberofPlayers: %d%n", controller.getNumberOfPlayers());
    }

    public void setSubState(IState subState) {
        System.out.println("setSubState");
        this.preparingState = subState;

        this.controller.updateObserver();


    }

    public int getCountOfPlayer() {
        return this.controller.getNumberOfPlayers();
    }

    public void setNameOfPlayers(String[] NamesOfPlayers){
        System.out.println("Names");
        for (String name : NamesOfPlayers) {
            System.out.println(name);
        }
        //this.controller.setGameState();
        System.out.println("SetGameState");
    }


    public IState getSubState() {
        return this.preparingState;
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public String toString() {
        return "PREPARING";
    }

}


