import java.util.ArrayList;

public class BlockChain {

    private ArrayList<Block> chain;

    public BlockChain() {
        chain = new ArrayList<Block>();
    }

    public void add(Block b){
        chain.add(b);
    }

    public String patientView(String name)
    {
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        for(int i = 0;i<chain.size();i++)
        {
            if(chain.get(i).getReporter().equalsIgnoreCase(name))
                arr.addAll(chain.get(i).getData());
        }
        String output = "";
        for(int i = 0;i<arr.size();i++) {
            output+=arr.get(i).get(0) + ", " + arr.get(i).get(1) + ", " + arr.get(i).get(2) + ", " + arr.get(i).get(3) + ", " + arr.get(i).get(4) + ", " + arr.get(i).get(5) + "\n";
        }
        return output ;
    }

    public String docView(String patientName, String docName)
    {
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> tempArr;
        for(int i = 0;i<chain.size();i++)
        {
            if(chain.get(i).getReporter().equalsIgnoreCase(patientName) && chain.get(i).getPhyscians().contains(docName)) {
                tempArr = chain.get(i).getData();
                arr = tempArr;
                break;
            }
        }
        for(int i = 0;i<chain.size();i++)
        {
            if(chain.get(i).inBlock(patientName))
            {
                tempArr = chain.get(i).getData();
                for(int x = 0;x<tempArr.size();x++)
                {
                    if(Block.getNames(arr).contains(tempArr.get(x).get(0)))
                    {
                        int index=Block.getNames(arr).indexOf(tempArr.get(x).get(0));
                        if(!(arr.get(index).get(2).equalsIgnoreCase(tempArr.get(x).get(2))) && !(arr.get(index).get(2).equalsIgnoreCase("false")))
                            arr.get(index).set(2, "false");
                        if(arr.get(index).get(3) == null)
                            arr.get(index).set(3, tempArr.get(x).get(3));
                        else if(!(tempArr.get(x).get(3).toLowerCase().contains(arr.get(index).get(3).toLowerCase())))
                            arr.get(index).set(3, arr.get(index).get(3) + " / " + tempArr.get(x).get(3));
                        else if(!(arr.get(index).get(3).toLowerCase().contains(tempArr.get(x).get(3).toLowerCase())))
                            arr.get(index).set(3, tempArr.get(x).get(3) + " / " + arr.get(index).get(3));
                        if(arr.get(index).get(4) == null && tempArr.get(x).get(4) != null)
                            arr.get(index).set(4, tempArr.get(x).get(4));
                        if(!(arr.get(index).get(4) == null))
                            if(arr.get(index).get(4).contains("-")) {
                                arr.get(index).set(4, (Integer.parseInt(tempArr.get(x).get(4))) < Integer.parseInt(arr.get(index).get(4).substring(0,arr.get(index).get(4).indexOf("-"))) ?
                                        tempArr.get(x).get(4) + arr.get(index).get(4).substring(arr.get(index).get(4).indexOf("-")) :
                                        Integer.parseInt(tempArr.get(x).get(4)) > Integer.parseInt(arr.get(index).get(4).substring(arr.get(index).get(4).indexOf("-")+1)) ?
                                        arr.get(index).get(4).substring(0,arr.get(index).get(4).indexOf("-")+1) + tempArr.get(x).get(4) : arr.get(index).get(4));
                            }else if(tempArr.get(x).get(4).contains("-")) {
                                arr.get(index).set(4, (Integer.parseInt(arr.get(index).get(4))) < Integer.parseInt(tempArr.get(x).get(4).substring(0, tempArr.get(x).get(4).indexOf("-"))) ?
                                        arr.get(index).get(4) + tempArr.get(x).get(4).substring(tempArr.get(x).get(4).indexOf("-")) :
                                        Integer.parseInt(arr.get(index).get(4)) > Integer.parseInt(tempArr.get(x).get(4).substring(tempArr.get(x).get(4).indexOf("-") + 1)) ?
                                        tempArr.get(x).get(4).substring(0, tempArr.get(x).get(4).indexOf("-") + 1) + arr.get(index).get(4) : tempArr.get(x).get(4));
                            }else if(Integer.parseInt(arr.get(index).get(4)) != Integer.parseInt(tempArr.get(x).get(4)))
                                arr.get(index).set(4, Integer.parseInt(arr.get(index).get(4)) > Integer.parseInt(tempArr.get(x).get(4)) ? tempArr.get(x).get(4) + "-" +  arr.get(index).get(4) : arr.get(index).get(4) + "-" + tempArr.get(x).get(4));
                        if(arr.get(index).get(5) == null && tempArr.get(x).get(5) != null)
                            arr.get(index).set(5, tempArr.get(x).get(5));
                        if(!(arr.get(index).get(5) == null))
                            if(arr.get(index).get(5).contains("-")) {
                                arr.get(index).set(5, (Integer.parseInt(tempArr.get(x).get(5))) < Integer.parseInt(arr.get(index).get(5).substring(0,arr.get(index).get(5).indexOf("-"))) ?
                                        tempArr.get(x).get(5) + arr.get(index).get(5).substring(arr.get(index).get(5).indexOf("-")) :
                                        Integer.parseInt(tempArr.get(x).get(5)) > Integer.parseInt(arr.get(index).get(5).substring(arr.get(index).get(5).indexOf("-")+1)) ?
                                                arr.get(index).get(5).substring(0,arr.get(index).get(5).indexOf("-")+1) + tempArr.get(x).get(5) : arr.get(index).get(5));
                            }else if(tempArr.get(x).get(5).contains("-")) {
                                arr.get(index).set(5, (Integer.parseInt(arr.get(index).get(5))) < Integer.parseInt(tempArr.get(x).get(5).substring(0, tempArr.get(x).get(5).indexOf("-"))) ?
                                        arr.get(index).get(5) + tempArr.get(x).get(5).substring(tempArr.get(x).get(5).indexOf("-")) :
                                        Integer.parseInt(arr.get(index).get(5)) > Integer.parseInt(tempArr.get(x).get(5).substring(tempArr.get(x).get(5).indexOf("-") + 1)) ?
                                                tempArr.get(x).get(5).substring(0, tempArr.get(x).get(4).indexOf("-") + 1) + arr.get(index).get(4) : tempArr.get(x).get(5));
                            }else if(Integer.parseInt(arr.get(index).get(5)) != Integer.parseInt(tempArr.get(x).get(5)))
                                arr.get(index).set(5, Integer.parseInt(arr.get(index).get(5)) > Integer.parseInt(tempArr.get(x).get(5)) ? tempArr.get(x).get(5) + "-" +  arr.get(index).get(5) : arr.get(index).get(5) + "-" + tempArr.get(x).get(5));
                    }
                }
            }
        }
        String output = "";
        for(int i = 0;i<arr.size();i++)
        {
            output+=(arr.get(i).get(0).equalsIgnoreCase(patientName) ? patientName : ",") + (arr.get(i).get(1).equalsIgnoreCase("Brother") ? "1st Degree Relative" : arr.get(i).get(1).equalsIgnoreCase("Sister") ? "1st Degree Relative" :
                    arr.get(i).get(1).equalsIgnoreCase("Mother") ? "1st Degree Relative" : arr.get(i).get(1).equalsIgnoreCase("Father") ? "1st Degree Relative" :
                    arr.get(i).get(1).equalsIgnoreCase("Son") ? "1st Degree Relative" : arr.get(i).get(1).equalsIgnoreCase("Daughter") ? "1st Degree Relative" :
                    arr.get(i).get(1).toLowerCase().contains("grandfather") ? "2st Degree Relative" : arr.get(i).get(1).toLowerCase().contains("grandmother") ? "2st Degree Relative" :
                    arr.get(i).get(1).toLowerCase().contains("aunt") ? "2st Degree Relative" : arr.get(i).get(1).toLowerCase().contains("uncle") ? "2st Degree Relative" :
                    arr.get(i).get(1).toLowerCase().contains("grandaughter") ? "2st Degree Relative" : arr.get(i).get(1).toLowerCase().contains("grandson") ? "2st Degree Relative" :
                    arr.get(i).get(1).toLowerCase().contains("in-law") ? "2st Degree Relative" : arr.get(i).get(1).toLowerCase().contains("niece") ? "2st Degree Relative" :
                    arr.get(i).get(1).toLowerCase().contains("nephew") ? "2st Degree Relative" : arr.get(i).get(1).equalsIgnoreCase("Maternal Cousin") ? "3rd Degree Relative" :
                    arr.get(i).get(1).equalsIgnoreCase("Paternal Cousin") ? "3rd Degree Relative" : arr.get(i).get(1).toLowerCase().contains("great") ? "3rd Degree Relative" : ",") +
                    ", " + (arr.get(i).get(2).equalsIgnoreCase("false") ? "Passed" : "Alive") + (arr.get(i).get(3) == null ? "," : ", " + arr.get(i).get(3)) +
                    (arr.get(i).get(4) == null ? "," : ", " + arr.get(i).get(4)) + (arr.get(i).get(5) == null ? "," : ", " + arr.get(i).get(5)) + "\n";
        }
        return output.substring(0,output.length()-2);
    }

    public String toString(){
        String output="";
        for(Block b: chain)
            output+=b.toString()+"\n\n";
        return output;
    }
}
