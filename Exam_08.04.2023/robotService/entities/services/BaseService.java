package robotService.entities.services;

import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseService implements Service {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if (robot.getKilograms() >= capacity) {
            throw new IllegalStateException("Not enough capacity for this robot.");
        }
        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : robots) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        int totalHardness = 0;
        for (Supplement supplement : supplements) {
            totalHardness += supplement.getHardness();
        }

        return totalHardness;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        String serviceType = this instanceof MainService ? "MainService" : "SecondaryService";
        sb.append(getName()).append(" ").append(serviceType).append(":").append(System.lineSeparator());

        if (!robots.isEmpty()) {
            sb.append("Robots:");
            for (Robot robot : robots) {
                sb.append(" ").append(robot.getName());
            }
            sb.append(System.lineSeparator());
        } else {
            sb.append("Robots: none").append(System.lineSeparator());
        }

        int supplementsCount = supplements.size();
        int sumHardness = sumHardness();

        sb.append("Supplements: ").append(supplementsCount).append(" Hardness: ").append(sumHardness);

        return sb.toString().trim();
    }
}