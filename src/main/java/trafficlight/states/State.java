package trafficlight.states;

//TODO implement a part of the pattern here

import trafficlight.Subject;
import trafficlight.gui.TrafficLight;
import trafficlight.gui.TrafficLightGui;

public abstract class State{

    public abstract State getNextState();

    public abstract String getColor();

    public String getSting(){
        return getColor();
    }


}