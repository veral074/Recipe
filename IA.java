import java.util.*;
class IA{
	static String[] recipeNames = {"Spaghetti", "Pancake", "Ice cream", "Chocolate cake", "French Fries"};
    static String[] recipe = {
            "1. Cook spaghetti for 8 mins and then drain it.\n2. On medium heat melt the butter and sautee the onion.\n3. Add the hamburger meat and cook until meat is well done.\n4. Add the tomato sauce, salt, pepper and garlic powder.\n5. Mix the sauce and noodles.",
            "1. Mix dry ingredients(flour, sugar, baking powder, and salt)\n2. Mix wet ingredients(milk, butter, and egg)\n3. Combine wet and dry ingredients\n4. Heat and oil skillet\n5. Spoon 2 to 3 tablespoons of batter onto skillet\n6. Cook both side(each 1-2 min)",
            "1. Cook milk, cream, and sugar until the sugar has dissolved.\n2. Transfer the mixture to a measuring cup, then add the vanilla extract. Chill overnight.\n3. Pour the mix into an ice cream maker and churn according to the manufacturer's directions.", 
            "1. Preheat the oven to 350°F (177°C) and grease two 9-inch cake pans.\n2. In a large bowl, whisk together flour, cocoa powder, sugar, baking soda, baking powder, and espresso powder (if using).\n3. In another bowl, mix together oil, eggs, and vanilla extract. Add buttermilk and mix until combined.\n4. Pour the wet ingredients into the dry ingredients, add hot coffee, and mix until the batter is combined.\n5. Divide the batter evenly between the prepared cake pans and bake for 23-26 minutes or until a toothpick inserted in the center comes out clean.\n6. Allow the cakes to cool completely in the pans on a wire rack.",
            "1. Slice the potatoes 1/2 inch thick\n2. Soak them cold in water for at least an hour or overnight.\n3. Rinse them twice with cold water and pat the completely dry.\n4. Heat oil to 300° F. Fry them in about 6 batches for 5-6 minutes.",
        };
    static String[][] recipeIngredients = {
            {"spaghetti","tomatoes","garlic","beef","onion"},
            {"flour","eggs","milk","sugar","baking powder","butter"},
            {"milk","heavy whipping cream","sugar","vanilla extract","vanilla extract", "buttermilk","hot coffee"},
            {"flour","cocoa powder","sugar","baking soda", "baking powder", "oil", "eggs"},
            {"potatoes","salt","oil"},
        };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Do you want to\n 1)search for a recipe \n 2)decide what to make?");
		String userDecision = s.nextLine();

		if(userDecision.equals("1")||userDecision.equals("search for a recipe")){
			searchForRecipe();
		}
		else if(userDecision.equals("2")||userDecision.equals("decide what to make")) {
			Deciding();
		}else{
			System.out.println("Invalid input. Please type in number 1 or 2.");
		}

	}

	public static void searchForRecipe() {
		Scanner s = new Scanner(System.in);
		System.out.println("What recipe are you looking for?");
		String foodName = s.nextLine();

		boolean notfound = true;

			for(int i = 0; i<5;i++){
				if (recipeNames[i].equals(foodName)) {
					System.out.println("Ingredients for " + recipeNames[i] + ": \n" + Arrays.toString(recipeIngredients[i]));
					System.out.println("Recipe:\n" + recipe[i]);
					notfound = false;

				}
			}
		if(notfound==true){
			System.out.println("Recipe not found. (Make sure input in lowercase letters except for the first letter.");
			}
		}
	
	public static void Deciding() {
		Scanner s = new Scanner(System.in);
		System.out.println("What ingrediants do you have? (please type in lowercase letters)");
		String userIngrediantsInput = s.nextLine();
		String[] userIngrediants = userIngrediantsInput.split(", ");
		boolean canMake = false;

		for(int i=0; i<5; i++){
		int count = 0;
			for(int j=0; j<recipeIngredients[i].length; j++){
				if(Arrays.asList(userIngrediants).contains(recipeIngredients[i][j])){
					count++;
			}
			}
			if (count >= 3) {
				System.out.println("You can make " + recipeNames[i] + ":\n" + "Ingredients needed:\n" + Arrays.toString(recipeIngredients[i]) + "\nRecipe:\n" + recipe[i]);
				canMake = true;
			}
		}
		if(canMake == false){
			System.out.println("You don't have enough ingredients.");
			}


	}
}