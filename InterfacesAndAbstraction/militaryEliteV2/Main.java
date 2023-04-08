package militaryEliteV2;
import militaryEliteV2.Classes.*;
import militaryEliteV2.enums.Corps;
import militaryEliteV2.enums.State;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, Soldier> privatesSoldierMap = new LinkedHashMap<>();


        while (!"End".equals(input)){
            createSoldierType(input, privatesSoldierMap);
            input = scanner.nextLine();
        }
    }

    private static void createSoldierType(String input, Map<Integer, Soldier> privatesSoldierMap) {
        String[] data = input.split("\\s+");
        String soldierType = data[0];
        int id = Integer.parseInt(data[1]);
        String soldierFirstName = data[2];
        String soldierLastName = data[3];
        double salary = Double.parseDouble(data[4]);
        switch (soldierType){
            case "Private":
                Soldier privateSoldier = new PrivateImpl(id,soldierFirstName,soldierLastName,salary);
                privatesSoldierMap.put(id,privateSoldier);
                System.out.println(privateSoldier);
                break;
            case "LieutenantGeneral":
                LieutenantGeneralImpl lieutenant = new LieutenantGeneralImpl(id,soldierFirstName,soldierLastName,salary);
                if (data.length > 5){
                    for (int i = 5; i < data.length; i++) {
                        int soldierId = Integer.parseInt(data[i]);
                        lieutenant.addPrivate((PrivateImpl) privatesSoldierMap.remove(soldierId));
                    }
                }
                System.out.println(lieutenant);
                break;
            case "Engineer":
                String corps = data[5];
                if (!corps.equals("Marines") && !corps.equals("Airforces")){
                    break;
                }
                EngineerImpl engineer = new EngineerImpl(id,soldierFirstName,soldierLastName,salary);
                selectCorps(corps, engineer);
                int dataLength = data.length;
                if (dataLength > 6){
                    for (int i = 6; i < data.length ; i++) {
                        String partName = data[i];
                        int hours = Integer.parseInt(data[i + 1]);
                        engineer.addRepair(new Repair(partName,hours));
                        i += 1;
                    }
                }
                System.out.println(engineer);
                break;
            case "Commando":
                CommandoImpl commando = new CommandoImpl(id,soldierFirstName,soldierLastName,salary);
                 corps = data[5];
                selectCorps(corps,commando);
                if (data.length > 6){
                    for (int i = 6; i < data.length; i++) {
                        Mission mission;
                        String missionName = data[i];
                        String state = data[i + 1];
                        if (state.equals("inProgress")){
                            mission = new Mission(missionName);
                            mission.setState(State.inProgress);
                            commando.addMission(mission);
                        }else if (state.equals("finished")){
                            mission = new Mission(missionName);
                            mission.setState(State.finished);
                            commando.addMission(mission);
                        }
                        i++;
                    }

                }
                System.out.println(commando);
                break;
            case "Spy":
                String codeNumberOfSpy = data[4];
                SpyImpl spy = new SpyImpl(id,soldierFirstName,soldierLastName,codeNumberOfSpy);
                System.out.println(spy);
                break;
        }
    }

    private static void selectCorps(String corps, SpecialisedSoldierImpl engineer) {
        if (corps.equals("Airforces")){
            engineer.setCorps(Corps.Airforces);
        }else if (corps.equals("Marines")){
            engineer.setCorps(Corps.Marines);
        }
    }
}
