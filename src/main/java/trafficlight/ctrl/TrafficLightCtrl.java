//Subjekt muss die Gui informieren wenn sich was ändert,
//schickt also updates raus und gui zeichnet neu
//oder TrafficLight von mir aus
package trafficlight.ctrl;

import trafficlight.Subject;
import trafficlight.gui.TrafficLight;
import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;

import java.awt.*;

public class TrafficLightCtrl extends Subject {

    private State greenState;

    private State redState;

    private State yellowState;

    private State currentState;

    private State previousState;

    private final TrafficLightGui gui;

    private boolean doRun = true;

    public TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        //TODO useful to update the current state

    }

    private void initStates() {
        greenState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                notifyObservers(currentState);
                //TODO useful to update the current state and the old one
                return yellowState;
            }

            @Override
            public String getColor() {
                return "green";
            }
        };

        redState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                notifyObservers(currentState);

                //TODO useful to update the current state and the old one
                return yellowState;
            }

            @Override
            public String getColor() {
                return "red";
            }
        };

        yellowState = new State() {
            @Override
            public State getNextState() {
                if (previousState.equals(greenState)) {
                    previousState = currentState;
                    notifyObservers(currentState);


                    //TODO useful to update the current state and the old one
                    return redState;
                } else {
                    previousState = currentState;
                    notifyObservers(currentState);

                    //TODO useful to update the current state and the old one
                    return greenState;
                }
            }

            @Override
            public String getColor() {
                return "yellow";
            }
        };
        currentState = greenState;
        previousState = yellowState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public void run() {
        int intervall = 1500;
        while (doRun) {
            try {
                Thread.sleep(intervall);
                nextState();
            } catch (InterruptedException e) {
                gui.showErrorMessage(e);
            }
        }
        System.out.println("Stopped");
        System.exit(0);
    }

    public void nextState() {
        currentState = currentState.getNextState();
    }

    public void stop() {
        doRun = false;
    }
}