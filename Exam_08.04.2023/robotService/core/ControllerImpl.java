package robotService.core;


import robotService.Main;
import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;


public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
      Service service;

      switch (type){
          case "MainService":
              service = new MainService(name);
              break;
          case "SecondaryService":
              service = new SecondaryService(name);
              break;
          default:
              throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
      }
      services.add(service);
      return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE,type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;

        switch (type) {
            case "MetalArmor":
                supplement = new MetalArmor();
                break;
            case "PlasticArmor":
                supplement = new PlasticArmor();
                break;
            default:
                throw new IllegalArgumentException("Invalid supplement type.");
        }
        supplements.addSupplement(supplement);
        return String.format("%s is successfully added.", type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = supplements.findFirst(supplementType);
        Service service;

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        for (Service currentService : services) {
            if (currentService.getName().equals(serviceName)) {
                service = currentService;
                service.addSupplement(supplement);
            }
        }

        supplements.removeSupplement(supplement);



        return String.format("Successfully added %s to %s.", supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        Service service = null;

        switch (robotType) {
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;
            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }
        for (Service currentService : services) {
            if (currentService.getName().equals(serviceName)) {
                service = currentService;
            }
        }

        
        if (service.getClass().getSimpleName().equals("MainService") && robotType.equals("MaleRobot")) {
                service.addRobot(robot);
            } else if (service.getClass().getSimpleName().equals("SecondaryService") && robotType.equals("FemaleRobot")) {
                service.addRobot(robot);
            } else {
                return "Unsuitable service.";
            }

        return String.format("Successfully added %s to %s." , robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = null;
        int count = 0;

        for (Service currentService : services) {
            if (currentService.getName().equals(serviceName)) {
                service = currentService;
            }
        }
       
        for (Robot robot : service.getRobots()) {
            robot.eating();
            count++;
        }


        return String.format(ConstantMessages.FEEDING_ROBOT, count);
    }

    @Override
    public String sumOfAll(String serviceName) {
       Service service = null;
       double totalSum = 0;
        for (Service service1 : services) {
            if (service1.getName().equals(serviceName)){
                service = service1;
            }
        }

      
        for (Robot robot : service.getRobots()) {
            totalSum += robot.getPrice();
        }
        for (Supplement supplement : service.getSupplements()) {
            totalSum += supplement.getPrice();
        }



        return String.format("The value of service %s is %.2f.",serviceName,totalSum);
    }


    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Service service : services) {
            sb.append(String.format("%s %s", service.getName(), service.getClass().getSimpleName())).append(System.lineSeparator())
                    .append("Robots: ");

            if (service.getRobots() != null && !service.getRobots().isEmpty()) {
                for (Robot robot : service.getRobots()) {
                    sb.append(String.format("%s ",robot.getName()));
                }
            }else {
                sb.append("none");
            }
            int totalHardness = 0;
            int count = 0;
            for (Supplement supplement : service.getSupplements()) {
                totalHardness += supplement.getHardness();
                count++;
            }
            sb.append(System.lineSeparator());
            sb.append(String.format("Supplements: %d Hardness: %d",count,totalHardness));

        }
        return sb.toString().trim();
    }
}
