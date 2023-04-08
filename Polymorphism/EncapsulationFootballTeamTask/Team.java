package EncapsulationFootballTeamTask;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        players.add(player);
    }
    public void removePlayer(String name){
        boolean removed = players.removeIf(player -> player.getName().equals(name));
        if (!removed) {
            System.out.println("Player " + name + " is not in " + this.name + " team.");
        }
    }
    public double getRating(){
        double rating = players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0.0);
        return Math.round(rating);
    }
}
