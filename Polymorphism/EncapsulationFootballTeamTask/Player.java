package EncapsulationFootballTeamTask;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if(isValidRating(endurance,"Endurance")){
            this.endurance = endurance;
        }
    }

    private void setSprint(int sprint) {
        if(isValidRating(sprint,"Sprint")){
            this.sprint = sprint;
        }
    }

    private void setDribble(int dribble) {
        if(isValidRating(dribble,"Dribble")){
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if(isValidRating(passing,"Passing")){
            this.passing = passing;
        }
    }

    private void setShooting(int shooting) {
        if(isValidRating(shooting,"Shooting")){
            this.shooting = shooting;
        }
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

    private boolean isValidRating(int rating,String statName) {
        if (rating < 0 || rating > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.",statName));
        }
        return true;
    }
}
