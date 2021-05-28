package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Controller {
    //this is the array of players(heros) and opponents(enemies)
    private final ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<Opponents> opponents = new ArrayList<>();
    //connecting to the fxml elements
    @FXML
    ListView peopleList, skill_upgrade;
    @FXML
    ImageView playerImage, p1battle, p2battle;
    @FXML
    Text choosePlayerText, notification, versus, score_text, divider, your_stats;
    @FXML
    Button choosePlayerButton, layup, dunk, midrange, threePoint, opp_offense, next_battle, start_over;
    @FXML
    Label name_label, school_label, position_label, height_label, skills_label, weakness_label,
            p1name, p2name, hero_score, opp_score, show_winner, rating_stats, layup_stats, power_stats,
            midrange_stats, three_point_stats, players_beat, players_lost;
    //these objects represent the hero and opponent
    private Player hero;
    private Opponents opp;
    //these represent the score of a game
    private int heroScore = 0;
    private int oppScore = 0;

    @FXML
    //this is the initialize or start function, it gets the class and object set up and starts the game for the user
    public void initialize() {
        //creates the player and opponent classes and fills them
        formulatePlayers();
        formulateOpponents();
        //clears the people list view
        peopleList.getItems().clear();
        //fills the listview with players
        for (Player p : players) {
            peopleList.getItems().add(p.getName());
        }
        //changing visibility of items
        choosePlayerText.setVisible(true);
        peopleList.setVisible(true);
        //sends a message to the user
        notification.setText("Click on a player to see their attributes");
    }

    //this code starts the entire game over without having to exit out of the game
    @FXML
    public void startOver() {
        //sets the necessary items invisible
        show_winner.setVisible(false);
        start_over.setVisible(true);
        p1battle.setVisible(false);
        p2battle.setVisible(false);
        next_battle.setVisible(false);
        rating_stats.setVisible(false);
        layup_stats.setVisible(false);
        power_stats.setVisible(false);
        midrange_stats.setVisible(false);
        three_point_stats.setVisible(false);
        start_over.setVisible(false);
        players_beat.setVisible(false);
        players_lost.setVisible(false);
        skill_upgrade.setVisible(false);
        //clears the array list of players and opponents so that the game can be reset
        players.clear();
        opponents.clear();
        peopleList.getItems().clear();
        //fills the array of players and opponents
        formulatePlayers();
        formulateOpponents();
        //clears the people list view
        peopleList.getItems().clear();
        //fills the listview with players
        for (Player p : players) {
            peopleList.getItems().add(p.getName());
        }
        //changing visibility of items and setting the text of some labels
        choosePlayerText.setVisible(true);
        choosePlayerText.setText("Choose Your Player");
        peopleList.setVisible(true);
        notification.setText("Click on a player to see their attributes");
    }

    //this fills the array of the players or heros that you can get, it has slightly different attributes as the opponents class, many of the attributes are based upon real player data
    private void formulatePlayers() {
        //fills all of the players and their attributes
        players.add(new Player("Stephen Curry", "Davidson College", "Point Guard", "6,3", "Lights Out 3 PT Shooter", "Injury Prone", new double[]{0.687, 4, 0.598, 0.412, 5}, "steph.jpg", "steph2.jpg"));
        players.add(new Player("Paul George", "Fresno State", "Shooting Guard", "6,8", "Good scorer and defensive presence", "Dunking and Defense", new double[]{0.603, 4, 0.467, 0.381, 3}, "paul.jpg", "paul2.jpg"));
        players.add(new Player("Jayson Tatum", "Duke", "Small Forward", "6,8", "Great scorer", "Layups", new double[]{0.333, 6, 0.469, 0.401, 2}, "jayson.jpg", "jayson2.jpg"));
        players.add(new Player("Draymond Green", "Michigan State University", "Power Forward", "6,6", "Dunking and Defense", "Poor 3 pt shooter", new double[]{0.591, 7, 0.40, 0.412, 0.319, 3}, "draymond.jpg", "draymond2.jpg"));
        players.add(new Player("Joel Embiid", "University of Kansas", "Center", "7,0", "Can score from anywhere", "Injury Prone", new double[]{0.664, 7, 0.45, 0.319, 5}, "joel.jpg", "joel2.jpg"));
    }

    //this fills the array of all of the opponents, most of the attributes are based upon real player data
    private void formulateOpponents() {
        // fills all the opponents and their attributes
        //these are level 5 opponents
        opponents.add(new Opponents("Michael Jordan", "North Carolina", "Shooting Guard", "6,6", "Everything", "None", "mj.jpg", 99, 0.45, .75, 0.50, 8));
        opponents.add(new Opponents("LeBron James", "St. Vincent-St.Mary High School", "Small Forward", "6,9", "Dunking, power", "Three Pointers", "lebron.jpg", 98, 0.344, 0.70, 0.488, 10));
        opponents.add(new Opponents("Kevin Durant", "The University of Texas at Austin", "Power Forward", "6,10", "Three Pointers", "Dunking and Power", "kd.jpg", 97, 0.381, 0.65, 0.40, 5));
        //these are level 4 opponents
        opponents.add(new Opponents("Kawhi Leonard", "San Diego State", "Small Forward", "6,7", "Midrange", "Dunking and Power", "kawhi.jpg", 95, 0.383, 0.66, 0.48, 6));
        opponents.add(new Opponents("Klay Thompson", "Washington State University", "Shooting Guard", "6,6", "Three Point shooting", "Layup", "klay.jpg", 93, 0.419, 0.6, 0.45, 6));
        opponents.add(new Opponents("Damian Lillard", "Weber State", "Point Guard", "6,2", "Midrange", "Dunking and Power", "dame.jpg", 91, 0.373, 0.6, 0.4, 5));
        //these are level 3 opponents
        opponents.add(new Opponents("James Harden", "Arizona State University", "Shooting Guard", "6,5", "Midrange", "Layup", "harden.jpg", 89, 0.363, 0.6, 0.38, 6));
        opponents.add(new Opponents("Zion Williamson", "Duke University", "Power Forward", "6,6", "Dunking and Power", "Midrange", "zion.jpg", 88, 0.429, 0.59, 0.3, 10));
        opponents.add(new Opponents("Jimmy Butler", "Marquette University", "Small Forward", "6,7", "Dunking and Power", "Three Pointer", "jimmy.jpg", 86, 0.333, 0.6, 0.33, 6));
        //these are level 2 opponents
        opponents.add(new Opponents("Kyrie Irving", "Duke University", "Point Guard", "6,2", "Layups", "Dunking and Power", "kyrie.jpg", 85, 0.390, 0.7, 0.3, 4));
        opponents.add(new Opponents("Nikola Jokic", "The University of Detroit Mercy", "Center", "7,0", "Dunking and Power", "Midrange", "nikola.jpg", 83, 0.338, 0.55, 0.25, 8));
        opponents.add(new Opponents("Jamal Murray", "The University of Kentucky", "Point Guard", "6,4", "Three Pointer", "Dunking and Power", "murray.jpg", 81, 0.358, 0.54, 0.3, 4));
        //these are the level 1 opponents
        opponents.add(new Opponents("Zach Lavine", "The University of California", "Small Forward", "6,6", "Dunking and Power", "Layups", "lavine.jpg", 78, 0.375, 0.55, 0.3, 5));
        opponents.add(new Opponents("Ja Morant", "Murray State", "Point Guard", "6,3", "Layups", "Midrange and Power", "ja.jpg", 76, 0.335, 0.55, 0.25, 4));
        opponents.add(new Opponents("Pascal Siakam", "New Mexico State University", "Power Forward", "6,9", "Three Pointer", "Dunking and Power", "pascal.jpg", 75, 0.334, 0.5, 0.20, 4));

    }

    @FXML
    //this shows up when you click a player, the if statement just shows whether you are choosing a hero or opponent
    private void viewPlayerAttributes() {
        //decides whether it should display hero or opponents attributes and displays those attributes
        if (choosePlayerText.getText().equals("Choose Your Player")) {
            heroAttributes();
        } else {
            oppAttributes();
        }
    }

    //this displays all of the attributes of a hero that is shown when the user clicks their name in a listview
    private void heroAttributes() {
        //tells the user a message
        notification.setText("Press choose player to make that player your avatar");
        //gets the player that is selected
        String selected = peopleList.getSelectionModel().getSelectedItem().toString();
        int player_index = 0;
        //identifies which player was clicked on by the user so that their attributes can be displayed
        for (Player i : players) {
            if (selected.equals(i.getName())) {
                player_index = players.indexOf(i);
                break;
            }
        }
        //makes it so that everything that displays attributes are visible
        playerImage.setVisible(true);
        name_label.setVisible(true);
        school_label.setVisible(true);
        position_label.setVisible(true);
        height_label.setVisible(true);
        skills_label.setVisible(true);
        weakness_label.setVisible(true);
        choosePlayerButton.setVisible(true);

        //displays the attributes of the player
        name_label.setText("Name: " + players.get(player_index).getName());
        school_label.setText("School: " + players.get(player_index).getSchool());
        position_label.setText("Position: " + players.get(player_index).getPosition());
        height_label.setText("Height: " + players.get(player_index).getHeight());
        skills_label.setText("Skills: " + players.get(player_index).getBestSkill());
        weakness_label.setText("Weakness: " + players.get(player_index).getWeakness());
        //shows the image of the player
        Image image = new Image(players.get(player_index).getPath());
        playerImage.setImage(image);

    }

    //this displays the information for an opponent when someone clicks their name in the listview
    private void oppAttributes() {
        //tells the user a message
        notification.setText("Press choose player to fight that player");
        //gets the item that is selected
        String selected = peopleList.getSelectionModel().getSelectedItem().toString();
        int opponent_index = 0;
        //identifies which opponent was clicked on by the user so that their attributes can be displayed
        for (Opponents i : opponents) {
            if (selected.equals(i.getName())) {
                opponent_index = opponents.indexOf(i);
                break;
            }
        }
        //shows the attributes of the opponent
        name_label.setText("Name: " + opponents.get(opponent_index).getName());
        school_label.setText("School: " + opponents.get(opponent_index).getSchool());
        position_label.setText("Position: " + opponents.get(opponent_index).getPosition());
        height_label.setText("Height: " + opponents.get(opponent_index).getHeight());
        skills_label.setText("Skills: " + opponents.get(opponent_index).getBestSkill());
        weakness_label.setText("Weakness: " + opponents.get(opponent_index).getWeakness());
        //displays the picture of the opponent
        Image image = new Image(opponents.get(opponent_index).getPath());
        playerImage.setImage(image);
        //makes the necessary things visible and invisible
        playerImage.setVisible(true);
        name_label.setVisible(true);
        school_label.setVisible(true);
        position_label.setVisible(true);
        height_label.setVisible(true);
        skills_label.setVisible(true);
        weakness_label.setVisible(true);
        choosePlayerButton.setVisible(true);
    }

    @FXML
    //this just decides what to do when someone clicks to select either a hero or opponent
    private void chooseCharacter() {
        //this if decided whether the computer is selected a player to keep as a hero or an opponent for the user to fight
        if (choosePlayerText.getText().equals("Choose Your Player")) {
            choosePlayer();
        } else {
            chooseOpponent();
        }
    }

    //identifies a player and makes that player the user's hero
    private void choosePlayer() {
        //identifies the player in the players array
        int player_index = 0;
        for (Player i : players) {
            if (name_label.getText().substring(name_label.getText().indexOf(" ") + 1).equals(i.getName())) {
                player_index = players.indexOf(i);
                break;
            }
        }
        //makes the hero the character that was selected
        hero = players.get(player_index);
        players.remove(player_index);
        //displays the player name and hides everything that is unnecessary
        notification.setText("Congratulations your player is " + hero.getName() + "!");
        choosePlayerText.setVisible(false);
        peopleList.setVisible(false);
        playerImage.setVisible(false);
        name_label.setVisible(false);
        school_label.setVisible(false);
        position_label.setVisible(false);
        height_label.setVisible(false);
        skills_label.setVisible(false);
        weakness_label.setVisible(false);
        choosePlayerButton.setVisible(false);
        //sets up the screen that allows the user to choose their opponent
        setupOpponent();

    }

    //this code selects an opponent and makes that opponent the opponent of the hero
    private void chooseOpponent() {
        //identifies the opponent that was selected
        int opponent_index = 0;
        for (Opponents i : opponents) {
            if (name_label.getText().substring(name_label.getText().indexOf(" ") + 1).equals(i.getName())) {
                opponent_index = opponents.indexOf(i);
                break;
            }
        }
        opp = opponents.get(opponent_index);
        //displays the name of the opponent that the user will be versing and makes unnecessary things invisible
        notification.setText("You will be versing " + opp.getName() + "!");
        choosePlayerText.setVisible(false);
        peopleList.setVisible(false);
        playerImage.setVisible(false);
        name_label.setVisible(false);
        school_label.setVisible(false);
        position_label.setVisible(false);
        height_label.setVisible(false);
        skills_label.setVisible(false);
        weakness_label.setVisible(false);
        choosePlayerButton.setVisible(false);
        //sets up the battle screen
        setUpBattle();

    }

    //this sets up the screen for the user to pick their opponent
    private void setupOpponent() {
        //tells the user what to do
        notification.setText("Your opponents are based on your skill level and experience");
        choosePlayerText.setText("Choose Your Opponent");
        choosePlayerText.setVisible(true);
        //makes the listview of opponents visible
        peopleList.setVisible(true);
        peopleList.getItems().clear();
        //determines which opponents to show depending on what level the hero is - so that a bad player doesn't play someone too hard
        for (Opponents o : opponents) {
            if (o.getRating() <= hero.getRating() + 5) {
                peopleList.getItems().add(o.getName());
            }
        }
    }

    //once the hero and opponent are selected, then this simply sets up the battle screen
    private void setUpBattle() {
        //resets the score
        heroScore = 0;
        oppScore = 0;
        //displays the score
        hero_score.setText("" + heroScore);
        opp_score.setText("" + oppScore);
        //explains the fight
        notification.setText("Battle your opponent, first to 21 points wins");
        //sets things visible and displays the images of the players
        versus.setVisible(true);
        p1battle.setVisible(true);
        Image heroImage = new Image(hero.getPath());
        p1battle.setImage(heroImage);
        p2battle.setVisible(true);
        Image oppImage = new Image(opp.getPath());
        p2battle.setImage(oppImage);

        p1name.setVisible(true);
        p2name.setVisible(true);
        //displays the name of the players
        p1name.setText(hero.getName());
        p2name.setText(opp.getName());

        score_text.setVisible(true);
        divider.setVisible(true);
        hero_score.setVisible(true);
        opp_score.setVisible(true);

        layup.setVisible(true);
        dunk.setVisible(true);
        midrange.setVisible(true);
        threePoint.setVisible(true);
        //makes the objects for the hero's actions visible since they will go first
        layup.setDisable(false);
        dunk.setDisable(false);
        midrange.setDisable(false);
        threePoint.setDisable(false);

        opp_offense.setVisible(true);
        opp_offense.setDisable(true);
    }

    //this checks the score after every turn to see if anyone has won the game
    private void checkBattleComplete() {
        //if the hero wins
        if (heroScore >= 11) {
            //reset the scores
            heroScore = 0;
            oppScore = 0;
            //makes the skill upgrade option available and clears the list view
            skill_upgrade.setVisible(true);
            skill_upgrade.setDisable(false);
            skill_upgrade.getItems().clear();
            start_over.setVisible(true);
            if (hero.getRating() <= opp.getRating()) {
                //checks if there are any skills that the opponent has better than the player --> this helps determine whether the hero deserves and upgrades
                boolean anySkills = false;
                //all of these ifs state if the hero's attribute is less than the opponent's attribute
                if (hero.getLayupPerc() < opp.getLayupPerc()) {
                    skill_upgrade.getItems().add("Layup");
                    anySkills = true;
                }
                if (hero.getPower() < opp.getPower()) {
                    skill_upgrade.getItems().add("Dunk");
                    anySkills = true;
                }
                if (hero.getMidrangePerc() < opp.getMidrange()) {
                    skill_upgrade.getItems().add("Midrange");
                    anySkills = true;
                }
                if (hero.getThreePointPercentage() < opp.getThreePointPercentage()) {
                    skill_upgrade.getItems().add("Three Pointer");
                    anySkills = true;
                }
                //if the user doesn't have any attributes that are worse than the opponent, they simply get an option to upgrade their overall rating
                if (!anySkills) {
                    skill_upgrade.getItems().add("Upgrade rating");
                }
            }
            //changes the jersey of the hero if needed --> this happens if this is the first win for the hero
            if (!hero.getPath().equals(hero.getPath2())) {
                hero.setPath(hero.getPath2());
                notification.setText("You got a new jersey!");
                Image heroImage = new Image(hero.getPath());
                p1battle.setImage(heroImage);
            }
            //makes things visible
            show_winner.setVisible(true);
            start_over.setVisible(true);
            next_battle.setVisible(true);
            //tells the user a message
            notification.setText(hero.getName() + " has won the battle! Inherit one of " + opp.getName() + "'s skills that are better. If there are no skills than your player has better skills.");
            //gets rid of the fxml elements for the battle screen
            breakDownBattle(true);
            //since the user won, we add this opponent to the list of peoople that the user beat
            hero.addToDefeatedOpponents(opp);
            //diplays the stats of the hero
            showHeroStats();
            //this is if the hero loses
        } else if (oppScore >= 11) {
            //resets the score
            heroScore = 0;
            oppScore = 0;
            //makes things visible
            show_winner.setVisible(true);
            start_over.setVisible(true);
            next_battle.setVisible(true);
            start_over.setVisible(true);
            //tells the user a message
            notification.setText("Better luck next time, " + hero.getName() + " has lost to " + opp.getName());
            //gets rid of all of the elements of the battle screen
            breakDownBattle(false);
            //adds this opponent to list of people that the hero lost to
            hero.addToOpponentsLostTo(opp);
            //possibly gives an injury to the user, which hurts the rating of the user
            possibleInjury();
            //shows the stats of the hero
            showHeroStats();
        }
    }

    //if a player loses, there is a chance that his character becomes injured and loses points, this determines whether an injury actually occurs
    private void possibleInjury() {
        //gets the chance that the user will get injured
        double chance = (hero.getInjuryChance() + (opp.getRating() - hero.getRating()));
        //gets a random number
        int random = (int) Math.random() * (10) + 1;
        //sees if random number was in the range of the chance --> basically if the user go injured
        if (random <= chance && hero.getRating() > 75) {
            //the hero is injured
            notification.setText("Yikes, you lost the game and got injured, your rating took a hit.");
            //the rating of the user goes down
            hero.setRating(hero.getRating() - 5);
        }
    }

    //this function is for upgrading the attributes of a hero once they have won a game against a higher ranked opponent
    @FXML
    private void upgradeHero() {
        //this code identifies the thing that is being upgraded
        String skill = skill_upgrade.getSelectionModel().getSelectedItem().toString();
        //if the user is just upgrading the overall rating
        if (skill.equals("Upgrade rating")) {
            skill_upgrade.setDisable(true);
            hero.setRating(hero.getRating() + 5);
            showHeroStats();
            next_battle.setDisable(false);
        }
        //the next four if statements are the same except they are for the 4 different types of shots
        if (skill.equals("Layup")) {
            //this upgrades the skill for the user
            hero.setLayupPerc(hero.getLayupPerc() + 0.05);
            //makes the upgrade listview invisible
            skill_upgrade.setDisable(true);
            //improves the overall rating of the hero
            hero.setRating(hero.getRating() + 5);
            //displays the stats of the hero
            showHeroStats();
            //makes the next battle button clickable
            next_battle.setDisable(false);
        } else if (skill.equals("Dunk")) {
            hero.setDunk(hero.getPower() + 1);
            skill_upgrade.setDisable(true);
            hero.setRating(hero.getRating() + 5);
            showHeroStats();
            next_battle.setDisable(false);
        } else if (skill.equals("Midrange")) {
            hero.setMidrangePerc(hero.getMidrangePerc() + 0.05);
            skill_upgrade.setDisable(true);
            hero.setRating(hero.getRating() + 5);
            showHeroStats();
            next_battle.setDisable(false);
        } else if (skill.equals("Three Pointer")) {
            hero.setThreePointPercentage(hero.getThreePointPercentage() + 0.05);
            skill_upgrade.setDisable(true);
            hero.setRating(hero.getRating() + 5);
            showHeroStats();
            next_battle.setDisable(false);
        }
        //tells the user that they have been upgraded
        notification.setText(notification.getText() + "Congrats! You have been upgraded!!!");
    }

    //this displays the stats of the hero on the screen right after a battle is complete
    private void showHeroStats() {
        //makes things visible
        players_beat.setVisible(true);
        players_lost.setVisible(true);
        your_stats.setVisible(true);
        rating_stats.setVisible(true);
        layup_stats.setVisible(true);
        power_stats.setVisible(true);
        midrange_stats.setVisible(true);
        three_point_stats.setVisible(true);
        //diplays the list of the people that the hero has beat
        if (hero.getDefeatedOpponents().size() > 0) {
            String beat = "";
            //gets names of opponents from an array
            for (Opponents o : hero.getDefeatedOpponents()) {
                beat += o.getName() + ", ";
            }
            players_beat.setText("You have beat: " + beat.substring(0, beat.length() - 2));
        } else {
            players_beat.setText("You have beat: Nobody");
        }
        //displays the list of people that the hero has lost to
        if (hero.getOpponentsLostTo().size() > 0) {
            String lost = "";
            //gets name of opponents from an array
            for (Opponents o : hero.getOpponentsLostTo()) {
                lost += o.getName() + ", ";
            }
            players_lost.setText("You have lost to: " + lost.substring(0, lost.length() - 2));
        } else {
            players_lost.setText("You have lost to: Nobody");
        }
        //shows the stats of the hero's skills
        rating_stats.setText("Rating: " + hero.getRating());
        layup_stats.setText("Layup: " + hero.getLayupPerc());
        power_stats.setText("Power/Dunk: " + hero.getPower());
        midrange_stats.setText("Midrange: " + hero.getMidrangePerc());
        three_point_stats.setText("Three Point: " + hero.getThreePointPercentage());
    }

    //this clears the battles elements from the screen and sets up for the screen that occurs right after a battle
    private void breakDownBattle(boolean hero_Won) {
        //this is where we will display the results of all of the hero's previous battles
        if (hero_Won) {
            //the hero won
            show_winner.setText(">");
        } else {
            //hero lost
            show_winner.setText("<");
        }
        //makes things invisible
        versus.setVisible(false);


        p1name.setVisible(false);
        p2name.setVisible(false);

        score_text.setVisible(false);
        divider.setVisible(false);
        hero_score.setVisible(false);
        opp_score.setVisible(false);

        layup.setVisible(false);
        dunk.setVisible(false);
        midrange.setVisible(false);
        threePoint.setVisible(false);

        opp_offense.setVisible(false);
        opp_offense.setDisable(false);
    }

    //this button ends a battle and allows a user to choose who they will fight next
    @FXML
    private void nextBattle() {
        //makes things invisible
        next_battle.setVisible(false);
        players_beat.setVisible(false);
        players_lost.setVisible(false);
        skill_upgrade.setVisible(false);
        p1battle.setVisible(false);
        p2battle.setVisible(false);
        your_stats.setVisible(false);
        rating_stats.setVisible(false);
        three_point_stats.setVisible(false);
        layup_stats.setVisible(false);
        midrange_stats.setVisible(false);
        power_stats.setVisible(false);
        show_winner.setVisible(false);
        start_over.setVisible(false);
        //tells the user a message
        notification.setText("Nice, choose your next opponent's level, remember, the goal is to BEAT MICHAEL JORDAN!");
        //make all the new stuff visible for choosing the next opponent
        setupOpponent();
    }
    //this runs a "layup" for the hero
    @FXML
    private void layupShot() {
        //converts the height of the hero and opponent into a comparable number
        double heroHeight = Integer.parseInt(hero.getHeight().substring(0, 1)) - (Integer.parseInt(hero.getHeight().substring(2)) / 12);
        double oppHeight = Integer.parseInt(opp.getHeight().substring(0, 1)) - (Integer.parseInt(opp.getHeight().substring(2)) / 12);
        //gets the chance that the hero will make the shot based on heights of the players, and how good the user is at layups
        double chance = (hero.getLayupPerc() * ((double) hero.getRating()) / ((double) opp.getRating())) + (heroHeight / 7) / 10 - (oppHeight / 7) / 10;
        //this is if the user actually makes the shot (the random number was less that or equal to the chance)
        if (Math.random() <= chance) {
            //code that it goes in
            //increase score
            heroScore += 2;
            //tells the user
            notification.setText(hero.getName() + " makes a layup. 2 pts for him!");
        } else {
            //code that it missed
            //randomly decides if the missed shot was blocked or just missed
            if (Math.random() <= 0.5) {
                notification.setText("Yikes " + hero.getName() + " was blocked by " + opp.getName() + "!");
            } else {
                notification.setText("Tough Luck, " + hero.getName() + " missed the shot.");
            }
        }
        //changes the score
        updateScore();
        //makes it the opponent's turn
        switchControls(true);
        //sees if anyone won yet
        checkBattleComplete();
    }

    //this runs a "dunk" for the hero
    @FXML
    private void dunkShot() {
        //converts the height of the hero and opponent into a comparable number
        double heroHeight = Integer.parseInt(hero.getHeight().substring(0, 1)) - (Integer.parseInt(hero.getHeight().substring(2)) / 12);
        double oppHeight = Integer.parseInt(opp.getHeight().substring(0, 1)) - (Integer.parseInt(opp.getHeight().substring(2)) / 12);
        //gets the chance that the hero will make the shot based on heights of the players, and how good the user is at dunks (their power)
        double chance = (((double) hero.getPower() / (double) 10) * ((double) hero.getRating()) / ((double) opp.getRating())) + (heroHeight / 7) / 10 - (oppHeight / 7) / 10;
        //this is if the user actually makes the shot (the random number was less that or equal to the chance)
        if (Math.random() <= chance) {
            //code that it goes in
            //increase score
            heroScore += 2;
            //tells the user
            notification.setText(hero.getName() + " makes a SLAM DUNK!!!");
        } else {
            //code that it missed
            //randomly decides if the missed shot was blocked or just missed
            if (Math.random() <= 0.5) {
                notification.setText("Yikes " + hero.getName() + " was blocked by " + opp.getName() + "!");
            } else {
                notification.setText("Tough Luck, " + hero.getName() + " somehow missed the rim.");
            }
        }
        //changes the score
        updateScore();
        //makes it the opponent's turn
        switchControls(true);
        //sees if anyone won yet
        checkBattleComplete();
    }

    //this runs a "midrange" shot for the hero
    @FXML
    private void midrangeShot() {
        //converts the height of the hero and opponent into a comparable number
        double heroHeight = Integer.parseInt(hero.getHeight().substring(0, 1)) - (Integer.parseInt(hero.getHeight().substring(2)) / 12);
        double oppHeight = Integer.parseInt(opp.getHeight().substring(0, 1)) - (Integer.parseInt(opp.getHeight().substring(2)) / 12);
        //gets the chance that the hero will make the shot based on heights of the players, and how good the user is at midrange shots
        double chance = (hero.getMidrangePerc() * ((double) hero.getRating()) / ((double) opp.getRating())) + (heroHeight / 7) / 10 - (oppHeight / 7) / 10;
        //this is if the user actually makes the shot (the random number was less that or equal to the chance)
        if (Math.random() <= chance) {
            //code that it goes in
            //increase score
            heroScore += 2;
            //tells the user
            notification.setText(hero.getName() + " drains a midrange shot. 2 pts for him!");
        } else {
            //code that it missed
            //randomly decides if the missed shot was blocked or just missed
            if (Math.random() <= 0.5) {
                notification.setText("Yikes " + hero.getName() + " was blocked by " + opp.getName() + "!");
            } else {
                notification.setText("Tough Luck, " + hero.getName() + " missed the shot.");
            }
        }
        //changes the score
        updateScore();
        //makes it the opponent's turn
        switchControls(true);
        //sees if anyone won yet
        checkBattleComplete();
    }

    //this runs a "three point" shot for the hero
    @FXML
    private void threePointShot() {
        //converts the height of the hero and opponent into a comparable number
        double heroHeight = Integer.parseInt(hero.getHeight().substring(0, 1)) - (Integer.parseInt(hero.getHeight().substring(2)) / 12);
        double oppHeight = Integer.parseInt(opp.getHeight().substring(0, 1)) - (Integer.parseInt(opp.getHeight().substring(2)) / 12);
        //gets the chance that the hero will make the shot based on heights of the players, and how good the user is at midrange shots
        double chance = (hero.getThreePointPercentage() * ((double) hero.getRating()) / ((double) opp.getRating())) + (heroHeight / 7) / 10 - (oppHeight / 7) / 10;
        //this is if the user actually makes the shot (the random number was less that or equal to the chance)
        if (Math.random() <= chance) {
            //code that it goes in
            //increase score
            heroScore += 3;
            //tells the user
            notification.setText(hero.getName() + " makes a 3pt shot from way downtown. 3 pts for him!");
        } else {
            //code that it missed
            //randomly decides if the missed shot was blocked or just missed
            if (Math.random() <= 0.5) {
                notification.setText("Yikes " + hero.getName() + " was blocked by " + opp.getName() + "!");
            } else {
                notification.setText("Tough Luck, " + hero.getName() + " missed the shot.");
            }
        }
        //changes the score
        updateScore();
        //makes it the opponent's turn
        switchControls(true);
        //sees if anyone won yet
        checkBattleComplete();
    }

    //this changes the shore when a turn happens
    private void updateScore() {
        //updates the score label for the hero and opponent
        hero_score.setText(Integer.toString(heroScore));
        opp_score.setText(Integer.toString(oppScore));
    }

    //this runs the offense for the opponent, which is choosen by the computer
    @FXML
    private void runOppOffense() {
        //pick determines which move will be made
        int pick = 0;
        //if the opponent is a level 3 opponent, then they will make intelligent move choices, moves based on their skills
        if (opp.getRating() > 85) {
            //runs the intelligent offense to determine the move
            String pickedSkill = IntelligentOpponentOffense();
            //sets the value of pick based upon what is selected
            if (pickedSkill == "layup") {
                pick = 1;
            } else if (pickedSkill == "power") {
                pick = 2;
            } else if (pickedSkill == "midrange") {
                pick = 3;
            } else {
                pick = 4;
            }
            //this happens if the choice is not intelligent
        } else {
            //randomly picks a number, with equal chances
            pick = (int) (Math.random() * (4 - 1 + 1)) + 1;
        }
        //based on the pick, runs a function that has the opponent take a type of shot
        if (pick == 1) {
            oppLayup();
        } else if (pick == 2) {
            oppDunk();
        } else if (pick == 3) {
            oppMidrange();
        } else if (pick == 4) {
            oppThreePointer();
        }
    }

    //if an opponent is level 3 or above then the computer is smarter and is more likely to pick the moves that an opponent is better at, this function picks those moves
    private String IntelligentOpponentOffense() {
        //for the player that is the opponent
        //compare each stat to the average for that stat among all opponents
        double powerCompare = comparePower(opp);
        double layupCompare = compareLayup(opp);
        double midrangeCompare = compareMidrange(opp);
        double threePointCompare = compareThreePoint(opp);
        //make an array list of these stats
        ArrayList<Double> comparisons = new ArrayList<>();
        comparisons.add(powerCompare);
        comparisons.add(layupCompare);
        comparisons.add(midrangeCompare);
        comparisons.add(threePointCompare);
        //make an array list of strings to match the stats
        ArrayList<String> methodNames = new ArrayList<>();
        methodNames.add("power");
        methodNames.add("layup");
        methodNames.add("midrange");
        methodNames.add("three point");
        //for this particular player, rank all of his stats from strongest to weakest -- a sorting algorithm
        ArrayList<Double> sortedComparisons = new ArrayList<>();
        ArrayList<String> sortedNames = new ArrayList<>();
        //this runs 4 times
        for (int i = 1; i <= 4; i++) {
            //goes through the entire array and sees what is the biggest remaining value
            double max = comparisons.get(0);
            int index_of_max = 0;
            for (int j = 0; j < comparisons.size(); j++) {
                if (max < comparisons.get(j)) {
                    max = comparisons.get(j);
                    index_of_max = j;
                }
            }
            //this then add the biggest value to the new array that will be ranked in order of greatest to smallest (there is also a ranked string array to match)
            sortedComparisons.add(comparisons.remove(index_of_max));
            sortedNames.add(methodNames.remove(index_of_max));
        }
        //decide what skill will be picked based upon this ranking
        int decide = (int) (Math.random() * (10 - 1 + 1)) + 1;
        //the earlier the position is in the sorted array (the stronger of a skill it is) the higher chance there is of that getting selected
        if (decide <= 4) {
            return sortedNames.get(0);
        } else if (decide <= 7) {
            return sortedNames.get(1);
        } else if (decide <= 9) {
            return sortedNames.get(2);
        } else {
            return sortedNames.get(3);
        }
    }

    //this compares the power of an opponent to the rest of the opponents
    private double comparePower(Opponents opponent) {
        double comparison = 0.0;
        //gets the average power of an opponent
        double avg = 0;
        for (Opponents o : opponents) {
            avg += o.getPower();
        }
        avg = avg / opponents.size();
        //compares the current opponents power to the rest and returns the value
        comparison = opponent.getPower() / avg;
        return comparison;
    }

    //compares the layup of an opponent to the rest of the opponents
    private double compareLayup(Opponents opponent) {
        double comparison = 0.0;
        //calculates the average power of an opponent
        double avg = 0;
        for (Opponents o : opponents) {
            avg += o.getLayupPerc();
        }
        avg = avg / opponents.size();
        //gets the user's power in comparison to the average and returns that
        comparison = opponent.getLayupPerc() / avg;
        return comparison;
    }

    //this compares the midrange of an opponent to the rest of the opponents
    private double compareMidrange(Opponents opponent) {
        double comparison = 0.0;
        //gets the average midrange of an opponent
        double avg = 0;
        for (Opponents o : opponents) {
            avg += o.getMidrange();
        }
        avg = avg / opponents.size();
        //returns the comparison of a opponent to the average
        comparison = opponent.getMidrange() / avg;
        return comparison;
    }

    //this compares the 3 pointer of an opponent to the rest of the opponents
    private double compareThreePoint(Opponents opponent) {
        double comparison = 0.0;
        //calculates the average of the three pointer between all opponents
        double avg = 0;
        for (Opponents o : opponents) {
            avg += o.getThreePointPercentage();
        }
        avg = avg / opponents.size();
        //returns the comparison between the opponent selected and the average 3 pt percentage
        comparison = opponent.getThreePointPercentage() / avg;
        return comparison;
    }

    //this happens when a user turn is done and makes the options for the user disabled, so they can't have multiple turns in a row
    private void switchControls(boolean b) {
        //makes the user controls disabled
        layup.setDisable(b);
        dunk.setDisable(b);
        midrange.setDisable(b);
        threePoint.setDisable(b);
        opp_offense.setDisable(!b);
    }

    //this runs a layup for the opponent
    private void oppLayup() {
        //gets the height of the players into comparable terms
        double heroHeight = Integer.parseInt(hero.getHeight().substring(0, 1)) - (Integer.parseInt(hero.getHeight().substring(2)) / 12);
        double oppHeight = Integer.parseInt(opp.getHeight().substring(0, 1)) - (Integer.parseInt(opp.getHeight().substring(2)) / 12);
        //calculates chance that the shot will go in based on the heights of the 2 players and the opponent's layup percentage
        double chance = (opp.getLayupPerc() * ((double) opp.getRating()) / ((double) hero.getRating())) + (oppHeight / 7) / 10 - (heroHeight / 7) / 10;
        if (Math.random() <= chance) {
            //code that it goes in
            //score increases and user notified
            oppScore += 2;
            notification.setText(opp.getName() + " made a layup. Wah Wah Wahhh");
        } else {
            //code that it missed
            //randomly chosen if the shot is blocked or missed
            if (Math.random() <= 0.5) {
                notification.setText("Yay " + opp.getName() + " was blocked by " + hero.getName() + "!");
            } else {
                notification.setText("Whew, " + opp.getName() + " missed the shot.");
            }
        }
        //displays updated score
        updateScore();
        //switches the controls to the user
        switchControls(false);
        //sees if someone has scored over 11
        checkBattleComplete();
    }

    //this runs a dunk for the opponent
    private void oppDunk() {
        //gets the height of the players into comparable terms
        double heroHeight = Integer.parseInt(hero.getHeight().substring(0, 1)) - (Integer.parseInt(hero.getHeight().substring(2)) / 12);
        double oppHeight = Integer.parseInt(opp.getHeight().substring(0, 1)) - (Integer.parseInt(opp.getHeight().substring(2)) / 12);
        //calculates chance that the shot will go in based on the heights of the 2 players and the opponent's power
        double chance = (((double) opp.getPower() / (double) 10) * ((double) opp.getRating()) / ((double) hero.getRating())) + (oppHeight / 7) / 10 - (heroHeight / 7) / 10;
        if (Math.random() <= chance) {
            //code that it goes in
            //score increases and user notified
            oppScore += 2;
            notification.setText(opp.getName() + " made a dunk. Wah Wah Wahhh");
        } else {
            //code that it missed
            //randomly chosen if the shot is blocked or missed
            if (Math.random() <= 0.5) {
                notification.setText("Yay " + opp.getName() + " was blocked by " + hero.getName() + "!");
            } else {
                notification.setText("Whew, " + opp.getName() + " missed the shot.");
            }
        }
        //displays updated score
        updateScore();
        //switches the controls to the user
        switchControls(false);
        //sees if someone has scored over 11
        checkBattleComplete();
    }

    //this runs a midrange for the opponent
    private void oppMidrange() {
        //gets the height of the players into comparable terms
        double heroHeight = Integer.parseInt(hero.getHeight().substring(0, 1)) - (Integer.parseInt(hero.getHeight().substring(2)) / 12);
        double oppHeight = Integer.parseInt(opp.getHeight().substring(0, 1)) - (Integer.parseInt(opp.getHeight().substring(2)) / 12);
        //calculates chance that the shot will go in based on the heights of the 2 players and the opponent's midrange percentage
        double chance = (opp.getMidrange() * ((double) opp.getRating()) / ((double) hero.getRating())) + (oppHeight / 7) / 10 - (heroHeight / 7) / 10;
        if (Math.random() <= chance) {
            //code that it goes in
            //score increases and user notified
            oppScore += 2;
            notification.setText(opp.getName() + " made a midrange. Wah Wah Wahhh");
        } else {
            //code that it missed
            //randomly chosen if the shot is blocked or missed
            if (Math.random() <= 0.5) {
                notification.setText("Yay " + opp.getName() + " was blocked by " + hero.getName() + "!");
            } else {
                notification.setText("Whew, " + opp.getName() + " missed the shot.");
            }
        }
        //displays updated score
        updateScore();
        //switches the controls to the user
        switchControls(false);
        //sees if someone has scored over 11
        checkBattleComplete();
    }

    //this runs a 3 pointer for the opponent
    private void oppThreePointer() {
        //gets the height of the players into comparable terms
        double heroHeight = Integer.parseInt(hero.getHeight().substring(0, 1)) - (Integer.parseInt(hero.getHeight().substring(2)) / 12);
        double oppHeight = Integer.parseInt(opp.getHeight().substring(0, 1)) - (Integer.parseInt(opp.getHeight().substring(2)) / 12);
        //calculates chance that the shot will go in based on the heights of the 2 players and the opponent's three point percentage
        double chance = (opp.getThreePointPercentage() * ((double) opp.getRating()) / ((double) hero.getRating())) + (oppHeight / 7) / 10 - (heroHeight / 7) / 10;
        if (Math.random() <= chance) {
            //code that it goes in
            //score increases and user notified
            oppScore += 3;
            notification.setText(opp.getName() + " made a three. Wah Wah Wahhh");
        } else {
            //code that it missed
            //randomly chosen if the shot is blocked or missed
            if (Math.random() <= 0.5) {
                notification.setText("Yay " + opp.getName() + "'s three pointer was blocked by " + hero.getName() + "!");
            } else {
                notification.setText("Whew, " + opp.getName() + " missed the three pointer.");
            }
        }
        //displays updated score
        updateScore();
        //switches the controls to the user
        switchControls(false);
        //sees if someone has scored over 11
        checkBattleComplete();
    }
}