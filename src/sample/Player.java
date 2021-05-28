package sample;
import java.util.ArrayList;

public class Player {
    //sets all the variables for attributes
    private final String name;
    private final String school;
    private double threePointPercentage;
    private final String position;
    private final String Height;
    private final String bestSkill;
    private final String weakness;
    private int rating = 75;
    private final int injuryChance;
    private double layupPerc;
    private double midrangePerc;
    private int power;
    private String path;
    private final String path2;
    private final ArrayList<Opponents> opponents_defeated = new ArrayList<>();
    private final ArrayList<Opponents> opponents_lost_to = new ArrayList<>();

    //constructor, sets all of the attributes based on input
    public Player(String n, String s, String p, String h, String b,String w,double[] stats, String ph, String ph2){
        name = n;
        school = s;
        threePointPercentage = stats[3];
        position = p;
        Height = h;
        bestSkill = b;
        weakness = w;
        injuryChance = (int) stats[4];
        layupPerc = stats[0];
        midrangePerc = stats[2];
        power = (int)stats[1];
        path = ph;
        path2 = ph2;
    }
    //all of these set functions allow a certain attribute to be changed
    //change rating
    public void setRating(int r){
        rating = r;
    }
    //change three point percentage
    public void setThreePointPercentage(double t){
        threePointPercentage = t;
    }
    //change layup percentage
    public void setLayupPerc(double lp){
        layupPerc = lp;
    }
    //change power
    public void setDunk(int p){
        power = p;
    }
    //change midrange percentage
    public void setMidrangePerc(double mp){
        midrangePerc = mp;
    }
    //change image path
    public void setPath(String p){
        path = p;
    }
    //these get functions return an attribute
    //return name
    public String getName(){
        return name;
    }
    //return school
    public String getSchool(){
        return school;
    }
    //return position
    public String getPosition(){
        return position;
    }
    //return height
    public String getHeight(){
        return Height;
    }
    //return the player's strength
    public String getBestSkill(){
        return bestSkill;
    }
    //return weakness
    public String getWeakness(){
        return weakness;
    }
    //return image path
    public String getPath(){
        return path;
    }
    //return overall rating
    public int getRating(){
        return rating;
    }
    //reutrn 3 pt percentage
    public double getThreePointPercentage(){
        return threePointPercentage;
    }
    //return layup percentage
    public double getLayupPerc(){
        return layupPerc;
    }
    //return midrange percentage
    public double getMidrangePerc(){
        return midrangePerc;
    }
    //return power
    public int getPower(){
        return power;
    }
    //return chance of injury
    public int getInjuryChance(){
        return injuryChance;
    }
    //return path of second image - "second jersey"
    public String getPath2(){
        return path2;
    }
    //add to the array of defeated opponents
    public void addToDefeatedOpponents(Opponents x){
        opponents_defeated.add(x);
    }
    //returns array of defeated opponents
    public ArrayList<Opponents> getDefeatedOpponents(){
        return opponents_defeated;
    }
    //add to the array of opponents lost to
    public void addToOpponentsLostTo(Opponents y){
        opponents_lost_to.add(y);
    }
    //returns array of opponents lost to
    public ArrayList<Opponents> getOpponentsLostTo(){
        return opponents_lost_to;
    }
}
