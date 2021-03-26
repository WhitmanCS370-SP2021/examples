import java.util.ArrayList;

class Switch {
    private boolean on = false;
    public void toggle()             { on = !on; }
    public boolean isOn()            { return on; }
}

class FourWaySwitch extends Switch {
    private int state = 0;
    public void toggle()             { state = (state+1) % 4; }
    public boolean isOn()            { return state > 0; }
    public boolean isOn(int lightno) { return (lightno & state) > 0; }
}

public class Switches {
    public static void main(String[] args) {
        ArrayList<Switch> bedroom = new ArrayList<>();
        Switch overheadLight = new Switch();
        FourWaySwitch bedsideLight = new FourWaySwitch();
        bedroom.add(bedsideLight);
        bedroom.add(overheadLight);
        for (Switch s : bedroom) {
            s.toggle();
            s.toggle();
            System.out.println(s.isOn());
        }
    }
}
