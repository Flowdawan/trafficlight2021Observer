//https://github.com/Flowdawan/trafficlight2021Observer.git
import trafficlight.ctrl.TrafficLightCtrl;


public class MCP {
    public static void main(String[] args) {
        TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
        ctrl.run();
    }
}