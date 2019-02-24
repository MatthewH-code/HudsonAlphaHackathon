import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BlockChainRunner {
    public static void main(String[] args)
    {
        BlockChain bob = new BlockChain();
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>() {{add(new ArrayList<String>(Arrays.asList("Charles", "self", "true", "Diabetes: Type 2", "44", null)));
                add(new ArrayList<String>(Arrays.asList("Sarah", "Sister", "true", "Diabetes: Type 1", "3", null)));
                add(new ArrayList<String>(Arrays.asList("John", "Father", "false", "Cancer: Bone Cancer", "58", "32")));
                add(new ArrayList<String>(Arrays.asList("Sherry", "Mother", "true", "Hypertension", "59", null)));
                add(new ArrayList<String>(Arrays.asList("Sam", "Son", "false", "Cancer: leukemia", "5", "7")));
                add(new ArrayList<String>(Arrays.asList("Gerald", "Paternal Grandfather", "false", "Clotting Disorder: Deep Vein Thrombosis", "71", "71")));
                add(new ArrayList<String>(Arrays.asList("Edna", "Paternal Grandmother", "false", "Cancer: Stomach", "77", "78")));
                add(new ArrayList<String>(Arrays.asList("Caroline", "Maternal Grandfather", "false", "Heart Disease: Aortic Dissection", "51", "53")));
                add(new ArrayList<String>(Arrays.asList("Fred", "Maternal Grandfather", "true", "Cancer: Thyroid", "60", null)));
                add(new ArrayList<String>(Arrays.asList("Sally", "Maternal Aunt", "true", null, "44", null)));
                add(new ArrayList<String>(Arrays.asList("George", "Maternal Cousin", "true", null, "44", null)));
        }};
        bob.add(new Block(0, arr, new ArrayList<String>(Arrays.asList("Thomas"))));
        arr = new ArrayList<ArrayList<String>>() {{
                add(new ArrayList<String>(Arrays.asList("Charles", "Maternal Cousin", "true", "Diabetes: Type 2", "44", null)));
                add(new ArrayList<String>(Arrays.asList("Sarah", "Maternal Cousin", "true", "Diabetes: Type 1", "2", null)));
                add(new ArrayList<String>(Arrays.asList("John", "Maternal Uncle", "false", "Cancer: Bone Cancer", "58", "32")));
                add(new ArrayList<String>(Arrays.asList("Sherry", "Maternal Aunt", "true", "Hypertension", "70", null)));
                add(new ArrayList<String>(Arrays.asList("Caroline", "Maternal Grandfather", "false", "Heart Disease: Aortic Dissection", "49", "51")));
                add(new ArrayList<String>(Arrays.asList("Fred", "Maternal Grandfather", "true", "Cancer: Thyroid", "59", null)));
                add(new ArrayList<String>(Arrays.asList("Sally", "Mother", "true", null, null, null)));
                add(new ArrayList<String>(Arrays.asList("George", "Self", "true", null, null, null)));
            }};
        bob.add(new Block(1, arr, new ArrayList<String>(Arrays.asList("Smith"))));
        System.out.println(bob);
        System.out.println(bob.patientView("George"));
        System.out.println("\n");

        try (FileWriter writer = new FileWriter(new File("C:\\Users\\Matthew\\Desktop\\HudsonAlphaHackathon\\data.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Name, Relationship, Vital Status, Disease(s), Disease onset, Death age\n");
            sb.append(bob.patientView("George"));
            writer.append(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(new File("C:\\Users\\Matthew\\Desktop\\HudsonAlphaHackathon\\data2.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Name, Relationship, Vital Status, Disease(s), Disease onset, Death age\n");
            sb.append(bob.docView("George", "Smith"));
            writer.append(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
