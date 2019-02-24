import java.util.ArrayList;

public class Block {
    private int index;
    private ArrayList<ArrayList<String>> data;
    private ArrayList<String> physcians;

    public Block(int i, ArrayList<ArrayList<String>> d, ArrayList<String> phys) {
        index = i;
        data = d;
        physcians = phys;
    }

    public String getReporter()
    {
        for(int r = 0;r<data.size();r++)
        {
            if(data.get(r).get(1).equalsIgnoreCase("self"))
                return data.get(r).get(0);
        }
        return "";
    }

    public static ArrayList<String> getNames(ArrayList<ArrayList<String>> stuff) {
        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0;i<stuff.size();i++)
            arr.add(stuff.get(i).get(0));
        return arr;
    }

    public Boolean inBlock(String name)
    {
        for(int r = 0;r<data.size();r++)
        {
            if(data.get(r).get(0).equalsIgnoreCase(name) && !(data.get(r).get(1).equalsIgnoreCase("self")))
                return true;
        }
        return false;
    }

    public ArrayList<String> getPhyscians(){    return physcians;    }

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    public String toString(){
        String output = "Index: " + index + "\nData:";
        for(int i = 0;i<data.size()-1;i++)
            output+=data.get(i).toString() + ",\n";
        return output + data.get(data.size()-1).toString();
    }
}
