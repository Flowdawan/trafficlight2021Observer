package trafficlight;

import trafficlight.gui.TrafficLight;
import trafficlight.states.State;


public interface Observer {

    void update(State o);

}


