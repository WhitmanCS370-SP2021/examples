public class ArraySubclassing {
    public static void main(String[] args) {
        String[] stringData = new String[3] {"Larry","Moe","Curly"};
        Object[] objectData = stringData;
        objectData[0] = new Integer(3);
    }
}
