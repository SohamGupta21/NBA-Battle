package sample;

public class Opponents {
    //all of the attributes
    private final String name;
    private final String school;
    private final String position;
    private final String Height;
    private final String bestSkill;
    private final String weakness;
    private final String path;
    private final int rating;
    private final double threePointPercentage;
    private final double layupPerc;
    private final int power;
    private final double midrange;
    //constructor, sets all attributes
    public Opponents(String n, String s, String p, String h, String b, String w, String ph, int r, double t, double l, double m, int pow) {
        name = n;
        school = s;
        position = p;
        Height = h;
        bestSkill = b;
        path = ph;
        weakness = w;
        rating = r;
        threePointPercentage = t;
        layupPerc = l;
        midrange = m;
        power = pow;
    }
    //the get functions return attributes
    //gets the name
    public String getName() {
        return name;
    }
    //returns school
    public String getSchool() {
        return school;
    }
    //returns position
    public String getPosition() {
        return position;
    }
    //returns height
    public String getHeight() {
        return Height;
    }
    //returns best skill/strength
    public String getBestSkill() {
        return bestSkill;
    }
    //returns weakness
    public String getWeakness() {
        return weakness;
    }
    //returns image path
    public String getPath() {
        return path;
    }
    //returns overall rating
    public int getRating() {
        return rating;
    }
    //returns 3 pt percentage
    public double getThreePointPercentage() {
        return threePointPercentage;
    }
    //returns layup percentage
    public double getLayupPerc(){
        return layupPerc;
    }
    //returns power
    public int getPower(){
        return power;
    }
    //returns midrange percentage
    public double getMidrange(){
        return midrange;
    }
}
