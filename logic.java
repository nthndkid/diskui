package logic_activity;

public class Einstein_puzzle {
    public static class HouseOwner {
        String nationality;
        String pet;
        String drink;
        String device;

        HouseOwner(String nationality) {
            this.nationality = nationality;
        }
    }

    public static class House {
        String color;
        HouseOwner owner;

        House(String color, HouseOwner owner) {
            this.color = color;
            this.owner = owner;
        }
    }

    public static void main(String[] args) {
        // Create owners
        HouseOwner american = new HouseOwner("American");
        HouseOwner indian = new HouseOwner("Indian");
        HouseOwner filipino = new HouseOwner("Filipino");
        HouseOwner german = new HouseOwner("German");
        HouseOwner korean = new HouseOwner("Korean");

        // Initialize houses with owners and their attributes
        House[] houses = new House[5];
        
        houses[0] = new House("Yellow", american);
        houses[0].owner.pet = "Cat";
        houses[0].owner.drink = "Water";
        houses[0].owner.device = "Oppo";
        
        houses[1] = new House("Blue", indian); //3
        houses[1].owner.drink = "Tea"; //3
        houses[1].owner.pet = "Horse";
        houses[1].owner.device = "Desktop";
        
        houses[2] = new House("Red", filipino); //1
        houses[2].owner.pet = "Bird"; 
        houses[2].owner.drink = "Milk";
        houses[2].owner.device = "Laptop";
        
        houses[3] = new House("Green", german); //4
        houses[3].owner.pet = "Fish";
        houses[3].owner.drink = "Coffee";
        houses[3].owner.device = "Tablet";
        
        houses[4] = new House("White", korean); //2
        houses[4].owner.pet = "Dogs"; //2
        houses[4].owner.drink = "Root Beer";
        houses[4].owner.device = "iPhone";

        // Print the results
        for (House house : houses) {
            System.out.println(house.owner.nationality + " owns the " + house.color + " house, " + 
                               "has a " + house.owner.pet + ", " + 
                               "drinks " + house.owner.drink + ", " + 
                               "and uses a " + house.owner.device + ".");
        }

        // Determine who owns the fish
        String fishOwner = null;
        for (House house : houses) {
            if ("Fish".equals(house.owner.pet)) {
                fishOwner = house.owner.nationality;
                break;
            }
        }

        System.out.println("The owner who owns the fish is: " + fishOwner);
    }
}
