package sumyitschool.thing_project.model;

import java.io.*;
import java.util.ArrayList;

public class ThingIO {
    private ArrayList<Thing> things;

    public ThingIO(ArrayList<Thing> thing) {
        this.things = thing;
    }

    public ThingIO() {
        things = new ArrayList<>();
    }

    public void writeThing(File file) {
        try(FileWriter thingWriter = new FileWriter(file)) {
            for (int i = 0; i < things.size(); i++) {
                thingWriter.write(things.get(i).toString());
            }
        }catch (IOException e) {
            System.out.println("Error while writting to file, " + e);
        }
    }

    public void readThing(File file) {
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line = bf.readLine();
            while (line != null) {
                String[] thingParts = line.split("-");
                things.add(new Thing(Boolean.valueOf(thingParts[0]), thingParts[1], thingParts[2], thingParts[3], thingParts[4]));
                line = bf.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error while reading from file, " + e);
        }
    }

    public ArrayList<Thing> getThing() {
        return things;
    }
}