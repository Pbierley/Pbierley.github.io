import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

// fix the button whewn you add a new citizen to change the food label to the updated +/- food per second instead of nothing
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Thread{

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel errorLabel;
    private static JLabel peopleCountLabel;
    private static JButton newCitizen;
    private static JLabel unemployedCountLabel;
    private static JButton newFarmer;
    public static JButton newMiner;
    public static JButton newSoldier;
    private static JButton newLumberjack;
    private static JLabel foodLabel;
    private static JLabel stoneLabel;
    private static JLabel woodLabel;
    private static JLabel farmersLabel;
    private static JLabel minersLabel;
    private static JLabel lumberjackLabel;
    private static JLabel soldierLabel;
    private static JLabel housingLabel;
    private static JLabel landLabel;
    private static JPanel storagePanel;
    private static JButton newHut;
    private static JButton newHouseButton;
    private static JButton increaseFoodStorageButton;
    private static JButton increaseWoodStorageButton;
    private static JButton increaseStoneStorageButton;
    private static boolean storageVisible = false;
    private static JPanel warPanel;
    private static JLabel armySizeLabel;
    private static JLabel enemyArmySizeLabel;
    private static JButton attackButton;
    private static JLabel lootLabel;

    public static void buildPeopleGUI() {
        frame = new JFrame();
        errorLabel = new JLabel("");
        peopleCountLabel = new JLabel("People:" + People.getCount() + " consuming " + People.getFoodComsumption() + " food");
        newCitizen = new JButton("New Citizen for 20 food");
        unemployedCountLabel = new JLabel(Unemployed.getCount() + " Unemployed People:");
        newFarmer = new JButton("+1 Farmer");
        farmersLabel = new JLabel(Farmer.getCount() + " farmers Generating 0 food ");
        newLumberjack = new JButton("+1 Lumberjack");
        lumberjackLabel = new JLabel(Lumberjack.getCount() + " lumberjacks Generating 0 wood");
        newMiner = new JButton("+1 Miner");
        minersLabel = new JLabel(Miner.getCount() + " miners Generating 0 stone");
        newSoldier = new JButton("+1 Soldier");
        soldierLabel = new JLabel(Soldier.getCount() + " soldiers defending the base");
        foodLabel = new JLabel("food:" + food.getFood() + "/" + food.getFoodStorage() + " +" + People.getFoodChange());
        stoneLabel = new JLabel("stone:" + stone.stoneAmount);
        woodLabel = new JLabel("wood:" + wood.woodAmount);
        landLabel = new JLabel("land:" + land.getLand());
        housingLabel = new JLabel("Housing Space: " + House.getHousingSpace());
        storagePanel = new JPanel();
        increaseFoodStorageButton = new JButton("Increase food storage by 100 for 100 stone & wood");
        increaseStoneStorageButton = new JButton("Increase stone storage by 100 for 100 wood & 100 stone");
        increaseWoodStorageButton = new JButton("Increase wood storage by 100 for 100 wood & 100 stone");
        newHut = new JButton("50 stone for +1 housing space");
        newHouseButton = new JButton("100 stone & 100 wood for +5 housing space");
        storagePanel.setBackground(Color.lightGray);
        storagePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        storagePanel.setLayout(new GridLayout(0, 1));
        storagePanel.add(newHut);
        storagePanel.add(newHouseButton);
        storagePanel.add(increaseFoodStorageButton);
        storagePanel.add(increaseWoodStorageButton);
        storagePanel.add(increaseStoneStorageButton);

        panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(peopleCountLabel);
        panel.add(unemployedCountLabel);
        panel.add(newCitizen);
        panel.add(farmersLabel);
        panel.add(newFarmer);
        panel.add(lumberjackLabel);
        panel.add(newLumberjack);
        panel.add(minersLabel);
        panel.add(newMiner);
        panel.add(soldierLabel);
        panel.add(newSoldier);
        panel.add(foodLabel);
        panel.add(woodLabel);
        panel.add(stoneLabel);
        panel.add(landLabel);
        panel.add(housingLabel);

        warPanel = new JPanel();
        armySizeLabel = new JLabel("Army size: " + Soldier.getCount());
        enemyArmySizeLabel = new JLabel("Enemy army size:" + Soldier.getEnemyArmySize());
        attackButton = new JButton("Attack enemy army");
        lootLabel = new JLabel("loot:");
        warPanel.setBackground(Color.lightGray);
        warPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        warPanel.setLayout(new GridLayout(0, 1));
        warPanel.add(armySizeLabel);
        warPanel.add(enemyArmySizeLabel);
        warPanel.add(attackButton);
        warPanel.add(lootLabel);
        lootLabel.setVisible(false);

        errorLabel.setVisible(false);
        frame.add(panel, BorderLayout.WEST);
        frame.add(storagePanel, BorderLayout.CENTER);
        frame.add(warPanel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Resources & Citizens");
        frame.pack();
        frame.setVisible(true);
        newCitizen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newCitizenMethod();
            }
        });

        newFarmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFarmerMethod();
            }
        });
        newLumberjack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newLumberjackMethod();
            }
        });
        newMiner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newMinerMethod();
            }
        });
        newSoldier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newSoldierMethod();
            }
        });
        newHut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newHutMethod();
            }
        });
        newHouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newHouseMethod();
            }
        });
        increaseFoodStorageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {increaseFoodStorageMethod();}
        });
        increaseWoodStorageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {increaseWoodStorageMethod();}
        });
        increaseStoneStorageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {increaseStoneStorageMethod();}
        });
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Button clicked!");
                attackMethod();
            }
        });
    }
    public static void updateResources(){
        if (People.getFoodChange() > 0) {
            foodLabel.setText("food:" + food.getFood() + "/" + food.getFoodStorage() + " + " + People.getFoodChange());
        }
        else if(People.getFoodChange() <= 0) {
            foodLabel.setText("food:" + food.getFood() + "/" + food.getFoodStorage() + " " + People.getFoodChange());
        }
        peopleCountLabel.setText("People:" + People.getCount() + " consuming " + People.getFoodComsumption() + " food");
        unemployedCountLabel.setText(Unemployed.getCount() + " Unemployed People:");
        farmersLabel.setText(Farmer.getCount() + " farmers Generating " + Farmer.getTotalRate() +  " food ");
        woodLabel.setText("wood:" + wood.getWood() + "/" + wood.getWoodStorage()  + " + " + Lumberjack.getTotalRate());
        stoneLabel.setText("stone:" + stone.getStone() + "/" + stone.getStoneStorage() + " + " + Miner.getTotalRate());
        housingLabel.setText("Housing Space: " + House.getHousingSpace());
        landLabel.setText("Land: " + land.getLand());
        soldierLabel.setText(Soldier.getCount() + " soldiers defending the base");
    }
    public static void newCitizenMethod(){
        if (food.foodAmount >= 20 && House.getHousingSpace() >= 1){
            food.setFood(-20);
            House.addHousingSpace(-1);
            Unemployed.createNew();
            peopleCountLabel.setText("People:" + People.getCount() + " consuming " + People.getFoodComsumption() + " food");
            unemployedCountLabel.setText(Unemployed.getCount() + " Unemployed People:");
            foodLabel.setText("food:" + food.foodAmount);

        }
    }
    public static void newFarmerMethod(){
        if (Unemployed.getCount() > 0){
            Unemployed.employCitizen();
            unemployedCountLabel.setText(Unemployed.getCount() + " Unemployed People:");
            Farmer.createNew();
            farmersLabel.setText(Farmer.getCount() + " farmers Generating " + Farmer.getTotalRate() + " food");
            updateResources();
        }
    }
    public static void newLumberjackMethod(){
        if (Unemployed.getCount() > 0){
            Unemployed.employCitizen();
            unemployedCountLabel.setText(Unemployed.getCount() + " Unemployed People:");
            Lumberjack.createNew();
            lumberjackLabel.setText(Lumberjack.getCount() + " lumberjacks Generating " + Lumberjack.getTotalRate() + " wood");
        }
    }
    public static void newMinerMethod(){
        if (Unemployed.getCount() > 0){
            Unemployed.employCitizen();
            unemployedCountLabel.setText(Unemployed.getCount() + " Unemployed People:" );
            Miner.createNew();
            minersLabel.setText(Miner.getCount() + " miners Generating " + Miner.getTotalRate() + " stone");
        }
    }
    public static void newSoldierMethod(){
        if (Unemployed.getCount() > 0){
            Unemployed.employCitizen();
            unemployedCountLabel.setText(Unemployed.getCount() + " Unemployed People:");
            Soldier.createNew();
            soldierLabel.setText(Soldier.getCount() + " soldiers  defending the base");
            updateWarGUI();
            updateResources();
        }
    }


    public static void main(String[] args) {
        buildPeopleGUI();
        //newStorageGUI.buildStorageGUI();
        //warGUI.buildWarGUI();
        //foodLabel = new JLabel();
        Multithread thread1 = new Multithread();
        thread1.start();
    }
    public static void newHutMethod() {
        if (stone.getStone() >= 50) {
            stone.setStone(-50);
            House.addHousingSpace(1);
        }
    }

    public static void newHouseMethod() {
        if (stone.getStone() >= 100 && wood.getWood() >= 100 && land.getLand() >= 1) {
            stone.setStone(-100);
            wood.setWood(-100);
            House.addHousingSpace(5);
            land.setLand(-1);
            Main.updateResources();
        }
    }
    // use inheritance in order to eliminate unecisary code in the food wood and stone category classes.
    public static void increaseFoodStorageMethod() {
        if (stone.getStone() >= 100 && wood.getWood() >= 100 && land.getLand() >= 1) {
            stone.setStone(-100);
            wood.setWood(-100);
            food.setFoodStorage(100);
        }
        else {
            //error message here
        }
    }

    public static void increaseWoodStorageMethod() {
        if (stone.getStone() >= 100 && wood.getWood() >= 100 && land.getLand() >= 1){
            stone.setStone(-100);
            wood.setWood(-100);
            wood.setWoodStorage(100);
        }

    }

    public static void increaseStoneStorageMethod() {
        if (stone.getStone() >= 100 && wood.getWood() >= 100 && land.getLand() >= 1){
            stone.setStone(-100);
            wood.setWood(-100);
            stone.setStoneStorage(100);
        }

    }

    public static void setStorageVisible(boolean input) {
        storageVisible = input;
    }

    public static boolean getStorageVisible(){
        return storageVisible;
    }
    public static void attackMethod(){
        if (Soldier.getCount() > Soldier.getEnemyArmySize()){
            Soldier.changeArmySize(-Soldier.getEnemyArmySize());
            Soldier.incEnemyArmySize();
            //loot winnings & update Label
            lootLabel.setText("Loot winnings: land: " + Soldier.getWinningsMultiplier() / 10 + " food: " + Soldier.getWinningsMultiplier() + " wood: " + Soldier.getWinningsMultiplier() + " stone: " + Soldier.getWinningsMultiplier());
            lootMethod();
        }
        else {
            Soldier.changeArmySize(-Soldier.getCount());
            lootLabel.setText("War lost...");
        }
        updateWarGUI();
    }
    public static void lootMethod(){
        food.setFood(Soldier.getWinningsMultiplier());
        stone.setStone(Soldier.getWinningsMultiplier());
        wood.setWood(Soldier.getWinningsMultiplier());
        land.setLand(Soldier.getWinningsMultiplier() / 10);
    }
    public static void updateWarGUI(){
        armySizeLabel.setText("Army size: " + Soldier.getCount());
        enemyArmySizeLabel.setText("Enemy army size:" + Soldier.getEnemyArmySize());
        lootLabel.setVisible(true);
    }
}


//have people that collect resources
//have a couple categories - farmers, miners, loggers, masons,

//add error pop ups for users, and make it easier to read
