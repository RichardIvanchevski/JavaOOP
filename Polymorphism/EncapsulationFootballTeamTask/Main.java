package EncapsulationFootballTeamTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Team> teams = new ArrayList<>();
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] commandParts = input.split(";");
            String command = commandParts[0];

            switch (command){
                case "Team":
                    try{
                        Team team = new Team(commandParts[1]);
                        teams.add(team);

                    }catch (Exception exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Add":
                    String teamName = commandParts[1];
                    String playerName = commandParts[2];
                    int endurance = Integer.parseInt(commandParts[3]);
                    int sprint = Integer.parseInt(commandParts[4]);
                    int dribble = Integer.parseInt(commandParts[5]);
                    int passing = Integer.parseInt(commandParts[6]);
                    int shooting = Integer.parseInt(commandParts[7]);
                    boolean isExist = false;
                    try{
                        Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
                        for (Team team : teams) {
                            if (team.getName().equals(teamName)){
                                team.addPlayer(player);
                                isExist = true;

                            }
                        }
                        if (!isExist){

                            System.out.printf("Team %s does not exist.",teamName);
                        }

                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "Remove":
                    teamName = commandParts[1];
                    playerName = commandParts[2];

                    try{
                        Optional<Team> team = teams.stream()
                                .filter(t -> t.getName().equals(teamName))
                                .findFirst();

                        if (team.isPresent()) {
                            team.get().removePlayer(playerName);
                        } else {
                            System.out.println("Team " + teamName + " does not exist.");
                        }
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Rating":
                    teamName = commandParts[1];
                    isExist = false;
                    for (Team team : teams) {
                        if (team.getName().equals(teamName)){
                            System.out.printf("%s - %.0f",teamName,team.getRating());
                            isExist = true;
                        }
                    }
                    if (!isExist){
                        System.out.printf("Team %s does not exist.",teamName);
                    }
                    break;
            }






            input = scanner.nextLine();
        }
    }
}
